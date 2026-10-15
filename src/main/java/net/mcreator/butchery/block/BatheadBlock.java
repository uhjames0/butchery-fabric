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

public class BatheadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public BatheadBlock(Properties properties) {
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
            box(7.25, -0.01244, 7.31256, 8.75, 1.48756, 8.81256),
            new VoxelShape[]{box(8.25, 1.23756, 7.56256, 9.0, 2.23756, 7.81256), box(7.0, 1.23756, 7.56256, 7.75, 2.23756, 7.81256)}
         );
         case EAST -> Shapes.or(
            box(7.18744, -0.01244, 7.25, 8.68744, 1.48756, 8.75),
            new VoxelShape[]{box(8.18744, 1.23756, 8.25, 8.43744, 2.23756, 9.0), box(8.18744, 1.23756, 7.0, 8.43744, 2.23756, 7.75)}
         );
         case WEST -> Shapes.or(
            box(7.31256, -0.01244, 7.25, 8.81256, 1.48756, 8.75),
            new VoxelShape[]{box(7.56256, 1.23756, 7.0, 7.81256, 2.23756, 7.75), box(7.56256, 1.23756, 8.25, 7.81256, 2.23756, 9.0)}
         );
         default -> Shapes.or(
            box(7.25, -0.01244, 7.18744, 8.75, 1.48756, 8.68744),
            new VoxelShape[]{box(7.0, 1.23756, 8.18744, 7.75, 2.23756, 8.43744), box(8.25, 1.23756, 8.18744, 9.0, 2.23756, 8.43744)}
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
