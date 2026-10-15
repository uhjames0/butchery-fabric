package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class SaltformationtipNeighbourBlockChangesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR || world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == Blocks.AIR) {
            BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
            Block.dropResources((BlockState)world.getBlockState(_pos), (LevelAccessor)world, (BlockPos)BlockPos.containing((double)x, (double)y, (double)z), null);
            world.destroyBlock(_pos, false);
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.AIR || world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.AIR) {
            Property _propertyNew;
            BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
            BlockState _bs = ((Block)ButcheryModBlocks.SALT_FORMATION_TIP.get()).defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Property _propertyOld : _bso.getProperties()) {
                _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                try {
                    _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
                }
                catch (Exception exception) {}
            }
            world.setBlock(_bp, _bs, 3);
            if (world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_MIDDLE.get() || world.getBlockState(BlockPos.containing((double)x, (double)(y - 1.0), (double)z)).getBlock() == ButcheryModBlocks.SALT_FORMATION_BASE.get()) {
                _bp = BlockPos.containing((double)x, (double)(y - 1.0), (double)z);
                _bs = ((Block)ButcheryModBlocks.SALT_FORMATION_FRUSTUM.get()).defaultBlockState();
                _bso = world.getBlockState(_bp);
                for (Property _propertyOldx : _bso.getProperties()) {
                    _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                    if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                    try {
                        _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                    }
                    catch (Exception exception) {}
                }
                world.setBlock(_bp, _bs, 3);
            }
        }
    }
}

