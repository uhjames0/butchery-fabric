package net.mcreator.butchery.procedures;

import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class Snifferanimationcondition2Procedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return Snifferanimationcondition2Procedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "butcherStage") == 1.0;
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
    }
}

