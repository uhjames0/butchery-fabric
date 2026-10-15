package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedmulesteakItem
extends Item {
    public CookedmulesteakItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.3f).build()));
    }
}

