package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.itemcap.ItemHandlerHelper;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class BottleofbloodPlayerFinishesUsingItemProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            Player _player;
            if (entity instanceof Player) {
                _player = (Player)entity;
                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.BOTTLE_OF_BLOOD.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
            }
            if (entity instanceof Player) {
                _player = (Player)entity;
                ItemStack _setstack = new ItemStack((ItemLike)Items.GLASS_BOTTLE).copy();
                _setstack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
        }
    }
}

