package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.CavespidercarcassBlockEntity;
import net.mcreator.butchery.procedures.CavespidercarcassbrokenProcedure;
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

public class CavespidercarcassBlock extends Block implements EntityBlock, DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 7);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public CavespidercarcassBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(CavespidercarcassBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(CavespidercarcassBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(CavespidercarcassBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(CavespidercarcassBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(CavespidercarcassBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(CavespidercarcassBlock.BLOCKSTATE) == 6) {
               return 0;
            } else {
               return s.getValue(CavespidercarcassBlock.BLOCKSTATE) == 7 ? 0 : 0;
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
               box(5.3, 20.0, 4.0, 10.8, 24.5, 8.0), new VoxelShape[]{box(5.7, 12.5, 5.2, 10.2, 19.3, 9.2), box(4.3, 5.3, 1.2, 11.8, 14.3, 10.0)}
            );
            case EAST -> Shapes.or(
               box(8.0, 20.0, 5.3, 12.0, 24.5, 10.8), new VoxelShape[]{box(6.8, 12.5, 5.7, 10.8, 19.3, 10.2), box(6.0, 5.3, 4.3, 14.8, 14.3, 11.8)}
            );
            case WEST -> Shapes.or(
               box(4.0, 20.0, 5.2, 8.0, 24.5, 10.7), new VoxelShape[]{box(5.2, 12.5, 5.8, 9.2, 19.3, 10.3), box(1.2, 5.3, 4.2, 10.0, 14.3, 11.7)}
            );
            default -> Shapes.or(
               box(5.2, 20.0, 8.0, 10.7, 24.5, 12.0), new VoxelShape[]{box(5.8, 12.5, 6.8, 10.3, 19.3, 10.8), box(4.2, 5.3, 6.0, 11.7, 14.3, 14.8)}
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(5.3, 20.0, 4.0, 10.8, 24.5, 8.0), new VoxelShape[]{box(5.7, 12.5, 5.2, 10.2, 19.3, 9.2), box(4.3, 5.3, 1.2, 11.8, 14.3, 10.0)}
            );
            case EAST -> Shapes.or(
               box(8.0, 20.0, 5.3, 12.0, 24.5, 10.8), new VoxelShape[]{box(6.8, 12.5, 5.7, 10.8, 19.3, 10.2), box(6.0, 5.3, 4.3, 14.8, 14.3, 11.8)}
            );
            case WEST -> Shapes.or(
               box(4.0, 20.0, 5.2, 8.0, 24.5, 10.7), new VoxelShape[]{box(5.2, 12.5, 5.8, 9.2, 19.3, 10.3), box(1.2, 5.3, 4.2, 10.0, 14.3, 11.7)}
            );
            default -> Shapes.or(
               box(5.2, 20.0, 8.0, 10.7, 24.5, 12.0), new VoxelShape[]{box(5.8, 12.5, 6.8, 10.3, 19.3, 10.8), box(4.2, 5.3, 6.0, 11.7, 14.3, 14.8)}
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(5.3, 20.0, 4.0, 10.8, 24.5, 8.0), new VoxelShape[]{box(5.7, 12.5, 5.2, 10.2, 19.3, 9.2), box(4.3, 5.3, 1.2, 11.8, 14.3, 10.0)}
            );
            case EAST -> Shapes.or(
               box(8.0, 20.0, 5.3, 12.0, 24.5, 10.8), new VoxelShape[]{box(6.8, 12.5, 5.7, 10.8, 19.3, 10.2), box(6.0, 5.3, 4.3, 14.8, 14.3, 11.8)}
            );
            case WEST -> Shapes.or(
               box(4.0, 20.0, 5.2, 8.0, 24.5, 10.7), new VoxelShape[]{box(5.2, 12.5, 5.8, 9.2, 19.3, 10.3), box(1.2, 5.3, 4.2, 10.0, 14.3, 11.7)}
            );
            default -> Shapes.or(
               box(5.2, 20.0, 8.0, 10.7, 24.5, 12.0), new VoxelShape[]{box(5.8, 12.5, 6.8, 10.3, 19.3, 10.8), box(4.2, 5.3, 6.0, 11.7, 14.3, 14.8)}
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 7) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(5.3, 20.0, 4.0, 10.8, 24.5, 8.0), new VoxelShape[]{box(5.7, 12.5, 5.2, 10.2, 19.3, 9.2), box(4.3, 5.3, 1.2, 11.8, 14.3, 10.0)}
            );
            case EAST -> Shapes.or(
               box(8.0, 20.0, 5.3, 12.0, 24.5, 10.8), new VoxelShape[]{box(6.8, 12.5, 5.7, 10.8, 19.3, 10.2), box(6.0, 5.3, 4.3, 14.8, 14.3, 11.8)}
            );
            case WEST -> Shapes.or(
               box(4.0, 20.0, 5.2, 8.0, 24.5, 10.7), new VoxelShape[]{box(5.2, 12.5, 5.8, 9.2, 19.3, 10.3), box(1.2, 5.3, 4.2, 10.0, 14.3, 11.7)}
            );
            default -> Shapes.or(
               box(5.2, 20.0, 8.0, 10.7, 24.5, 12.0), new VoxelShape[]{box(5.8, 12.5, 6.8, 10.3, 19.3, 10.8), box(4.2, 5.3, 6.0, 11.7, 14.3, 14.8)}
            );
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.87276, 0.075, 5.57276, 10.37276, 4.575, 10.07276);
            case EAST -> box(5.92724, 0.075, 5.87276, 10.42724, 4.575, 10.37276);
            case WEST -> box(5.57276, 0.075, 5.62724, 10.07276, 4.575, 10.12724);
            default -> box(5.62724, 0.075, 5.92724, 10.12724, 4.575, 10.42724);
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

   public boolean butchery$onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
      boolean retval = true;
      CavespidercarcassbrokenProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
      return retval;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new CavespidercarcassBlockEntity(pos, state);
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
      return world.getBlockEntity(pos) instanceof CavespidercarcassBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
