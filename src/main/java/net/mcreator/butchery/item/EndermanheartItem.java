package net.mcreator.butchery.item;

import java.util.function.Consumer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

public class EndermanheartItem
extends Item {
    public EndermanheartItem(Item.Properties properties) {
        super(properties);
    }

    public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
        return ItemUseAnimation.EAT;
    }

    public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
        return 32;
    }

    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
        componentConsumer.accept((Component)Component.translatable((String)"item.butchery.enderman_heart.description_0"));
    }

    public InteractionResult use(Level world, Player entity, InteractionHand hand) {
        InteractionResult ar = super.use(world, entity, hand);
        entity.startUsingItem(hand);
        return ar;
    }
}

