package net.mcreator.butchery.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.illager.Pillager;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Pillager_disguise_tickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean found = false;
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            if (!world.getEntitiesOfClass(Pillager.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(8.0), e -> true).isEmpty() && entity instanceof Mob) {
                Mob _entity = (Mob)entity;
                _entity.setTarget(null);
            }
        }
    }
}

