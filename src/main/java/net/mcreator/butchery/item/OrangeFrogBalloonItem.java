package net.mcreator.butchery.item;

import net.mcreator.butchery.procedures.SlowfallingballoonProcedure;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class OrangeFrogBalloonItem
extends Item {
    public OrangeFrogBalloonItem(Item.Properties properties) {
        super(properties.stacksTo(1));
    }

    public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
        super.inventoryTick(itemstack, world, entity, equipmentSlot);
        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            SlowfallingballoonProcedure.execute(entity);
        }
    }
}

