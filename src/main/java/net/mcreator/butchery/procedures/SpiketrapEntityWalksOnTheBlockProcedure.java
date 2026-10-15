package net.mcreator.butchery.procedures;

import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SpiketrapEntityWalksOnTheBlockProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            entity.hurt(new DamageSource((Holder)world.registryAccess().getOrThrow(DamageTypes.GENERIC)), 1.0f);
        }
    }
}

