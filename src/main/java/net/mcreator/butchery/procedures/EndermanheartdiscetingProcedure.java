package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.mcreator.butchery.shim.itemcap.ItemHandlerHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

public class EndermanheartdiscetingProcedure {
    public static void onRightClickItem(ShimEvent.RightClickItemShim event) {
        if (event.getHand() == event.getEntity().getUsedItemHand()) {
            EndermanheartdiscetingProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        EndermanheartdiscetingProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block20: {
            block22: {
                block21: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    if (entity == null) break block20;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)entity;
                        itemStack2 = _livEntx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (!itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:knives")))) break block20;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        itemStack = _livEnt.getOffhandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (itemStack.getItem() != ButcheryModItems.ENDERMAN_HEART.get()) break block20;
                    if (event instanceof ICancellableEvent) {
                        NeoEvent _cancellable = event;
                        _cancellable.setCanceled(true);
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (!(entity instanceof Player)) break block21;
                    Player _plr = (Player)entity;
                    if (_plr.getAbilities().instabuild) break block22;
                }
                if (world instanceof ServerLevel) {
                    ItemStack itemStack;
                    ServerLevel _level = (ServerLevel)world;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)entity;
                        itemStack = _livEntxx.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    itemStack.hurtAndBreak(1, _level, null, _stkprov -> {});
                }
                if (entity instanceof LivingEntity) {
                    ItemStack itemStack;
                    LivingEntity _entity = (LivingEntity)entity;
                    ItemStack _setstack10 = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN_HEART.get()).copy();
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)entity;
                        itemStack = _livEntxx.getOffhandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    _setstack10.setCount(itemStack.getCount() - 1);
                    _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack10);
                    if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                    }
                }
            }
            if (entity instanceof Player) {
                Player _player = (Player)entity;
                ItemStack _setstack = new ItemStack((ItemLike)Items.ENDER_PEARL).copy();
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
            if (world instanceof Level) {
                Level _level = (Level)world;
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.sculk_vein.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.sculk_vein.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
        }
    }
}

