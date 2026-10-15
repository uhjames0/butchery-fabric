package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class TaxidermytableBlockDestroyedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)z)).getBlock() == ButcheryModBlocks.TAXIDERMY_TABLE.get()) {
            world.setBlock(BlockPos.containing((double)(x + 1.0), (double)y, (double)z), Blocks.AIR.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)z)).getBlock() == ButcheryModBlocks.TAXIDERMY_TABLE.get()) {
            world.setBlock(BlockPos.containing((double)(x - 1.0), (double)y, (double)z), Blocks.AIR.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z + 1.0))).getBlock() == ButcheryModBlocks.TAXIDERMY_TABLE.get()) {
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)(z + 1.0)), Blocks.AIR.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z - 1.0))).getBlock() == ButcheryModBlocks.TAXIDERMY_TABLE.get()) {
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)(z - 1.0)), Blocks.AIR.defaultBlockState(), 3);
        }
    }
}

