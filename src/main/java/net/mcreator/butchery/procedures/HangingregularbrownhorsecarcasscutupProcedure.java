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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
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

/* JADX INFO: loaded from: HangingregularbrownhorsecarcasscutupProcedure.class */
public class HangingregularbrownhorsecarcasscutupProcedure {
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
        int iIntValue2;
        ItemStack mainHandItem3;
        int iIntValue3;
        ItemStack mainHandItem4;
        int iIntValue4;
        ItemStack mainHandItem5;
        ItemStack mainHandItem6;
        ItemStack mainHandItem7;
        int iIntValue5;
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
                    mainHandItem6 = _livEnt.getMainHandItem();
                } else {
                    mainHandItem6 = ItemStack.EMPTY;
                }
                if (!mainHandItem6.is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxx = (LivingEntity) entity;
                        mainHandItem7 = _livEntxxx.getMainHandItem();
                    } else {
                        mainHandItem7 = ItemStack.EMPTY;
                    }
                    if (!mainHandItem7.is(TagKey.create(Registries.ITEM, Identifier.parse("forge:skinning_knives")))) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx = (LivingEntity) entity;
                            mainHandItem9 = _livEntxx.getMainHandItem();
                        } else {
                            mainHandItem9 = ItemStack.EMPTY;
                        }
                        if (!mainHandItem9.is(TagKey.create(Registries.ITEM, Identifier.parse("c:skinning_knives")))) {
                            return;
                        }
                    }
                    if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained") && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()) {
                        Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property instanceof IntegerProperty) {
                            Property<?> _getip82 = property;
                            iIntValue5 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip82)).intValue();
                        } else {
                            iIntValue5 = -1;
                        }
                        if (iIntValue5 == 2) {
                            if (world instanceof ServerLevel) {
                                ServerLevel _level = (ServerLevel) world;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxxxx = (LivingEntity) entity;
                                    mainHandItem8 = _livEntxxxx.getMainHandItem();
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
                            BlockPos _pos = BlockPos.containing(x, y, z);
                            BlockState _bs = world.getBlockState(_pos);
                            Property<?> property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property2 instanceof IntegerProperty) {
                                IntegerProperty _integerProp = (IntegerProperty) property2;
                                if (_integerProp.getPossibleValues().contains(3)) {
                                    world.setBlock(_pos, (BlockState) _bs.setValue(_integerProp, 3), 3);
                                }
                            }
                            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()).defaultBlockState()));
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
                                ObjectListIterator var29 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/brown_horse_skin_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                while (var29.hasNext()) {
                                    ItemStack itemstackiterator = (ItemStack) var29.next();
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
                        return;
                    }
                    return;
                }
            }
            if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()) {
                    Property<?> property3 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property3 instanceof IntegerProperty) {
                        Property<?> _getip8 = property3;
                        iIntValue4 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip8)).intValue();
                    } else {
                        iIntValue4 = -1;
                    }
                    if (iIntValue4 == 1) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxx2 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx2 = (LivingEntity) entity;
                                mainHandItem5 = _livEntxx2.getMainHandItem();
                            } else {
                                mainHandItem5 = ItemStack.EMPTY;
                            }
                            mainHandItem5.hurtAndBreak(1, _levelxx2, (ServerPlayer) null, _stkprov2 -> {
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
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()).defaultBlockState()));
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
                            ObjectListIterator var63 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/brown_horse_head_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var63.hasNext()) {
                                ItemStack itemstackiterator2 = (ItemStack) var63.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn2 = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator2);
                                    entityToSpawn2.setPickUpDelay(10);
                                    _levelxxxx.addFreshEntity(entityToSpawn2);
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()) {
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
                                mainHandItem4 = _livEntxx3.getMainHandItem();
                            } else {
                                mainHandItem4 = ItemStack.EMPTY;
                            }
                            mainHandItem4.hurtAndBreak(1, _levelxxxx2, (ServerPlayer) null, _stkprov3 -> {
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
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()).defaultBlockState()));
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
                            ObjectListIterator var56 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var56.hasNext()) {
                                ItemStack itemstackiterator3 = (ItemStack) var56.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn3 = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator3);
                                    entityToSpawn3.setPickUpDelay(10);
                                    _levelxxxxxx.addFreshEntity(entityToSpawn3);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.ORGANS.get()).booleanValue() && !world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var57 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var57.hasNext()) {
                                ItemStack itemstackiterator4 = (ItemStack) var57.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxx2 = (ServerLevel) world;
                                    ItemEntity entityToSpawn4 = new ItemEntity(_levelxxxxxx2, x, y, z, itemstackiterator4);
                                    entityToSpawn4.setPickUpDelay(10);
                                    _levelxxxxxx2.addFreshEntity(entityToSpawn4);
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()) {
                    Property<?> property7 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property7 instanceof IntegerProperty) {
                        Property<?> _getip40 = property7;
                        iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip40)).intValue();
                    } else {
                        iIntValue2 = -1;
                    }
                    if (iIntValue2 == 4) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxx3 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx4 = (LivingEntity) entity;
                                mainHandItem3 = _livEntxx4.getMainHandItem();
                            } else {
                                mainHandItem3 = ItemStack.EMPTY;
                            }
                            mainHandItem3.hurtAndBreak(1, _levelxxxxxx3, (ServerPlayer) null, _stkprov4 -> {
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
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxx4 = (Level) world;
                            if (!_levelxxxxxx4.isClientSide()) {
                                _levelxxxxxx4.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxx4.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
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
                            ObjectListIterator var49 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var49.hasNext()) {
                                ItemStack itemstackiterator5 = (ItemStack) var49.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn5 = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator5);
                                    entityToSpawn5.setPickUpDelay(10);
                                    _levelxxxxxxxx.addFreshEntity(entityToSpawn5);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.ORGANS.get()).booleanValue() && !world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var50 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var50.hasNext()) {
                                ItemStack itemstackiterator6 = (ItemStack) var50.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxx2 = (ServerLevel) world;
                                    ItemEntity entityToSpawn6 = new ItemEntity(_levelxxxxxxxx2, x, y, z, itemstackiterator6);
                                    entityToSpawn6.setPickUpDelay(10);
                                    _levelxxxxxxxx2.addFreshEntity(entityToSpawn6);
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()) {
                    Property<?> property9 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property9 instanceof IntegerProperty) {
                        IntegerProperty _getip58 = (IntegerProperty) property9;
                        iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip58)).intValue();
                    } else {
                        iIntValue = -1;
                    }
                    if (iIntValue == 5) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxx3 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx5 = (LivingEntity) entity;
                                mainHandItem2 = _livEntxx5.getMainHandItem();
                            } else {
                                mainHandItem2 = ItemStack.EMPTY;
                            }
                            mainHandItem2.hurtAndBreak(1, _levelxxxxxxxx3, (ServerPlayer) null, _stkprov5 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity5 = (LivingEntity) entity;
                            _entity5.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()).defaultBlockState()));
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxx4 = (Level) world;
                            if (!_levelxxxxxxxx4.isClientSide()) {
                                _levelxxxxxxxx4.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxx4.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
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
                            ObjectListIterator var42 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var42.hasNext()) {
                                ItemStack itemstackiterator7 = (ItemStack) var42.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn7 = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator7);
                                    entityToSpawn7.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawn7);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.ORGANS.get()).booleanValue() && !world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var43 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var43.hasNext()) {
                                ItemStack itemstackiterator8 = (ItemStack) var43.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxxxx2 = (ServerLevel) world;
                                    ItemEntity entityToSpawn8 = new ItemEntity(_levelxxxxxxxxxx2, x, y, z, itemstackiterator8);
                                    entityToSpawn8.setPickUpDelay(10);
                                    _levelxxxxxxxxxx2.addFreshEntity(entityToSpawn8);
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
