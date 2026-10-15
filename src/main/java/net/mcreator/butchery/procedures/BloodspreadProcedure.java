package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BloodspreadProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (ButcheryconfigConfiguration.BLOOD_SPREAD.get().booleanValue() && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BLOOD_PUDDLE.get() && BloodspreadProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "sourceBlood")) {
            ButcheryMod.queueServerWork(4, () -> {
                if (world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BLOOD_PUDDLE.get() && BloodspreadProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "sourceBlood")) {
                    world.setBlock(BlockPos.containing((double)(x + 1.0), (double)y, (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                }
            });
            ButcheryMod.queueServerWork(8, () -> {
                if (world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BLOOD_PUDDLE.get() && BloodspreadProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "sourceBlood")) {
                    world.setBlock(BlockPos.containing((double)(x - 1.0), (double)y, (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                }
            });
            ButcheryMod.queueServerWork(12, () -> {
                if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z - 1.0))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BLOOD_PUDDLE.get() && BloodspreadProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "sourceBlood")) {
                    world.setBlock(BlockPos.containing((double)x, (double)y, (double)(z - 1.0)), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                }
            });
            ButcheryMod.queueServerWork(16, () -> {
                if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z + 1.0))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BLOOD_PUDDLE.get() && BloodspreadProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "sourceBlood")) {
                    world.setBlock(BlockPos.containing((double)x, (double)y, (double)(z + 1.0)), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                }
            });
            ButcheryMod.queueServerWork(20, () -> {
                if (world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)(z + 1.0))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BLOOD_PUDDLE.get() && BloodspreadProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "sourceBlood")) {
                    world.setBlock(BlockPos.containing((double)(x + 1.0), (double)y, (double)(z + 1.0)), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                }
            });
            ButcheryMod.queueServerWork(24, () -> {
                if (world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)(z + 1.0))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BLOOD_PUDDLE.get() && BloodspreadProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "sourceBlood")) {
                    world.setBlock(BlockPos.containing((double)(x - 1.0), (double)y, (double)(z + 1.0)), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                }
            });
            ButcheryMod.queueServerWork(28, () -> {
                if (world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)(z - 1.0))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BLOOD_PUDDLE.get() && BloodspreadProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "sourceBlood")) {
                    world.setBlock(BlockPos.containing((double)(x + 1.0), (double)y, (double)(z - 1.0)), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                }
            });
            ButcheryMod.queueServerWork(32, () -> {
                if (world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)(z - 1.0))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.BLOOD_PUDDLE.get() && BloodspreadProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "sourceBlood")) {
                    world.setBlock(BlockPos.containing((double)(x - 1.0), (double)y, (double)(z - 1.0)), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                }
            });
        }
        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)z)).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)z)).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z - 1.0))).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z + 1.0))).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.WATER) {
            world.destroyBlock(BlockPos.containing((double)x, (double)y, (double)z), false);
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
    }
}

