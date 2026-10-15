package net.mcreator.butchery.procedures;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.FluidHandler;
import net.mcreator.butchery.shim.capabilities.ItemHandler;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler.FluidAction;
import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandlerModifiable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BasinupdatetickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "basinEvaporating")) {
         if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               ButcheryPersistentData.of(_blockEntity).putDouble("Timer", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") + 1.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 1000.0) {
            if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 1000
               && (
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6
                        ? (Integer)blockstate.getValue(_getip6)
                        : -1
                  )
                  == 1
               && world instanceof Level _lvl7
               && _lvl7.isBrightOutside()
               && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
               && !((Level)world).isRaining()) {
               new ILevelExtension(world);
               IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(
                  world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}
               );
               if (_fluidHandler != null) {
                  _fluidHandler.drain(166, FluidAction.EXECUTE);
               }

               int _value = 2;
               BlockPos _pos = BlockPos.containing(x, y, z);
               BlockState _bsx = world.getBlockState(_pos);
               if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_value)) {
                  world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.SALT.get()).copy();
                  _setstack.setCount(
                     (int)(
                        itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getCount()
                           + (Double)ButcheryconfigConfiguration.SALT_BASIN_YIELD.get()
                     )
                  );
                  _itemHandlerModifiable.setStackInSlot(0, _setstack);
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 2000.0) {
            if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 834
               && (
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19
                        ? (Integer)blockstate.getValue(_getip19)
                        : -1
                  )
                  == 2
               && world instanceof Level _lvl20
               && _lvl20.isBrightOutside()
               && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
               && !((Level)world).isRaining()) {
               new ILevelExtension(world);
               IFluidHandler _fluidHandlerx = (IFluidHandler)ButcheryCaps.getCapability(
                  world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}
               );
               if (_fluidHandlerx != null) {
                  _fluidHandlerx.drain(166, FluidAction.EXECUTE);
               }

               int _valuex = 3;
               BlockPos _posx = BlockPos.containing(x, y, z);
               BlockState _bsxx = world.getBlockState(_posx);
               if (_bsxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuex)) {
                  world.setBlock(_posx, (BlockState)_bsxx.setValue(_integerProp, _valuex), 3);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.SALT.get()).copy();
                  _setstack.setCount(
                     (int)(
                        itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getCount()
                           + (Double)ButcheryconfigConfiguration.SALT_BASIN_YIELD.get()
                     )
                  );
                  _itemHandlerModifiable.setStackInSlot(0, _setstack);
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 3000.0) {
            if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 668
               && (
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip32
                        ? (Integer)blockstate.getValue(_getip32)
                        : -1
                  )
                  == 3
               && world instanceof Level _lvl33
               && _lvl33.isBrightOutside()
               && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
               && !((Level)world).isRaining()) {
               new ILevelExtension(world);
               IFluidHandler _fluidHandlerxx = (IFluidHandler)ButcheryCaps.getCapability(
                  world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}
               );
               if (_fluidHandlerxx != null) {
                  _fluidHandlerxx.drain(166, FluidAction.EXECUTE);
               }

               int _valuexx = 4;
               BlockPos _posxx = BlockPos.containing(x, y, z);
               BlockState _bsxxx = world.getBlockState(_posxx);
               if (_bsxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuexx)) {
                  world.setBlock(_posxx, (BlockState)_bsxxx.setValue(_integerProp, _valuexx), 3);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.SALT.get()).copy();
                  _setstack.setCount(
                     (int)(
                        itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getCount()
                           + (Double)ButcheryconfigConfiguration.SALT_BASIN_YIELD.get()
                     )
                  );
                  _itemHandlerModifiable.setStackInSlot(0, _setstack);
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 4000.0) {
            if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 502
               && (
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip45
                        ? (Integer)blockstate.getValue(_getip45)
                        : -1
                  )
                  == 4
               && world instanceof Level _lvl46
               && _lvl46.isBrightOutside()
               && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
               && !((Level)world).isRaining()) {
               new ILevelExtension(world);
               IFluidHandler _fluidHandlerxxx = (IFluidHandler)ButcheryCaps.getCapability(
                  world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}
               );
               if (_fluidHandlerxxx != null) {
                  _fluidHandlerxxx.drain(166, FluidAction.EXECUTE);
               }

               int _valuexxx = 5;
               BlockPos _posxxx = BlockPos.containing(x, y, z);
               BlockState _bsxxxx = world.getBlockState(_posxxx);
               if (_bsxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuexxx)) {
                  world.setBlock(_posxxx, (BlockState)_bsxxxx.setValue(_integerProp, _valuexxx), 3);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.SALT.get()).copy();
                  _setstack.setCount(
                     (int)(
                        itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getCount()
                           + (Double)ButcheryconfigConfiguration.SALT_BASIN_YIELD.get()
                     )
                  );
                  _itemHandlerModifiable.setStackInSlot(0, _setstack);
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 5000.0) {
            if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 336
               && (
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip58
                        ? (Integer)blockstate.getValue(_getip58)
                        : -1
                  )
                  == 5
               && world instanceof Level _lvl59
               && _lvl59.isBrightOutside()
               && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
               && !((Level)world).isRaining()) {
               new ILevelExtension(world);
               IFluidHandler _fluidHandlerxxxx = (IFluidHandler)ButcheryCaps.getCapability(
                  world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}
               );
               if (_fluidHandlerxxxx != null) {
                  _fluidHandlerxxxx.drain(166, FluidAction.EXECUTE);
               }

               int _valuexxxx = 6;
               BlockPos _posxxxx = BlockPos.containing(x, y, z);
               BlockState _bsxxxxx = world.getBlockState(_posxxxx);
               if (_bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuexxxx)) {
                  world.setBlock(_posxxxx, (BlockState)_bsxxxxx.setValue(_integerProp, _valuexxxx), 3);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.SALT.get()).copy();
                  _setstack.setCount(
                     (int)(
                        itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getCount()
                           + (Double)ButcheryconfigConfiguration.SALT_BASIN_YIELD.get()
                     )
                  );
                  _itemHandlerModifiable.setStackInSlot(0, _setstack);
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 6000.0
            && getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 170
            && (
                  blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip71
                     ? (Integer)blockstate.getValue(_getip71)
                     : -1
               )
               == 6
            && world instanceof Level _lvl72
            && _lvl72.isBrightOutside()
            && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
            && !((Level)world).isRaining()) {
            new ILevelExtension(world);
            IFluidHandler _fluidHandlerxxxxx = (IFluidHandler)ButcheryCaps.getCapability(
               world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}
            );
            if (_fluidHandlerxxxxx != null) {
               _fluidHandlerxxxxx.drain(170, FluidAction.EXECUTE);
            }

            int _valuexxxxx = 7;
            BlockPos _posxxxxx = BlockPos.containing(x, y, z);
            BlockState _bsxxxxxx = world.getBlockState(_posxxxxx);
            if (_bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
               && _integerProp.getPossibleValues().contains(_valuexxxxx)) {
               world.setBlock(_posxxxxx, (BlockState)_bsxxxxxx.setValue(_integerProp, _valuexxxxx), 3);
            }

            if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
               )
             {
               ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.SALT.get()).copy();
               _setstack.setCount(
                  (int)(
                     itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getCount()
                        + (Double)ButcheryconfigConfiguration.SALT_BASIN_YIELD.get()
                  )
               );
               _itemHandlerModifiable.setStackInSlot(0, _setstack);
            }

            if (!world.isClientSide()) {
               BlockPos _bpx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
               _bsxxxxxx = world.getBlockState(_bpx);
               if (_blockEntityx != null) {
                  ButcheryPersistentData.of(_blockEntityx).putBoolean("basinEvaporating", false);
                  ButcheryPersistentData.of(_blockEntityx).putDouble("Timer", 0.0);
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bpx, _bsxxxxxx, _bsxxxxxx, 3);
               }
            }
         }
      }
   }

   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
   }

   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
   }

   private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
      new ILevelExtension(level);
      IFluidHandler fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(level, FluidHandler.BLOCK, new Object[]{pos, direction});
      return fluidHandler != null ? fluidHandler.getFluidInTank(tank).getAmount() : 0;
   }

   private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
      new ILevelExtension(world);
      IItemHandler itemHandler = (IItemHandler)ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{pos, null});
      return itemHandler != null ? itemHandler.getStackInSlot(slot) : ItemStack.EMPTY;
   }
}
