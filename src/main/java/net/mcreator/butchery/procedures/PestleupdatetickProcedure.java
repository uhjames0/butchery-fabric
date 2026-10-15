package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.ItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandlerModifiable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: PestleupdatetickProcedure.class */
public class PestleupdatetickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getItem() != ButcheryModItems.HOOF.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() != 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() != Items.SLIME_BALL || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() > 63))) {
            if (!itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().is(TagKey.create(Registries.ITEM, Identifier.parse("butchery:crushable_bone"))) || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() != 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() != Items.BONE_MEAL || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() > 63))) {
                if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getItem() != ButcheryModItems.WITHER_BONE.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() != 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() != ButcheryModItems.WITHER_BONE_MEAL.get() || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() > 63))) {
                    if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getItem() != ButcheryModItems.ICEY_BONE.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() != 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() != ButcheryModItems.ICEY_BONE_MEAL.get() || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() > 63))) {
                        if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getItem() == ButcheryModItems.SCULK_BONE.get() && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() == 0 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getItem() == ButcheryModItems.SCULKBONEMEAL.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() <= 63))) {
                            if (!world.isClientSide()) {
                                BlockPos _bp = BlockPos.containing(x, y, z);
                                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                BlockState _bs = world.getBlockState(_bp);
                                if (_blockEntity != null) {
                                    ButcheryPersistentData.of(_blockEntity).putDouble("craftingTime", 150.0d);
                                    ButcheryPersistentData.of(_blockEntity).putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0d);
                                }
                                if (world instanceof Level) {
                                    Level _level = (Level) world;
                                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                            }
                            if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0d) {
                                Object capability = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                                if (capability instanceof IItemHandlerModifiable) {
                                    IItemHandlerModifiable _itemHandlerModifiable = (IItemHandlerModifiable) capability;
                                    ItemStack _stk = _itemHandlerModifiable.getStackInSlot(0).copy();
                                    _stk.shrink(1);
                                    _itemHandlerModifiable.setStackInSlot(0, _stk);
                                }
                                Object capability2 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                                if (capability2 instanceof IItemHandlerModifiable) {
                                    IItemHandlerModifiable _itemHandlerModifiable2 = (IItemHandlerModifiable) capability2;
                                    ItemStack _setstack = new ItemStack((ItemLike) ButcheryModItems.SCULKBONEMEAL.get()).copy();
                                    _setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
                                    _itemHandlerModifiable2.setStackInSlot(1, _setstack);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bpx = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                                    BlockState _bsx = world.getBlockState(_bpx);
                                    if (_blockEntityx != null) {
                                        ButcheryPersistentData.of(_blockEntityx).putDouble("craftingProgress", 0.0d);
                                    }
                                    if (world instanceof Level) {
                                        Level _level2 = (Level) world;
                                        _level2.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (!world.isClientSide()) {
                            BlockPos _bpxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                            BlockState _bsxx = world.getBlockState(_bpxx);
                            if (_blockEntityxx != null) {
                                ButcheryPersistentData.of(_blockEntityxx).putDouble("craftingProgress", 0.0d);
                            }
                            if (world instanceof Level) {
                                Level _level3 = (Level) world;
                                _level3.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bpxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                        BlockState _bsxxx = world.getBlockState(_bpxxx);
                        if (_blockEntityxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxx).putDouble("craftingTime", 150.0d);
                            ButcheryPersistentData.of(_blockEntityxxx).putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0d);
                        }
                        if (world instanceof Level) {
                            Level _level4 = (Level) world;
                            _level4.sendBlockUpdated(_bpxxx, _bsxxx, _bsxxx, 3);
                        }
                    }
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0d) {
                        Object capability3 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                        if (capability3 instanceof IItemHandlerModifiable) {
                            IItemHandlerModifiable _itemHandlerModifiable3 = (IItemHandlerModifiable) capability3;
                            ItemStack _stk2 = _itemHandlerModifiable3.getStackInSlot(0).copy();
                            _stk2.shrink(1);
                            _itemHandlerModifiable3.setStackInSlot(0, _stk2);
                        }
                        Object capability4 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                        if (capability4 instanceof IItemHandlerModifiable) {
                            IItemHandlerModifiable _itemHandlerModifiable4 = (IItemHandlerModifiable) capability4;
                            ItemStack _setstack2 = new ItemStack((ItemLike) ButcheryModItems.ICEY_BONE_MEAL.get()).copy();
                            _setstack2.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 3);
                            _itemHandlerModifiable4.setStackInSlot(1, _setstack2);
                        }
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                            BlockState _bsxxxx = world.getBlockState(_bpxxxx);
                            if (_blockEntityxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxx).putDouble("craftingProgress", 0.0d);
                            }
                            if (world instanceof Level) {
                                Level _level5 = (Level) world;
                                _level5.sendBlockUpdated(_bpxxxx, _bsxxxx, _bsxxxx, 3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxx = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                    BlockState _bsxxxxx = world.getBlockState(_bpxxxxx);
                    if (_blockEntityxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxx).putDouble("craftingTime", 150.0d);
                        ButcheryPersistentData.of(_blockEntityxxxxx).putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0d);
                    }
                    if (world instanceof Level) {
                        Level _level6 = (Level) world;
                        _level6.sendBlockUpdated(_bpxxxxx, _bsxxxxx, _bsxxxxx, 3);
                    }
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0d) {
                    Object capability5 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                    if (capability5 instanceof IItemHandlerModifiable) {
                        IItemHandlerModifiable _itemHandlerModifiable5 = (IItemHandlerModifiable) capability5;
                        ItemStack _stk3 = _itemHandlerModifiable5.getStackInSlot(0).copy();
                        _stk3.shrink(1);
                        _itemHandlerModifiable5.setStackInSlot(0, _stk3);
                    }
                    Object capability6 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                    if (capability6 instanceof IItemHandlerModifiable) {
                        IItemHandlerModifiable _itemHandlerModifiable6 = (IItemHandlerModifiable) capability6;
                        ItemStack _setstack3 = new ItemStack((ItemLike) ButcheryModItems.WITHER_BONE_MEAL.get()).copy();
                        _setstack3.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
                        _itemHandlerModifiable6.setStackInSlot(1, _setstack3);
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
                        BlockState _bsxxxxxx = world.getBlockState(_bpxxxxxx);
                        if (_blockEntityxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxx).putDouble("craftingProgress", 0.0d);
                        }
                        if (world instanceof Level) {
                            Level _level7 = (Level) world;
                            _level7.sendBlockUpdated(_bpxxxxxx, _bsxxxxxx, _bsxxxxxx, 3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxx = BlockPos.containing(x, y, z);
                BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
                BlockState _bsxxxxxxx = world.getBlockState(_bpxxxxxxx);
                if (_blockEntityxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxx).putDouble("craftingTime", 150.0d);
                    ButcheryPersistentData.of(_blockEntityxxxxxxx).putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0d);
                }
                if (world instanceof Level) {
                    Level _level8 = (Level) world;
                    _level8.sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxx, _bsxxxxxxx, 3);
                }
            }
            if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0d) {
                Object capability7 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                if (capability7 instanceof IItemHandlerModifiable) {
                    IItemHandlerModifiable _itemHandlerModifiable7 = (IItemHandlerModifiable) capability7;
                    ItemStack _stk4 = _itemHandlerModifiable7.getStackInSlot(0).copy();
                    _stk4.shrink(1);
                    _itemHandlerModifiable7.setStackInSlot(0, _stk4);
                }
                Object capability8 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                if (capability8 instanceof IItemHandlerModifiable) {
                    IItemHandlerModifiable _itemHandlerModifiable8 = (IItemHandlerModifiable) capability8;
                    ItemStack _setstack4 = new ItemStack(Items.BONE_MEAL).copy();
                    _setstack4.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 3);
                    _itemHandlerModifiable8.setStackInSlot(1, _setstack4);
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntityxxxxxxxx = world.getBlockEntity(_bpxxxxxxxx);
                    BlockState _bsxxxxxxxx = world.getBlockState(_bpxxxxxxxx);
                    if (_blockEntityxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxx).putDouble("craftingProgress", 0.0d);
                    }
                    if (world instanceof Level) {
                        Level _level9 = (Level) world;
                        _level9.sendBlockUpdated(_bpxxxxxxxx, _bsxxxxxxxx, _bsxxxxxxxx, 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!world.isClientSide()) {
            BlockPos _bpxxxxxxxxx = BlockPos.containing(x, y, z);
            BlockEntity _blockEntityxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxx);
            BlockState _bsxxxxxxxxx = world.getBlockState(_bpxxxxxxxxx);
            if (_blockEntityxxxxxxxxx != null) {
                ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putDouble("craftingTime", 150.0d);
                ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putDouble("craftingProgress", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") + 1.0d);
            }
            if (world instanceof Level) {
                Level _level10 = (Level) world;
                _level10.sendBlockUpdated(_bpxxxxxxxxx, _bsxxxxxxxxx, _bsxxxxxxxxx, 3);
            }
        }
        if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "craftingProgress") >= 150.0d) {
            Object capability9 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
            if (capability9 instanceof IItemHandlerModifiable) {
                IItemHandlerModifiable _itemHandlerModifiable9 = (IItemHandlerModifiable) capability9;
                ItemStack _stk5 = _itemHandlerModifiable9.getStackInSlot(0).copy();
                _stk5.shrink(1);
                _itemHandlerModifiable9.setStackInSlot(0, _stk5);
            }
            Object capability10 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
            if (capability10 instanceof IItemHandlerModifiable) {
                IItemHandlerModifiable _itemHandlerModifiable10 = (IItemHandlerModifiable) capability10;
                ItemStack _setstack5 = new ItemStack(Items.SLIME_BALL).copy();
                _setstack5.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
                _itemHandlerModifiable10.setStackInSlot(1, _setstack5);
            }
            if (!world.isClientSide()) {
                BlockPos _bpxxxxxxxxxx = BlockPos.containing(x, y, z);
                BlockEntity _blockEntityxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxx);
                BlockState _bsxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxx);
                if (_blockEntityxxxxxxxxxx != null) {
                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putDouble("craftingProgress", 0.0d);
                }
                if (world instanceof Level) {
                    Level _level11 = (Level) world;
                    _level11.sendBlockUpdated(_bpxxxxxxxxxx, _bsxxxxxxxxxx, _bsxxxxxxxxxx, 3);
                }
            }
        }
    }

    private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
        new ILevelExtension(world);
        IItemHandler itemHandler = (IItemHandler) ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{pos, null});
        if (itemHandler != null) {
            return itemHandler.getStackInSlot(slot);
        }
        return ItemStack.EMPTY;
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0d);
        }
        return -1.0d;
    }
}
