package net.mcreator.butchery.item;

import java.util.Map;
import net.mcreator.butchery.procedures.PiglinbrutearmorChestplateTickEventProcedure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
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
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.jetbrains.annotations.Nullable;

public abstract class PiglinbrutearmorItem extends Item {
   public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(
      15,
      Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 2, ArmorType.BODY, 6),
      9,
      BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY),
      0.0F,
      0.0F,
      TagKey.create(Registries.ITEM, Identifier.parse("butchery:piglin_brute_armor_repair_items")),
      ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.parse("butchery:piglin_brute_armor"))
   );

   private PiglinbrutearmorItem(Properties properties) {
      super(properties);
   }

   public static class Chestplate extends PiglinbrutearmorItem {
      public Chestplate(Properties properties) {
         super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
      }

      public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
         super.inventoryTick(itemstack, world, entity, equipmentSlot);
         if (entity instanceof Player player && equipmentSlot != null && equipmentSlot.getType() == Type.HUMANOID_ARMOR) {
            PiglinbrutearmorChestplateTickEventProcedure.execute(entity);
         }
      }
   }
}
