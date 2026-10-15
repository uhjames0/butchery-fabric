package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedporklegItem
extends Item {
    public CookedporklegItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).build()));
    }
}

