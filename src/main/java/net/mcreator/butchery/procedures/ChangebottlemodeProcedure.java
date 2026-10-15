package net.mcreator.butchery.procedures;

import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import org.jetbrains.annotations.Nullable;

public class ChangebottlemodeProcedure {
    public static void onRightClickItem(ShimEvent.RightClickItemShim event) {
        if (event.getHand() == event.getEntity().getUsedItemHand()) {
            ChangebottlemodeProcedure.execute(event, (Entity)event.getEntity());
        }
    }

    public static void execute(Entity entity) {
        ChangebottlemodeProcedure.execute(null, entity);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void execute(@Nullable NeoEvent event, Entity entity) {
        ItemStack itemStack;
        ItemStack itemStack2;
        ItemStack itemStack3;
        ItemStack itemStack4;
        ItemStack itemStack5;
        ItemStack itemStack6;
        if (entity == null) return;
        if (!entity.isShiftKeyDown()) return;
        if (entity instanceof LivingEntity) {
            LivingEntity _livEntx = (LivingEntity)entity;
            itemStack6 = _livEntx.getMainHandItem();
        } else {
            itemStack6 = ItemStack.EMPTY;
        }
        if (itemStack6.getItem() == Items.GLASS_BOTTLE) {
            ItemStack itemStack7;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity)entity;
                itemStack7 = _livEnt.getMainHandItem();
            } else {
                itemStack7 = ItemStack.EMPTY;
            }
            if (((CustomData)itemStack7.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) == 0.0) {
                ItemStack itemStack8;
                String _tagName = "bucketVersion";
                double _tagValue = 1.0;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntxx = (LivingEntity)entity;
                    itemStack8 = _livEntxx.getMainHandItem();
                } else {
                    itemStack8 = ItemStack.EMPTY;
                }
                CustomData.update((DataComponentType)DataComponents.CUSTOM_DATA, (ItemStack)itemStack8, tag -> tag.putDouble("bucketVersion", 1.0));
                if (!(entity instanceof Player)) return;
                Player _player = (Player)entity;
                if (_player.level().isClientSide()) return;
                _player.sendOverlayMessage((Component)Component.literal((String)"Bucket Mode: \u00a74Blood Magic "));
                return;
            }
        }
        if (entity instanceof LivingEntity) {
            LivingEntity _livEntxxx = (LivingEntity)entity;
            itemStack5 = _livEntxxx.getMainHandItem();
        } else {
            itemStack5 = ItemStack.EMPTY;
        }
        if (itemStack5.getItem() == Items.GLASS_BOTTLE) {
            ItemStack itemStack9;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEntxx = (LivingEntity)entity;
                itemStack9 = _livEntxx.getMainHandItem();
            } else {
                itemStack9 = ItemStack.EMPTY;
            }
            if (((CustomData)itemStack9.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) == 1.0) {
                ItemStack itemStack10;
                String _tagName = "bucketVersion";
                double _tagValue = 2.0;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntxxxx = (LivingEntity)entity;
                    itemStack10 = _livEntxxxx.getMainHandItem();
                } else {
                    itemStack10 = ItemStack.EMPTY;
                }
                CustomData.update((DataComponentType)DataComponents.CUSTOM_DATA, (ItemStack)itemStack10, tag -> tag.putDouble("bucketVersion", 2.0));
                if (!(entity instanceof Player)) return;
                Player _player = (Player)entity;
                if (_player.level().isClientSide()) return;
                _player.sendOverlayMessage((Component)Component.literal((String)"Bucket Mode: \u00a75Vampirism"));
                return;
            }
        }
        if (entity instanceof LivingEntity) {
            LivingEntity _livEntxxxxx = (LivingEntity)entity;
            itemStack4 = _livEntxxxxx.getMainHandItem();
        } else {
            itemStack4 = ItemStack.EMPTY;
        }
        if (itemStack4.getItem() == Items.GLASS_BOTTLE) {
            ItemStack itemStack11;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEntxxxx = (LivingEntity)entity;
                itemStack11 = _livEntxxxx.getMainHandItem();
            } else {
                itemStack11 = ItemStack.EMPTY;
            }
            if (((CustomData)itemStack11.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) == 2.0) {
                ItemStack itemStack12;
                String _tagName = "bucketVersion";
                double _tagValue = 3.0;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntxxxxxx = (LivingEntity)entity;
                    itemStack12 = _livEntxxxxxx.getMainHandItem();
                } else {
                    itemStack12 = ItemStack.EMPTY;
                }
                CustomData.update((DataComponentType)DataComponents.CUSTOM_DATA, (ItemStack)itemStack12, tag -> tag.putDouble("bucketVersion", 3.0));
                if (!(entity instanceof Player)) return;
                Player _player = (Player)entity;
                if (_player.level().isClientSide()) return;
                _player.sendOverlayMessage((Component)Component.literal((String)"Bucket Mode: \u00a76Hexerei"));
                return;
            }
        }
        if (entity instanceof LivingEntity) {
            LivingEntity _livEntxxxxxxx = (LivingEntity)entity;
            itemStack3 = _livEntxxxxxxx.getMainHandItem();
        } else {
            itemStack3 = ItemStack.EMPTY;
        }
        if (itemStack3.getItem() != Items.GLASS_BOTTLE) return;
        if (entity instanceof LivingEntity) {
            LivingEntity _livEntxxxxxx = (LivingEntity)entity;
            itemStack2 = _livEntxxxxxx.getMainHandItem();
        } else {
            itemStack2 = ItemStack.EMPTY;
        }
        if (((CustomData)itemStack2.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) != 3.0) return;
        String _tagName = "bucketVersion";
        double _tagValue = 0.0;
        if (entity instanceof LivingEntity) {
            LivingEntity _livEntxxxxxxxx = (LivingEntity)entity;
            itemStack = _livEntxxxxxxxx.getMainHandItem();
        } else {
            itemStack = ItemStack.EMPTY;
        }
        CustomData.update((DataComponentType)DataComponents.CUSTOM_DATA, (ItemStack)itemStack, tag -> tag.putDouble("bucketVersion", 0.0));
        if (!(entity instanceof Player)) return;
        Player _player = (Player)entity;
        if (_player.level().isClientSide()) return;
        _player.sendOverlayMessage((Component)Component.literal((String)"Bucket Mode: Vanilla"));
    }
}

