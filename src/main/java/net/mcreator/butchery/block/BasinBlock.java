package net.mcreator.butchery.block;

import net.mcreator.butchery.ClientEnvHooks;
import net.mcreator.butchery.block.entity.BasinBlockEntity;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.procedures.BasinupdatetickProcedure;
import net.mcreator.butchery.procedures.FillsaltbasinProcedure;
import net.mcreator.butchery.procedures.RemovewaterbesideProcedure;
import net.mcreator.butchery.shim.events.RegisterBlockColorShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BasinBlock extends Block implements EntityBlock {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 7);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public BasinBlock(Properties properties) {
      super(properties.strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(BasinBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(BasinBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(BasinBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(BasinBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(BasinBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(BasinBlock.BLOCKSTATE) == 6) {
               return 0;
            } else {
               return s.getValue(BasinBlock.BLOCKSTATE) == 7 ? 0 : 0;
            }
         }
      }).getLightLevel()).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASEDRUM));
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
               box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case EAST -> Shapes.or(
               box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case WEST -> Shapes.or(
               box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            default -> Shapes.or(
               box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case EAST -> Shapes.or(
               box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case WEST -> Shapes.or(
               box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            default -> Shapes.or(
               box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case EAST -> Shapes.or(
               box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case WEST -> Shapes.or(
               box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            default -> Shapes.or(
               box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 4) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case EAST -> Shapes.or(
               box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case WEST -> Shapes.or(
               box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            default -> Shapes.or(
               box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 5) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case EAST -> Shapes.or(
               box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case WEST -> Shapes.or(
               box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            default -> Shapes.or(
               box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 6) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case EAST -> Shapes.or(
               box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case WEST -> Shapes.or(
               box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            default -> Shapes.or(
               box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
         };
      } else if ((Integer)state.getValue(BLOCKSTATE) == 7) {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case EAST -> Shapes.or(
               box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case WEST -> Shapes.or(
               box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            default -> Shapes.or(
               box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
         };
      } else {
         return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
               box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case EAST -> Shapes.or(
               box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            case WEST -> Shapes.or(
               box(0.0, 3.0, 14.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 16.0, 12.0, 2.0),
                  box(0.0, 3.0, 2.0, 2.0, 12.0, 14.0),
                  box(14.0, 3.0, 2.0, 16.0, 12.0, 14.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
            );
            default -> Shapes.or(
               box(14.0, 3.0, 0.0, 16.0, 12.0, 16.0),
               new VoxelShape[]{
                  box(2.0, 3.0, 2.0, 14.0, 4.0, 14.0),
                  box(0.0, 3.0, 0.0, 2.0, 12.0, 16.0),
                  box(2.0, 3.0, 14.0, 14.0, 12.0, 16.0),
                  box(2.0, 3.0, 0.0, 14.0, 12.0, 2.0),
                  box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)
               }
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

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      world.scheduleTick(pos, this, 1);
   }

   public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
      super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
      RemovewaterbesideProcedure.execute();
   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      BasinupdatetickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
      world.scheduleTick(pos, this, 1);
   }

   public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
      super.setPlacedBy(world, pos, blockstate, entity, itemstack);
      RemovewaterbesideProcedure.execute();
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
      FillsaltbasinProcedure.execute(world, x, y, z, entity);
      return InteractionResult.SUCCESS;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new BasinBlockEntity(pos, state);
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
      return world.getBlockEntity(pos) instanceof BasinBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
   }

   public static void blockColorLoad(RegisterBlockColorShim event) {
      event.register((bs, world, pos, index) -> ClientEnvHooks.basinWaterColor(bs, world, pos, index), new Block[]{(Block)ButcheryModBlocks.BASIN.get()});
   }
}
