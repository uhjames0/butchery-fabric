package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModMenus;
import net.mcreator.butchery.world.inventory.TaxidermystationguiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/* JADX INFO: loaded from: TaxidermytableOnBlockRightClickedProcedure.class */
public class TaxidermytableOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        int iIntValue5;
        if (entity != null) {
            Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip1 = property;
                iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip1)).intValue();
            } else {
                iIntValue = -1;
            }
            if (iIntValue == 0) {
                if (entity instanceof ServerPlayer) {
                    ServerPlayer _ent = (ServerPlayer) entity;
                    BlockPos _bpos = BlockPos.containing(x, y, z);
                    _ent.openMenu(ButcheryModMenus.posMenuProvider("Taxidermystationgui", _bpos, (id, inv) -> {
                        return new TaxidermystationguiMenu(id.intValue(), inv, ButcheryModMenus.bufWithPos(_bpos));
                    }));
                    return;
                }
                return;
            }
            if (getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z))) == Direction.NORTH) {
                Property<?> property2 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property2 instanceof IntegerProperty) {
                    Property<?> _getip7 = property2;
                    iIntValue5 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip7)).intValue();
                } else {
                    iIntValue5 = -1;
                }
                if (iIntValue5 == 1 && world.getBlockState(BlockPos.containing(x - 1.0d, y, z)).getBlock() == ButcheryModBlocks.TAXIDERMY_TABLE.get()) {
                    if (entity instanceof ServerPlayer) {
                        ServerPlayer _ent2 = (ServerPlayer) entity;
                        BlockPos _bpos2 = BlockPos.containing(x - 1.0d, y, z);
                        _ent2.openMenu(ButcheryModMenus.posMenuProvider("Taxidermystationgui", _bpos2, (id2, inv2) -> {
                            return new TaxidermystationguiMenu(id2.intValue(), inv2, ButcheryModMenus.bufWithPos(_bpos2));
                        }));
                        return;
                    }
                    return;
                }
            }
            if (getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z))) == Direction.SOUTH) {
                Property<?> property3 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property3 instanceof IntegerProperty) {
                    Property<?> _getip15 = property3;
                    iIntValue4 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip15)).intValue();
                } else {
                    iIntValue4 = -1;
                }
                if (iIntValue4 == 1 && world.getBlockState(BlockPos.containing(x + 1.0d, y, z)).getBlock() == ButcheryModBlocks.TAXIDERMY_TABLE.get()) {
                    if (entity instanceof ServerPlayer) {
                        ServerPlayer _ent3 = (ServerPlayer) entity;
                        BlockPos _bpos3 = BlockPos.containing(x + 1.0d, y, z);
                        _ent3.openMenu(ButcheryModMenus.posMenuProvider("Taxidermystationgui", _bpos3, (id3, inv3) -> {
                            return new TaxidermystationguiMenu(id3.intValue(), inv3, ButcheryModMenus.bufWithPos(_bpos3));
                        }));
                        return;
                    }
                    return;
                }
            }
            if (getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z))) == Direction.WEST) {
                Property<?> property4 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property4 instanceof IntegerProperty) {
                    Property<?> _getip23 = property4;
                    iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip23)).intValue();
                } else {
                    iIntValue3 = -1;
                }
                if (iIntValue3 == 1 && world.getBlockState(BlockPos.containing(x, y, z + 1.0d)).getBlock() == ButcheryModBlocks.TAXIDERMY_TABLE.get()) {
                    if (entity instanceof ServerPlayer) {
                        ServerPlayer _ent4 = (ServerPlayer) entity;
                        BlockPos _bpos4 = BlockPos.containing(x, y, z + 1.0d);
                        _ent4.openMenu(ButcheryModMenus.posMenuProvider("Taxidermystationgui", _bpos4, (id4, inv4) -> {
                            return new TaxidermystationguiMenu(id4.intValue(), inv4, ButcheryModMenus.bufWithPos(_bpos4));
                        }));
                        return;
                    }
                    return;
                }
            }
            if (getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z))) == Direction.EAST) {
                Property<?> property5 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property5 instanceof IntegerProperty) {
                    Property<?> _getip31 = property5;
                    iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip31)).intValue();
                } else {
                    iIntValue2 = -1;
                }
                if (iIntValue2 == 1 && world.getBlockState(BlockPos.containing(x, y, z - 1.0d)).getBlock() == ButcheryModBlocks.TAXIDERMY_TABLE.get() && (entity instanceof ServerPlayer)) {
                    ServerPlayer _ent5 = (ServerPlayer) entity;
                    BlockPos _bpos5 = BlockPos.containing(x, y, z - 1.0d);
                    _ent5.openMenu(ButcheryModMenus.posMenuProvider("Taxidermystationgui", _bpos5, (id5, inv5) -> {
                        return new TaxidermystationguiMenu(id5.intValue(), inv5, ButcheryModMenus.bufWithPos(_bpos5));
                    }));
                }
            }
        }
    }

    private static Direction getDirectionFromBlockState(BlockState blockState) {
        Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property instanceof EnumProperty) {
            EnumProperty ep = (EnumProperty) property;
            if (ep.getValueClass() == Direction.class) {
                return (Direction) blockState.getValue(ep);
            }
        }
        Property<?> property2 = blockState.getBlock().getStateDefinition().getProperty("axis");
        if (property2 instanceof EnumProperty) {
            EnumProperty ep2 = (EnumProperty) property2;
            if (ep2.getValueClass() == Direction.Axis.class) {
                return Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep2), Direction.AxisDirection.POSITIVE);
            }
        }
        return Direction.NORTH;
    }
}
