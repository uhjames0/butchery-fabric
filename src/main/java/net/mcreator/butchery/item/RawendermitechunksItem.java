package net.mcreator.butchery.item;

import com.mojang.serialization.MapCodec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mcreator.butchery.procedures.RawendermitechunksPropertyValueProviderProcedure;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import org.jetbrains.annotations.Nullable;

public class RawendermitechunksItem extends Item {
   public RawendermitechunksItem(Properties properties) {
      super(properties.food(new Builder().nutrition(3).saturationModifier(0.3F).build()));
   }

   @Environment(EnvType.CLIENT)
   public record MultipleProperty() implements RangeSelectItemModelProperty {
      public static final MapCodec<RawendermitechunksItem.MultipleProperty> MAP_CODEC = MapCodec.unit(new RawendermitechunksItem.MultipleProperty());

      public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner entity, int seed) {
         return (float)RawendermitechunksPropertyValueProviderProcedure.execute(itemStackToRender);
      }

      public MapCodec<RawendermitechunksItem.MultipleProperty> type() {
         return MAP_CODEC;
      }
   }
}
