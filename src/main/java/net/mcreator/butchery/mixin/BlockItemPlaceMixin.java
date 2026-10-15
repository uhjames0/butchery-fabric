package net.mcreator.butchery.mixin;

import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Fires the NeoForge-equivalent of BlockEvent.EntityPlaceEvent when a player
 * places a block. Required by SalttipplacedProcedure (salt formation growth:
 * placing a block on top of a salt formation tip extends the column
 * dripstone-style: tip -> frustum -> base/middle, new block becomes the tip).
 */
@Mixin(value={BlockItem.class})
public abstract class BlockItemPlaceMixin {
    @Inject(method={"place(Lnet/minecraft/world/item/context/BlockPlaceContext;)Lnet/minecraft/world/InteractionResult;"}, at={@At(value="TAIL")})
    private void butchery$afterBlockPlaced(BlockPlaceContext context, CallbackInfoReturnable<InteractionResult> cir) {
        InteractionResult result = (InteractionResult)cir.getReturnValue();
        if (result != null && result.consumesAction()) {
            // NeoForge's BlockEvent.EntityPlaceEvent fires for every entity placement
            // (player, dispenser, ...); the placing entity may be null (dispensers).
            if (!context.getLevel().isClientSide()) {
                ButcheryMixinHooks.onBlockPlaced(context.getPlayer(), context.getLevel(), context.getClickedPos());
            }
        }
    }
}
