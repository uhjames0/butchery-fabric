package net.mcreator.butchery.block;

import net.mcreator.butchery.procedures.JarBlockDestroyedByPlayerProcedure;
import net.mcreator.butchery.procedures.Jar_right_clickedProcedure;
import net.mcreator.butchery.shim.ButcheryBlockHooks.DestroyHook;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JarBlock extends Block implements DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 19);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public JarBlock(Properties properties) {
      super(properties.sound(SoundType.GLASS).strength(0.3F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 6) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 7) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 8) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 9) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 10) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 11) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 12) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 13) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 14) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 15) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 16) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 17) {
               return 0;
            } else if ((Integer)s.getValue(JarBlock.BLOCKSTATE) == 18) {
               return 0;
            } else {
               return s.getValue(JarBlock.BLOCKSTATE) == 19 ? 0 : 0;
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
      return switch ((Direction)state.getValue(FACING)) {
         case NORTH -> box(4.0, 0.1, 4.0, 12.0, 9.1, 12.001);
         case EAST -> box(3.999, 0.1, 4.0, 12.0, 9.1, 12.0);
         case WEST -> box(4.0, 0.1, 4.0, 12.001, 9.1, 12.0);
         default -> box(4.0, 0.1, 3.999, 12.0, 9.1, 12.0);
      };
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
      JarBlockDestroyedByPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
      return retval;
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
      Jar_right_clickedProcedure.execute(world, x, y, z, entity);
      return InteractionResult.SUCCESS;
   }
}
