package net.mcreator.butchery.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class IronhammerItem
extends Item {
    private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 250, 6.0f, 0.0f, 14, TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:iron_hammer_repair_items")));

    public IronhammerItem(Item.Properties properties) {
        super(properties.pickaxe(TOOL_MATERIAL, 5.0f, -2.8f));
    }
}

