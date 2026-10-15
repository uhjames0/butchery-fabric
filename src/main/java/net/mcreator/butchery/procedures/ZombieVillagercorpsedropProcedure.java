package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.BuiltInRegistries;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: ZombieVillagercorpsedropProcedure.class */
public class ZombieVillagercorpsedropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        ItemStack mainHandItem;
        ItemStack mainHandItem2;
        ItemStack mainHandItem3;
        ItemStack mainHandItem4;
        ItemStack mainHandItem5;
        ItemStack mainHandItem6;
        ItemStack mainHandItem7;
        if (entity != null && sourceentity != null) {
            if (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString().equals("minecraft:zombie_villager") || entity.getType().builtInRegistryHolder().is(TagKey.create(Registries.ENTITY_TYPE, Identifier.parse("forge:zombie_villager"))) || entity.getType().builtInRegistryHolder().is(TagKey.create(Registries.ENTITY_TYPE, Identifier.parse("c:zombie_villager")))) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt3 = (LivingEntity) entity;
                    if (_livEnt3.isBaby()) {
                        return;
                    }
                }
                if (((Boolean) ButcheryconfigConfiguration.ZOMBIE_VILLAGER_CORPSE.get()).booleanValue()) {
                    if (((Boolean) ButcheryconfigConfiguration.SPECIFIC_TOOLS.get()).booleanValue()) {
                        if (!((Boolean) ButcheryconfigConfiguration.FD_CARCASS_DROP.get()).booleanValue()) {
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntxx = (LivingEntity) sourceentity;
                                mainHandItem5 = _livEntxx.getMainHandItem();
                            } else {
                                mainHandItem5 = ItemStack.EMPTY;
                            }
                            if (!mainHandItem5.is(TagKey.create(Registries.ITEM, Identifier.parse("butchery:cleaver")))) {
                                if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEntx = (LivingEntity) sourceentity;
                                    mainHandItem6 = _livEntx.getMainHandItem();
                                } else {
                                    mainHandItem6 = ItemStack.EMPTY;
                                }
                                if (mainHandItem6.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("butchery:butcherstouch")))) == 0) {
                                    if (sourceentity instanceof LivingEntity) {
                                        LivingEntity _livEnt = (LivingEntity) sourceentity;
                                        mainHandItem7 = _livEnt.getMainHandItem();
                                    } else {
                                        mainHandItem7 = ItemStack.EMPTY;
                                    }
                                    if (mainHandItem7.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("butchery:hunter")))) == 0) {
                                        return;
                                    }
                                }
                            }
                            if (world instanceof ServerLevel) {
                                ServerLevel _level = (ServerLevel) world;
                                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.ZOMBIE_VILLAGER_CORPSE.get()));
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity(entityToSpawn);
                            }
                            ButcheryMod.queueServerWork(1, () -> {
                                if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                                    entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:rotten_flesh\"}},distance=..20]");
                                }
                            });
                            return;
                        }
                        if (((Boolean) ButcheryconfigConfiguration.FD_CARCASS_DROP.get()).booleanValue()) {
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntxxx = (LivingEntity) sourceentity;
                                mainHandItem = _livEntxxx.getMainHandItem();
                            } else {
                                mainHandItem = ItemStack.EMPTY;
                            }
                            if (!mainHandItem.is(TagKey.create(Registries.ITEM, Identifier.parse("butchery:cleaver")))) {
                                if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEntxx2 = (LivingEntity) sourceentity;
                                    mainHandItem2 = _livEntxx2.getMainHandItem();
                                } else {
                                    mainHandItem2 = ItemStack.EMPTY;
                                }
                                if (!mainHandItem2.is(TagKey.create(Registries.ITEM, Identifier.parse("farmersdelight:tools/knives")))) {
                                    if (sourceentity instanceof LivingEntity) {
                                        LivingEntity _livEntx2 = (LivingEntity) sourceentity;
                                        mainHandItem3 = _livEntx2.getMainHandItem();
                                    } else {
                                        mainHandItem3 = ItemStack.EMPTY;
                                    }
                                    if (mainHandItem3.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("butchery:butcherstouch")))) == 0) {
                                        if (sourceentity instanceof LivingEntity) {
                                            LivingEntity _livEnt2 = (LivingEntity) sourceentity;
                                            mainHandItem4 = _livEnt2.getMainHandItem();
                                        } else {
                                            mainHandItem4 = ItemStack.EMPTY;
                                        }
                                        if (mainHandItem4.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("butchery:hunter")))) == 0) {
                                            return;
                                        }
                                    }
                                }
                            }
                            if (world instanceof ServerLevel) {
                                ServerLevel _level2 = (ServerLevel) world;
                                ItemEntity entityToSpawn2 = new ItemEntity(_level2, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.ZOMBIE_VILLAGER_CORPSE.get()));
                                entityToSpawn2.setPickUpDelay(10);
                                _level2.addFreshEntity(entityToSpawn2);
                            }
                            ButcheryMod.queueServerWork(1, () -> {
                                if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                                    entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:rotten_flesh\"}},distance=..20]");
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (!((Boolean) ButcheryconfigConfiguration.SPECIFIC_TOOLS.get()).booleanValue()) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level3 = (ServerLevel) world;
                            ItemEntity entityToSpawn3 = new ItemEntity(_level3, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.ZOMBIE_VILLAGER_CORPSE.get()));
                            entityToSpawn3.setPickUpDelay(10);
                            _level3.addFreshEntity(entityToSpawn3);
                        }
                        ButcheryMod.queueServerWork(1, () -> {
                            if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                                entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:rotten_flesh\"}},distance=..20]");
                            }
                        });
                        return;
                    }
                    if (sourceentity instanceof Animal) {
                        if (((Boolean) ButcheryconfigConfiguration.ZOMBIE_VILLAGER_CORPSE.get()).booleanValue()) {
                            if (world instanceof ServerLevel) {
                                ServerLevel _level4 = (ServerLevel) world;
                                ItemEntity entityToSpawn4 = new ItemEntity(_level4, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.ZOMBIE_VILLAGER_CORPSE.get()));
                                entityToSpawn4.setPickUpDelay(10);
                                _level4.addFreshEntity(entityToSpawn4);
                            }
                            ButcheryMod.queueServerWork(1, () -> {
                                if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                                    entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:rotten_flesh\"}},distance=..20]");
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((sourceentity instanceof Monster) && ((Boolean) ButcheryconfigConfiguration.ZOMBIE_VILLAGER_CORPSE.get()).booleanValue()) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level5 = (ServerLevel) world;
                            ItemEntity entityToSpawn5 = new ItemEntity(_level5, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.ZOMBIE_VILLAGER_CORPSE.get()));
                            entityToSpawn5.setPickUpDelay(10);
                            _level5.addFreshEntity(entityToSpawn5);
                        }
                        ButcheryMod.queueServerWork(1, () -> {
                            if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                                entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/kill @e[type=item,nbt={Item:{id:\"minecraft:rotten_flesh\"}},distance=..20]");
                            }
                        });
                    }
                }
            }
        }
    }
}
