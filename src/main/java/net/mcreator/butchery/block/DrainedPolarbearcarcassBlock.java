package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.DrainedPolarbearcarcassBlockEntity;
import net.mcreator.butchery.procedures.DrainedPolarbearbrokenProcedure;
import net.mcreator.butchery.procedures.Drained_carcass_placedProcedure;
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

public class DrainedPolarbearcarcassBlock extends Block implements EntityBlock, DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 9);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public DrainedPolarbearcarcassBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(DrainedPolarbearcarcassBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(DrainedPolarbearcarcassBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(DrainedPolarbearcarcassBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(DrainedPolarbearcarcassBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(DrainedPolarbearcarcassBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(DrainedPolarbearcarcassBlock.BLOCKSTATE) == 6) {
               return 0;
            } else if ((Integer)s.getValue(DrainedPolarbearcarcassBlock.BLOCKSTATE) == 7) {
               return 0;
            } else if ((Integer)s.getValue(DrainedPolarbearcarcassBlock.BLOCKSTATE) == 8) {
               return 0;
            } else {
               return s.getValue(DrainedPolarbearcarcassBlock.BLOCKSTATE) == 9 ? 0 : 0;
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
               box(1.5, -2.9, 2.4, 14.5, 10.1, 12.4),
               new VoxelShape[]{box(2.4, 13.07183, 1.75293, 13.4, 17.57183, 8.75293), box(2.4, 10.07183, 2.75293, 13.4, 13.17183, 11.15293)}
            );
            case EAST -> Shapes.or(
               box(3.6, -2.9, 1.5, 13.6, 10.1, 14.5),
               new VoxelShape[]{box(7.24707, 13.07183, 2.4, 14.24707, 17.57183, 13.4), box(4.84707, 10.07183, 2.4, 13.24707, 13.17183, 13.4)}
            );
            case WEST -> Shapes.or(
               box(2.4, -2.9, 1.5, 12.4, 10.1, 14.5),
               new VoxelShape[]{box(1.75293, 13.07183, 2.6, 8.75293, 17.57183, 13.6), box(2.75293, 10.07183, 2.6, 11.15293, 13.17183, 13.6)}
            );
            default -> Shapes.or(
               box(1.5, -2.9, 3.6, 14.5, 10.1, 13.6),
               new VoxelShape[]{box(2.6, 13.07183, 7.24707, 13.6, 17.57183, 14.24707), box(2.6, 10.07183, 4.84707, 13.6, 13.17183, 13.24707)}
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(1.5, -2.9, 2.4, 14.5, 10.1, 12.4),
               new VoxelShape[]{box(2.4, 13.07183, 1.75293, 13.4, 17.57183, 8.75293), box(2.4, 10.07183, 2.75293, 13.4, 13.17183, 11.15293)}
            );
            case EAST -> Shapes.or(
               box(3.6, -2.9, 1.5, 13.6, 10.1, 14.5),
               new VoxelShape[]{box(7.24707, 13.07183, 2.4, 14.24707, 17.57183, 13.4), box(4.84707, 10.07183, 2.4, 13.24707, 13.17183, 13.4)}
            );
            case WEST -> Shapes.or(
               box(2.4, -2.9, 1.5, 12.4, 10.1, 14.5),
               new VoxelShape[]{box(1.75293, 13.07183, 2.6, 8.75293, 17.57183, 13.6), box(2.75293, 10.07183, 2.6, 11.15293, 13.17183, 13.6)}
            );
            default -> Shapes.or(
               box(1.5, -2.9, 3.6, 14.5, 10.1, 13.6),
               new VoxelShape[]{box(2.6, 13.07183, 7.24707, 13.6, 17.57183, 14.24707), box(2.6, 10.07183, 4.84707, 13.6, 13.17183, 13.24707)}
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(1.5, -2.9, 2.4, 14.5, 10.1, 12.4),
               new VoxelShape[]{box(2.4, 13.07183, 1.75293, 13.4, 17.57183, 8.75293), box(2.4, 10.07183, 2.75293, 13.4, 13.17183, 11.15293)}
            );
            case EAST -> Shapes.or(
               box(3.6, -2.9, 1.5, 13.6, 10.1, 14.5),
               new VoxelShape[]{box(7.24707, 13.07183, 2.4, 14.24707, 17.57183, 13.4), box(4.84707, 10.07183, 2.4, 13.24707, 13.17183, 13.4)}
            );
            case WEST -> Shapes.or(
               box(2.4, -2.9, 1.5, 12.4, 10.1, 14.5),
               new VoxelShape[]{box(1.75293, 13.07183, 2.6, 8.75293, 17.57183, 13.6), box(2.75293, 10.07183, 2.6, 11.15293, 13.17183, 13.6)}
            );
            default -> Shapes.or(
               box(1.5, -2.9, 3.6, 14.5, 10.1, 13.6),
               new VoxelShape[]{box(2.6, 13.07183, 7.24707, 13.6, 17.57183, 14.24707), box(2.6, 10.07183, 4.84707, 13.6, 13.17183, 13.24707)}
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 4) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(1.5, -2.9, 2.4, 14.5, 10.1, 12.4),
               new VoxelShape[]{box(2.4, 13.07183, 1.75293, 13.4, 17.57183, 8.75293), box(2.4, 10.07183, 2.75293, 13.4, 13.17183, 11.15293)}
            );
            case EAST -> Shapes.or(
               box(3.6, -2.9, 1.5, 13.6, 10.1, 14.5),
               new VoxelShape[]{box(7.24707, 13.07183, 2.4, 14.24707, 17.57183, 13.4), box(4.84707, 10.07183, 2.4, 13.24707, 13.17183, 13.4)}
            );
            case WEST -> Shapes.or(
               box(2.4, -2.9, 1.5, 12.4, 10.1, 14.5),
               new VoxelShape[]{box(1.75293, 13.07183, 2.6, 8.75293, 17.57183, 13.6), box(2.75293, 10.07183, 2.6, 11.15293, 13.17183, 13.6)}
            );
            default -> Shapes.or(
               box(1.5, -2.9, 3.6, 14.5, 10.1, 13.6),
               new VoxelShape[]{box(2.6, 13.07183, 7.24707, 13.6, 17.57183, 14.24707), box(2.6, 10.07183, 4.84707, 13.6, 13.17183, 13.24707)}
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 5) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(1.5, -2.9, 2.4, 14.5, 10.1, 12.4),
               new VoxelShape[]{box(2.4, 13.07183, 1.75293, 13.4, 17.57183, 8.75293), box(2.4, 10.07183, 2.75293, 13.4, 13.17183, 11.15293)}
            );
            case EAST -> Shapes.or(
               box(3.6, -2.9, 1.5, 13.6, 10.1, 14.5),
               new VoxelShape[]{box(7.24707, 13.07183, 2.4, 14.24707, 17.57183, 13.4), box(4.84707, 10.07183, 2.4, 13.24707, 13.17183, 13.4)}
            );
            case WEST -> Shapes.or(
               box(2.4, -2.9, 1.5, 12.4, 10.1, 14.5),
               new VoxelShape[]{box(1.75293, 13.07183, 2.6, 8.75293, 17.57183, 13.6), box(2.75293, 10.07183, 2.6, 11.15293, 13.17183, 13.6)}
            );
            default -> Shapes.or(
               box(1.5, -2.9, 3.6, 14.5, 10.1, 13.6),
               new VoxelShape[]{box(2.6, 13.07183, 7.24707, 13.6, 17.57183, 14.24707), box(2.6, 10.07183, 4.84707, 13.6, 13.17183, 13.24707)}
            );
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(1.4, 0.3, 5.5, 14.4, 13.3, 15.5), box(2.4, 13.3, 5.5, 13.4, 21.3, 12.5));
            case EAST -> Shapes.or(box(0.5, 0.3, 1.4, 10.5, 13.3, 14.4), box(3.5, 13.3, 2.4, 10.5, 21.3, 13.4));
            case WEST -> Shapes.or(box(5.5, 0.3, 1.6, 15.5, 13.3, 14.6), box(5.5, 13.3, 2.6, 12.5, 21.3, 13.6));
            default -> Shapes.or(box(1.6, 0.3, 0.5, 14.6, 13.3, 10.5), box(2.6, 13.3, 3.5, 13.6, 21.3, 10.5));
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
      DrainedPolarbearbrokenProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
      return retval;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new DrainedPolarbearcarcassBlockEntity(pos, state);
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
      return world.getBlockEntity(pos) instanceof DrainedPolarbearcarcassBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
