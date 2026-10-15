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

public class WhitehorseheadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public WhitehorseheadBlock(Properties properties) {
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
            box(5.0, -0.00768, 6.99712, 11.0, 4.99232, 13.99712),
            new VoxelShape[]{
               box(6.0, -0.00768, 1.99712, 10.0, 4.99232, 6.99712),
               box(8.55, 4.99232, 12.98712, 10.55, 7.99232, 13.98712),
               box(5.45, 4.99232, 12.98712, 7.45, 7.99232, 13.98712)
            }
         );
         case EAST -> Shapes.or(
            box(2.00288, -0.00768, 5.0, 9.00288, 4.99232, 11.0),
            new VoxelShape[]{
               box(9.00288, -0.00768, 6.0, 14.00288, 4.99232, 10.0),
               box(2.01288, 4.99232, 8.55, 3.01288, 7.99232, 10.55),
               box(2.01288, 4.99232, 5.45, 3.01288, 7.99232, 7.45)
            }
         );
         case WEST -> Shapes.or(
            box(6.99712, -0.00768, 5.0, 13.99712, 4.99232, 11.0),
            new VoxelShape[]{
               box(1.99712, -0.00768, 6.0, 6.99712, 4.99232, 10.0),
               box(12.98712, 4.99232, 5.45, 13.98712, 7.99232, 7.45),
               box(12.98712, 4.99232, 8.55, 13.98712, 7.99232, 10.55)
            }
         );
         default -> Shapes.or(
            box(5.0, -0.00768, 2.00288, 11.0, 4.99232, 9.00288),
            new VoxelShape[]{
               box(6.0, -0.00768, 9.00288, 10.0, 4.99232, 14.00288),
               box(5.45, 4.99232, 2.01288, 7.45, 7.99232, 3.01288),
               box(8.55, 4.99232, 2.01288, 10.55, 7.99232, 3.01288)
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
