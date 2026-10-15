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

public class GlowsquidcarcassbrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        block17: {
            block21: {
                block18: {
                    block20: {
                        block19: {
                            int n;
                            int n2;
                            int n3;
                            int n4;
                            if (entity == null) break block17;
                            Property property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property instanceof IntegerProperty) {
                                Property<?> _getip1 = (IntegerProperty)property;
                                n4 = (Integer)blockstate.getValue((Property)_getip1);
                            } else {
                                n4 = -1;
                            }
                            if (n4 == 0) break block18;
                            property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property instanceof IntegerProperty) {
                                Property<?> _getip3 = (IntegerProperty)property;
                                n3 = (Integer)blockstate.getValue((Property)_getip3);
                            } else {
                                n3 = -1;
                            }
                            if (n3 == 1) break block18;
                            Property property2 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property2 instanceof IntegerProperty) {
                                Property<?> _getip7 = (IntegerProperty)property2;
                                n2 = (Integer)blockstate.getValue((Property)_getip7);
                            } else {
                                n2 = -1;
                            }
                            if (n2 == 3) break block19;
                            property2 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property2 instanceof IntegerProperty) {
                                IntegerProperty _getip9 = (IntegerProperty)property2;
                                n = (Integer)blockstate.getValue((Property)_getip9);
                            } else {
                                n = -1;
                            }
                            if (n != 5) break block17;
                        }
                        if (!(entity instanceof Player)) break block20;
                        Player _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) break block17;
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.GLOW_SQUID_HEAD.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity((Entity)entityToSpawn);
                    }
                    break block17;
                }
                if (!(entity instanceof Player)) break block21;
                Player _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block17;
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.GLOW_SQUID_CARCASS.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
        }
    }
}

