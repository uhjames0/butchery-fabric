package net.mcreator.butchery.block;

import net.mcreator.butchery.procedures.PlasticsheetcornerOnTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PlasticsheetcornerBlock extends Block {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);
   public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

   public PlasticsheetcornerBlock(Properties properties) {
      super(properties.strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            return s.getValue(PlasticsheetcornerBlock.BLOCKSTATE) == 1 ? 0 : 0;
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
         case NORTH -> Shapes.or(box(0.0, 0.0, 15.0, 15.0, 16.0, 16.0), box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0));
         case EAST -> Shapes.or(box(0.0, 0.0, 0.0, 1.0, 16.0, 15.0), box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0));
         case WEST -> Shapes.or(box(15.0, 0.0, 1.0, 16.0, 16.0, 16.0), box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0));
         default -> Shapes.or(box(1.0, 0.0, 0.0, 16.0, 16.0, 1.0), box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0));
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
      PlasticsheetcornerOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
      world.scheduleTick(pos, this, 1);
   }
}
