package net.mcreator.butchery.item;

import com.mojang.serialization.MapCodec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mcreator.butchery.procedures.RawslimechunksPropertyValueProviderProcedure;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import org.jetbrains.annotations.Nullable;

public class SlimechunksItem extends Item {
   public SlimechunksItem(Properties properties) {
      super(properties.food(new Builder().nutrition(7).saturationModifier(0.3F).build()));
   }

   @Environment(EnvType.CLIENT)
   public record MultipleProperty() implements RangeSelectItemModelProperty {
      public static final MapCodec<SlimechunksItem.MultipleProperty> MAP_CODEC = MapCodec.unit(new SlimechunksItem.MultipleProperty());

      public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner entity, int seed) {
         return (float)RawslimechunksPropertyValueProviderProcedure.execute(itemStackToRender);
      }

      public MapCodec<SlimechunksItem.MultipleProperty> type() {
         return MAP_CODEC;
      }
   }
}
