package net.mcreator.butchery.block;

import net.mcreator.butchery.procedures.Drained_carcass_placedProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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

public class DrainedorangefrogcarcassBlock extends Block {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 6);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public DrainedorangefrogcarcassBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(DrainedorangefrogcarcassBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(DrainedorangefrogcarcassBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(DrainedorangefrogcarcassBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(DrainedorangefrogcarcassBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(DrainedorangefrogcarcassBlock.BLOCKSTATE) == 5) {
               return 0;
            } else {
               return s.getValue(DrainedorangefrogcarcassBlock.BLOCKSTATE) == 6 ? 0 : 0;
            }
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
            case NORTH -> box(4.575, 2.69795, 2.91705, 11.575, 11.69795, 7.91705);
            case EAST -> box(8.08295, 2.69795, 4.575, 13.08295, 11.69795, 11.575);
            case WEST -> box(2.91705, 2.69795, 4.425, 7.91705, 11.69795, 11.425);
            default -> box(4.425, 2.69795, 8.08295, 11.425, 11.69795, 13.08295);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(-1.4, 0.0, 0.0, 17.6, 2.0, 16.0), box(4.6, 2.05, 3.0, 11.6, 6.05, 12.0));
            case EAST -> Shapes.or(box(0.0, 0.0, -1.4, 16.0, 2.0, 17.6), box(4.0, 2.05, 4.6, 13.0, 6.05, 11.6));
            case WEST -> Shapes.or(box(0.0, 0.0, -1.6, 16.0, 2.0, 17.4), box(3.0, 2.05, 4.4, 12.0, 6.05, 11.4));
            default -> Shapes.or(box(-1.6, 0.0, 0.0, 17.4, 2.0, 16.0), box(4.4, 2.05, 4.0, 11.4, 6.05, 13.0));
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(-1.4, 0.0, 0.0, 17.6, 2.0, 16.0), box(4.6, 2.05, 3.0, 11.6, 6.05, 12.0));
            case EAST -> Shapes.or(box(0.0, 0.0, -1.4, 16.0, 2.0, 17.6), box(4.0, 2.05, 4.6, 13.0, 6.05, 11.6));
            case WEST -> Shapes.or(box(0.0, 0.0, -1.6, 16.0, 2.0, 17.4), box(3.0, 2.05, 4.4, 12.0, 6.05, 11.4));
            default -> Shapes.or(box(-1.6, 0.0, 0.0, 17.4, 2.0, 16.0), box(4.4, 2.05, 4.0, 11.4, 6.05, 13.0));
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 4) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(-1.4, 0.0, 0.0, 17.6, 2.0, 16.0), box(4.6, 2.05, 3.0, 11.6, 6.05, 12.0));
            case EAST -> Shapes.or(box(0.0, 0.0, -1.4, 16.0, 2.0, 17.6), box(4.0, 2.05, 4.6, 13.0, 6.05, 11.6));
            case WEST -> Shapes.or(box(0.0, 0.0, -1.6, 16.0, 2.0, 17.4), box(3.0, 2.05, 4.4, 12.0, 6.05, 11.4));
            default -> Shapes.or(box(-1.6, 0.0, 0.0, 17.4, 2.0, 16.0), box(4.4, 2.05, 4.0, 11.4, 6.05, 13.0));
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 5) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(-1.4, 0.0, 0.0, 17.6, 2.0, 16.0), box(4.6, 2.05, 3.0, 11.6, 6.05, 12.0));
            case EAST -> Shapes.or(box(0.0, 0.0, -1.4, 16.0, 2.0, 17.6), box(4.0, 2.05, 4.6, 13.0, 6.05, 11.6));
            case WEST -> Shapes.or(box(0.0, 0.0, -1.6, 16.0, 2.0, 17.4), box(3.0, 2.05, 4.4, 12.0, 6.05, 11.4));
            default -> Shapes.or(box(-1.6, 0.0, 0.0, 17.4, 2.0, 16.0), box(4.4, 2.05, 4.0, 11.4, 6.05, 13.0));
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 6) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(-1.4, 0.0, 0.0, 17.6, 2.0, 16.0), box(4.6, 2.05, 3.0, 11.6, 6.05, 12.0));
            case EAST -> Shapes.or(box(0.0, 0.0, -1.4, 16.0, 2.0, 17.6), box(4.0, 2.05, 4.6, 13.0, 6.05, 11.6));
            case WEST -> Shapes.or(box(0.0, 0.0, -1.6, 16.0, 2.0, 17.4), box(3.0, 2.05, 4.4, 12.0, 6.05, 11.4));
            default -> Shapes.or(box(-1.6, 0.0, 0.0, 17.4, 2.0, 16.0), box(4.4, 2.05, 4.0, 11.4, 6.05, 13.0));
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(4.5, 0.125, 3.0, 11.5, 5.125, 12.0);
            case EAST -> box(4.0, 0.125, 4.5, 13.0, 5.125, 11.5);
            case WEST -> box(3.0, 0.125, 4.5, 12.0, 5.125, 11.5);
            default -> box(4.5, 0.125, 4.0, 11.5, 5.125, 13.0);
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

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      Drained_carcass_placedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }
}
