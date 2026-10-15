package net.mcreator.butchery.item;

import net.mcreator.butchery.init.ButcheryModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;

public class InfectedBloodItem
extends BucketItem {
    public InfectedBloodItem(Item.Properties properties) {
        super((Fluid)ButcheryModFluids.INFECTED_BLOOD.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1));
    }
}

