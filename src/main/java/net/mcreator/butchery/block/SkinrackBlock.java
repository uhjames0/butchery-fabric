package net.mcreator.butchery.block;

import net.mcreator.butchery.block.entity.SkinrackBlockEntity;
import net.mcreator.butchery.procedures.PlaceskinonrackProcedure;
import net.mcreator.butchery.procedures.VariantSkinrackProcedure;
import net.mcreator.butchery.procedures.SkinrackOnTickUpdateProcedure;
import net.mcreator.butchery.procedures.SkinrackbrokenProcedure;
import net.mcreator.butchery.shim.ButcheryBlockHooks.DestroyHook;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SkinrackBlock extends Block implements EntityBlock, DestroyHook {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 50);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public SkinrackBlock(Properties properties) {
      super(properties.sound(SoundType.WOOD).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 6) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 7) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 8) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 9) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 10) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 11) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 12) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 13) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 14) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 15) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 16) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 17) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 18) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 19) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 20) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 21) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 22) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 23) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 24) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 25) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 26) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 27) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 28) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 29) {
               return 0;
            } else if ((Integer)s.getValue(SkinrackBlock.BLOCKSTATE) == 30) {
               return 0;
            } else {
               return s.getValue(SkinrackBlock.BLOCKSTATE) == 31 ? 0 : 0;
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
         case NORTH -> Shapes.or(
            box(-0.4998, 0.0, 1.1, 16.5004, 5.0, 14.6),
            new VoxelShape[]{box(-0.4998, 5.0, 3.1, 16.5004, 10.0, 12.6), box(-0.4998, 10.0, 5.1, 16.5004, 15.0, 10.6)}
         );
         case EAST -> Shapes.or(
            box(1.4, 0.0, -0.4998, 14.9, 5.0, 16.5004),
            new VoxelShape[]{box(3.4, 5.0, -0.4998, 12.9, 10.0, 16.5004), box(5.4, 10.0, -0.4998, 10.9, 15.0, 16.5004)}
         );
         case WEST -> Shapes.or(
            box(1.1, 0.0, -0.5004, 14.6, 5.0, 16.4998),
            new VoxelShape[]{box(3.1, 5.0, -0.5004, 12.6, 10.0, 16.4998), box(5.1, 10.0, -0.5004, 10.6, 15.0, 16.4998)}
         );
         default -> Shapes.or(
            box(-0.5004, 0.0, 1.4, 16.4998, 5.0, 14.9),
            new VoxelShape[]{box(-0.5004, 5.0, 3.4, 16.4998, 10.0, 12.9), box(-0.5004, 10.0, 5.4, 16.4998, 15.0, 10.9)}
         );
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

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      world.scheduleTick(pos, this, 1);
   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      SkinrackOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
      world.scheduleTick(pos, this, 1);
   }

   public boolean butchery$onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
      boolean retval = true;
      SkinrackbrokenProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
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
      PlaceskinonrackProcedure.execute(world, x, y, z, blockstate, entity);
      VariantSkinrackProcedure.execute(world, x, y, z, entity);
      return InteractionResult.SUCCESS;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new SkinrackBlockEntity(pos, state);
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
      return world.getBlockEntity(pos) instanceof SkinrackBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }
}
