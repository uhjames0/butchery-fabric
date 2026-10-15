package net.mcreator.butchery.fluid;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModFluidTypes;
import net.mcreator.butchery.init.ButcheryModFluids;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.BaseFlowingFluid;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class InfectedBloodFluid
extends BaseFlowingFluid {
    public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> ButcheryModFluidTypes.INFECTED_BLOOD_TYPE.get(), () -> (Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), () -> (Fluid)ButcheryModFluids.FLOWING_INFECTED_BLOOD.get()).explosionResistance(10.0f).bucket(() -> (Item)ButcheryModItems.INFECTED_BLOOD_BUCKET.get()).block(() -> (LiquidBlock)ButcheryModBlocks.INFECTED_BLOOD.get());

    private InfectedBloodFluid() {
        super(PROPERTIES);
    }

    public ParticleOptions getDripParticle() {
        return ParticleTypes.EXPLOSION;
    }

    public static class Source
    extends InfectedBloodFluid {
        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing
    extends InfectedBloodFluid {
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

