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
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class HorseblackdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            HorseblackdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        HorseblackdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block85: {
            block86: {
                Horse horseEntity;
                block87: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    ItemStack itemStack3;
                    LivingEntity _livEnt3;
                    if (entity == null || sourceentity == null || !(entity instanceof Horse) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:horse"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:horse"))) || entity instanceof LivingEntity && (_livEnt3 = (LivingEntity)entity).isBaby() || !ButcheryconfigConfiguration.HORSE_CARCASS.get().booleanValue()) break block85;
                    if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block86;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)sourceentity;
                        itemStack3 = _livEntxx.getMainHandItem();
                    } else {
                        itemStack3 = ItemStack.EMPTY;
                    }
                    if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) break block87;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                        itemStack2 = _livEntx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) break block87;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        itemStack = _livEnt.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) == 0) break block85;
                }
                if ((horseEntity = (Horse)entity).getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("NONE")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE") && !horseEntity.getMarkings().toString().contains("WHITE_DOTS") && !horseEntity.getMarkings().toString().contains("WHITE_FIELD")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE_FIELD")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE_DOTS")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("BLACK_DOTS") && !world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawnx = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawnx.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawnx);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                        entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                    }
                });
                break block85;
            }
            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) {
                Horse horseEntity = (Horse)entity;
                if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("NONE")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE") && !horseEntity.getMarkings().toString().contains("WHITE_DOTS") && !horseEntity.getMarkings().toString().contains("WHITE_FIELD")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE_FIELD")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE_DOTS")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("BLACK_DOTS") && !world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                        entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                    }
                });
            } else if (sourceentity instanceof Animal) {
                if (ButcheryconfigConfiguration.HORSE_CARCASS.get().booleanValue()) {
                    Horse horseEntity = (Horse)entity;
                    if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("NONE")) {
                        if (!world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                    } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE") && !horseEntity.getMarkings().toString().contains("WHITE_DOTS") && !horseEntity.getMarkings().toString().contains("WHITE_FIELD")) {
                        if (!world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                    } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE_FIELD")) {
                        if (!world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                    } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE_DOTS")) {
                        if (!world.isClientSide() && world.getServer() != null) {
                            for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                                if (!(world instanceof ServerLevel)) continue;
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                    } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("BLACK_DOTS") && !world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                    ButcheryMod.queueServerWork(1, () -> {
                        if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                            entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                        }
                    });
                }
            } else if (sourceentity instanceof Monster && ButcheryconfigConfiguration.HORSE_CARCASS.get().booleanValue()) {
                Horse horseEntity = (Horse)entity;
                if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("NONE")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE") && !horseEntity.getMarkings().toString().contains("WHITE_DOTS") && !horseEntity.getMarkings().toString().contains("WHITE_FIELD")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE_FIELD")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("WHITE_DOTS")) {
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _level = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                } else if (horseEntity.getVariant().toString().contains("BLACK") && horseEntity.getMarkings().toString().contains("BLACK_DOTS") && !world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)"butchery:blocks/regular_black_carcass_loot"))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                        if (!(world instanceof ServerLevel)) continue;
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                }
                ButcheryMod.queueServerWork(1, () -> {
                    if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                        entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:leather\"}},distance=..20]");
                    }
                });
            }
        }
    }
}

