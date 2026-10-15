package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
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
import net.minecraft.world.entity.animal.equine.Llama;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class LlamacarcassdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            LlamacarcassdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        LlamacarcassdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block97: {
            block98: {
                Llama llama;
                block101: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    ItemStack itemStack3;
                    ItemStack itemStack4;
                    block99: {
                        Llama llama2;
                        block100: {
                            ItemStack itemStack5;
                            ItemStack itemStack6;
                            ItemStack itemStack7;
                            LivingEntity _livEnt3;
                            if (entity == null || sourceentity == null || !(entity instanceof Llama) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:llama"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:llama"))) || entity instanceof LivingEntity && (_livEnt3 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.LLAMA_CARCASS.get().booleanValue()) break block97;
                            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block98;
                            if (ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block99;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntxx = (LivingEntity)sourceentity;
                                itemStack7 = _livEntxx.getMainHandItem();
                            } else {
                                itemStack7 = ItemStack.EMPTY;
                            }
                            if (itemStack7.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block100;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntx = (LivingEntity)sourceentity;
                                itemStack6 = _livEntx.getMainHandItem();
                            } else {
                                itemStack6 = ItemStack.EMPTY;
                            }
                            if (itemStack6.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block100;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEnt = (LivingEntity)sourceentity;
                                itemStack5 = _livEnt.getMainHandItem();
                            } else {
                                itemStack5 = ItemStack.EMPTY;
                            }
                            if (itemStack5.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block97;
                        }
                        if (event instanceof ICancellableEvent) {
                            NeoEvent _cancellable = event;
                            _cancellable.setCanceled(true);
                        }
                        if (String.valueOf((llama2 = (Llama)entity).getVariant()).equals("CREAMY")) {
                            if (!world.isClientSide() && world.getServer() != null) {
                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creamy_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                    if (!(world instanceof ServerLevel)) continue;
                                    ServerLevel _level = (ServerLevel)world;
                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity((Entity)entityToSpawn);
                                }
                            }
                        } else if (String.valueOf(llama2.getVariant()).equals("BROWN")) {
                            if (!world.isClientSide() && world.getServer() != null) {
                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                    if (!(world instanceof ServerLevel)) continue;
                                    ServerLevel _level = (ServerLevel)world;
                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity((Entity)entityToSpawn);
                                }
                            }
                        } else if (String.valueOf(llama2.getVariant()).equals("WHITE")) {
                            if (!world.isClientSide() && world.getServer() != null) {
                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/white_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                    if (!(world instanceof ServerLevel)) continue;
                                    ServerLevel _level = (ServerLevel)world;
                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity((Entity)entityToSpawn);
                                }
                            }
                        } else if (String.valueOf(llama2.getVariant()).equals("GRAY") && !world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawnx = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawnx.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawnx);
                            }
                        }
                        ButcheryMod.queueServerWork(1, () -> {
                            if (!sourceentity.level().isClientSide() && sourceentity.level().getServer() != null) {
                                sourceentity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(), sourceentity.level() instanceof ServerLevel ? (ServerLevel)sourceentity.level() : null, PermissionSet.ALL_PERMISSIONS, sourceentity.level().getServer(), sourceentity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                            }
                        });
                        break block97;
                    }
                    if (!ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block97;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxxx = (LivingEntity)sourceentity;
                        itemStack4 = _livEntxxx.getMainHandItem();
                    } else {
                        itemStack4 = ItemStack.EMPTY;
                    }
                    if (itemStack4.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block101;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)sourceentity;
                        itemStack3 = _livEntxx.getMainHandItem();
                    } else {
                        itemStack3 = ItemStack.EMPTY;
                    }
                    if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"farmersdelight:tools/knives")))) break block101;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                        itemStack2 = _livEntx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (itemStack2.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block101;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        itemStack = _livEnt.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block97;
                }
                if (event instanceof ICancellableEvent) {
                    NeoEvent _cancellable = event;
                    _cancellable.setCanceled(true);
                }
                if (String.valueOf((llama = (Llama)entity).getVariant()).equals("CREAMY")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creamy_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (String.valueOf(llama.getVariant()).equals("BROWN")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (String.valueOf(llama.getVariant()).equals("WHITE")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/white_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (String.valueOf(llama.getVariant()).equals("GRAY") && !world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!sourceentity.level().isClientSide() && sourceentity.level().getServer() != null) {
                        sourceentity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(), sourceentity.level() instanceof ServerLevel ? (ServerLevel)sourceentity.level() : null, PermissionSet.ALL_PERMISSIONS, sourceentity.level().getServer(), sourceentity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                    }
                });
                break block97;
            }
            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) {
                Llama llama;
                if (event instanceof ICancellableEvent) {
                    NeoEvent _cancellable = event;
                    _cancellable.setCanceled(true);
                }
                if (String.valueOf((llama = (Llama)entity).getVariant()).equals("CREAMY")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creamy_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (String.valueOf(llama.getVariant()).equals("BROWN")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (String.valueOf(llama.getVariant()).equals("WHITE")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/white_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (String.valueOf(llama.getVariant()).equals("GRAY") && !world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!sourceentity.level().isClientSide() && sourceentity.level().getServer() != null) {
                        sourceentity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(), sourceentity.level() instanceof ServerLevel ? (ServerLevel)sourceentity.level() : null, PermissionSet.ALL_PERMISSIONS, sourceentity.level().getServer(), sourceentity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                    }
                });
            } else if (sourceentity instanceof Animal) {
                if (ButcheryconfigConfiguration.LLAMA_CARCASS.get().booleanValue()) {
                    Llama llama;
                    if (event instanceof ICancellableEvent) {
                        NeoEvent _cancellable = event;
                        _cancellable.setCanceled(true);
                    }
                    if (String.valueOf((llama = (Llama)entity).getVariant()).equals("CREAMY")) {
                        if (!world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creamy_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                    } else if (String.valueOf(llama.getVariant()).equals("BROWN")) {
                        if (!world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                    } else if (String.valueOf(llama.getVariant()).equals("WHITE")) {
                        if (!world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/white_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                    } else if (String.valueOf(llama.getVariant()).equals("GRAY") && !world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                    ButcheryMod.queueServerWork(1, () -> {
                        if (!sourceentity.level().isClientSide() && sourceentity.level().getServer() != null) {
                            sourceentity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(), sourceentity.level() instanceof ServerLevel ? (ServerLevel)sourceentity.level() : null, PermissionSet.ALL_PERMISSIONS, sourceentity.level().getServer(), sourceentity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                        }
                    });
                }
            } else if (sourceentity instanceof Monster && ButcheryconfigConfiguration.LLAMA_CARCASS.get().booleanValue()) {
                Llama llama;
                if (event instanceof ICancellableEvent) {
                    NeoEvent _cancellable = event;
                    _cancellable.setCanceled(true);
                }
                if (String.valueOf((llama = (Llama)entity).getVariant()).equals("CREAMY")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/creamy_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (String.valueOf(llama.getVariant()).equals("BROWN")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (String.valueOf(llama.getVariant()).equals("WHITE")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/white_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (String.valueOf(llama.getVariant()).equals("GRAY") && !world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_llama_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!sourceentity.level().isClientSide() && sourceentity.level().getServer() != null) {
                        sourceentity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(), sourceentity.level() instanceof ServerLevel ? (ServerLevel)sourceentity.level() : null, PermissionSet.ALL_PERMISSIONS, sourceentity.level().getServer(), sourceentity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                    }
                });
            }
        }
    }
}

