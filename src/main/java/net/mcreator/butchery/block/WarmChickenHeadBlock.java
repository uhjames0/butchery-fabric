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

public class WarmChickenHeadBlock extends Block {
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public WarmChickenHeadBlock(Properties properties) {
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
         case NORTH -> Shapes.or(box(6.0, 0.0, 6.0, 10.0, 6.0, 9.0), new VoxelShape[]{box(6.0, 2.0, 4.0, 10.0, 4.0, 6.0), box(7.0, 0.0, 5.0, 9.0, 2.0, 7.0)});
         case EAST -> Shapes.or(box(7.0, 0.0, 6.0, 10.0, 6.0, 10.0), new VoxelShape[]{box(10.0, 2.0, 6.0, 12.0, 4.0, 10.0), box(9.0, 0.0, 7.0, 11.0, 2.0, 9.0)});
         case WEST -> Shapes.or(box(6.0, 0.0, 6.0, 9.0, 6.0, 10.0), new VoxelShape[]{box(4.0, 2.0, 6.0, 6.0, 4.0, 10.0), box(5.0, 0.0, 7.0, 7.0, 2.0, 9.0)});
         default -> Shapes.or(box(6.0, 0.0, 7.0, 10.0, 6.0, 10.0), new VoxelShape[]{box(6.0, 2.0, 10.0, 10.0, 4.0, 12.0), box(7.0, 0.0, 9.0, 9.0, 2.0, 11.0)});
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
