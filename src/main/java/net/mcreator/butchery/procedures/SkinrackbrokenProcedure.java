package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/* JADX INFO: loaded from: SkinrackbrokenProcedure.class */
public class SkinrackbrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        int iIntValue5;
        int iIntValue6;
        int iIntValue7;
        int iIntValue8;
        int iIntValue9;
        int iIntValue10;
        int iIntValue11;
        int iIntValue12;
        int iIntValue13;
        int iIntValue14;
        int iIntValue15;
        int iIntValue16;
        int iIntValue17;
        int iIntValue18;
        int iIntValue19;
        int iIntValue20;
        int iIntValue21;
        int iIntValue22;
        int iIntValue23;
        int iIntValue24;
        int iIntValue25;
        int iIntValue26;
        int iIntValue27;
        if (entity != null) {
            if (entity instanceof Player) {
                Player _plr = (Player) entity;
                if (_plr.getAbilities().instabuild) {
                    return;
                }
            }
            Property<?> property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip2 = property;
                iIntValue = ((Integer) blockstate.getValue(_getip2)).intValue();
            } else {
                iIntValue = -1;
            }
            if (iIntValue == 1) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel) world;
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike) ButcheryModItems.BAT_SKIN.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                    return;
                }
                return;
            }
            Property<?> property2 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property2 instanceof IntegerProperty) {
                Property<?> _getip5 = property2;
                iIntValue2 = ((Integer) blockstate.getValue(_getip5)).intValue();
            } else {
                iIntValue2 = -1;
            }
            if (iIntValue2 == 2) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level2 = (ServerLevel) world;
                    ItemEntity entityToSpawn2 = new ItemEntity(_level2, x, y, z, new ItemStack((ItemLike) ButcheryModItems.BLACK_HORSE_SKIN.get()));
                    entityToSpawn2.setPickUpDelay(10);
                    _level2.addFreshEntity(entityToSpawn2);
                    return;
                }
                return;
            }
            Property<?> property3 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property3 instanceof IntegerProperty) {
                Property<?> _getip8 = property3;
                iIntValue3 = ((Integer) blockstate.getValue(_getip8)).intValue();
            } else {
                iIntValue3 = -1;
            }
            if (iIntValue3 == 3) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level3 = (ServerLevel) world;
                    ItemEntity entityToSpawn3 = new ItemEntity(_level3, x, y, z, new ItemStack((ItemLike) ButcheryModItems.BROWN_MOOSHROOM_SKIN.get()));
                    entityToSpawn3.setPickUpDelay(10);
                    _level3.addFreshEntity(entityToSpawn3);
                    return;
                }
                return;
            }
            Property<?> property4 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property4 instanceof IntegerProperty) {
                Property<?> _getip11 = property4;
                iIntValue4 = ((Integer) blockstate.getValue(_getip11)).intValue();
            } else {
                iIntValue4 = -1;
            }
            if (iIntValue4 == 4) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level4 = (ServerLevel) world;
                    ItemEntity entityToSpawn4 = new ItemEntity(_level4, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CHESTNUT_HORSE_SKIN.get()));
                    entityToSpawn4.setPickUpDelay(10);
                    _level4.addFreshEntity(entityToSpawn4);
                    return;
                }
                return;
            }
            Property<?> property5 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property5 instanceof IntegerProperty) {
                Property<?> _getip14 = property5;
                iIntValue5 = ((Integer) blockstate.getValue(_getip14)).intValue();
            } else {
                iIntValue5 = -1;
            }
            if (iIntValue5 == 5) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level5 = (ServerLevel) world;
                    ItemEntity entityToSpawn5 = new ItemEntity(_level5, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CREAMY_HORSE_SKIN.get()));
                    entityToSpawn5.setPickUpDelay(10);
                    _level5.addFreshEntity(entityToSpawn5);
                    return;
                }
                return;
            }
            Property<?> property6 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property6 instanceof IntegerProperty) {
                Property<?> _getip17 = property6;
                iIntValue6 = ((Integer) blockstate.getValue(_getip17)).intValue();
            } else {
                iIntValue6 = -1;
            }
            if (iIntValue6 == 6) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level6 = (ServerLevel) world;
                    ItemEntity entityToSpawn6 = new ItemEntity(_level6, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CREEPER_SKIN.get()));
                    entityToSpawn6.setPickUpDelay(10);
                    _level6.addFreshEntity(entityToSpawn6);
                    return;
                }
                return;
            }
            Property<?> property7 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property7 instanceof IntegerProperty) {
                Property<?> _getip20 = property7;
                iIntValue7 = ((Integer) blockstate.getValue(_getip20)).intValue();
            } else {
                iIntValue7 = -1;
            }
            if (iIntValue7 == 7) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level7 = (ServerLevel) world;
                    ItemEntity entityToSpawn7 = new ItemEntity(_level7, x, y, z, new ItemStack((ItemLike) ButcheryModItems.DARK_BROWN_HORSE_SKIN.get()));
                    entityToSpawn7.setPickUpDelay(10);
                    _level7.addFreshEntity(entityToSpawn7);
                    return;
                }
                return;
            }
            Property<?> property8 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property8 instanceof IntegerProperty) {
                Property<?> _getip23 = property8;
                iIntValue8 = ((Integer) blockstate.getValue(_getip23)).intValue();
            } else {
                iIntValue8 = -1;
            }
            if (iIntValue8 == 8) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level8 = (ServerLevel) world;
                    ItemEntity entityToSpawn8 = new ItemEntity(_level8, x, y, z, new ItemStack((ItemLike) ButcheryModItems.DOLPHIN_SKIN.get()));
                    entityToSpawn8.setPickUpDelay(10);
                    _level8.addFreshEntity(entityToSpawn8);
                    return;
                }
                return;
            }
            Property<?> property9 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property9 instanceof IntegerProperty) {
                Property<?> _getip26 = property9;
                iIntValue9 = ((Integer) blockstate.getValue(_getip26)).intValue();
            } else {
                iIntValue9 = -1;
            }
            if (iIntValue9 == 9) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level9 = (ServerLevel) world;
                    ItemEntity entityToSpawn9 = new ItemEntity(_level9, x, y, z, new ItemStack((ItemLike) ButcheryModItems.DONKEY_SKIN.get()));
                    entityToSpawn9.setPickUpDelay(10);
                    _level9.addFreshEntity(entityToSpawn9);
                    return;
                }
                return;
            }
            Property<?> property10 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property10 instanceof IntegerProperty) {
                Property<?> _getip29 = property10;
                iIntValue10 = ((Integer) blockstate.getValue(_getip29)).intValue();
            } else {
                iIntValue10 = -1;
            }
            if (iIntValue10 == 10) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level10 = (ServerLevel) world;
                    ItemEntity entityToSpawn10 = new ItemEntity(_level10, x, y, z, new ItemStack((ItemLike) ButcheryModItems.FOX_SKIN.get()));
                    entityToSpawn10.setPickUpDelay(10);
                    _level10.addFreshEntity(entityToSpawn10);
                    return;
                }
                return;
            }
            Property<?> property11 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property11 instanceof IntegerProperty) {
                Property<?> _getip32 = property11;
                iIntValue11 = ((Integer) blockstate.getValue(_getip32)).intValue();
            } else {
                iIntValue11 = -1;
            }
            if (iIntValue11 == 11) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level11 = (ServerLevel) world;
                    ItemEntity entityToSpawn11 = new ItemEntity(_level11, x, y, z, new ItemStack((ItemLike) ButcheryModItems.GRAY_HORSE_SKIN.get()));
                    entityToSpawn11.setPickUpDelay(10);
                    _level11.addFreshEntity(entityToSpawn11);
                    return;
                }
                return;
            }
            Property<?> property12 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property12 instanceof IntegerProperty) {
                Property<?> _getip35 = property12;
                iIntValue12 = ((Integer) blockstate.getValue(_getip35)).intValue();
            } else {
                iIntValue12 = -1;
            }
            if (iIntValue12 == 12) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level12 = (ServerLevel) world;
                    ItemEntity entityToSpawn12 = new ItemEntity(_level12, x, y, z, new ItemStack((ItemLike) ButcheryModItems.HOGLIN_SKIN.get()));
                    entityToSpawn12.setPickUpDelay(10);
                    _level12.addFreshEntity(entityToSpawn12);
                    return;
                }
                return;
            }
            Property<?> property13 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property13 instanceof IntegerProperty) {
                Property<?> _getip38 = property13;
                iIntValue13 = ((Integer) blockstate.getValue(_getip38)).intValue();
            } else {
                iIntValue13 = -1;
            }
            if (iIntValue13 == 13) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level13 = (ServerLevel) world;
                    ItemEntity entityToSpawn13 = new ItemEntity(_level13, x, y, z, new ItemStack((ItemLike) ButcheryModItems.MULE_SKIN.get()));
                    entityToSpawn13.setPickUpDelay(10);
                    _level13.addFreshEntity(entityToSpawn13);
                    return;
                }
                return;
            }
            Property<?> property14 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property14 instanceof IntegerProperty) {
                Property<?> _getip41 = property14;
                iIntValue14 = ((Integer) blockstate.getValue(_getip41)).intValue();
            } else {
                iIntValue14 = -1;
            }
            if (iIntValue14 == 14) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level14 = (ServerLevel) world;
                    ItemEntity entityToSpawn14 = new ItemEntity(_level14, x, y, z, new ItemStack((ItemLike) ButcheryModItems.OCELOT_SKIN.get()));
                    entityToSpawn14.setPickUpDelay(10);
                    _level14.addFreshEntity(entityToSpawn14);
                    return;
                }
                return;
            }
            Property<?> property15 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property15 instanceof IntegerProperty) {
                Property<?> _getip44 = property15;
                iIntValue15 = ((Integer) blockstate.getValue(_getip44)).intValue();
            } else {
                iIntValue15 = -1;
            }
            if (iIntValue15 == 15) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level15 = (ServerLevel) world;
                    ItemEntity entityToSpawn15 = new ItemEntity(_level15, x, y, z, new ItemStack((ItemLike) ButcheryModItems.PANDA_SKIN.get()));
                    entityToSpawn15.setPickUpDelay(10);
                    _level15.addFreshEntity(entityToSpawn15);
                    return;
                }
                return;
            }
            Property<?> property16 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property16 instanceof IntegerProperty) {
                Property<?> _getip47 = property16;
                iIntValue16 = ((Integer) blockstate.getValue(_getip47)).intValue();
            } else {
                iIntValue16 = -1;
            }
            if (iIntValue16 == 16) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level16 = (ServerLevel) world;
                    ItemEntity entityToSpawn16 = new ItemEntity(_level16, x, y, z, new ItemStack((ItemLike) ButcheryModItems.PIG_SKIN.get()));
                    entityToSpawn16.setPickUpDelay(10);
                    _level16.addFreshEntity(entityToSpawn16);
                    return;
                }
                return;
            }
            Property<?> property17 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property17 instanceof IntegerProperty) {
                Property<?> _getip50 = property17;
                iIntValue17 = ((Integer) blockstate.getValue(_getip50)).intValue();
            } else {
                iIntValue17 = -1;
            }
            if (iIntValue17 == 17) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level17 = (ServerLevel) world;
                    ItemEntity entityToSpawn17 = new ItemEntity(_level17, x, y, z, new ItemStack((ItemLike) ButcheryModItems.RED_MOOSHROOM_SKIN.get()));
                    entityToSpawn17.setPickUpDelay(10);
                    _level17.addFreshEntity(entityToSpawn17);
                    return;
                }
                return;
            }
            Property<?> property18 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property18 instanceof IntegerProperty) {
                Property<?> _getip53 = property18;
                iIntValue18 = ((Integer) blockstate.getValue(_getip53)).intValue();
            } else {
                iIntValue18 = -1;
            }
            if (iIntValue18 == 18) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level18 = (ServerLevel) world;
                    ItemEntity entityToSpawn18 = new ItemEntity(_level18, x, y, z, new ItemStack((ItemLike) ButcheryModItems.SHEEP_SKIN.get()));
                    entityToSpawn18.setPickUpDelay(10);
                    _level18.addFreshEntity(entityToSpawn18);
                    return;
                }
                return;
            }
            Property<?> property19 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property19 instanceof IntegerProperty) {
                Property<?> _getip56 = property19;
                iIntValue19 = ((Integer) blockstate.getValue(_getip56)).intValue();
            } else {
                iIntValue19 = -1;
            }
            if (iIntValue19 == 19) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level19 = (ServerLevel) world;
                    ItemEntity entityToSpawn19 = new ItemEntity(_level19, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.SKIN_RACK.get()));
                    entityToSpawn19.setPickUpDelay(10);
                    _level19.addFreshEntity(entityToSpawn19);
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level20 = (ServerLevel) world;
                    ItemEntity entityToSpawn20 = new ItemEntity(_level20, x, y, z, new ItemStack((ItemLike) ButcheryModItems.SNOW_FOX_SKIN.get()));
                    entityToSpawn20.setPickUpDelay(10);
                    _level20.addFreshEntity(entityToSpawn20);
                    return;
                }
                return;
            }
            Property<?> property20 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property20 instanceof IntegerProperty) {
                Property<?> _getip60 = property20;
                iIntValue20 = ((Integer) blockstate.getValue(_getip60)).intValue();
            } else {
                iIntValue20 = -1;
            }
            if (iIntValue20 == 20) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level21 = (ServerLevel) world;
                    ItemEntity entityToSpawn21 = new ItemEntity(_level21, x, y, z, new ItemStack((ItemLike) ButcheryModItems.WHITE_HORSE_SKIN.get()));
                    entityToSpawn21.setPickUpDelay(10);
                    _level21.addFreshEntity(entityToSpawn21);
                    return;
                }
                return;
            }
            Property<?> property21 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property21 instanceof IntegerProperty) {
                Property<?> _getip63 = property21;
                iIntValue21 = ((Integer) blockstate.getValue(_getip63)).intValue();
            } else {
                iIntValue21 = -1;
            }
            if (iIntValue21 == 21) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level22 = (ServerLevel) world;
                    ItemEntity entityToSpawn22 = new ItemEntity(_level22, x, y, z, new ItemStack((ItemLike) ButcheryModItems.POLAR_BEAR_SKIN.get()));
                    entityToSpawn22.setPickUpDelay(10);
                    _level22.addFreshEntity(entityToSpawn22);
                    return;
                }
                return;
            }
            Property<?> property22 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property22 instanceof IntegerProperty) {
                Property<?> _getip66 = property22;
                iIntValue22 = ((Integer) blockstate.getValue(_getip66)).intValue();
            } else {
                iIntValue22 = -1;
            }
            if (iIntValue22 == 22) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level23 = (ServerLevel) world;
                    ItemEntity entityToSpawn23 = new ItemEntity(_level23, x, y, z, new ItemStack((ItemLike) ButcheryModItems.BROWN_LLAMA_SKIN.get()));
                    entityToSpawn23.setPickUpDelay(10);
                    _level23.addFreshEntity(entityToSpawn23);
                    return;
                }
                return;
            }
            Property<?> property23 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property23 instanceof IntegerProperty) {
                Property<?> _getip69 = property23;
                iIntValue23 = ((Integer) blockstate.getValue(_getip69)).intValue();
            } else {
                iIntValue23 = -1;
            }
            if (iIntValue23 == 23) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level24 = (ServerLevel) world;
                    ItemEntity entityToSpawn24 = new ItemEntity(_level24, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CREAMY_LLAMA_SKIN.get()));
                    entityToSpawn24.setPickUpDelay(10);
                    _level24.addFreshEntity(entityToSpawn24);
                    return;
                }
                return;
            }
            Property<?> property24 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property24 instanceof IntegerProperty) {
                Property<?> _getip72 = property24;
                iIntValue24 = ((Integer) blockstate.getValue(_getip72)).intValue();
            } else {
                iIntValue24 = -1;
            }
            if (iIntValue24 == 24) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level25 = (ServerLevel) world;
                    ItemEntity entityToSpawn25 = new ItemEntity(_level25, x, y, z, new ItemStack((ItemLike) ButcheryModItems.GRAY_LLAMA_SKIN.get()));
                    entityToSpawn25.setPickUpDelay(10);
                    _level25.addFreshEntity(entityToSpawn25);
                    return;
                }
                return;
            }
            Property<?> property25 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property25 instanceof IntegerProperty) {
                Property<?> _getip75 = property25;
                iIntValue25 = ((Integer) blockstate.getValue(_getip75)).intValue();
            } else {
                iIntValue25 = -1;
            }
            if (iIntValue25 == 25) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level26 = (ServerLevel) world;
                    ItemEntity entityToSpawn26 = new ItemEntity(_level26, x, y, z, new ItemStack((ItemLike) ButcheryModItems.WHITE_LLAMA_SKIN.get()));
                    entityToSpawn26.setPickUpDelay(10);
                    _level26.addFreshEntity(entityToSpawn26);
                    return;
                }
                return;
            }
            Property<?> property26 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property26 instanceof IntegerProperty) {
                Property<?> _getip78 = property26;
                iIntValue26 = ((Integer) blockstate.getValue(_getip78)).intValue();
            } else {
                iIntValue26 = -1;
            }
            if (iIntValue26 == 28) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level27 = (ServerLevel) world;
                    ItemEntity entityToSpawn27 = new ItemEntity(_level27, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COW_SKIN.get()));
                    entityToSpawn27.setPickUpDelay(10);
                    _level27.addFreshEntity(entityToSpawn27);
                    return;
                }
                return;
            }
            Property<?> property27 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property27 instanceof IntegerProperty) {
                IntegerProperty _getip81 = (IntegerProperty) property27;
                iIntValue27 = ((Integer) blockstate.getValue(_getip81)).intValue();
            } else {
                iIntValue27 = -1;
            }
            if (iIntValue27 == 29 && (world instanceof ServerLevel)) {
                ServerLevel _level28 = (ServerLevel) world;
                ItemEntity entityToSpawn28 = new ItemEntity(_level28, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ZOGLIN_SKIN.get()));
                entityToSpawn28.setPickUpDelay(10);
                _level28.addFreshEntity(entityToSpawn28);
            }
            if (rackIntValue(blockstate) == 30 && (world instanceof ServerLevel)) {
                ServerLevel _level30 = (ServerLevel) world;
                ItemEntity entityToSpawn30 = new ItemEntity(_level30, x, y, z, new ItemStack((ItemLike) ButcheryModItems.HOGLIN_SKIN.get()));
                entityToSpawn30.setPickUpDelay(10);
                _level30.addFreshEntity(entityToSpawn30);
            }
            if (rackIntValue(blockstate) == 31 && (world instanceof ServerLevel)) {
                ServerLevel _level31 = (ServerLevel) world;
                ItemEntity entityToSpawn31 = new ItemEntity(_level31, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CAMEL_SKIN.get()));
                entityToSpawn31.setPickUpDelay(10);
                _level31.addFreshEntity(entityToSpawn31);
            }
            if (rackIntValue(blockstate) == 32 && (world instanceof ServerLevel)) {
                ServerLevel _level32 = (ServerLevel) world;
                ItemEntity entityToSpawn32 = new ItemEntity(_level32, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COLD_PIG_SKIN.get()));
                entityToSpawn32.setPickUpDelay(10);
                _level32.addFreshEntity(entityToSpawn32);
            }
            if (rackIntValue(blockstate) == 33 && (world instanceof ServerLevel)) {
                ServerLevel _level33 = (ServerLevel) world;
                ItemEntity entityToSpawn33 = new ItemEntity(_level33, x, y, z, new ItemStack((ItemLike) ButcheryModItems.WARM_PIG_SKIN.get()));
                entityToSpawn33.setPickUpDelay(10);
                _level33.addFreshEntity(entityToSpawn33);
            }
            if (rackIntValue(blockstate) == 34 && (world instanceof ServerLevel)) {
                ServerLevel _level34 = (ServerLevel) world;
                ItemEntity entityToSpawn34 = new ItemEntity(_level34, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COLD_COW_SKIN.get()));
                entityToSpawn34.setPickUpDelay(10);
                _level34.addFreshEntity(entityToSpawn34);
            }
            if (rackIntValue(blockstate) == 35 && (world instanceof ServerLevel)) {
                ServerLevel _level35 = (ServerLevel) world;
                ItemEntity entityToSpawn35 = new ItemEntity(_level35, x, y, z, new ItemStack((ItemLike) ButcheryModItems.WARM_COW_SKIN.get()));
                entityToSpawn35.setPickUpDelay(10);
                _level35.addFreshEntity(entityToSpawn35);
            }
            // dyed sheep skins (states 36-50)
            for (int _sheepState = 36; _sheepState <= 50; _sheepState++) {
                if (rackIntValue(blockstate) == _sheepState && (world instanceof ServerLevel)) {
                    ServerLevel _sheepLevel = (ServerLevel) world;
                    Item _sheepSkin = net.mcreator.butchery.init.ButcheryVariants.sheepSkinForRackState(_sheepState);
                    if (_sheepSkin != null) {
                        ItemEntity _sheepDrop = new ItemEntity(_sheepLevel, x, y, z, new ItemStack((ItemLike) _sheepSkin));
                        _sheepDrop.setPickUpDelay(10);
                        _sheepLevel.addFreshEntity((Entity) _sheepDrop);
                    }
                }
            }
        }
    }

    private static int rackIntValue(BlockState blockstate) {
        Property<?> property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
        if (property instanceof IntegerProperty) {
            return ((Integer) blockstate.getValue((Property) property)).intValue();
        }
        return -1;
    }
}
