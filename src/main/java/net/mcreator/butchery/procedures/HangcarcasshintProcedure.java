package net.mcreator.butchery.procedures;

import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class HangcarcasshintProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            HangcarcasshintProcedure.execute(event, (LevelAccessor)event.getLevel(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity entity) {
        HangcarcasshintProcedure.execute(null, world, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, Entity entity) {
        block11: {
            block12: {
                ItemStack itemStack;
                ItemStack itemStack2;
                if (entity == null) break block11;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntx = (LivingEntity)entity;
                    itemStack2 = _livEntx.getMainHandItem();
                } else {
                    itemStack2 = ItemStack.EMPTY;
                }
                if (itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) break block12;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    itemStack = _livEnt.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                if (!itemStack.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) break block11;
            }
            if (world.getBlockState(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass"))) || world.getBlockState(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:small_carcass")))) {
                Player _player;
                int n;
                Property property = world.getBlockState(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    IntegerProperty _getip18 = (IntegerProperty)property;
                    n = (Integer)world.getBlockState(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())).getValue((Property)_getip18);
                } else {
                    n = -1;
                }
                if (n == 0 && entity instanceof Player && !(_player = (Player)entity).level().isClientSide()) {
                    _player.sendOverlayMessage((Component)Component.literal((String)"This carcass needs hanging and bleeding first"));
                }
            }
        }
    }
}

