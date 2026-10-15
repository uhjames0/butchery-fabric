package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: HangingbatcutupProcedure.class */
public class HangingbatcutupProcedure {
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
        int iIntValue;
        ItemStack mainHandItem2;
        ItemStack mainHandItem3;
        ItemStack mainHandItem4;
        ItemStack mainHandItem5;
        ItemStack mainHandItem6;
        ItemStack mainHandItem7;
        ItemStack mainHandItem8;
        int iIntValue2;
        ItemStack mainHandItem9;
        ItemStack mainHandItem10;
        ItemStack mainHandItem11;
        ItemStack mainHandItem12;
        ItemStack mainHandItem13;
        ItemStack mainHandItem14;
        ItemStack mainHandItem15;
        int iIntValue3;
        ItemStack mainHandItem16;
        ItemStack mainHandItem17;
        ItemStack mainHandItem18;
        ItemStack mainHandItem19;
        ItemStack mainHandItem20;
        ItemStack mainHandItem21;
        ItemStack mainHandItem22;
        int iIntValue4;
        ItemStack mainHandItem23;
        ItemStack mainHandItem24;
        ItemStack mainHandItem25;
        int iIntValue5;
        ItemStack mainHandItem26;
        ItemStack mainHandItem27;
        ItemStack mainHandItem28;
        ItemStack mainHandItem29;
        ItemStack mainHandItem30;
        ItemStack mainHandItem31;
        ItemStack mainHandItem32;
        ItemStack mainHandItem33;
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
                    mainHandItem24 = _livEnt.getMainHandItem();
                } else {
                    mainHandItem24 = ItemStack.EMPTY;
                }
                if (!mainHandItem24.is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxx = (LivingEntity) entity;
                        mainHandItem25 = _livEntxxx.getMainHandItem();
                    } else {
                        mainHandItem25 = ItemStack.EMPTY;
                    }
                    if (!mainHandItem25.is(TagKey.create(Registries.ITEM, Identifier.parse("forge:skinning_knives")))) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx = (LivingEntity) entity;
                            mainHandItem33 = _livEntxx.getMainHandItem();
                        } else {
                            mainHandItem33 = ItemStack.EMPTY;
                        }
                        if (!mainHandItem33.is(TagKey.create(Registries.ITEM, Identifier.parse("c:skinning_knives")))) {
                            return;
                        }
                    }
                    if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained") && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BAT_CARCASS.get()) {
                        Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property instanceof IntegerProperty) {
                            Property<?> _getip173 = property;
                            iIntValue5 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip173)).intValue();
                        } else {
                            iIntValue5 = -1;
                        }
                        if (iIntValue5 == 2) {
                            if (world instanceof ServerLevel) {
                                ServerLevel _level = (ServerLevel) world;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxxxx = (LivingEntity) entity;
                                    mainHandItem32 = _livEntxxxx.getMainHandItem();
                                } else {
                                    mainHandItem32 = ItemStack.EMPTY;
                                }
                                mainHandItem32.hurtAndBreak(1, _level, (ServerPlayer) null, _stkprov -> {
                                });
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity) entity;
                                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                            }
                            BlockPos _pos = BlockPos.containing(x, y, z);
                            BlockState _bs = world.getBlockState(_pos);
                            Property<?> property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property2 instanceof IntegerProperty) {
                                IntegerProperty _integerProp = (IntegerProperty) property2;
                                if (_integerProp.getPossibleValues().contains(3)) {
                                    world.setBlock(_pos, (BlockState) _bs.setValue(_integerProp, 3), 3);
                                }
                            }
                            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_BAT_CARCASS.get()).defaultBlockState()));
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
                                ObjectListIterator var35 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_skin_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                while (var35.hasNext()) {
                                    ItemStack itemstackiterator = (ItemStack) var35.next();
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
                                    LivingEntity _livEntxxxxx = (LivingEntity) entity;
                                    mainHandItem26 = _livEntxxxxx.getMainHandItem();
                                } else {
                                    mainHandItem26 = ItemStack.EMPTY;
                                }
                                if (mainHandItem26.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _livEntxxxx2 = (LivingEntity) entity;
                                        mainHandItem31 = _livEntxxxx2.getMainHandItem();
                                    } else {
                                        mainHandItem31 = ItemStack.EMPTY;
                                    }
                                    if (mainHandItem31.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                        for (int index9 = 0; index9 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index9++) {
                                            if (!world.isClientSide() && world.getServer() != null) {
                                                ObjectListIterator var128 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_skin_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                                while (var128.hasNext()) {
                                                    ItemStack itemstackiterator2 = (ItemStack) var128.next();
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
                                    LivingEntity _livEntxxxxx2 = (LivingEntity) entity;
                                    mainHandItem27 = _livEntxxxxx2.getMainHandItem();
                                } else {
                                    mainHandItem27 = ItemStack.EMPTY;
                                }
                                if (mainHandItem27.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _livEntxxxx3 = (LivingEntity) entity;
                                        mainHandItem30 = _livEntxxxx3.getMainHandItem();
                                    } else {
                                        mainHandItem30 = ItemStack.EMPTY;
                                    }
                                    if (mainHandItem30.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                        for (int index10 = 0; index10 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index10++) {
                                            if (!world.isClientSide() && world.getServer() != null) {
                                                ObjectListIterator var127 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_skin_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                                while (var127.hasNext()) {
                                                    ItemStack itemstackiterator3 = (ItemStack) var127.next();
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
                                    LivingEntity _livEntxxxxx3 = (LivingEntity) entity;
                                    mainHandItem28 = _livEntxxxxx3.getMainHandItem();
                                } else {
                                    mainHandItem28 = ItemStack.EMPTY;
                                }
                                if (mainHandItem28.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _livEntxxxx4 = (LivingEntity) entity;
                                        mainHandItem29 = _livEntxxxx4.getMainHandItem();
                                    } else {
                                        mainHandItem29 = ItemStack.EMPTY;
                                    }
                                    if (mainHandItem29.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                        for (int index11 = 0; index11 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index11++) {
                                            if (!world.isClientSide() && world.getServer() != null) {
                                                ObjectListIterator var126 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_skin_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                                while (var126.hasNext()) {
                                                    ItemStack itemstackiterator4 = (ItemStack) var126.next();
                                                    if (world instanceof ServerLevel) {
                                                        ServerLevel _levelxx4 = (ServerLevel) world;
                                                        ItemEntity entityToSpawn4 = new ItemEntity(_levelxx4, x, y, z, itemstackiterator4);
                                                        entityToSpawn4.setPickUpDelay(10);
                                                        _levelxx4.addFreshEntity(entityToSpawn4);
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
                    return;
                }
            }
            if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BAT_CARCASS.get()) {
                    Property<?> property3 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property3 instanceof IntegerProperty) {
                        Property<?> _getip8 = property3;
                        iIntValue4 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip8)).intValue();
                    } else {
                        iIntValue4 = -1;
                    }
                    if (iIntValue4 == 1) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx2 = (LivingEntity) entity;
                                mainHandItem23 = _livEntxx2.getMainHandItem();
                            } else {
                                mainHandItem23 = ItemStack.EMPTY;
                            }
                            mainHandItem23.hurtAndBreak(1, _levelxx5, (ServerPlayer) null, _stkprov2 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity2 = (LivingEntity) entity;
                            _entity2.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posx = BlockPos.containing(x, y, z);
                        BlockState _bsx = world.getBlockState(_posx);
                        Property<?> property4 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property4 instanceof IntegerProperty) {
                            IntegerProperty _integerProp2 = (IntegerProperty) property4;
                            if (_integerProp2.getPossibleValues().contains(2)) {
                                world.setBlock(_posx, (BlockState) _bsx.setValue(_integerProp2, 2), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_BAT_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxx6 = (Level) world;
                            if (!_levelxx6.isClientSide()) {
                                _levelxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
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
                            ObjectListIterator var74 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_head_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var74.hasNext()) {
                                ItemStack itemstackiterator5 = (ItemStack) var74.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn5 = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator5);
                                    entityToSpawn5.setPickUpDelay(10);
                                    _levelxxxx.addFreshEntity(entityToSpawn5);
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BAT_CARCASS.get()) {
                    Property<?> property5 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property5 instanceof IntegerProperty) {
                        Property<?> _getip22 = property5;
                        iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip22)).intValue();
                    } else {
                        iIntValue3 = -1;
                    }
                    if (iIntValue3 == 3) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxx2 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx3 = (LivingEntity) entity;
                                mainHandItem22 = _livEntxx3.getMainHandItem();
                            } else {
                                mainHandItem22 = ItemStack.EMPTY;
                            }
                            mainHandItem22.hurtAndBreak(1, _levelxxxx2, (ServerPlayer) null, _stkprov3 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity3 = (LivingEntity) entity;
                            _entity3.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posxx = BlockPos.containing(x, y, z);
                        BlockState _bsxx = world.getBlockState(_posxx);
                        Property<?> property6 = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property6 instanceof IntegerProperty) {
                            IntegerProperty _integerProp3 = (IntegerProperty) property6;
                            if (_integerProp3.getPossibleValues().contains(4)) {
                                world.setBlock(_posxx, (BlockState) _bsxx.setValue(_integerProp3, 4), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_BAT_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxx3 = (Level) world;
                            if (!_levelxxxx3.isClientSide()) {
                                _levelxxxx3.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxx3.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
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
                            ObjectListIterator var67 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var67.hasNext()) {
                                ItemStack itemstackiterator6 = (ItemStack) var67.next();
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
                                LivingEntity _livEntxxx2 = (LivingEntity) entity;
                                mainHandItem16 = _livEntxxx2.getMainHandItem();
                            } else {
                                mainHandItem16 = ItemStack.EMPTY;
                            }
                            if (mainHandItem16.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx4 = (LivingEntity) entity;
                                    mainHandItem21 = _livEntxx4.getMainHandItem();
                                } else {
                                    mainHandItem21 = ItemStack.EMPTY;
                                }
                                if (mainHandItem21.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index0 = 0; index0 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index0++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var158 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var158.hasNext()) {
                                                ItemStack itemstackiterator7 = (ItemStack) var158.next();
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
                                LivingEntity _livEntxxx3 = (LivingEntity) entity;
                                mainHandItem17 = _livEntxxx3.getMainHandItem();
                            } else {
                                mainHandItem17 = ItemStack.EMPTY;
                            }
                            if (mainHandItem17.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx5 = (LivingEntity) entity;
                                    mainHandItem20 = _livEntxx5.getMainHandItem();
                                } else {
                                    mainHandItem20 = ItemStack.EMPTY;
                                }
                                if (mainHandItem20.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index1 = 0; index1 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index1++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var157 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var157.hasNext()) {
                                                ItemStack itemstackiterator8 = (ItemStack) var157.next();
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
                                LivingEntity _livEntxxx4 = (LivingEntity) entity;
                                mainHandItem18 = _livEntxxx4.getMainHandItem();
                            } else {
                                mainHandItem18 = ItemStack.EMPTY;
                            }
                            if (mainHandItem18.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx6 = (LivingEntity) entity;
                                    mainHandItem19 = _livEntxx6.getMainHandItem();
                                } else {
                                    mainHandItem19 = ItemStack.EMPTY;
                                }
                                if (mainHandItem19.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index2 = 0; index2 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index2++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var156 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var156.hasNext()) {
                                                ItemStack itemstackiterator9 = (ItemStack) var156.next();
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
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BAT_CARCASS.get()) {
                    Property<?> property7 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property7 instanceof IntegerProperty) {
                        Property<?> _getip61 = property7;
                        iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip61)).intValue();
                    } else {
                        iIntValue2 = -1;
                    }
                    if (iIntValue2 == 4) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx7 = (LivingEntity) entity;
                                mainHandItem15 = _livEntxx7.getMainHandItem();
                            } else {
                                mainHandItem15 = ItemStack.EMPTY;
                            }
                            mainHandItem15.hurtAndBreak(1, _levelxxxxxx5, (ServerPlayer) null, _stkprov4 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity4 = (LivingEntity) entity;
                            _entity4.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxx = world.getBlockState(_posxxx);
                        Property<?> property8 = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property8 instanceof IntegerProperty) {
                            IntegerProperty _integerProp4 = (IntegerProperty) property8;
                            if (_integerProp4.getPossibleValues().contains(5)) {
                                world.setBlock(_posxxx, (BlockState) _bsxxx.setValue(_integerProp4, 5), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_BAT_CARCASS.get()).defaultBlockState()));
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
                            ObjectListIterator var60 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var60.hasNext()) {
                                ItemStack itemstackiterator10 = (ItemStack) var60.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn10 = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator10);
                                    entityToSpawn10.setPickUpDelay(10);
                                    _levelxxxxxxxx.addFreshEntity(entityToSpawn10);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx5 = (LivingEntity) entity;
                                mainHandItem9 = _livEntxxx5.getMainHandItem();
                            } else {
                                mainHandItem9 = ItemStack.EMPTY;
                            }
                            if (mainHandItem9.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx8 = (LivingEntity) entity;
                                    mainHandItem14 = _livEntxx8.getMainHandItem();
                                } else {
                                    mainHandItem14 = ItemStack.EMPTY;
                                }
                                if (mainHandItem14.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index3 = 0; index3 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index3++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var155 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var155.hasNext()) {
                                                ItemStack itemstackiterator11 = (ItemStack) var155.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn11 = new ItemEntity(_levelxxxxxxxx2, x, y, z, itemstackiterator11);
                                                    entityToSpawn11.setPickUpDelay(10);
                                                    _levelxxxxxxxx2.addFreshEntity(entityToSpawn11);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx6 = (LivingEntity) entity;
                                mainHandItem10 = _livEntxxx6.getMainHandItem();
                            } else {
                                mainHandItem10 = ItemStack.EMPTY;
                            }
                            if (mainHandItem10.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx9 = (LivingEntity) entity;
                                    mainHandItem13 = _livEntxx9.getMainHandItem();
                                } else {
                                    mainHandItem13 = ItemStack.EMPTY;
                                }
                                if (mainHandItem13.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index4 = 0; index4 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index4++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var154 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var154.hasNext()) {
                                                ItemStack itemstackiterator12 = (ItemStack) var154.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn12 = new ItemEntity(_levelxxxxxxxx3, x, y, z, itemstackiterator12);
                                                    entityToSpawn12.setPickUpDelay(10);
                                                    _levelxxxxxxxx3.addFreshEntity(entityToSpawn12);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx7 = (LivingEntity) entity;
                                mainHandItem11 = _livEntxxx7.getMainHandItem();
                            } else {
                                mainHandItem11 = ItemStack.EMPTY;
                            }
                            if (mainHandItem11.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx10 = (LivingEntity) entity;
                                    mainHandItem12 = _livEntxx10.getMainHandItem();
                                } else {
                                    mainHandItem12 = ItemStack.EMPTY;
                                }
                                if (mainHandItem12.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index5 = 0; index5 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index5++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var153 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var153.hasNext()) {
                                                ItemStack itemstackiterator13 = (ItemStack) var153.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn13 = new ItemEntity(_levelxxxxxxxx4, x, y, z, itemstackiterator13);
                                                    entityToSpawn13.setPickUpDelay(10);
                                                    _levelxxxxxxxx4.addFreshEntity(entityToSpawn13);
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
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BAT_CARCASS.get()) {
                    Property<?> property9 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property9 instanceof IntegerProperty) {
                        IntegerProperty _getip100 = (IntegerProperty) property9;
                        iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip100)).intValue();
                    } else {
                        iIntValue = -1;
                    }
                    if (iIntValue == 5) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx11 = (LivingEntity) entity;
                                mainHandItem8 = _livEntxx11.getMainHandItem();
                            } else {
                                mainHandItem8 = ItemStack.EMPTY;
                            }
                            mainHandItem8.hurtAndBreak(1, _levelxxxxxxxx5, (ServerPlayer) null, _stkprov5 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity5 = (LivingEntity) entity;
                            _entity5.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_BAT_CARCASS.get()).defaultBlockState()));
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxx6 = (Level) world;
                            if (!_levelxxxxxxxx6.isClientSide()) {
                                _levelxxxxxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
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
                            ObjectListIterator var51 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var51.hasNext()) {
                                ItemStack itemstackiterator14 = (ItemStack) var51.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn14 = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator14);
                                    entityToSpawn14.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawn14);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.ORGANS.get()).booleanValue()) {
                            if (!world.isClientSide() && world.getServer() != null) {
                                ObjectListIterator var52 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                while (var52.hasNext()) {
                                    ItemStack itemstackiterator15 = (ItemStack) var52.next();
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _levelxxxxxxxxxx2 = (ServerLevel) world;
                                        ItemEntity entityToSpawn15 = new ItemEntity(_levelxxxxxxxxxx2, x, y, z, itemstackiterator15);
                                        entityToSpawn15.setPickUpDelay(10);
                                        _levelxxxxxxxxxx2.addFreshEntity(entityToSpawn15);
                                    }
                                }
                            }
                            if (!world.isClientSide() && world.getServer() != null) {
                                ObjectListIterator var53 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                while (var53.hasNext()) {
                                    ItemStack itemstackiterator16 = (ItemStack) var53.next();
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _levelxxxxxxxxxx3 = (ServerLevel) world;
                                        ItemEntity entityToSpawn16 = new ItemEntity(_levelxxxxxxxxxx3, x, y, z, itemstackiterator16);
                                        entityToSpawn16.setPickUpDelay(10);
                                        _levelxxxxxxxxxx3.addFreshEntity(entityToSpawn16);
                                    }
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx8 = (LivingEntity) entity;
                                mainHandItem2 = _livEntxxx8.getMainHandItem();
                            } else {
                                mainHandItem2 = ItemStack.EMPTY;
                            }
                            if (mainHandItem2.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx12 = (LivingEntity) entity;
                                    mainHandItem7 = _livEntxx12.getMainHandItem();
                                } else {
                                    mainHandItem7 = ItemStack.EMPTY;
                                }
                                if (mainHandItem7.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index6 = 0; index6 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index6++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var150 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var150.hasNext()) {
                                                ItemStack itemstackiterator17 = (ItemStack) var150.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn17 = new ItemEntity(_levelxxxxxxxxxx4, x, y, z, itemstackiterator17);
                                                    entityToSpawn17.setPickUpDelay(10);
                                                    _levelxxxxxxxxxx4.addFreshEntity(entityToSpawn17);
                                                }
                                            }
                                        }
                                        if (((Boolean) ButcheryconfigConfiguration.ORGANS.get()).booleanValue()) {
                                            if (!world.isClientSide() && world.getServer() != null) {
                                                ObjectListIterator var151 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                                while (var151.hasNext()) {
                                                    ItemStack itemstackiterator18 = (ItemStack) var151.next();
                                                    if (world instanceof ServerLevel) {
                                                        ServerLevel _levelxxxxxxxxxx5 = (ServerLevel) world;
                                                        ItemEntity entityToSpawn18 = new ItemEntity(_levelxxxxxxxxxx5, x, y, z, itemstackiterator18);
                                                        entityToSpawn18.setPickUpDelay(10);
                                                        _levelxxxxxxxxxx5.addFreshEntity(entityToSpawn18);
                                                    }
                                                }
                                            }
                                            if (!world.isClientSide() && world.getServer() != null) {
                                                ObjectListIterator var152 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                                while (var152.hasNext()) {
                                                    ItemStack itemstackiterator19 = (ItemStack) var152.next();
                                                    if (world instanceof ServerLevel) {
                                                        ServerLevel _levelxxxxxxxxxx6 = (ServerLevel) world;
                                                        ItemEntity entityToSpawn19 = new ItemEntity(_levelxxxxxxxxxx6, x, y, z, itemstackiterator19);
                                                        entityToSpawn19.setPickUpDelay(10);
                                                        _levelxxxxxxxxxx6.addFreshEntity(entityToSpawn19);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx9 = (LivingEntity) entity;
                                mainHandItem3 = _livEntxxx9.getMainHandItem();
                            } else {
                                mainHandItem3 = ItemStack.EMPTY;
                            }
                            if (mainHandItem3.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx13 = (LivingEntity) entity;
                                    mainHandItem6 = _livEntxx13.getMainHandItem();
                                } else {
                                    mainHandItem6 = ItemStack.EMPTY;
                                }
                                if (mainHandItem6.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index7 = 0; index7 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index7++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var147 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var147.hasNext()) {
                                                ItemStack itemstackiterator20 = (ItemStack) var147.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxx7 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn20 = new ItemEntity(_levelxxxxxxxxxx7, x, y, z, itemstackiterator20);
                                                    entityToSpawn20.setPickUpDelay(10);
                                                    _levelxxxxxxxxxx7.addFreshEntity(entityToSpawn20);
                                                }
                                            }
                                        }
                                        if (((Boolean) ButcheryconfigConfiguration.ORGANS.get()).booleanValue()) {
                                            if (!world.isClientSide() && world.getServer() != null) {
                                                ObjectListIterator var148 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                                while (var148.hasNext()) {
                                                    ItemStack itemstackiterator21 = (ItemStack) var148.next();
                                                    if (world instanceof ServerLevel) {
                                                        ServerLevel _levelxxxxxxxxxx8 = (ServerLevel) world;
                                                        ItemEntity entityToSpawn21 = new ItemEntity(_levelxxxxxxxxxx8, x, y, z, itemstackiterator21);
                                                        entityToSpawn21.setPickUpDelay(10);
                                                        _levelxxxxxxxxxx8.addFreshEntity(entityToSpawn21);
                                                    }
                                                }
                                            }
                                            if (!world.isClientSide() && world.getServer() != null) {
                                                ObjectListIterator var149 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                                while (var149.hasNext()) {
                                                    ItemStack itemstackiterator22 = (ItemStack) var149.next();
                                                    if (world instanceof ServerLevel) {
                                                        ServerLevel _levelxxxxxxxxxx9 = (ServerLevel) world;
                                                        ItemEntity entityToSpawn22 = new ItemEntity(_levelxxxxxxxxxx9, x, y, z, itemstackiterator22);
                                                        entityToSpawn22.setPickUpDelay(10);
                                                        _levelxxxxxxxxxx9.addFreshEntity(entityToSpawn22);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx10 = (LivingEntity) entity;
                                mainHandItem4 = _livEntxxx10.getMainHandItem();
                            } else {
                                mainHandItem4 = ItemStack.EMPTY;
                            }
                            if (mainHandItem4.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx14 = (LivingEntity) entity;
                                    mainHandItem5 = _livEntxx14.getMainHandItem();
                                } else {
                                    mainHandItem5 = ItemStack.EMPTY;
                                }
                                if (mainHandItem5.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index8 = 0; index8 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index8++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator entityToSpawn23 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bat_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (entityToSpawn23.hasNext()) {
                                                ItemStack itemstackiterator23 = (ItemStack) entityToSpawn23.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxx10 = (ServerLevel) world;
                                                    ItemEntity entityToSpawnx = new ItemEntity(_levelxxxxxxxxxx10, x, y, z, itemstackiterator23);
                                                    entityToSpawnx.setPickUpDelay(10);
                                                    _levelxxxxxxxxxx10.addFreshEntity(entityToSpawnx);
                                                }
                                            }
                                        }
                                        if (((Boolean) ButcheryconfigConfiguration.ORGANS.get()).booleanValue()) {
                                            if (!world.isClientSide() && world.getServer() != null) {
                                                ObjectListIterator var145 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                                while (var145.hasNext()) {
                                                    ItemStack itemstackiterator24 = (ItemStack) var145.next();
                                                    if (world instanceof ServerLevel) {
                                                        ServerLevel _levelxxxxxxxxxx11 = (ServerLevel) world;
                                                        ItemEntity entityToSpawn24 = new ItemEntity(_levelxxxxxxxxxx11, x, y, z, itemstackiterator24);
                                                        entityToSpawn24.setPickUpDelay(10);
                                                        _levelxxxxxxxxxx11.addFreshEntity(entityToSpawn24);
                                                    }
                                                }
                                            }
                                            if (!world.isClientSide() && world.getServer() != null) {
                                                ObjectListIterator var146 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                                while (var146.hasNext()) {
                                                    ItemStack itemstackiterator25 = (ItemStack) var146.next();
                                                    if (world instanceof ServerLevel) {
                                                        ServerLevel _levelxxxxxxxxxx12 = (ServerLevel) world;
                                                        ItemEntity entityToSpawn25 = new ItemEntity(_levelxxxxxxxxxx12, x, y, z, itemstackiterator25);
                                                        entityToSpawn25.setPickUpDelay(10);
                                                        _levelxxxxxxxxxx12.addFreshEntity(entityToSpawn25);
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
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false);
        }
        return false;
    }
}
