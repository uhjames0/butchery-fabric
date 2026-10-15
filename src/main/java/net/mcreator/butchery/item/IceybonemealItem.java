package net.mcreator.butchery.item;

import java.util.function.Consumer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

public class IceybonemealItem
extends Item {
    public IceybonemealItem(Item.Properties properties) {
        super(properties);
    }

    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
        componentConsumer.accept((Component)Component.translatable((String)"item.butchery.icey_bone_meal.description_0"));
    }
}

