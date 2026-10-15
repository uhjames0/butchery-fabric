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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RopeBlock extends Block {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 7);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public RopeBlock(Properties properties) {
      super(properties.strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(RopeBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(RopeBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(RopeBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(RopeBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(RopeBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(RopeBlock.BLOCKSTATE) == 6) {
               return 0;
            } else {
               return s.getValue(RopeBlock.BLOCKSTATE) == 7 ? 0 : 0;
            }
         }
      }).getLightLevel()).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASEDRUM));
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
      if ((Integer)state.getValue(BLOCKSTATE) == 4) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            case EAST -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            case WEST -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            default -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 5) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            case EAST -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            case WEST -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            default -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 6) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            case EAST -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            case WEST -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            default -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 7) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            case EAST -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            case WEST -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
            default -> box(5.0, -0.001, 5.0, 11.0, 15.999, 11.0);
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
            case EAST -> box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
            case WEST -> box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
            default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
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
