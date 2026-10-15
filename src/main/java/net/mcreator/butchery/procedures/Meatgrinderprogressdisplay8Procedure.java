package net.mcreator.butchery.procedures;

import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class Meatgrinderprogressdisplay8Procedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        double craftingTime = 0.0;
        craftingTime = Meatgrinderprogressdisplay8Procedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "craftingTime") / 10.0;
        return Meatgrinderprogressdisplay8Procedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "craftingProgress") > craftingTime * 8.0 && Meatgrinderprogressdisplay8Procedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "craftingProgress") <= craftingTime * 9.0;
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
    }
}

