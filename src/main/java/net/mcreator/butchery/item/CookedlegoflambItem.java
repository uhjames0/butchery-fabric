package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class CookedlegoflambItem
extends Item {
    public CookedlegoflambItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).build()).usingConvertsTo(Items.BONE));
    }
}

