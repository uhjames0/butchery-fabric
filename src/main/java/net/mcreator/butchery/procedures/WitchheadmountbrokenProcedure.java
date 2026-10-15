package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/* JADX INFO: loaded from: WitchheadmountbrokenProcedure.class */
public class WitchheadmountbrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        int iIntValue;
        int iIntValue2;
        if (entity != null) {
            Property<?> property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip1 = property;
                iIntValue = ((Integer) blockstate.getValue(_getip1)).intValue();
            } else {
                iIntValue = -1;
            }
            if (iIntValue == 0) {
                if (entity instanceof Player) {
                    Player _plr = (Player) entity;
                    if (_plr.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel) world;
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.WITCH_HEAD_MOUNT.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                    return;
                }
                return;
            }
            Property<?> property2 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property2 instanceof IntegerProperty) {
                IntegerProperty _getip5 = (IntegerProperty) property2;
                iIntValue2 = ((Integer) blockstate.getValue(_getip5)).intValue();
            } else {
                iIntValue2 = -1;
            }
            if (iIntValue2 == 1) {
                if (entity instanceof Player) {
                    Player _plr2 = (Player) entity;
                    if (_plr2.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level2 = (ServerLevel) world;
                    ItemEntity entityToSpawn2 = new ItemEntity(_level2, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.WITCH_HEAD_MOUNT.get()));
                    entityToSpawn2.setPickUpDelay(10);
                    _level2.addFreshEntity(entityToSpawn2);
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level3 = (ServerLevel) world;
                    ItemEntity entityToSpawn3 = new ItemEntity(_level3, x, y, z, new ItemStack((ItemLike) ButcheryModItems.WITCHES_CLOTHES_HELMET.get()));
                    entityToSpawn3.setPickUpDelay(10);
                    _level3.addFreshEntity(entityToSpawn3);
                }
            }
        }
    }
}
