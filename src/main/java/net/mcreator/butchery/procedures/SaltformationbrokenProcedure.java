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

public class SaltformationbrokenProcedure {
    public static void onBlockBreak(ShimEvent.BreakShim event) {
        SaltformationbrokenProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
    }

    public static void execute(LevelAccessor world, double x, double y, double z) {
        SaltformationbrokenProcedure.execute(null, world, x, y, z);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_TIP.get() && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get() && world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_BASE.get()) {
            world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)ButcheryModBlocks.SALT_FORMATION_TIP.get()).defaultBlockState(), 3);
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
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }
}

