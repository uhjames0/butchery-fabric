package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedporkbellyItem
extends Item {
    public CookedporkbellyItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.5f).build()));
    }
}

