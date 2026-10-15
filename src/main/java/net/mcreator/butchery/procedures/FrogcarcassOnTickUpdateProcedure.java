package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

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
import net.minecraft.world.level.storage.TagValueInput;

/* JADX INFO: loaded from: FrogcarcassOnTickUpdateProcedure.class */
public class FrogcarcassOnTickUpdateProcedure {
    /* JADX WARN: Type inference failed for: r0v36, types: [net.mcreator.butchery.procedures.FrogcarcassOnTickUpdateProcedure$3] */
    /* JADX WARN: Type inference failed for: r0v54, types: [net.mcreator.butchery.procedures.FrogcarcassOnTickUpdateProcedure$2] */
    /* JADX WARN: Type inference failed for: r0v72, types: [net.mcreator.butchery.procedures.FrogcarcassOnTickUpdateProcedure$1] */
    public static void execute(LevelAccessor world, double x, double y, double z) {
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
            if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 28.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 56.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 84.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 112.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 140.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 168.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 196.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 224.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 250.0d) {
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
            if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 45.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 90.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 135.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 180.0d || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 225.0d) {
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
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GRAY_FROG_CARCASS.get()) {
                    BlockPos _bpxx = BlockPos.containing(x, y, z);
                    BlockState _bsxx = new Object() { // from class: net.mcreator.butchery.procedures.FrogcarcassOnTickUpdateProcedure.1
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
                    }.with(((Block) ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).defaultBlockState(), "blockstate", 1);
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
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GREEN_FROG_CARCASS.get()) {
                    BlockPos _bpxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxx = new Object() { // from class: net.mcreator.butchery.procedures.FrogcarcassOnTickUpdateProcedure.2
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
                    }.with(((Block) ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    BlockEntity _bex2 = world.getBlockEntity(_bpxxx);
                    CompoundTag _bnbtx = null;
                    if (_bex2 != null) {
                        _bnbtx = _bex2.saveWithFullMetadata(world.registryAccess());
                        _bex2.setRemoved();
                    }
                    world.setBlock(_bpxxx, _bsxxx, 3);
                    if (_bnbtx != null && (_bex = world.getBlockEntity(_bpxxx)) != null) {
                        try {
                            _bex.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtx));
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    return;
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ORANGE_FROG_CARCASS.get()) {
                    BlockPos _bpxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxx = new Object() { // from class: net.mcreator.butchery.procedures.FrogcarcassOnTickUpdateProcedure.3
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
                    }.with(((Block) ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                    BlockEntity _bexx2 = world.getBlockEntity(_bpxxxx);
                    CompoundTag _bnbtxx = null;
                    if (_bexx2 != null) {
                        _bnbtxx = _bexx2.saveWithFullMetadata(world.registryAccess());
                        _bexx2.setRemoved();
                    }
                    world.setBlock(_bpxxxx, _bsxxxx, 3);
                    if (_bnbtxx != null && (_bexx = world.getBlockEntity(_bpxxxx)) != null) {
                        try {
                            _bexx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxx));
                        } catch (Exception e3) {
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
