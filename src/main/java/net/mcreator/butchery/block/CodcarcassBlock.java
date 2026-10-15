package net.mcreator.butchery.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CodcarcassBlock extends Block {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public CodcarcassBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            return s.getValue(CodcarcassBlock.BLOCKSTATE) == 1 ? 0 : 0;
         }
      }).getLightLevel()).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
      if ((Integer)state.getValue(BLOCKSTATE) == 1) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(3.85, 0.3, 3.75, 12.85, 19.3, 10.75);
            case EAST -> box(5.25, 0.3, 3.85, 12.25, 19.3, 12.85);
            case WEST -> box(3.75, 0.3, 3.15, 10.75, 19.3, 12.15);
            default -> box(3.15, 0.3, 5.25, 12.15, 19.3, 12.25);
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(3.75, 0.05, 5.0, 13.75, 2.05, 9.0);
            case EAST -> box(7.0, 0.05, 3.75, 11.0, 2.05, 13.75);
            case WEST -> box(5.0, 0.05, 2.25, 9.0, 2.05, 12.25);
            default -> box(2.25, 0.05, 7.0, 12.25, 2.05, 11.0);
         };
      }
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING, BLOCKSTATE});
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
