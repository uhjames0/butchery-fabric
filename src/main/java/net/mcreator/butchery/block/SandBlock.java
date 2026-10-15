package net.mcreator.butchery.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SandBlock extends Block {
   public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 14);

   public SandBlock(Properties properties) {
      super(properties.sound(SoundType.SAND).strength(1.0F, 10.0F).lightLevel(s -> (new Object() {
         public int getLightLevel() {
            if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 1) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 2) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 3) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 4) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 5) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 6) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 7) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 8) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 9) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 10) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 11) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 12) {
               return 0;
            } else if ((Integer)s.getValue(SandBlock.BLOCKSTATE) == 13) {
               return 0;
            } else {
               return s.getValue(SandBlock.BLOCKSTATE) == 14 ? 0 : 0;
            }
         }
      }).getLightLevel()).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
         return box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 2) {
         return box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 3) {
         return box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 4) {
         return box(0.0, 0.0, 0.0, 16.0, 5.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 5) {
         return box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 6) {
         return box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 7) {
         return box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 8) {
         return box(0.0, 0.0, 0.0, 16.0, 9.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 9) {
         return box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 10) {
         return box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 11) {
         return box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 12) {
         return box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
      } else if ((Integer)state.getValue(BLOCKSTATE) == 13) {
         return box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0);
      } else {
         return state.getValue(BLOCKSTATE) == 14 ? box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0) : box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
      }
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{BLOCKSTATE});
   }
}
