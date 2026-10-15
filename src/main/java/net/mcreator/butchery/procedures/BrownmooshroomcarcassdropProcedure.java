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
import net.minecraft.world.entity.animal.cow.MushroomCow;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class BrownmooshroomcarcassdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            BrownmooshroomcarcassdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        BrownmooshroomcarcassdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block45: {
            MushroomCow mushroomcowEntity;
            block46: {
                MushroomCow mushroomcowEntity2;
                block50: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    ItemStack itemStack3;
                    ItemStack itemStack4;
                    block48: {
                        MushroomCow mushroomcowEntity3;
                        block49: {
                            ItemStack itemStack5;
                            ItemStack itemStack6;
                            ItemStack itemStack7;
                            block47: {
                                ItemStack itemStack8;
                                ItemStack itemStack9;
                                ItemStack itemStack10;
                                ItemStack itemStack11;
                                LivingEntity _livEnt3;
                                if (entity == null || sourceentity == null || !(entity instanceof MushroomCow) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:brown_mooshroom"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:brown_mooshroom"))) || entity instanceof LivingEntity && (_livEnt3 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.BMOOSHROOM_CARCASS.get().booleanValue()) break block45;
                                if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block46;
                                if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEntxxx = (LivingEntity)sourceentity;
                                    itemStack11 = _livEntxxx.getMainHandItem();
                                } else {
                                    itemStack11 = ItemStack.EMPTY;
                                }
                                if (itemStack11.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) break block47;
                                if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEntxx = (LivingEntity)sourceentity;
                                    itemStack10 = _livEntxx.getMainHandItem();
                                } else {
                                    itemStack10 = ItemStack.EMPTY;
                                }
                                if (itemStack10.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) break block47;
                                if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEntx = (LivingEntity)sourceentity;
                                    itemStack9 = _livEntx.getMainHandItem();
                                } else {
                                    itemStack9 = ItemStack.EMPTY;
                                }
                                if (itemStack9.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block47;
                                if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)sourceentity;
                                    itemStack8 = _livEnt.getMainHandItem();
                                } else {
                                    itemStack8 = ItemStack.EMPTY;
                                }
                                if (itemStack8.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block45;
                            }
                            if (ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block48;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntxxxxxx = (LivingEntity)sourceentity;
                                itemStack7 = _livEntxxxxxx.getMainHandItem();
                            } else {
                                itemStack7 = ItemStack.EMPTY;
                            }
                            if (itemStack7.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block49;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntxxxxx = (LivingEntity)sourceentity;
                                itemStack6 = _livEntxxxxx.getMainHandItem();
                            } else {
                                itemStack6 = ItemStack.EMPTY;
                            }
                            if (itemStack6.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block49;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntxxxx = (LivingEntity)sourceentity;
                                itemStack5 = _livEntxxxx.getMainHandItem();
                            } else {
                                itemStack5 = ItemStack.EMPTY;
                            }
                            if (itemStack5.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block45;
                        }
                        if ((mushroomcowEntity3 = (MushroomCow)entity).getVariant().toString().contains("BROWN")) {
                            if (!world.isClientSide() && world.getServer() != null) {
                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brownmooshroom_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                    if (!(world instanceof ServerLevel)) continue;
                                    ServerLevel _level = (ServerLevel)world;
                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity((Entity)entityToSpawn);
                                }
                            }
                            ButcheryMod.queueServerWork(1, () -> {
                                if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                                    entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:beef\"}},distance=..20]");
                                }
                                if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                                    entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                                }
                            });
                        }
                        break block45;
                    }
                    if (!ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block45;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxxxxxxxxxx = (LivingEntity)sourceentity;
                        itemStack4 = _livEntxxxxxxxxxx.getMainHandItem();
                    } else {
                        itemStack4 = ItemStack.EMPTY;
                    }
                    if (itemStack4.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block50;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxxxxxxxxx = (LivingEntity)sourceentity;
                        itemStack3 = _livEntxxxxxxxxx.getMainHandItem();
                    } else {
                        itemStack3 = ItemStack.EMPTY;
                    }
                    if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"farmersdelight:tools/knives")))) break block50;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxxxxxxxx = (LivingEntity)sourceentity;
                        itemStack2 = _livEntxxxxxxxx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (itemStack2.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block50;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxxxxxxx = (LivingEntity)sourceentity;
                        itemStack = _livEntxxxxxxx.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block45;
                }
                if ((mushroomcowEntity2 = (MushroomCow)entity).getVariant().toString().contains("BROWN")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brownmooshroom_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                    ButcheryMod.queueServerWork(1, () -> {
                        if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                            entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:beef\"}},distance=..20]");
                        }
                        if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                            entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                        }
                    });
                }
                break block45;
            }
            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) {
                MushroomCow mushroomcowEntity4 = (MushroomCow)entity;
                if (mushroomcowEntity4.getVariant().toString().contains("BROWN")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brownmooshroom_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                    ButcheryMod.queueServerWork(1, () -> {
                        if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                            entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:beef\"}},distance=..20]");
                        }
                        if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                            entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                        }
                    });
                }
            } else if (sourceentity instanceof Animal) {
                MushroomCow mushroomcowEntity5;
                if (ButcheryconfigConfiguration.BMOOSHROOM_CARCASS.get().booleanValue() && (mushroomcowEntity5 = (MushroomCow)entity).getVariant().toString().contains("BROWN")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brownmooshroom_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                    ButcheryMod.queueServerWork(1, () -> {
                        if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                            entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:beef\"}},distance=..20]");
                        }
                        if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                            entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                        }
                    });
                }
            } else if (sourceentity instanceof Monster && ButcheryconfigConfiguration.BMOOSHROOM_CARCASS.get().booleanValue() && (mushroomcowEntity = (MushroomCow)entity).getVariant().toString().contains("BROWN")) {
                if (!world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brownmooshroom_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                        entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:beef\"}},distance=..20]");
                    }
                    if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                        entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                    }
                });
            }
        }
    }
}

