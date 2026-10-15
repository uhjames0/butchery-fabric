package net.mcreator.butchery.item;

import java.util.function.Consumer;
import net.mcreator.butchery.procedures.MagicwishbonebreakProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class MagicWishboneItem
extends Item {
    public MagicWishboneItem(Item.Properties properties) {
        super(properties.rarity(Rarity.EPIC).stacksTo(16));
    }

    public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
        return ItemUseAnimation.BOW;
    }

    public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
        return 24;
    }

    public boolean isFoil(ItemStack itemstack) {
        return true;
    }

    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
        componentConsumer.accept((Component)Component.translatable((String)"item.butchery.magic_wishbone.description_0"));
    }

    public InteractionResult use(Level world, Player entity, InteractionHand hand) {
        InteractionResult ar = super.use(world, entity, hand);
        entity.startUsingItem(hand);
        MagicwishbonebreakProcedure.execute((LevelAccessor)world, entity.getX(), entity.getY(), entity.getZ(), (Entity)entity);
        return ar;
    }
}

