package net.mcreator.butchery.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class HealcommandProcedure {
    public static void execute(Entity entity) {
        if (entity != null && entity instanceof LivingEntity) {
            float f;
            LivingEntity _entity = (LivingEntity)entity;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity)entity;
                f = _livEnt.getMaxHealth();
            } else {
                f = -1.0f;
            }
            _entity.setHealth(f);
        }
    }
}

