package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.TagValueInput;
import org.jetbrains.annotations.Nullable;

public class SalttipplacedProcedure {
    public static void onBlockPlace(ShimEvent.EntityPlaceShim event) {
        SalttipplacedProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
    }

    public static void execute(LevelAccessor world, double x, double y, double z) {
        SalttipplacedProcedure.execute(null, world, x, y, z);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_TIP.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() != ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get()) {
            BlockPos _bp = BlockPos.containing((double)x, (double)(y - 1.0), (double)z);
            BlockState _bs = ((Block)ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get()).defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Property _propertyOld : _bso.getProperties()) {
                Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
                }
                catch (Exception exception) {}
            }
            BlockEntity _be = world.getBlockEntity(_bp);
            CompoundTag _bnbt = null;
            if (_be != null) {
                _bnbt = _be.saveWithFullMetadata((HolderLookup.Provider)world.registryAccess());
                _be.setRemoved();
            }
            world.setBlock(_bp, _bs, 3);
            if (_bnbt != null && (_be = world.getBlockEntity(_bp)) != null) {
                try {
                    _be.loadWithComponents(TagValueInput.create((ProblemReporter)ProblemReporter.DISCARDING, (HolderLookup.Provider)world.registryAccess(), (CompoundTag)_bnbt));
                }
                catch (Exception _propertyNew) {
                    // empty catch block
                }
            }
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)ButcheryModBlocks.SALT_FORMATION_TIP.get()).defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_TIP.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() != ButcheryModBlocks.SALT_FORMATION_BASE.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() != ButcheryModBlocks.SALT_FORMATION_MIDDLE.get()) {
            BlockPos _bp = BlockPos.containing((double)x, (double)(y - 2.0), (double)z);
            BlockState _bs = ((Block)ButcheryModBlocks.SALT_FORMATION_BASE.get()).defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Property _propertyOldx : _bso.getProperties()) {
                Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                }
                catch (Exception exception) {}
            }
            BlockEntity _bex = world.getBlockEntity(_bp);
            CompoundTag _bnbtx = null;
            if (_bex != null) {
                _bnbtx = _bex.saveWithFullMetadata((HolderLookup.Provider)world.registryAccess());
                _bex.setRemoved();
            }
            world.setBlock(_bp, _bs, 3);
            if (_bnbtx != null && (_bex = world.getBlockEntity(_bp)) != null) {
                try {
                    _bex.loadWithComponents(TagValueInput.create((ProblemReporter)ProblemReporter.DISCARDING, (HolderLookup.Provider)world.registryAccess(), (CompoundTag)_bnbtx));
                }
                catch (Exception _propertyNew) {
                    // empty catch block
                }
            }
            _bp = BlockPos.containing((double)x, (double)(y - 1.0), (double)z);
            _bs = ((Block)ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get()).defaultBlockState();
            _bso = world.getBlockState(_bp);
            for (Property _propertyOldxx : _bso.getProperties()) {
                Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldxx));
                }
                catch (Exception exception) {}
            }
            _bex = world.getBlockEntity(_bp);
            _bnbtx = null;
            if (_bex != null) {
                _bnbtx = _bex.saveWithFullMetadata((HolderLookup.Provider)world.registryAccess());
                _bex.setRemoved();
            }
            world.setBlock(_bp, _bs, 3);
            if (_bnbtx != null && (_bex = world.getBlockEntity(_bp)) != null) {
                try {
                    _bex.loadWithComponents(TagValueInput.create((ProblemReporter)ProblemReporter.DISCARDING, (HolderLookup.Provider)world.registryAccess(), (CompoundTag)_bnbtx));
                }
                catch (Exception _propertyNew) {
                    // empty catch block
                }
            }
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)ButcheryModBlocks.SALT_FORMATION_TIP.get()).defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_TIP.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_BASE.get()) {
            BlockPos _bp = BlockPos.containing((double)x, (double)(y - 1.0), (double)z);
            BlockState _bs = ((Block)ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get()).defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Property _propertyOldxxx : _bso.getProperties()) {
                Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldxxx));
                }
                catch (Exception _propertyOldxx) {}
            }
            BlockEntity _bexx = world.getBlockEntity(_bp);
            CompoundTag _bnbtxx = null;
            if (_bexx != null) {
                _bnbtxx = _bexx.saveWithFullMetadata((HolderLookup.Provider)world.registryAccess());
                _bexx.setRemoved();
            }
            world.setBlock(_bp, _bs, 3);
            if (_bnbtxx != null && (_bexx = world.getBlockEntity(_bp)) != null) {
                try {
                    _bexx.loadWithComponents(TagValueInput.create((ProblemReporter)ProblemReporter.DISCARDING, (HolderLookup.Provider)world.registryAccess(), (CompoundTag)_bnbtxx));
                }
                catch (Exception _propertyNew) {
                    // empty catch block
                }
            }
            _bp = BlockPos.containing((double)x, (double)(y - 2.0), (double)z);
            _bs = ((Block)ButcheryModBlocks.SALT_FORMATION_MIDDLE.get()).defaultBlockState();
            _bso = world.getBlockState(_bp);
            for (Property _propertyOldxxxx : _bso.getProperties()) {
                Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldxxxx.getName());
                if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldxxxx));
                }
                catch (Exception exception) {}
            }
            _bexx = world.getBlockEntity(_bp);
            _bnbtxx = null;
            if (_bexx != null) {
                _bnbtxx = _bexx.saveWithFullMetadata((HolderLookup.Provider)world.registryAccess());
                _bexx.setRemoved();
            }
            world.setBlock(_bp, _bs, 3);
            if (_bnbtxx != null && (_bexx = world.getBlockEntity(_bp)) != null) {
                try {
                    _bexx.loadWithComponents(TagValueInput.create((ProblemReporter)ProblemReporter.DISCARDING, (HolderLookup.Provider)world.registryAccess(), (CompoundTag)_bnbtxx));
                }
                catch (Exception _propertyNew) {
                    // empty catch block
                }
            }
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)ButcheryModBlocks.SALT_FORMATION_TIP.get()).defaultBlockState(), 3);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_TIP.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 2.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 3.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_MIDDLE.get()) {
            BlockPos _bp = BlockPos.containing((double)x, (double)(y - 1.0), (double)z);
            BlockState _bs = ((Block)ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get()).defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Property _propertyOldxxxxx : _bso.getProperties()) {
                Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldxxxxx.getName());
                if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxx));
                }
                catch (Exception _propertyOldxxxx) {}
            }
            BlockEntity _bexxx = world.getBlockEntity(_bp);
            CompoundTag _bnbtxxx = null;
            if (_bexxx != null) {
                _bnbtxxx = _bexxx.saveWithFullMetadata((HolderLookup.Provider)world.registryAccess());
                _bexxx.setRemoved();
            }
            world.setBlock(_bp, _bs, 3);
            if (_bnbtxxx != null && (_bexxx = world.getBlockEntity(_bp)) != null) {
                try {
                    _bexxx.loadWithComponents(TagValueInput.create((ProblemReporter)ProblemReporter.DISCARDING, (HolderLookup.Provider)world.registryAccess(), (CompoundTag)_bnbtxxx));
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            _bp = BlockPos.containing((double)x, (double)(y - 2.0), (double)z);
            _bs = ((Block)ButcheryModBlocks.SALT_FORMATION_MIDDLE.get()).defaultBlockState();
            _bso = world.getBlockState(_bp);
            for (Property _propertyOldxxxxxx : _bso.getProperties()) {
                Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxx.getName());
                if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxx));
                }
                catch (Exception exception) {}
            }
            _bexxx = world.getBlockEntity(_bp);
            _bnbtxxx = null;
            if (_bexxx != null) {
                _bnbtxxx = _bexxx.saveWithFullMetadata((HolderLookup.Provider)world.registryAccess());
                _bexxx.setRemoved();
            }
            world.setBlock(_bp, _bs, 3);
            if (_bnbtxxx != null && (_bexxx = world.getBlockEntity(_bp)) != null) {
                try {
                    _bexxx.loadWithComponents(TagValueInput.create((ProblemReporter)ProblemReporter.DISCARDING, (HolderLookup.Provider)world.registryAccess(), (CompoundTag)_bnbtxxx));
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)ButcheryModBlocks.SALT_FORMATION_TIP.get()).defaultBlockState(), 3);
        }
    }
}

