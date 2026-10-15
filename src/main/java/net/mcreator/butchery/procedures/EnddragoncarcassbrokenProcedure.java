package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class EnddragoncarcassbrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        ItemEntity entityToSpawn;
        ServerLevel _level;
        for (int index0 = 0; index0 < (int)Mth.nextDouble((RandomSource)RandomSource.create(), (double)1.0, (double)3.0); ++index0) {
            if (!(world instanceof ServerLevel)) continue;
            _level = (ServerLevel)world;
            entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.RAW_DRAGON_MEAT.get()));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity((Entity)entityToSpawn);
        }
        for (int index1 = 0; index1 < (int)Mth.nextDouble((RandomSource)RandomSource.create(), (double)1.0, (double)3.0); ++index1) {
            if (!(world instanceof ServerLevel)) continue;
            _level = (ServerLevel)world;
            entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.DRAGON_SCALE.get()));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity((Entity)entityToSpawn);
        }
        for (int index2 = 0; index2 < (int)Mth.nextDouble((RandomSource)RandomSource.create(), (double)1.0, (double)3.0); ++index2) {
            if (!(world instanceof ServerLevel)) continue;
            _level = (ServerLevel)world;
            entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.DRAGON_BONE.get()));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity((Entity)entityToSpawn);
        }
    }
}

