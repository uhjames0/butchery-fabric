package net.mcreator.butchery.item;

import net.mcreator.butchery.procedures.PoisonsacPlayerFinishesUsingItemProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PoisonsacItem
extends Item {
    public PoisonsacItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build()));
    }

    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        PoisonsacPlayerFinishesUsingItemProcedure.execute((Entity)entity);
        return retval;
    }
}

