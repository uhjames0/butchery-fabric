package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
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

public class DrainedTurtlecarcassbrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        block20: {
            block25: {
                block21: {
                    block24: {
                        block22: {
                            block23: {
                                int n;
                                int n2;
                                int n3;
                                int n4;
                                if (entity == null) break block20;
                                Property property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                if (property instanceof IntegerProperty) {
                                    Property<?> _getip1 = (IntegerProperty)property;
                                    n4 = (Integer)blockstate.getValue((Property)_getip1);
                                } else {
                                    n4 = -1;
                                }
                                if (n4 == 0) break block21;
                                property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                if (property instanceof IntegerProperty) {
                                    Property<?> _getip3 = (IntegerProperty)property;
                                    n3 = (Integer)blockstate.getValue((Property)_getip3);
                                } else {
                                    n3 = -1;
                                }
                                if (n3 == 1) break block21;
                                Property property2 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                if (property2 instanceof IntegerProperty) {
                                    Property<?> _getip7 = (IntegerProperty)property2;
                                    n2 = (Integer)blockstate.getValue((Property)_getip7);
                                } else {
                                    n2 = -1;
                                }
                                if (n2 == 8) break block22;
                                property2 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                                if (property2 instanceof IntegerProperty) {
                                    IntegerProperty _getip9 = (IntegerProperty)property2;
                                    n = (Integer)blockstate.getValue((Property)_getip9);
                                } else {
                                    n = -1;
                                }
                                if (n == 16) break block22;
                                if (!(entity instanceof Player)) break block23;
                                Player _plr = (Player)entity;
                                if (_plr.getAbilities().instabuild) break block20;
                            }
                            if (world instanceof ServerLevel) {
                                ServerLevel _level = (ServerLevel)world;
                                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.RAW_TURTLE_MEAT.get()));
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                            break block20;
                        }
                        if (!(entity instanceof Player)) break block24;
                        Player _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) break block20;
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    break block20;
                }
                if (!(entity instanceof Player)) break block25;
                Player _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block20;
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
        }
    }
}

