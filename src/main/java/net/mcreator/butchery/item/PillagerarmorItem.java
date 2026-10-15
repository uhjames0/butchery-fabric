package net.mcreator.butchery.item;

import java.util.Map;
import net.mcreator.butchery.procedures.WearingpillagerdisguiseProcedure;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.jetbrains.annotations.Nullable;

public abstract class PillagerarmorItem
extends Item {
    public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(5, Map.of(ArmorType.BOOTS, 1, ArmorType.LEGGINGS, 3, ArmorType.CHESTPLATE, 4, ArmorType.HELMET, 1, ArmorType.BODY, 4), 13, SoundEvents.ARMOR_EQUIP_LEATHER, 0.4f, 0.0f, TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:pillager_armor_repair_items")), ResourceKey.create((ResourceKey)EquipmentAssets.ROOT_ID, (Identifier)Identifier.parse((String)"butchery:pillager_armor")));

    private PillagerarmorItem(Item.Properties properties) {
        super(properties);
    }

    public static class Leggings
    extends PillagerarmorItem {
        public Leggings(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
        }
    }

    public static class Helmet
    extends PillagerarmorItem {
        public Helmet(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
        }

        public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
            super.inventoryTick(itemstack, world, entity, equipmentSlot);
            if (entity instanceof Player) {
                Player player = (Player)entity;
                if (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                    WearingpillagerdisguiseProcedure.execute(entity);
                }
            }
        }
    }

    public static class Chestplate
    extends PillagerarmorItem {
        public Chestplate(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
        }
    }

    public static class Boots
    extends PillagerarmorItem {
        public Boots(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
        }
    }
}

