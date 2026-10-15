package net.mcreator.butchery.procedures;

import net.minecraft.world.entity.Entity;

public class StraynecklaceeffectProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            boolean found = false;
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            if (entity.getTicksFrozen() > 1) {
                entity.setTicksFrozen(0);
            }
        }
    }
}

