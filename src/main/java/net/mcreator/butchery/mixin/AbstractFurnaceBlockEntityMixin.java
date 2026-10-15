package net.mcreator.butchery.mixin;

import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({AbstractFurnaceBlockEntity.class})
public class AbstractFurnaceBlockEntityMixin {
   @Inject(
      method = {"getBurnDuration(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/item/ItemStack;)I"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void butchery$burnTime(ServerLevel level, ItemStack stack, CallbackInfoReturnable<Integer> cir) {
      int t = ButcheryMixinHooks.getBurnTime(stack);
      if (t >= 0) {
         cir.setReturnValue(t);
      }
   }
}
