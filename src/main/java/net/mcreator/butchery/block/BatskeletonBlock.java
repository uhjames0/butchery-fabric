package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.BatskeletonBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BatskeletonBlock extends Block implements EntityBlock {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public BatskeletonBlock(Properties properties) {
      super(properties.sound(SoundType.BONE_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            return s.getValue(BatskeletonBlock.BLOCKSTATE) == 1 ? 0 : 0;
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
            case NORTH -> Shapes.or(box(7.25, 11.45594, 7.13094, 8.75, 12.95594, 8.63094), box(7.25, 12.95594, 7.13094, 8.75, 15.95594, 8.63094));
            case EAST -> Shapes.or(box(7.36906, 11.45594, 7.25, 8.86906, 12.95594, 8.75), box(7.36906, 12.95594, 7.25, 8.86906, 15.95594, 8.75));
            case WEST -> Shapes.or(box(7.13094, 11.45594, 7.25, 8.63094, 12.95594, 8.75), box(7.13094, 12.95594, 7.25, 8.63094, 15.95594, 8.75));
            default -> Shapes.or(box(7.25, 11.45594, 7.36906, 8.75, 12.95594, 8.86906), box(7.25, 12.95594, 7.36906, 8.75, 15.95594, 8.86906));
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(7.25, -0.04994, 6.62506, 8.75, 1.45006, 9.62506);
            case EAST -> box(6.37494, -0.04994, 7.25, 9.37494, 1.45006, 8.75);
            case WEST -> box(6.62506, -0.04994, 7.25, 9.62506, 1.45006, 8.75);
            default -> box(7.25, -0.04994, 6.37494, 8.75, 1.45006, 9.37494);
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

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new BatskeletonBlockEntity(pos, state);
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
      return world.getBlockEntity(pos) instanceof BatskeletonBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
