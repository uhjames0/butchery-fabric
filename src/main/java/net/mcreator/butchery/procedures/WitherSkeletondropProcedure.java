package net.mcreator.butchery.procedures;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.skeleton.WitherSkeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

public class WitherSkeletondropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            WitherSkeletondropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        WitherSkeletondropProcedure.execute(null, world, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, Entity entity, Entity sourceentity) {
        block22: {
            block23: {
                block24: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    ItemStack itemStack3;
                    LivingEntity _livEnt3;
                    if (entity == null || sourceentity == null || !(entity instanceof WitherSkeleton) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:wither_skeleton"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:wither_skeleton"))) || entity instanceof LivingEntity && (_livEnt3 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.WITHER_SKELETON_CORPSE.get().booleanValue()) break block22;
                    if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block23;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)sourceentity;
                        itemStack3 = _livEntxx.getMainHandItem();
                    } else {
                        itemStack3 = ItemStack.EMPTY;
                    }
                    if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) break block24;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                        itemStack2 = _livEntx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) break block24;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        itemStack = _livEnt.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) == 0) break block22;
                }
                if (event instanceof ICancellableEvent) {
                    NeoEvent _cancellable = event;
                    _cancellable.setCanceled(true);
                }
                if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                    entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/loot spawn ~ ~-1 ~ loot butchery:blocks/wither_skeleton_corpse_loot");
                }
                break block22;
            }
            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) {
                if (event instanceof ICancellableEvent) {
                    NeoEvent _cancellable = event;
                    _cancellable.setCanceled(true);
                }
                if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                    entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/loot spawn ~ ~-1 ~ loot butchery:blocks/wither_skeleton_corpse_loot");
                }
            } else if (sourceentity instanceof Animal) {
                if (ButcheryconfigConfiguration.WITHER_SKELETON_CORPSE.get().booleanValue()) {
                    if (event instanceof ICancellableEvent) {
                        NeoEvent _cancellable = event;
                        _cancellable.setCanceled(true);
                    }
                    if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                        entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/loot spawn ~ ~-1 ~ loot butchery:blocks/wither_skeleton_corpse_loot");
                    }
                }
            } else if (sourceentity instanceof Monster && ButcheryconfigConfiguration.WITHER_SKELETON_CORPSE.get().booleanValue()) {
                if (event instanceof ICancellableEvent) {
                    NeoEvent _cancellable = event;
                    _cancellable.setCanceled(true);
                }
                if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                    entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/loot spawn ~ ~-1 ~ loot butchery:blocks/wither_skeleton_corpse_loot");
                }
            }
        }
    }
}

