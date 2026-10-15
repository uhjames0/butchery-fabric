package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class HoneystomachItem
extends Item {
    public HoneystomachItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.3f).build()));
    }
}

