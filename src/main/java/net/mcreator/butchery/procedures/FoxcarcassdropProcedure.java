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
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class FoxcarcassdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            FoxcarcassdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        FoxcarcassdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block25: {
            Fox foxEntity;
            block36: {
                block34: {
                    Fox foxEntity2;
                    block35: {
                        block32: {
                            Fox foxEntity3;
                            block33: {
                                block26: {
                                    Fox foxEntity4;
                                    block31: {
                                        block30: {
                                            ItemStack itemStack;
                                            ItemStack itemStack2;
                                            ItemStack itemStack3;
                                            ItemStack itemStack4;
                                            block27: {
                                                Fox foxEntity5;
                                                block29: {
                                                    block28: {
                                                        ItemStack itemStack5;
                                                        ItemStack itemStack6;
                                                        ItemStack itemStack7;
                                                        LivingEntity _livEnt3;
                                                        if (entity == null || sourceentity == null || !(entity instanceof Fox) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:fox"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:fox"))) || entity instanceof LivingEntity && (_livEnt3 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.FOX_CARCASS.get().booleanValue()) break block25;
                                                        if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block26;
                                                        if (ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block27;
                                                        if (sourceentity instanceof LivingEntity) {
                                                            LivingEntity _livEntxx = (LivingEntity)sourceentity;
                                                            itemStack7 = _livEntxx.getMainHandItem();
                                                        } else {
                                                            itemStack7 = ItemStack.EMPTY;
                                                        }
                                                        if (itemStack7.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block28;
                                                        if (sourceentity instanceof LivingEntity) {
                                                            LivingEntity _livEntx = (LivingEntity)sourceentity;
                                                            itemStack6 = _livEntx.getMainHandItem();
                                                        } else {
                                                            itemStack6 = ItemStack.EMPTY;
                                                        }
                                                        if (itemStack6.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block28;
                                                        if (sourceentity instanceof LivingEntity) {
                                                            LivingEntity _livEnt = (LivingEntity)sourceentity;
                                                            itemStack5 = _livEnt.getMainHandItem();
                                                        } else {
                                                            itemStack5 = ItemStack.EMPTY;
                                                        }
                                                        if (itemStack5.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block25;
                                                    }
                                                    if (!(foxEntity5 = (Fox)entity).getVariant().toString().equals("RED")) break block29;
                                                    if (world.isClientSide() || world.getServer() == null) break block25;
                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                        if (!(world instanceof ServerLevel)) continue;
                                                        ServerLevel _level = (ServerLevel)world;
                                                        ItemEntity entityToSpawnx = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                        entityToSpawnx.setPickUpDelay(10);
                                                        _level.addFreshEntity((Entity)entityToSpawnx);
                                                    }
                                                    break block25;
                                                }
                                                if (!foxEntity5.getVariant().toString().equals("SNOW") || world.isClientSide() || world.getServer() == null) break block25;
                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/snow_fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                    if (!(world instanceof ServerLevel)) continue;
                                                    ServerLevel _level = (ServerLevel)world;
                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                    entityToSpawn.setPickUpDelay(10);
                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                }
                                                break block25;
                                            }
                                            if (!ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block25;
                                            if (sourceentity instanceof LivingEntity) {
                                                LivingEntity _livEntxxxxxx = (LivingEntity)sourceentity;
                                                itemStack4 = _livEntxxxxxx.getMainHandItem();
                                            } else {
                                                itemStack4 = ItemStack.EMPTY;
                                            }
                                            if (itemStack4.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block30;
                                            if (sourceentity instanceof LivingEntity) {
                                                LivingEntity _livEntxxxxx = (LivingEntity)sourceentity;
                                                itemStack3 = _livEntxxxxx.getMainHandItem();
                                            } else {
                                                itemStack3 = ItemStack.EMPTY;
                                            }
                                            if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"farmersdelight:tools/knives")))) break block30;
                                            if (sourceentity instanceof LivingEntity) {
                                                LivingEntity _livEntxxxx = (LivingEntity)sourceentity;
                                                itemStack2 = _livEntxxxx.getMainHandItem();
                                            } else {
                                                itemStack2 = ItemStack.EMPTY;
                                            }
                                            if (itemStack2.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block30;
                                            if (sourceentity instanceof LivingEntity) {
                                                LivingEntity _livEntxxx = (LivingEntity)sourceentity;
                                                itemStack = _livEntxxx.getMainHandItem();
                                            } else {
                                                itemStack = ItemStack.EMPTY;
                                            }
                                            if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block25;
                                        }
                                        if (!(foxEntity4 = (Fox)entity).getVariant().toString().equals("RED")) break block31;
                                        if (world.isClientSide() || world.getServer() == null) break block25;
                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                            if (!(world instanceof ServerLevel)) continue;
                                            ServerLevel _level = (ServerLevel)world;
                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                            entityToSpawn.setPickUpDelay(10);
                                            _level.addFreshEntity((Entity)entityToSpawn);
                                        }
                                        break block25;
                                    }
                                    if (!foxEntity4.getVariant().toString().equals("SNOW") || world.isClientSide() || world.getServer() == null) break block25;
                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/snow_fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                        if (!(world instanceof ServerLevel)) continue;
                                        ServerLevel _level = (ServerLevel)world;
                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                        entityToSpawn.setPickUpDelay(10);
                                        _level.addFreshEntity((Entity)entityToSpawn);
                                    }
                                    break block25;
                                }
                                if (ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block32;
                                foxEntity3 = (Fox)entity;
                                if (!foxEntity3.getVariant().toString().equals("RED")) break block33;
                                if (world.isClientSide() || world.getServer() == null) break block25;
                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                    if (!(world instanceof ServerLevel)) continue;
                                    ServerLevel _level = (ServerLevel)world;
                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity((Entity)entityToSpawn);
                                }
                                break block25;
                            }
                            if (!foxEntity3.getVariant().toString().equals("SNOW") || world.isClientSide() || world.getServer() == null) break block25;
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/snow_fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                            break block25;
                        }
                        if (!(sourceentity instanceof Animal)) break block34;
                        if (!ButcheryconfigConfiguration.FOX_CARCASS.get().booleanValue()) break block25;
                        foxEntity2 = (Fox)entity;
                        if (!foxEntity2.getVariant().toString().equals("RED")) break block35;
                        if (world.isClientSide() || world.getServer() == null) break block25;
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                        break block25;
                    }
                    if (!foxEntity2.getVariant().toString().equals("SNOW") || world.isClientSide() || world.getServer() == null) break block25;
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/snow_fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    break block25;
                }
                if (!(sourceentity instanceof Monster) || !ButcheryconfigConfiguration.FOX_CARCASS.get().booleanValue()) break block25;
                foxEntity = (Fox)entity;
                if (!foxEntity.getVariant().toString().equals("RED")) break block36;
                if (world.isClientSide() || world.getServer() == null) break block25;
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                    if (!(world instanceof ServerLevel)) continue;
                    ServerLevel _level = (ServerLevel)world;
                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
                break block25;
            }
            if (foxEntity.getVariant().toString().equals("SNOW") && !world.isClientSide() && world.getServer() != null) {
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/snow_fox_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
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

