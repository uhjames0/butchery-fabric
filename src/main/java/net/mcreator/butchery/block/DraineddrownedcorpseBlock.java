package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.DraineddrownedcorpseBlockEntity;
import net.mcreator.butchery.procedures.Drained_carcass_placedProcedure;
import net.mcreator.butchery.procedures.DrownedcarcassbrokenProcedure;
import net.mcreator.butchery.shim.ButcheryBlockHooks.DestroyHook;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DraineddrownedcorpseBlock extends Block implements EntityBlock, DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 7);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public DraineddrownedcorpseBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(DraineddrownedcorpseBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(DraineddrownedcorpseBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(DraineddrownedcorpseBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(DraineddrownedcorpseBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(DraineddrownedcorpseBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(DraineddrownedcorpseBlock.BLOCKSTATE) == 6) {
               return 0;
            } else {
               return s.getValue(DraineddrownedcorpseBlock.BLOCKSTATE) == 7 ? 0 : 0;
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
            case NORTH -> Shapes.or(
               box(3.9, 8.0, 5.0, 11.9, 20.0, 9.0),
               new VoxelShape[]{
                  box(-0.09316, 7.90942, 4.93632, 3.90684, 19.90942, 8.93632),
                  box(11.90684, 8.09058, 5.06368, 15.90684, 20.09058, 9.06368),
                  box(3.90567, -4.0, 4.99206, 7.90567, 8.0, 8.99206),
                  box(7.90932, -3.99464, 5.0, 11.90932, 8.00536, 9.0)
               }
            );
            case EAST -> Shapes.or(
               box(7.0, 8.0, 3.9, 11.0, 20.0, 11.9),
               new VoxelShape[]{
                  box(7.06368, 7.90942, -0.09316, 11.06368, 19.90942, 3.90684),
                  box(6.93632, 8.09058, 11.90684, 10.93632, 20.09058, 15.90684),
                  box(7.00794, -4.0, 3.90567, 11.00794, 8.0, 7.90567),
                  box(7.0, -3.99464, 7.90932, 11.0, 8.00536, 11.90932)
               }
            );
            case WEST -> Shapes.or(
               box(5.0, 8.0, 4.1, 9.0, 20.0, 12.1),
               new VoxelShape[]{
                  box(4.93632, 7.90942, 12.09316, 8.93632, 19.90942, 16.09316),
                  box(5.06368, 8.09058, 0.09316, 9.06368, 20.09058, 4.09316),
                  box(4.99206, -4.0, 8.09433, 8.99206, 8.0, 12.09433),
                  box(5.0, -3.99464, 4.09068, 9.0, 8.00536, 8.09068)
               }
            );
            default -> Shapes.or(
               box(4.1, 8.0, 7.0, 12.1, 20.0, 11.0),
               new VoxelShape[]{
                  box(12.09316, 7.90942, 7.06368, 16.09316, 19.90942, 11.06368),
                  box(0.09316, 8.09058, 6.93632, 4.09316, 20.09058, 10.93632),
                  box(8.09433, -4.0, 7.00794, 12.09433, 8.0, 11.00794),
                  box(4.09068, -3.99464, 7.0, 8.09068, 8.00536, 11.0)
               }
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(3.9, 8.0, 5.0, 11.9, 20.0, 9.0),
               new VoxelShape[]{
                  box(-0.09316, 7.90942, 4.93632, 3.90684, 19.90942, 8.93632),
                  box(11.90684, 8.09058, 5.06368, 15.90684, 20.09058, 9.06368),
                  box(3.90567, -4.0, 4.99206, 7.90567, 8.0, 8.99206),
                  box(7.90932, -3.99464, 5.0, 11.90932, 8.00536, 9.0)
               }
            );
            case EAST -> Shapes.or(
               box(7.0, 8.0, 3.9, 11.0, 20.0, 11.9),
               new VoxelShape[]{
                  box(7.06368, 7.90942, -0.09316, 11.06368, 19.90942, 3.90684),
                  box(6.93632, 8.09058, 11.90684, 10.93632, 20.09058, 15.90684),
                  box(7.00794, -4.0, 3.90567, 11.00794, 8.0, 7.90567),
                  box(7.0, -3.99464, 7.90932, 11.0, 8.00536, 11.90932)
               }
            );
            case WEST -> Shapes.or(
               box(5.0, 8.0, 4.1, 9.0, 20.0, 12.1),
               new VoxelShape[]{
                  box(4.93632, 7.90942, 12.09316, 8.93632, 19.90942, 16.09316),
                  box(5.06368, 8.09058, 0.09316, 9.06368, 20.09058, 4.09316),
                  box(4.99206, -4.0, 8.09433, 8.99206, 8.0, 12.09433),
                  box(5.0, -3.99464, 4.09068, 9.0, 8.00536, 8.09068)
               }
            );
            default -> Shapes.or(
               box(4.1, 8.0, 7.0, 12.1, 20.0, 11.0),
               new VoxelShape[]{
                  box(12.09316, 7.90942, 7.06368, 16.09316, 19.90942, 11.06368),
                  box(0.09316, 8.09058, 6.93632, 4.09316, 20.09058, 10.93632),
                  box(8.09433, -4.0, 7.00794, 12.09433, 8.0, 11.00794),
                  box(4.09068, -3.99464, 7.0, 8.09068, 8.00536, 11.0)
               }
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(3.9, 8.0, 5.0, 11.9, 20.0, 9.0),
               new VoxelShape[]{
                  box(-0.09316, 7.90942, 4.93632, 3.90684, 19.90942, 8.93632),
                  box(11.90684, 8.09058, 5.06368, 15.90684, 20.09058, 9.06368),
                  box(3.90567, -4.0, 4.99206, 7.90567, 8.0, 8.99206),
                  box(7.90932, -3.99464, 5.0, 11.90932, 8.00536, 9.0)
               }
            );
            case EAST -> Shapes.or(
               box(7.0, 8.0, 3.9, 11.0, 20.0, 11.9),
               new VoxelShape[]{
                  box(7.06368, 7.90942, -0.09316, 11.06368, 19.90942, 3.90684),
                  box(6.93632, 8.09058, 11.90684, 10.93632, 20.09058, 15.90684),
                  box(7.00794, -4.0, 3.90567, 11.00794, 8.0, 7.90567),
                  box(7.0, -3.99464, 7.90932, 11.0, 8.00536, 11.90932)
               }
            );
            case WEST -> Shapes.or(
               box(5.0, 8.0, 4.1, 9.0, 20.0, 12.1),
               new VoxelShape[]{
                  box(4.93632, 7.90942, 12.09316, 8.93632, 19.90942, 16.09316),
                  box(5.06368, 8.09058, 0.09316, 9.06368, 20.09058, 4.09316),
                  box(4.99206, -4.0, 8.09433, 8.99206, 8.0, 12.09433),
                  box(5.0, -3.99464, 4.09068, 9.0, 8.00536, 8.09068)
               }
            );
            default -> Shapes.or(
               box(4.1, 8.0, 7.0, 12.1, 20.0, 11.0),
               new VoxelShape[]{
                  box(12.09316, 7.90942, 7.06368, 16.09316, 19.90942, 11.06368),
                  box(0.09316, 8.09058, 6.93632, 4.09316, 20.09058, 10.93632),
                  box(8.09433, -4.0, 7.00794, 12.09433, 8.0, 11.00794),
                  box(4.09068, -3.99464, 7.0, 8.09068, 8.00536, 11.0)
               }
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 4) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(3.9, 8.0, 5.0, 11.9, 20.0, 9.0),
               new VoxelShape[]{
                  box(-0.09316, 7.90942, 4.93632, 3.90684, 19.90942, 8.93632),
                  box(11.90684, 8.09058, 5.06368, 15.90684, 20.09058, 9.06368),
                  box(3.90567, -4.0, 4.99206, 7.90567, 8.0, 8.99206),
                  box(7.90932, -3.99464, 5.0, 11.90932, 8.00536, 9.0)
               }
            );
            case EAST -> Shapes.or(
               box(7.0, 8.0, 3.9, 11.0, 20.0, 11.9),
               new VoxelShape[]{
                  box(7.06368, 7.90942, -0.09316, 11.06368, 19.90942, 3.90684),
                  box(6.93632, 8.09058, 11.90684, 10.93632, 20.09058, 15.90684),
                  box(7.00794, -4.0, 3.90567, 11.00794, 8.0, 7.90567),
                  box(7.0, -3.99464, 7.90932, 11.0, 8.00536, 11.90932)
               }
            );
            case WEST -> Shapes.or(
               box(5.0, 8.0, 4.1, 9.0, 20.0, 12.1),
               new VoxelShape[]{
                  box(4.93632, 7.90942, 12.09316, 8.93632, 19.90942, 16.09316),
                  box(5.06368, 8.09058, 0.09316, 9.06368, 20.09058, 4.09316),
                  box(4.99206, -4.0, 8.09433, 8.99206, 8.0, 12.09433),
                  box(5.0, -3.99464, 4.09068, 9.0, 8.00536, 8.09068)
               }
            );
            default -> Shapes.or(
               box(4.1, 8.0, 7.0, 12.1, 20.0, 11.0),
               new VoxelShape[]{
                  box(12.09316, 7.90942, 7.06368, 16.09316, 19.90942, 11.06368),
                  box(0.09316, 8.09058, 6.93632, 4.09316, 20.09058, 10.93632),
                  box(8.09433, -4.0, 7.00794, 12.09433, 8.0, 11.00794),
                  box(4.09068, -3.99464, 7.0, 8.09068, 8.00536, 11.0)
               }
            );
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(3.9, 4.0, 10.0, 11.9, 16.0, 14.0);
            case EAST -> box(2.0, 4.0, 3.9, 6.0, 16.0, 11.9);
            case WEST -> box(10.0, 4.0, 4.1, 14.0, 16.0, 12.1);
            default -> box(4.1, 4.0, 2.0, 12.1, 16.0, 6.0);
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

   public boolean butchery$onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
      boolean retval = true;
      DrownedcarcassbrokenProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
      return retval;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new DraineddrownedcorpseBlockEntity(pos, state);
   }

   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
   }

   protected void affectNeighborsAfterRemoval(BlockState blockstate, ServerLevel world, BlockPos blockpos, boolean flag) {
      Containers.updateNeighboursAfterDestroy(blockstate, world, blockpos);
   }

   public boolean hasAnalogOutputSignal(BlockState state) {
      return true;
   }

   public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
      return world.getBlockEntity(pos) instanceof DraineddrownedcorpseBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
