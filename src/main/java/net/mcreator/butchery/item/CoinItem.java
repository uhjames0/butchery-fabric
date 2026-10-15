package net.mcreator.butchery.item;

import com.mojang.serialization.MapCodec;
import java.util.function.Consumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mcreator.butchery.procedures.CoinpropertyvalueproviderProcedure;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jetbrains.annotations.Nullable;

public class CoinItem extends Item {
   public CoinItem(Properties properties) {
      super(properties.rarity(Rarity.UNCOMMON));
   }

   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(
      ItemStack itemstack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag
   ) {
      super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
      componentConsumer.accept(Component.translatable("item.butchery.coin.description_0"));
      componentConsumer.accept(Component.translatable("item.butchery.coin.description_1"));
   }

   @Environment(EnvType.CLIENT)
   public record AmountProperty() implements RangeSelectItemModelProperty {
      public static final MapCodec<CoinItem.AmountProperty> MAP_CODEC = MapCodec.unit(new CoinItem.AmountProperty());

      public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner entity, int seed) {
         return (float)CoinpropertyvalueproviderProcedure.execute(itemStackToRender);
      }

      public MapCodec<CoinItem.AmountProperty> type() {
         return MAP_CODEC;
      }
   }
}
