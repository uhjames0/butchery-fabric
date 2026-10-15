package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class RawporkbellyItem
extends Item {
    public RawporkbellyItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.4f).build()));
    }
}

