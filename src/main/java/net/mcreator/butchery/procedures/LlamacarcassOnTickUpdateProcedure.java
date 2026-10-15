package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.TagValueInput;

/* JADX INFO: loaded from: LlamacarcassOnTickUpdateProcedure.class */
public class LlamacarcassOnTickUpdateProcedure {
    /* JADX WARN: Type inference failed for: r0v115, types: [net.mcreator.butchery.procedures.LlamacarcassOnTickUpdateProcedure$2] */
    /* JADX WARN: Type inference failed for: r0v153, types: [net.mcreator.butchery.procedures.LlamacarcassOnTickUpdateProcedure$1] */
    /* JADX WARN: Type inference failed for: r0v39, types: [net.mcreator.butchery.procedures.LlamacarcassOnTickUpdateProcedure$4] */
    /* JADX WARN: Type inference failed for: r0v77, types: [net.mcreator.butchery.procedures.LlamacarcassOnTickUpdateProcedure$3] */
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockEntity _bexxx;
        BlockEntity _bexx;
        BlockEntity _bex;
        BlockEntity _be;
        if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isBleeding")) {
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null) {
                    ButcheryPersistentData.of(_blockEntity).putDouble("Timer", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") + 1.0d);
                }
                if (world instanceof Level) {
                    Level _level = (Level) world;
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            }
            if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 28.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 56.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 84.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 112.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 140.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 168.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 196.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 224.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 252.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 280.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 308.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 336.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 364.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 392.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 420.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 448.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 476.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 504.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 532.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 560.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 588.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 616.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 644.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 672.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 700.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 728.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 756.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 784.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 812.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 840.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 868.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 896.0d) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level2 = (ServerLevel) world;
                    _level2.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5d, y - 0.6d, z + 0.5d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level3 = (ServerLevel) world;
                        _level3.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6d, y - 0.6d, z + 0.6d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level3 = (ServerLevel) world;
                        _level3.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6d, y - 0.6d, z + 0.4d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level3 = (ServerLevel) world;
                        _level3.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4d, y - 0.6d, z + 0.6d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                    }
                });
            }
            if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 45.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 90.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 135.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 180.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 225.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 270.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 315.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 360.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 405.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 450.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 495.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 540.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 585.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 630.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 675.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 720.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 765.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 810.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 855.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 900.0d) {
                FillbloodgrateProcedure.execute(world, x, y, z);
            }
            if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 900.0d) {
                if (!world.isClientSide()) {
                    BlockPos _bpx = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                    BlockState _bsx = world.getBlockState(_bpx);
                    if (_blockEntityx != null) {
                        ButcheryPersistentData.of(_blockEntityx).putBoolean("isBleeding", false);
                    }
                    if (world instanceof Level) {
                        Level _level3 = (Level) world;
                        _level3.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                    }
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BROWN_LLAMA_CARCASS.get()) {
                    BlockPos _bpxx = BlockPos.containing(x, y, z);
                    BlockState _bsxx = new Object() { // from class: net.mcreator.butchery.procedures.LlamacarcassOnTickUpdateProcedure.1
                        public BlockState with(BlockState _bs2, String _property, int _newValue) {
                            Property<?> property = _bs2.getBlock().getStateDefinition().getProperty(_property);
                            if (property instanceof IntegerProperty) {
                                IntegerProperty _ip = (IntegerProperty) property;
                                if (property.getPossibleValues().contains(Integer.valueOf(_newValue))) {
                                    return (BlockState) _bs2.setValue((Property) _ip, (Comparable) Integer.valueOf(_newValue));
                                }
                            }
                            return _bs2;
                        }
                    }.with(((Block) ButcheryModBlocks.DRAINED_BROWN_LLAMA_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    BlockState _bso = world.getBlockState(_bpxx);
                    for (Property<?> _propertyOld : _bso.getProperties()) {
                        Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                        if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                            try {
                                _bsxx = (BlockState) _bsxx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                            } catch (Exception e) {
                            }
                        }
                    }
                    BlockEntity _be2 = world.getBlockEntity(_bpxx);
                    CompoundTag _bnbt = null;
                    if (_be2 != null) {
                        _bnbt = _be2.saveWithFullMetadata(world.registryAccess());
                        _be2.setRemoved();
                    }
                    world.setBlock(_bpxx, _bsxx, 3);
                    if (_bnbt != null && (_be = world.getBlockEntity(_bpxx)) != null) {
                        try {
                            _be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    return;
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CREAMY_LLAMA_CARCASS.get()) {
                    BlockPos _bpxx2 = BlockPos.containing(x, y, z);
                    BlockState _bsxx2 = new Object() { // from class: net.mcreator.butchery.procedures.LlamacarcassOnTickUpdateProcedure.2
                        public BlockState with(BlockState _bs2, String _property, int _newValue) {
                            Property<?> property = _bs2.getBlock().getStateDefinition().getProperty(_property);
                            if (property instanceof IntegerProperty) {
                                IntegerProperty _ip = (IntegerProperty) property;
                                if (property.getPossibleValues().contains(Integer.valueOf(_newValue))) {
                                    return (BlockState) _bs2.setValue((Property) _ip, (Comparable) Integer.valueOf(_newValue));
                                }
                            }
                            return _bs2;
                        }
                    }.with(((Block) ButcheryModBlocks.DRAINED_CREAMY_LLAMA_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    BlockState _bso2 = world.getBlockState(_bpxx2);
                    for (Property<?> _propertyOldx : _bso2.getProperties()) {
                        Property _propertyNew2 = _bsxx2.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                        if (_propertyNew2 != null && _bsxx2.getValue(_propertyNew2) != null) {
                            try {
                                _bsxx2 = (BlockState) _bsxx2.setValue(_propertyNew2, _bso2.getValue(_propertyOldx));
                            } catch (Exception e3) {
                            }
                        }
                    }
                    BlockEntity _bex2 = world.getBlockEntity(_bpxx2);
                    CompoundTag _bnbtx = null;
                    if (_bex2 != null) {
                        _bnbtx = _bex2.saveWithFullMetadata(world.registryAccess());
                        _bex2.setRemoved();
                    }
                    world.setBlock(_bpxx2, _bsxx2, 3);
                    if (_bnbtx != null && (_bex = world.getBlockEntity(_bpxx2)) != null) {
                        try {
                            _bex.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtx));
                            return;
                        } catch (Exception e4) {
                            return;
                        }
                    }
                    return;
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GRAY_LLAMA_CARCASS.get()) {
                    BlockPos _bpxx3 = BlockPos.containing(x, y, z);
                    BlockState _bsxx3 = new Object() { // from class: net.mcreator.butchery.procedures.LlamacarcassOnTickUpdateProcedure.3
                        public BlockState with(BlockState _bs2, String _property, int _newValue) {
                            Property<?> property = _bs2.getBlock().getStateDefinition().getProperty(_property);
                            if (property instanceof IntegerProperty) {
                                IntegerProperty _ip = (IntegerProperty) property;
                                if (property.getPossibleValues().contains(Integer.valueOf(_newValue))) {
                                    return (BlockState) _bs2.setValue((Property) _ip, (Comparable) Integer.valueOf(_newValue));
                                }
                            }
                            return _bs2;
                        }
                    }.with(((Block) ButcheryModBlocks.DRAINED_GRAY_LLAMA_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    BlockState _bso3 = world.getBlockState(_bpxx3);
                    for (Property<?> _propertyOldxx : _bso3.getProperties()) {
                        Property _propertyNew3 = _bsxx3.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                        if (_propertyNew3 != null && _bsxx3.getValue(_propertyNew3) != null) {
                            try {
                                _bsxx3 = (BlockState) _bsxx3.setValue(_propertyNew3, _bso3.getValue(_propertyOldxx));
                            } catch (Exception e5) {
                            }
                        }
                    }
                    BlockEntity _bexx2 = world.getBlockEntity(_bpxx3);
                    CompoundTag _bnbtxx = null;
                    if (_bexx2 != null) {
                        _bnbtxx = _bexx2.saveWithFullMetadata(world.registryAccess());
                        _bexx2.setRemoved();
                    }
                    world.setBlock(_bpxx3, _bsxx3, 3);
                    if (_bnbtxx != null && (_bexx = world.getBlockEntity(_bpxx3)) != null) {
                        try {
                            _bexx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxx));
                            return;
                        } catch (Exception e6) {
                            return;
                        }
                    }
                    return;
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WHITE_LLAMA_CARCASS.get()) {
                    BlockPos _bpxx4 = BlockPos.containing(x, y, z);
                    BlockState _bsxx4 = new Object() { // from class: net.mcreator.butchery.procedures.LlamacarcassOnTickUpdateProcedure.4
                        public BlockState with(BlockState _bs2, String _property, int _newValue) {
                            Property<?> property = _bs2.getBlock().getStateDefinition().getProperty(_property);
                            if (property instanceof IntegerProperty) {
                                IntegerProperty _ip = (IntegerProperty) property;
                                if (property.getPossibleValues().contains(Integer.valueOf(_newValue))) {
                                    return (BlockState) _bs2.setValue((Property) _ip, (Comparable) Integer.valueOf(_newValue));
                                }
                            }
                            return _bs2;
                        }
                    }.with(((Block) ButcheryModBlocks.DRAINED_WHITE_LLAMA_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    BlockState _bso4 = world.getBlockState(_bpxx4);
                    for (Property<?> _propertyOldxxx : _bso4.getProperties()) {
                        Property _propertyNew4 = _bsxx4.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                        if (_propertyNew4 != null && _bsxx4.getValue(_propertyNew4) != null) {
                            try {
                                _bsxx4 = (BlockState) _bsxx4.setValue(_propertyNew4, _bso4.getValue(_propertyOldxxx));
                            } catch (Exception e7) {
                            }
                        }
                    }
                    BlockEntity _bexxx2 = world.getBlockEntity(_bpxx4);
                    CompoundTag _bnbtxxx = null;
                    if (_bexxx2 != null) {
                        _bnbtxxx = _bexxx2.saveWithFullMetadata(world.registryAccess());
                        _bexxx2.setRemoved();
                    }
                    world.setBlock(_bpxx4, _bsxx4, 3);
                    if (_bnbtxxx != null && (_bexxx = world.getBlockEntity(_bpxx4)) != null) {
                        try {
                            _bexxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxx));
                        } catch (Exception e8) {
                        }
                    }
                }
            }
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false);
        }
        return false;
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0d);
        }
        return -1.0d;
    }
}
