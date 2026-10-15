package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class RavagerdropProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            RavagerdropProcedure.execute(event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        RavagerdropProcedure.execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        block12: {
            block13: {
                block14: {
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    ItemStack itemStack3;
                    if (entity == null || sourceentity == null || !(entity instanceof Ravager) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"forge:ravager"))) && !entity.getType().builtInRegistryHolder().is(TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.parse((String)"c:ravager"))) || !ButcheryconfigConfiguration.RAVAGER_CARCASS.get().booleanValue()) break block12;
                    if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue()) break block13;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)sourceentity;
                        itemStack3 = _livEntxx.getMainHandItem();
                    } else {
                        itemStack3 = ItemStack.EMPTY;
                    }
                    if (itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) break block14;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                        itemStack2 = _livEntx.getMainHandItem();
                    } else {
                        itemStack2 = ItemStack.EMPTY;
                    }
                    if (itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) break block14;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        itemStack = _livEnt.getMainHandItem();
                    } else {
                        itemStack = ItemStack.EMPTY;
                    }
                    if (itemStack.getEnchantments().getLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create((ResourceKey)Registries.ENCHANTMENT, (Identifier)Identifier.parse((String)"butchery:butcherstouch")))) == 0) break block12;
                }
                if (entity instanceof Ravager) {
                    if (event instanceof ICancellableEvent) {
                        NeoEvent _cancellable = event;
                        _cancellable.setCanceled(true);
                    }
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            FallingBlockEntity.fall((Level)_level, (BlockPos)BlockPos.containing((double)x, (double)y, (double)z), (BlockState)((Block)ButcheryModBlocks.RAVAGER.get()).defaultBlockState());
                        }
                    });
                }
                break block12;
            }
            if (!ButcheryconfigConfiguration.SPECIFIC_TOOLS.get().booleanValue() && entity instanceof Ravager) {
                if (event instanceof ICancellableEvent) {
                    NeoEvent _cancellable = event;
                    _cancellable.setCanceled(true);
                }
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        FallingBlockEntity.fall((Level)_level, (BlockPos)BlockPos.containing((double)x, (double)y, (double)z), (BlockState)((Block)ButcheryModBlocks.RAVAGER.get()).defaultBlockState());
                    }
                });
            }
        }
    }
}

