package net.mcreator.butchery.procedures;

import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.ItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandlerModifiable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class MeatgrinderrecipeprocedureProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getItem() == Blocks.AIR.asItem()) {
         if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               ButcheryPersistentData.of(_blockEntity).putDouble("craftingTime", 0.0);
               ButcheryPersistentData.of(_blockEntity).putDouble("craftingProgress", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (!(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getItem() instanceof BlockItem _bi
                  ? _bi.getBlock().defaultBlockState()
                  : Blocks.AIR.defaultBlockState())
               .is(TagKey.create(Registries.BLOCK, Identifier.parse("butchery:scrappable")))
            && !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0)
               .copy()
               .is(TagKey.create(Registries.ITEM, Identifier.parse("butchery:scrappable")))
         || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() != 0
            && (
               itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy().getItem() != ButcheryModItems.MEAT_SCRAPS.get()
                  || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() > 63
            )) {
         if ((
               itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_pork")))
                  || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_pork")))
            )
            && (
               itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() == 0
                  || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy().getItem() == ButcheryModItems.RAW_SAUSAGE.get()
                     && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() <= 63
            )
            && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().getItem() == ButcheryModItems.SAUSAGE_ATTACHMENT.get()
            && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() == ButcheryModItems.INTESTINES.get()
            && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0) {
            if (!world.isClientSide()) {
               BlockPos _bpx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
               BlockState _bsx = world.getBlockState(_bpx);
               if (_blockEntityx != null) {
                  ButcheryPersistentData.of(_blockEntityx).putDouble("craftingTime", 150.0);
                  ButcheryPersistentData.of(_blockEntityx)
                     .putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0);
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
               }
            }

            if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0) {
               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  int _slotid = 0;
                  ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
                  _stk.shrink(1);
                  _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  int _slotid = 1;
                  ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
                  _stk.shrink(1);
                  _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.RAW_SAUSAGE.get()).copy();
                  _setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + 1);
                  _itemHandlerModifiable.setStackInSlot(4, _setstack);
               }

               if (!world.isClientSide()) {
                  BlockPos _bpxx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                  BlockState _bsxx = world.getBlockState(_bpxx);
                  if (_blockEntityxx != null) {
                     ButcheryPersistentData.of(_blockEntityxx).putDouble("craftingProgress", 0.0);
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                  }
               }
            }
         } else if (!itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0)
                  .copy()
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_pork")))
               && !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_pork")))
            || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() != 0
               && (
                  itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy().getItem() != ButcheryModItems.RAW_BLOOD_SAUSAGE.get()
                     || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() > 63
               )
            || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().getItem() != ButcheryModItems.SAUSAGE_ATTACHMENT.get()
            || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() != ButcheryModItems.INTESTINES.get()
            || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy().getItem() != ButcheryModItems.BOTTLE_OF_BLOOD.get()
               && !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("c:blood_bottle")))
               && !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5)
                  .copy()
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:blood_bottle")))) {
            if (!itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_mutton")))
                  && !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0)
                     .copy()
                     .is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_mutton")))
               || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() != 0
                  && (
                     itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy().getItem() != ButcheryModItems.RAW_LAMB_MINCE.get()
                        || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() > 63
                  )) {
               if ((
                     itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0)
                           .copy()
                           .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_beef")))
                        || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0)
                           .copy()
                           .is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_beef")))
                  )
                  && (
                     itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() == 0
                        || (
                              itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy().getItem() == ButcheryModItems.RAW_BEEF_MINCE.get()
                                 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy().getItem()
                                    == BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:minced_beef"))
                           )
                           && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() <= 63
                  )) {
                  if (!world.isClientSide()) {
                     BlockPos _bpxxx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                     BlockState _bsxxx = world.getBlockState(_bpxxx);
                     if (_blockEntityxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxx).putDouble("craftingTime", 150.0);
                        ButcheryPersistentData.of(_blockEntityxxx)
                           .putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0);
                     }

                     if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bpxxx, _bsxxx, _bsxxx, 3);
                     }
                  }

                  if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0) {
                     if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                        )
                      {
                        int _slotid = 0;
                        ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
                        _stk.shrink(1);
                        _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
                     }

                     if (FabricLoader.getInstance().isModLoaded("farmersdelight") && (Boolean)ButcheryconfigConfiguration.FARMERS_DELIGHT.get()) {
                        if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                           )
                         {
                           ItemStack _setstack = new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:minced_beef")))
                              .copy();
                           _setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + 1);
                           _itemHandlerModifiable.setStackInSlot(4, _setstack);
                        }
                     } else if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                        )
                      {
                        ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.RAW_BEEF_MINCE.get()).copy();
                        _setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + 1);
                        _itemHandlerModifiable.setStackInSlot(4, _setstack);
                     }

                     if (!world.isClientSide()) {
                        BlockPos _bpxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                        BlockState _bsxxxx = world.getBlockState(_bpxxxx);
                        if (_blockEntityxxxx != null) {
                           ButcheryPersistentData.of(_blockEntityxxxx).putDouble("craftingProgress", 0.0);
                        }

                        if (world instanceof Level _level) {
                           _level.sendBlockUpdated(_bpxxxx, _bsxxxx, _bsxxxx, 3);
                        }
                     }
                  }
               }
            } else {
               if (!world.isClientSide()) {
                  BlockPos _bpxxxxx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                  BlockState _bsxxxxx = world.getBlockState(_bpxxxxx);
                  if (_blockEntityxxxxx != null) {
                     ButcheryPersistentData.of(_blockEntityxxxxx).putDouble("craftingTime", 150.0);
                     ButcheryPersistentData.of(_blockEntityxxxxx)
                        .putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0);
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bpxxxxx, _bsxxxxx, _bsxxxxx, 3);
                  }
               }

               if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0) {
                  if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                     )
                   {
                     int _slotid = 0;
                     ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
                     _stk.shrink(1);
                     _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
                  }

                  if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                     )
                   {
                     ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.RAW_LAMB_MINCE.get()).copy();
                     _setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + 1);
                     _itemHandlerModifiable.setStackInSlot(4, _setstack);
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpxxxxxx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
                     BlockState _bsxxxxxx = world.getBlockState(_bpxxxxxx);
                     if (_blockEntityxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxx).putDouble("craftingProgress", 0.0);
                     }

                     if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bpxxxxxx, _bsxxxxxx, _bsxxxxxx, 3);
                     }
                  }
               }
            }
         } else {
            if (!world.isClientSide()) {
               BlockPos _bpxxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
               BlockState _bsxxxxxxx = world.getBlockState(_bpxxxxxxx);
               if (_blockEntityxxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxxx).putDouble("craftingTime", 150.0);
                  ButcheryPersistentData.of(_blockEntityxxxxxxx)
                     .putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0);
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxx, _bsxxxxxxx, 3);
               }
            }

            if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0) {
               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  int _slotid = 0;
                  ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
                  _stk.shrink(1);
                  _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  int _slotid = 1;
                  ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
                  _stk.shrink(1);
                  _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  int _slotid = 5;
                  ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
                  _stk.shrink(1);
                  _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  int _slotid = 3;
                  ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
                  _stk.shrink(1);
                  _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
                  _setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).getCount() + 1);
                  _itemHandlerModifiable.setStackInSlot(5, _setstack);
               }

               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.RAW_BLOOD_SAUSAGE.get()).copy();
                  _setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + 1);
                  _itemHandlerModifiable.setStackInSlot(4, _setstack);
               }

               if (!world.isClientSide()) {
                  BlockPos _bpxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityxxxxxxxx = world.getBlockEntity(_bpxxxxxxxx);
                  BlockState _bsxxxxxxxx = world.getBlockState(_bpxxxxxxxx);
                  if (_blockEntityxxxxxxxx != null) {
                     ButcheryPersistentData.of(_blockEntityxxxxxxxx).putDouble("craftingProgress", 0.0);
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bpxxxxxxxx, _bsxxxxxxxx, _bsxxxxxxxx, 3);
                  }
               }
            }
         }
      } else {
         if (!world.isClientSide()) {
            BlockPos _bpxxxxxxxxx = BlockPos.containing(x, y, z);
            BlockEntity _blockEntityxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxx);
            BlockState _bsxxxxxxxxx = world.getBlockState(_bpxxxxxxxxx);
            if (_blockEntityxxxxxxxxx != null) {
               ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putDouble("craftingTime", 150.0);
               ButcheryPersistentData.of(_blockEntityxxxxxxxxx)
                  .putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpxxxxxxxxx, _bsxxxxxxxxx, _bsxxxxxxxxx, 3);
            }
         }

         if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0) {
            if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
               )
             {
               int _slotid = 0;
               ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
               _stk.shrink(1);
               _itemHandlerModifiable.setStackInSlot(_slotid, _stk);
            }

            if (!(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getItem() instanceof BlockItem _bixx
                     ? _bixx.getBlock().defaultBlockState()
                     : Blocks.AIR.defaultBlockState())
                  .is(TagKey.create(Registries.BLOCK, Identifier.parse("butchery:carcass")))
               && !(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getItem() instanceof BlockItem _bix
                     ? _bix.getBlock().defaultBlockState()
                     : Blocks.AIR.defaultBlockState())
                  .is(TagKey.create(Registries.BLOCK, Identifier.parse("butchery:drained_carcass")))) {
               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.MEAT_SCRAPS.get()).copy();
                  _setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + 1);
                  _itemHandlerModifiable.setStackInSlot(4, _setstack);
               }

               if (!world.isClientSide()) {
                  BlockPos _bpxxxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxx);
                  BlockState _bsxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxx);
                  if (_blockEntityxxxxxxxxxx != null) {
                     ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putDouble("craftingProgress", 0.0);
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bpxxxxxxxxxx, _bsxxxxxxxxxx, _bsxxxxxxxxxx, 3);
                  }
               }
            } else {
               if (ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null}) instanceof IItemHandlerModifiable _itemHandlerModifiable
                  )
                {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.MEAT_SCRAPS.get()).copy();
                  _setstack.setCount(
                     (int)(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + Mth.nextDouble(RandomSource.create(), 3.0, 8.0))
                  );
                  _itemHandlerModifiable.setStackInSlot(4, _setstack);
               }

               if (!world.isClientSide()) {
                  BlockPos _bpxxxxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxx);
                  BlockState _bsxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxx);
                  if (_blockEntityxxxxxxxxxxx != null) {
                     ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putDouble("craftingProgress", 0.0);
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bpxxxxxxxxxxx, _bsxxxxxxxxxxx, _bsxxxxxxxxxxx, 3);
                  }
               }
            }
         }
      }

      if ((
            !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_meat")))
               || !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_meat")))
         )
         && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().getItem() != ButcheryModItems.SAUSAGE_ATTACHMENT.get()
         && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() != ButcheryModItems.INTESTINES.get()) {
         int _value = 0;
         BlockPos _pos = BlockPos.containing(x, y, z);
         BlockState _bsxxxxxxxxxxxx = world.getBlockState(_pos);
         if (_bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxxxxxxxxx.setValue(_integerProp, _value), 3);
         }
      }

      if ((
            itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_meat")))
               || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_meat")))
         )
         && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().getItem() != ButcheryModItems.SAUSAGE_ATTACHMENT.get()
         && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() != ButcheryModItems.INTESTINES.get()) {
         int _value = 1;
         BlockPos _pos = BlockPos.containing(x, y, z);
         BlockState _bsxxxxxxxxxxxx = world.getBlockState(_pos);
         if (_bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxxxxxxxxx.setValue(_integerProp, _value), 3);
         }
      }

      if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().getItem() == ButcheryModItems.SAUSAGE_ATTACHMENT.get()
         && (
            itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() != ButcheryModItems.INTESTINES.get()
               || !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_meat")))
               || !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_meat")))
         )) {
         int _value = 2;
         BlockPos _pos = BlockPos.containing(x, y, z);
         BlockState _bsxxxxxxxxxxxx = world.getBlockState(_pos);
         if (_bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxxxxxxxxx.setValue(_integerProp, _value), 3);
         }
      }

      if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().getItem() == ButcheryModItems.SAUSAGE_ATTACHMENT.get()
         && (
            itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_meat")))
               || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_meat")))
         )) {
         int _value = 3;
         BlockPos _pos = BlockPos.containing(x, y, z);
         BlockState _bsxxxxxxxxxxxx = world.getBlockState(_pos);
         if (_bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxxxxxxxxx.setValue(_integerProp, _value), 3);
         }
      }

      if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().getItem() == ButcheryModItems.SAUSAGE_ATTACHMENT.get()
         && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() == ButcheryModItems.INTESTINES.get()
         && (
            !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_meat")))
               || !itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_meat")))
         )) {
         int _value = 4;
         BlockPos _pos = BlockPos.containing(x, y, z);
         BlockState _bsxxxxxxxxxxxx = world.getBlockState(_pos);
         if (_bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxxxxxxxxx.setValue(_integerProp, _value), 3);
         }
      }

      if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().getItem() == ButcheryModItems.SAUSAGE_ATTACHMENT.get()
         && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() == ButcheryModItems.INTESTINES.get()
         && (
            itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("forge:raw_meat")))
               || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_meat")))
         )) {
         int _value = 5;
         BlockPos _pos = BlockPos.containing(x, y, z);
         BlockState _bsxxxxxxxxxxxx = world.getBlockState(_pos);
         if (_bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxxxxxxxxx.setValue(_integerProp, _value), 3);
         }
      }
   }

   private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
      new ILevelExtension(world);
      IItemHandler itemHandler = (IItemHandler)ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{pos, null});
      return itemHandler != null ? itemHandler.getStackInSlot(slot) : ItemStack.EMPTY;
   }

   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
   }
}
