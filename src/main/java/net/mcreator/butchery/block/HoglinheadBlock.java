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

public class HoglinheadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public HoglinheadBlock(Properties properties) {
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
            box(0.99313, 0.02963, -1.33089, 14.99313, 6.02963, 17.66911),
            new VoxelShape[]{
               box(13.99313, 0.62763, 4.53308, 15.99313, 11.62763, 6.53308),
               box(-0.00687, 0.62763, 4.53308, 1.99313, 11.62763, 6.53308),
               box(14.77385, 2.55075, 10.63761, 15.77385, 6.55075, 16.63761),
               box(0.21242, 2.42722, 10.94591, 1.21242, 6.42722, 16.94591)
            }
         );
         case EAST -> Shapes.or(
            box(-1.66911, 0.02963, 0.99313, 17.33089, 6.02963, 14.99313),
            new VoxelShape[]{
               box(9.46692, 0.62763, 13.99313, 11.46692, 11.62763, 15.99313),
               box(9.46692, 0.62763, -0.00687, 11.46692, 11.62763, 1.99313),
               box(-0.63761, 2.55075, 14.77385, 5.36239, 6.55075, 15.77385),
               box(-0.94591, 2.42722, 0.21242, 5.05409, 6.42722, 1.21242)
            }
         );
         case WEST -> Shapes.or(
            box(-1.33089, 0.02963, 1.00687, 17.66911, 6.02963, 15.00687),
            new VoxelShape[]{
               box(4.53308, 0.62763, 0.00687, 6.53308, 11.62763, 2.00687),
               box(4.53308, 0.62763, 14.00687, 6.53308, 11.62763, 16.00687),
               box(10.63761, 2.55075, 0.22615, 16.63761, 6.55075, 1.22615),
               box(10.94591, 2.42722, 14.78758, 16.94591, 6.42722, 15.78758)
            }
         );
         default -> Shapes.or(
            box(1.00687, 0.02963, -1.66911, 15.00687, 6.02963, 17.33089),
            new VoxelShape[]{
               box(0.00687, 0.62763, 9.46692, 2.00687, 11.62763, 11.46692),
               box(14.00687, 0.62763, 9.46692, 16.00687, 11.62763, 11.46692),
               box(0.22615, 2.55075, -0.63761, 1.22615, 6.55075, 5.36239),
               box(14.78758, 2.42722, -0.94591, 15.78758, 6.42722, 5.05409)
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
