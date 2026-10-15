package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class RawporklegItem
extends Item {
    public RawporklegItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).build()));
    }
}

