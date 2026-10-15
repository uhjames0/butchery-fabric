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

public class PolarbearheadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public PolarbearheadBlock(Properties properties) {
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
            box(4.5, -0.003, 5.99253, 11.5, 6.997, 12.99253),
            new VoxelShape[]{
               box(5.5, -0.003, 2.99253, 10.5, 2.997, 5.99253), box(3.5, 5.997, 7.99253, 5.5, 7.997, 8.99253), box(10.5, 5.997, 7.99253, 12.5, 7.997, 8.99253)
            }
         );
         case EAST -> Shapes.or(
            box(3.00747, -0.003, 4.5, 10.00747, 6.997, 11.5),
            new VoxelShape[]{
               box(10.00747, -0.003, 5.5, 13.00747, 2.997, 10.5),
               box(7.00747, 5.997, 3.5, 8.00747, 7.997, 5.5),
               box(7.00747, 5.997, 10.5, 8.00747, 7.997, 12.5)
            }
         );
         case WEST -> Shapes.or(
            box(5.99253, -0.003, 4.5, 12.99253, 6.997, 11.5),
            new VoxelShape[]{
               box(2.99253, -0.003, 5.5, 5.99253, 2.997, 10.5), box(7.99253, 5.997, 10.5, 8.99253, 7.997, 12.5), box(7.99253, 5.997, 3.5, 8.99253, 7.997, 5.5)
            }
         );
         default -> Shapes.or(
            box(4.5, -0.003, 3.00747, 11.5, 6.997, 10.00747),
            new VoxelShape[]{
               box(5.5, -0.003, 10.00747, 10.5, 2.997, 13.00747),
               box(10.5, 5.997, 7.00747, 12.5, 7.997, 8.00747),
               box(3.5, 5.997, 7.00747, 5.5, 7.997, 8.00747)
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
