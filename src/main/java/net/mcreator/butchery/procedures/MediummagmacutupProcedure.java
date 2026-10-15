package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: MediummagmacutupProcedure.class */
public class MediummagmacutupProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ItemStack mainHandItem;
        ItemStack mainHandItem2;
        ItemStack mainHandItem3;
        ItemStack mainHandItem4;
        ItemStack mainHandItem5;
        ItemStack mainHandItem6;
        ItemStack mainHandItem7;
        ItemStack mainHandItem8;
        ItemStack mainHandItem9;
        if (entity != null) {
            if (entity instanceof LivingEntity) {
                LivingEntity _livEntx = (LivingEntity) entity;
                mainHandItem = _livEntx.getMainHandItem();
            } else {
                mainHandItem = ItemStack.EMPTY;
            }
            if (!mainHandItem.is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity) entity;
                    mainHandItem9 = _livEnt.getMainHandItem();
                } else {
                    mainHandItem9 = ItemStack.EMPTY;
                }
                if (!mainHandItem9.is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) {
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.MEDIUM_MAGMA_CUBE_CARCASS.get()) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel) world;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity) entity;
                        mainHandItem8 = _livEntxx.getMainHandItem();
                    } else {
                        mainHandItem8 = ItemStack.EMPTY;
                    }
                    mainHandItem8.hurtAndBreak(1, _level, (ServerPlayer) null, _stkprov -> {
                    });
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity) entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.MEDIUM_MAGMA_CUBE_CARCASS.get()).defaultBlockState()));
                if (world instanceof Level) {
                    Level _level2 = (Level) world;
                    if (!_level2.isClientSide()) {
                        _level2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                    } else {
                        _level2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                    }
                }
                if (world instanceof Level) {
                    Level _levelx = (Level) world;
                    if (!_levelx.isClientSide()) {
                        _levelx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                    } else {
                        _levelx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                    }
                }
                if (!world.isClientSide() && world.getServer() != null) {
                    ObjectListIterator var25 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/medium_magma_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                    while (var25.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack) var25.next();
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxx = (ServerLevel) world;
                            ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _levelxx.addFreshEntity(entityToSpawn);
                        }
                    }
                }
                if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxx = (LivingEntity) entity;
                        mainHandItem2 = _livEntxxx.getMainHandItem();
                    } else {
                        mainHandItem2 = ItemStack.EMPTY;
                    }
                    if (mainHandItem2.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx2 = (LivingEntity) entity;
                            mainHandItem7 = _livEntxx2.getMainHandItem();
                        } else {
                            mainHandItem7 = ItemStack.EMPTY;
                        }
                        if (mainHandItem7.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                            for (int index0 = 0; index0 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index0++) {
                                if (!world.isClientSide() && world.getServer() != null) {
                                    ObjectListIterator var34 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/medium_magma_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                    while (var34.hasNext()) {
                                        ItemStack itemstackiterator2 = (ItemStack) var34.next();
                                        if (world instanceof ServerLevel) {
                                            ServerLevel _levelxx2 = (ServerLevel) world;
                                            ItemEntity entityToSpawn2 = new ItemEntity(_levelxx2, x, y, z, itemstackiterator2);
                                            entityToSpawn2.setPickUpDelay(10);
                                            _levelxx2.addFreshEntity(entityToSpawn2);
                                        }
                                    }
                                }
                            }
                            return;
                        }
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxx2 = (LivingEntity) entity;
                        mainHandItem3 = _livEntxxx2.getMainHandItem();
                    } else {
                        mainHandItem3 = ItemStack.EMPTY;
                    }
                    if (mainHandItem3.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx3 = (LivingEntity) entity;
                            mainHandItem6 = _livEntxx3.getMainHandItem();
                        } else {
                            mainHandItem6 = ItemStack.EMPTY;
                        }
                        if (mainHandItem6.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                            for (int index1 = 0; index1 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index1++) {
                                if (!world.isClientSide() && world.getServer() != null) {
                                    ObjectListIterator var33 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/medium_magma_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                    while (var33.hasNext()) {
                                        ItemStack itemstackiterator3 = (ItemStack) var33.next();
                                        if (world instanceof ServerLevel) {
                                            ServerLevel _levelxx3 = (ServerLevel) world;
                                            ItemEntity entityToSpawn3 = new ItemEntity(_levelxx3, x, y, z, itemstackiterator3);
                                            entityToSpawn3.setPickUpDelay(10);
                                            _levelxx3.addFreshEntity(entityToSpawn3);
                                        }
                                    }
                                }
                            }
                            return;
                        }
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxx3 = (LivingEntity) entity;
                        mainHandItem4 = _livEntxxx3.getMainHandItem();
                    } else {
                        mainHandItem4 = ItemStack.EMPTY;
                    }
                    if (mainHandItem4.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx4 = (LivingEntity) entity;
                            mainHandItem5 = _livEntxx4.getMainHandItem();
                        } else {
                            mainHandItem5 = ItemStack.EMPTY;
                        }
                        if (mainHandItem5.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                            for (int index2 = 0; index2 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index2++) {
                                if (!world.isClientSide() && world.getServer() != null) {
                                    ObjectListIterator var18 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/medium_magma_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                    while (var18.hasNext()) {
                                        ItemStack itemstackiterator4 = (ItemStack) var18.next();
                                        if (world instanceof ServerLevel) {
                                            ServerLevel _levelxx4 = (ServerLevel) world;
                                            ItemEntity entityToSpawn4 = new ItemEntity(_levelxx4, x, y, z, itemstackiterator4);
                                            entityToSpawn4.setPickUpDelay(10);
                                            _levelxx4.addFreshEntity(entityToSpawn4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
