package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
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

public class BrownmooshroomcarcassbrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        block8: {
            block10: {
                block9: {
                    int n;
                    int n2;
                    if (entity == null) break block8;
                    Property property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property instanceof IntegerProperty) {
                        Property<?> _getip1 = (IntegerProperty)property;
                        n2 = (Integer)blockstate.getValue((Property)_getip1);
                    } else {
                        n2 = -1;
                    }
                    if (n2 == 0) break block9;
                    property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property instanceof IntegerProperty) {
                        IntegerProperty _getip3 = (IntegerProperty)property;
                        n = (Integer)blockstate.getValue((Property)_getip3);
                    } else {
                        n = -1;
                    }
                    if (n != 1) break block8;
                }
                if (!(entity instanceof Player)) break block10;
                Player _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block8;
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.BROWN_MOOSHROOM_CARCASS.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
        }
    }
}

