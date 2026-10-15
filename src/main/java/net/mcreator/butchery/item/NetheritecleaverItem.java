package net.mcreator.butchery.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class NetheritecleaverItem
extends Item {
    private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 2032, 9.0f, 0.0f, 15, TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:netherite_cleaver_repair_items")));

    public NetheritecleaverItem(Item.Properties properties) {
        super(properties.sword(TOOL_MATERIAL, 6.0f, -2.2f));
    }
}

