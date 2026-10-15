package net.mcreator.butchery.item;

import java.util.Map;
import java.util.function.Consumer;
import net.mcreator.butchery.procedures.StraynecklaceeffectProcedure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.jetbrains.annotations.Nullable;

public abstract class StraynecklaceItem extends Item {
   public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(
      0,
      Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 0, ArmorType.BODY, 0),
      9,
      BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY),
      0.0F,
      0.0F,
      TagKey.create(Registries.ITEM, Identifier.parse("butchery:stray_necklace_repair_items")),
      ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.parse("butchery:stray_necklace"))
   );

   private StraynecklaceItem(Properties properties) {
      super(properties);
   }

   public static class Chestplate extends StraynecklaceItem {
      public Chestplate(Properties properties) {
         super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
      }

      public void appendHoverText(
         ItemStack itemstack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag
      ) {
         super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
         componentConsumer.accept(Component.translatable("item.butchery.stray_necklace_chestplate.description_0"));
      }

      public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
         super.inventoryTick(itemstack, world, entity, equipmentSlot);
         if (entity instanceof Player player && equipmentSlot != null && equipmentSlot.getType() == Type.HUMANOID_ARMOR) {
            StraynecklaceeffectProcedure.execute(entity);
         }
      }
   }
}
