package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.DrainedGraySheepCarcassBlockEntity;
import net.mcreator.butchery.procedures.Drained_carcass_placedProcedure;
import net.mcreator.butchery.procedures.DrainedsheepcarcassbrokenProcedure;
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

public class DrainedGraySheepCarcassBlock extends Block implements EntityBlock, DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 9);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public DrainedGraySheepCarcassBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(DrainedGraySheepCarcassBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGraySheepCarcassBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGraySheepCarcassBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGraySheepCarcassBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGraySheepCarcassBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGraySheepCarcassBlock.BLOCKSTATE) == 6) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGraySheepCarcassBlock.BLOCKSTATE) == 7) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGraySheepCarcassBlock.BLOCKSTATE) == 8) {
               return 0;
            } else {
               return s.getValue(DrainedGraySheepCarcassBlock.BLOCKSTATE) == 9 ? 0 : 0;
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
            case NORTH -> box(3.02277, -1.02911, 0.79255, 12.82277, 14.77089, 8.59255);
            case EAST -> box(7.40745, -1.02911, 3.02277, 15.20745, 14.77089, 12.82277);
            case WEST -> box(0.79255, -1.02911, 3.17723, 8.59255, 14.77089, 12.97723);
            default -> box(3.17723, -1.02911, 7.40745, 12.97723, 14.77089, 15.20745);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(3.02277, -1.02911, 0.79255, 12.82277, 14.77089, 8.59255);
            case EAST -> box(7.40745, -1.02911, 3.02277, 15.20745, 14.77089, 12.82277);
            case WEST -> box(0.79255, -1.02911, 3.17723, 8.59255, 14.77089, 12.97723);
            default -> box(3.17723, -1.02911, 7.40745, 12.97723, 14.77089, 15.20745);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(3.02277, -1.02911, 0.79255, 12.82277, 14.77089, 8.59255);
            case EAST -> box(7.40745, -1.02911, 3.02277, 15.20745, 14.77089, 12.82277);
            case WEST -> box(0.79255, -1.02911, 3.17723, 8.59255, 14.77089, 12.97723);
            default -> box(3.17723, -1.02911, 7.40745, 12.97723, 14.77089, 15.20745);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 4) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(3.02277, -1.02911, 0.79255, 12.82277, 14.77089, 8.59255);
            case EAST -> box(7.40745, -1.02911, 3.02277, 15.20745, 14.77089, 12.82277);
            case WEST -> box(0.79255, -1.02911, 3.17723, 8.59255, 14.77089, 12.97723);
            default -> box(3.17723, -1.02911, 7.40745, 12.97723, 14.77089, 15.20745);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 5) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(3.02277, -1.02911, 0.79255, 12.82277, 14.77089, 8.59255);
            case EAST -> box(7.40745, -1.02911, 3.02277, 15.20745, 14.77089, 12.82277);
            case WEST -> box(0.79255, -1.02911, 3.17723, 8.59255, 14.77089, 12.97723);
            default -> box(3.17723, -1.02911, 7.40745, 12.97723, 14.77089, 15.20745);
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(0.1527, 0.10082, 5.00518, 15.9527, 9.90082, 12.80518);
            case EAST -> box(3.19482, 0.10082, 0.1527, 10.99482, 9.90082, 15.9527);
            case WEST -> box(5.00518, 0.10082, 0.0473, 12.80518, 9.90082, 15.8473);
            default -> box(0.0473, 0.10082, 3.19482, 15.8473, 9.90082, 10.99482);
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
      DrainedsheepcarcassbrokenProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
      return retval;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new DrainedGraySheepCarcassBlockEntity(pos, state);
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
      return world.getBlockEntity(pos) instanceof DrainedGraySheepCarcassBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
