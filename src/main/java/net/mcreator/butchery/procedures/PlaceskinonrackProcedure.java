package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class PlaceskinonrackProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity != null) {
            int n;
            Property property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip1 = (IntegerProperty)property;
                n = (Integer)blockstate.getValue((Property)_getip1);
            } else {
                n = -1;
            }
            if (n == 0) {
                ItemStack itemStack;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    itemStack = _livEnt.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                if (itemStack.getItem() == ButcheryModItems.BAT_SKIN.get()) {
                    IntegerProperty _integerProp;
                    ItemStack itemStack2;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)entity;
                        itemStack2 = _livEntx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    itemStack2.shrink(1);
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    int _value = 1;
                    BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property2 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property2).getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                } else {
                    ItemStack itemStack3;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        itemStack3 = _livEnt.getMainHandItem();
                    } else {
                        itemStack3 = ItemStack.EMPTY;
                    }
                    if (itemStack3.getItem() == ButcheryModItems.BLACK_HORSE_SKIN.get()) {
                        IntegerProperty _integerProp;
                        ItemStack itemStack4;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx = (LivingEntity)entity;
                            itemStack4 = _livEntxx.getMainHandItem();
                        } else {
                            itemStack4 = ItemStack.EMPTY;
                        }
                        itemStack4.shrink(1);
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        int _valuex = 2;
                        BlockPos _posx = BlockPos.containing((double)x, (double)y, (double)z);
                        BlockState _bsx = world.getBlockState(_posx);
                        Property property3 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property3 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property3).getPossibleValues().contains(_valuex)) {
                            world.setBlock(_posx, (BlockState)_bsx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuex)), 3);
                        }
                        if (world instanceof Level) {
                            Level _levelx = (Level)world;
                            if (!_levelx.isClientSide()) {
                                _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                    } else {
                        ItemStack itemStack5;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity)entity;
                            itemStack5 = _livEnt.getMainHandItem();
                        } else {
                            itemStack5 = ItemStack.EMPTY;
                        }
                        if (itemStack5.getItem() == ButcheryModItems.BROWN_MOOSHROOM_SKIN.get()) {
                            IntegerProperty _integerProp;
                            ItemStack itemStack6;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx = (LivingEntity)entity;
                                itemStack6 = _livEntxxx.getMainHandItem();
                            } else {
                                itemStack6 = ItemStack.EMPTY;
                            }
                            itemStack6.shrink(1);
                            if (entity instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entity;
                                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                            }
                            int _valuexx = 3;
                            BlockPos _posxx = BlockPos.containing((double)x, (double)y, (double)z);
                            BlockState _bsxx = world.getBlockState(_posxx);
                            Property property4 = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property4 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property4).getPossibleValues().contains(_valuexx)) {
                                world.setBlock(_posxx, (BlockState)_bsxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexx)), 3);
                            }
                            if (world instanceof Level) {
                                Level _levelxx = (Level)world;
                                if (!_levelxx.isClientSide()) {
                                    _levelxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                } else {
                                    _levelxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                }
                            }
                        } else {
                            ItemStack itemStack7;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEnt = (LivingEntity)entity;
                                itemStack7 = _livEnt.getMainHandItem();
                            } else {
                                itemStack7 = ItemStack.EMPTY;
                            }
                            if (itemStack7.getItem() == ButcheryModItems.CHESTNUT_HORSE_SKIN.get()) {
                                IntegerProperty _integerProp;
                                ItemStack itemStack8;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxxxx = (LivingEntity)entity;
                                    itemStack8 = _livEntxxxx.getMainHandItem();
                                } else {
                                    itemStack8 = ItemStack.EMPTY;
                                }
                                itemStack8.shrink(1);
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                }
                                int _valuexxx = 4;
                                BlockPos _posxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                BlockState _bsxxx = world.getBlockState(_posxxx);
                                Property property5 = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                if (property5 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property5).getPossibleValues().contains(_valuexxx)) {
                                    world.setBlock(_posxxx, (BlockState)_bsxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxx)), 3);
                                }
                                if (world instanceof Level) {
                                    Level _levelxxx = (Level)world;
                                    if (!_levelxxx.isClientSide()) {
                                        _levelxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                    } else {
                                        _levelxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                    }
                                }
                            } else {
                                ItemStack itemStack9;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    itemStack9 = _livEnt.getMainHandItem();
                                } else {
                                    itemStack9 = ItemStack.EMPTY;
                                }
                                if (itemStack9.getItem() == ButcheryModItems.CREAMY_HORSE_SKIN.get()) {
                                    IntegerProperty _integerProp;
                                    ItemStack itemStack10;
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _livEntxxxxx = (LivingEntity)entity;
                                        itemStack10 = _livEntxxxxx.getMainHandItem();
                                    } else {
                                        itemStack10 = ItemStack.EMPTY;
                                    }
                                    itemStack10.shrink(1);
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _entity = (LivingEntity)entity;
                                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                    }
                                    int _valuexxxx = 5;
                                    BlockPos _posxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                    BlockState _bsxxxx = world.getBlockState(_posxxxx);
                                    Property property6 = _bsxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                    if (property6 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property6).getPossibleValues().contains(_valuexxxx)) {
                                        world.setBlock(_posxxxx, (BlockState)_bsxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxx)), 3);
                                    }
                                    if (world instanceof Level) {
                                        Level _levelxxxx = (Level)world;
                                        if (!_levelxxxx.isClientSide()) {
                                            _levelxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                        } else {
                                            _levelxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                        }
                                    }
                                } else {
                                    ItemStack itemStack11;
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _livEnt = (LivingEntity)entity;
                                        itemStack11 = _livEnt.getMainHandItem();
                                    } else {
                                        itemStack11 = ItemStack.EMPTY;
                                    }
                                    if (itemStack11.getItem() == ButcheryModItems.CREEPER_SKIN.get()) {
                                        IntegerProperty _integerProp;
                                        ItemStack itemStack12;
                                        if (entity instanceof LivingEntity) {
                                            LivingEntity _livEntxxxxxx = (LivingEntity)entity;
                                            itemStack12 = _livEntxxxxxx.getMainHandItem();
                                        } else {
                                            itemStack12 = ItemStack.EMPTY;
                                        }
                                        itemStack12.shrink(1);
                                        if (entity instanceof LivingEntity) {
                                            LivingEntity _entity = (LivingEntity)entity;
                                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                        }
                                        int _valuexxxxx = 6;
                                        BlockPos _posxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                        BlockState _bsxxxxx = world.getBlockState(_posxxxxx);
                                        Property property7 = _bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                        if (property7 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property7).getPossibleValues().contains(_valuexxxxx)) {
                                            world.setBlock(_posxxxxx, (BlockState)_bsxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxx)), 3);
                                        }
                                        if (world instanceof Level) {
                                            Level _levelxxxxx = (Level)world;
                                            if (!_levelxxxxx.isClientSide()) {
                                                _levelxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                            } else {
                                                _levelxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                            }
                                        }
                                    } else {
                                        ItemStack itemStack13;
                                        if (entity instanceof LivingEntity) {
                                            LivingEntity _livEnt = (LivingEntity)entity;
                                            itemStack13 = _livEnt.getMainHandItem();
                                        } else {
                                            itemStack13 = ItemStack.EMPTY;
                                        }
                                        if (itemStack13.getItem() == ButcheryModItems.DARK_BROWN_HORSE_SKIN.get()) {
                                            IntegerProperty _integerProp;
                                            ItemStack itemStack14;
                                            if (entity instanceof LivingEntity) {
                                                LivingEntity _livEntxxxxxxx = (LivingEntity)entity;
                                                itemStack14 = _livEntxxxxxxx.getMainHandItem();
                                            } else {
                                                itemStack14 = ItemStack.EMPTY;
                                            }
                                            itemStack14.shrink(1);
                                            if (entity instanceof LivingEntity) {
                                                LivingEntity _entity = (LivingEntity)entity;
                                                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                            }
                                            int _valuexxxxxx = 7;
                                            BlockPos _posxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                            BlockState _bsxxxxxx = world.getBlockState(_posxxxxxx);
                                            Property property8 = _bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                            if (property8 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property8).getPossibleValues().contains(_valuexxxxxx)) {
                                                world.setBlock(_posxxxxxx, (BlockState)_bsxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxx)), 3);
                                            }
                                            if (world instanceof Level) {
                                                Level _levelxxxxxx = (Level)world;
                                                if (!_levelxxxxxx.isClientSide()) {
                                                    _levelxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                } else {
                                                    _levelxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                }
                                            }
                                        } else {
                                            ItemStack itemStack15;
                                            if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                itemStack15 = _livEnt.getMainHandItem();
                                            } else {
                                                itemStack15 = ItemStack.EMPTY;
                                            }
                                            if (itemStack15.getItem() == ButcheryModItems.DOLPHIN_SKIN.get()) {
                                                IntegerProperty _integerProp;
                                                ItemStack itemStack16;
                                                if (entity instanceof LivingEntity) {
                                                    LivingEntity _livEntxxxxxxxx = (LivingEntity)entity;
                                                    itemStack16 = _livEntxxxxxxxx.getMainHandItem();
                                                } else {
                                                    itemStack16 = ItemStack.EMPTY;
                                                }
                                                itemStack16.shrink(1);
                                                if (entity instanceof LivingEntity) {
                                                    LivingEntity _entity = (LivingEntity)entity;
                                                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                }
                                                int _valuexxxxxxx = 8;
                                                BlockPos _posxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                BlockState _bsxxxxxxx = world.getBlockState(_posxxxxxxx);
                                                Property property9 = _bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                if (property9 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property9).getPossibleValues().contains(_valuexxxxxxx)) {
                                                    world.setBlock(_posxxxxxxx, (BlockState)_bsxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxx)), 3);
                                                }
                                                if (world instanceof Level) {
                                                    Level _levelxxxxxxx = (Level)world;
                                                    if (!_levelxxxxxxx.isClientSide()) {
                                                        _levelxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                    } else {
                                                        _levelxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                    }
                                                }
                                            } else {
                                                ItemStack itemStack17;
                                                if (entity instanceof LivingEntity) {
                                                    LivingEntity _livEnt = (LivingEntity)entity;
                                                    itemStack17 = _livEnt.getMainHandItem();
                                                } else {
                                                    itemStack17 = ItemStack.EMPTY;
                                                }
                                                if (itemStack17.getItem() == ButcheryModItems.DONKEY_SKIN.get()) {
                                                    IntegerProperty _integerProp;
                                                    ItemStack itemStack18;
                                                    if (entity instanceof LivingEntity) {
                                                        LivingEntity _livEntxxxxxxxxx = (LivingEntity)entity;
                                                        itemStack18 = _livEntxxxxxxxxx.getMainHandItem();
                                                    } else {
                                                        itemStack18 = ItemStack.EMPTY;
                                                    }
                                                    itemStack18.shrink(1);
                                                    if (entity instanceof LivingEntity) {
                                                        LivingEntity _entity = (LivingEntity)entity;
                                                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                    }
                                                    int _valuexxxxxxxx = 9;
                                                    BlockPos _posxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                    BlockState _bsxxxxxxxx = world.getBlockState(_posxxxxxxxx);
                                                    Property property10 = _bsxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                    if (property10 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property10).getPossibleValues().contains(_valuexxxxxxxx)) {
                                                        world.setBlock(_posxxxxxxxx, (BlockState)_bsxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxx)), 3);
                                                    }
                                                    if (world instanceof Level) {
                                                        Level _levelxxxxxxxx = (Level)world;
                                                        if (!_levelxxxxxxxx.isClientSide()) {
                                                            _levelxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                        } else {
                                                            _levelxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                        }
                                                    }
                                                } else {
                                                    ItemStack itemStack19;
                                                    if (entity instanceof LivingEntity) {
                                                        LivingEntity _livEnt = (LivingEntity)entity;
                                                        itemStack19 = _livEnt.getMainHandItem();
                                                    } else {
                                                        itemStack19 = ItemStack.EMPTY;
                                                    }
                                                    if (itemStack19.getItem() == ButcheryModItems.FOX_SKIN.get()) {
                                                        IntegerProperty _integerProp;
                                                        ItemStack itemStack20;
                                                        if (entity instanceof LivingEntity) {
                                                            LivingEntity _livEntxxxxxxxxxx = (LivingEntity)entity;
                                                            itemStack20 = _livEntxxxxxxxxxx.getMainHandItem();
                                                        } else {
                                                            itemStack20 = ItemStack.EMPTY;
                                                        }
                                                        itemStack20.shrink(1);
                                                        if (entity instanceof LivingEntity) {
                                                            LivingEntity _entity = (LivingEntity)entity;
                                                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                        }
                                                        int _valuexxxxxxxxx = 10;
                                                        BlockPos _posxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                        BlockState _bsxxxxxxxxx = world.getBlockState(_posxxxxxxxxx);
                                                        Property property11 = _bsxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                        if (property11 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property11).getPossibleValues().contains(_valuexxxxxxxxx)) {
                                                            world.setBlock(_posxxxxxxxxx, (BlockState)_bsxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxx)), 3);
                                                        }
                                                        if (world instanceof Level) {
                                                            Level _levelxxxxxxxxx = (Level)world;
                                                            if (!_levelxxxxxxxxx.isClientSide()) {
                                                                _levelxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                            } else {
                                                                _levelxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                            }
                                                        }
                                                    } else {
                                                        ItemStack itemStack21;
                                                        if (entity instanceof LivingEntity) {
                                                            LivingEntity _livEnt = (LivingEntity)entity;
                                                            itemStack21 = _livEnt.getMainHandItem();
                                                        } else {
                                                            itemStack21 = ItemStack.EMPTY;
                                                        }
                                                        if (itemStack21.getItem() == ButcheryModItems.GRAY_HORSE_SKIN.get()) {
                                                            IntegerProperty _integerProp;
                                                            ItemStack itemStack22;
                                                            if (entity instanceof LivingEntity) {
                                                                LivingEntity _livEntxxxxxxxxxxx = (LivingEntity)entity;
                                                                itemStack22 = _livEntxxxxxxxxxxx.getMainHandItem();
                                                            } else {
                                                                itemStack22 = ItemStack.EMPTY;
                                                            }
                                                            itemStack22.shrink(1);
                                                            if (entity instanceof LivingEntity) {
                                                                LivingEntity _entity = (LivingEntity)entity;
                                                                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                            }
                                                            int _valuexxxxxxxxxx = 11;
                                                            BlockPos _posxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                            BlockState _bsxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxx);
                                                            Property property12 = _bsxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                            if (property12 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property12).getPossibleValues().contains(_valuexxxxxxxxxx)) {
                                                                world.setBlock(_posxxxxxxxxxx, (BlockState)_bsxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxx)), 3);
                                                            }
                                                            if (world instanceof Level) {
                                                                Level _levelxxxxxxxxxx = (Level)world;
                                                                if (!_levelxxxxxxxxxx.isClientSide()) {
                                                                    _levelxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                } else {
                                                                    _levelxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                }
                                                            }
                                                        } else {
                                                            ItemStack itemStack23;
                                                            if (entity instanceof LivingEntity) {
                                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                                itemStack23 = _livEnt.getMainHandItem();
                                                            } else {
                                                                itemStack23 = ItemStack.EMPTY;
                                                            }
                                                            if (itemStack23.getItem() == ButcheryModItems.HOGLIN_SKIN.get()) {
                                                                IntegerProperty _integerProp;
                                                                ItemStack itemStack24;
                                                                if (entity instanceof LivingEntity) {
                                                                    LivingEntity _livEntxxxxxxxxxxxx = (LivingEntity)entity;
                                                                    itemStack24 = _livEntxxxxxxxxxxxx.getMainHandItem();
                                                                } else {
                                                                    itemStack24 = ItemStack.EMPTY;
                                                                }
                                                                itemStack24.shrink(1);
                                                                if (entity instanceof LivingEntity) {
                                                                    LivingEntity _entity = (LivingEntity)entity;
                                                                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                }
                                                                int _valuexxxxxxxxxxx = 12;
                                                                BlockPos _posxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                BlockState _bsxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxx);
                                                                Property property13 = _bsxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                if (property13 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property13).getPossibleValues().contains(_valuexxxxxxxxxxx)) {
                                                                    world.setBlock(_posxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxx)), 3);
                                                                }
                                                                if (world instanceof Level) {
                                                                    Level _levelxxxxxxxxxxx = (Level)world;
                                                                    if (!_levelxxxxxxxxxxx.isClientSide()) {
                                                                        _levelxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                    } else {
                                                                        _levelxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                    }
                                                                }
                                                            } else {
                                                                ItemStack itemStack25;
                                                                if (entity instanceof LivingEntity) {
                                                                    LivingEntity _livEnt = (LivingEntity)entity;
                                                                    itemStack25 = _livEnt.getMainHandItem();
                                                                } else {
                                                                    itemStack25 = ItemStack.EMPTY;
                                                                }
                                                                if (itemStack25.getItem() == ButcheryModItems.MULE_SKIN.get()) {
                                                                    IntegerProperty _integerProp;
                                                                    ItemStack itemStack26;
                                                                    if (entity instanceof LivingEntity) {
                                                                        LivingEntity _livEntxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                        itemStack26 = _livEntxxxxxxxxxxxxx.getMainHandItem();
                                                                    } else {
                                                                        itemStack26 = ItemStack.EMPTY;
                                                                    }
                                                                    itemStack26.shrink(1);
                                                                    if (entity instanceof LivingEntity) {
                                                                        LivingEntity _entity = (LivingEntity)entity;
                                                                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                    }
                                                                    int _valuexxxxxxxxxxxx = 13;
                                                                    BlockPos _posxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                    BlockState _bsxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxx);
                                                                    Property property14 = _bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                    if (property14 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property14).getPossibleValues().contains(_valuexxxxxxxxxxxx)) {
                                                                        world.setBlock(_posxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxx)), 3);
                                                                    }
                                                                    if (world instanceof Level) {
                                                                        Level _levelxxxxxxxxxxxx = (Level)world;
                                                                        if (!_levelxxxxxxxxxxxx.isClientSide()) {
                                                                            _levelxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                        } else {
                                                                            _levelxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                        }
                                                                    }
                                                                } else {
                                                                    ItemStack itemStack27;
                                                                    if (entity instanceof LivingEntity) {
                                                                        LivingEntity _livEnt = (LivingEntity)entity;
                                                                        itemStack27 = _livEnt.getMainHandItem();
                                                                    } else {
                                                                        itemStack27 = ItemStack.EMPTY;
                                                                    }
                                                                    if (itemStack27.getItem() == ButcheryModItems.OCELOT_SKIN.get()) {
                                                                        IntegerProperty _integerProp;
                                                                        ItemStack itemStack28;
                                                                        if (entity instanceof LivingEntity) {
                                                                            LivingEntity _livEntxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                            itemStack28 = _livEntxxxxxxxxxxxxxx.getMainHandItem();
                                                                        } else {
                                                                            itemStack28 = ItemStack.EMPTY;
                                                                        }
                                                                        itemStack28.shrink(1);
                                                                        if (entity instanceof LivingEntity) {
                                                                            LivingEntity _entity = (LivingEntity)entity;
                                                                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                        }
                                                                        int _valuexxxxxxxxxxxxx = 14;
                                                                        BlockPos _posxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                        BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxx);
                                                                        Property property15 = _bsxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                        if (property15 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property15).getPossibleValues().contains(_valuexxxxxxxxxxxxx)) {
                                                                            world.setBlock(_posxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxx)), 3);
                                                                        }
                                                                        if (world instanceof Level) {
                                                                            Level _levelxxxxxxxxxxxxx = (Level)world;
                                                                            if (!_levelxxxxxxxxxxxxx.isClientSide()) {
                                                                                _levelxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                            } else {
                                                                                _levelxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                            }
                                                                        }
                                                                    } else {
                                                                        ItemStack itemStack29;
                                                                        if (entity instanceof LivingEntity) {
                                                                            LivingEntity _livEnt = (LivingEntity)entity;
                                                                            itemStack29 = _livEnt.getMainHandItem();
                                                                        } else {
                                                                            itemStack29 = ItemStack.EMPTY;
                                                                        }
                                                                        if (itemStack29.getItem() == ButcheryModItems.PANDA_SKIN.get()) {
                                                                            IntegerProperty _integerProp;
                                                                            ItemStack itemStack30;
                                                                            if (entity instanceof LivingEntity) {
                                                                                LivingEntity _livEntxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                itemStack30 = _livEntxxxxxxxxxxxxxxx.getMainHandItem();
                                                                            } else {
                                                                                itemStack30 = ItemStack.EMPTY;
                                                                            }
                                                                            itemStack30.shrink(1);
                                                                            if (entity instanceof LivingEntity) {
                                                                                LivingEntity _entity = (LivingEntity)entity;
                                                                                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                            }
                                                                            int _valuexxxxxxxxxxxxxx = 15;
                                                                            BlockPos _posxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                            BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxx);
                                                                            Property property16 = _bsxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                            if (property16 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property16).getPossibleValues().contains(_valuexxxxxxxxxxxxxx)) {
                                                                                world.setBlock(_posxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxx)), 3);
                                                                            }
                                                                            if (world instanceof Level) {
                                                                                Level _levelxxxxxxxxxxxxxx = (Level)world;
                                                                                if (!_levelxxxxxxxxxxxxxx.isClientSide()) {
                                                                                    _levelxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                } else {
                                                                                    _levelxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                }
                                                                            }
                                                                        } else {
                                                                            ItemStack itemStack31;
                                                                            if (entity instanceof LivingEntity) {
                                                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                                                itemStack31 = _livEnt.getMainHandItem();
                                                                            } else {
                                                                                itemStack31 = ItemStack.EMPTY;
                                                                            }
                                                                            if (itemStack31.getItem() == ButcheryModItems.PIG_SKIN.get()) {
                                                                                IntegerProperty _integerProp;
                                                                                ItemStack itemStack32;
                                                                                if (entity instanceof LivingEntity) {
                                                                                    LivingEntity _livEntxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                    itemStack32 = _livEntxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                } else {
                                                                                    itemStack32 = ItemStack.EMPTY;
                                                                                }
                                                                                itemStack32.shrink(1);
                                                                                if (entity instanceof LivingEntity) {
                                                                                    LivingEntity _entity = (LivingEntity)entity;
                                                                                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                }
                                                                                int _valuexxxxxxxxxxxxxxx = 16;
                                                                                BlockPos _posxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                BlockState _bsxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxx);
                                                                                Property property17 = _bsxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                if (property17 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property17).getPossibleValues().contains(_valuexxxxxxxxxxxxxxx)) {
                                                                                    world.setBlock(_posxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxx)), 3);
                                                                                }
                                                                                if (world instanceof Level) {
                                                                                    Level _levelxxxxxxxxxxxxxxx = (Level)world;
                                                                                    if (!_levelxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                        _levelxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                    } else {
                                                                                        _levelxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                ItemStack itemStack33;
                                                                                if (entity instanceof LivingEntity) {
                                                                                    LivingEntity _livEnt = (LivingEntity)entity;
                                                                                    itemStack33 = _livEnt.getMainHandItem();
                                                                                } else {
                                                                                    itemStack33 = ItemStack.EMPTY;
                                                                                }
                                                                                if (itemStack33.getItem() == ButcheryModItems.RED_MOOSHROOM_SKIN.get()) {
                                                                                    IntegerProperty _integerProp;
                                                                                    ItemStack itemStack34;
                                                                                    if (entity instanceof LivingEntity) {
                                                                                        LivingEntity _livEntxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                        itemStack34 = _livEntxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                    } else {
                                                                                        itemStack34 = ItemStack.EMPTY;
                                                                                    }
                                                                                    itemStack34.shrink(1);
                                                                                    if (entity instanceof LivingEntity) {
                                                                                        LivingEntity _entity = (LivingEntity)entity;
                                                                                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                    }
                                                                                    int _valuexxxxxxxxxxxxxxxx = 17;
                                                                                    BlockPos _posxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                    BlockState _bsxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxx);
                                                                                    Property property18 = _bsxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                    if (property18 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property18).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxx)) {
                                                                                        world.setBlock(_posxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxx)), 3);
                                                                                    }
                                                                                    if (world instanceof Level) {
                                                                                        Level _levelxxxxxxxxxxxxxxxx = (Level)world;
                                                                                        if (!_levelxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                            _levelxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                        } else {
                                                                                            _levelxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    ItemStack itemStack35;
                                                                                    if (entity instanceof LivingEntity) {
                                                                                        LivingEntity _livEnt = (LivingEntity)entity;
                                                                                        itemStack35 = _livEnt.getMainHandItem();
                                                                                    } else {
                                                                                        itemStack35 = ItemStack.EMPTY;
                                                                                    }
                                                                                    if (itemStack35.getItem() == ButcheryModItems.SHEEP_SKIN.get()) {
                                                                                        IntegerProperty _integerProp;
                                                                                        ItemStack itemStack36;
                                                                                        if (entity instanceof LivingEntity) {
                                                                                            LivingEntity _livEntxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                            itemStack36 = _livEntxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                        } else {
                                                                                            itemStack36 = ItemStack.EMPTY;
                                                                                        }
                                                                                        itemStack36.shrink(1);
                                                                                        if (entity instanceof LivingEntity) {
                                                                                            LivingEntity _entity = (LivingEntity)entity;
                                                                                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                        }
                                                                                        int _valuexxxxxxxxxxxxxxxxx = 18;
                                                                                        BlockPos _posxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                        BlockState _bsxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxx);
                                                                                        Property property19 = _bsxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                        if (property19 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property19).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxx)) {
                                                                                            world.setBlock(_posxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxx)), 3);
                                                                                        }
                                                                                        if (world instanceof Level) {
                                                                                            Level _levelxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                            if (!_levelxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                _levelxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                            } else {
                                                                                                _levelxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        ItemStack itemStack37;
                                                                                        if (entity instanceof LivingEntity) {
                                                                                            LivingEntity _livEnt = (LivingEntity)entity;
                                                                                            itemStack37 = _livEnt.getMainHandItem();
                                                                                        } else {
                                                                                            itemStack37 = ItemStack.EMPTY;
                                                                                        }
                                                                                        if (itemStack37.getItem() == ButcheryModItems.SNOW_FOX_SKIN.get()) {
                                                                                            IntegerProperty _integerProp;
                                                                                            ItemStack itemStack38;
                                                                                            if (entity instanceof LivingEntity) {
                                                                                                LivingEntity _livEntxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                itemStack38 = _livEntxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack38 = ItemStack.EMPTY;
                                                                                            }
                                                                                            itemStack38.shrink(1);
                                                                                            if (entity instanceof LivingEntity) {
                                                                                                LivingEntity _entity = (LivingEntity)entity;
                                                                                                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                            }
                                                                                            int _valuexxxxxxxxxxxxxxxxxx = 19;
                                                                                            BlockPos _posxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                            BlockState _bsxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxx);
                                                                                            Property property20 = _bsxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                            if (property20 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property20).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxx)) {
                                                                                                world.setBlock(_posxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxx)), 3);
                                                                                            }
                                                                                            if (world instanceof Level) {
                                                                                                Level _levelxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                if (!_levelxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                    _levelxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                } else {
                                                                                                    _levelxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            ItemStack itemStack39;
                                                                                            if (entity instanceof LivingEntity) {
                                                                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                itemStack39 = _livEnt.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack39 = ItemStack.EMPTY;
                                                                                            }
                                                                                            if (itemStack39.getItem() == ButcheryModItems.WHITE_HORSE_SKIN.get()) {
                                                                                                IntegerProperty _integerProp;
                                                                                                ItemStack itemStack40;
                                                                                                if (entity instanceof LivingEntity) {
                                                                                                    LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                    itemStack40 = _livEntxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                                } else {
                                                                                                    itemStack40 = ItemStack.EMPTY;
                                                                                                }
                                                                                                itemStack40.shrink(1);
                                                                                                if (entity instanceof LivingEntity) {
                                                                                                    LivingEntity _entity = (LivingEntity)entity;
                                                                                                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                }
                                                                                                int _valuexxxxxxxxxxxxxxxxxxx = 20;
                                                                                                BlockPos _posxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                                BlockState _bsxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxx);
                                                                                                Property property21 = _bsxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                                if (property21 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property21).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxx)) {
                                                                                                    world.setBlock(_posxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxxx)), 3);
                                                                                                }
                                                                                                if (world instanceof Level) {
                                                                                                    Level _levelxxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                    if (!_levelxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                        _levelxxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                    } else {
                                                                                                        _levelxxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                ItemStack itemStack41;
                                                                                                if (entity instanceof LivingEntity) {
                                                                                                    LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                    itemStack41 = _livEnt.getMainHandItem();
                                                                                                } else {
                                                                                                    itemStack41 = ItemStack.EMPTY;
                                                                                                }
                                                                                                if (itemStack41.getItem() == ButcheryModItems.POLAR_BEAR_SKIN.get()) {
                                                                                                    IntegerProperty _integerProp;
                                                                                                    ItemStack itemStack42;
                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                        LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                        itemStack42 = _livEntxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                                    } else {
                                                                                                        itemStack42 = ItemStack.EMPTY;
                                                                                                    }
                                                                                                    itemStack42.shrink(1);
                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                        LivingEntity _entity = (LivingEntity)entity;
                                                                                                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                    }
                                                                                                    int _valuexxxxxxxxxxxxxxxxxxxx = 21;
                                                                                                    BlockPos _posxxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                                    BlockState _bsxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxx);
                                                                                                    Property property22 = _bsxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                                    if (property22 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property22).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxx)) {
                                                                                                        world.setBlock(_posxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxxxx)), 3);
                                                                                                    }
                                                                                                    if (world instanceof Level) {
                                                                                                        Level _levelxxxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                        if (!_levelxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                            _levelxxxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                        } else {
                                                                                                            _levelxxxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    ItemStack itemStack43;
                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                        LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                        itemStack43 = _livEnt.getMainHandItem();
                                                                                                    } else {
                                                                                                        itemStack43 = ItemStack.EMPTY;
                                                                                                    }
                                                                                                    if (itemStack43.getItem() == ButcheryModItems.BROWN_LLAMA_SKIN.get()) {
                                                                                                        IntegerProperty _integerProp;
                                                                                                        ItemStack itemStack44;
                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                            LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                            itemStack44 = _livEntxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                                        } else {
                                                                                                            itemStack44 = ItemStack.EMPTY;
                                                                                                        }
                                                                                                        itemStack44.shrink(1);
                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                            LivingEntity _entity = (LivingEntity)entity;
                                                                                                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                        }
                                                                                                        int _valuexxxxxxxxxxxxxxxxxxxxx = 22;
                                                                                                        BlockPos _posxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                                        BlockState _bsxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxx);
                                                                                                        Property property23 = _bsxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                                        if (property23 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property23).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxx)) {
                                                                                                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxxxxx)), 3);
                                                                                                        }
                                                                                                        if (world instanceof Level) {
                                                                                                            Level _levelxxxxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                            if (!_levelxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                                _levelxxxxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                            } else {
                                                                                                                _levelxxxxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                            }
                                                                                                        }
                                                                                                    } else {
                                                                                                        ItemStack itemStack45;
                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                            LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                            itemStack45 = _livEnt.getMainHandItem();
                                                                                                        } else {
                                                                                                            itemStack45 = ItemStack.EMPTY;
                                                                                                        }
                                                                                                        if (itemStack45.getItem() == ButcheryModItems.CREAMY_LLAMA_SKIN.get()) {
                                                                                                            IntegerProperty _integerProp;
                                                                                                            ItemStack itemStack46;
                                                                                                            if (entity instanceof LivingEntity) {
                                                                                                                LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                                itemStack46 = _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                                            } else {
                                                                                                                itemStack46 = ItemStack.EMPTY;
                                                                                                            }
                                                                                                            itemStack46.shrink(1);
                                                                                                            if (entity instanceof LivingEntity) {
                                                                                                                LivingEntity _entity = (LivingEntity)entity;
                                                                                                                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                            }
                                                                                                            int _valuexxxxxxxxxxxxxxxxxxxxxx = 23;
                                                                                                            BlockPos _posxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                                            BlockState _bsxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxx);
                                                                                                            Property property24 = _bsxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                                            if (property24 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property24).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxx)) {
                                                                                                                world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxxxxxx)), 3);
                                                                                                            }
                                                                                                            if (world instanceof Level) {
                                                                                                                Level _levelxxxxxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                                if (!_levelxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                                    _levelxxxxxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                                } else {
                                                                                                                    _levelxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                                }
                                                                                                            }
                                                                                                        } else {
                                                                                                            ItemStack itemStack47;
                                                                                                            if (entity instanceof LivingEntity) {
                                                                                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                                itemStack47 = _livEnt.getMainHandItem();
                                                                                                            } else {
                                                                                                                itemStack47 = ItemStack.EMPTY;
                                                                                                            }
                                                                                                            if (itemStack47.getItem() == ButcheryModItems.GRAY_LLAMA_SKIN.get()) {
                                                                                                                IntegerProperty _integerProp;
                                                                                                                ItemStack itemStack48;
                                                                                                                if (entity instanceof LivingEntity) {
                                                                                                                    LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                                    itemStack48 = _livEntxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                                                } else {
                                                                                                                    itemStack48 = ItemStack.EMPTY;
                                                                                                                }
                                                                                                                itemStack48.shrink(1);
                                                                                                                if (entity instanceof LivingEntity) {
                                                                                                                    LivingEntity _entity = (LivingEntity)entity;
                                                                                                                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                                }
                                                                                                                int _valuexxxxxxxxxxxxxxxxxxxxxxx = 24;
                                                                                                                BlockPos _posxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                                                BlockState _bsxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxx);
                                                                                                                Property property25 = _bsxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                                                if (property25 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property25).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxx)) {
                                                                                                                    world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxxxxxxx)), 3);
                                                                                                                }
                                                                                                                if (world instanceof Level) {
                                                                                                                    Level _levelxxxxxxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                                    if (!_levelxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                                        _levelxxxxxxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                                    } else {
                                                                                                                        _levelxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                                    }
                                                                                                                }
                                                                                                            } else {
                                                                                                                ItemStack itemStack49;
                                                                                                                if (entity instanceof LivingEntity) {
                                                                                                                    LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                                    itemStack49 = _livEnt.getMainHandItem();
                                                                                                                } else {
                                                                                                                    itemStack49 = ItemStack.EMPTY;
                                                                                                                }
                                                                                                                if (itemStack49.getItem() == ButcheryModItems.WHITE_LLAMA_SKIN.get()) {
                                                                                                                    IntegerProperty _integerProp;
                                                                                                                    ItemStack itemStack50;
                                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                                        LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                                        itemStack50 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                                                    } else {
                                                                                                                        itemStack50 = ItemStack.EMPTY;
                                                                                                                    }
                                                                                                                    itemStack50.shrink(1);
                                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                                        LivingEntity _entity = (LivingEntity)entity;
                                                                                                                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                                    }
                                                                                                                    int _valuexxxxxxxxxxxxxxxxxxxxxxxx = 25;
                                                                                                                    BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                                                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxx);
                                                                                                                    Property property26 = _bsxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                                                    if (property26 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property26).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxx)) {
                                                                                                                        world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxxxxxxxx)), 3);
                                                                                                                    }
                                                                                                                    if (world instanceof Level) {
                                                                                                                        Level _levelxxxxxxxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                                            _levelxxxxxxxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                                        } else {
                                                                                                                            _levelxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    ItemStack itemStack51;
                                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                                        LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                                        itemStack51 = _livEnt.getMainHandItem();
                                                                                                                    } else {
                                                                                                                        itemStack51 = ItemStack.EMPTY;
                                                                                                                    }
                                                                                                                    if (itemStack51.getItem() == ButcheryModItems.COW_SKIN.get()) {
                                                                                                                        IntegerProperty _integerProp;
                                                                                                                        ItemStack itemStack52;
                                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                                            LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                                            itemStack52 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                                                        } else {
                                                                                                                            itemStack52 = ItemStack.EMPTY;
                                                                                                                        }
                                                                                                                        itemStack52.shrink(1);
                                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                                            LivingEntity _entity = (LivingEntity)entity;
                                                                                                                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                                        }
                                                                                                                        int _valuexxxxxxxxxxxxxxxxxxxxxxxxx = 28;
                                                                                                                        BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                                                        BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxx);
                                                                                                                        Property property27 = _bsxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                                                        if (property27 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property27).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxx)) {
                                                                                                                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxxxxxxxxx)), 3);
                                                                                                                        }
                                                                                                                        if (world instanceof Level) {
                                                                                                                            Level _levelxxxxxxxxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                                            if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                                                _levelxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                                            } else {
                                                                                                                                _levelxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        ItemStack itemStack53;
                                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                                            LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                                            itemStack53 = _livEnt.getMainHandItem();
                                                                                                                        } else {
                                                                                                                            itemStack53 = ItemStack.EMPTY;
                                                                                                                        }
                                                                                                                        if (itemStack53.getItem() == ButcheryModItems.ZOGLIN_SKIN.get()) {
                                                                                                                            IntegerProperty _integerProp;
                                                                                                                            ItemStack itemStack54;
                                                                                                                            if (entity instanceof LivingEntity) {
                                                                                                                                LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                                                itemStack54 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                                                            } else {
                                                                                                                                itemStack54 = ItemStack.EMPTY;
                                                                                                                            }
                                                                                                                            itemStack54.shrink(1);
                                                                                                                            if (entity instanceof LivingEntity) {
                                                                                                                                LivingEntity _entity = (LivingEntity)entity;
                                                                                                                                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                                            }
                                                                                                                            int _valuexxxxxxxxxxxxxxxxxxxxxxxxxx = 29;
                                                                                                                            BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                                                            BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxx);
                                                                                                                            Property property28 = _bsxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                                                            if (property28 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property28).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                                                                                                                                world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxxxxxxxxxx)), 3);
                                                                                                                            }
                                                                                                                            if (world instanceof Level) {
                                                                                                                                Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                                                if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                                                    _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                                                } else {
                                                                                                                                    _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            ItemStack itemStack55;
                                                                                                                            if (entity instanceof LivingEntity) {
                                                                                                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                                                itemStack55 = _livEnt.getMainHandItem();
                                                                                                                            } else {
                                                                                                                                itemStack55 = ItemStack.EMPTY;
                                                                                                                            }
                                                                                                                            if (itemStack55.getItem() == ButcheryModItems.CAMEL_SKIN.get()) {
                                                                                                                                IntegerProperty _integerProp;
                                                                                                                                ItemStack itemStack56;
                                                                                                                                if (entity instanceof LivingEntity) {
                                                                                                                                    LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                                                                    itemStack56 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                                                                                } else {
                                                                                                                                    itemStack56 = ItemStack.EMPTY;
                                                                                                                                }
                                                                                                                                itemStack56.shrink(1);
                                                                                                                                if (entity instanceof LivingEntity) {
                                                                                                                                    LivingEntity _entity = (LivingEntity)entity;
                                                                                                                                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                                                }
                                                                                                                                int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxx = 31;
                                                                                                                                BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                                                                                                                                BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                                                                                                                                Property property29 = _bsxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                                                                                                                                if (property29 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property29).getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                                                                                                                                    world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxx)), 3);
                                                                                                                                }
                                                                                                                                if (world instanceof Level) {
                                                                                                                                    Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx = (Level)world;
                                                                                                                                    if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                                                                                                                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                                                    } else {
                                                                                                                                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
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
                            }
                        }
                    }
                }
            }
        }
    }
}

