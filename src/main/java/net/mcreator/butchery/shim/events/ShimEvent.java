package net.mcreator.butchery.shim.events;

import net.mcreator.butchery.shim.ButcheryEnv;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ShimEvent {

    public static class ItemPickupShim
    extends NeoEvent {
        public final Player entity;
        public final ItemEntity itemEntity;

        public ItemPickupShim(Player entity, ItemEntity itemEntity) {
            this.entity = entity;
            this.itemEntity = itemEntity;
        }

        public Player getPlayer() {
            return this.entity;
        }

        public Player getEntity() {
            return this.entity;
        }

        public ItemEntity getItemEntity() {
            return this.itemEntity;
        }

        public Level getLevel() {
            return this.entity.level();
        }
    }

    public static class MobEffectShim
    extends NeoEvent {
        public final Entity entity;
        public final MobEffectInstance effectInstance;

        public MobEffectShim(Entity entity, MobEffectInstance effectInstance) {
            this.entity = entity;
            this.effectInstance = effectInstance;
        }

        public Entity getEntity() {
            return this.entity;
        }

        public MobEffectInstance getEffectInstance() {
            return this.effectInstance;
        }
    }

    public static class VillagerTradesShim
    extends NeoEvent {
        public final VillagerProfession profession;

        public VillagerTradesShim(VillagerProfession profession) {
            this.profession = profession;
        }

        public Object getTrades() {
            return null;
        }
    }

    public static class EntityPlaceShim
    extends NeoEvent {
        public final Entity entity;
        public final Level level;
        public final BlockPos pos;

        public EntityPlaceShim(Entity entity, Level level, BlockPos pos, BlockState state) {
            this.entity = entity;
            this.level = level;
            this.pos = pos;
        }

        public Entity getEntity() {
            return this.entity;
        }

        public Level getLevel() {
            return this.level;
        }

        public BlockPos getPos() {
            return this.pos;
        }

        @Override
        public void setCanceled(boolean c) {
        }
    }

    public static class AdvancementEarnShim
    extends NeoEvent {
        public final Player player;
        public final AdvancementHolder advancement;

        public AdvancementEarnShim(Player player, AdvancementHolder advancement) {
            this.player = player;
            this.advancement = advancement;
        }

        public Player getEntity() {
            return this.player;
        }

        public AdvancementHolder getAdvancement() {
            return this.advancement;
        }
    }

    public static class PlayerChangedDimensionShim
    extends NeoEvent {
        public final Player player;

        public PlayerChangedDimensionShim(Player player) {
            this.player = player;
        }

        public Player getEntity() {
            return this.player;
        }
    }

    public static class PlayerCloneShim
    extends NeoEvent {
        public final Player original;
        public final Player clone;
        public final boolean wasDeath;

        public PlayerCloneShim(Player original, Player clone, boolean wasDeath) {
            this.original = original;
            this.clone = clone;
            this.wasDeath = wasDeath;
        }

        public Player getOriginal() {
            return this.original;
        }

        public Player getEntity() {
            return this.clone;
        }

        public boolean isWasDeath() {
            return this.wasDeath;
        }
    }

    public static class PlayerRespawnShim
    extends NeoEvent {
        public final Player player;

        public PlayerRespawnShim(Player player) {
            this.player = player;
        }

        public Player getEntity() {
            return this.player;
        }
    }

    public static class PlayerLoggedInShim
    extends NeoEvent {
        public final Player player;

        public PlayerLoggedInShim(Player player) {
            this.player = player;
        }

        public Player getEntity() {
            return this.player;
        }

        public Player getPlayer() {
            return this.player;
        }
    }

    public static class ItemCraftedShim
    extends NeoEvent {
        public final Player player;
        public final ItemStack crafting;
        public final CraftingContainer container;

        public ItemCraftedShim(Player player, ItemStack crafted, CraftingContainer container) {
            this.player = player;
            this.crafting = crafted;
            this.container = container;
        }

        public Player getEntity() {
            return this.player;
        }

        public Player getPlayer() {
            return this.player;
        }

        public ItemStack getCrafting() {
            return this.crafting;
        }

        public CraftingContainer getInventory() {
            return this.container;
        }
    }

    public static class LivingDamageShim
    extends NeoEvent {
        public final LivingEntity entity;
        public final DamageSource source;
        public float newDamage;

        public LivingDamageShim(LivingEntity entity, DamageSource source, float amount) {
            this.entity = entity;
            this.source = source;
            this.newDamage = amount;
        }

        public LivingEntity getEntity() {
            return this.entity;
        }

        public DamageSource getSource() {
            return this.source;
        }

        public float getNewDamage() {
            return this.newDamage;
        }

        public void setNewDamage(float d) {
            this.newDamage = d;
        }

        public float getOriginalDamage() {
            return this.newDamage;
        }

        @Override
        public void setCanceled(boolean c) {
            this.newDamage = 0.0f;
        }
    }

    public static class ClientTickShim
    extends NeoEvent {
    }

    public static class ServerTickShim
    extends NeoEvent {
        @Override
        public MinecraftServer getServer() {
            return ButcheryEnv.getCurrentServer();
        }
    }

    public static class PlayerTickShim
    extends NeoEvent {
        public final Player entity;

        public PlayerTickShim(Player entity) {
            this.entity = entity;
        }

        public Player getEntity() {
            return this.entity;
        }

        public Level getLevel() {
            return this.entity.level();
        }
    }

    public static class EntityTickShim
    extends NeoEvent {
        public final Entity entity;

        public EntityTickShim(Entity entity) {
            this.entity = entity;
        }

        public Entity getEntity() {
            return this.entity;
        }

        @Override
        public void setCanceled(boolean c) {
        }
    }

    public static class EntityJoinShim
    extends NeoEvent {
        public final Entity entity;
        public final Level level;

        public EntityJoinShim(Entity entity, Level level) {
            this.entity = entity;
            this.level = level;
        }

        public Entity getEntity() {
            return this.entity;
        }

        public Level getLevel() {
            return this.level;
        }
    }

    public static class BreakShim
    extends NeoEvent {
        public final Player entity;
        public final Level level;
        public final BlockPos pos;
        public final BlockState state;

        public BreakShim(Player entity, Level level, BlockPos pos, BlockState state) {
            this.entity = entity;
            this.level = level;
            this.pos = pos;
            this.state = state;
        }

        public Player getEntity() {
            return this.entity;
        }

        public Level getLevel() {
            return this.level;
        }

        public BlockPos getPos() {
            return this.pos;
        }

        public BlockState getState() {
            return this.state;
        }

        public Player getPlayer() {
            return this.entity;
        }

        @Override
        public void setCanceled(boolean c) {
        }
    }

    public static class LivingDeathShim
    extends NeoEvent {
        public final LivingEntity entity;
        public final DamageSource source;

        public LivingDeathShim(LivingEntity entity, DamageSource source) {
            this.entity = entity;
            this.source = source;
        }

        public LivingEntity getEntity() {
            return this.entity;
        }

        public DamageSource getSource() {
            return this.source;
        }

        public Level getLevel() {
            return this.entity.level();
        }

        public BlockPos getPos() {
            return this.entity.blockPosition();
        }
    }

    public static class RightClickItemShim
    extends NeoEvent {
        public final Player entity;
        public final Level level;
        public final InteractionHand hand;
        public boolean canceled = false;

        public RightClickItemShim(Player entity, Level level, InteractionHand hand) {
            this.entity = entity;
            this.level = level;
            this.hand = hand;
        }

        public Player getEntity() {
            return this.entity;
        }

        public Level getLevel() {
            return this.level;
        }

        public InteractionHand getHand() {
            return this.hand;
        }

        public ItemStack getItemStack() {
            return this.entity.getItemInHand(this.hand);
        }

        public BlockPos getPos() {
            return this.entity.blockPosition();
        }

        public BlockState getState() {
            return this.level.getBlockState(this.entity.blockPosition());
        }

        @Override
        public void setCanceled(boolean c) {
            this.canceled = c;
        }

        @Override
        public boolean isCanceled() {
            return this.canceled;
        }
    }

    public static class RightClickBlockShim
    extends NeoEvent {
        public final Player entity;
        public final Level level;
        public final InteractionHand hand;
        public final BlockHitResult hit;
        public boolean canceled = false;

        public RightClickBlockShim(Player entity, Level level, InteractionHand hand, BlockHitResult hit) {
            this.entity = entity;
            this.level = level;
            this.hand = hand;
            this.hit = hit;
        }

        public Player getEntity() {
            return this.entity;
        }

        public Level getLevel() {
            return this.level;
        }

        public InteractionHand getHand() {
            return this.hand;
        }

        public BlockHitResult getHitVec() {
            return this.hit;
        }

        public BlockHitResult getHitResult() {
            return this.hit;
        }

        public BlockPos getPos() {
            return this.hit.getBlockPos();
        }

        public BlockState getState() {
            return this.level.getBlockState(this.hit.getBlockPos());
        }

        public ItemStack getItemStack() {
            return this.entity.getItemInHand(this.hand);
        }

        @Override
        public void setCanceled(boolean c) {
            this.canceled = c;
        }

        @Override
        public boolean isCanceled() {
            return this.canceled;
        }
    }
}

