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

public class DolphinheadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public DolphinheadBlock(Properties properties) {
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
            box(4.01135, 0.001, 6.96254, 12.01135, 7.001, 12.96254),
            new VoxelShape[]{box(7.01135, 2.001, 12.96254, 9.01135, 4.001, 13.96254), box(7.01135, 0.001, 2.96254, 9.01135, 2.001, 6.96254)}
         );
         case EAST -> Shapes.or(
            box(3.03746, 0.001, 4.01135, 9.03746, 7.001, 12.01135),
            new VoxelShape[]{box(2.03746, 2.001, 7.01135, 3.03746, 4.001, 9.01135), box(9.03746, 0.001, 7.01135, 13.03746, 2.001, 9.01135)}
         );
         case WEST -> Shapes.or(
            box(6.96254, 0.001, 3.98865, 12.96254, 7.001, 11.98865),
            new VoxelShape[]{box(12.96254, 2.001, 6.98865, 13.96254, 4.001, 8.98865), box(2.96254, 0.001, 6.98865, 6.96254, 2.001, 8.98865)}
         );
         default -> Shapes.or(
            box(3.98865, 0.001, 3.03746, 11.98865, 7.001, 9.03746),
            new VoxelShape[]{box(6.98865, 2.001, 2.03746, 8.98865, 4.001, 3.03746), box(6.98865, 0.001, 9.03746, 8.98865, 2.001, 13.03746)}
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
