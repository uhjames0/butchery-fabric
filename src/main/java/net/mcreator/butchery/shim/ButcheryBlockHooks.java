package net.mcreator.butchery.shim;

import net.mcreator.butchery.shim.ButcheryEnv;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class ButcheryBlockHooks {
    public static void fire(Level world, BlockPos pos, Player player) {
        try {
            BlockState state = world.getBlockState(pos);
            Block block = state.getBlock();
            if (block instanceof DestroyHook) {
                DestroyHook hook = (DestroyHook)block;
                hook.butchery$onDestroyedByPlayer(state, world, pos, player, true, world.getFluidState(pos));
            }
        }
        catch (Exception e) {
            ButcheryEnv.LOGGER.error("[Butchery] onDestroyedByPlayer hook failed at {}", (Object)pos, (Object)e);
        }
    }

    public static interface DestroyHook {
        public boolean butchery$onDestroyedByPlayer(BlockState var1, Level var2, BlockPos var3, Player var4, boolean var5, FluidState var6);
    }
}

