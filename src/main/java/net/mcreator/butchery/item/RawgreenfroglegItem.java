package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class RawgreenfroglegItem
extends Item {
    public RawgreenfroglegItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build()).usingConvertsTo(Items.BONE));
    }
}

