package net.mcreator.butchery.entity;

import net.mcreator.butchery.procedures.ShellboatridingProcedure;
import net.mcreator.butchery.shim.SpinPlacementsShim;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class TurtleshellboatEntity
extends PathfinderMob {
    public TurtleshellboatEntity(EntityType<TurtleshellboatEntity> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new FloatGoal((Mob)this));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float f) {
        return super.getPassengerAttachmentPoint(entity, dimensions, f).add(0.0, (double)-0.6f, 0.0);
    }

    public SoundEvent getHurtSound(DamageSource ds) {
        return (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.generic.hurt"));
    }

    public SoundEvent getDeathSound() {
        return (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.generic.death"));
    }

    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult.Success retval = InteractionResult.SUCCESS;
        super.mobInteract(sourceentity, hand);
        sourceentity.startRiding((Entity)this);
        return retval;
    }

    public void baseTick() {
        super.baseTick();
        ShellboatridingProcedure.execute((LevelAccessor)this.level(), this.getX(), this.getY(), this.getZ(), (Entity)this);
    }

    public void travel(Vec3 dir) {
        Entity entity;
        Entity entity2 = entity = this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
        if (this.isVehicle()) {
            double d0;
            double d1;
            float f1;
            this.setYRot(entity.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(entity.getXRot() * 0.5f);
            this.setRot(this.getYRot(), this.getXRot());
            this.yBodyRot = entity.getYRot();
            this.yHeadRot = entity.getYRot();
            if (entity instanceof ServerPlayer) {
                ServerPlayer passenger = (ServerPlayer)entity;
                this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float forward = passenger.getLastClientInput().forward() == passenger.getLastClientInput().backward() ? 0.0f : (float)(passenger.getLastClientInput().forward() ? 1 : -1);
                float strafe = 0.0f;
                super.travel(new Vec3((double)strafe, 0.0, (double)forward));
            }
            if ((f1 = (float)Math.sqrt((d1 = this.getX() - this.xo) * d1 + (d0 = this.getZ() - this.zo) * d0) * 4.0f) > 1.0f) {
                f1 = 1.0f;
            }
            this.walkAnimation.setSpeed(this.walkAnimation.speed() + (f1 - this.walkAnimation.speed()) * 0.4f);
            this.walkAnimation.position(this.walkAnimation.position() + this.walkAnimation.speed());
            this.calculateEntityAnimation(true);
        } else {
            super.travel(dir);
        }
    }

    public static void init(SpinPlacementsShim event) {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.6);
        builder = builder.add(Attributes.MAX_HEALTH, 20.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
        return builder.add(Attributes.STEP_HEIGHT, 0.6);
    }
}

