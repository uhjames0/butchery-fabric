package net.mcreator.butchery.block;

import net.mcreator.butchery.procedures.Hook_Block_DestroyedProcedure;
import net.mcreator.butchery.shim.ButcheryBlockHooks.DestroyHook;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HookBlock extends Block implements DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 2);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public HookBlock(Properties properties) {
      super(properties.sound(SoundType.CHAIN).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(HookBlock.BLOCKSTATE) == 1) {
               return 0;
            } else {
               return s.getValue(HookBlock.BLOCKSTATE) == 2 ? 0 : 0;
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
            case NORTH -> box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
            case EAST -> box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
            case WEST -> box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
            default -> box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(4.0, 8.0, 5.0, 12.0, 16.0, 16.0), box(4.0, 0.0, 5.0, 12.0, 8.0, 11.0));
            case EAST -> Shapes.or(box(0.0, 8.0, 4.0, 11.0, 16.0, 12.0), box(5.0, 0.0, 4.0, 11.0, 8.0, 12.0));
            case WEST -> Shapes.or(box(5.0, 8.0, 4.0, 16.0, 16.0, 12.0), box(5.0, 0.0, 4.0, 11.0, 8.0, 12.0));
            default -> Shapes.or(box(4.0, 8.0, 0.0, 12.0, 16.0, 11.0), box(4.0, 0.0, 5.0, 12.0, 8.0, 11.0));
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(box(0.0, 7.0, 7.0, 16.0, 9.0, 9.0), box(5.5, 0.0, 5.0, 10.5, 10.0, 11.0));
            case EAST -> Shapes.or(box(7.0, 7.0, 0.0, 9.0, 9.0, 16.0), box(5.0, 0.0, 5.5, 11.0, 10.0, 10.5));
            case WEST -> Shapes.or(box(7.0, 7.0, 0.0, 9.0, 9.0, 16.0), box(5.0, 0.0, 5.5, 11.0, 10.0, 10.5));
            default -> Shapes.or(box(0.0, 7.0, 7.0, 16.0, 9.0, 9.0), box(5.5, 0.0, 5.0, 10.5, 10.0, 11.0));
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
      Hook_Block_DestroyedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
      return retval;
   }
}
