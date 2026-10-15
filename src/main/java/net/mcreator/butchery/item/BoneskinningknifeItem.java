package net.mcreator.butchery.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class BoneskinningknifeItem
extends Item {
    private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 59, 2.0f, 0.0f, 15, TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:bone_skinning_knife_repair_items")));

    public BoneskinningknifeItem(Item.Properties properties) {
        super(properties.sword(TOOL_MATERIAL, 2.0f, -2.2f));
    }
}

