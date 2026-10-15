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
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class AxolotlcarcassdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            AxolotlcarcassdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        AxolotlcarcassdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block40: {
            Axolotl axolotl;
            block66: {
                block65: {
                    block64: {
                        block63: {
                            block58: {
                                Axolotl axolotl2;
                                block62: {
                                    block61: {
                                        block60: {
                                            block59: {
                                                block53: {
                                                    Axolotl axolotl3;
                                                    block57: {
                                                        block56: {
                                                            block55: {
                                                                block54: {
                                                                    block41: {
                                                                        Axolotl axolotl4;
                                                                        block52: {
                                                                            block51: {
                                                                                block50: {
                                                                                    block49: {
                                                                                        block48: {
                                                                                            ItemStack itemStack;
                                                                                            ItemStack itemStack2;
                                                                                            ItemStack itemStack3;
                                                                                            ItemStack itemStack4;
                                                                                            block42: {
                                                                                                Axolotl axolotl5;
                                                                                                block47: {
                                                                                                    block46: {
                                                                                                        block45: {
                                                                                                            block44: {
                                                                                                                block43: {
                                                                                                                    ItemStack itemStack5;
                                                                                                                    ItemStack itemStack6;
                                                                                                                    ItemStack itemStack7;
                                                                                                                    LivingEntity _livEnt3;
                                                                                                                    if (entity == null || sourceentity == null || !(entity instanceof Axolotl) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:axolotl"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:axolotl"))) || entity instanceof LivingEntity && (_livEnt3 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.AXOLOTL_CARCASS.get().booleanValue()) break block40;
                                                                                                                    if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block41;
                                                                                                                    if (ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block42;
                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                        LivingEntity _livEntxx = (LivingEntity)sourceentity;
                                                                                                                        itemStack7 = _livEntxx.getMainHandItem();
                                                                                                                    } else {
                                                                                                                        itemStack7 = ItemStack.EMPTY;
                                                                                                                    }
                                                                                                                    if (itemStack7.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block43;
                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                                                                                                                        itemStack6 = _livEntx.getMainHandItem();
                                                                                                                    } else {
                                                                                                                        itemStack6 = ItemStack.EMPTY;
                                                                                                                    }
                                                                                                                    if (itemStack6.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block43;
                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                                                                                                                        itemStack5 = _livEnt.getMainHandItem();
                                                                                                                    } else {
                                                                                                                        itemStack5 = ItemStack.EMPTY;
                                                                                                                    }
                                                                                                                    if (itemStack5.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block40;
                                                                                                                }
                                                                                                                if (!String.valueOf((axolotl5 = (Axolotl)entity).getVariant()).equals("BLUE")) break block44;
                                                                                                                if (world.isClientSide() || world.getServer() == null) break block40;
                                                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/blue_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                                                    ItemEntity entityToSpawnx = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                    entityToSpawnx.setPickUpDelay(10);
                                                                                                                    _level.addFreshEntity((Entity)entityToSpawnx);
                                                                                                                }
                                                                                                                break block40;
                                                                                                            }
                                                                                                            if (!String.valueOf(axolotl5.getVariant()).equals("CYAN")) break block45;
                                                                                                            if (world.isClientSide() || world.getServer() == null) break block40;
                                                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/cyan_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                            }
                                                                                                            break block40;
                                                                                                        }
                                                                                                        if (!String.valueOf(axolotl5.getVariant()).equals("GOLD")) break block46;
                                                                                                        if (world.isClientSide() || world.getServer() == null) break block40;
                                                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gold_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                                                            ServerLevel _level = (ServerLevel)world;
                                                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                            entityToSpawn.setPickUpDelay(10);
                                                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                        }
                                                                                                        break block40;
                                                                                                    }
                                                                                                    if (!String.valueOf(axolotl5.getVariant()).equals("LUCY")) break block47;
                                                                                                    if (world.isClientSide() || world.getServer() == null) break block40;
                                                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/pink_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                                                        ServerLevel _level = (ServerLevel)world;
                                                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                        entityToSpawn.setPickUpDelay(10);
                                                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                    }
                                                                                                    break block40;
                                                                                                }
                                                                                                if (!String.valueOf(axolotl5.getVariant()).equals("WILD") || world.isClientSide() || world.getServer() == null) break block40;
                                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                    entityToSpawn.setPickUpDelay(10);
                                                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                }
                                                                                                break block40;
                                                                                            }
                                                                                            if (!ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block40;
                                                                                            if (sourceentity instanceof LivingEntity) {
                                                                                                LivingEntity _livEntxxxxxx = (LivingEntity)sourceentity;
                                                                                                itemStack4 = _livEntxxxxxx.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack4 = ItemStack.EMPTY;
                                                                                            }
                                                                                            if (itemStack4.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block48;
                                                                                            if (sourceentity instanceof LivingEntity) {
                                                                                                LivingEntity _livEntxxxxx = (LivingEntity)sourceentity;
                                                                                                itemStack3 = _livEntxxxxx.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack3 = ItemStack.EMPTY;
                                                                                            }
                                                                                            if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"farmersdelight:tools/knives")))) break block48;
                                                                                            if (sourceentity instanceof LivingEntity) {
                                                                                                LivingEntity _livEntxxxx = (LivingEntity)sourceentity;
                                                                                                itemStack2 = _livEntxxxx.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack2 = ItemStack.EMPTY;
                                                                                            }
                                                                                            if (itemStack2.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block48;
                                                                                            if (sourceentity instanceof LivingEntity) {
                                                                                                LivingEntity _livEntxxx = (LivingEntity)sourceentity;
                                                                                                itemStack = _livEntxxx.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack = ItemStack.EMPTY;
                                                                                            }
                                                                                            if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block40;
                                                                                        }
                                                                                        if (!String.valueOf((axolotl4 = (Axolotl)entity).getVariant()).equals("BLUE")) break block49;
                                                                                        if (world.isClientSide() || world.getServer() == null) break block40;
                                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/blue_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                                            ServerLevel _level = (ServerLevel)world;
                                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                            entityToSpawn.setPickUpDelay(10);
                                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                                        }
                                                                                        break block40;
                                                                                    }
                                                                                    if (!String.valueOf(axolotl4.getVariant()).equals("CYAN")) break block50;
                                                                                    if (world.isClientSide() || world.getServer() == null) break block40;
                                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/cyan_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                                        ServerLevel _level = (ServerLevel)world;
                                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                        entityToSpawn.setPickUpDelay(10);
                                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                                    }
                                                                                    break block40;
                                                                                }
                                                                                if (!String.valueOf(axolotl4.getVariant()).equals("GOLD")) break block51;
                                                                                if (world.isClientSide() || world.getServer() == null) break block40;
                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gold_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                    entityToSpawn.setPickUpDelay(10);
                                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                                }
                                                                                break block40;
                                                                            }
                                                                            if (!String.valueOf(axolotl4.getVariant()).equals("LUCY")) break block52;
                                                                            if (world.isClientSide() || world.getServer() == null) break block40;
                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/pink_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                            }
                                                                            break block40;
                                                                        }
                                                                        if (!String.valueOf(axolotl4.getVariant()).equals("WILD") || world.isClientSide() || world.getServer() == null) break block40;
                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                            ServerLevel _level = (ServerLevel)world;
                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                            entityToSpawn.setPickUpDelay(10);
                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                        }
                                                                        break block40;
                                                                    }
                                                                    if (ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block53;
                                                                    axolotl3 = (Axolotl)entity;
                                                                    if (!String.valueOf(axolotl3.getVariant()).equals("BLUE")) break block54;
                                                                    if (world.isClientSide() || world.getServer() == null) break block40;
                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/blue_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                        ServerLevel _level = (ServerLevel)world;
                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                        entityToSpawn.setPickUpDelay(10);
                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                    }
                                                                    break block40;
                                                                }
                                                                if (!String.valueOf(axolotl3.getVariant()).equals("CYAN")) break block55;
                                                                if (world.isClientSide() || world.getServer() == null) break block40;
                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/cyan_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                    ServerLevel _level = (ServerLevel)world;
                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                    entityToSpawn.setPickUpDelay(10);
                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                }
                                                                break block40;
                                                            }
                                                            if (!String.valueOf(axolotl3.getVariant()).equals("GOLD")) break block56;
                                                            if (world.isClientSide() || world.getServer() == null) break block40;
                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gold_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                if (!(world instanceof ServerLevel)) continue;
                                                                ServerLevel _level = (ServerLevel)world;
                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                entityToSpawn.setPickUpDelay(10);
                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                            }
                                                            break block40;
                                                        }
                                                        if (!String.valueOf(axolotl3.getVariant()).equals("LUCY")) break block57;
                                                        if (world.isClientSide() || world.getServer() == null) break block40;
                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/pink_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                            if (!(world instanceof ServerLevel)) continue;
                                                            ServerLevel _level = (ServerLevel)world;
                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                            entityToSpawn.setPickUpDelay(10);
                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                        }
                                                        break block40;
                                                    }
                                                    if (!String.valueOf(axolotl3.getVariant()).equals("WILD") || world.isClientSide() || world.getServer() == null) break block40;
                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                        if (!(world instanceof ServerLevel)) continue;
                                                        ServerLevel _level = (ServerLevel)world;
                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                        entityToSpawn.setPickUpDelay(10);
                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                    }
                                                    break block40;
                                                }
                                                if (!(sourceentity instanceof Animal)) break block58;
                                                if (!ButcheryconfigConfiguration.AXOLOTL_CARCASS.get().booleanValue()) break block40;
                                                axolotl2 = (Axolotl)entity;
                                                if (!String.valueOf(axolotl2.getVariant()).equals("BLUE")) break block59;
                                                if (world.isClientSide() || world.getServer() == null) break block40;
                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/blue_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                    if (!(world instanceof ServerLevel)) continue;
                                                    ServerLevel _level = (ServerLevel)world;
                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                    entityToSpawn.setPickUpDelay(10);
                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                }
                                                break block40;
                                            }
                                            if (!String.valueOf(axolotl2.getVariant()).equals("CYAN")) break block60;
                                            if (world.isClientSide() || world.getServer() == null) break block40;
                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/cyan_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                if (!(world instanceof ServerLevel)) continue;
                                                ServerLevel _level = (ServerLevel)world;
                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                entityToSpawn.setPickUpDelay(10);
                                                _level.addFreshEntity((Entity)entityToSpawn);
                                            }
                                            break block40;
                                        }
                                        if (!String.valueOf(axolotl2.getVariant()).equals("GOLD")) break block61;
                                        if (world.isClientSide() || world.getServer() == null) break block40;
                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gold_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                            if (!(world instanceof ServerLevel)) continue;
                                            ServerLevel _level = (ServerLevel)world;
                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                            entityToSpawn.setPickUpDelay(10);
                                            _level.addFreshEntity((Entity)entityToSpawn);
                                        }
                                        break block40;
                                    }
                                    if (!String.valueOf(axolotl2.getVariant()).equals("LUCY")) break block62;
                                    if (world.isClientSide() || world.getServer() == null) break block40;
                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/pink_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                        if (!(world instanceof ServerLevel)) continue;
                                        ServerLevel _level = (ServerLevel)world;
                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                        entityToSpawn.setPickUpDelay(10);
                                        _level.addFreshEntity((Entity)entityToSpawn);
                                    }
                                    break block40;
                                }
                                if (!String.valueOf(axolotl2.getVariant()).equals("WILD") || world.isClientSide() || world.getServer() == null) break block40;
                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                    if (!(world instanceof ServerLevel)) continue;
                                    ServerLevel _level = (ServerLevel)world;
                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity((Entity)entityToSpawn);
                                }
                                break block40;
                            }
                            if (!(sourceentity instanceof Monster) || !ButcheryconfigConfiguration.AXOLOTL_CARCASS.get().booleanValue()) break block40;
                            axolotl = (Axolotl)entity;
                            if (!String.valueOf(axolotl.getVariant()).equals("BLUE")) break block63;
                            if (world.isClientSide() || world.getServer() == null) break block40;
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/blue_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                            break block40;
                        }
                        if (!String.valueOf(axolotl.getVariant()).equals("CYAN")) break block64;
                        if (world.isClientSide() || world.getServer() == null) break block40;
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/cyan_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                        break block40;
                    }
                    if (!String.valueOf(axolotl.getVariant()).equals("GOLD")) break block65;
                    if (world.isClientSide() || world.getServer() == null) break block40;
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/gold_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    break block40;
                }
                if (!String.valueOf(axolotl.getVariant()).equals("LUCY")) break block66;
                if (world.isClientSide() || world.getServer() == null) break block40;
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/pink_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                    if (!(world instanceof ServerLevel)) continue;
                    ServerLevel _level = (ServerLevel)world;
                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
                break block40;
            }
            if (String.valueOf(axolotl.getVariant()).equals("WILD") && !world.isClientSide() && world.getServer() != null) {
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/brown_axolotl_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
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

