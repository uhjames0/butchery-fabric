package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class PlaceslimecarcassProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            PlaceslimecarcassProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        PlaceslimecarcassProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block14: {
            Player _player;
            block15: {
                Player _player2;
                block16: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    ItemStack itemStack3;
                    ItemStack itemStack4;
                    if (entity == null || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.HOOK.get() && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.ROPE.get()) break block14;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)entity;
                        itemStack4 = _livEntx.getMainHandItem();
                    } else {
                        itemStack4 = ItemStack.EMPTY;
                    }
                    if (itemStack4.getItem() == ((Block)ButcheryModBlocks.MEDIUM_SLIME_CARCASS.get()).asItem()) break block15;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        itemStack3 = _livEnt.getOffhandItem();
                    } else {
                        itemStack3 = ItemStack.EMPTY;
                    }
                    if (itemStack3.getItem() == ((Block)ButcheryModBlocks.MEDIUM_SLIME_CARCASS.get()).asItem()) break block15;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxx = (LivingEntity)entity;
                        itemStack2 = _livEntxxx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (itemStack2.getItem() == ((Block)ButcheryModBlocks.SMALL_SLIME_CARCASS.get()).asItem()) break block16;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)entity;
                        itemStack = _livEntxx.getOffhandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (itemStack.getItem() != ((Block)ButcheryModBlocks.SMALL_SLIME_CARCASS.get()).asItem()) break block14;
                }
                if (event instanceof ICancellableEvent) {
                    NeoEvent _cancellable = event;
                    _cancellable.setCanceled(true);
                }
                if (entity instanceof Player && !(_player2 = (Player)entity).level().isClientSide()) {
                    _player2.sendOverlayMessage((Component)Component.literal((String)"You can't hang a Slime, it will fall off!"));
                }
                break block14;
            }
            if (event instanceof ICancellableEvent) {
                NeoEvent _cancellable = event;
                _cancellable.setCanceled(true);
            }
            if (entity instanceof Player && !(_player = (Player)entity).level().isClientSide()) {
                _player.sendOverlayMessage((Component)Component.literal((String)"You can't hang a Slime, it will fall off!"));
            }
        }
    }
}

