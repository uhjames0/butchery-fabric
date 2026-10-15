package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
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

/* JADX INFO: loaded from: FrogcarcassbrokenProcedure.class */
public class FrogcarcassbrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        int iIntValue5;
        int iIntValue6;
        if (entity != null) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GRAY_FROG_CARCASS.get()) {
                Property<?> property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip3 = property;
                    iIntValue5 = ((Integer) blockstate.getValue(_getip3)).intValue();
                } else {
                    iIntValue5 = -1;
                }
                if (iIntValue5 != 0) {
                    Property<?> property2 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property2 instanceof IntegerProperty) {
                        Property<?> _getip5 = property2;
                        iIntValue6 = ((Integer) blockstate.getValue(_getip5)).intValue();
                    } else {
                        iIntValue6 = -1;
                    }
                    if (iIntValue6 != 1) {
                        return;
                    }
                }
                if (entity instanceof Player) {
                    Player _plr = (Player) entity;
                    if (_plr.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel) world;
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.GRAY_FROG_CARCASS.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                    return;
                }
                return;
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GREEN_FROG_CARCASS.get()) {
                Property<?> property3 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property3 instanceof IntegerProperty) {
                    Property<?> _getip11 = property3;
                    iIntValue3 = ((Integer) blockstate.getValue(_getip11)).intValue();
                } else {
                    iIntValue3 = -1;
                }
                if (iIntValue3 != 0) {
                    Property<?> property4 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property4 instanceof IntegerProperty) {
                        Property<?> _getip13 = property4;
                        iIntValue4 = ((Integer) blockstate.getValue(_getip13)).intValue();
                    } else {
                        iIntValue4 = -1;
                    }
                    if (iIntValue4 != 1) {
                        return;
                    }
                }
                if (entity instanceof Player) {
                    Player _plr2 = (Player) entity;
                    if (_plr2.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level2 = (ServerLevel) world;
                    ItemEntity entityToSpawn2 = new ItemEntity(_level2, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.GREEN_FROG_CARCASS.get()));
                    entityToSpawn2.setPickUpDelay(10);
                    _level2.addFreshEntity(entityToSpawn2);
                    return;
                }
                return;
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ORANGE_FROG_CARCASS.get()) {
                Property<?> property5 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property5 instanceof IntegerProperty) {
                    Property<?> _getip19 = property5;
                    iIntValue = ((Integer) blockstate.getValue(_getip19)).intValue();
                } else {
                    iIntValue = -1;
                }
                if (iIntValue != 0) {
                    Property<?> property6 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property6 instanceof IntegerProperty) {
                        IntegerProperty _getip21 = (IntegerProperty) property6;
                        iIntValue2 = ((Integer) blockstate.getValue(_getip21)).intValue();
                    } else {
                        iIntValue2 = -1;
                    }
                    if (iIntValue2 != 1) {
                        return;
                    }
                }
                if (entity instanceof Player) {
                    Player _plr3 = (Player) entity;
                    if (_plr3.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level3 = (ServerLevel) world;
                    ItemEntity entityToSpawn3 = new ItemEntity(_level3, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.ORANGE_FROG_CARCASS.get()));
                    entityToSpawn3.setPickUpDelay(10);
                    _level3.addFreshEntity(entityToSpawn3);
                }
            }
        }
    }
}
