package net.mcreator.butchery.item;

import net.mcreator.butchery.procedures.CashregisterRightclickedOnBlockProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;

public class CashregisterItem
extends Item {
    public CashregisterItem(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        CashregisterRightclickedOnBlockProcedure.execute((LevelAccessor)context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), (Entity)context.getPlayer());
        return InteractionResult.SUCCESS;
    }
}

