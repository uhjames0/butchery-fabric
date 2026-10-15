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

public class FoxheadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public FoxheadBlock(Properties properties) {
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
            box(4.25, 0.0, 5.95, 12.25, 6.0, 11.95),
            new VoxelShape[]{
               box(4.24746, 6.03477, 7.0, 6.24746, 8.03477, 8.0), box(10.24746, 6.03477, 7.0, 12.24746, 8.03477, 8.0), box(6.25, 0.0, 2.95, 10.25, 2.0, 5.95)
            }
         );
         case EAST -> Shapes.or(
            box(4.05, 0.0, 4.25, 10.05, 6.0, 12.25),
            new VoxelShape[]{
               box(8.0, 6.03477, 4.24746, 9.0, 8.03477, 6.24746), box(8.0, 6.03477, 10.24746, 9.0, 8.03477, 12.24746), box(10.05, 0.0, 6.25, 13.05, 2.0, 10.25)
            }
         );
         case WEST -> Shapes.or(
            box(5.95, 0.0, 3.75, 11.95, 6.0, 11.75),
            new VoxelShape[]{
               box(7.0, 6.03477, 9.75254, 8.0, 8.03477, 11.75254), box(7.0, 6.03477, 3.75254, 8.0, 8.03477, 5.75254), box(2.95, 0.0, 5.75, 5.95, 2.0, 9.75)
            }
         );
         default -> Shapes.or(
            box(3.75, 0.0, 4.05, 11.75, 6.0, 10.05),
            new VoxelShape[]{
               box(9.75254, 6.03477, 8.0, 11.75254, 8.03477, 9.0), box(3.75254, 6.03477, 8.0, 5.75254, 8.03477, 9.0), box(5.75, 0.0, 10.05, 9.75, 2.0, 13.05)
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
