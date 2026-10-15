package net.mcreator.butchery.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class InstantplacesandProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 1.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 2.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 3.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 4.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 5.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 6.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 7.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 8.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 9.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 10.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 11.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 12.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 13.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 14.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 16.0), (double)z)).getBlock() != Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)x, (double)(y - 15.0), (double)z), Blocks.SAND.defaultBlockState(), 3);
        }
    }
}

