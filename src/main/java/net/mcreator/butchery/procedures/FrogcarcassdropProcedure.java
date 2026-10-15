package net.mcreator.butchery.procedures;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class FrogcarcassdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            FrogcarcassdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        FrogcarcassdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block30: {
            Frog frogEntity;
            block46: {
                block45: {
                    block42: {
                        Frog frogEntity2;
                        block44: {
                            block43: {
                                block39: {
                                    Frog frogEntity3;
                                    block41: {
                                        block40: {
                                            block31: {
                                                Frog frogEntity4;
                                                block38: {
                                                    block37: {
                                                        block36: {
                                                            ItemStack itemStack;
                                                            ItemStack itemStack2;
                                                            ItemStack itemStack3;
                                                            ItemStack itemStack4;
                                                            block32: {
                                                                Frog frogEntity5;
                                                                block35: {
                                                                    block34: {
                                                                        block33: {
                                                                            ItemStack itemStack5;
                                                                            ItemStack itemStack6;
                                                                            ItemStack itemStack7;
                                                                            LivingEntity _livEnt3;
                                                                            if (entity == null || sourceentity == null || !(entity instanceof Frog) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:frog"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:frog"))) || entity instanceof LivingEntity && (_livEnt3 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.FROG_CARCASS.get().booleanValue()) break block30;
                                                                            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block31;
                                                                            if (ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block32;
                                                                            if (sourceentity instanceof LivingEntity) {
                                                                                LivingEntity _livEntxx = (LivingEntity)sourceentity;
                                                                                itemStack7 = _livEntxx.getMainHandItem();
                                                                            } else {
                                                                                itemStack7 = ItemStack.EMPTY;
                                                                            }
                                                                            if (itemStack7.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block33;
                                                                            if (sourceentity instanceof LivingEntity) {
                                                                                LivingEntity _livEntx = (LivingEntity)sourceentity;
                                                                                itemStack6 = _livEntx.getMainHandItem();
                                                                            } else {
                                                                                itemStack6 = ItemStack.EMPTY;
                                                                            }
                                                                            if (itemStack6.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block33;
                                                                            if (sourceentity instanceof LivingEntity) {
                                                                                LivingEntity _livEnt = (LivingEntity)sourceentity;
                                                                                itemStack5 = _livEnt.getMainHandItem();
                                                                            } else {
                                                                                itemStack5 = ItemStack.EMPTY;
                                                                            }
                                                                            if (itemStack5.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block30;
                                                                        }
                                                                        if (!(frogEntity5 = (Frog)entity).getVariant().toString().contains("temperate_frog")) break block34;
                                                                        if (world.isClientSide() || world.getServer() == null) break block30;
                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/orange_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                            ServerLevel _level = (ServerLevel)world;
                                                                            ItemEntity entityToSpawnx = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                            entityToSpawnx.setPickUpDelay(10);
                                                                            _level.addFreshEntity((Entity)entityToSpawnx);
                                                                        }
                                                                        break block30;
                                                                    }
                                                                    if (!frogEntity5.getVariant().toString().contains("cold_frog")) break block35;
                                                                    if (world.isClientSide() || world.getServer() == null) break block30;
                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/green_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                        ServerLevel _level = (ServerLevel)world;
                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                        entityToSpawn.setPickUpDelay(10);
                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                    }
                                                                    break block30;
                                                                }
                                                                if (!frogEntity5.getVariant().toString().contains("warm_frog") || world.isClientSide() || world.getServer() == null) break block30;
                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                    ServerLevel _level = (ServerLevel)world;
                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                    entityToSpawn.setPickUpDelay(10);
                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                }
                                                                break block30;
                                                            }
                                                            if (!ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block30;
                                                            if (sourceentity instanceof LivingEntity) {
                                                                LivingEntity _livEntxxxxxx = (LivingEntity)sourceentity;
                                                                itemStack4 = _livEntxxxxxx.getMainHandItem();
                                                            } else {
                                                                itemStack4 = ItemStack.EMPTY;
                                                            }
                                                            if (itemStack4.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block36;
                                                            if (sourceentity instanceof LivingEntity) {
                                                                LivingEntity _livEntxxxxx = (LivingEntity)sourceentity;
                                                                itemStack3 = _livEntxxxxx.getMainHandItem();
                                                            } else {
                                                                itemStack3 = ItemStack.EMPTY;
                                                            }
                                                            if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"farmersdelight:tools/knives")))) break block36;
                                                            if (sourceentity instanceof LivingEntity) {
                                                                LivingEntity _livEntxxxx = (LivingEntity)sourceentity;
                                                                itemStack2 = _livEntxxxx.getMainHandItem();
                                                            } else {
                                                                itemStack2 = ItemStack.EMPTY;
                                                            }
                                                            if (itemStack2.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block36;
                                                            if (sourceentity instanceof LivingEntity) {
                                                                LivingEntity _livEntxxx = (LivingEntity)sourceentity;
                                                                itemStack = _livEntxxx.getMainHandItem();
                                                            } else {
                                                                itemStack = ItemStack.EMPTY;
                                                            }
                                                            if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block30;
                                                        }
                                                        if (!(frogEntity4 = (Frog)entity).getVariant().toString().contains("temperate_frog")) break block37;
                                                        if (world.isClientSide() || world.getServer() == null) break block30;
                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/orange_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                            if (!(world instanceof ServerLevel)) continue;
                                                            ServerLevel _level = (ServerLevel)world;
                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                            entityToSpawn.setPickUpDelay(10);
                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                        }
                                                        break block30;
                                                    }
                                                    if (!frogEntity4.getVariant().toString().contains("cold_frog")) break block38;
                                                    if (world.isClientSide() || world.getServer() == null) break block30;
                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/green_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                        if (!(world instanceof ServerLevel)) continue;
                                                        ServerLevel _level = (ServerLevel)world;
                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                        entityToSpawn.setPickUpDelay(10);
                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                    }
                                                    break block30;
                                                }
                                                if (!frogEntity4.getVariant().toString().contains("warm_frog") || world.isClientSide() || world.getServer() == null) break block30;
                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                    if (!(world instanceof ServerLevel)) continue;
                                                    ServerLevel _level = (ServerLevel)world;
                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                    entityToSpawn.setPickUpDelay(10);
                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                }
                                                break block30;
                                            }
                                            if (ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block39;
                                            frogEntity3 = (Frog)entity;
                                            if (!frogEntity3.getVariant().toString().contains("temperate_frog")) break block40;
                                            if (world.isClientSide() || world.getServer() == null) break block30;
                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/orange_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                if (!(world instanceof ServerLevel)) continue;
                                                ServerLevel _level = (ServerLevel)world;
                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                entityToSpawn.setPickUpDelay(10);
                                                _level.addFreshEntity((Entity)entityToSpawn);
                                            }
                                            break block30;
                                        }
                                        if (!frogEntity3.getVariant().toString().contains("cold_frog")) break block41;
                                        if (world.isClientSide() || world.getServer() == null) break block30;
                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/green_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                            if (!(world instanceof ServerLevel)) continue;
                                            ServerLevel _level = (ServerLevel)world;
                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                            entityToSpawn.setPickUpDelay(10);
                                            _level.addFreshEntity((Entity)entityToSpawn);
                                        }
                                        break block30;
                                    }
                                    if (!frogEntity3.getVariant().toString().contains("warm_frog") || world.isClientSide() || world.getServer() == null) break block30;
                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                        if (!(world instanceof ServerLevel)) continue;
                                        ServerLevel _level = (ServerLevel)world;
                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                        entityToSpawn.setPickUpDelay(10);
                                        _level.addFreshEntity((Entity)entityToSpawn);
                                    }
                                    break block30;
                                }
                                if (!(sourceentity instanceof Animal)) break block42;
                                if (!ButcheryconfigConfiguration.FROG_CARCASS.get().booleanValue()) break block30;
                                frogEntity2 = (Frog)entity;
                                if (!frogEntity2.getVariant().toString().contains("temperate_frog")) break block43;
                                if (world.isClientSide() || world.getServer() == null) break block30;
                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/orange_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                    if (!(world instanceof ServerLevel)) continue;
                                    ServerLevel _level = (ServerLevel)world;
                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity((Entity)entityToSpawn);
                                }
                                break block30;
                            }
                            if (!frogEntity2.getVariant().toString().contains("cold_frog")) break block44;
                            if (world.isClientSide() || world.getServer() == null) break block30;
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/green_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                            break block30;
                        }
                        if (!frogEntity2.getVariant().toString().contains("warm_frog") || world.isClientSide() || world.getServer() == null) break block30;
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                        break block30;
                    }
                    if (!(sourceentity instanceof Monster) || !ButcheryconfigConfiguration.FROG_CARCASS.get().booleanValue()) break block30;
                    frogEntity = (Frog)entity;
                    if (!frogEntity.getVariant().toString().contains("temperate_frog")) break block45;
                    if (world.isClientSide() || world.getServer() == null) break block30;
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/orange_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    break block30;
                }
                if (!frogEntity.getVariant().toString().contains("cold_frog")) break block46;
                if (world.isClientSide() || world.getServer() == null) break block30;
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/green_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                    if (!(world instanceof ServerLevel)) continue;
                    ServerLevel _level = (ServerLevel)world;
                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
                break block30;
            }
            if (frogEntity.getVariant().toString().contains("warm_frog") && !world.isClientSide() && world.getServer() != null) {
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gray_frog_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                    if (!(world instanceof ServerLevel)) continue;
                    ServerLevel _level = (ServerLevel)world;
                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
            }
        }
    }
}

