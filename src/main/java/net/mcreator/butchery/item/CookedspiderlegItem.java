package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedspiderlegItem
extends Item {
    public CookedspiderlegItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f).build()));
    }
}

