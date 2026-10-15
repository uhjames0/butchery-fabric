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

public class SmallfillbloodgrateProcedure {
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
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
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
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
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
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
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
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
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
            _fluidHandler.fill(new FluidStack((Fluid)ButcheryModFluids.BLOOD.get(), 50), FluidAction.EXECUTE);
         }
      }

      if ((
            world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip28
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip28)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip32
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip32)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip36
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip36)
                        : -1
                  )
                  != 1
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip40
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip40)
                        : -1
                  )
                  != 1
         )
         && world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip44
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip44)
                  : -1
            )
            == 1) {
      }

      if ((
            world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip48
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip48)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip52
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip52)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip56
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip56)
                        : -1
                  )
                  != 2
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip60
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip60)
                        : -1
                  )
                  != 2
         )
         && world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip64
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip64)
                  : -1
            )
            == 2) {
      }

      if ((
            world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip68
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip68)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip72
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip72)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip76
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip76)
                        : -1
                  )
                  != 3
         )
         && (
            world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()
               || (
                     world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip80
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip80)
                        : -1
                  )
                  != 3
         )
         && world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() == ButcheryModBlocks.BLOOD_GRATE.get()
         && (
               world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip84
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip84)
                  : -1
            )
            == 3) {
      }
   }
}
