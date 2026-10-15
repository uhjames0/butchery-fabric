package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedporkloinItem
extends Item {
    public CookedporkloinItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.4f).build()));
    }
}

