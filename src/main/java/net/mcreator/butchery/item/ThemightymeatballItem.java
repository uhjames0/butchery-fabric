package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ThemightymeatballItem
extends Item {
    public ThemightymeatballItem(Item.Properties properties) {
        super(properties.rarity(Rarity.EPIC).stacksTo(1).food(new FoodProperties.Builder().nutrition(1000).saturationModifier(10.0f).build()));
    }

    public boolean isFoil(ItemStack itemstack) {
        return true;
    }
}

