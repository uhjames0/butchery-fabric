package net.mcreator.butchery.block;

import net.mcreator.butchery.procedures.SaltformationtipNeighbourBlockChangesProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SaltformationfrustumBlock
extends Block {
    public SaltformationfrustumBlock(BlockBehaviour.Properties properties) {
        super(properties.strength(1.0f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
    }

    public boolean propagatesSkylightDown(BlockState state) {
        return true;
    }

    public int getLightBlock(BlockState state) {
        return 0;
    }

    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
        super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
        SaltformationtipNeighbourBlockChangesProcedure.execute((LevelAccessor)world, pos.getX(), pos.getY(), pos.getZ());
    }
}

