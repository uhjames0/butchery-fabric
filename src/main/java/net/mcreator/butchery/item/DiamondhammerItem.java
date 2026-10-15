package net.mcreator.butchery.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class DiamondhammerItem
extends Item {
    private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 1561, 8.0f, 0.0f, 10, TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:diamond_hammer_repair_items")));

    public DiamondhammerItem(Item.Properties properties) {
        super(properties.pickaxe(TOOL_MATERIAL, 6.0f, -2.8f));
    }
}

