package net.mcreator.butchery.shim;

import java.util.function.BiConsumer;
import java.util.function.Supplier;
import net.mcreator.butchery.shim.FluidType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class BaseFlowingFluid
extends FlowingFluid {
    protected final Properties properties;

    protected BaseFlowingFluid(Properties properties) {
        this.properties = properties;
    }

    public Fluid getFlowing() {
        return this.properties.flowing.get();
    }

    public Fluid getSource() {
        return this.properties.source.get();
    }

    /**
     * Vanilla WaterFluid overrides isSame to cover BOTH the source and the
     * flowing variant (they are distinct registry objects). Without this
     * override the default `other == this` never matches source vs flowing,
     * which breaks getNewLiquid/affectsFlow/isWaterHole level computation and
     * makes flowing blood collapse to air immediately. NeoForge's
     * BaseFlowingFluid provides the same behaviour for modded fluids.
     */
    @Override
    public boolean isSame(Fluid other) {
        return other == this.getSource() || other == this.getFlowing();
    }

    protected boolean canConvertToSource(ServerLevel level) {
        return false;
    }

    protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? level.getBlockEntity(pos) : null;
        Block.dropResources((BlockState)state, (LevelAccessor)level, (BlockPos)pos, (BlockEntity)blockEntity);
    }

    public int getSlopeFindDistance(LevelReader level) {
        return this.properties.slopeFindDistance;
    }

    public int getDropOff(LevelReader level) {
        return 1;
    }

    public Item getBucket() {
        return this.properties.bucket != null ? this.properties.bucket.get() : Items.BUCKET;
    }

    public boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid fluidIn, Direction direction) {
        // Water-like semantics (matches vanilla WaterFluid): a different fluid
        // flowing downward can replace this fluid; same-fluid replacement and
        // horizontal fluid-vs-fluid spreading are handled by the fluid tick
        // path (getNewLiquid), exactly like vanilla water merging.
        return direction == Direction.DOWN && !fluidIn.isSame(this);
    }

    public int getTickDelay(LevelReader level) {
        return this.properties.tickRate;
    }

    public float getExplosionResistance() {
        return this.properties.explosionResistance;
    }

    protected BlockState createLegacyBlock(FluidState state) {
        return (BlockState)this.properties.block.get().defaultBlockState().setValue((Property)LiquidBlock.LEVEL, (Comparable)Integer.valueOf(BaseFlowingFluid.getLegacyLevel((FluidState)state)));
    }

    public boolean isSource(FluidState state) {
        return true;
    }

    public int getAmount(FluidState state) {
        return 8;
    }

    public static class Properties {
        public final Supplier<? extends FluidType> fluidType;
        public final Supplier<? extends Fluid> source;
        public final Supplier<? extends Fluid> flowing;
        public Supplier<? extends Item> bucket;
        public Supplier<? extends LiquidBlock> block;
        public int slopeFindDistance = 4;
        public float explosionResistance = 1.0f;
        public int tickRate = 5;
        public BiConsumer<Level, BlockPos> onPlaced;

        public Properties(Supplier<? extends FluidType> fluidType, Supplier<? extends Fluid> source, Supplier<? extends Fluid> flowing) {
            this.fluidType = fluidType;
            this.source = source;
            this.flowing = flowing;
        }

        public Properties bucket(Supplier<? extends Item> b) {
            this.bucket = b;
            return this;
        }

        public Properties block(Supplier<? extends LiquidBlock> b) {
            this.block = b;
            return this;
        }

        public Properties slopeFindDistance(int d) {
            this.slopeFindDistance = d;
            return this;
        }

        public Properties explosionResistance(float r) {
            this.explosionResistance = r;
            return this;
        }

        public Properties tickRate(int t) {
            this.tickRate = t;
            return this;
        }
    }

    public static class Flowing
    extends BaseFlowingFluid {
        public Flowing(Properties properties) {
            super(properties);
        }

        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(new Property[]{LEVEL});
        }

        @Override
        public int getAmount(FluidState state) {
            return (Integer)state.getValue((Property)LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }
}

