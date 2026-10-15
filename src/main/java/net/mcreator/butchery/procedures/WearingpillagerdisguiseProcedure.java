package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.init.ButcheryModMobEffects;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: WearingpillagerdisguiseProcedure.class */
public class WearingpillagerdisguiseProcedure {
    public static void execute(Entity entity) {
        ItemStack itemBySlot;
        ItemStack itemBySlot2;
        ItemStack itemBySlot3;
        ItemStack itemBySlot4;
        if (entity != null) {
            if (entity instanceof LivingEntity) {
                LivingEntity _entGetArmorxxx = (LivingEntity) entity;
                itemBySlot = _entGetArmorxxx.getItemBySlot(EquipmentSlot.HEAD);
            } else {
                itemBySlot = ItemStack.EMPTY;
            }
            if (itemBySlot.getItem() == ButcheryModItems.PILLAGER_ARMOR_HELMET.get()) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _entGetArmorxx = (LivingEntity) entity;
                    itemBySlot2 = _entGetArmorxx.getItemBySlot(EquipmentSlot.CHEST);
                } else {
                    itemBySlot2 = ItemStack.EMPTY;
                }
                if (itemBySlot2.getItem() == ButcheryModItems.PILLAGER_ARMOR_CHESTPLATE.get()) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmorx = (LivingEntity) entity;
                        itemBySlot3 = _entGetArmorx.getItemBySlot(EquipmentSlot.LEGS);
                    } else {
                        itemBySlot3 = ItemStack.EMPTY;
                    }
                    if (itemBySlot3.getItem() == ButcheryModItems.PILLAGER_ARMOR_LEGGINGS.get()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entGetArmor = (LivingEntity) entity;
                            itemBySlot4 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                        } else {
                            itemBySlot4 = ItemStack.EMPTY;
                        }
                        if (itemBySlot4.getItem() == ButcheryModItems.PILLAGER_ARMOR_BOOTS.get() && (entity instanceof LivingEntity)) {
                            LivingEntity _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder((MobEffect) ButcheryModMobEffects.PILLAGERFRIEND.get()), 3, 1, false, false));
                            }
                        }
                    }
                }
            }
        }
    }
}
