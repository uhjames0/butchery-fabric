package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
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
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: PlaceCookedbloodsausagesonhookProcedure.class */
public class PlaceCookedbloodsausagesonhookProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ItemStack mainHandItem;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        ItemStack offhandItem;
        if (entity != null) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntx = (LivingEntity) entity;
                    mainHandItem = _livEntx.getMainHandItem();
                } else {
                    mainHandItem = ItemStack.EMPTY;
                }
                if (mainHandItem.getItem() != ButcheryModItems.COOKED_BLOOD_SAUSAGE.get()) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity) entity;
                        offhandItem = _livEnt.getOffhandItem();
                    } else {
                        offhandItem = ItemStack.EMPTY;
                    }
                    if (offhandItem.getItem() != ButcheryModItems.COOKED_BLOOD_SAUSAGE.get()) {
                        return;
                    }
                }
                if (event instanceof ICancellableEvent) {
                    event.setCanceled(true);
                }
                if (world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock() == Blocks.AIR) {
                    world.setBlock(BlockPos.containing(x, y - 1.0d, z), blockStateWithDirection(((Block) ButcheryModBlocks.COOKED_BLOOD_SAUSAGES.get()).defaultBlockState(), getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))), 3);
                    if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()) {
                        if (world instanceof Level) {
                            Level _level = (Level) world;
                            if (!_level.isClientSide()) {
                                _level.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _level.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                    } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get() && (world instanceof Level)) {
                        Level _levelx = (Level) world;
                        if (!_levelx.isClientSide()) {
                            _levelx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")), SoundSource.NEUTRAL, 0.5f, 1.0f);
                        } else {
                            _levelx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")), SoundSource.NEUTRAL, 0.5f, 1.0f, false);
                        }
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity) entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (entity instanceof Player) {
                        Player _plr = (Player) entity;
                        if (_plr.getAbilities().instabuild) {
                            return;
                        }
                    }
                    if (entity instanceof Player) {
                        Player _player = (Player) entity;
                        ItemStack _stktoremove = new ItemStack((ItemLike) ButcheryModItems.COOKED_BLOOD_SAUSAGE.get());
                        _player.getInventory().clearOrCountMatchingItems(p -> {
                            return _stktoremove.getItem() == p.getItem();
                        }, false, 1, _player.inventoryMenu.getCraftSlots());
                        return;
                    }
                    return;
                }
                if (world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock() == ButcheryModBlocks.COOKED_BLOOD_SAUSAGES.get()) {
                    Property<?> property = world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property instanceof IntegerProperty) {
                        Property<?> _getip26 = property;
                        iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getValue(_getip26)).intValue();
                    } else {
                        iIntValue3 = -1;
                    }
                    if (iIntValue3 == 0) {
                        BlockPos _pos = BlockPos.containing(x, y - 1.0d, z);
                        BlockState _bs = world.getBlockState(_pos);
                        Property<?> property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property2 instanceof IntegerProperty) {
                            IntegerProperty _integerProp = (IntegerProperty) property2;
                            if (_integerProp.getPossibleValues().contains(1)) {
                                world.setBlock(_pos, (BlockState) _bs.setValue(_integerProp, 1), 3);
                            }
                        }
                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()) {
                            if (world instanceof Level) {
                                Level _levelxx = (Level) world;
                                if (!_levelxx.isClientSide()) {
                                    _levelxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                } else {
                                    _levelxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                }
                            }
                        } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get() && (world instanceof Level)) {
                            Level _levelxxx = (Level) world;
                            if (!_levelxxx.isClientSide()) {
                                _levelxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")), SoundSource.NEUTRAL, 0.5f, 1.0f);
                            } else {
                                _levelxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")), SoundSource.NEUTRAL, 0.5f, 1.0f, false);
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity2 = (LivingEntity) entity;
                            _entity2.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (entity instanceof Player) {
                            Player _plr2 = (Player) entity;
                            if (_plr2.getAbilities().instabuild) {
                                return;
                            }
                        }
                        if (entity instanceof Player) {
                            Player _player2 = (Player) entity;
                            ItemStack _stktoremove2 = new ItemStack((ItemLike) ButcheryModItems.COOKED_BLOOD_SAUSAGE.get());
                            _player2.getInventory().clearOrCountMatchingItems(p2 -> {
                                return _stktoremove2.getItem() == p2.getItem();
                            }, false, 1, _player2.inventoryMenu.getCraftSlots());
                            return;
                        }
                        return;
                    }
                }
                if (world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock() == ButcheryModBlocks.COOKED_BLOOD_SAUSAGES.get()) {
                    Property<?> property3 = world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property3 instanceof IntegerProperty) {
                        Property<?> _getip40 = property3;
                        iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getValue(_getip40)).intValue();
                    } else {
                        iIntValue2 = -1;
                    }
                    if (iIntValue2 == 1) {
                        BlockPos _posx = BlockPos.containing(x, y - 1.0d, z);
                        BlockState _bsx = world.getBlockState(_posx);
                        Property<?> property4 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property4 instanceof IntegerProperty) {
                            IntegerProperty _integerProp2 = (IntegerProperty) property4;
                            if (_integerProp2.getPossibleValues().contains(2)) {
                                world.setBlock(_posx, (BlockState) _bsx.setValue(_integerProp2, 2), 3);
                            }
                        }
                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()) {
                            if (world instanceof Level) {
                                Level _levelxxxx = (Level) world;
                                if (!_levelxxxx.isClientSide()) {
                                    _levelxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                } else {
                                    _levelxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                }
                            }
                        } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get() && (world instanceof Level)) {
                            Level _levelxxxxx = (Level) world;
                            if (!_levelxxxxx.isClientSide()) {
                                _levelxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")), SoundSource.NEUTRAL, 0.5f, 1.0f);
                            } else {
                                _levelxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")), SoundSource.NEUTRAL, 0.5f, 1.0f, false);
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity3 = (LivingEntity) entity;
                            _entity3.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (entity instanceof Player) {
                            Player _plr3 = (Player) entity;
                            if (_plr3.getAbilities().instabuild) {
                                return;
                            }
                        }
                        if (entity instanceof Player) {
                            Player _player3 = (Player) entity;
                            ItemStack _stktoremove3 = new ItemStack((ItemLike) ButcheryModItems.COOKED_BLOOD_SAUSAGE.get());
                            _player3.getInventory().clearOrCountMatchingItems(p3 -> {
                                return _stktoremove3.getItem() == p3.getItem();
                            }, false, 1, _player3.inventoryMenu.getCraftSlots());
                            return;
                        }
                        return;
                    }
                }
                if (world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock() == ButcheryModBlocks.COOKED_BLOOD_SAUSAGES.get()) {
                    Property<?> property5 = world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property5 instanceof IntegerProperty) {
                        Property<?> _getip54 = property5;
                        iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getValue(_getip54)).intValue();
                    } else {
                        iIntValue = -1;
                    }
                    if (iIntValue == 2 && (entity instanceof Player)) {
                        Player _player4 = (Player) entity;
                        if (!_player4.level().isClientSide()) {
                            _player4.sendOverlayMessage(Component.literal("It's full.."));
                        }
                    }
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

    private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
        Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property instanceof EnumProperty) {
            EnumProperty enumProperty = (EnumProperty) property;
            if (enumProperty.getPossibleValues().contains(newValue)) {
                return (BlockState) blockState.setValue(enumProperty, newValue);
            }
        }
        Property<?> property2 = blockState.getBlock().getStateDefinition().getProperty("axis");
        if (property2 instanceof EnumProperty) {
            EnumProperty enumProperty2 = (EnumProperty) property2;
            if (enumProperty2.getPossibleValues().contains(newValue.getAxis())) {
                return (BlockState) blockState.setValue(enumProperty2, newValue.getAxis());
            }
        }
        return blockState;
    }
}
