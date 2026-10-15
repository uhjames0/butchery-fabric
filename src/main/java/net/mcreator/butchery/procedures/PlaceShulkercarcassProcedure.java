package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class PlaceShulkercarcassProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            PlaceShulkercarcassProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        PlaceShulkercarcassProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block26: {
            Player _player;
            block30: {
                ItemStack itemStack;
                ItemStack itemStack2;
                block28: {
                    Player _player2;
                    block29: {
                        ItemStack itemStack3;
                        ItemStack itemStack4;
                        block27: {
                            ItemStack itemStack5;
                            ItemStack itemStack6;
                            if (entity == null || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.HOOK.get() && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.ROPE.get()) break block26;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx = (LivingEntity)entity;
                                itemStack6 = _livEntx.getMainHandItem();
                            } else {
                                itemStack6 = ItemStack.EMPTY;
                            }
                            if (itemStack6.getItem() == ((Block)ButcheryModBlocks.SHULKER_CARCASS.get()).asItem()) break block27;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEnt = (LivingEntity)entity;
                                itemStack5 = _livEnt.getOffhandItem();
                            } else {
                                itemStack5 = ItemStack.EMPTY;
                            }
                            if (itemStack5.getItem() != ((Block)ButcheryModBlocks.SHULKER_CARCASS.get()).asItem()) break block26;
                        }
                        if (event instanceof ICancellableEvent) {
                            NeoEvent _cancellable = event;
                            _cancellable.setCanceled(true);
                        }
                        if (world instanceof Level) {
                            Level _level = (Level)world;
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.chain.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.chain.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.HOOK.get()) break block28;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx = (LivingEntity)entity;
                            itemStack4 = _livEntxxx.getMainHandItem();
                        } else {
                            itemStack4 = ItemStack.EMPTY;
                        }
                        if (itemStack4.getItem() == ((Block)ButcheryModBlocks.SHULKER_CARCASS.get()).asItem()) break block29;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx = (LivingEntity)entity;
                            itemStack3 = _livEntxx.getOffhandItem();
                        } else {
                            itemStack3 = ItemStack.EMPTY;
                        }
                        if (itemStack3.getItem() != ((Block)ButcheryModBlocks.SHULKER_CARCASS.get()).asItem()) break block26;
                    }
                    if (entity instanceof Player && !(_player2 = (Player)entity).level().isClientSide()) {
                        _player2.sendOverlayMessage((Component)Component.literal((String)"The shell is too tough for the hook to pierce.."));
                    }
                    break block26;
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.ROPE.get()) break block26;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntxxx = (LivingEntity)entity;
                    itemStack2 = _livEntxxx.getMainHandItem();
                } else {
                    itemStack2 = ItemStack.EMPTY;
                }
                if (itemStack2.getItem() == ((Block)ButcheryModBlocks.SHULKER_CARCASS.get()).asItem()) break block30;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntxx = (LivingEntity)entity;
                    itemStack = _livEntxx.getOffhandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                if (itemStack.getItem() != ((Block)ButcheryModBlocks.SHULKER_CARCASS.get()).asItem()) break block26;
            }
            if (entity instanceof Player && !(_player = (Player)entity).level().isClientSide()) {
                _player.sendOverlayMessage((Component)Component.literal((String)"You can't hang a shulker from the rope.."));
            }
        }
    }
}

