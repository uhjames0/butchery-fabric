package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.DrainedColdChickenCarcassBlockEntity;
import net.mcreator.butchery.procedures.Drained_carcass_placedProcedure;
import net.mcreator.butchery.procedures.DrainedchickencarcassbrokenProcedure;
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

public class DrainedColdChickenCarcassBlock extends Block implements EntityBlock, DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 8);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public DrainedColdChickenCarcassBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(DrainedColdChickenCarcassBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(DrainedColdChickenCarcassBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(DrainedColdChickenCarcassBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(DrainedColdChickenCarcassBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(DrainedColdChickenCarcassBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(DrainedColdChickenCarcassBlock.BLOCKSTATE) == 6) {
               return 0;
            } else if ((Integer)s.getValue(DrainedColdChickenCarcassBlock.BLOCKSTATE) == 7) {
               return 0;
            } else {
               return s.getValue(DrainedColdChickenCarcassBlock.BLOCKSTATE) == 8 ? 0 : 0;
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
            case NORTH -> box(5.0, 6.64605, 6.64605, 11.0, 14.64605, 12.64605);
            case EAST -> box(3.35395, 6.64605, 5.0, 9.35395, 14.64605, 11.0);
            case WEST -> box(6.64605, 6.64605, 5.0, 12.64605, 14.64605, 11.0);
            default -> box(5.0, 6.64605, 3.35395, 11.0, 14.64605, 9.35395);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.0, 6.64605, 6.64605, 11.0, 14.64605, 12.64605);
            case EAST -> box(3.35395, 6.64605, 5.0, 9.35395, 14.64605, 11.0);
            case WEST -> box(6.64605, 6.64605, 5.0, 12.64605, 14.64605, 11.0);
            default -> box(5.0, 6.64605, 3.35395, 11.0, 14.64605, 9.35395);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.0, 6.64605, 6.64605, 11.0, 14.64605, 12.64605);
            case EAST -> box(3.35395, 6.64605, 5.0, 9.35395, 14.64605, 11.0);
            case WEST -> box(6.64605, 6.64605, 5.0, 12.64605, 14.64605, 11.0);
            default -> box(5.0, 6.64605, 3.35395, 11.0, 14.64605, 9.35395);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 4) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.0, 6.64605, 6.64605, 11.0, 14.64605, 12.64605);
            case EAST -> box(3.35395, 6.64605, 5.0, 9.35395, 14.64605, 11.0);
            case WEST -> box(6.64605, 6.64605, 5.0, 12.64605, 14.64605, 11.0);
            default -> box(5.0, 6.64605, 3.35395, 11.0, 14.64605, 9.35395);
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(5.0, 0.0, 2.0, 11.0, 6.0, 10.0);
            case EAST -> box(6.0, 0.0, 5.0, 14.0, 6.0, 11.0);
            case WEST -> box(2.0, 0.0, 5.0, 10.0, 6.0, 11.0);
            default -> box(5.0, 0.0, 6.0, 11.0, 6.0, 14.0);
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
      DrainedchickencarcassbrokenProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
      return retval;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new DrainedColdChickenCarcassBlockEntity(pos, state);
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
      return world.getBlockEntity(pos) instanceof DrainedColdChickenCarcassBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
