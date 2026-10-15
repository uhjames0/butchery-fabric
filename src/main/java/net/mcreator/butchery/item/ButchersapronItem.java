package net.mcreator.butchery.item;

import java.util.Map;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;

public abstract class ButchersapronItem extends Item {
   public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(
      3,
      Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 2, ArmorType.BODY, 0),
      9,
      BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY),
      0.0F,
      0.0F,
      TagKey.create(Registries.ITEM, Identifier.parse("butchery:butchers_apron_repair_items")),
      ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.parse("butchery:butchers_apron"))
   );

   private ButchersapronItem(Properties properties) {
      super(properties);
   }

   public static class Chestplate extends ButchersapronItem {
      public Chestplate(Properties properties) {
         super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
      }
   }
}
