package net.mcreator.butchery.init;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.minecraft.world.item.Item;

public class ButcheryModFuels {
    public static void registerFuels() {
        ButcheryMixinHooks.addFuel((Item)ButcheryModItems.ANIMAL_FAT.get(), 650);
        ButcheryMod.LOGGER.debug("[Butchery] fuels registered");
    }
}

