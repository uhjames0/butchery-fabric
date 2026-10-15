package net.mcreator.butchery.procedures;

import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class RegisteCloseConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return !RegisteCloseConditionProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "registerOpen");
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
    }
}

