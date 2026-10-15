package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.BreakShim;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class DrainedllamacarcassbrokenProcedure {
   public static void onBlockBreak(BreakShim event) {
      execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
      execute(null, world, x, y, z, blockstate, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
      if (entity != null) {
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BROWN_LLAMA_CARCASS.get()) {
            if ((
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3
                        ? (Integer)blockstate.getValue(_getip3)
                        : -1
                  )
                  != 0
               && (
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5
                        ? (Integer)blockstate.getValue(_getip5)
                        : -1
                  )
                  != 1) {
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.RAW_LLAMA_STEAK.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            } else if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_BROWN_LLAMA_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_CREAMY_LLAMA_CARCASS.get()) {
            if ((
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13
                        ? (Integer)blockstate.getValue(_getip13)
                        : -1
                  )
                  != 0
               && (
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15
                        ? (Integer)blockstate.getValue(_getip15)
                        : -1
                  )
                  != 1) {
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.RAW_LLAMA_STEAK.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            } else if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_CREAMY_LLAMA_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_GRAY_LLAMA_CARCASS.get()) {
            if ((
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23
                        ? (Integer)blockstate.getValue(_getip23)
                        : -1
                  )
                  != 0
               && (
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip25
                        ? (Integer)blockstate.getValue(_getip25)
                        : -1
                  )
                  != 1) {
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.RAW_LLAMA_STEAK.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            } else if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_GRAY_LLAMA_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WHITE_LLAMA_CARCASS.get()) {
            if ((
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip33
                        ? (Integer)blockstate.getValue(_getip33)
                        : -1
                  )
                  != 0
               && (
                     blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35
                        ? (Integer)blockstate.getValue(_getip35)
                        : -1
                  )
                  != 1) {
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.RAW_LLAMA_STEAK.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            } else if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_WHITE_LLAMA_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }
      }
   }
}
