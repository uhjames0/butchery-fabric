package net.mcreator.butchery.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RabbitheadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public RabbitheadBlock(Properties properties) {
      super(properties.strength(1.0F, 10.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
      return switch ((Direction)state.getValue(FACING)) {
         case NORTH -> Shapes.or(
            box(5.45558, -0.01078, 5.79289, 10.45558, 3.98922, 10.79289),
            new VoxelShape[]{
               box(7.45558, 1.48922, 5.29289, 8.45558, 2.48922, 6.29289),
               box(5.45558, 3.98922, 9.54289, 7.45558, 8.98922, 10.54289),
               box(8.45558, 3.98922, 9.54289, 10.45558, 8.98922, 10.54289)
            }
         );
         case EAST -> Shapes.or(
            box(5.20711, -0.01078, 5.45558, 10.20711, 3.98922, 10.45558),
            new VoxelShape[]{
               box(9.70711, 1.48922, 7.45558, 10.70711, 2.48922, 8.45558),
               box(5.45711, 3.98922, 5.45558, 6.45711, 8.98922, 7.45558),
               box(5.45711, 3.98922, 8.45558, 6.45711, 8.98922, 10.45558)
            }
         );
         case WEST -> Shapes.or(
            box(5.79289, -0.01078, 5.54442, 10.79289, 3.98922, 10.54442),
            new VoxelShape[]{
               box(5.29289, 1.48922, 7.54442, 6.29289, 2.48922, 8.54442),
               box(9.54289, 3.98922, 8.54442, 10.54289, 8.98922, 10.54442),
               box(9.54289, 3.98922, 5.54442, 10.54289, 8.98922, 7.54442)
            }
         );
         default -> Shapes.or(
            box(5.54442, -0.01078, 5.20711, 10.54442, 3.98922, 10.20711),
            new VoxelShape[]{
               box(7.54442, 1.48922, 9.70711, 8.54442, 2.48922, 10.70711),
               box(8.54442, 3.98922, 5.45711, 10.54442, 8.98922, 6.45711),
               box(5.54442, 3.98922, 5.45711, 7.54442, 8.98922, 6.45711)
            }
         );
      };
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING});
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
}
