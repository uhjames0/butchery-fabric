package net.mcreator.butchery.block;

import net.mcreator.butchery.procedures.BloodsplatterrightclickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BloodsplatterBlock extends Block {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 9);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
   public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

   public BloodsplatterBlock(Properties properties) {
      super(properties.sound(SoundType.SLIME_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(BloodsplatterBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(BloodsplatterBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(BloodsplatterBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(BloodsplatterBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(BloodsplatterBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(BloodsplatterBlock.BLOCKSTATE) == 6) {
               return 0;
            } else if ((Integer)s.getValue(BloodsplatterBlock.BLOCKSTATE) == 7) {
               return 0;
            } else if ((Integer)s.getValue(BloodsplatterBlock.BLOCKSTATE) == 8) {
               return 0;
            } else {
               return s.getValue(BloodsplatterBlock.BLOCKSTATE) == 9 ? 0 : 0;
            }
         }
      }).getLightLevel()).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
      this.registerDefaultState(
         (BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(FACE, AttachFace.WALL)
      );
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
         case NORTH -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(0.0, 0.0, 0.0, 16.0, 0.2, 16.0);
               case WALL:
                  yield box(0.0, 0.0, 15.8, 16.0, 16.0, 16.0);
               case CEILING:
                  yield box(0.0, 15.8, 0.0, 16.0, 16.0, 16.0);
               default:
                  throw new MatchException(null, null);
            }
         }
         case EAST -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(0.0, 0.0, 0.0, 16.0, 0.2, 16.0);
               case WALL:
                  yield box(0.0, 0.0, 0.0, 0.2, 16.0, 16.0);
               case CEILING:
                  yield box(0.0, 15.8, 0.0, 16.0, 16.0, 16.0);
               default:
                  throw new MatchException(null, null);
            }
         }
         case WEST -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(0.0, 0.0, 0.0, 16.0, 0.2, 16.0);
               case WALL:
                  yield box(15.8, 0.0, 0.0, 16.0, 16.0, 16.0);
               case CEILING:
                  yield box(0.0, 15.8, 0.0, 16.0, 16.0, 16.0);
               default:
                  throw new MatchException(null, null);
            }
         }
         default -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(0.0, 0.0, 0.0, 16.0, 0.2, 16.0);
               case WALL:
                  yield box(0.0, 0.0, 0.0, 16.0, 16.0, 0.2);
               case CEILING:
                  yield box(0.0, 15.8, 0.0, 16.0, 16.0, 16.0);
               default:
                  throw new MatchException(null, null);
            }
         }
      };
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING, FACE, BLOCKSTATE});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)((BlockState)super.getStateForPlacement(context).setValue(FACE, this.faceForDirection(context.getNearestLookingDirection())))
         .setValue(FACING, context.getHorizontalDirection().getOpposite());
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   private AttachFace faceForDirection(Direction direction) {
      if (direction.getAxis() == Axis.Y) {
         return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
      } else {
         return AttachFace.WALL;
      }
   }

   public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
      super.useWithoutItem(blockstate, world, pos, entity, hit);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      double hitX = hit.getLocation().x;
      double hitY = hit.getLocation().y;
      double hitZ = hit.getLocation().z;
      Direction direction = hit.getDirection();
      BloodsplatterrightclickProcedure.execute(world, x, y, z, blockstate, entity);
      return InteractionResult.SUCCESS;
   }
}
