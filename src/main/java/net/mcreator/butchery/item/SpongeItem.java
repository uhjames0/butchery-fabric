package net.mcreator.butchery.item;

import com.mojang.serialization.MapCodec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mcreator.butchery.procedures.SpongepropertyvalueproviderProcedure;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import org.jetbrains.annotations.Nullable;

public class SpongeItem extends Item {
   public SpongeItem(Properties properties) {
      super(properties.durability(4062));
   }

   @Environment(EnvType.CLIENT)
   public record WetnessProperty() implements RangeSelectItemModelProperty {
      public static final MapCodec<SpongeItem.WetnessProperty> MAP_CODEC = MapCodec.unit(new SpongeItem.WetnessProperty());

      public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner entity, int seed) {
         return (float)SpongepropertyvalueproviderProcedure.execute(itemStackToRender);
      }

      public MapCodec<SpongeItem.WetnessProperty> type() {
         return MAP_CODEC;
      }
   }
}
