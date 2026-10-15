package net.mcreator.butchery.init;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.minecraft.world.item.Item;

public class ButcheryModCompostables {
    public static void initCompostables() {
        Item[] items;
        float chance = 0.3f;
        for (Item item : items = new Item[]{(Item)ButcheryModItems.ROTTEN_HEART.get(), (Item)ButcheryModItems.ROTTEN_LUNGS.get(), (Item)ButcheryModItems.ROTTEN_KIDNEY.get(), (Item)ButcheryModItems.ROTTEN_LIVER.get(), (Item)ButcheryModItems.ROTTEN_INTESTINES.get(), (Item)ButcheryModItems.ROTTEN_STOMACH.get()}) {
            ButcheryMixinHooks.addCompostable(item, chance);
        }
        ButcheryMod.LOGGER.debug("[Butchery] compostables registered");
    }
}

