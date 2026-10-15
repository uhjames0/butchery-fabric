package net.mcreator.butchery.mixin;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Mob.class})
public interface MobGoalSelectorAccessor {
    @Accessor(value="goalSelector")
    public GoalSelector butchery$getGoalSelector();

    @Accessor(value="targetSelector")
    public GoalSelector butchery$getTargetSelector();
}

