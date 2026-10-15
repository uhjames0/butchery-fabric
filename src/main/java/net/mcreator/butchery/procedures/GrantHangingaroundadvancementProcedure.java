package net.mcreator.butchery.procedures;

import java.util.Iterator;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class GrantHangingaroundadvancementProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            GrantHangingaroundadvancementProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        GrantHangingaroundadvancementProcedure.execute(null, world, x, y, z, entity);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ServerLevel _sl_player;
        ServerLevel serverLevel;
        ItemStack itemStack;
        if (entity == null) return;
        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.HOOK.get()) return;
        if (entity instanceof LivingEntity) {
            LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
            itemStack = _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
        } else {
            itemStack = ItemStack.EMPTY;
        }
        if (itemStack.getItem() != ((Block)ButcheryModBlocks.PIG_CARCASS.get()).asItem() && itemStack.getItem() != ((Block)ButcheryModBlocks.COLD_PIG_CARCASS.get()).asItem() && itemStack.getItem() != ((Block)ButcheryModBlocks.WARM_PIG_CARCASS.get()).asItem() && itemStack.getItem() != ((Block)ButcheryModBlocks.COLD_COW_CARCASS.get()).asItem() && itemStack.getItem() != ((Block)ButcheryModBlocks.WARM_COW_CARCASS.get()).asItem() && itemStack.getItem() != ((Block)ButcheryModBlocks.COLD_CHICKEN_CARCASS.get()).asItem() && itemStack.getItem() != ((Block)ButcheryModBlocks.WARM_CHICKEN_CARCASS.get()).asItem()) {
            ItemStack itemStack2;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                itemStack2 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
            } else {
                itemStack2 = ItemStack.EMPTY;
            }
            if (itemStack2.getItem() != ((Block)ButcheryModBlocks.COW_CARCASS.get()).asItem()) {
                ItemStack itemStack3;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                    itemStack3 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                } else {
                    itemStack3 = ItemStack.EMPTY;
                }
                if (itemStack3.getItem() != ((Block)ButcheryModBlocks.SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.ORANGE_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.MAGENTA_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.LIGHT_BLUE_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.YELLOW_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.LIME_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.PINK_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.GRAY_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.LIGHT_GRAY_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.CYAN_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.PURPLE_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.BLUE_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.BROWN_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.GREEN_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.RED_SHEEP_CARCASS.get()).asItem() && itemStack3.getItem() != ((Block)ButcheryModBlocks.BLACK_SHEEP_CARCASS.get()).asItem()) {
                    ItemStack itemStack4;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                        itemStack4 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                    } else {
                        itemStack4 = ItemStack.EMPTY;
                    }
                    if (itemStack4.getItem() != ((Block)ButcheryModBlocks.CHICKEN_CARCASS.get()).asItem()) {
                        ItemStack itemStack5;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                            itemStack5 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                        } else {
                            itemStack5 = ItemStack.EMPTY;
                        }
                        if (itemStack5.getItem() != ((Block)ButcheryModBlocks.BAT_CARCASS.get()).asItem()) {
                            ItemStack itemStack6;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                itemStack6 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                            } else {
                                itemStack6 = ItemStack.EMPTY;
                            }
                            if (itemStack6.getItem() != ((Block)ButcheryModBlocks.DOLPHIN_CARCASS.get()).asItem()) {
                                ItemStack itemStack7;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                    itemStack7 = _livEntxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                } else {
                                    itemStack7 = ItemStack.EMPTY;
                                }
                                if (itemStack7.getItem() != ((Block)ButcheryModBlocks.GLOW_SQUID_CARCASS.get()).asItem()) {
                                    ItemStack itemStack8;
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                        itemStack8 = _livEntxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                    } else {
                                        itemStack8 = ItemStack.EMPTY;
                                    }
                                    if (itemStack8.getItem() != ((Block)ButcheryModBlocks.SQUID_CARCASS.get()).asItem()) {
                                        ItemStack itemStack9;
                                        if (entity instanceof LivingEntity) {
                                            LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                            itemStack9 = _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                        } else {
                                            itemStack9 = ItemStack.EMPTY;
                                        }
                                        if (itemStack9.getItem() != ((Block)ButcheryModBlocks.GOAT_CARCASS.get()).asItem()) {
                                            ItemStack itemStack10;
                                            if (entity instanceof LivingEntity) {
                                                LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                itemStack10 = _livEntxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                            } else {
                                                itemStack10 = ItemStack.EMPTY;
                                            }
                                            if (itemStack10.getItem() != ((Block)ButcheryModBlocks.RED_MOOSHROOM_CARCASS.get()).asItem()) {
                                                ItemStack itemStack11;
                                                if (entity instanceof LivingEntity) {
                                                    LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                    itemStack11 = _livEntxxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                } else {
                                                    itemStack11 = ItemStack.EMPTY;
                                                }
                                                if (itemStack11.getItem() != ((Block)ButcheryModBlocks.BROWN_MOOSHROOM_CARCASS.get()).asItem()) {
                                                    ItemStack itemStack12;
                                                    if (entity instanceof LivingEntity) {
                                                        LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                        itemStack12 = _livEntxxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                    } else {
                                                        itemStack12 = ItemStack.EMPTY;
                                                    }
                                                    if (itemStack12.getItem() != ((Block)ButcheryModBlocks.OCELOT_CARCASS.get()).asItem()) {
                                                        ItemStack itemStack13;
                                                        if (entity instanceof LivingEntity) {
                                                            LivingEntity _livEntxxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                            itemStack13 = _livEntxxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                        } else {
                                                            itemStack13 = ItemStack.EMPTY;
                                                        }
                                                        if (itemStack13.getItem() != ((Block)ButcheryModBlocks.CAMEL_CARCASS.get()).asItem()) {
                                                            ItemStack itemStack14;
                                                            if (entity instanceof LivingEntity) {
                                                                LivingEntity _livEntxxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                itemStack14 = _livEntxxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                            } else {
                                                                itemStack14 = ItemStack.EMPTY;
                                                            }
                                                            if (itemStack14.getItem() != ((Block)ButcheryModBlocks.CAVE_SPIDER_CARCASS.get()).asItem()) {
                                                                ItemStack itemStack15;
                                                                if (entity instanceof LivingEntity) {
                                                                    LivingEntity _livEntxxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                    itemStack15 = _livEntxxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                } else {
                                                                    itemStack15 = ItemStack.EMPTY;
                                                                }
                                                                if (itemStack15.getItem() != ((Block)ButcheryModBlocks.SPIDER_CARCASS.get()).asItem()) {
                                                                    ItemStack itemStack16;
                                                                    if (entity instanceof LivingEntity) {
                                                                        LivingEntity _livEntxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                        itemStack16 = _livEntxxxxxxxxxxxxxxxx.getMainHandItem();
                                                                    } else {
                                                                        itemStack16 = ItemStack.EMPTY;
                                                                    }
                                                                    if (itemStack16.getItem() != ((Block)ButcheryModBlocks.COD_CARCASS.get()).asItem()) {
                                                                        ItemStack itemStack17;
                                                                        if (entity instanceof LivingEntity) {
                                                                            LivingEntity _livEntxxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                            itemStack17 = _livEntxxxxxxxxxxxxxxx.getMainHandItem();
                                                                        } else {
                                                                            itemStack17 = ItemStack.EMPTY;
                                                                        }
                                                                        if (itemStack17.getItem() != ((Block)ButcheryModBlocks.SALMON_CARCASS.get()).asItem()) {
                                                                            ItemStack itemStack18;
                                                                            if (entity instanceof LivingEntity) {
                                                                                LivingEntity _livEntxxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                itemStack18 = _livEntxxxxxxxxxxxxxx.getMainHandItem();
                                                                            } else {
                                                                                itemStack18 = ItemStack.EMPTY;
                                                                            }
                                                                            if (itemStack18.getItem() != ((Block)ButcheryModBlocks.CREEPER_CARCASS.get()).asItem()) {
                                                                                ItemStack itemStack19;
                                                                                if (entity instanceof LivingEntity) {
                                                                                    LivingEntity _livEntxxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                    itemStack19 = _livEntxxxxxxxxxxxxx.getMainHandItem();
                                                                                } else {
                                                                                    itemStack19 = ItemStack.EMPTY;
                                                                                }
                                                                                if (itemStack19.getItem() != ((Block)ButcheryModBlocks.DONKEY_CARCASS.get()).asItem()) {
                                                                                    ItemStack itemStack20;
                                                                                    if (entity instanceof LivingEntity) {
                                                                                        LivingEntity _livEntxxxxxxxxxxxx = (LivingEntity)entity;
                                                                                        itemStack20 = _livEntxxxxxxxxxxxx.getMainHandItem();
                                                                                    } else {
                                                                                        itemStack20 = ItemStack.EMPTY;
                                                                                    }
                                                                                    if (itemStack20.getItem() != ((Block)ButcheryModBlocks.MULE_CARCASS.get()).asItem()) {
                                                                                        ItemStack itemStack21;
                                                                                        if (entity instanceof LivingEntity) {
                                                                                            LivingEntity _livEntxxxxxxxxxxx = (LivingEntity)entity;
                                                                                            itemStack21 = _livEntxxxxxxxxxxx.getMainHandItem();
                                                                                        } else {
                                                                                            itemStack21 = ItemStack.EMPTY;
                                                                                        }
                                                                                        if (itemStack21.getItem() != ((Block)ButcheryModBlocks.FOX_CARCASS.get()).asItem()) {
                                                                                            ItemStack itemStack22;
                                                                                            if (entity instanceof LivingEntity) {
                                                                                                LivingEntity _livEntxxxxxxxxxx = (LivingEntity)entity;
                                                                                                itemStack22 = _livEntxxxxxxxxxx.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack22 = ItemStack.EMPTY;
                                                                                            }
                                                                                            if (itemStack22.getItem() != ((Block)ButcheryModBlocks.SNOW_FOX_CARCASS.get()).asItem()) {
                                                                                                ItemStack itemStack23;
                                                                                                if (entity instanceof LivingEntity) {
                                                                                                    LivingEntity _livEntxxxxxxxxx = (LivingEntity)entity;
                                                                                                    itemStack23 = _livEntxxxxxxxxx.getMainHandItem();
                                                                                                } else {
                                                                                                    itemStack23 = ItemStack.EMPTY;
                                                                                                }
                                                                                                if (itemStack23.getItem() != ((Block)ButcheryModBlocks.RABBIT_CARCASS.get()).asItem()) {
                                                                                                    ItemStack itemStack24;
                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                        LivingEntity _livEntxxxxxxxx = (LivingEntity)entity;
                                                                                                        itemStack24 = _livEntxxxxxxxx.getMainHandItem();
                                                                                                    } else {
                                                                                                        itemStack24 = ItemStack.EMPTY;
                                                                                                    }
                                                                                                    if (itemStack24.getItem() != ((Block)ButcheryModBlocks.STRIDER_CARCASS.get()).asItem()) {
                                                                                                        ItemStack itemStack25;
                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                            LivingEntity _livEntxxxxxxx = (LivingEntity)entity;
                                                                                                            itemStack25 = _livEntxxxxxxx.getMainHandItem();
                                                                                                        } else {
                                                                                                            itemStack25 = ItemStack.EMPTY;
                                                                                                        }
                                                                                                        if (itemStack25.getItem() != ((Block)ButcheryModBlocks.TURTLE_CARCASS.get()).asItem()) {
                                                                                                            ItemStack itemStack26;
                                                                                                            if (entity instanceof LivingEntity) {
                                                                                                                LivingEntity _livEntxxxxxx = (LivingEntity)entity;
                                                                                                                itemStack26 = _livEntxxxxxx.getMainHandItem();
                                                                                                            } else {
                                                                                                                itemStack26 = ItemStack.EMPTY;
                                                                                                            }
                                                                                                            if (itemStack26.getItem() != ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).asItem()) {
                                                                                                                ItemStack itemStack27;
                                                                                                                if (entity instanceof LivingEntity) {
                                                                                                                    LivingEntity _livEntxxxxx = (LivingEntity)entity;
                                                                                                                    itemStack27 = _livEntxxxxx.getMainHandItem();
                                                                                                                } else {
                                                                                                                    itemStack27 = ItemStack.EMPTY;
                                                                                                                }
                                                                                                                if (itemStack27.getItem() != ((Block)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).asItem()) {
                                                                                                                    ItemStack itemStack28;
                                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                                        LivingEntity _livEntxxxx = (LivingEntity)entity;
                                                                                                                        itemStack28 = _livEntxxxx.getMainHandItem();
                                                                                                                    } else {
                                                                                                                        itemStack28 = ItemStack.EMPTY;
                                                                                                                    }
                                                                                                                    if (itemStack28.getItem() != ((Block)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).asItem()) {
                                                                                                                        ItemStack itemStack29;
                                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                                            LivingEntity _livEntxxx = (LivingEntity)entity;
                                                                                                                            itemStack29 = _livEntxxx.getMainHandItem();
                                                                                                                        } else {
                                                                                                                            itemStack29 = ItemStack.EMPTY;
                                                                                                                        }
                                                                                                                        if (itemStack29.getItem() != ((Block)ButcheryModBlocks.BROWN_LLAMA_CARCASS.get()).asItem()) {
                                                                                                                            ItemStack itemStack30;
                                                                                                                            if (entity instanceof LivingEntity) {
                                                                                                                                LivingEntity _livEntxx = (LivingEntity)entity;
                                                                                                                                itemStack30 = _livEntxx.getMainHandItem();
                                                                                                                            } else {
                                                                                                                                itemStack30 = ItemStack.EMPTY;
                                                                                                                            }
                                                                                                                            if (itemStack30.getItem() != ((Block)ButcheryModBlocks.CREAMY_LLAMA_CARCASS.get()).asItem()) {
                                                                                                                                ItemStack itemStack31;
                                                                                                                                if (entity instanceof LivingEntity) {
                                                                                                                                    LivingEntity _livEntx = (LivingEntity)entity;
                                                                                                                                    itemStack31 = _livEntx.getMainHandItem();
                                                                                                                                } else {
                                                                                                                                    itemStack31 = ItemStack.EMPTY;
                                                                                                                                }
                                                                                                                                if (itemStack31.getItem() != ((Block)ButcheryModBlocks.GRAY_LLAMA_CARCASS.get()).asItem()) {
                                                                                                                                    ItemStack itemStack32;
                                                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                                                        LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                                                        itemStack32 = _livEnt.getMainHandItem();
                                                                                                                                    } else {
                                                                                                                                        itemStack32 = ItemStack.EMPTY;
                                                                                                                                    }
                                                                                                                                    if (itemStack32.getItem() != ((Block)ButcheryModBlocks.WHITE_LLAMA_CARCASS.get()).asItem()) return;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _plr66 = (ServerPlayer)entity;
        ServerLevel _plr67 = _plr66.level();
        if (!(_plr67 instanceof ServerLevel)) return;
        if (!_plr66.getAdvancements().getOrStartProgress(_plr67.getServer().getAdvancements().get(Identifier.parse((String)"butchery:firstcarcass"))).isDone()) return;
        boolean var85 = true;
        if (!var85) return;
        if (entity instanceof ServerPlayer) {
            ServerLevel _sl_plr67;
            ServerLevel _player;
            ServerPlayer _plr672 = (ServerPlayer)entity;
            serverLevel = _plr672.level();
            ServerLevel serverLevel2 = _player = serverLevel instanceof ServerLevel ? (_sl_plr67 = serverLevel) : null;
            if (_player instanceof ServerLevel && _plr672.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:hangingaround"))).isDone()) {
                return;
            }
        }
        var85 = false;
        if (var85) return;
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _player = (ServerPlayer)entity;
        serverLevel = _player.level();
        ServerLevel _adv = serverLevel instanceof ServerLevel ? (_sl_player = serverLevel) : null;
        if (!(_adv instanceof ServerLevel)) return;
        AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:hangingaround"));
        if (_advx == null) return;
        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_advx);
        if (_ap.isDone()) return;
        Iterator iterator = _ap.getRemainingCriteria().iterator();
        while (iterator.hasNext()) {
            String criteria = (String)iterator.next();
            _player.getAdvancements().award(_advx, criteria);
        }
    }
}

