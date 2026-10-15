package net.mcreator.butchery.item;

import net.mcreator.butchery.procedures.FrogheartPlayerFinishesUsingItemProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FrogheartItem
extends Item {
    public FrogheartItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.3f).build()));
    }

    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        FrogheartPlayerFinishesUsingItemProcedure.execute((Entity)entity);
        return retval;
    }
}

