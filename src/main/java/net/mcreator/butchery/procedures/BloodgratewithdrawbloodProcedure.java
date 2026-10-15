package net.mcreator.butchery.procedures;

import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.FluidHandler;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.mcreator.butchery.shim.itemcap.ItemHandlerHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BloodgratewithdrawbloodProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        block154: {
            block177: {
                block176: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    block173: {
                        block175: {
                            block174: {
                                ItemStack itemStack3;
                                ItemStack itemStack4;
                                block170: {
                                    block172: {
                                        block171: {
                                            ItemStack itemStack5;
                                            ItemStack itemStack6;
                                            block167: {
                                                block169: {
                                                    block168: {
                                                        ItemStack itemStack7;
                                                        ItemStack itemStack8;
                                                        block164: {
                                                            Player _player;
                                                            block166: {
                                                                block165: {
                                                                    ItemStack itemStack9;
                                                                    ItemStack itemStack10;
                                                                    block161: {
                                                                        Player _player2;
                                                                        ItemStack vampirismBottle;
                                                                        block163: {
                                                                            block162: {
                                                                                ItemStack itemStack11;
                                                                                ItemStack itemStack12;
                                                                                block158: {
                                                                                    Player _player3;
                                                                                    block160: {
                                                                                        block159: {
                                                                                            ItemStack itemStack13;
                                                                                            ItemStack itemStack14;
                                                                                            block155: {
                                                                                                block157: {
                                                                                                    block156: {
                                                                                                        ItemStack itemStack15;
                                                                                                        ItemStack itemStack16;
                                                                                                        if (entity == null) break block154;
                                                                                                        vampirismBottle = ItemStack.EMPTY;
                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                            LivingEntity _livEntx = (LivingEntity)entity;
                                                                                                            itemStack16 = _livEntx.getMainHandItem();
                                                                                                        } else {
                                                                                                            itemStack16 = ItemStack.EMPTY;
                                                                                                        }
                                                                                                        if (itemStack16.getItem() != Items.GLASS_BOTTLE) break block155;
                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                            LivingEntity _livEnt = (LivingEntity)entity;
                                                                                                            itemStack15 = _livEnt.getMainHandItem();
                                                                                                        } else {
                                                                                                            itemStack15 = ItemStack.EMPTY;
                                                                                                        }
                                                                                                        if (((CustomData)itemStack15.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) != 0.0) break block155;
                                                                                                        if (BloodgratewithdrawbloodProcedure.getFluidTankLevel(world, BlockPos.containing((double)x, (double)y, (double)z), 1, null) < 333) break block154;
                                                                                                        if (!(entity instanceof Player)) break block156;
                                                                                                        Player _plr = (Player)entity;
                                                                                                        if (_plr.getAbilities().instabuild) break block157;
                                                                                                    }
                                                                                                    if (entity instanceof LivingEntity) {
                                                                                                        ItemStack itemStack17;
                                                                                                        LivingEntity _entity = (LivingEntity)entity;
                                                                                                        ItemStack _setstack8 = new ItemStack((ItemLike)Items.GLASS_BOTTLE).copy();
                                                                                                        if (entity instanceof LivingEntity) {
                                                                                                            LivingEntity _livEntxx = (LivingEntity)entity;
                                                                                                            itemStack17 = _livEntxx.getMainHandItem();
                                                                                                        } else {
                                                                                                            itemStack17 = ItemStack.EMPTY;
                                                                                                        }
                                                                                                        _setstack8.setCount(itemStack17.getCount() - 1);
                                                                                                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack8);
                                                                                                        if (_entity instanceof Player) {
                                                                                                            Player _player4 = (Player)_entity;
                                                                                                            _player4.getInventory().setChanged();
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                if (entity instanceof LivingEntity) {
                                                                                                    LivingEntity _entityx = (LivingEntity)entity;
                                                                                                    _entityx.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                                }
                                                                                                ILevelExtension _ext = new ILevelExtension(world);
                                                                                                IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)y, (double)z), null);
                                                                                                if (_fluidHandler != null) {
                                                                                                    _fluidHandler.drain(333, IFluidHandler.FluidAction.EXECUTE);
                                                                                                }
                                                                                                if (entity instanceof Player) {
                                                                                                    Player _player5 = (Player)entity;
                                                                                                    ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.BOTTLE_OF_BLOOD.get()).copy();
                                                                                                    _setstack.setCount(1);
                                                                                                    ItemHandlerHelper.giveItemToPlayer(_player5, _setstack);
                                                                                                }
                                                                                                if (world instanceof Level) {
                                                                                                    Level _level = (Level)world;
                                                                                                    if (!_level.isClientSide()) {
                                                                                                        _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                                    } else {
                                                                                                        _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                                    }
                                                                                                }
                                                                                                break block154;
                                                                                            }
                                                                                            if (entity instanceof LivingEntity) {
                                                                                                LivingEntity _livEntxxx = (LivingEntity)entity;
                                                                                                itemStack14 = _livEntxxx.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack14 = ItemStack.EMPTY;
                                                                                            }
                                                                                            if (itemStack14.getItem() != Items.GLASS_BOTTLE) break block158;
                                                                                            if (entity instanceof LivingEntity) {
                                                                                                LivingEntity _livEntxx = (LivingEntity)entity;
                                                                                                itemStack13 = _livEntxx.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack13 = ItemStack.EMPTY;
                                                                                            }
                                                                                            if (((CustomData)itemStack13.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) != 1.0) break block158;
                                                                                            if (BloodgratewithdrawbloodProcedure.getFluidTankLevel(world, BlockPos.containing((double)x, (double)y, (double)z), 1, null) < 333) break block154;
                                                                                            if (!(entity instanceof Player)) break block159;
                                                                                            Player _plrx = (Player)entity;
                                                                                            if (_plrx.getAbilities().instabuild) break block160;
                                                                                        }
                                                                                        if (entity instanceof LivingEntity) {
                                                                                            ItemStack itemStack18;
                                                                                            LivingEntity _entityx = (LivingEntity)entity;
                                                                                            ItemStack _setstack21 = new ItemStack((ItemLike)Items.GLASS_BOTTLE).copy();
                                                                                            if (entity instanceof LivingEntity) {
                                                                                                LivingEntity _livEntxxxx = (LivingEntity)entity;
                                                                                                itemStack18 = _livEntxxxx.getMainHandItem();
                                                                                            } else {
                                                                                                itemStack18 = ItemStack.EMPTY;
                                                                                            }
                                                                                            _setstack21.setCount(itemStack18.getCount() - 1);
                                                                                            _entityx.setItemInHand(InteractionHand.MAIN_HAND, _setstack21);
                                                                                            if (_entityx instanceof Player) {
                                                                                                Player _player6 = (Player)_entityx;
                                                                                                _player6.getInventory().setChanged();
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    if (entity instanceof LivingEntity) {
                                                                                        LivingEntity _entityxx = (LivingEntity)entity;
                                                                                        _entityxx.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                                    }
                                                                                    if (FabricLoader.getInstance().isModLoaded("blood_magic")) {
                                                                                        Player _player7;
                                                                                        if (entity instanceof Player && !(_player7 = (Player)entity).level().isClientSide()) {
                                                                                            _player7.sendOverlayMessage((Component)Component.literal((String)"You need to use a bucket."));
                                                                                        }
                                                                                    } else if (entity instanceof Player && !(_player3 = (Player)entity).level().isClientSide()) {
                                                                                        _player3.sendOverlayMessage((Component)Component.literal((String)"You need to use a bucket."));
                                                                                    }
                                                                                    if (world instanceof Level) {
                                                                                        Level _levelx = (Level)world;
                                                                                        if (!_levelx.isClientSide()) {
                                                                                            _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                                        } else {
                                                                                            _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                                        }
                                                                                    }
                                                                                    break block154;
                                                                                }
                                                                                if (entity instanceof LivingEntity) {
                                                                                    LivingEntity _livEntxxxxx = (LivingEntity)entity;
                                                                                    itemStack12 = _livEntxxxxx.getMainHandItem();
                                                                                } else {
                                                                                    itemStack12 = ItemStack.EMPTY;
                                                                                }
                                                                                if (itemStack12.getItem() != Items.GLASS_BOTTLE) break block161;
                                                                                if (entity instanceof LivingEntity) {
                                                                                    LivingEntity _livEntxxxx = (LivingEntity)entity;
                                                                                    itemStack11 = _livEntxxxx.getMainHandItem();
                                                                                } else {
                                                                                    itemStack11 = ItemStack.EMPTY;
                                                                                }
                                                                                if (((CustomData)itemStack11.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) != 2.0) break block161;
                                                                                if (BloodgratewithdrawbloodProcedure.getFluidTankLevel(world, BlockPos.containing((double)x, (double)y, (double)z), 1, null) < 333) break block154;
                                                                                if (!(entity instanceof Player)) break block162;
                                                                                Player _plrxx = (Player)entity;
                                                                                if (_plrxx.getAbilities().instabuild) break block163;
                                                                            }
                                                                            if (entity instanceof LivingEntity) {
                                                                                ItemStack itemStack19;
                                                                                LivingEntity _entityxx = (LivingEntity)entity;
                                                                                ItemStack _setstack35 = new ItemStack((ItemLike)Items.GLASS_BOTTLE).copy();
                                                                                if (entity instanceof LivingEntity) {
                                                                                    LivingEntity _livEntxxxxxx = (LivingEntity)entity;
                                                                                    itemStack19 = _livEntxxxxxx.getMainHandItem();
                                                                                } else {
                                                                                    itemStack19 = ItemStack.EMPTY;
                                                                                }
                                                                                _setstack35.setCount(itemStack19.getCount() - 1);
                                                                                _entityxx.setItemInHand(InteractionHand.MAIN_HAND, _setstack35);
                                                                                if (_entityxx instanceof Player) {
                                                                                    _player2 = (Player)_entityxx;
                                                                                    _player2.getInventory().setChanged();
                                                                                }
                                                                            }
                                                                        }
                                                                        if (entity instanceof LivingEntity) {
                                                                            LivingEntity _entityxxx = (LivingEntity)entity;
                                                                            _entityxxx.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                                        }
                                                                        ILevelExtension _extx = new ILevelExtension(world);
                                                                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)y, (double)z), null);
                                                                        if (_fluidHandler != null) {
                                                                            _fluidHandler.drain(333, IFluidHandler.FluidAction.EXECUTE);
                                                                        }
                                                                        vampirismBottle = new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse((String)"vampirism:blood_bottle"))).copy();
                                                                        String _tagName = "Damage";
                                                                        double _tagValue = 9.0;
                                                                        CustomData.update((DataComponentType)DataComponents.CUSTOM_DATA, (ItemStack)vampirismBottle, tag -> tag.putDouble("Damage", 9.0));
                                                                        if (entity instanceof Player) {
                                                                            _player2 = (Player)entity;
                                                                            ItemStack _setstack = vampirismBottle.copy();
                                                                            _setstack.setCount(1);
                                                                            ItemHandlerHelper.giveItemToPlayer(_player2, _setstack);
                                                                        }
                                                                        if (world instanceof Level) {
                                                                            Level _levelxx = (Level)world;
                                                                            if (!_levelxx.isClientSide()) {
                                                                                _levelxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                            } else {
                                                                                _levelxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                            }
                                                                        }
                                                                        break block154;
                                                                    }
                                                                    if (entity instanceof LivingEntity) {
                                                                        LivingEntity _livEntxxxxxxx = (LivingEntity)entity;
                                                                        itemStack10 = _livEntxxxxxxx.getMainHandItem();
                                                                    } else {
                                                                        itemStack10 = ItemStack.EMPTY;
                                                                    }
                                                                    if (itemStack10.getItem() != Items.GLASS_BOTTLE) break block164;
                                                                    if (entity instanceof LivingEntity) {
                                                                        LivingEntity _livEntxxxxxx = (LivingEntity)entity;
                                                                        itemStack9 = _livEntxxxxxx.getMainHandItem();
                                                                    } else {
                                                                        itemStack9 = ItemStack.EMPTY;
                                                                    }
                                                                    if (((CustomData)itemStack9.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) != 3.0) break block164;
                                                                    if (BloodgratewithdrawbloodProcedure.getFluidTankLevel(world, BlockPos.containing((double)x, (double)y, (double)z), 1, null) < 333) break block154;
                                                                    if (!(entity instanceof Player)) break block165;
                                                                    Player _plrxxx = (Player)entity;
                                                                    if (_plrxxx.getAbilities().instabuild) break block166;
                                                                }
                                                                if (entity instanceof LivingEntity) {
                                                                    ItemStack itemStack20;
                                                                    LivingEntity _entityxxx = (LivingEntity)entity;
                                                                    ItemStack _setstack50 = new ItemStack((ItemLike)Items.GLASS_BOTTLE).copy();
                                                                    if (entity instanceof LivingEntity) {
                                                                        LivingEntity _livEntxxxxxxxx = (LivingEntity)entity;
                                                                        itemStack20 = _livEntxxxxxxxx.getMainHandItem();
                                                                    } else {
                                                                        itemStack20 = ItemStack.EMPTY;
                                                                    }
                                                                    _setstack50.setCount(itemStack20.getCount() - 1);
                                                                    _entityxxx.setItemInHand(InteractionHand.MAIN_HAND, _setstack50);
                                                                    if (_entityxxx instanceof Player) {
                                                                        _player = (Player)_entityxxx;
                                                                        _player.getInventory().setChanged();
                                                                    }
                                                                }
                                                            }
                                                            if (entity instanceof LivingEntity) {
                                                                LivingEntity _entityxxxx = (LivingEntity)entity;
                                                                _entityxxxx.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                            }
                                                            ILevelExtension _extxx = new ILevelExtension(world);
                                                            IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)y, (double)z), null);
                                                            if (_fluidHandler != null) {
                                                                _fluidHandler.drain(333, IFluidHandler.FluidAction.EXECUTE);
                                                            }
                                                            String _tagNamex = "Damage";
                                                            double _tagValuex = 9.0;
                                                            CustomData.update((DataComponentType)DataComponents.CUSTOM_DATA, (ItemStack)new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse((String)"hexerei:blood_bottle"))), tag -> tag.putDouble("Damage", 9.0));
                                                            if (entity instanceof Player) {
                                                                _player = (Player)entity;
                                                                ItemStack _setstack = new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse((String)"hexerei:blood_bottle"))).copy();
                                                                _setstack.setCount(1);
                                                                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                                            }
                                                            if (world instanceof Level) {
                                                                Level _levelxxx = (Level)world;
                                                                if (!_levelxxx.isClientSide()) {
                                                                    _levelxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                                } else {
                                                                    _levelxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                                }
                                                            }
                                                            break block154;
                                                        }
                                                        if (entity instanceof LivingEntity) {
                                                            LivingEntity _livEntxxxxxxxxx = (LivingEntity)entity;
                                                            itemStack8 = _livEntxxxxxxxxx.getMainHandItem();
                                                        } else {
                                                            itemStack8 = ItemStack.EMPTY;
                                                        }
                                                        if (itemStack8.getItem() != Items.BUCKET) break block167;
                                                        if (entity instanceof LivingEntity) {
                                                            LivingEntity _livEntxxxxxxxx = (LivingEntity)entity;
                                                            itemStack7 = _livEntxxxxxxxx.getMainHandItem();
                                                        } else {
                                                            itemStack7 = ItemStack.EMPTY;
                                                        }
                                                        if (((CustomData)itemStack7.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) != 0.0) break block167;
                                                        if (BloodgratewithdrawbloodProcedure.getFluidTankLevel(world, BlockPos.containing((double)x, (double)y, (double)z), 1, null) < 1000) break block154;
                                                        if (!(entity instanceof Player)) break block168;
                                                        Player _plrxxxx = (Player)entity;
                                                        if (_plrxxxx.getAbilities().instabuild) break block169;
                                                    }
                                                    if (entity instanceof LivingEntity) {
                                                        ItemStack itemStack21;
                                                        LivingEntity _entityxxxx = (LivingEntity)entity;
                                                        ItemStack _setstack66 = new ItemStack((ItemLike)Items.BUCKET).copy();
                                                        if (entity instanceof LivingEntity) {
                                                            LivingEntity _livEntxxxxxxxxxx = (LivingEntity)entity;
                                                            itemStack21 = _livEntxxxxxxxxxx.getMainHandItem();
                                                        } else {
                                                            itemStack21 = ItemStack.EMPTY;
                                                        }
                                                        _setstack66.setCount(itemStack21.getCount() - 1);
                                                        _entityxxxx.setItemInHand(InteractionHand.MAIN_HAND, _setstack66);
                                                        if (_entityxxxx instanceof Player) {
                                                            Player _player = (Player)_entityxxxx;
                                                            _player.getInventory().setChanged();
                                                        }
                                                    }
                                                }
                                                if (entity instanceof LivingEntity) {
                                                    LivingEntity _entityxxxxx = (LivingEntity)entity;
                                                    _entityxxxxx.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                                }
                                                ILevelExtension _extxxx = new ILevelExtension(world);
                                                IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)y, (double)z), null);
                                                if (_fluidHandler != null) {
                                                    _fluidHandler.drain(1000, IFluidHandler.FluidAction.EXECUTE);
                                                }
                                                if (entity instanceof Player) {
                                                    Player _player = (Player)entity;
                                                    ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.BLOOD_BUCKET.get()).copy();
                                                    _setstack.setCount(1);
                                                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                                }
                                                if (world instanceof Level) {
                                                    Level _levelxxxx = (Level)world;
                                                    if (!_levelxxxx.isClientSide()) {
                                                        _levelxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                                    } else {
                                                        _levelxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                                    }
                                                }
                                                break block154;
                                            }
                                            if (entity instanceof LivingEntity) {
                                                LivingEntity _livEntxxxxxxxxxxx = (LivingEntity)entity;
                                                itemStack6 = _livEntxxxxxxxxxxx.getMainHandItem();
                                            } else {
                                                itemStack6 = ItemStack.EMPTY;
                                            }
                                            if (itemStack6.getItem() != Items.BUCKET) break block170;
                                            if (entity instanceof LivingEntity) {
                                                LivingEntity _livEntxxxxxxxxxx = (LivingEntity)entity;
                                                itemStack5 = _livEntxxxxxxxxxx.getMainHandItem();
                                            } else {
                                                itemStack5 = ItemStack.EMPTY;
                                            }
                                            if (((CustomData)itemStack5.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) != 1.0) break block170;
                                            if (BloodgratewithdrawbloodProcedure.getFluidTankLevel(world, BlockPos.containing((double)x, (double)y, (double)z), 1, null) < 1000) break block154;
                                            if (!(entity instanceof Player)) break block171;
                                            Player _plrxxxxx = (Player)entity;
                                            if (_plrxxxxx.getAbilities().instabuild) break block172;
                                        }
                                        if (entity instanceof LivingEntity) {
                                            ItemStack itemStack22;
                                            LivingEntity _entityxxxxx = (LivingEntity)entity;
                                            ItemStack _setstack79 = new ItemStack((ItemLike)Items.BUCKET).copy();
                                            if (entity instanceof LivingEntity) {
                                                LivingEntity _livEntxxxxxxxxxxxx = (LivingEntity)entity;
                                                itemStack22 = _livEntxxxxxxxxxxxx.getMainHandItem();
                                            } else {
                                                itemStack22 = ItemStack.EMPTY;
                                            }
                                            _setstack79.setCount(itemStack22.getCount() - 1);
                                            _entityxxxxx.setItemInHand(InteractionHand.MAIN_HAND, _setstack79);
                                            if (_entityxxxxx instanceof Player) {
                                                Player _player = (Player)_entityxxxxx;
                                                _player.getInventory().setChanged();
                                            }
                                        }
                                    }
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _entityxxxxxx = (LivingEntity)entity;
                                        _entityxxxxxx.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                    }
                                    ILevelExtension _extxxxx = new ILevelExtension(world);
                                    IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)y, (double)z), null);
                                    if (_fluidHandler != null) {
                                        _fluidHandler.drain(1000, IFluidHandler.FluidAction.EXECUTE);
                                    }
                                    if (entity instanceof Player) {
                                        Player _player = (Player)entity;
                                        ItemStack _setstack = new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse((String)"bloodmagic:life_essence_bucket"))).copy();
                                        _setstack.setCount(1);
                                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                    }
                                    if (world instanceof Level) {
                                        Level _levelxxxxx = (Level)world;
                                        if (!_levelxxxxx.isClientSide()) {
                                            _levelxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                        } else {
                                            _levelxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                                        }
                                    }
                                    break block154;
                                }
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxxxxxxxxxxxxx = (LivingEntity)entity;
                                    itemStack4 = _livEntxxxxxxxxxxxxx.getMainHandItem();
                                } else {
                                    itemStack4 = ItemStack.EMPTY;
                                }
                                if (itemStack4.getItem() != Items.BUCKET) break block173;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxxxxxxxxxxxx = (LivingEntity)entity;
                                    itemStack3 = _livEntxxxxxxxxxxxx.getMainHandItem();
                                } else {
                                    itemStack3 = ItemStack.EMPTY;
                                }
                                if (((CustomData)itemStack3.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) != 2.0) break block173;
                                if (BloodgratewithdrawbloodProcedure.getFluidTankLevel(world, BlockPos.containing((double)x, (double)y, (double)z), 1, null) < 1000) break block154;
                                if (!(entity instanceof Player)) break block174;
                                Player _plrxxxxxx = (Player)entity;
                                if (_plrxxxxxx.getAbilities().instabuild) break block175;
                            }
                            if (entity instanceof LivingEntity) {
                                ItemStack itemStack23;
                                LivingEntity _entityxxxxxx = (LivingEntity)entity;
                                ItemStack _setstack93 = new ItemStack((ItemLike)Items.GLASS_BOTTLE).copy();
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxxxxxxxxxxxxxx = (LivingEntity)entity;
                                    itemStack23 = _livEntxxxxxxxxxxxxxx.getMainHandItem();
                                } else {
                                    itemStack23 = ItemStack.EMPTY;
                                }
                                _setstack93.setCount(itemStack23.getCount() - 1);
                                _entityxxxxxx.setItemInHand(InteractionHand.MAIN_HAND, _setstack93);
                                if (_entityxxxxxx instanceof Player) {
                                    Player _player = (Player)_entityxxxxxx;
                                    _player.getInventory().setChanged();
                                }
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entityxxxxxxx = (LivingEntity)entity;
                            _entityxxxxxxx.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        ILevelExtension _extxxxxx = new ILevelExtension(world);
                        IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)y, (double)z), null);
                        if (_fluidHandler != null) {
                            _fluidHandler.drain(1000, IFluidHandler.FluidAction.EXECUTE);
                        }
                        if (entity instanceof Player) {
                            Player _player = (Player)entity;
                            ItemStack _setstack = new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse((String)"vampirism:blood_bucket"))).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxx = (Level)world;
                            if (!_levelxxxxxx.isClientSide()) {
                                _levelxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        break block154;
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxxxxxxxxxxxxxx = (LivingEntity)entity;
                        itemStack2 = _livEntxxxxxxxxxxxxxxx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (itemStack2.getItem() != Items.BUCKET) break block154;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxxxxxxxxxxxxx = (LivingEntity)entity;
                        itemStack = _livEntxxxxxxxxxxxxxx.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (((CustomData)itemStack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) != 3.0 || BloodgratewithdrawbloodProcedure.getFluidTankLevel(world, BlockPos.containing((double)x, (double)y, (double)z), 1, null) < 1000) break block154;
                    if (!(entity instanceof Player)) break block176;
                    Player _plrxxxxxxx = (Player)entity;
                    if (_plrxxxxxxx.getAbilities().instabuild) break block177;
                }
                if (entity instanceof LivingEntity) {
                    ItemStack itemStack;
                    LivingEntity _entityxxxxxxx = (LivingEntity)entity;
                    ItemStack _setstack107 = new ItemStack((ItemLike)Items.GLASS_BOTTLE).copy();
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxxxxxxxxxxxxxxx = (LivingEntity)entity;
                        itemStack = _livEntxxxxxxxxxxxxxxxx.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    _setstack107.setCount(itemStack.getCount() - 1);
                    _entityxxxxxxx.setItemInHand(InteractionHand.MAIN_HAND, _setstack107);
                    if (_entityxxxxxxx instanceof Player) {
                        Player _player = (Player)_entityxxxxxxx;
                        _player.getInventory().setChanged();
                    }
                }
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entityxxxxxxxx = (LivingEntity)entity;
                _entityxxxxxxxx.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            ILevelExtension _extxxxxxx = new ILevelExtension(world);
            IFluidHandler _fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(world, FluidHandler.BLOCK, BlockPos.containing((double)x, (double)y, (double)z), null);
            if (_fluidHandler != null) {
                _fluidHandler.drain(1000, IFluidHandler.FluidAction.EXECUTE);
            }
            if (entity instanceof Player) {
                Player _player = (Player)entity;
                ItemStack _setstack = new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse((String)"hexerei:blood_bucket"))).copy();
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
            if (world instanceof Level) {
                Level _levelxxxxxxx = (Level)world;
                if (!_levelxxxxxxx.isClientSide()) {
                    _levelxxxxxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _levelxxxxxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.fill")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
        }
    }

    private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
        ILevelExtension levelExtension = new ILevelExtension(level);
        IFluidHandler fluidHandler = (IFluidHandler)ButcheryCaps.getCapability(level, FluidHandler.BLOCK, pos, direction);
        if (fluidHandler != null) {
            return fluidHandler.getFluidInTank(tank).getAmount();
        }
        return 0;
    }
}

