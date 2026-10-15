package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class CookedchickenwingItem
extends Item {
    public CookedchickenwingItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.5f).build()).usingConvertsTo(Items.BONE));
    }
}

