package net.mcreator.butchery.mixin;

import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ResultSlot.class})
public class ResultSlotMixin {
    @Shadow
    public Player player;
    @Shadow(aliases={"craftSlots", "field_7557"}, remap=true)
    private CraftingContainer craftSlots;

    @Inject(method={"checkTakeAchievements"}, at={@At(value="HEAD")})
    private void butchery$onCrafted(ItemStack stack, CallbackInfo ci) {
        try {
            ButcheryMixinHooks.onCrafted(this.player, stack, this.craftSlots);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

