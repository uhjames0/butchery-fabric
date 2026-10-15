package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.DrainedGrayllamacarcassBlockEntity;
import net.mcreator.butchery.procedures.Drained_carcass_placedProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DrainedGrayllamacarcassBlock extends Block implements EntityBlock {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 9);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public DrainedGrayllamacarcassBlock(Properties properties) {
      super(properties.sound(SoundType.HONEY_BLOCK).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(DrainedGrayllamacarcassBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGrayllamacarcassBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGrayllamacarcassBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGrayllamacarcassBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGrayllamacarcassBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGrayllamacarcassBlock.BLOCKSTATE) == 6) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGrayllamacarcassBlock.BLOCKSTATE) == 7) {
               return 0;
            } else if ((Integer)s.getValue(DrainedGrayllamacarcassBlock.BLOCKSTATE) == 8) {
               return 0;
            } else {
               return s.getValue(DrainedGrayllamacarcassBlock.BLOCKSTATE) == 9 ? 0 : 0;
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
            case NORTH -> box(1.6325, -3.10669, 8.73919, 13.6325, 14.89331, 18.73919);
            case EAST -> box(-2.73919, -3.10669, 1.6325, 7.26081, 14.89331, 13.6325);
            case WEST -> box(8.73919, -3.10669, 2.3675, 18.73919, 14.89331, 14.3675);
            default -> box(2.3675, -3.10669, -2.73919, 14.3675, 14.89331, 7.26081);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(1.6325, -3.10669, 8.73919, 13.6325, 14.89331, 18.73919);
            case EAST -> box(-2.73919, -3.10669, 1.6325, 7.26081, 14.89331, 13.6325);
            case WEST -> box(8.73919, -3.10669, 2.3675, 18.73919, 14.89331, 14.3675);
            default -> box(2.3675, -3.10669, -2.73919, 14.3675, 14.89331, 7.26081);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(1.6325, -3.10669, 8.73919, 13.6325, 14.89331, 18.73919);
            case EAST -> box(-2.73919, -3.10669, 1.6325, 7.26081, 14.89331, 13.6325);
            case WEST -> box(8.73919, -3.10669, 2.3675, 18.73919, 14.89331, 14.3675);
            default -> box(2.3675, -3.10669, -2.73919, 14.3675, 14.89331, 7.26081);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 4) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(1.6325, -3.10669, 8.73919, 13.6325, 14.89331, 18.73919);
            case EAST -> box(-2.73919, -3.10669, 1.6325, 7.26081, 14.89331, 13.6325);
            case WEST -> box(8.73919, -3.10669, 2.3675, 18.73919, 14.89331, 14.3675);
            default -> box(2.3675, -3.10669, -2.73919, 14.3675, 14.89331, 7.26081);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 5) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(1.6325, -3.10669, 8.73919, 13.6325, 14.89331, 18.73919);
            case EAST -> box(-2.73919, -3.10669, 1.6325, 7.26081, 14.89331, 13.6325);
            case WEST -> box(8.73919, -3.10669, 2.3675, 18.73919, 14.89331, 14.3675);
            default -> box(2.3675, -3.10669, -2.73919, 14.3675, 14.89331, 7.26081);
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> box(-0.35637, 0.2, 3.64363, 17.04363, 11.8, 14.14363);
            case EAST -> box(1.85637, 0.2, -0.35637, 12.35637, 11.8, 17.04363);
            case WEST -> box(3.64363, 0.2, -1.04363, 14.14363, 11.8, 16.35637);
            default -> box(-1.04363, 0.2, 1.85637, 16.35637, 11.8, 12.35637);
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

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new DrainedGrayllamacarcassBlockEntity(pos, state);
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
      return world.getBlockEntity(pos) instanceof DrainedGrayllamacarcassBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
