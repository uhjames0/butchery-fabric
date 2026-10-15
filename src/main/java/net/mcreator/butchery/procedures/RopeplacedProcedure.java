package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class RopeplacedProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            RopeplacedProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {

        Player _plr = null;

        _plr = null;
        RopeplacedProcedure.execute(null, world, x, y, z, entity);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {

        Player _plr = null;
        ItemStack itemStack;
        if (entity == null) return;
        if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            itemStack = _livEnt.getMainHandItem();
        } else {
            itemStack = ItemStack.EMPTY;
        }
        if (itemStack.getItem() != ((Block)ButcheryModBlocks.ROPE.get()).asItem()) return;
        if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.NORTH) {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z - 1.0))).getBlock() != Blocks.AIR) return;
            if (event instanceof ICancellableEvent) {
                NeoEvent _cancellable = event;
                _cancellable.setCanceled(true);
            }
            if (world instanceof Level) {
                Level _level = (Level)world;
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() - 1), RopeplacedProcedure.blockStateWithDirection(new Object(){

                /*
                 * Enabled aggressive block sorting
                 */
                public BlockState with(BlockState _bs, String _property, int _newValue) {
                    BlockState blockState;
                    Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                    if (_prop instanceof IntegerProperty) {
                        Property<?> _ip = (IntegerProperty)_prop;
                        if (_prop.getPossibleValues().contains(_newValue)) {
                            blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                            return blockState;
                        }
                    }
                    blockState = _bs;
                    return blockState;
                }
            }.with(((Block)ButcheryModBlocks.ROPE.get()).defaultBlockState(), "blockstate", 0), Direction.NORTH), 3);
            if (entity instanceof Player) {
                _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) return;
            }
            if (!(entity instanceof Player)) return;
            Player _player = (Player)entity;
            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ROPE.get());
            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
            return;
        } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.SOUTH) {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z + 1.0))).getBlock() != Blocks.AIR) return;
            if (event instanceof ICancellableEvent) {
                NeoEvent _cancellable = event;
                _cancellable.setCanceled(true);
            }
            if (world instanceof Level) {
                Level _levelx = (Level)world;
                if (!_levelx.isClientSide()) {
                    _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1), RopeplacedProcedure.blockStateWithDirection(new Object(){

                /*
                 * Enabled aggressive block sorting
                 */
                public BlockState with(BlockState _bs, String _property, int _newValue) {
                    BlockState blockState;
                    Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                    if (_prop instanceof IntegerProperty) {
                        Property<?> _ip = (IntegerProperty)_prop;
                        if (_prop.getPossibleValues().contains(_newValue)) {
                            blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                            return blockState;
                        }
                    }
                    blockState = _bs;
                    return blockState;
                }
            }.with(((Block)ButcheryModBlocks.ROPE.get()).defaultBlockState(), "blockstate", 0), Direction.SOUTH), 3);
            if (entity instanceof Player) {
                _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) return;
            }
            if (!(entity instanceof Player)) return;
            Player _player = (Player)entity;
            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ROPE.get());
            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
            return;
        } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.WEST) {
            if (world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)z)).getBlock() != Blocks.AIR) return;
            if (event instanceof ICancellableEvent) {
                NeoEvent _cancellable = event;
                _cancellable.setCanceled(true);
            }
            if (world instanceof Level) {
                Level _levelxx = (Level)world;
                if (!_levelxx.isClientSide()) {
                    _levelxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _levelxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), RopeplacedProcedure.blockStateWithDirection(new Object(){

                /*
                 * Enabled aggressive block sorting
                 */
                public BlockState with(BlockState _bs, String _property, int _newValue) {
                    BlockState blockState;
                    Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                    if (_prop instanceof IntegerProperty) {
                        Property<?> _ip = (IntegerProperty)_prop;
                        if (_prop.getPossibleValues().contains(_newValue)) {
                            blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                            return blockState;
                        }
                    }
                    blockState = _bs;
                    return blockState;
                }
            }.with(((Block)ButcheryModBlocks.ROPE.get()).defaultBlockState(), "blockstate", 0), Direction.WEST), 3);
            if (entity instanceof Player) {
                _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) return;
            }
            if (!(entity instanceof Player)) return;
            Player _player = (Player)entity;
            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ROPE.get());
            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
            return;
        } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.EAST) {
            if (world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)z)).getBlock() != Blocks.AIR) return;
            if (event instanceof ICancellableEvent) {
                NeoEvent _cancellable = event;
                _cancellable.setCanceled(true);
            }
            if (world instanceof Level) {
                Level _levelxxx = (Level)world;
                if (!_levelxxx.isClientSide()) {
                    _levelxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _levelxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), RopeplacedProcedure.blockStateWithDirection(new Object(){

                /*
                 * Enabled aggressive block sorting
                 */
                public BlockState with(BlockState _bs, String _property, int _newValue) {
                    BlockState blockState;
                    Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                    if (_prop instanceof IntegerProperty) {
                        Property<?> _ip = (IntegerProperty)_prop;
                        if (_prop.getPossibleValues().contains(_newValue)) {
                            blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                            return blockState;
                        }
                    }
                    blockState = _bs;
                    return blockState;
                }
            }.with(((Block)ButcheryModBlocks.ROPE.get()).defaultBlockState(), "blockstate", 0), Direction.EAST), 3);
            if (entity instanceof Player) {
                _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) return;
            }
            if (!(entity instanceof Player)) return;
            Player _player = (Player)entity;
            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ROPE.get());
            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
            return;
        } else {
            if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() != Direction.DOWN) return;
            if (event instanceof ICancellableEvent) {
                NeoEvent _cancellable = event;
                _cancellable.setCanceled(true);
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            if (entity.getDirection() == Direction.NORTH) {
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() != Blocks.AIR) return;
                if (world instanceof Level) {
                    Level _levelxxxx = (Level)world;
                    if (!_levelxxxx.isClientSide()) {
                        _levelxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                    } else {
                        _levelxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                    }
                }
                world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), RopeplacedProcedure.blockStateWithDirection(new Object(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public BlockState with(BlockState _bs, String _property, int _newValue) {
                        BlockState blockState;
                        Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        if (_prop instanceof IntegerProperty) {
                            Property<?> _ip = (IntegerProperty)_prop;
                            if (_prop.getPossibleValues().contains(_newValue)) {
                                blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                                return blockState;
                            }
                        }
                        blockState = _bs;
                        return blockState;
                    }
                }.with(((Block)ButcheryModBlocks.ROPE.get()).defaultBlockState(), "blockstate", 4), Direction.SOUTH), 3);
                if (entity instanceof Player) {
                    _plr = (Player)entity;
                    if (_plr.getAbilities().instabuild) return;
                }
                if (!(entity instanceof Player)) return;
                Player _player = (Player)entity;
                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ROPE.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                return;
            } else if (entity.getDirection() == Direction.SOUTH) {
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() != Blocks.AIR) return;
                if (world instanceof Level) {
                    Level _levelxxxxx = (Level)world;
                    if (!_levelxxxxx.isClientSide()) {
                        _levelxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                    } else {
                        _levelxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                    }
                }
                world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), RopeplacedProcedure.blockStateWithDirection(new Object(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public BlockState with(BlockState _bs, String _property, int _newValue) {
                        BlockState blockState;
                        Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        if (_prop instanceof IntegerProperty) {
                            Property<?> _ip = (IntegerProperty)_prop;
                            if (_prop.getPossibleValues().contains(_newValue)) {
                                blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                                return blockState;
                            }
                        }
                        blockState = _bs;
                        return blockState;
                    }
                }.with(((Block)ButcheryModBlocks.ROPE.get()).defaultBlockState(), "blockstate", 4), Direction.NORTH), 3);
                if (entity instanceof Player) {
                    _plr = (Player)entity;
                    if (_plr.getAbilities().instabuild) return;
                }
                if (!(entity instanceof Player)) return;
                Player _player = (Player)entity;
                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ROPE.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                return;
            } else if (entity.getDirection() == Direction.WEST) {
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() != Blocks.AIR) return;
                if (world instanceof Level) {
                    Level _levelxxxxxx = (Level)world;
                    if (!_levelxxxxxx.isClientSide()) {
                        _levelxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                    } else {
                        _levelxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                    }
                }
                world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), RopeplacedProcedure.blockStateWithDirection(new Object(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public BlockState with(BlockState _bs, String _property, int _newValue) {
                        BlockState blockState;
                        Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        if (_prop instanceof IntegerProperty) {
                            Property<?> _ip = (IntegerProperty)_prop;
                            if (_prop.getPossibleValues().contains(_newValue)) {
                                blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                                return blockState;
                            }
                        }
                        blockState = _bs;
                        return blockState;
                    }
                }.with(((Block)ButcheryModBlocks.ROPE.get()).defaultBlockState(), "blockstate", 4), Direction.EAST), 3);
                if (entity instanceof Player) {
                    _plr = (Player)entity;
                    if (_plr.getAbilities().instabuild) return;
                }
                if (!(entity instanceof Player)) return;
                Player _player = (Player)entity;
                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ROPE.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                return;
            } else {
                if (entity.getDirection() != Direction.EAST || world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() != Blocks.AIR) return;
                if (world instanceof Level) {
                    Level _levelxxxxxxx = (Level)world;
                    if (!_levelxxxxxxx.isClientSide()) {
                        _levelxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                    } else {
                        _levelxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                    }
                }
                world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), RopeplacedProcedure.blockStateWithDirection(new Object(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public BlockState with(BlockState _bs, String _property, int _newValue) {
                        BlockState blockState;
                        Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        if (_prop instanceof IntegerProperty) {
                            Property<?> _ip = (IntegerProperty)_prop;
                            if (_prop.getPossibleValues().contains(_newValue)) {
                                blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                                return blockState;
                            }
                        }
                        blockState = _bs;
                        return blockState;
                    }
                }.with(((Block)ButcheryModBlocks.ROPE.get()).defaultBlockState(), "blockstate", 4), Direction.WEST), 3);
                if (entity instanceof Player) {
                    _plr = (Player)entity;
                    if (_plr.getAbilities().instabuild) return;
                }
                if (!(entity instanceof Player)) return;
                Player _player = (Player)entity;
                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ROPE.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
            }
        }
    }

    private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
        EnumProperty enumProperty;
        EnumProperty enumProperty2;
        Property property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property instanceof EnumProperty && (enumProperty2 = (EnumProperty)property).getPossibleValues().contains(newValue)) {
            return (BlockState)blockState.setValue((Property)enumProperty2, (Comparable)newValue);
        }
        Property property2 = blockState.getBlock().getStateDefinition().getProperty("axis");
        return property2 instanceof EnumProperty && (enumProperty = (EnumProperty)property2).getPossibleValues().contains(newValue.getAxis()) ? (BlockState)blockState.setValue((Property)enumProperty, (Comparable)newValue.getAxis()) : blockState;
    }
}

