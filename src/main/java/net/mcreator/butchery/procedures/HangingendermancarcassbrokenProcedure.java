package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class HangingendermancarcassbrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        block4: {
            block5: {
                if (entity == null) break block4;
                if (!(entity instanceof Player)) break block5;
                Player _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block4;
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
        }
    }
}

