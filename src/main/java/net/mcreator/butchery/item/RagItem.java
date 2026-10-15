package net.mcreator.butchery.item;

import com.mojang.serialization.MapCodec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mcreator.butchery.procedures.RagpropertyvalueproviderProcedure;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import org.jetbrains.annotations.Nullable;

public class RagItem extends Item {
   public RagItem(Properties properties) {
      super(properties.stacksTo(1));
   }

   @Environment(EnvType.CLIENT)
   public record WetnessProperty() implements RangeSelectItemModelProperty {
      public static final MapCodec<RagItem.WetnessProperty> MAP_CODEC = MapCodec.unit(new RagItem.WetnessProperty());

      public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner entity, int seed) {
         return (float)RagpropertyvalueproviderProcedure.execute(itemStackToRender);
      }

      public MapCodec<RagItem.WetnessProperty> type() {
         return MAP_CODEC;
      }
   }
}
