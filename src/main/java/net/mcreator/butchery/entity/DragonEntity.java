package net.mcreator.butchery.entity;

import net.mcreator.butchery.procedures.DragonOnEntityTickUpdateProcedure;
import net.mcreator.butchery.shim.SpinPlacementsShim;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class DragonEntity
extends Monster {
    public DragonEntity(EntityType<DragonEntity> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
    }

    protected void registerGoals() {
        super.registerGoals();
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
        return damagesource.is(DamageTypes.FALL) ? false : super.hurtServer(level, damagesource, amount);
    }

    public void baseTick() {
        super.baseTick();
        DragonOnEntityTickUpdateProcedure.execute((LevelAccessor)this.level(), this.getX(), this.getY(), this.getZ(), (Entity)this);
    }

    public static void init(SpinPlacementsShim event) {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 10.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
        return builder.add(Attributes.STEP_HEIGHT, 0.6);
    }
}

