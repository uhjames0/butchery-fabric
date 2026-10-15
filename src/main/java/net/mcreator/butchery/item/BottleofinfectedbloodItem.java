package net.mcreator.butchery.item;

import net.mcreator.butchery.procedures.BottleofbloodPlayerFinishesUsingItemProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.Level;

public class BottleofinfectedbloodItem
extends Item {
    public BottleofinfectedbloodItem(Item.Properties properties) {
        super(properties.stacksTo(16).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.3f).alwaysEdible().build(), Consumables.DEFAULT_DRINK));
    }

    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        BottleofbloodPlayerFinishesUsingItemProcedure.execute((Entity)entity);
        return retval;
    }
}

