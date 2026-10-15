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

public class AllblackcatheadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public AllblackcatheadBlock(Properties properties) {
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
            box(5.5, 0.0, 6.0, 10.5, 4.0, 11.0),
            new VoxelShape[]{box(6.5, 0.02, 5.0, 9.5, 2.02, 7.0), box(9.0, 4.0, 9.0, 10.0, 5.0, 11.0), box(6.0, 4.0, 9.0, 7.0, 5.0, 11.0)}
         );
         case EAST -> Shapes.or(
            box(5.0, 0.0, 5.5, 10.0, 4.0, 10.5),
            new VoxelShape[]{box(9.0, 0.02, 6.5, 11.0, 2.02, 9.5), box(5.0, 4.0, 9.0, 7.0, 5.0, 10.0), box(5.0, 4.0, 6.0, 7.0, 5.0, 7.0)}
         );
         case WEST -> Shapes.or(
            box(6.0, 0.0, 5.5, 11.0, 4.0, 10.5),
            new VoxelShape[]{box(5.0, 0.02, 6.5, 7.0, 2.02, 9.5), box(9.0, 4.0, 6.0, 11.0, 5.0, 7.0), box(9.0, 4.0, 9.0, 11.0, 5.0, 10.0)}
         );
         default -> Shapes.or(
            box(5.5, 0.0, 5.0, 10.5, 4.0, 10.0),
            new VoxelShape[]{box(6.5, 0.02, 9.0, 9.5, 2.02, 11.0), box(6.0, 4.0, 5.0, 7.0, 5.0, 7.0), box(9.0, 4.0, 5.0, 10.0, 5.0, 7.0)}
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
