package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModFluids;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.FluidHandler;
import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;

/* JADX INFO: loaded from: FillbloodgrateProcedure.class */
public class FillbloodgrateProcedure {
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
            Property<?> property = world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip3 = property;
                iIntValue16 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getValue(_getip3)).intValue();
            } else {
                iIntValue16 = -1;
            }
            if (iIntValue16 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 1.0d, z), null});
                if (_fluidHandler != null) {
                    _fluidHandler.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 2.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property2 = world.getBlockState(BlockPos.containing(x, y - 2.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property2 instanceof IntegerProperty) {
                Property<?> _getip8 = property2;
                iIntValue15 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 2.0d, z)).getValue(_getip8)).intValue();
            } else {
                iIntValue15 = -1;
            }
            if (iIntValue15 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler2 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 2.0d, z), null});
                if (_fluidHandler2 != null) {
                    _fluidHandler2.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 3.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property3 = world.getBlockState(BlockPos.containing(x, y - 3.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property3 instanceof IntegerProperty) {
                Property<?> _getip13 = property3;
                iIntValue14 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 3.0d, z)).getValue(_getip13)).intValue();
            } else {
                iIntValue14 = -1;
            }
            if (iIntValue14 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler3 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 3.0d, z), null});
                if (_fluidHandler3 != null) {
                    _fluidHandler3.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 4.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property4 = world.getBlockState(BlockPos.containing(x, y - 4.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property4 instanceof IntegerProperty) {
                Property<?> _getip18 = property4;
                iIntValue13 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 4.0d, z)).getValue(_getip18)).intValue();
            } else {
                iIntValue13 = -1;
            }
            if (iIntValue13 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler4 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 4.0d, z), null});
                if (_fluidHandler4 != null) {
                    _fluidHandler4.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 5.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property5 = world.getBlockState(BlockPos.containing(x, y - 5.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property5 instanceof IntegerProperty) {
                Property<?> _getip23 = property5;
                iIntValue12 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 5.0d, z)).getValue(_getip23)).intValue();
            } else {
                iIntValue12 = -1;
            }
            if (iIntValue12 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler5 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 5.0d, z), null});
                if (_fluidHandler5 != null) {
                    _fluidHandler5.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 6.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property6 = world.getBlockState(BlockPos.containing(x, y - 6.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property6 instanceof IntegerProperty) {
                Property<?> _getip28 = property6;
                iIntValue11 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 6.0d, z)).getValue(_getip28)).intValue();
            } else {
                iIntValue11 = -1;
            }
            if (iIntValue11 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler6 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 6.0d, z), null});
                if (_fluidHandler6 != null) {
                    _fluidHandler6.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 7.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property7 = world.getBlockState(BlockPos.containing(x, y - 7.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property7 instanceof IntegerProperty) {
                Property<?> _getip33 = property7;
                iIntValue10 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 7.0d, z)).getValue(_getip33)).intValue();
            } else {
                iIntValue10 = -1;
            }
            if (iIntValue10 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler7 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 7.0d, z), null});
                if (_fluidHandler7 != null) {
                    _fluidHandler7.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 8.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property8 = world.getBlockState(BlockPos.containing(x, y - 8.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property8 instanceof IntegerProperty) {
                Property<?> _getip38 = property8;
                iIntValue9 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 8.0d, z)).getValue(_getip38)).intValue();
            } else {
                iIntValue9 = -1;
            }
            if (iIntValue9 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler8 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 8.0d, z), null});
                if (_fluidHandler8 != null) {
                    _fluidHandler8.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 9.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property9 = world.getBlockState(BlockPos.containing(x, y - 9.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property9 instanceof IntegerProperty) {
                Property<?> _getip43 = property9;
                iIntValue8 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 9.0d, z)).getValue(_getip43)).intValue();
            } else {
                iIntValue8 = -1;
            }
            if (iIntValue8 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler9 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 9.0d, z), null});
                if (_fluidHandler9 != null) {
                    _fluidHandler9.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 10.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property10 = world.getBlockState(BlockPos.containing(x, y - 10.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property10 instanceof IntegerProperty) {
                Property<?> _getip48 = property10;
                iIntValue7 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 10.0d, z)).getValue(_getip48)).intValue();
            } else {
                iIntValue7 = -1;
            }
            if (iIntValue7 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler10 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 10.0d, z), null});
                if (_fluidHandler10 != null) {
                    _fluidHandler10.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 11.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property11 = world.getBlockState(BlockPos.containing(x, y - 11.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property11 instanceof IntegerProperty) {
                Property<?> _getip53 = property11;
                iIntValue6 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 11.0d, z)).getValue(_getip53)).intValue();
            } else {
                iIntValue6 = -1;
            }
            if (iIntValue6 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler11 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 11.0d, z), null});
                if (_fluidHandler11 != null) {
                    _fluidHandler11.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 12.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property12 = world.getBlockState(BlockPos.containing(x, y - 12.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property12 instanceof IntegerProperty) {
                Property<?> _getip58 = property12;
                iIntValue5 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 12.0d, z)).getValue(_getip58)).intValue();
            } else {
                iIntValue5 = -1;
            }
            if (iIntValue5 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler12 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 12.0d, z), null});
                if (_fluidHandler12 != null) {
                    _fluidHandler12.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 13.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property13 = world.getBlockState(BlockPos.containing(x, y - 13.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property13 instanceof IntegerProperty) {
                Property<?> _getip63 = property13;
                iIntValue4 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 13.0d, z)).getValue(_getip63)).intValue();
            } else {
                iIntValue4 = -1;
            }
            if (iIntValue4 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler13 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 13.0d, z), null});
                if (_fluidHandler13 != null) {
                    _fluidHandler13.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 14.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property14 = world.getBlockState(BlockPos.containing(x, y - 14.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property14 instanceof IntegerProperty) {
                Property<?> _getip68 = property14;
                iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 14.0d, z)).getValue(_getip68)).intValue();
            } else {
                iIntValue3 = -1;
            }
            if (iIntValue3 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler14 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 14.0d, z), null});
                if (_fluidHandler14 != null) {
                    _fluidHandler14.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 15.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property15 = world.getBlockState(BlockPos.containing(x, y - 15.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property15 instanceof IntegerProperty) {
                Property<?> _getip73 = property15;
                iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 15.0d, z)).getValue(_getip73)).intValue();
            } else {
                iIntValue2 = -1;
            }
            if (iIntValue2 == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler15 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 15.0d, z), null});
                if (_fluidHandler15 != null) {
                    _fluidHandler15.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y - 16.0d, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()) {
            Property<?> property16 = world.getBlockState(BlockPos.containing(x, y - 16.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property16 instanceof IntegerProperty) {
                IntegerProperty _getip78 = (IntegerProperty) property16;
                iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y - 16.0d, z)).getValue(_getip78)).intValue();
            } else {
                iIntValue = -1;
            }
            if (iIntValue == 0) {
                new ILevelExtension(world);
                IFluidHandler _fluidHandler16 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 16.0d, z), null});
                if (_fluidHandler16 != null) {
                    _fluidHandler16.fill(new FluidStack((Fluid) ButcheryModFluids.BLOOD.get(), 50), IFluidHandler.FluidAction.EXECUTE);
                }
            }
        }
    }
}
