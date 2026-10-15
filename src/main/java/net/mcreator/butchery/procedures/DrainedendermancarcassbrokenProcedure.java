package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

public class DrainedendermancarcassbrokenProcedure {
    public static void onBlockBreak(ShimEvent.BreakShim event) {
        DrainedendermancarcassbrokenProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getPlayer());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        DrainedendermancarcassbrokenProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block9: {
            block12: {
                block10: {
                    block11: {
                        if (entity == null || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get() && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.HANGING_DRAINED_ENDERMAN_CARCASS.get()) break block9;
                        if (DrainedendermancarcassbrokenProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "butcherStage") != 0.0) break block10;
                        if (!(entity instanceof Player)) break block11;
                        Player _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) break block9;
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    break block9;
                }
                if (!(DrainedendermancarcassbrokenProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "butcherStage") >= 1.0)) break block9;
                if (!(entity instanceof Player)) break block12;
                Player _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block9;
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.RAW_ENDERMAN_STEAK.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
        }
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
    }
}

