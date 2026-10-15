package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.BrainBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BrainBlock
extends Block
implements EntityBlock {
    public BrainBlock(BlockBehaviour.Properties properties) {
        super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0f, 10.0f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return BrainBlock.box((double)4.6, (double)0.0, (double)4.0, (double)11.7, (double)5.4, (double)13.0);
    }

    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        MenuProvider menuProvider;
        BlockEntity blockEntity = worldIn.getBlockEntity(pos);
        return blockEntity instanceof MenuProvider ? (menuProvider = (MenuProvider)blockEntity) : null;
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BrainBlockEntity(pos, state);
    }

    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
    }

    protected void affectNeighborsAfterRemoval(BlockState blockstate, ServerLevel world, BlockPos blockpos, boolean flag) {
        Containers.updateNeighboursAfterDestroy((BlockState)blockstate, (Level)world, (BlockPos)blockpos);
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
        int n;
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BrainBlockEntity) {
            BrainBlockEntity be = (BrainBlockEntity)blockEntity;
            n = AbstractContainerMenu.getRedstoneSignalFromContainer((Container)be);
        } else {
            n = 0;
        }
        return n;
    }
}

