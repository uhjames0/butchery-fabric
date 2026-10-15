package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class DrainedsniffercarcassplacedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            Player _player;
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.HOOK.get()) {
                if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.NORTH) {
                    if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z - 1.0))).getBlock() == Blocks.AIR) {
                        if (world instanceof Level) {
                            Level _level = (Level)world;
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() - 1), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.NORTH), 3);
                        if (entity instanceof Player) {
                            Player _player2 = (Player)entity;
                            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                            _player2.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player2.inventoryMenu.getCraftSlots());
                        }
                    }
                } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.SOUTH) {
                    if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z + 1.0))).getBlock() == Blocks.AIR) {
                        if (world instanceof Level) {
                            Level _levelx = (Level)world;
                            if (!_levelx.isClientSide()) {
                                _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.SOUTH), 3);
                        if (entity instanceof Player) {
                            Player _player3 = (Player)entity;
                            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                            _player3.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player3.inventoryMenu.getCraftSlots());
                        }
                    }
                } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.WEST) {
                    if (world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level) {
                            Level _levelxx = (Level)world;
                            if (!_levelxx.isClientSide()) {
                                _levelxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.WEST), 3);
                        if (entity instanceof Player) {
                            Player _player4 = (Player)entity;
                            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                            _player4.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player4.inventoryMenu.getCraftSlots());
                        }
                    }
                } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.EAST) {
                    if (world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level) {
                            Level _levelxxx = (Level)world;
                            if (!_levelxxx.isClientSide()) {
                                _levelxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.EAST), 3);
                        if (entity instanceof Player) {
                            Player _player5 = (Player)entity;
                            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                            _player5.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player5.inventoryMenu.getCraftSlots());
                        }
                    }
                } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.UP) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (entity.getDirection() == Direction.NORTH) {
                        if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _levelxxxx = (Level)world;
                                if (!_levelxxxx.isClientSide()) {
                                    _levelxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                } else {
                                    _levelxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                }
                            }
                            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.SOUTH), 3);
                            if (entity instanceof Player) {
                                _player = (Player)entity;
                                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                            }
                        }
                    } else if (entity.getDirection() == Direction.SOUTH) {
                        if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _levelxxxxx = (Level)world;
                                if (!_levelxxxxx.isClientSide()) {
                                    _levelxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                } else {
                                    _levelxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                }
                            }
                            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.NORTH), 3);
                            if (entity instanceof Player) {
                                _player = (Player)entity;
                                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                            }
                        }
                    } else if (entity.getDirection() == Direction.WEST) {
                        if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _levelxxxxxx = (Level)world;
                                if (!_levelxxxxxx.isClientSide()) {
                                    _levelxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                } else {
                                    _levelxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                }
                            }
                            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.EAST), 3);
                            if (entity instanceof Player) {
                                _player = (Player)entity;
                                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                            }
                        }
                    } else if (entity.getDirection() == Direction.EAST && world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level) {
                            Level _levelxxxxxxx = (Level)world;
                            if (!_levelxxxxxxx.isClientSide()) {
                                _levelxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.WEST), 3);
                        if (entity instanceof Player) {
                            _player = (Player)entity;
                            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                        }
                    }
                } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.DOWN) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (entity.getDirection() == Direction.NORTH) {
                        if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _levelxxxxxxxx = (Level)world;
                                if (!_levelxxxxxxxx.isClientSide()) {
                                    _levelxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                } else {
                                    _levelxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                }
                            }
                            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.SOUTH), 3);
                            if (entity instanceof Player) {
                                _player = (Player)entity;
                                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                            }
                        }
                    } else if (entity.getDirection() == Direction.SOUTH) {
                        if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _levelxxxxxxxxx = (Level)world;
                                if (!_levelxxxxxxxxx.isClientSide()) {
                                    _levelxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                } else {
                                    _levelxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                }
                            }
                            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.NORTH), 3);
                            if (entity instanceof Player) {
                                _player = (Player)entity;
                                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                            }
                        }
                    } else if (entity.getDirection() == Direction.WEST) {
                        if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _levelxxxxxxxxxx = (Level)world;
                                if (!_levelxxxxxxxxxx.isClientSide()) {
                                    _levelxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                } else {
                                    _levelxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                }
                            }
                            world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.EAST), 3);
                            if (entity instanceof Player) {
                                _player = (Player)entity;
                                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                            }
                        }
                    } else if (entity.getDirection() == Direction.EAST && world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxxx = (Level)world;
                            if (!_levelxxxxxxxxxxx.isClientSide()) {
                                _levelxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        world.setBlock(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1, entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(100.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), Direction.WEST), 3);
                        if (entity instanceof Player) {
                            _player = (Player)entity;
                            ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                        }
                    }
                }
            } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.HOOK.get()) {
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR) {
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxx = (Level)world;
                        if (!_levelxxxxxxxxxxxx.isClientSide()) {
                            _levelxxxxxxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.chain.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.chain.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    world.setBlock(BlockPos.containing((double)x, (double)(y - 1.0), (double)z), DrainedsniffercarcassplacedProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState(), DrainedsniffercarcassplacedProcedure.getDirectionFromBlockState(world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)))), 3);
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing((double)x, (double)(y - 1.0), (double)z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                            ButcheryPersistentData.of(_blockEntity).putDouble("butcherStage", 5.0);
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxxxxx = (Level)world;
                            _levelxxxxxxxxxxxxx.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                    }
                    if (entity instanceof Player) {
                        Player _player6 = (Player)entity;
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_SNIFFER_CARCASS.get());
                        _player6.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player6.inventoryMenu.getCraftSlots());
                    }
                }
            } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.ROPE.get() && entity instanceof Player && !(_player = (Player)entity).level().isClientSide()) {
                _player.sendOverlayMessage((Component)Component.literal((String)"The sniffer is too heavy for the rope..."));
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

    private static Direction getDirectionFromBlockState(BlockState blockState) {
        EnumProperty ep;
        EnumProperty ep2;
        Property property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property instanceof EnumProperty && (ep2 = (EnumProperty)property).getValueClass() == Direction.class) {
            return (Direction)blockState.getValue((Property)ep2);
        }
        Property property2 = blockState.getBlock().getStateDefinition().getProperty("axis");
        return property2 instanceof EnumProperty && (ep = (EnumProperty)property2).getValueClass() == Direction.Axis.class ? Direction.fromAxisAndDirection((Direction.Axis)((Direction.Axis)blockState.getValue((Property)ep)), (Direction.AxisDirection)Direction.AxisDirection.POSITIVE) : Direction.NORTH;
    }
}

