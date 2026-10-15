package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.mixin.MobGoalSelectorAccessor;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class BrainattractProcedure {
    public static void onEntitySpawned(ShimEvent.EntityJoinShim event) {
        BrainattractProcedure.execute(event, event.getEntity());
    }

    public static void execute(Entity entity) {
        BrainattractProcedure.execute(null, entity);
    }

    private static void execute(@Nullable NeoEvent event, Entity entity) {
        if (entity != null && entity instanceof Zombie && entity instanceof PathfinderMob && entity instanceof Monster) {
            ((MobGoalSelectorAccessor)((PathfinderMob)entity)).butchery$getGoalSelector().addGoal(1, (Goal)new RemoveBlockGoal((Block)ButcheryModBlocks.BRAIN.get(), (PathfinderMob)entity, 1.0, 4));
        }
    }
}

