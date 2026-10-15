package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class VindicatormasknoiseProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            ItemStack itemStack;
            if (entity instanceof LivingEntity) {
                LivingEntity _entGetArmor = (LivingEntity)entity;
                itemStack = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
                itemStack = ItemStack.EMPTY;
            }
            if (itemStack.getItem() == ButcheryModItems.PILLAGER_ARMOR_HELMET.get() && world instanceof Level) {
                Level _level = (Level)world;
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.vindicator.ambient")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                } else {
                    _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.vindicator.ambient")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
        }
    }
}

