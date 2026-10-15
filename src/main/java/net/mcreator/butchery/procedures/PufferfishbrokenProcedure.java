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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class PufferfishbrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        block6: {
            block7: {
                int n;
                if (entity == null) break block6;
                Property property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    IntegerProperty _getip1 = (IntegerProperty)property;
                    n = (Integer)blockstate.getValue((Property)_getip1);
                } else {
                    n = -1;
                }
                if (n != 1) break block6;
                if (!(entity instanceof Player)) break block7;
                Player _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block6;
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.RAW_PUFFERFISH.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
        }
    }
}

