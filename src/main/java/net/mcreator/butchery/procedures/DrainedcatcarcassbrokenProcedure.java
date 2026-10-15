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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class DrainedcatcarcassbrokenProcedure {
   public static void onBlockBreak(BreakShim event) {
      execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip3)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip5)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip11
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip11)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip13)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip19)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip21
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip21)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(
                  _level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get())
               );
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip27
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip27)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip29)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip35)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip37
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip37)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip43
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip43)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip45
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip45)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip51
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip51)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip53
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip53)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip59
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip59)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip61
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip61)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip67
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip67)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip69
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip69)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip75
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip75)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip77
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip77)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip83
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip83)
                           : -1
                     )
                     == 0
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip85
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip85)
                           : -1
                     )
                     == 1
            )) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CAT_CARCASS.get()
            && !(entity instanceof Player _plr && _plr.getAbilities().instabuild)
            && world instanceof ServerLevel _level) {
            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.RAW_CAT_MEAT.get()));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
         }
      }
   }
}
