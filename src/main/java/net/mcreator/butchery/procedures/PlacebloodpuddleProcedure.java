package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PlacebloodpuddleProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (ButcheryconfigConfiguration.BLOOD_PUDDLE.get().booleanValue()) {
            ButcheryMod.queueServerWork(40, () -> {
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 16.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_GRATE.get()) {
                    if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 1.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bp = BlockPos.containing((double)x, (double)(y - 1.0), (double)z);
                            BlockEntity _blockEntity = world.getBlockEntity(_bp);
                            BlockState _bs = world.getBlockState(_bp);
                            if (_blockEntity != null) {
                                ButcheryPersistentData.of(_blockEntity).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpx = BlockPos.containing((double)x, (double)(y - 1.0), (double)z);
                                BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                                BlockState _bsx = world.getBlockState(_bpx);
                                if (_blockEntityx != null) {
                                    ButcheryPersistentData.of(_blockEntityx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 2.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpx = BlockPos.containing((double)x, (double)(y - 2.0), (double)z);
                            BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                            BlockState _bsx = world.getBlockState(_bpx);
                            if (_blockEntityx != null) {
                                ButcheryPersistentData.of(_blockEntityx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxx = BlockPos.containing((double)x, (double)(y - 2.0), (double)z);
                                BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                                BlockState _bsxx = world.getBlockState(_bpxx);
                                if (_blockEntityxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 3.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxx = BlockPos.containing((double)x, (double)(y - 3.0), (double)z);
                            BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                            BlockState _bsxx = world.getBlockState(_bpxx);
                            if (_blockEntityxx != null) {
                                ButcheryPersistentData.of(_blockEntityxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxx = BlockPos.containing((double)x, (double)(y - 3.0), (double)z);
                                BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                                BlockState _bsxxx = world.getBlockState(_bpxxx);
                                if (_blockEntityxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxx, _bsxxx, _bsxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 4.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxx = BlockPos.containing((double)x, (double)(y - 4.0), (double)z);
                            BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                            BlockState _bsxxx = world.getBlockState(_bpxxx);
                            if (_blockEntityxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxx, _bsxxx, _bsxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxx = BlockPos.containing((double)x, (double)(y - 4.0), (double)z);
                                BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                                BlockState _bsxxxx = world.getBlockState(_bpxxxx);
                                if (_blockEntityxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxx, _bsxxxx, _bsxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 5.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxx = BlockPos.containing((double)x, (double)(y - 5.0), (double)z);
                            BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                            BlockState _bsxxxx = world.getBlockState(_bpxxxx);
                            if (_blockEntityxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxx, _bsxxxx, _bsxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxx = BlockPos.containing((double)x, (double)(y - 5.0), (double)z);
                                BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                                BlockState _bsxxxxx = world.getBlockState(_bpxxxxx);
                                if (_blockEntityxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxx, _bsxxxxx, _bsxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 6.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxx = BlockPos.containing((double)x, (double)(y - 6.0), (double)z);
                            BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                            BlockState _bsxxxxx = world.getBlockState(_bpxxxxx);
                            if (_blockEntityxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxx, _bsxxxxx, _bsxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxx = BlockPos.containing((double)x, (double)(y - 6.0), (double)z);
                                BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
                                BlockState _bsxxxxxx = world.getBlockState(_bpxxxxxx);
                                if (_blockEntityxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxx, _bsxxxxxx, _bsxxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 7.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxx = BlockPos.containing((double)x, (double)(y - 7.0), (double)z);
                            BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
                            BlockState _bsxxxxxx = world.getBlockState(_bpxxxxxx);
                            if (_blockEntityxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxxx, _bsxxxxxx, _bsxxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxxx = BlockPos.containing((double)x, (double)(y - 7.0), (double)z);
                                BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
                                BlockState _bsxxxxxxx = world.getBlockState(_bpxxxxxxx);
                                if (_blockEntityxxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxx, _bsxxxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 8.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxx = BlockPos.containing((double)x, (double)(y - 8.0), (double)z);
                            BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
                            BlockState _bsxxxxxxx = world.getBlockState(_bpxxxxxxx);
                            if (_blockEntityxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxx, _bsxxxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxxxx = BlockPos.containing((double)x, (double)(y - 8.0), (double)z);
                                BlockEntity _blockEntityxxxxxxxx = world.getBlockEntity(_bpxxxxxxxx);
                                BlockState _bsxxxxxxxx = world.getBlockState(_bpxxxxxxxx);
                                if (_blockEntityxxxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxxxx, _bsxxxxxxxx, _bsxxxxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 9.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxxx = BlockPos.containing((double)x, (double)(y - 9.0), (double)z);
                            BlockEntity _blockEntityxxxxxxxx = world.getBlockEntity(_bpxxxxxxxx);
                            BlockState _bsxxxxxxxx = world.getBlockState(_bpxxxxxxxx);
                            if (_blockEntityxxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxxxxx, _bsxxxxxxxx, _bsxxxxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 9.0), (double)z);
                                BlockEntity _blockEntityxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxx);
                                BlockState _bsxxxxxxxxx = world.getBlockState(_bpxxxxxxxxx);
                                if (_blockEntityxxxxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxxxxx, _bsxxxxxxxxx, _bsxxxxxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 10.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 10.0), (double)z);
                            BlockEntity _blockEntityxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxx);
                            BlockState _bsxxxxxxxxx = world.getBlockState(_bpxxxxxxxxx);
                            if (_blockEntityxxxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxxxxxx, _bsxxxxxxxxx, _bsxxxxxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 10.0), (double)z);
                                BlockEntity _blockEntityxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxx);
                                BlockState _bsxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxx);
                                if (_blockEntityxxxxxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxxxxxx, _bsxxxxxxxxxx, _bsxxxxxxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 11.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 11.0), (double)z);
                            BlockEntity _blockEntityxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxx);
                            BlockState _bsxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxx);
                            if (_blockEntityxxxxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxxxxxxx, _bsxxxxxxxxxx, _bsxxxxxxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 11.0), (double)z);
                                BlockEntity _blockEntityxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxx);
                                BlockState _bsxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxx);
                                if (_blockEntityxxxxxxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxxxxxxx, _bsxxxxxxxxxxx, _bsxxxxxxxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 12.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 12.0), (double)z);
                            BlockEntity _blockEntityxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxx);
                            BlockState _bsxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxx);
                            if (_blockEntityxxxxxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxxxxxxxx, _bsxxxxxxxxxxx, _bsxxxxxxxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 12.0), (double)z);
                                BlockEntity _blockEntityxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxx);
                                BlockState _bsxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxx);
                                if (_blockEntityxxxxxxxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxxxxxxxx, _bsxxxxxxxxxxxx, _bsxxxxxxxxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 13.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 13.0), (double)z);
                            BlockEntity _blockEntityxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxx);
                            BlockState _bsxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxx);
                            if (_blockEntityxxxxxxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxxxxxxxxx, _bsxxxxxxxxxxxx, _bsxxxxxxxxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 13.0), (double)z);
                                BlockEntity _blockEntityxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxx);
                                BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxx);
                                if (_blockEntityxxxxxxxxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxxxxxxxxx, _bsxxxxxxxxxxxxx, _bsxxxxxxxxxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 14.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 14.0), (double)z);
                            BlockEntity _blockEntityxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxx);
                            BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxx);
                            if (_blockEntityxxxxxxxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxxxxxxxxxx, _bsxxxxxxxxxxxxx, _bsxxxxxxxxxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 14.0), (double)z);
                                BlockEntity _blockEntityxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxx);
                                BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxx);
                                if (_blockEntityxxxxxxxxxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, 3);
                                }
                            }
                        });
                    } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 4.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 5.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 6.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 7.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 8.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 9.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 10.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 11.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 12.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 13.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 14.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 15.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 16.0), (double)z)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y - 16.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 16.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 16.0), (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlock(BlockPos.containing((double)x, (double)(y - 15.0), (double)z), ((Block)ButcheryModBlocks.BLOOD_PUDDLE.get()).defaultBlockState(), 3);
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 15.0), (double)z);
                            BlockEntity _blockEntityxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxx);
                            BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxx);
                            if (_blockEntityxxxxxxxxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putBoolean("sourceBlood", true);
                            }
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                _level.sendBlockUpdated(_bpxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, 3);
                            }
                        }
                        ButcheryMod.queueServerWork(110, () -> {
                            if (!world.isClientSide()) {
                                BlockPos _bpxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)(y - 15.0), (double)z);
                                BlockEntity _blockEntityxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxx);
                                BlockState _bsxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxx);
                                if (_blockEntityxxxxxxxxxxxxxxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxx).putBoolean("sourceBlood", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelx = (Level)world;
                                    _levelx.sendBlockUpdated(_bpxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxx, 3);
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}

