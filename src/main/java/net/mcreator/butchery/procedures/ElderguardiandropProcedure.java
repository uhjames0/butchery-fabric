package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class ElderguardiandropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            ElderguardiandropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        ElderguardiandropProcedure.execute(null, world, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, Entity entity, Entity sourceentity) {
        block12: {
            block13: {
                block14: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    ItemStack itemStack3;
                    ItemStack itemStack4;
                    if (entity == null || sourceentity == null || !(entity instanceof ElderGuardian) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:elder_guardian"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:elder_guardian"))) || !ButcheryconfigConfiguration.ELDER_GUARDIAN_CARCASS.get().booleanValue()) break block12;
                    if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block13;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxxx = (LivingEntity)sourceentity;
                        itemStack4 = _livEntxxx.getMainHandItem();
                    } else {
                        itemStack4 = ItemStack.EMPTY;
                    }
                    if (itemStack4.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) break block14;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)sourceentity;
                        itemStack3 = _livEntxx.getMainHandItem();
                    } else {
                        itemStack3 = ItemStack.EMPTY;
                    }
                    if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) break block14;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                        itemStack2 = _livEntx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (itemStack2.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) != 0) break block14;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        itemStack = _livEnt.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:hunter")))) == 0) break block12;
                }
                if (entity instanceof ElderGuardian) {
                    ButcheryMod.queueServerWork(10, () -> world.setBlock(BlockPos.containing((double)entity.getX(), (double)(entity.getY() + 1.0), (double)entity.getZ()), ((Block)ButcheryModBlocks.ELDER_GUARDIAN_CARCASS.get()).defaultBlockState(), 3));
                }
                break block12;
            }
            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue() && entity instanceof ElderGuardian) {
                ButcheryMod.queueServerWork(10, () -> world.setBlock(BlockPos.containing((double)entity.getX(), (double)(entity.getY() + 1.0), (double)entity.getZ()), ((Block)ButcheryModBlocks.ELDER_GUARDIAN_CARCASS.get()).defaultBlockState(), 3));
            }
        }
    }
}

