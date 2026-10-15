package net.mcreator.butchery.shim.fluidcap;

import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class BlockFluidHandler
implements IFluidHandler {
    private final Level level;
    private final BlockPos pos;

    public BlockFluidHandler(Level level, BlockPos pos) {
        this.level = level;
        this.pos = pos;
    }

    @Override
    public int getTanks() {
        return 1;
    }

    @Override
    public FluidStack getFluidInTank(int tank) {
        BlockState state = this.level.getBlockState(this.pos);
        Block block = state.getBlock();
        if (block instanceof LiquidBlock) {
            LiquidBlock lb = (LiquidBlock)block;
            FluidState fs = state.getFluidState();
            Fluid fluid = fs.getType();
            if (fluid instanceof FlowingFluid) {
                FlowingFluid ff = (FlowingFluid)fluid;
                return new FluidStack(ff.getSource(), fs.isSource() ? 1000 : fs.getAmount() * 125);
            }
        }
        return FluidStack.EMPTY;
    }

    @Override
    public int getTankCapacity(int tank) {
        return 1000;
    }

    @Override
    public boolean isFluidValid(int tank, FluidStack stack) {
        return true;
    }

    @Override
    public int fill(FluidStack resource, IFluidHandler.FluidAction action) {
        return 0;
    }

    @Override
    public FluidStack drain(FluidStack resource, IFluidHandler.FluidAction action) {
        return this.drain(resource.getAmount(), action);
    }

    @Override
    public FluidStack drain(int maxDrain, IFluidHandler.FluidAction action) {
        FluidStack available = this.getFluidInTank(0);
        if (available.isEmpty() || !this.level.getFluidState(this.pos).isSource()) {
            return FluidStack.EMPTY;
        }
        if (action.execute()) {
            this.level.setBlock(this.pos, Blocks.AIR.defaultBlockState(), 11);
            this.level.playSound(null, this.pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
        return available;
    }
}

