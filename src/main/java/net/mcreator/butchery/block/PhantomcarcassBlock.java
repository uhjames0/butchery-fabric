package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.PhantomcarcassBlockEntity;
import net.mcreator.butchery.procedures.PhantomcarcassOnTickUpdateProcedure;
import net.mcreator.butchery.procedures.PhantomcarcassbrokenProcedure;
import net.mcreator.butchery.shim.ButcheryBlockHooks.DestroyHook;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PhantomcarcassBlock extends Block implements EntityBlock, DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public PhantomcarcassBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            return s.getValue(PhantomcarcassBlock.BLOCKSTATE) == 1 ? 0 : 0;
         }
      }).getLightLevel()).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
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
      if ((Integer)state.getValue(BLOCKSTATE) == 1) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(5.5, 3.48171, 6.70847, 10.5, 12.48171, 9.70847),
               new VoxelShape[]{
                  box(-0.5, 3.48171, 7.70847, 5.5, 12.48171, 9.70847),
                  box(10.5, 3.48171, 7.70847, 16.5, 12.48171, 9.70847),
                  box(6.5, 12.46765, 7.71055, 9.5, 18.46765, 9.71055)
               }
            );
            case EAST -> Shapes.or(
               box(6.29153, 3.48171, 5.5, 9.29153, 12.48171, 10.5),
               new VoxelShape[]{
                  box(6.29153, 3.48171, -0.5, 8.29153, 12.48171, 5.5),
                  box(6.29153, 3.48171, 10.5, 8.29153, 12.48171, 16.5),
                  box(6.28945, 12.46765, 6.5, 8.28945, 18.46765, 9.5)
               }
            );
            case WEST -> Shapes.or(
               box(6.70847, 3.48171, 5.5, 9.70847, 12.48171, 10.5),
               new VoxelShape[]{
                  box(7.70847, 3.48171, 10.5, 9.70847, 12.48171, 16.5),
                  box(7.70847, 3.48171, -0.5, 9.70847, 12.48171, 5.5),
                  box(7.71055, 12.46765, 6.5, 9.71055, 18.46765, 9.5)
               }
            );
            default -> Shapes.or(
               box(5.5, 3.48171, 6.29153, 10.5, 12.48171, 9.29153),
               new VoxelShape[]{
                  box(10.5, 3.48171, 6.29153, 16.5, 12.48171, 8.29153),
                  box(-0.5, 3.48171, 6.29153, 5.5, 12.48171, 8.29153),
                  box(6.5, 12.46765, 6.28945, 9.5, 18.46765, 8.28945)
               }
            );
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(5.5, 0.05, 3.0, 10.5, 3.05, 12.0), new VoxelShape[]{box(-0.5, 0.05, 3.0, 5.5, 2.05, 12.0), box(10.5, 0.05, 3.0, 16.5, 2.05, 12.0)}
            );
            case EAST -> Shapes.or(
               box(4.0, 0.05, 5.5, 13.0, 3.05, 10.5), new VoxelShape[]{box(4.0, 0.05, -0.5, 13.0, 2.05, 5.5), box(4.0, 0.05, 10.5, 13.0, 2.05, 16.5)}
            );
            case WEST -> Shapes.or(
               box(3.0, 0.05, 5.5, 12.0, 3.05, 10.5), new VoxelShape[]{box(3.0, 0.05, 10.5, 12.0, 2.05, 16.5), box(3.0, 0.05, -0.5, 12.0, 2.05, 5.5)}
            );
            default -> Shapes.or(
               box(5.5, 0.05, 4.0, 10.5, 3.05, 13.0), new VoxelShape[]{box(10.5, 0.05, 4.0, 16.5, 2.05, 13.0), box(-0.5, 0.05, 4.0, 5.5, 2.05, 13.0)}
            );
         };
      }
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING, BLOCKSTATE});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      world.scheduleTick(pos, this, 1);
   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      PhantomcarcassOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
      world.scheduleTick(pos, this, 1);
   }

   public boolean butchery$onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
      boolean retval = true;
      PhantomcarcassbrokenProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
      return retval;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new PhantomcarcassBlockEntity(pos, state);
   }

   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
   }

   protected void affectNeighborsAfterRemoval(BlockState blockstate, ServerLevel world, BlockPos blockpos, boolean flag) {
      Containers.updateNeighboursAfterDestroy(blockstate, world, blockpos);
   }

   public boolean hasAnalogOutputSignal(BlockState state) {
      return true;
   }

   public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
      return world.getBlockEntity(pos) instanceof PhantomcarcassBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
