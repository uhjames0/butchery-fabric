package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModFluids;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.FluidHandler;
import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;

/* JADX INFO: loaded from: FillinfectedbloodgrateProcedure.class */
public class FillinfectedbloodgrateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        int iIntValue5;
        int iIntValue6;
        int iIntValue7;
        int iIntValue8;
        int iIntValue9;
        int iIntValue10;
        int iIntValue11;
        int iIntValue12;
        int iIntValue13;
        int iIntValue14;
        int iIntValue15;
        int iIntValue16;
        if (world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 1.0d, z), null});
            if (_fluidHandler != null) {
                _fluidHandler.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y - 1.0d, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null) {
                    ButcheryPersistentData.of(_blockEntity).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntity).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntity).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntity).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntity).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level = (Level) world;
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            }
            Property<?> property = world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip9 = property;
                iIntValue16 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getValue(_getip9)).intValue();
            } else {
                iIntValue16 = -1;
            }
            if (iIntValue16 != 0) {
                BlockPos _pos = BlockPos.containing(x, y - 1.0d, z);
                BlockState _bsx = world.getBlockState(_pos);
                Property<?> property2 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property2 instanceof IntegerProperty) {
                    IntegerProperty _integerProp = (IntegerProperty) property2;
                    if (_integerProp.getPossibleValues().contains(0)) {
                        world.setBlock(_pos, (BlockState) _bsx.setValue(_integerProp, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 2.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler2 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 2.0d, z), null});
            if (_fluidHandler2 != null) {
                _fluidHandler2.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpx = BlockPos.containing(x, y - 2.0d, z);
                BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                BlockState _bsx2 = world.getBlockState(_bpx);
                if (_blockEntityx != null) {
                    ButcheryPersistentData.of(_blockEntityx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level2 = (Level) world;
                    _level2.sendBlockUpdated(_bpx, _bsx2, _bsx2, 3);
                }
            }
            Property<?> property3 = world.getBlockState(BlockPos.containing(x, y - 2.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property3 instanceof IntegerProperty) {
                Property<?> _getip20 = property3;
                iIntValue15 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 2.0d, z)).getValue(_getip20)).intValue();
            } else {
                iIntValue15 = -1;
            }
            if (iIntValue15 != 0) {
                BlockPos _pos2 = BlockPos.containing(x, y - 2.0d, z);
                BlockState _bsxx = world.getBlockState(_pos2);
                Property<?> property4 = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property4 instanceof IntegerProperty) {
                    IntegerProperty _integerProp2 = (IntegerProperty) property4;
                    if (_integerProp2.getPossibleValues().contains(0)) {
                        world.setBlock(_pos2, (BlockState) _bsxx.setValue(_integerProp2, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 3.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler3 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 3.0d, z), null});
            if (_fluidHandler3 != null) {
                _fluidHandler3.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxx = BlockPos.containing(x, y - 3.0d, z);
                BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                BlockState _bsxx2 = world.getBlockState(_bpxx);
                if (_blockEntityxx != null) {
                    ButcheryPersistentData.of(_blockEntityxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level3 = (Level) world;
                    _level3.sendBlockUpdated(_bpxx, _bsxx2, _bsxx2, 3);
                }
            }
            Property<?> property5 = world.getBlockState(BlockPos.containing(x, y - 3.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property5 instanceof IntegerProperty) {
                Property<?> _getip31 = property5;
                iIntValue14 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 3.0d, z)).getValue(_getip31)).intValue();
            } else {
                iIntValue14 = -1;
            }
            if (iIntValue14 != 0) {
                BlockPos _pos3 = BlockPos.containing(x, y - 3.0d, z);
                BlockState _bsxxx = world.getBlockState(_pos3);
                Property<?> property6 = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property6 instanceof IntegerProperty) {
                    IntegerProperty _integerProp3 = (IntegerProperty) property6;
                    if (_integerProp3.getPossibleValues().contains(0)) {
                        world.setBlock(_pos3, (BlockState) _bsxxx.setValue(_integerProp3, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 4.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler4 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 4.0d, z), null});
            if (_fluidHandler4 != null) {
                _fluidHandler4.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxx = BlockPos.containing(x, y - 4.0d, z);
                BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                BlockState _bsxxx2 = world.getBlockState(_bpxxx);
                if (_blockEntityxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level4 = (Level) world;
                    _level4.sendBlockUpdated(_bpxxx, _bsxxx2, _bsxxx2, 3);
                }
            }
            Property<?> property7 = world.getBlockState(BlockPos.containing(x, y - 4.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property7 instanceof IntegerProperty) {
                Property<?> _getip42 = property7;
                iIntValue13 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 4.0d, z)).getValue(_getip42)).intValue();
            } else {
                iIntValue13 = -1;
            }
            if (iIntValue13 != 0) {
                BlockPos _pos4 = BlockPos.containing(x, y - 4.0d, z);
                BlockState _bsxxxx = world.getBlockState(_pos4);
                Property<?> property8 = _bsxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property8 instanceof IntegerProperty) {
                    IntegerProperty _integerProp4 = (IntegerProperty) property8;
                    if (_integerProp4.getPossibleValues().contains(0)) {
                        world.setBlock(_pos4, (BlockState) _bsxxxx.setValue(_integerProp4, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 5.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler5 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 5.0d, z), null});
            if (_fluidHandler5 != null) {
                _fluidHandler5.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxx = BlockPos.containing(x, y - 5.0d, z);
                BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                BlockState _bsxxxx2 = world.getBlockState(_bpxxxx);
                if (_blockEntityxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level5 = (Level) world;
                    _level5.sendBlockUpdated(_bpxxxx, _bsxxxx2, _bsxxxx2, 3);
                }
            }
            Property<?> property9 = world.getBlockState(BlockPos.containing(x, y - 5.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property9 instanceof IntegerProperty) {
                Property<?> _getip53 = property9;
                iIntValue12 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 5.0d, z)).getValue(_getip53)).intValue();
            } else {
                iIntValue12 = -1;
            }
            if (iIntValue12 != 0) {
                BlockPos _pos5 = BlockPos.containing(x, y - 5.0d, z);
                BlockState _bsxxxxx = world.getBlockState(_pos5);
                Property<?> property10 = _bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property10 instanceof IntegerProperty) {
                    IntegerProperty _integerProp5 = (IntegerProperty) property10;
                    if (_integerProp5.getPossibleValues().contains(0)) {
                        world.setBlock(_pos5, (BlockState) _bsxxxxx.setValue(_integerProp5, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 6.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler6 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 6.0d, z), null});
            if (_fluidHandler6 != null) {
                _fluidHandler6.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxx = BlockPos.containing(x, y - 6.0d, z);
                BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                BlockState _bsxxxxx2 = world.getBlockState(_bpxxxxx);
                if (_blockEntityxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level6 = (Level) world;
                    _level6.sendBlockUpdated(_bpxxxxx, _bsxxxxx2, _bsxxxxx2, 3);
                }
            }
            Property<?> property11 = world.getBlockState(BlockPos.containing(x, y - 6.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property11 instanceof IntegerProperty) {
                Property<?> _getip64 = property11;
                iIntValue11 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 6.0d, z)).getValue(_getip64)).intValue();
            } else {
                iIntValue11 = -1;
            }
            if (iIntValue11 != 0) {
                BlockPos _pos6 = BlockPos.containing(x, y - 6.0d, z);
                BlockState _bsxxxxxx = world.getBlockState(_pos6);
                Property<?> property12 = _bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property12 instanceof IntegerProperty) {
                    IntegerProperty _integerProp6 = (IntegerProperty) property12;
                    if (_integerProp6.getPossibleValues().contains(0)) {
                        world.setBlock(_pos6, (BlockState) _bsxxxxxx.setValue(_integerProp6, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 7.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler7 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 7.0d, z), null});
            if (_fluidHandler7 != null) {
                _fluidHandler7.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxx = BlockPos.containing(x, y - 7.0d, z);
                BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
                BlockState _bsxxxxxx2 = world.getBlockState(_bpxxxxxx);
                if (_blockEntityxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level7 = (Level) world;
                    _level7.sendBlockUpdated(_bpxxxxxx, _bsxxxxxx2, _bsxxxxxx2, 3);
                }
            }
            Property<?> property13 = world.getBlockState(BlockPos.containing(x, y - 7.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property13 instanceof IntegerProperty) {
                Property<?> _getip75 = property13;
                iIntValue10 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 7.0d, z)).getValue(_getip75)).intValue();
            } else {
                iIntValue10 = -1;
            }
            if (iIntValue10 != 0) {
                BlockPos _pos7 = BlockPos.containing(x, y - 7.0d, z);
                BlockState _bsxxxxxxx = world.getBlockState(_pos7);
                Property<?> property14 = _bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property14 instanceof IntegerProperty) {
                    IntegerProperty _integerProp7 = (IntegerProperty) property14;
                    if (_integerProp7.getPossibleValues().contains(0)) {
                        world.setBlock(_pos7, (BlockState) _bsxxxxxxx.setValue(_integerProp7, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 8.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler8 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 8.0d, z), null});
            if (_fluidHandler8 != null) {
                _fluidHandler8.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxx = BlockPos.containing(x, y - 8.0d, z);
                BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
                BlockState _bsxxxxxxx2 = world.getBlockState(_bpxxxxxxx);
                if (_blockEntityxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level8 = (Level) world;
                    _level8.sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxx2, _bsxxxxxxx2, 3);
                }
            }
            Property<?> property15 = world.getBlockState(BlockPos.containing(x, y - 8.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property15 instanceof IntegerProperty) {
                Property<?> _getip86 = property15;
                iIntValue9 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 8.0d, z)).getValue(_getip86)).intValue();
            } else {
                iIntValue9 = -1;
            }
            if (iIntValue9 != 0) {
                BlockPos _pos8 = BlockPos.containing(x, y - 8.0d, z);
                BlockState _bsxxxxxxxx = world.getBlockState(_pos8);
                Property<?> property16 = _bsxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property16 instanceof IntegerProperty) {
                    IntegerProperty _integerProp8 = (IntegerProperty) property16;
                    if (_integerProp8.getPossibleValues().contains(0)) {
                        world.setBlock(_pos8, (BlockState) _bsxxxxxxxx.setValue(_integerProp8, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 9.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler9 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 9.0d, z), null});
            if (_fluidHandler9 != null) {
                _fluidHandler9.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxxx = BlockPos.containing(x, y - 9.0d, z);
                BlockEntity _blockEntityxxxxxxxx = world.getBlockEntity(_bpxxxxxxxx);
                BlockState _bsxxxxxxxx2 = world.getBlockState(_bpxxxxxxxx);
                if (_blockEntityxxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level9 = (Level) world;
                    _level9.sendBlockUpdated(_bpxxxxxxxx, _bsxxxxxxxx2, _bsxxxxxxxx2, 3);
                }
            }
            Property<?> property17 = world.getBlockState(BlockPos.containing(x, y - 9.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property17 instanceof IntegerProperty) {
                Property<?> _getip97 = property17;
                iIntValue8 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 9.0d, z)).getValue(_getip97)).intValue();
            } else {
                iIntValue8 = -1;
            }
            if (iIntValue8 != 0) {
                BlockPos _pos9 = BlockPos.containing(x, y - 9.0d, z);
                BlockState _bsxxxxxxxxx = world.getBlockState(_pos9);
                Property<?> property18 = _bsxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property18 instanceof IntegerProperty) {
                    IntegerProperty _integerProp9 = (IntegerProperty) property18;
                    if (_integerProp9.getPossibleValues().contains(0)) {
                        world.setBlock(_pos9, (BlockState) _bsxxxxxxxxx.setValue(_integerProp9, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 10.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler10 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 10.0d, z), null});
            if (_fluidHandler10 != null) {
                _fluidHandler10.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxxxx = BlockPos.containing(x, y - 10.0d, z);
                BlockEntity _blockEntityxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxx);
                BlockState _bsxxxxxxxxx2 = world.getBlockState(_bpxxxxxxxxx);
                if (_blockEntityxxxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level10 = (Level) world;
                    _level10.sendBlockUpdated(_bpxxxxxxxxx, _bsxxxxxxxxx2, _bsxxxxxxxxx2, 3);
                }
            }
            Property<?> property19 = world.getBlockState(BlockPos.containing(x, y - 10.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property19 instanceof IntegerProperty) {
                Property<?> _getip108 = property19;
                iIntValue7 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 10.0d, z)).getValue(_getip108)).intValue();
            } else {
                iIntValue7 = -1;
            }
            if (iIntValue7 != 0) {
                BlockPos _pos10 = BlockPos.containing(x, y - 10.0d, z);
                BlockState _bsxxxxxxxxxx = world.getBlockState(_pos10);
                Property<?> property20 = _bsxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property20 instanceof IntegerProperty) {
                    IntegerProperty _integerProp10 = (IntegerProperty) property20;
                    if (_integerProp10.getPossibleValues().contains(0)) {
                        world.setBlock(_pos10, (BlockState) _bsxxxxxxxxxx.setValue(_integerProp10, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 11.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler11 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 11.0d, z), null});
            if (_fluidHandler11 != null) {
                _fluidHandler11.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxxxxx = BlockPos.containing(x, y - 11.0d, z);
                BlockEntity _blockEntityxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxx);
                BlockState _bsxxxxxxxxxx2 = world.getBlockState(_bpxxxxxxxxxx);
                if (_blockEntityxxxxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level11 = (Level) world;
                    _level11.sendBlockUpdated(_bpxxxxxxxxxx, _bsxxxxxxxxxx2, _bsxxxxxxxxxx2, 3);
                }
            }
            Property<?> property21 = world.getBlockState(BlockPos.containing(x, y - 11.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property21 instanceof IntegerProperty) {
                Property<?> _getip119 = property21;
                iIntValue6 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 11.0d, z)).getValue(_getip119)).intValue();
            } else {
                iIntValue6 = -1;
            }
            if (iIntValue6 != 0) {
                BlockPos _pos11 = BlockPos.containing(x, y - 11.0d, z);
                BlockState _bsxxxxxxxxxxx = world.getBlockState(_pos11);
                Property<?> property22 = _bsxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property22 instanceof IntegerProperty) {
                    IntegerProperty _integerProp11 = (IntegerProperty) property22;
                    if (_integerProp11.getPossibleValues().contains(0)) {
                        world.setBlock(_pos11, (BlockState) _bsxxxxxxxxxxx.setValue(_integerProp11, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 12.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler12 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 12.0d, z), null});
            if (_fluidHandler12 != null) {
                _fluidHandler12.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxxxxxx = BlockPos.containing(x, y - 12.0d, z);
                BlockEntity _blockEntityxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxx);
                BlockState _bsxxxxxxxxxxx2 = world.getBlockState(_bpxxxxxxxxxxx);
                if (_blockEntityxxxxxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level12 = (Level) world;
                    _level12.sendBlockUpdated(_bpxxxxxxxxxxx, _bsxxxxxxxxxxx2, _bsxxxxxxxxxxx2, 3);
                }
            }
            Property<?> property23 = world.getBlockState(BlockPos.containing(x, y - 12.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property23 instanceof IntegerProperty) {
                Property<?> _getip130 = property23;
                iIntValue5 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 12.0d, z)).getValue(_getip130)).intValue();
            } else {
                iIntValue5 = -1;
            }
            if (iIntValue5 != 0) {
                BlockPos _pos12 = BlockPos.containing(x, y - 12.0d, z);
                BlockState _bsxxxxxxxxxxxx = world.getBlockState(_pos12);
                Property<?> property24 = _bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property24 instanceof IntegerProperty) {
                    IntegerProperty _integerProp12 = (IntegerProperty) property24;
                    if (_integerProp12.getPossibleValues().contains(0)) {
                        world.setBlock(_pos12, (BlockState) _bsxxxxxxxxxxxx.setValue(_integerProp12, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 13.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler13 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 13.0d, z), null});
            if (_fluidHandler13 != null) {
                _fluidHandler13.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxxxxxxx = BlockPos.containing(x, y - 13.0d, z);
                BlockEntity _blockEntityxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxx);
                BlockState _bsxxxxxxxxxxxx2 = world.getBlockState(_bpxxxxxxxxxxxx);
                if (_blockEntityxxxxxxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level13 = (Level) world;
                    _level13.sendBlockUpdated(_bpxxxxxxxxxxxx, _bsxxxxxxxxxxxx2, _bsxxxxxxxxxxxx2, 3);
                }
            }
            Property<?> property25 = world.getBlockState(BlockPos.containing(x, y - 13.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property25 instanceof IntegerProperty) {
                Property<?> _getip141 = property25;
                iIntValue4 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 13.0d, z)).getValue(_getip141)).intValue();
            } else {
                iIntValue4 = -1;
            }
            if (iIntValue4 != 0) {
                BlockPos _pos13 = BlockPos.containing(x, y - 13.0d, z);
                BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_pos13);
                Property<?> property26 = _bsxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property26 instanceof IntegerProperty) {
                    IntegerProperty _integerProp13 = (IntegerProperty) property26;
                    if (_integerProp13.getPossibleValues().contains(0)) {
                        world.setBlock(_pos13, (BlockState) _bsxxxxxxxxxxxxx.setValue(_integerProp13, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 14.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler14 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 14.0d, z), null});
            if (_fluidHandler14 != null) {
                _fluidHandler14.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxxxxxxxx = BlockPos.containing(x, y - 14.0d, z);
                BlockEntity _blockEntityxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxx);
                BlockState _bsxxxxxxxxxxxxx2 = world.getBlockState(_bpxxxxxxxxxxxxx);
                if (_blockEntityxxxxxxxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level14 = (Level) world;
                    _level14.sendBlockUpdated(_bpxxxxxxxxxxxxx, _bsxxxxxxxxxxxxx2, _bsxxxxxxxxxxxxx2, 3);
                }
            }
            Property<?> property27 = world.getBlockState(BlockPos.containing(x, y - 14.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property27 instanceof IntegerProperty) {
                Property<?> _getip152 = property27;
                iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 14.0d, z)).getValue(_getip152)).intValue();
            } else {
                iIntValue3 = -1;
            }
            if (iIntValue3 != 0) {
                BlockPos _pos14 = BlockPos.containing(x, y - 14.0d, z);
                BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_pos14);
                Property<?> property28 = _bsxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property28 instanceof IntegerProperty) {
                    IntegerProperty _integerProp14 = (IntegerProperty) property28;
                    if (_integerProp14.getPossibleValues().contains(0)) {
                        world.setBlock(_pos14, (BlockState) _bsxxxxxxxxxxxxxx.setValue(_integerProp14, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 15.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler15 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 15.0d, z), null});
            if (_fluidHandler15 != null) {
                _fluidHandler15.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxxxxxxxxx = BlockPos.containing(x, y - 15.0d, z);
                BlockEntity _blockEntityxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxx);
                BlockState _bsxxxxxxxxxxxxxx2 = world.getBlockState(_bpxxxxxxxxxxxxxx);
                if (_blockEntityxxxxxxxxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level15 = (Level) world;
                    _level15.sendBlockUpdated(_bpxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx2, _bsxxxxxxxxxxxxxx2, 3);
                }
            }
            Property<?> property29 = world.getBlockState(BlockPos.containing(x, y - 15.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property29 instanceof IntegerProperty) {
                Property<?> _getip163 = property29;
                iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 15.0d, z)).getValue(_getip163)).intValue();
            } else {
                iIntValue2 = -1;
            }
            if (iIntValue2 != 0) {
                BlockPos _pos15 = BlockPos.containing(x, y - 15.0d, z);
                BlockState _bsxxxxxxxxxxxxxxx = world.getBlockState(_pos15);
                Property<?> property30 = _bsxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property30 instanceof IntegerProperty) {
                    IntegerProperty _integerProp15 = (IntegerProperty) property30;
                    if (_integerProp15.getPossibleValues().contains(0)) {
                        world.setBlock(_pos15, (BlockState) _bsxxxxxxxxxxxxxxx.setValue(_integerProp15, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (world.getBlockState(BlockPos.containing(x, y - 16.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandler16 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 16.0d, z), null});
            if (_fluidHandler16 != null) {
                _fluidHandler16.fill(new FluidStack((Fluid) ButcheryModFluids.INFECTED_BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxxxxxxxxxx = BlockPos.containing(x, y - 16.0d, z);
                BlockEntity _blockEntityxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxx);
                BlockState _bsxxxxxxxxxxxxxxx2 = world.getBlockState(_bpxxxxxxxxxxxxxxx);
                if (_blockEntityxxxxxxxxxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxx).putBoolean("isInfectedButchery", true);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxx).putBoolean("isButchery", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxx).putBoolean("isBloodMagic", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxx).putBoolean("isHexeri", false);
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxx).putBoolean("isVampirism", false);
                }
                if (world instanceof Level) {
                    Level _level16 = (Level) world;
                    _level16.sendBlockUpdated(_bpxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxx2, _bsxxxxxxxxxxxxxxx2, 3);
                }
            }
            Property<?> property31 = world.getBlockState(BlockPos.containing(x, y - 16.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property31 instanceof IntegerProperty) {
                Property<?> _getip174 = property31;
                iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y - 16.0d, z)).getValue(_getip174)).intValue();
            } else {
                iIntValue = -1;
            }
            if (iIntValue != 0) {
                BlockPos _pos16 = BlockPos.containing(x, y - 16.0d, z);
                BlockState _bsxxxxxxxxxxxxxxxx = world.getBlockState(_pos16);
                Property<?> property32 = _bsxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property32 instanceof IntegerProperty) {
                    IntegerProperty _integerProp16 = (IntegerProperty) property32;
                    if (_integerProp16.getPossibleValues().contains(0)) {
                        world.setBlock(_pos16, (BlockState) _bsxxxxxxxxxxxxxxxx.setValue(_integerProp16, 0), 3);
                    }
                }
            }
        }
    }
}
