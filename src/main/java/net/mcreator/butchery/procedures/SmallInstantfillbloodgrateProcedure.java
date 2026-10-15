package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModFluids;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.FluidHandler;
import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler.FluidAction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;

public class SmallInstantfillbloodgrateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip3)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 1.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip8)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 2.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip13)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 3.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip18
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip18)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 4.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip23)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 5.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip28
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip28)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 6.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip33
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip33)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 7.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip38
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip38)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 8.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip43
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip43)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 9.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip48
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip48)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 10.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip53
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip53)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 11.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip58
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip58)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 12.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip63
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip63)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 13.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip68
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip68)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 14.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip73
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip73)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 15.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip78
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip78)
                  : -1
            )
            == 0) {
         new ILevelExtension(world);
         IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
            world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y - 16.0, z), null}
         );
         if (_fluidHandler != null) {
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 250), FluidAction.EXECUTE);
         }
      }

      if ((
            world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip83
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip83)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip87
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip87)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip91
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip91)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip95
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip95)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip99
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip99)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip103
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip103)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip107
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip107)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip111
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip111)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip115
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip115)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip119
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip119)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip123
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip123)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip127
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip127)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip131
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip131)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip135
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip135)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip139
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip139)
                        : -1
                  )
                  != 1
         )
         && world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip143
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip143)
                  : -1
            )
            == 1) {
      }

      if ((
            world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip147
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip147)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip151
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip151)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip155
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip155)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip159
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip159)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip163
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip163)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip167
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip167)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip171
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip171)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip175
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip175)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip179
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip179)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip183
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip183)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip187
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip187)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip191
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip191)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip195
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip195)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip199
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip199)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip203
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip203)
                        : -1
                  )
                  != 2
         )
         && world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip207
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip207)
                  : -1
            )
            == 2) {
      }

      if ((
            world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip211
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip211)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip215
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip215)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip219
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip219)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip223
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip223)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip227
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip227)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip231
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip231)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip235
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip235)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip239
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip239)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip243
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip243)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip247
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip247)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip251
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip251)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip255
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip255)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip259
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip259)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip263
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip263)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip267
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip267)
                        : -1
                  )
                  != 3
         )
         && world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip271
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip271)
                  : -1
            )
            == 3) {
      }
   }
}
