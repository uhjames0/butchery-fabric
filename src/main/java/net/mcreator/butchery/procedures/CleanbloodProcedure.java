package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

public class CleanbloodProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            CleanbloodProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        CleanbloodProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block30: {
            ItemStack itemStack;
            ItemStack itemStack2;
            block33: {
                ItemStack itemStack3;
                ItemStack itemStack4;
                block31: {
                    ItemStack itemStack5;
                    ItemStack itemStack6;
                    block32: {
                        ItemStack itemStack7;
                        ItemStack itemStack8;
                        if (entity == null || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.BLOOD_PUDDLE.get()) break block30;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntx = (LivingEntity)entity;
                            itemStack8 = _livEntx.getMainHandItem();
                        } else {
                            itemStack8 = ItemStack.EMPTY;
                        }
                        if (itemStack8.getItem() != ButcheryModItems.SPONGE.get()) break block31;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity)entity;
                            itemStack7 = _livEnt.getMainHandItem();
                        } else {
                            itemStack7 = ItemStack.EMPTY;
                        }
                        if (!(((CustomData)itemStack7.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) >= 1.0)) break block31;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _level = (Level)world;
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.fishing_bobber.splash")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.fishing_bobber.splash")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        world.destroyBlock(BlockPos.containing((double)x, (double)y, (double)z), false);
                        if (!(entity instanceof Player)) break block32;
                        Player _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) break block30;
                    }
                    String _tagName = "spongeWetness";
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)entity;
                        itemStack6 = _livEntxx.getMainHandItem();
                    } else {
                        itemStack6 = ItemStack.EMPTY;
                    }
                    double _tagValue = ((CustomData)itemStack6.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) - 1.0;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxx = (LivingEntity)entity;
                        itemStack5 = _livEntxxx.getMainHandItem();
                    } else {
                        itemStack5 = ItemStack.EMPTY;
                    }
                    CustomData.update((DataComponentType)DataComponents.CUSTOM_DATA, (ItemStack)itemStack5, tag -> tag.putDouble("spongeWetness", _tagValue));
                    break block30;
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntx = (LivingEntity)entity;
                    itemStack4 = _livEntx.getMainHandItem();
                } else {
                    itemStack4 = ItemStack.EMPTY;
                }
                if (itemStack4.getItem() != ButcheryModItems.RAG.get()) break block30;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    itemStack3 = _livEnt.getMainHandItem();
                } else {
                    itemStack3 = ItemStack.EMPTY;
                }
                if (!(((CustomData)itemStack3.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("ragWetness", 0.0) >= 1.0)) break block30;
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                if (world instanceof Level) {
                    Level _levelx = (Level)world;
                    if (!_levelx.isClientSide()) {
                        _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.fishing_bobber.splash")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                    } else {
                        _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.fishing_bobber.splash")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                    }
                }
                world.destroyBlock(BlockPos.containing((double)x, (double)y, (double)z), false);
                if (!(entity instanceof Player)) break block33;
                Player _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block30;
            }
            String _tagName = "ragWetness";
            if (entity instanceof LivingEntity) {
                LivingEntity _livEntxx = (LivingEntity)entity;
                itemStack2 = _livEntxx.getMainHandItem();
            } else {
                itemStack2 = ItemStack.EMPTY;
            }
            double _tagValue = ((CustomData)itemStack2.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("ragWetness", 0.0) - 1.0;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEntxxx = (LivingEntity)entity;
                itemStack = _livEntxxx.getMainHandItem();
            } else {
                itemStack = ItemStack.EMPTY;
            }
            CustomData.update((DataComponentType)DataComponents.CUSTOM_DATA, (ItemStack)itemStack, tag -> tag.putDouble("ragWetness", _tagValue));
        }
    }
}

