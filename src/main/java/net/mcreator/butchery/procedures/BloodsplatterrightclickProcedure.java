package net.mcreator.butchery.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class BloodsplatterrightclickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity != null) {
            ItemStack itemStack;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity)entity;
                itemStack = _livEnt.getMainHandItem();
            } else {
                itemStack = ItemStack.EMPTY;
            }
            if (itemStack.getItem() == Blocks.AIR.asItem()) {
                int n;
                Property property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip3 = (IntegerProperty)property;
                    n = (Integer)blockstate.getValue((Property)_getip3);
                } else {
                    n = -1;
                }
                if (n == 0) {
                    IntegerProperty _integerProp;
                    int _value = 1;
                    BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property2 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property2).getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
                    }
                } else {
                    int n2;
                    Property _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (_value instanceof IntegerProperty) {
                        Property<?> _getip6 = (IntegerProperty)_value;
                        n2 = (Integer)blockstate.getValue((Property)_getip6);
                    } else {
                        n2 = -1;
                    }
                    if (n2 == 1) {
                        IntegerProperty _integerProp;
                        int _value2 = 2;
                        BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                        BlockState _bs = world.getBlockState(_pos);
                        Property property3 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property3 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property3).getPossibleValues().contains(_value2)) {
                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value2)), 3);
                        }
                    } else {
                        int n3;
                        _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                        if (_value instanceof IntegerProperty) {
                            Property<?> _getip9 = (IntegerProperty)_value;
                            n3 = (Integer)blockstate.getValue((Property)_getip9);
                        } else {
                            n3 = -1;
                        }
                        if (n3 == 2) {
                            IntegerProperty _integerProp;
                            int _value3 = 3;
                            BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                            BlockState _bs = world.getBlockState(_pos);
                            Property property4 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property4 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property4).getPossibleValues().contains(_value3)) {
                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value3)), 3);
                            }
                        } else {
                            int n4;
                            _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                            if (_value instanceof IntegerProperty) {
                                Property<?> _getip12 = (IntegerProperty)_value;
                                n4 = (Integer)blockstate.getValue((Property)_getip12);
                            } else {
                                n4 = -1;
                            }
                            if (n4 == 3) {
                                IntegerProperty _integerProp;
                                int _value4 = 4;
                                BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                                BlockState _bs = world.getBlockState(_pos);
                                Property property5 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                                if (property5 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property5).getPossibleValues().contains(_value4)) {
                                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value4)), 3);
                                }
                            } else {
                                int n5;
                                _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                if (_value instanceof IntegerProperty) {
                                    Property<?> _getip15 = (IntegerProperty)_value;
                                    n5 = (Integer)blockstate.getValue((Property)_getip15);
                                } else {
                                    n5 = -1;
                                }
                                if (n5 == 4) {
                                    IntegerProperty _integerProp;
                                    int _value5 = 5;
                                    BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                                    BlockState _bs = world.getBlockState(_pos);
                                    Property property6 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                                    if (property6 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property6).getPossibleValues().contains(_value5)) {
                                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value5)), 3);
                                    }
                                } else {
                                    int n6;
                                    _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                    if (_value instanceof IntegerProperty) {
                                        Property<?> _getip18 = (IntegerProperty)_value;
                                        n6 = (Integer)blockstate.getValue((Property)_getip18);
                                    } else {
                                        n6 = -1;
                                    }
                                    if (n6 == 5) {
                                        IntegerProperty _integerProp;
                                        int _value6 = 6;
                                        BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                                        BlockState _bs = world.getBlockState(_pos);
                                        Property property7 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                                        if (property7 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property7).getPossibleValues().contains(_value6)) {
                                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value6)), 3);
                                        }
                                    } else {
                                        int n7;
                                        _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                        if (_value instanceof IntegerProperty) {
                                            Property<?> _getip21 = (IntegerProperty)_value;
                                            n7 = (Integer)blockstate.getValue((Property)_getip21);
                                        } else {
                                            n7 = -1;
                                        }
                                        if (n7 == 6) {
                                            IntegerProperty _integerProp;
                                            int _value7 = 7;
                                            BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                                            BlockState _bs = world.getBlockState(_pos);
                                            Property property8 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                                            if (property8 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property8).getPossibleValues().contains(_value7)) {
                                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value7)), 3);
                                            }
                                        } else {
                                            int n8;
                                            _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                            if (_value instanceof IntegerProperty) {
                                                Property<?> _getip24 = (IntegerProperty)_value;
                                                n8 = (Integer)blockstate.getValue((Property)_getip24);
                                            } else {
                                                n8 = -1;
                                            }
                                            if (n8 == 7) {
                                                IntegerProperty _integerProp;
                                                int _value8 = 8;
                                                BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                                                BlockState _bs = world.getBlockState(_pos);
                                                Property property9 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                                                if (property9 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property9).getPossibleValues().contains(_value8)) {
                                                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value8)), 3);
                                                }
                                            } else {
                                                int n9;
                                                _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                                if (_value instanceof IntegerProperty) {
                                                    Property<?> _getip27 = (IntegerProperty)_value;
                                                    n9 = (Integer)blockstate.getValue((Property)_getip27);
                                                } else {
                                                    n9 = -1;
                                                }
                                                if (n9 == 8) {
                                                    IntegerProperty _integerProp;
                                                    int _value9 = 9;
                                                    BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                                                    BlockState _bs = world.getBlockState(_pos);
                                                    Property property10 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                                                    if (property10 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property10).getPossibleValues().contains(_value9)) {
                                                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value9)), 3);
                                                    }
                                                } else {
                                                    int n10;
                                                    _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                                    if (_value instanceof IntegerProperty) {
                                                        Property<?> _getip30 = (IntegerProperty)_value;
                                                        n10 = (Integer)blockstate.getValue((Property)_getip30);
                                                    } else {
                                                        n10 = -1;
                                                    }
                                                    if (n10 == 9) {
                                                        IntegerProperty _integerProp;
                                                        int _value10 = 10;
                                                        BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                                                        BlockState _bs = world.getBlockState(_pos);
                                                        Property property11 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                                                        if (property11 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property11).getPossibleValues().contains(_value10)) {
                                                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value10)), 3);
                                                        }
                                                    } else {
                                                        int n11;
                                                        _value = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                                        if (_value instanceof IntegerProperty) {
                                                            Property<?> _getip33 = (IntegerProperty)_value;
                                                            n11 = (Integer)blockstate.getValue((Property)_getip33);
                                                        } else {
                                                            n11 = -1;
                                                        }
                                                        if (n11 == 10) {
                                                            IntegerProperty _integerProp;
                                                            int _value11 = 0;
                                                            BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                                                            BlockState _bs = world.getBlockState(_pos);
                                                            Property property12 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                                                            if (property12 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property12).getPossibleValues().contains(_value11)) {
                                                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value11)), 3);
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

