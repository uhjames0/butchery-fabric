package net.mcreator.butchery.item;

import java.util.function.Consumer;
import net.mcreator.butchery.procedures.SculkbonemealrightclickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;

public class SculkbonemealItem
extends Item {
    public SculkbonemealItem(Item.Properties properties) {
        super(properties);
    }

    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
        componentConsumer.accept((Component)Component.translatable((String)"item.butchery.sculkbonemeal.description_0"));
    }

    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        SculkbonemealrightclickProcedure.execute((LevelAccessor)context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), (Entity)context.getPlayer());
        return InteractionResult.SUCCESS;
    }
}

