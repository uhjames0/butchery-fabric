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

public class EndermiteBlock extends Block {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 3);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public EndermiteBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(EndermiteBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(EndermiteBlock.BLOCKSTATE) == 2) {
               return 0;
            } else {
               return s.getValue(EndermiteBlock.BLOCKSTATE) == 3 ? 0 : 0;
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
            case NORTH -> Shapes.or(box(5.5, 0.0, 5.0, 10.5, 4.0, 11.0), new VoxelShape[]{box(4.5, 0.0, 6.5, 5.5, 3.0, 9.5), box(3.5, 0.0, 7.5, 4.5, 2.0, 8.5)});
            case EAST -> Shapes.or(box(5.0, 0.0, 5.5, 11.0, 4.0, 10.5), new VoxelShape[]{box(6.5, 0.0, 4.5, 9.5, 3.0, 5.5), box(7.5, 0.0, 3.5, 8.5, 2.0, 4.5)});
            case WEST -> Shapes.or(
               box(5.0, 0.0, 5.5, 11.0, 4.0, 10.5), new VoxelShape[]{box(6.5, 0.0, 10.5, 9.5, 3.0, 11.5), box(7.5, 0.0, 11.5, 8.5, 2.0, 12.5)}
            );
            default -> Shapes.or(
               box(5.5, 0.0, 5.0, 10.5, 4.0, 11.0), new VoxelShape[]{box(10.5, 0.0, 6.5, 11.5, 3.0, 9.5), box(11.5, 0.0, 7.5, 12.5, 2.0, 8.5)}
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(5.5, 0.0, 5.0, 10.5, 4.0, 11.0), box(4.5, 0.0, 6.5, 5.5, 3.0, 9.5));
            case EAST -> Shapes.or(box(5.0, 0.0, 5.5, 11.0, 4.0, 10.5), box(6.5, 0.0, 4.5, 9.5, 3.0, 5.5));
            case WEST -> Shapes.or(box(5.0, 0.0, 5.5, 11.0, 4.0, 10.5), box(6.5, 0.0, 10.5, 9.5, 3.0, 11.5));
            default -> Shapes.or(box(5.5, 0.0, 5.0, 10.5, 4.0, 11.0), box(10.5, 0.0, 6.5, 11.5, 3.0, 9.5));
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.5, 0.0, 5.0, 10.5, 4.0, 11.0);
            case EAST -> box(5.0, 0.0, 5.5, 11.0, 4.0, 10.5);
            case WEST -> box(5.0, 0.0, 5.5, 11.0, 4.0, 10.5);
            default -> box(5.5, 0.0, 5.0, 10.5, 4.0, 11.0);
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(10.5, 0.0, 6.0, 12.5, 3.0, 10.0),
               new VoxelShape[]{box(5.5, 0.0, 5.0, 10.5, 4.0, 11.0), box(4.5, 0.0, 6.5, 5.5, 3.0, 9.5), box(3.5, 0.0, 7.5, 4.5, 2.0, 8.5)}
            );
            case EAST -> Shapes.or(
               box(6.0, 0.0, 10.5, 10.0, 3.0, 12.5),
               new VoxelShape[]{box(5.0, 0.0, 5.5, 11.0, 4.0, 10.5), box(6.5, 0.0, 4.5, 9.5, 3.0, 5.5), box(7.5, 0.0, 3.5, 8.5, 2.0, 4.5)}
            );
            case WEST -> Shapes.or(
               box(6.0, 0.0, 3.5, 10.0, 3.0, 5.5),
               new VoxelShape[]{box(5.0, 0.0, 5.5, 11.0, 4.0, 10.5), box(6.5, 0.0, 10.5, 9.5, 3.0, 11.5), box(7.5, 0.0, 11.5, 8.5, 2.0, 12.5)}
            );
            default -> Shapes.or(
               box(3.5, 0.0, 6.0, 5.5, 3.0, 10.0),
               new VoxelShape[]{box(5.5, 0.0, 5.0, 10.5, 4.0, 11.0), box(10.5, 0.0, 6.5, 11.5, 3.0, 9.5), box(11.5, 0.0, 7.5, 12.5, 2.0, 8.5)}
            );
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
