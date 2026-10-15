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
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class CatcarcassdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            CatcarcassdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        CatcarcassdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block59: {
            Cat catEntity;
            block105: {
                block104: {
                    block103: {
                        block102: {
                            block101: {
                                block100: {
                                    block99: {
                                        block98: {
                                            block97: {
                                                block96: {
                                                    block85: {
                                                        Cat catEntity2;
                                                        block95: {
                                                            block94: {
                                                                block93: {
                                                                    block92: {
                                                                        block91: {
                                                                            block90: {
                                                                                block89: {
                                                                                    block88: {
                                                                                        block87: {
                                                                                            block86: {
                                                                                                block84: {
                                                                                                    block60: {
                                                                                                        Cat catEntity3;
                                                                                                        block83: {
                                                                                                            block82: {
                                                                                                                block81: {
                                                                                                                    block80: {
                                                                                                                        block79: {
                                                                                                                            block78: {
                                                                                                                                block77: {
                                                                                                                                    block76: {
                                                                                                                                        block75: {
                                                                                                                                            block74: {
                                                                                                                                                block73: {
                                                                                                                                                    ItemStack itemStack;
                                                                                                                                                    ItemStack itemStack2;
                                                                                                                                                    ItemStack itemStack3;
                                                                                                                                                    ItemStack itemStack4;
                                                                                                                                                    block61: {
                                                                                                                                                        Cat catEntity4;
                                                                                                                                                        block72: {
                                                                                                                                                            block71: {
                                                                                                                                                                block70: {
                                                                                                                                                                    block69: {
                                                                                                                                                                        block68: {
                                                                                                                                                                            block67: {
                                                                                                                                                                                block66: {
                                                                                                                                                                                    block65: {
                                                                                                                                                                                        block64: {
                                                                                                                                                                                            block63: {
                                                                                                                                                                                                block62: {
                                                                                                                                                                                                    ItemStack itemStack5;
                                                                                                                                                                                                    ItemStack itemStack6;
                                                                                                                                                                                                    ItemStack itemStack7;
                                                                                                                                                                                                    LivingEntity _livEnt3;
                                                                                                                                                                                                    if (entity == null || sourceentity == null || !(entity instanceof Cat) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:cat"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:cat"))) || entity instanceof LivingEntity && (_livEnt3 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.CAT_CARCASS.get().booleanValue()) break block59;
                                                                                                                                                                                                    if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block60;
                                                                                                                                                                                                    if (ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block61;
                                                                                                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                                                                                                        LivingEntity _livEntxx = (LivingEntity)sourceentity;
                                                                                                                                                                                                        itemStack7 = _livEntxx.getMainHandItem();
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        itemStack7 = ItemStack.EMPTY;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    if (itemStack7.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block62;
                                                                                                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                                                                                                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                                                                                                                                                                                                        itemStack6 = _livEntx.getMainHandItem();
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        itemStack6 = ItemStack.EMPTY;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    if (itemStack6.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block62;
                                                                                                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                                                                                                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                                                                                                                                                                                                        itemStack5 = _livEnt.getMainHandItem();
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        itemStack5 = ItemStack.EMPTY;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    if (itemStack5.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block59;
                                                                                                                                                                                                }
                                                                                                                                                                                                if (!(catEntity4 = (Cat)entity).getVariant().toString().contains("tabby")) break block63;
                                                                                                                                                                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/tabby_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                                                    ItemEntity entityToSpawnx = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                                                    entityToSpawnx.setPickUpDelay(10);
                                                                                                                                                                                                    _level.addFreshEntity((Entity)entityToSpawnx);
                                                                                                                                                                                                }
                                                                                                                                                                                                break block59;
                                                                                                                                                                                            }
                                                                                                                                                                                            if (!catEntity4.getVariant().toString().contains("black") || catEntity4.getVariant().toString().contains("all_black")) break block64;
                                                                                                                                                                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                                                                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                                                            }
                                                                                                                                                                                            break block59;
                                                                                                                                                                                        }
                                                                                                                                                                                        if (!catEntity4.getVariant().toString().contains("red")) break block65;
                                                                                                                                                                                        if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/red_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                                            ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                                            entityToSpawn.setPickUpDelay(10);
                                                                                                                                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                                                        }
                                                                                                                                                                                        break block59;
                                                                                                                                                                                    }
                                                                                                                                                                                    if (!catEntity4.getVariant().toString().contains("siamese")) break block66;
                                                                                                                                                                                    if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/siamese_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                                        ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                                        entityToSpawn.setPickUpDelay(10);
                                                                                                                                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                                                    }
                                                                                                                                                                                    break block59;
                                                                                                                                                                                }
                                                                                                                                                                                if (!catEntity4.getVariant().toString().contains("british_shorthair")) break block67;
                                                                                                                                                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/bshorthair_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                                    entityToSpawn.setPickUpDelay(10);
                                                                                                                                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                                                }
                                                                                                                                                                                break block59;
                                                                                                                                                                            }
                                                                                                                                                                            if (!catEntity4.getVariant().toString().contains("calico")) break block68;
                                                                                                                                                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/calico_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                                                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                                            }
                                                                                                                                                                            break block59;
                                                                                                                                                                        }
                                                                                                                                                                        if (!catEntity4.getVariant().toString().contains("persian")) break block69;
                                                                                                                                                                        if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/persian_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                            ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                            entityToSpawn.setPickUpDelay(10);
                                                                                                                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                                        }
                                                                                                                                                                        break block59;
                                                                                                                                                                    }
                                                                                                                                                                    if (!catEntity4.getVariant().toString().contains("ragdoll")) break block70;
                                                                                                                                                                    if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/ragdoll_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                        ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                        entityToSpawn.setPickUpDelay(10);
                                                                                                                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                                    }
                                                                                                                                                                    break block59;
                                                                                                                                                                }
                                                                                                                                                                if (!catEntity4.getVariant().toString().contains("white")) break block71;
                                                                                                                                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/white_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                    entityToSpawn.setPickUpDelay(10);
                                                                                                                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                                }
                                                                                                                                                                break block59;
                                                                                                                                                            }
                                                                                                                                                            if (!catEntity4.getVariant().toString().contains("jellie")) break block72;
                                                                                                                                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/jellie_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                            }
                                                                                                                                                            break block59;
                                                                                                                                                        }
                                                                                                                                                        if (!catEntity4.getVariant().toString().contains("all_black") || world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/all_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                            ServerLevel _level = (ServerLevel)world;
                                                                                                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                            entityToSpawn.setPickUpDelay(10);
                                                                                                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                        }
                                                                                                                                                        break block59;
                                                                                                                                                    }
                                                                                                                                                    if (!ButcheryconfigConfiguration.FD_CARCASS_DROP.get().booleanValue()) break block59;
                                                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                                                        LivingEntity _livEntxxxxxx = (LivingEntity)sourceentity;
                                                                                                                                                        itemStack4 = _livEntxxxxxx.getMainHandItem();
                                                                                                                                                    } else {
                                                                                                                                                        itemStack4 = ItemStack.EMPTY;
                                                                                                                                                    }
                                                                                                                                                    if (itemStack4.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:cleaver")))) break block73;
                                                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                                                        LivingEntity _livEntxxxxx = (LivingEntity)sourceentity;
                                                                                                                                                        itemStack3 = _livEntxxxxx.getMainHandItem();
                                                                                                                                                    } else {
                                                                                                                                                        itemStack3 = ItemStack.EMPTY;
                                                                                                                                                    }
                                                                                                                                                    if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"farmersdelight:tools/knives")))) break block73;
                                                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                                                        LivingEntity _livEntxxxx = (LivingEntity)sourceentity;
                                                                                                                                                        itemStack2 = _livEntxxxx.getMainHandItem();
                                                                                                                                                    } else {
                                                                                                                                                        itemStack2 = ItemStack.EMPTY;
                                                                                                                                                    }
                                                                                                                                                    if (itemStack2.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block73;
                                                                                                                                                    if (sourceentity instanceof LivingEntity) {
                                                                                                                                                        LivingEntity _livEntxxx = (LivingEntity)sourceentity;
                                                                                                                                                        itemStack = _livEntxxx.getMainHandItem();
                                                                                                                                                    } else {
                                                                                                                                                        itemStack = ItemStack.EMPTY;
                                                                                                                                                    }
                                                                                                                                                    if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block59;
                                                                                                                                                }
                                                                                                                                                if (!(catEntity3 = (Cat)entity).getVariant().toString().contains("tabby")) break block74;
                                                                                                                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/tabby_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                    entityToSpawn.setPickUpDelay(10);
                                                                                                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                                }
                                                                                                                                                break block59;
                                                                                                                                            }
                                                                                                                                            if (!catEntity3.getVariant().toString().contains("black") || catEntity3.getVariant().toString().contains("all_black")) break block75;
                                                                                                                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                            }
                                                                                                                                            break block59;
                                                                                                                                        }
                                                                                                                                        if (!catEntity3.getVariant().toString().contains("red")) break block76;
                                                                                                                                        if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/red_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                                                                                            ServerLevel _level = (ServerLevel)world;
                                                                                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                            entityToSpawn.setPickUpDelay(10);
                                                                                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                        }
                                                                                                                                        break block59;
                                                                                                                                    }
                                                                                                                                    if (!catEntity3.getVariant().toString().contains("siamese")) break block77;
                                                                                                                                    if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/siamese_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                                                                                        ServerLevel _level = (ServerLevel)world;
                                                                                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                        entityToSpawn.setPickUpDelay(10);
                                                                                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                    }
                                                                                                                                    break block59;
                                                                                                                                }
                                                                                                                                if (!catEntity3.getVariant().toString().contains("british_shorthair")) break block78;
                                                                                                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/bshorthair_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                    entityToSpawn.setPickUpDelay(10);
                                                                                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                                }
                                                                                                                                break block59;
                                                                                                                            }
                                                                                                                            if (!catEntity3.getVariant().toString().contains("calico")) break block79;
                                                                                                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/calico_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                            }
                                                                                                                            break block59;
                                                                                                                        }
                                                                                                                        if (!catEntity3.getVariant().toString().contains("persian")) break block80;
                                                                                                                        if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/persian_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                                                                            ServerLevel _level = (ServerLevel)world;
                                                                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                            entityToSpawn.setPickUpDelay(10);
                                                                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                        }
                                                                                                                        break block59;
                                                                                                                    }
                                                                                                                    if (!catEntity3.getVariant().toString().contains("ragdoll")) break block81;
                                                                                                                    if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/ragdoll_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                                                                        ServerLevel _level = (ServerLevel)world;
                                                                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                        entityToSpawn.setPickUpDelay(10);
                                                                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                    }
                                                                                                                    break block59;
                                                                                                                }
                                                                                                                if (!catEntity3.getVariant().toString().contains("white")) break block82;
                                                                                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/white_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                    entityToSpawn.setPickUpDelay(10);
                                                                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                                }
                                                                                                                break block59;
                                                                                                            }
                                                                                                            if (!catEntity3.getVariant().toString().contains("jellie")) break block83;
                                                                                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/jellie_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                            }
                                                                                                            break block59;
                                                                                                        }
                                                                                                        if (!catEntity3.getVariant().toString().contains("all_black") || world.isClientSide() || world.getServer() == null) break block59;
                                                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/all_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                                                            ServerLevel _level = (ServerLevel)world;
                                                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                            entityToSpawn.setPickUpDelay(10);
                                                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                        }
                                                                                                        break block59;
                                                                                                    }
                                                                                                    if (ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block84;
                                                                                                    Cat _livEntxxxxxx = (Cat)entity;
                                                                                                    break block59;
                                                                                                }
                                                                                                if (!(sourceentity instanceof Animal)) break block85;
                                                                                                if (!ButcheryconfigConfiguration.CAT_CARCASS.get().booleanValue()) break block59;
                                                                                                catEntity2 = (Cat)entity;
                                                                                                if (!catEntity2.getVariant().toString().contains("tabby")) break block86;
                                                                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/tabby_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                    entityToSpawn.setPickUpDelay(10);
                                                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                }
                                                                                                break block59;
                                                                                            }
                                                                                            if (!catEntity2.getVariant().toString().contains("black") || catEntity2.getVariant().toString().contains("all_black")) break block87;
                                                                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                                            }
                                                                                            break block59;
                                                                                        }
                                                                                        if (!catEntity2.getVariant().toString().contains("red")) break block88;
                                                                                        if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/red_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                                            ServerLevel _level = (ServerLevel)world;
                                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                            entityToSpawn.setPickUpDelay(10);
                                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                                        }
                                                                                        break block59;
                                                                                    }
                                                                                    if (!catEntity2.getVariant().toString().contains("siamese")) break block89;
                                                                                    if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/siamese_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                                        ServerLevel _level = (ServerLevel)world;
                                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                        entityToSpawn.setPickUpDelay(10);
                                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                                    }
                                                                                    break block59;
                                                                                }
                                                                                if (!catEntity2.getVariant().toString().contains("british_shorthair")) break block90;
                                                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/bshorthair_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                                    ServerLevel _level = (ServerLevel)world;
                                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                    entityToSpawn.setPickUpDelay(10);
                                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                                }
                                                                                break block59;
                                                                            }
                                                                            if (!catEntity2.getVariant().toString().contains("calico")) break block91;
                                                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/calico_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                                if (!(world instanceof ServerLevel)) continue;
                                                                                ServerLevel _level = (ServerLevel)world;
                                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                                entityToSpawn.setPickUpDelay(10);
                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                            }
                                                                            break block59;
                                                                        }
                                                                        if (!catEntity2.getVariant().toString().contains("persian")) break block92;
                                                                        if (world.isClientSide() || world.getServer() == null) break block59;
                                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/persian_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                            if (!(world instanceof ServerLevel)) continue;
                                                                            ServerLevel _level = (ServerLevel)world;
                                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                            entityToSpawn.setPickUpDelay(10);
                                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                                        }
                                                                        break block59;
                                                                    }
                                                                    if (!catEntity2.getVariant().toString().contains("ragdoll")) break block93;
                                                                    if (world.isClientSide() || world.getServer() == null) break block59;
                                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/ragdoll_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                        if (!(world instanceof ServerLevel)) continue;
                                                                        ServerLevel _level = (ServerLevel)world;
                                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                        entityToSpawn.setPickUpDelay(10);
                                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                                    }
                                                                    break block59;
                                                                }
                                                                if (!catEntity2.getVariant().toString().contains("white")) break block94;
                                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/white_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                    if (!(world instanceof ServerLevel)) continue;
                                                                    ServerLevel _level = (ServerLevel)world;
                                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                    entityToSpawn.setPickUpDelay(10);
                                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                                }
                                                                break block59;
                                                            }
                                                            if (!catEntity2.getVariant().toString().contains("jellie")) break block95;
                                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/jellie_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                                if (!(world instanceof ServerLevel)) continue;
                                                                ServerLevel _level = (ServerLevel)world;
                                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                                entityToSpawn.setPickUpDelay(10);
                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                            }
                                                            break block59;
                                                        }
                                                        if (!catEntity2.getVariant().toString().contains("all_black") || world.isClientSide() || world.getServer() == null) break block59;
                                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/all_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                            if (!(world instanceof ServerLevel)) continue;
                                                            ServerLevel _level = (ServerLevel)world;
                                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                            entityToSpawn.setPickUpDelay(10);
                                                            _level.addFreshEntity((Entity)entityToSpawn);
                                                        }
                                                        break block59;
                                                    }
                                                    if (!(sourceentity instanceof Monster) || !ButcheryconfigConfiguration.CAT_CARCASS.get().booleanValue()) break block59;
                                                    catEntity = (Cat)entity;
                                                    if (!catEntity.getVariant().toString().contains("tabby")) break block96;
                                                    if (world.isClientSide() || world.getServer() == null) break block59;
                                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/tabby_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                        if (!(world instanceof ServerLevel)) continue;
                                                        ServerLevel _level = (ServerLevel)world;
                                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                        entityToSpawn.setPickUpDelay(10);
                                                        _level.addFreshEntity((Entity)entityToSpawn);
                                                    }
                                                    break block59;
                                                }
                                                if (!catEntity.getVariant().toString().contains("black") || catEntity.getVariant().toString().contains("all_black")) break block97;
                                                if (world.isClientSide() || world.getServer() == null) break block59;
                                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                    if (!(world instanceof ServerLevel)) continue;
                                                    ServerLevel _level = (ServerLevel)world;
                                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                    entityToSpawn.setPickUpDelay(10);
                                                    _level.addFreshEntity((Entity)entityToSpawn);
                                                }
                                                break block59;
                                            }
                                            if (!catEntity.getVariant().toString().contains("red")) break block98;
                                            if (world.isClientSide() || world.getServer() == null) break block59;
                                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/red_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                                if (!(world instanceof ServerLevel)) continue;
                                                ServerLevel _level = (ServerLevel)world;
                                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                                entityToSpawn.setPickUpDelay(10);
                                                _level.addFreshEntity((Entity)entityToSpawn);
                                            }
                                            break block59;
                                        }
                                        if (!catEntity.getVariant().toString().contains("siamese")) break block99;
                                        if (world.isClientSide() || world.getServer() == null) break block59;
                                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/siamese_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                            if (!(world instanceof ServerLevel)) continue;
                                            ServerLevel _level = (ServerLevel)world;
                                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                            entityToSpawn.setPickUpDelay(10);
                                            _level.addFreshEntity((Entity)entityToSpawn);
                                        }
                                        break block59;
                                    }
                                    if (!catEntity.getVariant().toString().contains("british_shorthair")) break block100;
                                    if (world.isClientSide() || world.getServer() == null) break block59;
                                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/bshorthair_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                        if (!(world instanceof ServerLevel)) continue;
                                        ServerLevel _level = (ServerLevel)world;
                                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                        entityToSpawn.setPickUpDelay(10);
                                        _level.addFreshEntity((Entity)entityToSpawn);
                                    }
                                    break block59;
                                }
                                if (!catEntity.getVariant().toString().contains("calico")) break block101;
                                if (world.isClientSide() || world.getServer() == null) break block59;
                                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/calico_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                    if (!(world instanceof ServerLevel)) continue;
                                    ServerLevel _level = (ServerLevel)world;
                                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity((Entity)entityToSpawn);
                                }
                                break block59;
                            }
                            if (!catEntity.getVariant().toString().contains("persian")) break block102;
                            if (world.isClientSide() || world.getServer() == null) break block59;
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/persian_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                            break block59;
                        }
                        if (!catEntity.getVariant().toString().contains("ragdoll")) break block103;
                        if (world.isClientSide() || world.getServer() == null) break block59;
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/ragdoll_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                        break block59;
                    }
                    if (!catEntity.getVariant().toString().contains("white")) break block104;
                    if (world.isClientSide() || world.getServer() == null) break block59;
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/white_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    break block59;
                }
                if (!catEntity.getVariant().toString().contains("jellie")) break block105;
                if (world.isClientSide() || world.getServer() == null) break block59;
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/jellie_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                    if (!(world instanceof ServerLevel)) continue;
                    ServerLevel _level = (ServerLevel)world;
                    ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
                break block59;
            }
            if (catEntity.getVariant().toString().contains("all_black") && !world.isClientSide() && world.getServer() != null) {
                for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/all_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
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

