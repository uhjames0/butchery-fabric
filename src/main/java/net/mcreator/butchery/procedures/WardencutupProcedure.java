package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.shim.ButcheryPersistentData;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

/* JADX INFO: loaded from: WardencutupProcedure.class */
public class WardencutupProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        ItemStack mainHandItem;
        ItemStack mainHandItem2;
        ItemStack mainHandItem3;
        ItemStack mainHandItem4;
        ItemStack mainHandItem5;
        ItemStack mainHandItem6;
        ItemStack mainHandItem7;
        ItemStack mainHandItem8;
        ItemStack mainHandItem9;
        ItemStack mainHandItem10;
        ItemStack mainHandItem11;
        ItemStack mainHandItem12;
        ItemStack mainHandItem13;
        ItemStack mainHandItem14;
        ItemStack mainHandItem15;
        ItemStack mainHandItem16;
        ItemStack mainHandItem17;
        ItemStack mainHandItem18;
        ItemStack mainHandItem19;
        ItemStack mainHandItem20;
        ItemStack mainHandItem21;
        ItemStack mainHandItem22;
        ItemStack mainHandItem23;
        ItemStack mainHandItem24;
        ItemStack mainHandItem25;
        ItemStack mainHandItem26;
        ItemStack mainHandItem27;
        ItemStack mainHandItem28;
        ItemStack mainHandItem29;
        ItemStack mainHandItem30;
        if (entity != null) {
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity) entity;
                mainHandItem = _livEnt.getMainHandItem();
            } else {
                mainHandItem = ItemStack.EMPTY;
            }
            if (mainHandItem.is(TagKey.create(Registries.ITEM, Identifier.parse("butchery:boss_tool")))) {
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 0.0d) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntx = (LivingEntity) entity;
                            mainHandItem30 = _livEntx.getMainHandItem();
                        } else {
                            mainHandItem30 = ItemStack.EMPTY;
                        }
                        mainHandItem30.hurtAndBreak(5, _level, (ServerPlayer) null, _stkprov -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity) entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                            ButcheryPersistentData.of(_blockEntity).putDouble("butcherStage", 1.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                    }
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SCULK.defaultBlockState()));
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
                        ObjectListIterator var24 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/wither_head_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var24.hasNext()) {
                            ItemStack itemstackiterator = (ItemStack) var24.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxx = (ServerLevel) world;
                                ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _levelxx.addFreshEntity(entityToSpawn);
                            }
                        }
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 1.0d) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx2 = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntx2 = (LivingEntity) entity;
                            mainHandItem29 = _livEntx2.getMainHandItem();
                        } else {
                            mainHandItem29 = ItemStack.EMPTY;
                        }
                        mainHandItem29.hurtAndBreak(5, _levelxx2, (ServerPlayer) null, _stkprov2 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity2 = (LivingEntity) entity;
                        _entity2.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bpx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                        BlockState _bsx = world.getBlockState(_bpx);
                        if (_blockEntityx != null) {
                            ButcheryPersistentData.of(_blockEntityx).putDouble("butcherStage", 2.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                        }
                    }
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SCULK.defaultBlockState()));
                    if (world instanceof Level) {
                        Level _levelxx3 = (Level) world;
                        if (!_levelxx3.isClientSide()) {
                            _levelxx3.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxx3.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (world instanceof Level) {
                        Level _levelxxx = (Level) world;
                        if (!_levelxxx.isClientSide()) {
                            _levelxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var30 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var30.hasNext()) {
                            ItemStack itemstackiterator2 = (ItemStack) var30.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxxxx = (ServerLevel) world;
                                ItemEntity entityToSpawn2 = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator2);
                                entityToSpawn2.setPickUpDelay(10);
                                _levelxxxx.addFreshEntity(entityToSpawn2);
                            }
                        }
                    }
                    if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx = (LivingEntity) entity;
                            mainHandItem23 = _livEntxx.getMainHandItem();
                        } else {
                            mainHandItem23 = ItemStack.EMPTY;
                        }
                        if (mainHandItem23.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx3 = (LivingEntity) entity;
                                mainHandItem28 = _livEntx3.getMainHandItem();
                            } else {
                                mainHandItem28 = ItemStack.EMPTY;
                            }
                            if (mainHandItem28.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                for (int index0 = 0; index0 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index0++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var111 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var111.hasNext()) {
                                            ItemStack itemstackiterator3 = (ItemStack) var111.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxx2 = (ServerLevel) world;
                                                ItemEntity entityToSpawn3 = new ItemEntity(_levelxxxx2, x, y, z, itemstackiterator3);
                                                entityToSpawn3.setPickUpDelay(10);
                                                _levelxxxx2.addFreshEntity(entityToSpawn3);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx2 = (LivingEntity) entity;
                            mainHandItem24 = _livEntxx2.getMainHandItem();
                        } else {
                            mainHandItem24 = ItemStack.EMPTY;
                        }
                        if (mainHandItem24.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx4 = (LivingEntity) entity;
                                mainHandItem27 = _livEntx4.getMainHandItem();
                            } else {
                                mainHandItem27 = ItemStack.EMPTY;
                            }
                            if (mainHandItem27.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                for (int index1 = 0; index1 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index1++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var110 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var110.hasNext()) {
                                            ItemStack itemstackiterator4 = (ItemStack) var110.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxx3 = (ServerLevel) world;
                                                ItemEntity entityToSpawn4 = new ItemEntity(_levelxxxx3, x, y, z, itemstackiterator4);
                                                entityToSpawn4.setPickUpDelay(10);
                                                _levelxxxx3.addFreshEntity(entityToSpawn4);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx3 = (LivingEntity) entity;
                            mainHandItem25 = _livEntxx3.getMainHandItem();
                        } else {
                            mainHandItem25 = ItemStack.EMPTY;
                        }
                        if (mainHandItem25.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx5 = (LivingEntity) entity;
                                mainHandItem26 = _livEntx5.getMainHandItem();
                            } else {
                                mainHandItem26 = ItemStack.EMPTY;
                            }
                            if (mainHandItem26.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                for (int index2 = 0; index2 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index2++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var16 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var16.hasNext()) {
                                            ItemStack itemstackiterator5 = (ItemStack) var16.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxx4 = (ServerLevel) world;
                                                ItemEntity entityToSpawn5 = new ItemEntity(_levelxxxx4, x, y, z, itemstackiterator5);
                                                entityToSpawn5.setPickUpDelay(10);
                                                _levelxxxx4.addFreshEntity(entityToSpawn5);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 2.0d) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxx5 = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntx6 = (LivingEntity) entity;
                            mainHandItem22 = _livEntx6.getMainHandItem();
                        } else {
                            mainHandItem22 = ItemStack.EMPTY;
                        }
                        mainHandItem22.hurtAndBreak(5, _levelxxxx5, (ServerPlayer) null, _stkprov3 -> {
                        });
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bpxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                        BlockState _bsxx = world.getBlockState(_bpxx);
                        if (_blockEntityxx != null) {
                            ButcheryPersistentData.of(_blockEntityxx).putDouble("butcherStage", 3.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                        }
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity3 = (LivingEntity) entity;
                        _entity3.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SCULK.defaultBlockState()));
                    if (world instanceof Level) {
                        Level _levelxxxx6 = (Level) world;
                        if (!_levelxxxx6.isClientSide()) {
                            _levelxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxx = (Level) world;
                        if (!_levelxxxxx.isClientSide()) {
                            _levelxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var37 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var37.hasNext()) {
                            ItemStack itemstackiterator6 = (ItemStack) var37.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxxxxxx = (ServerLevel) world;
                                ItemEntity entityToSpawn6 = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator6);
                                entityToSpawn6.setPickUpDelay(10);
                                _levelxxxxxx.addFreshEntity(entityToSpawn6);
                            }
                        }
                    }
                    if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx4 = (LivingEntity) entity;
                            mainHandItem16 = _livEntxx4.getMainHandItem();
                        } else {
                            mainHandItem16 = ItemStack.EMPTY;
                        }
                        if (mainHandItem16.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx7 = (LivingEntity) entity;
                                mainHandItem21 = _livEntx7.getMainHandItem();
                            } else {
                                mainHandItem21 = ItemStack.EMPTY;
                            }
                            if (mainHandItem21.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                for (int index3 = 0; index3 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index3++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var114 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var114.hasNext()) {
                                            ItemStack itemstackiterator7 = (ItemStack) var114.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxx2 = (ServerLevel) world;
                                                ItemEntity entityToSpawn7 = new ItemEntity(_levelxxxxxx2, x, y, z, itemstackiterator7);
                                                entityToSpawn7.setPickUpDelay(10);
                                                _levelxxxxxx2.addFreshEntity(entityToSpawn7);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx5 = (LivingEntity) entity;
                            mainHandItem17 = _livEntxx5.getMainHandItem();
                        } else {
                            mainHandItem17 = ItemStack.EMPTY;
                        }
                        if (mainHandItem17.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx8 = (LivingEntity) entity;
                                mainHandItem20 = _livEntx8.getMainHandItem();
                            } else {
                                mainHandItem20 = ItemStack.EMPTY;
                            }
                            if (mainHandItem20.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                for (int index4 = 0; index4 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index4++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var113 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var113.hasNext()) {
                                            ItemStack itemstackiterator8 = (ItemStack) var113.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxx3 = (ServerLevel) world;
                                                ItemEntity entityToSpawn8 = new ItemEntity(_levelxxxxxx3, x, y, z, itemstackiterator8);
                                                entityToSpawn8.setPickUpDelay(10);
                                                _levelxxxxxx3.addFreshEntity(entityToSpawn8);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx6 = (LivingEntity) entity;
                            mainHandItem18 = _livEntxx6.getMainHandItem();
                        } else {
                            mainHandItem18 = ItemStack.EMPTY;
                        }
                        if (mainHandItem18.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx9 = (LivingEntity) entity;
                                mainHandItem19 = _livEntx9.getMainHandItem();
                            } else {
                                mainHandItem19 = ItemStack.EMPTY;
                            }
                            if (mainHandItem19.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                for (int index5 = 0; index5 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index5++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var112 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var112.hasNext()) {
                                            ItemStack itemstackiterator9 = (ItemStack) var112.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxx4 = (ServerLevel) world;
                                                ItemEntity entityToSpawn9 = new ItemEntity(_levelxxxxxx4, x, y, z, itemstackiterator9);
                                                entityToSpawn9.setPickUpDelay(10);
                                                _levelxxxxxx4.addFreshEntity(entityToSpawn9);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") != 3.0d) {
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 4.0d) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxx = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx10 = (LivingEntity) entity;
                                mainHandItem8 = _livEntx10.getMainHandItem();
                            } else {
                                mainHandItem8 = ItemStack.EMPTY;
                            }
                            mainHandItem8.hurtAndBreak(5, _levelxxxxxxxx, (ServerPlayer) null, _stkprov4 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity4 = (LivingEntity) entity;
                            _entity4.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SCULK.defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxx2 = (Level) world;
                            if (!_levelxxxxxxxx2.isClientSide()) {
                                _levelxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxx = (Level) world;
                            if (!_levelxxxxxxxxx.isClientSide()) {
                                _levelxxxxxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var50 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_4_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var50.hasNext()) {
                                ItemStack itemstackiterator10 = (ItemStack) var50.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn10 = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator10);
                                    entityToSpawn10.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawn10);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx7 = (LivingEntity) entity;
                                mainHandItem2 = _livEntxx7.getMainHandItem();
                            } else {
                                mainHandItem2 = ItemStack.EMPTY;
                            }
                            if (mainHandItem2.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntx11 = (LivingEntity) entity;
                                    mainHandItem7 = _livEntx11.getMainHandItem();
                                } else {
                                    mainHandItem7 = ItemStack.EMPTY;
                                }
                                if (mainHandItem7.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index9 = 0; index9 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index9++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var120 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_4_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var120.hasNext()) {
                                                ItemStack itemstackiterator11 = (ItemStack) var120.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn11 = new ItemEntity(_levelxxxxxxxxxx2, x, y, z, itemstackiterator11);
                                                    entityToSpawn11.setPickUpDelay(10);
                                                    _levelxxxxxxxxxx2.addFreshEntity(entityToSpawn11);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx8 = (LivingEntity) entity;
                                mainHandItem3 = _livEntxx8.getMainHandItem();
                            } else {
                                mainHandItem3 = ItemStack.EMPTY;
                            }
                            if (mainHandItem3.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntx12 = (LivingEntity) entity;
                                    mainHandItem6 = _livEntx12.getMainHandItem();
                                } else {
                                    mainHandItem6 = ItemStack.EMPTY;
                                }
                                if (mainHandItem6.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index10 = 0; index10 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index10++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var119 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_4_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var119.hasNext()) {
                                                ItemStack itemstackiterator12 = (ItemStack) var119.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn12 = new ItemEntity(_levelxxxxxxxxxx3, x, y, z, itemstackiterator12);
                                                    entityToSpawn12.setPickUpDelay(10);
                                                    _levelxxxxxxxxxx3.addFreshEntity(entityToSpawn12);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx9 = (LivingEntity) entity;
                                mainHandItem4 = _livEntxx9.getMainHandItem();
                            } else {
                                mainHandItem4 = ItemStack.EMPTY;
                            }
                            if (mainHandItem4.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntx13 = (LivingEntity) entity;
                                    mainHandItem5 = _livEntx13.getMainHandItem();
                                } else {
                                    mainHandItem5 = ItemStack.EMPTY;
                                }
                                if (mainHandItem5.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index11 = 0; index11 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index11++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var118 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_4_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var118.hasNext()) {
                                                ItemStack itemstackiterator13 = (ItemStack) var118.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn13 = new ItemEntity(_levelxxxxxxxxxx4, x, y, z, itemstackiterator13);
                                                    entityToSpawn13.setPickUpDelay(10);
                                                    _levelxxxxxxxxxx4.addFreshEntity(entityToSpawn13);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxxxxxx5 = (ServerLevel) world;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntx14 = (LivingEntity) entity;
                        mainHandItem15 = _livEntx14.getMainHandItem();
                    } else {
                        mainHandItem15 = ItemStack.EMPTY;
                    }
                    mainHandItem15.hurtAndBreak(5, _levelxxxxxx5, (ServerPlayer) null, _stkprov5 -> {
                    });
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity5 = (LivingEntity) entity;
                    _entity5.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxx = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                    BlockState _bsxxx = world.getBlockState(_bpxxx);
                    if (_blockEntityxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxx).putDouble("butcherStage", 4.0d);
                    }
                    if (world instanceof Level) {
                        ((Level) world).sendBlockUpdated(_bpxxx, _bsxxx, _bsxxx, 3);
                    }
                }
                world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SCULK.defaultBlockState()));
                if (world instanceof Level) {
                    Level _levelxxxxxx6 = (Level) world;
                    if (!_levelxxxxxx6.isClientSide()) {
                        _levelxxxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                    } else {
                        _levelxxxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                    }
                }
                if (world instanceof Level) {
                    Level _levelxxxxxxx = (Level) world;
                    if (!_levelxxxxxxx.isClientSide()) {
                        _levelxxxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                    } else {
                        _levelxxxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                    }
                }
                if (!world.isClientSide() && world.getServer() != null) {
                    ObjectListIterator var44 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                    while (var44.hasNext()) {
                        ItemStack itemstackiterator14 = (ItemStack) var44.next();
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxx3 = (ServerLevel) world;
                            ItemEntity entityToSpawn14 = new ItemEntity(_levelxxxxxxxx3, x, y, z, itemstackiterator14);
                            entityToSpawn14.setPickUpDelay(10);
                            _levelxxxxxxxx3.addFreshEntity(entityToSpawn14);
                        }
                    }
                }
                if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxx10 = (LivingEntity) entity;
                        mainHandItem9 = _livEntxx10.getMainHandItem();
                    } else {
                        mainHandItem9 = ItemStack.EMPTY;
                    }
                    if (mainHandItem9.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntx15 = (LivingEntity) entity;
                            mainHandItem14 = _livEntx15.getMainHandItem();
                        } else {
                            mainHandItem14 = ItemStack.EMPTY;
                        }
                        if (mainHandItem14.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                            for (int index6 = 0; index6 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index6++) {
                                if (!world.isClientSide() && world.getServer() != null) {
                                    ObjectListIterator var117 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                    while (var117.hasNext()) {
                                        ItemStack itemstackiterator15 = (ItemStack) var117.next();
                                        if (world instanceof ServerLevel) {
                                            ServerLevel _levelxxxxxxxx4 = (ServerLevel) world;
                                            ItemEntity entityToSpawn15 = new ItemEntity(_levelxxxxxxxx4, x, y, z, itemstackiterator15);
                                            entityToSpawn15.setPickUpDelay(10);
                                            _levelxxxxxxxx4.addFreshEntity(entityToSpawn15);
                                        }
                                    }
                                }
                            }
                            return;
                        }
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxx11 = (LivingEntity) entity;
                        mainHandItem10 = _livEntxx11.getMainHandItem();
                    } else {
                        mainHandItem10 = ItemStack.EMPTY;
                    }
                    if (mainHandItem10.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntx16 = (LivingEntity) entity;
                            mainHandItem13 = _livEntx16.getMainHandItem();
                        } else {
                            mainHandItem13 = ItemStack.EMPTY;
                        }
                        if (mainHandItem13.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                            for (int index7 = 0; index7 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index7++) {
                                if (!world.isClientSide() && world.getServer() != null) {
                                    ObjectListIterator var116 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                    while (var116.hasNext()) {
                                        ItemStack itemstackiterator16 = (ItemStack) var116.next();
                                        if (world instanceof ServerLevel) {
                                            ServerLevel _levelxxxxxxxx5 = (ServerLevel) world;
                                            ItemEntity entityToSpawn16 = new ItemEntity(_levelxxxxxxxx5, x, y, z, itemstackiterator16);
                                            entityToSpawn16.setPickUpDelay(10);
                                            _levelxxxxxxxx5.addFreshEntity(entityToSpawn16);
                                        }
                                    }
                                }
                            }
                            return;
                        }
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxx12 = (LivingEntity) entity;
                        mainHandItem11 = _livEntxx12.getMainHandItem();
                    } else {
                        mainHandItem11 = ItemStack.EMPTY;
                    }
                    if (mainHandItem11.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntx17 = (LivingEntity) entity;
                            mainHandItem12 = _livEntx17.getMainHandItem();
                        } else {
                            mainHandItem12 = ItemStack.EMPTY;
                        }
                        if (mainHandItem12.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                            for (int index8 = 0; index8 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index8++) {
                                if (!world.isClientSide() && world.getServer() != null) {
                                    ObjectListIterator var115 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/warden_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                    while (var115.hasNext()) {
                                        ItemStack itemstackiterator17 = (ItemStack) var115.next();
                                        if (world instanceof ServerLevel) {
                                            ServerLevel _levelxxxxxxxx6 = (ServerLevel) world;
                                            ItemEntity entityToSpawn17 = new ItemEntity(_levelxxxxxxxx6, x, y, z, itemstackiterator17);
                                            entityToSpawn17.setPickUpDelay(10);
                                            _levelxxxxxxxx6.addFreshEntity(entityToSpawn17);
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

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0d);
        }
        return -1.0d;
    }
}
