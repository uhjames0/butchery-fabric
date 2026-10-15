package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.FluidHandler;
import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.mcreator.butchery.shim.itemcap.ItemHandlerHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

/* JADX INFO: loaded from: FillsaltbasinProcedure.class */
public class FillsaltbasinProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        ItemStack mainHandItem;
        ItemStack offhandItem;
        if (entity != null && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BASIN.get()) {
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity) entity;
                mainHandItem = _livEnt.getMainHandItem();
            } else {
                mainHandItem = ItemStack.EMPTY;
            }
            if (mainHandItem.getItem() == Items.WATER_BUCKET) {
                if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 0) {
                    if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "basinEvaporating")) {
                        if (!world.isClientSide()) {
                            BlockPos _bp = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntity = world.getBlockEntity(_bp);
                            BlockState _bs = world.getBlockState(_bp);
                            if (_blockEntity != null) {
                                ButcheryPersistentData.of(_blockEntity).putBoolean("basinEvaporating", true);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
                            }
                        }
                        new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                        if (_fluidHandler != null) {
                            _fluidHandler.fill(new FluidStack((Fluid) Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
                        }
                        BlockPos _pos = BlockPos.containing(x, y, z);
                        BlockState _bsx = world.getBlockState(_pos);
                        Property<?> property = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property instanceof IntegerProperty) {
                            IntegerProperty _integerProp = (IntegerProperty) property;
                            if (_integerProp.getPossibleValues().contains(1)) {
                                world.setBlock(_pos, (BlockState) _bsx.setValue(_integerProp, 1), 3);
                            }
                        }
                        if (world instanceof Level) {
                            Level _level = (Level) world;
                            if (!_level.isClientSide()) {
                                _level.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _level.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity) entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (entity instanceof Player) {
                            Player _plr = (Player) entity;
                            if (_plr.getAbilities().instabuild) {
                                ButcheryMod.queueServerWork(3, () -> {
                                    if (entity instanceof Player) {
                                        Player _playerx = (Player) entity;
                                        ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                                        _setstack.setCount(1);
                                        ItemHandlerHelper.giveItemToPlayer(_playerx, _setstack);
                                    }
                                });
                                return;
                            }
                        }
                        if (entity instanceof Player) {
                            Player _player = (Player) entity;
                            ItemStack _stktoremove = new ItemStack(Items.WATER_BUCKET);
                            _player.getInventory().clearOrCountMatchingItems(p -> {
                                return _stktoremove.getItem() == p.getItem();
                            }, false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                        ButcheryMod.queueServerWork(3, () -> {
                            if (entity instanceof Player) {
                                Player _playerx = (Player) entity;
                                ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                                _setstack.setCount(1);
                                ItemHandlerHelper.giveItemToPlayer(_playerx, _setstack);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) > 10 && (entity instanceof Player)) {
                    Player _player2 = (Player) entity;
                    if (!_player2.level().isClientSide()) {
                        _player2.sendOverlayMessage(Component.literal("You need to wait for the water to evaporate before adding more.."));
                        return;
                    }
                    return;
                }
                return;
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _livEntx = (LivingEntity) entity;
                offhandItem = _livEntx.getOffhandItem();
            } else {
                offhandItem = ItemStack.EMPTY;
            }
            if (offhandItem.getItem() == Items.WATER_BUCKET) {
                if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) == 0) {
                    if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "basinEvaporating")) {
                        if (!world.isClientSide()) {
                            BlockPos _bpx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                            BlockState _bsxx = world.getBlockState(_bpx);
                            if (_blockEntityx != null) {
                                ButcheryPersistentData.of(_blockEntityx).putBoolean("basinEvaporating", true);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpx, _bsxx, _bsxx, 3);
                            }
                        }
                        new ILevelExtension(world);
                        IFluidHandler _fluidHandler2 = (IFluidHandler) ButcheryCaps.getCapability(world, FluidHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
                        if (_fluidHandler2 != null) {
                            _fluidHandler2.fill(new FluidStack((Fluid) Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
                        }
                        BlockPos _posx = BlockPos.containing(x, y, z);
                        BlockState _bsxxx = world.getBlockState(_posx);
                        Property<?> property2 = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property2 instanceof IntegerProperty) {
                            IntegerProperty _integerProp2 = (IntegerProperty) property2;
                            if (_integerProp2.getPossibleValues().contains(1)) {
                                world.setBlock(_posx, (BlockState) _bsxxx.setValue(_integerProp2, 1), 3);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelx = (Level) world;
                            if (!_levelx.isClientSide()) {
                                _levelx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity2 = (LivingEntity) entity;
                            _entity2.swing(InteractionHand.OFF_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (entity instanceof Player) {
                            Player _plr2 = (Player) entity;
                            if (_plr2.getAbilities().instabuild) {
                                ButcheryMod.queueServerWork(3, () -> {
                                    if (entity instanceof Player) {
                                        Player _playerx = (Player) entity;
                                        ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                                        _setstack.setCount(1);
                                        ItemHandlerHelper.giveItemToPlayer(_playerx, _setstack);
                                    }
                                });
                                return;
                            }
                        }
                        if (entity instanceof Player) {
                            Player _player3 = (Player) entity;
                            ItemStack _stktoremove2 = new ItemStack(Items.WATER_BUCKET);
                            _player3.getInventory().clearOrCountMatchingItems(p2 -> {
                                return _stktoremove2.getItem() == p2.getItem();
                            }, false, 1, _player3.inventoryMenu.getCraftSlots());
                        }
                        ButcheryMod.queueServerWork(3, () -> {
                            if (entity instanceof Player) {
                                Player _playerx = (Player) entity;
                                ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                                _setstack.setCount(1);
                                ItemHandlerHelper.giveItemToPlayer(_playerx, _setstack);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) > 10 && (entity instanceof Player)) {
                    Player _player4 = (Player) entity;
                    if (!_player4.level().isClientSide()) {
                        _player4.sendOverlayMessage(Component.literal("You need to wait for the water to evaporate before adding more.."));
                    }
                }
            }
        }
    }

    private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
        new ILevelExtension(level);
        IFluidHandler fluidHandler = (IFluidHandler) ButcheryCaps.getCapability(level, FluidHandler.BLOCK, new Object[]{pos, direction});
        if (fluidHandler != null) {
            return fluidHandler.getFluidInTank(tank).getAmount();
        }
        return 0;
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false);
        }
        return false;
    }
}
