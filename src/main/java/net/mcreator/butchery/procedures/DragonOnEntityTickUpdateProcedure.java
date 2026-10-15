package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DragonOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null && world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() != Blocks.AIR) {
            if (!entity.level().isClientSide()) {
                entity.discard();
            }
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)ButcheryModBlocks.ENDER_DRAGON_CARCASS.get()).defaultBlockState(), 3);
        }
    }
}

