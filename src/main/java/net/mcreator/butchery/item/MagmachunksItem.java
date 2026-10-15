package net.mcreator.butchery.item;

import com.mojang.serialization.MapCodec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mcreator.butchery.procedures.MagmachunksPlayerFinishesUsingItemProcedure;
import net.mcreator.butchery.procedures.MagmachunksPropertyValueProviderProcedure;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class MagmachunksItem extends Item {
   public MagmachunksItem(Properties properties) {
      super(properties.food(new Builder().nutrition(8).saturationModifier(0.3F).build()));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      MagmachunksPlayerFinishesUsingItemProcedure.execute(entity);
      return retval;
   }

   @Environment(EnvType.CLIENT)
   public record MultipleProperty() implements RangeSelectItemModelProperty {
      public static final MapCodec<MagmachunksItem.MultipleProperty> MAP_CODEC = MapCodec.unit(new MagmachunksItem.MultipleProperty());

      public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner entity, int seed) {
         return (float)MagmachunksPropertyValueProviderProcedure.execute(itemStackToRender);
      }

      public MapCodec<MagmachunksItem.MultipleProperty> type() {
         return MAP_CODEC;
      }
   }
}
