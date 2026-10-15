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

public abstract class WitchesclothesItem
extends Item {
    public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(3, Map.of(ArmorType.BOOTS, 1, ArmorType.LEGGINGS, 2, ArmorType.CHESTPLATE, 3, ArmorType.HELMET, 1, ArmorType.BODY, 3), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:witches_clothes_repair_items")), ResourceKey.create((ResourceKey)EquipmentAssets.ROOT_ID, (Identifier)Identifier.parse((String)"butchery:witches_clothes")));

    private WitchesclothesItem(Item.Properties properties) {
        super(properties);
    }

    public static class Helmet
    extends WitchesclothesItem {
        public Helmet(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
        }
    }

    public static class Chestplate
    extends WitchesclothesItem {
        public Chestplate(Item.Properties properties) {
            super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
        }
    }
}

