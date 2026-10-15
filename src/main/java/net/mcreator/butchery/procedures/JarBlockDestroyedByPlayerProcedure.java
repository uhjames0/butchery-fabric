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

/* JADX INFO: loaded from: JarBlockDestroyedByPlayerProcedure.class */
public class JarBlockDestroyedByPlayerProcedure {
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
        if (entity != null) {
            Property<?> property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip1 = property;
                iIntValue = ((Integer) blockstate.getValue(_getip1)).intValue();
            } else {
                iIntValue = -1;
            }
            if (iIntValue == 1) {
                if (entity instanceof Player) {
                    Player _plr = (Player) entity;
                    if (_plr.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel) world;
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike) ButcheryModItems.HEART.get()));
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
                if (entity instanceof Player) {
                    Player _plr2 = (Player) entity;
                    if (_plr2.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level2 = (ServerLevel) world;
                    ItemEntity entityToSpawn2 = new ItemEntity(_level2, x, y, z, new ItemStack((ItemLike) ButcheryModItems.INTESTINES.get()));
                    entityToSpawn2.setPickUpDelay(10);
                    _level2.addFreshEntity(entityToSpawn2);
                    return;
                }
                return;
            }
            Property<?> property3 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property3 instanceof IntegerProperty) {
                Property<?> _getip9 = property3;
                iIntValue3 = ((Integer) blockstate.getValue(_getip9)).intValue();
            } else {
                iIntValue3 = -1;
            }
            if (iIntValue3 == 3) {
                if (entity instanceof Player) {
                    Player _plr3 = (Player) entity;
                    if (_plr3.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level3 = (ServerLevel) world;
                    ItemEntity entityToSpawn3 = new ItemEntity(_level3, x, y, z, new ItemStack((ItemLike) ButcheryModItems.KIDNEY.get()));
                    entityToSpawn3.setPickUpDelay(10);
                    _level3.addFreshEntity(entityToSpawn3);
                    return;
                }
                return;
            }
            Property<?> property4 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property4 instanceof IntegerProperty) {
                Property<?> _getip13 = property4;
                iIntValue4 = ((Integer) blockstate.getValue(_getip13)).intValue();
            } else {
                iIntValue4 = -1;
            }
            if (iIntValue4 == 4) {
                if (entity instanceof Player) {
                    Player _plr4 = (Player) entity;
                    if (_plr4.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level4 = (ServerLevel) world;
                    ItemEntity entityToSpawn4 = new ItemEntity(_level4, x, y, z, new ItemStack((ItemLike) ButcheryModItems.LIVER.get()));
                    entityToSpawn4.setPickUpDelay(10);
                    _level4.addFreshEntity(entityToSpawn4);
                    return;
                }
                return;
            }
            Property<?> property5 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property5 instanceof IntegerProperty) {
                Property<?> _getip17 = property5;
                iIntValue5 = ((Integer) blockstate.getValue(_getip17)).intValue();
            } else {
                iIntValue5 = -1;
            }
            if (iIntValue5 == 5) {
                if (entity instanceof Player) {
                    Player _plr5 = (Player) entity;
                    if (_plr5.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level5 = (ServerLevel) world;
                    ItemEntity entityToSpawn5 = new ItemEntity(_level5, x, y, z, new ItemStack((ItemLike) ButcheryModItems.STOMACH.get()));
                    entityToSpawn5.setPickUpDelay(10);
                    _level5.addFreshEntity(entityToSpawn5);
                    return;
                }
                return;
            }
            Property<?> property6 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property6 instanceof IntegerProperty) {
                Property<?> _getip21 = property6;
                iIntValue6 = ((Integer) blockstate.getValue(_getip21)).intValue();
            } else {
                iIntValue6 = -1;
            }
            if (iIntValue6 == 6) {
                if (entity instanceof Player) {
                    Player _plr6 = (Player) entity;
                    if (_plr6.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level6 = (ServerLevel) world;
                    ItemEntity entityToSpawn6 = new ItemEntity(_level6, x, y, z, new ItemStack((ItemLike) ButcheryModItems.LUNGS.get()));
                    entityToSpawn6.setPickUpDelay(10);
                    _level6.addFreshEntity(entityToSpawn6);
                    return;
                }
                return;
            }
            Property<?> property7 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property7 instanceof IntegerProperty) {
                Property<?> _getip25 = property7;
                iIntValue7 = ((Integer) blockstate.getValue(_getip25)).intValue();
            } else {
                iIntValue7 = -1;
            }
            if (iIntValue7 == 7) {
                if (entity instanceof Player) {
                    Player _plr7 = (Player) entity;
                    if (_plr7.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level7 = (ServerLevel) world;
                    ItemEntity entityToSpawn7 = new ItemEntity(_level7, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ROTTEN_HEART.get()));
                    entityToSpawn7.setPickUpDelay(10);
                    _level7.addFreshEntity(entityToSpawn7);
                    return;
                }
                return;
            }
            Property<?> property8 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property8 instanceof IntegerProperty) {
                Property<?> _getip29 = property8;
                iIntValue8 = ((Integer) blockstate.getValue(_getip29)).intValue();
            } else {
                iIntValue8 = -1;
            }
            if (iIntValue8 == 8) {
                if (entity instanceof Player) {
                    Player _plr8 = (Player) entity;
                    if (_plr8.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level8 = (ServerLevel) world;
                    ItemEntity entityToSpawn8 = new ItemEntity(_level8, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ROTTEN_INTESTINES.get()));
                    entityToSpawn8.setPickUpDelay(10);
                    _level8.addFreshEntity(entityToSpawn8);
                    return;
                }
                return;
            }
            Property<?> property9 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property9 instanceof IntegerProperty) {
                Property<?> _getip33 = property9;
                iIntValue9 = ((Integer) blockstate.getValue(_getip33)).intValue();
            } else {
                iIntValue9 = -1;
            }
            if (iIntValue9 == 9) {
                if (entity instanceof Player) {
                    Player _plr9 = (Player) entity;
                    if (_plr9.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level9 = (ServerLevel) world;
                    ItemEntity entityToSpawn9 = new ItemEntity(_level9, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ROTTEN_KIDNEY.get()));
                    entityToSpawn9.setPickUpDelay(10);
                    _level9.addFreshEntity(entityToSpawn9);
                    return;
                }
                return;
            }
            Property<?> property10 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property10 instanceof IntegerProperty) {
                Property<?> _getip37 = property10;
                iIntValue10 = ((Integer) blockstate.getValue(_getip37)).intValue();
            } else {
                iIntValue10 = -1;
            }
            if (iIntValue10 == 10) {
                if (entity instanceof Player) {
                    Player _plr10 = (Player) entity;
                    if (_plr10.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level10 = (ServerLevel) world;
                    ItemEntity entityToSpawn10 = new ItemEntity(_level10, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ROTTEN_LIVER.get()));
                    entityToSpawn10.setPickUpDelay(10);
                    _level10.addFreshEntity(entityToSpawn10);
                    return;
                }
                return;
            }
            Property<?> property11 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property11 instanceof IntegerProperty) {
                Property<?> _getip41 = property11;
                iIntValue11 = ((Integer) blockstate.getValue(_getip41)).intValue();
            } else {
                iIntValue11 = -1;
            }
            if (iIntValue11 == 11) {
                if (entity instanceof Player) {
                    Player _plr11 = (Player) entity;
                    if (_plr11.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level11 = (ServerLevel) world;
                    ItemEntity entityToSpawn11 = new ItemEntity(_level11, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ROTTEN_STOMACH.get()));
                    entityToSpawn11.setPickUpDelay(10);
                    _level11.addFreshEntity(entityToSpawn11);
                    return;
                }
                return;
            }
            Property<?> property12 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property12 instanceof IntegerProperty) {
                Property<?> _getip45 = property12;
                iIntValue12 = ((Integer) blockstate.getValue(_getip45)).intValue();
            } else {
                iIntValue12 = -1;
            }
            if (iIntValue12 == 12) {
                if (entity instanceof Player) {
                    Player _plr12 = (Player) entity;
                    if (_plr12.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level12 = (ServerLevel) world;
                    ItemEntity entityToSpawn12 = new ItemEntity(_level12, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ROTTEN_LUNGS.get()));
                    entityToSpawn12.setPickUpDelay(10);
                    _level12.addFreshEntity(entityToSpawn12);
                    return;
                }
                return;
            }
            Property<?> property13 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property13 instanceof IntegerProperty) {
                Property<?> _getip49 = property13;
                iIntValue13 = ((Integer) blockstate.getValue(_getip49)).intValue();
            } else {
                iIntValue13 = -1;
            }
            if (iIntValue13 == 13) {
                if (entity instanceof Player) {
                    Player _plr13 = (Player) entity;
                    if (_plr13.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level13 = (ServerLevel) world;
                    ItemEntity entityToSpawn13 = new ItemEntity(_level13, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ENDERMAN_HEART.get()));
                    entityToSpawn13.setPickUpDelay(10);
                    _level13.addFreshEntity(entityToSpawn13);
                    return;
                }
                return;
            }
            Property<?> property14 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property14 instanceof IntegerProperty) {
                Property<?> _getip53 = property14;
                iIntValue14 = ((Integer) blockstate.getValue(_getip53)).intValue();
            } else {
                iIntValue14 = -1;
            }
            if (iIntValue14 == 14) {
                if (entity instanceof Player) {
                    Player _plr14 = (Player) entity;
                    if (_plr14.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level14 = (ServerLevel) world;
                    ItemEntity entityToSpawn14 = new ItemEntity(_level14, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ENDERMAN_INTESTINES.get()));
                    entityToSpawn14.setPickUpDelay(10);
                    _level14.addFreshEntity(entityToSpawn14);
                    return;
                }
                return;
            }
            Property<?> property15 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property15 instanceof IntegerProperty) {
                Property<?> _getip57 = property15;
                iIntValue15 = ((Integer) blockstate.getValue(_getip57)).intValue();
            } else {
                iIntValue15 = -1;
            }
            if (iIntValue15 == 15) {
                if (entity instanceof Player) {
                    Player _plr15 = (Player) entity;
                    if (_plr15.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level15 = (ServerLevel) world;
                    ItemEntity entityToSpawn15 = new ItemEntity(_level15, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ENDERMAN_KIDNEY.get()));
                    entityToSpawn15.setPickUpDelay(10);
                    _level15.addFreshEntity(entityToSpawn15);
                    return;
                }
                return;
            }
            Property<?> property16 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property16 instanceof IntegerProperty) {
                Property<?> _getip61 = property16;
                iIntValue16 = ((Integer) blockstate.getValue(_getip61)).intValue();
            } else {
                iIntValue16 = -1;
            }
            if (iIntValue16 == 16) {
                if (entity instanceof Player) {
                    Player _plr16 = (Player) entity;
                    if (_plr16.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level16 = (ServerLevel) world;
                    ItemEntity entityToSpawn16 = new ItemEntity(_level16, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ENDERMAN_LIVER.get()));
                    entityToSpawn16.setPickUpDelay(10);
                    _level16.addFreshEntity(entityToSpawn16);
                    return;
                }
                return;
            }
            Property<?> property17 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property17 instanceof IntegerProperty) {
                Property<?> _getip65 = property17;
                iIntValue17 = ((Integer) blockstate.getValue(_getip65)).intValue();
            } else {
                iIntValue17 = -1;
            }
            if (iIntValue17 == 17) {
                if (entity instanceof Player) {
                    Player _plr17 = (Player) entity;
                    if (_plr17.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level17 = (ServerLevel) world;
                    ItemEntity entityToSpawn17 = new ItemEntity(_level17, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ENDERMAN_STOMACH.get()));
                    entityToSpawn17.setPickUpDelay(10);
                    _level17.addFreshEntity(entityToSpawn17);
                    return;
                }
                return;
            }
            Property<?> property18 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property18 instanceof IntegerProperty) {
                Property<?> _getip69 = property18;
                iIntValue18 = ((Integer) blockstate.getValue(_getip69)).intValue();
            } else {
                iIntValue18 = -1;
            }
            if (iIntValue18 == 18) {
                if (entity instanceof Player) {
                    Player _plr18 = (Player) entity;
                    if (_plr18.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level18 = (ServerLevel) world;
                    ItemEntity entityToSpawn18 = new ItemEntity(_level18, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ENDERMAN_LUNGS.get()));
                    entityToSpawn18.setPickUpDelay(10);
                    _level18.addFreshEntity(entityToSpawn18);
                    return;
                }
                return;
            }
            Property<?> property19 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property19 instanceof IntegerProperty) {
                IntegerProperty _getip73 = (IntegerProperty) property19;
                iIntValue19 = ((Integer) blockstate.getValue(_getip73)).intValue();
            } else {
                iIntValue19 = -1;
            }
            if (iIntValue19 == 19) {
                if (entity instanceof Player) {
                    Player _plr19 = (Player) entity;
                    if (_plr19.getAbilities().instabuild) {
                        return;
                    }
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level19 = (ServerLevel) world;
                    ItemEntity entityToSpawn19 = new ItemEntity(_level19, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.BRAIN.get()));
                    entityToSpawn19.setPickUpDelay(10);
                    _level19.addFreshEntity(entityToSpawn19);
                }
            }
        }
    }
}
