package net.mcreator.butchery.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;

public class BrokenwishboneItem
extends Item {
    public BrokenwishboneItem(Item.Properties properties) {
        super(properties);
    }

    public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
        return ItemUseAnimation.BOW;
    }

    public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
        return 4;
    }

    public InteractionResult use(Level world, Player entity, InteractionHand hand) {
        InteractionResult ar = super.use(world, entity, hand);
        entity.startUsingItem(hand);
        return ar;
    }
}

