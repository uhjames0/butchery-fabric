package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedporkshoulderItem
extends Item {
    public CookedporkshoulderItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.5f).build()));
    }
}

