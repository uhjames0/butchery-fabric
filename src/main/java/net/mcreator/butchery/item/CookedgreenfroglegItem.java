package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class CookedgreenfroglegItem
extends Item {
    public CookedgreenfroglegItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.3f).build()).usingConvertsTo(Items.BONE));
    }
}

