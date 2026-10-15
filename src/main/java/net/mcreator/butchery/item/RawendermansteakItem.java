package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class RawendermansteakItem
extends Item {
    public RawendermansteakItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.3f).build()));
    }
}

