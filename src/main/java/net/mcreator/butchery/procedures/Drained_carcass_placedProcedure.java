package net.mcreator.butchery.procedures;

import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class Drained_carcass_placedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!Drained_carcass_placedProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "isDrained") && !world.isClientSide()) {
            BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
                ButcheryPersistentData.of(_blockEntity).putBoolean("isDrained", true);
            }
            if (world instanceof Level) {
                Level _level = (Level)world;
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
    }
}

