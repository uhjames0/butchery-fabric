package net.mcreator.butchery.item;

import net.mcreator.butchery.procedures.RavagerplaceProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;

public class RavagercarcassItem
extends Item {
    public RavagercarcassItem(Item.Properties properties) {
        super(properties.stacksTo(8));
    }

    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        RavagerplaceProcedure.execute((LevelAccessor)context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), (Entity)context.getPlayer());
        return InteractionResult.SUCCESS;
    }
}

