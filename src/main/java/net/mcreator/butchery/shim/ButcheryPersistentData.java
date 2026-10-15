package net.mcreator.butchery.shim;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.mcreator.butchery.ButcheryMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: ButcheryPersistentData.class */
public class ButcheryPersistentData {
    public static final AttachmentType<CompoundTag> DATA = AttachmentRegistry.<CompoundTag>builder().persistent(CompoundTag.CODEC).copyOnDeath().buildAndRegister(Identifier.fromNamespaceAndPath(ButcheryMod.MODID, "persistent_data"));

    public static CompoundTag of(Object holder) {
        if (holder instanceof Entity) {
            Entity e = (Entity) holder;
            return (CompoundTag) e.getAttachedOrCreate(DATA, CompoundTag::new);
        }
        if (holder instanceof BlockEntity) {
            BlockEntity be = (BlockEntity) holder;
            return (CompoundTag) be.getAttachedOrCreate(DATA, CompoundTag::new);
        }
        return new CompoundTag();
    }

    public static void touch() {
    }
}
