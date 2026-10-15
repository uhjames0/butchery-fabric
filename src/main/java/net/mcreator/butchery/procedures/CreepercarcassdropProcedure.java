package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class CreepercarcassdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            CreepercarcassdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        CreepercarcassdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block30: {
            block31: {
                block34: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    ItemStack itemStack3;
                    block32: {
                        block33: {
                            ItemStack itemStack4;
                            ItemStack itemStack5;
                            LivingEntity _livEnt3;
                            if (entity == null || sourceentity == null || !(entity instanceof Creeper) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:creeper"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:creeper"))) || entity instanceof LivingEntity && (_livEnt3 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.CREEPER_CARCASS.get().booleanValue()) break block30;
                            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block31;
                            if (ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block32;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntx = (LivingEntity)sourceentity;
                                itemStack5 = _livEntx.getMainHandItem();
                            } else {
                                itemStack5 = ItemStack.EMPTY;
                            }
                            if (itemStack5.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block33;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEnt = (LivingEntity)sourceentity;
                                itemStack4 = _livEnt.getMainHandItem();
                            } else {
                                itemStack4 = ItemStack.EMPTY;
                            }
                            if (itemStack4.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) == 0) break block30;
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creeper_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _levelx = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_levelx, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _levelx.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                        ButcheryMod.queueServerWork(1, () -> {
                            if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                                entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:gunpowder\"}},distance=..20]");
                            }
                        });
                        break block30;
                    }
                    if (!ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block30;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)sourceentity;
                        itemStack3 = _livEntxx.getMainHandItem();
                    } else {
                        itemStack3 = ItemStack.EMPTY;
                    }
                    if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block34;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                        itemStack2 = _livEntx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"farmersdelight:tools/knives")))) break block34;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        itemStack = _livEnt.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) == 0) break block30;
                }
                if (!world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creeper_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                        entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:gunpowder\"}},distance=..20]");
                    }
                });
                break block30;
            }
            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) {
                if (!world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creeper_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                        entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:gunpowder\"}},distance=..20]");
                    }
                });
            } else if (sourceentity instanceof Animal) {
                if (ButcheryconfigConfiguration.CREEPER_CARCASS.get().booleanValue()) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creeper_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                    ButcheryMod.queueServerWork(1, () -> {
                        if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                            entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:gunpowder\"}},distance=..20]");
                        }
                    });
                }
            } else if (sourceentity instanceof Monster && ButcheryconfigConfiguration.CREEPER_CARCASS.get().booleanValue()) {
                if (!world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creeper_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                        entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:gunpowder\"}},distance=..20]");
                    }
                });
            }
        }
    }
}

