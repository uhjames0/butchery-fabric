package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: PlayercorpsedropProcedure.class */
public class PlayercorpsedropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        ItemStack mainHandItem;
        ItemStack mainHandItem2;
        if (entity != null && sourceentity != null) {
            if ((entity instanceof Player) || (entity instanceof ServerPlayer)) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt2 = (LivingEntity) entity;
                    if (_livEnt2.isBaby()) {
                        return;
                    }
                }
                if (((Boolean) ButcheryconfigConfiguration.PLAYER_CORPSE.get()).booleanValue()) {
                    if (((Boolean) ButcheryconfigConfiguration.SPECIFIC_TOOLS.get()).booleanValue()) {
                        if (sourceentity instanceof LivingEntity) {
                            LivingEntity _livEntxx = (LivingEntity) sourceentity;
                            mainHandItem = _livEntxx.getMainHandItem();
                        } else {
                            mainHandItem = ItemStack.EMPTY;
                        }
                        if (!mainHandItem.is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))) {
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEntx = (LivingEntity) sourceentity;
                                mainHandItem2 = _livEntx.getMainHandItem();
                            } else {
                                mainHandItem2 = ItemStack.EMPTY;
                            }
                            if (!mainHandItem2.is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) {
                                if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity) sourceentity;
                                    if (!_livEnt.getMainHandItem().getEnchantments().keySet().stream().anyMatch(holder -> {
                                        return ((Boolean) holder.unwrapKey().map(key -> {
                                            return Boolean.valueOf(key.identifier().equals(Identifier.fromNamespaceAndPath(ButcheryMod.MODID, "butcherstouch")));
                                        }).orElse(false)).booleanValue();
                                    })) {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator entityToSpawn = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/player_corpse_loot"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (entityToSpawn.hasNext()) {
                                ItemStack itemstackiterator = (ItemStack) entityToSpawn.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel) world;
                                    CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> {
                                        tag.putString("PlayerUUID", entity.getUUID().toString());
                                        tag.putString("PlayerName", entity.getName().getString());
                                    });
                                    itemstackiterator.set(DataComponents.CUSTOM_NAME, Component.literal(entity.getName().getString() + " Corpse").withStyle(style -> {
                                        return style.withItalic(false);
                                    }));
                                    ItemEntity entityToSpawnx = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawnx.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawnx);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    if (!((Boolean) ButcheryconfigConfiguration.SPECIFIC_TOOLS.get()).booleanValue()) {
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var18 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/player_corpse_loot"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var18.hasNext()) {
                                ItemStack itemstackiterator2 = (ItemStack) var18.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _level2 = (ServerLevel) world;
                                    CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator2, tag2 -> {
                                        tag2.putString("PlayerUUID", entity.getUUID().toString());
                                        tag2.putString("PlayerName", entity.getName().getString());
                                    });
                                    itemstackiterator2.set(DataComponents.CUSTOM_NAME, Component.literal(entity.getName().getString() + " Corpse").withStyle(style2 -> {
                                        return style2.withItalic(false);
                                    }));
                                    ItemEntity entityToSpawn2 = new ItemEntity(_level2, x, y, z, itemstackiterator2);
                                    entityToSpawn2.setPickUpDelay(10);
                                    _level2.addFreshEntity(entityToSpawn2);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    if (sourceentity instanceof Animal) {
                        if (((Boolean) ButcheryconfigConfiguration.PLAYER_CORPSE.get()).booleanValue() && !world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var19 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/player_corpse_loot"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var19.hasNext()) {
                                ItemStack itemstackiterator3 = (ItemStack) var19.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _level3 = (ServerLevel) world;
                                    CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator3, tag3 -> {
                                        tag3.putString("PlayerUUID", entity.getUUID().toString());
                                        tag3.putString("PlayerName", entity.getName().getString());
                                    });
                                    itemstackiterator3.set(DataComponents.CUSTOM_NAME, Component.literal(entity.getName().getString() + " Corpse").withStyle(style3 -> {
                                        return style3.withItalic(false);
                                    }));
                                    ItemEntity entityToSpawn3 = new ItemEntity(_level3, x, y, z, itemstackiterator3);
                                    entityToSpawn3.setPickUpDelay(10);
                                    _level3.addFreshEntity(entityToSpawn3);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    if ((sourceentity instanceof Monster) && ((Boolean) ButcheryconfigConfiguration.PLAYER_CORPSE.get()).booleanValue() && !world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var20 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/player_corpse_loot"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var20.hasNext()) {
                            ItemStack itemstackiterator4 = (ItemStack) var20.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _level4 = (ServerLevel) world;
                                CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator4, tag4 -> {
                                    tag4.putString("PlayerUUID", entity.getUUID().toString());
                                    tag4.putString("PlayerName", entity.getName().getString());
                                });
                                itemstackiterator4.set(DataComponents.CUSTOM_NAME, Component.literal(entity.getName().getString() + " Corpse").withStyle(style4 -> {
                                    return style4.withItalic(false);
                                }));
                                ItemEntity entityToSpawn4 = new ItemEntity(_level4, x, y, z, itemstackiterator4);
                                entityToSpawn4.setPickUpDelay(10);
                                _level4.addFreshEntity(entityToSpawn4);
                            }
                        }
                    }
                }
            }
        }
    }
}
