package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/* JADX INFO: loaded from: WoodenspitrotisserieNeighbourBlockChangesProcedure.class */
public class WoodenspitrotisserieNeighbourBlockChangesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock() == Blocks.CAMPFIRE) {
            ButcheryMod.queueServerWork(1800, () -> {
                int iIntValue;
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()) {
                    Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property instanceof IntegerProperty) {
                        Property<?> _getip5 = property;
                        iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip5)).intValue();
                    } else {
                        iIntValue = -1;
                    }
                    if (iIntValue != 1) {
                        return;
                    }
                }
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                Property<?> property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                if (property2 instanceof IntegerProperty) {
                    IntegerProperty _integerProp = (IntegerProperty) property2;
                    if (_integerProp.getPossibleValues().contains(2)) {
                        world.setBlock(_pos, (BlockState) _bs.setValue(_integerProp, 2), 3);
                    }
                }
                ButcheryMod.queueServerWork(1800, () -> {
                    int iIntValue2;
                    if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()) {
                        Property<?> property3 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property3 instanceof IntegerProperty) {
                            Property<?> _getip10 = property3;
                            iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip10)).intValue();
                        } else {
                            iIntValue2 = -1;
                        }
                        if (iIntValue2 != 2) {
                            return;
                        }
                    }
                    BlockPos _posx = BlockPos.containing(x, y, z);
                    BlockState _bsx = world.getBlockState(_posx);
                    Property<?> property4 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property4 instanceof IntegerProperty) {
                        IntegerProperty _integerPropx = (IntegerProperty) property4;
                        if (_integerPropx.getPossibleValues().contains(3)) {
                            world.setBlock(_posx, (BlockState) _bsx.setValue(_integerPropx, 3), 3);
                        }
                    }
                });
            });
        }
    }
}
