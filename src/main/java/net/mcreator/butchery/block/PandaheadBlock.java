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

public class PandaheadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public PandaheadBlock(Properties properties) {
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
            box(1.4779, 0.04591, 4.43691, 14.4779, 10.04591, 13.43691),
            new VoxelShape[]{
               box(4.4779, 0.04591, 2.43691, 11.4779, 5.04591, 4.43691),
               box(11.4779, 8.09311, 7.43691, 16.4779, 12.09311, 8.43691),
               box(-0.5221, 8.09311, 7.43691, 4.4779, 12.09311, 8.43691)
            }
         );
         case EAST -> Shapes.or(
            box(2.56309, 0.04591, 1.4779, 11.56309, 10.04591, 14.4779),
            new VoxelShape[]{
               box(11.56309, 0.04591, 4.4779, 13.56309, 5.04591, 11.4779),
               box(7.56309, 8.09311, 11.4779, 8.56309, 12.09311, 16.4779),
               box(7.56309, 8.09311, -0.5221, 8.56309, 12.09311, 4.4779)
            }
         );
         case WEST -> Shapes.or(
            box(4.43691, 0.04591, 1.5221, 13.43691, 10.04591, 14.5221),
            new VoxelShape[]{
               box(2.43691, 0.04591, 4.5221, 4.43691, 5.04591, 11.5221),
               box(7.43691, 8.09311, -0.4779, 8.43691, 12.09311, 4.5221),
               box(7.43691, 8.09311, 11.5221, 8.43691, 12.09311, 16.5221)
            }
         );
         default -> Shapes.or(
            box(1.5221, 0.04591, 2.56309, 14.5221, 10.04591, 11.56309),
            new VoxelShape[]{
               box(4.5221, 0.04591, 11.56309, 11.5221, 5.04591, 13.56309),
               box(-0.4779, 8.09311, 7.56309, 4.5221, 12.09311, 8.56309),
               box(11.5221, 8.09311, 7.56309, 16.5221, 12.09311, 8.56309)
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
