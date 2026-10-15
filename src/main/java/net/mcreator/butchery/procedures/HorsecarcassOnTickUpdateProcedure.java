package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.procedures.FillbloodgrateProcedure;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class HorsecarcassOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {

        BlockPos _bpxx = null;
        BlockState _bso = null;
        BlockState _bsxx = null;
        if (HorsecarcassOnTickUpdateProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "isBleeding")) {
            Level _level;
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null) {
                    ButcheryPersistentData.of(_blockEntity).putDouble("Timer", HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") + 1.0);
                }
                if (world instanceof Level) {
                    _level = (Level)world;
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            }
            if (HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 28.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 56.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 84.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 112.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 140.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 168.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 196.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 224.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 252.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 280.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 308.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 336.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 364.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 392.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 420.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 448.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 476.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 504.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 532.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 560.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 588.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 616.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 644.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 672.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 700.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 728.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 756.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 784.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 812.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 840.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 868.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 896.0) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level2 = (ServerLevel)world;
                    _level2.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelx = (ServerLevel)world;
                        _levelx.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelx = (ServerLevel)world;
                        _levelx.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelx = (ServerLevel)world;
                        _levelx.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
            if (HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 45.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 90.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 135.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 180.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 225.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 270.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 315.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 360.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 405.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 450.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 495.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 540.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 585.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 630.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 675.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 720.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 765.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 810.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 855.0 || HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 900.0) {
                FillbloodgrateProcedure.execute(world, x, y, z);
            }
            if (HorsecarcassOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == 900.0) {
                if (!world.isClientSide()) {
                    BlockPos _bpx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                    BlockState _bsx = world.getBlockState(_bpx);
                    if (_blockEntityx != null) {
                        ButcheryPersistentData.of(_blockEntityx).putBoolean("isBleeding", false);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                    }
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.REGULAR_BLACK_HORSE_CARCASS.get()) {
                    _bpxx = BlockPos.containing((double)x, (double)y, (double)z);
                    _bsxx = new Object(){

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
                    }.with(((Block)ButcheryModBlocks.DRAINED_REGULAR_BLACK_HORSE_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    _bso = world.getBlockState(_bpxx);
                    for (Property _propertyOld : _bso.getProperties()) {
                        Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                        if (_propertyNew == null || _bsxx.getValue(_propertyNew) == null) continue;
                        try {
                            _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                        }
                        catch (Exception exception) {}
                    }
                    world.setBlock(_bpxx, _bsxx, 3);
                } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.REGULAR_BROWN_HORSE_CARCASS.get()) {
                    _bpxx = BlockPos.containing((double)x, (double)y, (double)z);
                    _bsxx = new Object(){

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
                    }.with(((Block)ButcheryModBlocks.DRAINED_REGULAR_BROWN_HORSE_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    _bso = world.getBlockState(_bpxx);
                    for (Property _propertyOldx : _bso.getProperties()) {
                        Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                        if (_propertyNew == null || _bsxx.getValue(_propertyNew) == null) continue;
                        try {
                            _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                        }
                        catch (Exception exception) {}
                    }
                    world.setBlock(_bpxx, _bsxx, 3);
                } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.REGULAR_CHESTNUT_HORSE_CARCASS.get()) {
                    _bpxx = BlockPos.containing((double)x, (double)y, (double)z);
                    _bsxx = new Object(){

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
                    }.with(((Block)ButcheryModBlocks.DRAINED_REGULAR_CHESTNUT_HORSE_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    _bso = world.getBlockState(_bpxx);
                    for (Property _propertyOldxx : _bso.getProperties()) {
                        Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                        if (_propertyNew == null || _bsxx.getValue(_propertyNew) == null) continue;
                        try {
                            _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxx));
                        }
                        catch (Exception exception) {}
                    }
                    world.setBlock(_bpxx, _bsxx, 3);
                } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.REGULAR_CREAMY_HORSE_CARCASS.get()) {
                    _bpxx = BlockPos.containing((double)x, (double)y, (double)z);
                    _bsxx = new Object(){

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
                    }.with(((Block)ButcheryModBlocks.DRAINED_REGULAR_CREAMY_HORSE_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    _bso = world.getBlockState(_bpxx);
                    for (Property _propertyOldxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                        if (_propertyNew == null || _bsxx.getValue(_propertyNew) == null) continue;
                        try {
                            _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxx));
                        }
                        catch (Exception exception) {}
                    }
                    world.setBlock(_bpxx, _bsxx, 3);
                } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.REGULAR_DARK_BROWN_HORSE_CARCASS.get()) {
                    _bpxx = BlockPos.containing((double)x, (double)y, (double)z);
                    _bsxx = new Object(){

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
                    }.with(((Block)ButcheryModBlocks.DRAINED_REGULAR_DARK_BROWN_HORSE_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    _bso = world.getBlockState(_bpxx);
                    for (Property _propertyOldxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxx.getName());
                        if (_propertyNew == null || _bsxx.getValue(_propertyNew) == null) continue;
                        try {
                            _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxx));
                        }
                        catch (Exception exception) {}
                    }
                    world.setBlock(_bpxx, _bsxx, 3);
                } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.REGULAR_GRAY_HORSE_CARCASS.get()) {
                    _bpxx = BlockPos.containing((double)x, (double)y, (double)z);
                    _bsxx = new Object(){

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
                    }.with(((Block)ButcheryModBlocks.DRAINED_GRAY_HORSE_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    _bso = world.getBlockState(_bpxx);
                    for (Property _propertyOldxxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxx.getName());
                        if (_propertyNew == null || _bsxx.getValue(_propertyNew) == null) continue;
                        try {
                            _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxx));
                        }
                        catch (Exception exception) {}
                    }
                    world.setBlock(_bpxx, _bsxx, 3);
                } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.REGULAR_WHITE_HORSE_CARCASS.get()) {
                    _bpxx = BlockPos.containing((double)x, (double)y, (double)z);
                    _bsxx = new Object(){

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
                    }.with(((Block)ButcheryModBlocks.DRAINED_WHITE_HORSE_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    _bso = world.getBlockState(_bpxx);
                    for (Property _propertyOldxxxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxx.getName());
                        if (_propertyNew == null || _bsxx.getValue(_propertyNew) == null) continue;
                        try {
                            _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxx));
                        }
                        catch (Exception exception) {}
                    }
                    world.setBlock(_bpxx, _bsxx, 3);
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
}

