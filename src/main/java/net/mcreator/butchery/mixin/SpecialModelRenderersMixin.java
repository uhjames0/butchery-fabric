package net.mcreator.butchery.mixin;

import com.mojang.serialization.MapCodec;
import net.mcreator.butchery.ButcheryMod;
import net.minecraft.client.renderer.special.SpecialModelRenderers;
import net.minecraft.client.renderer.special.SpecialModelRenderer.Unbaked;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs.LateBoundIdMapper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({SpecialModelRenderers.class})
public abstract class SpecialModelRenderersMixin {
   @Shadow
   @Final
   private static LateBoundIdMapper<Identifier, MapCodec<? extends Unbaked<?>>> ID_MAPPER;

   @Inject(
      method = {"bootstrap"},
      at = {@At("TAIL")}
   )
   private static void butchery$registerSpecialModelRenderers(CallbackInfo ci) {
      ID_MAPPER.put(
         Identifier.fromNamespaceAndPath("butchery", "playercorpse"), net.mcreator.butchery.client.renderer.PlayercorpseItemRenderer.Unbaked.MAP_CODEC
      );
      ButcheryMod.LOGGER.debug("[Butchery] special item model renderers registered");
   }
}
