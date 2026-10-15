package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class TaxidermytableBlockAddedProcedure {
    /*
     * Enabled aggressive block sorting
     */
    public static void execute(LevelAccessor world, double x, double y, double z) {
        int n;
        Property property;
        if (TaxidermytableBlockAddedProcedure.getDirectionFromBlockState(world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z))) == Direction.NORTH) {
            int n2;
            property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip4 = (IntegerProperty)property;
                n2 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip4);
            } else {
                n2 = -1;
            }
            if (n2 == 0 && world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)z)).getBlock() == Blocks.AIR) {
                world.setBlock(BlockPos.containing((double)(x + 1.0), (double)y, (double)z), new Object(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public BlockState with(BlockState _bs, String _property, int _newValue) {
                        BlockState blockState;
                        Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        if (_prop instanceof IntegerProperty) {
                            Property<?> _ip = (IntegerProperty)_prop;
                            if (_prop.getPossibleValues().contains(_newValue)) {
                                blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                                return blockState;
                            }
                        }
                        blockState = _bs;
                        return blockState;
                    }
                }.with(((Block)ButcheryModBlocks.TAXIDERMY_TABLE.get()).defaultBlockState(), "blockstate", 1), 3);
                return;
            }
        }
        if (TaxidermytableBlockAddedProcedure.getDirectionFromBlockState(world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z))) == Direction.SOUTH) {
            int n3;
            property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip13 = (IntegerProperty)property;
                n3 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip13);
            } else {
                n3 = -1;
            }
            if (n3 == 0 && world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)z)).getBlock() == Blocks.AIR) {
                world.setBlock(BlockPos.containing((double)(x - 1.0), (double)y, (double)z), TaxidermytableBlockAddedProcedure.blockStateWithDirection(new Object(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public BlockState with(BlockState _bs, String _property, int _newValue) {
                        BlockState blockState;
                        Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        if (_prop instanceof IntegerProperty) {
                            Property<?> _ip = (IntegerProperty)_prop;
                            if (_prop.getPossibleValues().contains(_newValue)) {
                                blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                                return blockState;
                            }
                        }
                        blockState = _bs;
                        return blockState;
                    }
                }.with(((Block)ButcheryModBlocks.TAXIDERMY_TABLE.get()).defaultBlockState(), "blockstate", 1), Direction.SOUTH), 3);
                return;
            }
        }
        if (TaxidermytableBlockAddedProcedure.getDirectionFromBlockState(world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z))) == Direction.WEST) {
            int n4;
            property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip23 = (IntegerProperty)property;
                n4 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip23);
            } else {
                n4 = -1;
            }
            if (n4 == 0 && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z - 1.0))).getBlock() == Blocks.AIR) {
                world.setBlock(BlockPos.containing((double)x, (double)y, (double)(z - 1.0)), TaxidermytableBlockAddedProcedure.blockStateWithDirection(new Object(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public BlockState with(BlockState _bs, String _property, int _newValue) {
                        BlockState blockState;
                        Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        if (_prop instanceof IntegerProperty) {
                            Property<?> _ip = (IntegerProperty)_prop;
                            if (_prop.getPossibleValues().contains(_newValue)) {
                                blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                                return blockState;
                            }
                        }
                        blockState = _bs;
                        return blockState;
                    }
                }.with(((Block)ButcheryModBlocks.TAXIDERMY_TABLE.get()).defaultBlockState(), "blockstate", 1), Direction.WEST), 3);
                return;
            }
        }
        if (TaxidermytableBlockAddedProcedure.getDirectionFromBlockState(world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z))) != Direction.EAST) return;
        property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
        if (property instanceof IntegerProperty) {
            Property<?> _getip33 = (IntegerProperty)property;
            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip33);
        } else {
            n = -1;
        }
        if (n != 0) return;
        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z + 1.0))).getBlock() != Blocks.AIR) return;
        world.setBlock(BlockPos.containing((double)x, (double)y, (double)(z + 1.0)), TaxidermytableBlockAddedProcedure.blockStateWithDirection(new Object(){

            /*
             * Enabled aggressive block sorting
             */
            public BlockState with(BlockState _bs, String _property, int _newValue) {
                BlockState blockState;
                Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                if (_prop instanceof IntegerProperty) {
                    Property<?> _ip = (IntegerProperty)_prop;
                    if (_prop.getPossibleValues().contains(_newValue)) {
                        blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                        return blockState;
                    }
                }
                blockState = _bs;
                return blockState;
            }
        }.with(((Block)ButcheryModBlocks.TAXIDERMY_TABLE.get()).defaultBlockState(), "blockstate", 1), Direction.EAST), 3);
    }

    private static Direction getDirectionFromBlockState(BlockState blockState) {
        EnumProperty ep;
        EnumProperty ep2;
        Property property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property instanceof EnumProperty && (ep2 = (EnumProperty)property).getValueClass() == Direction.class) {
            return (Direction)blockState.getValue((Property)ep2);
        }
        Property property2 = blockState.getBlock().getStateDefinition().getProperty("axis");
        return property2 instanceof EnumProperty && (ep = (EnumProperty)property2).getValueClass() == Direction.Axis.class ? Direction.fromAxisAndDirection((Direction.Axis)((Direction.Axis)blockState.getValue((Property)ep)), (Direction.AxisDirection)Direction.AxisDirection.POSITIVE) : Direction.NORTH;
    }

    private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
        EnumProperty enumProperty;
        EnumProperty enumProperty2;
        Property property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property instanceof EnumProperty && (enumProperty2 = (EnumProperty)property).getPossibleValues().contains(newValue)) {
            return (BlockState)blockState.setValue((Property)enumProperty2, (Comparable)newValue);
        }
        Property property2 = blockState.getBlock().getStateDefinition().getProperty("axis");
        return property2 instanceof EnumProperty && (enumProperty = (EnumProperty)property2).getPossibleValues().contains(newValue.getAxis()) ? (BlockState)blockState.setValue((Property)enumProperty, (Comparable)newValue.getAxis()) : blockState;
    }
}

