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
import net.minecraft.world.entity.animal.squid.GlowSquid;
import net.minecraft.world.entity.animal.squid.Squid;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class SquidcarcassdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            SquidcarcassdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        SquidcarcassdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block22: {
            block28: {
                block27: {
                    block23: {
                        block26: {
                            ItemStack itemStack;
                            ItemStack itemStack2;
                            ItemStack itemStack3;
                            ItemStack itemStack4;
                            block24: {
                                block25: {
                                    ItemStack itemStack5;
                                    ItemStack itemStack6;
                                    ItemStack itemStack7;
                                    LivingEntity _livEnt4;
                                    if (entity == null || sourceentity == null || !(entity instanceof Squid) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:squid"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:squid"))) || entity instanceof GlowSquid || entity instanceof LivingEntity && (_livEnt4 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.SQUID_CARCASS.get().booleanValue()) break block22;
                                    if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block23;
                                    if (ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block24;
                                    if (sourceentity instanceof LivingEntity) {
                                        LivingEntity _livEntxx = (LivingEntity)sourceentity;
                                        itemStack7 = _livEntxx.getMainHandItem();
                                    } else {
                                        itemStack7 = ItemStack.EMPTY;
                                    }
                                    if (itemStack7.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block25;
                                    if (sourceentity instanceof LivingEntity) {
                                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                                        itemStack6 = _livEntx.getMainHandItem();
                                    } else {
                                        itemStack6 = ItemStack.EMPTY;
                                    }
                                    if (itemStack6.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block25;
                                    if (sourceentity instanceof LivingEntity) {
                                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                                        itemStack5 = _livEnt.getMainHandItem();
                                    } else {
                                        itemStack5 = ItemStack.EMPTY;
                                    }
                                    if (itemStack5.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block22;
                                }
                                if (!world.isClientSide() && world.getServer() != null) {
                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/squid_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                        if (!(world instanceof ServerLevel)) continue;
                                        ServerLevel _level = (ServerLevel)world;
                                        ItemEntity entityToSpawnx = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                        entityToSpawnx.setPickUpDelay(10);
                                        _level.addFreshEntity((Entity)entityToSpawnx);
                                    }
                                }
                                break block22;
                            }
                            if (!ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block22;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntxxx = (LivingEntity)sourceentity;
                                itemStack4 = _livEntxxx.getMainHandItem();
                            } else {
                                itemStack4 = ItemStack.EMPTY;
                            }
                            if (itemStack4.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block26;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntxx = (LivingEntity)sourceentity;
                                itemStack3 = _livEntxx.getMainHandItem();
                            } else {
                                itemStack3 = ItemStack.EMPTY;
                            }
                            if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"farmersdelight:tools/knives")))) break block26;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntx = (LivingEntity)sourceentity;
                                itemStack2 = _livEntx.getMainHandItem();
                            } else {
                                itemStack2 = ItemStack.EMPTY;
                            }
                            if (itemStack2.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block26;
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEnt = (LivingEntity)sourceentity;
                                itemStack = _livEnt.getMainHandItem();
                            } else {
                                itemStack = ItemStack.EMPTY;
                            }
                            if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block22;
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/squid_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                        break block22;
                    }
                    if (ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block27;
                    if (world.isClientSide() || world.getServer() == null) break block22;
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/squid_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    break block22;
                }
                if (!(sourceentity instanceof Animal)) break block28;
                if (!ButcheryconfigConfiguration.SQUID_CARCASS.get().booleanValue() || world.isClientSide() || world.getServer() == null) break block22;
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/squid_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                    if (!(world instanceof ServerLevel)) continue;
                    ServerLevel _level = (ServerLevel)world;
                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
                break block22;
            }
            if (sourceentity instanceof Monster && ButcheryconfigConfiguration.SQUID_CARCASS.get().booleanValue() && !world.isClientSide() && world.getServer() != null) {
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/squid_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
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

