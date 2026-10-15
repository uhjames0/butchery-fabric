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

public abstract class DragonscalearmorItem
extends Item {
    public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(43, Map.of(ArmorType.BOOTS, 6, ArmorType.LEGGINGS, 8, ArmorType.CHESTPLATE, 11, ArmorType.HELMET, 6, ArmorType.BODY, 11), 22, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0f, 0.2f, TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:dragon_scale_armor_repair_items")), ResourceKey.create((ResourceKey)EquipmentAssets.ROOT_ID, (Identifier)Identifier.parse((String)"butchery:dragon_scale_armor")));

    private DragonscalearmorItem(Item.Properties properties) {
        super(properties);
    }

    public static class Leggings
    extends DragonscalearmorItem {
        public Leggings(Item.Properties properties) {
            super(properties.fireResistant().humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
        }
    }

    public static class Helmet
    extends DragonscalearmorItem {
        public Helmet(Item.Properties properties) {
            super(properties.fireResistant().humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
        }
    }

    public static class Chestplate
    extends DragonscalearmorItem {
        public Chestplate(Item.Properties properties) {
            super(properties.fireResistant().humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
        }
    }

    public static class Boots
    extends DragonscalearmorItem {
        public Boots(Item.Properties properties) {
            super(properties.fireResistant().humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
        }
    }
}

