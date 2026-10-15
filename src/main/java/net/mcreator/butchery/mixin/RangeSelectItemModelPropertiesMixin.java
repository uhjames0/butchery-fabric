package net.mcreator.butchery.mixin;

import com.mojang.serialization.MapCodec;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.item.CoinItem.AmountProperty;
import net.mcreator.butchery.item.MagmachunksItem.MultipleProperty;
import net.mcreator.butchery.item.RagItem.WetnessProperty;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs.LateBoundIdMapper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RangeSelectItemModelProperties.class})
public abstract class RangeSelectItemModelPropertiesMixin {
   @Shadow
   @Final
   private static LateBoundIdMapper<Identifier, MapCodec<? extends RangeSelectItemModelProperty>> ID_MAPPER;

   @Inject(
      method = {"bootstrap"},
      at = {@At("TAIL")}
   )
   private static void butchery$registerItemModelProperties(CallbackInfo ci) {
      ID_MAPPER.put(Identifier.fromNamespaceAndPath("butchery", "coin/amount"), AmountProperty.MAP_CODEC);
      ID_MAPPER.put(Identifier.fromNamespaceAndPath("butchery", "rag/wetness"), WetnessProperty.MAP_CODEC);
      ID_MAPPER.put(Identifier.fromNamespaceAndPath("butchery", "sponge/wetness"), net.mcreator.butchery.item.SpongeItem.WetnessProperty.MAP_CODEC);
      ID_MAPPER.put(Identifier.fromNamespaceAndPath("butchery", "magma_chunks/multiple"), MultipleProperty.MAP_CODEC);
      ID_MAPPER.put(Identifier.fromNamespaceAndPath("butchery", "slime_chunks/multiple"), net.mcreator.butchery.item.SlimechunksItem.MultipleProperty.MAP_CODEC);
      ID_MAPPER.put(
         Identifier.fromNamespaceAndPath("butchery", "raw_endermite_chunks/multiple"),
         net.mcreator.butchery.item.RawendermitechunksItem.MultipleProperty.MAP_CODEC
      );
      ID_MAPPER.put(
         Identifier.fromNamespaceAndPath("butchery", "raw_silverfish_chunks/multiple"),
         net.mcreator.butchery.item.RawsilverfishchunksItem.MultipleProperty.MAP_CODEC
      );
      ID_MAPPER.put(
         Identifier.fromNamespaceAndPath("butchery", "cooked_endermite_chunks/multiple"),
         net.mcreator.butchery.item.CookedendermitechunksItem.MultipleProperty.MAP_CODEC
      );
      ID_MAPPER.put(
         Identifier.fromNamespaceAndPath("butchery", "cooked_silverfish_chunks/multiple"),
         net.mcreator.butchery.item.CookedSilverfishchunksItem.MultipleProperty.MAP_CODEC
      );
      ButcheryMod.LOGGER.debug("[Butchery] item model properties registered");
   }
}
