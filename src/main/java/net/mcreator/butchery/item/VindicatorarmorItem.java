package net.mcreator.butchery.item;

import java.util.Map;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;

public abstract class VindicatorarmorItem
extends Item {
    public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(13, Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 2, ArmorType.BODY, 6), 13, SoundEvents.ARMOR_EQUIP_LEATHER, 0.6f, 0.0f, TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:vindicatorarmor_repair_items")), ResourceKey.create((ResourceKey)EquipmentAssets.ROOT_ID, (Identifier)Identifier.parse((String)"butchery:vindicatorarmor")));

    private VindicatorarmorItem(Item.Properties properties) {
        super(properties);
    }

    public static class Leggings
    extends VindicatorarmorItem {
        public Leggings(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
        }
    }

    public static class Helmet
    extends VindicatorarmorItem {
        public Helmet(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
        }
    }

    public static class Chestplate
    extends VindicatorarmorItem {
        public Chestplate(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
        }
    }

    public static class Boots
    extends VindicatorarmorItem {
        public Boots(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
        }
    }
}

