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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class Hook_Block_DestroyedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        block12: {
            block15: {
                block13: {
                    ItemEntity entityToSpawn;
                    ServerLevel _level;
                    block14: {
                        int n;
                        if (entity == null) break block12;
                        Property property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property instanceof IntegerProperty) {
                            IntegerProperty _getip1 = (IntegerProperty)property;
                            n = (Integer)blockstate.getValue((Property)_getip1);
                        } else {
                            n = -1;
                        }
                        if (n != 0) break block13;
                        if (!(entity instanceof Player)) break block14;
                        Player _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) break block12;
                    }
                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)Blocks.IRON_CHAIN));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    break block12;
                }
                if (!(entity instanceof Player)) break block15;
                Player _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block12;
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
        }
    }
}

