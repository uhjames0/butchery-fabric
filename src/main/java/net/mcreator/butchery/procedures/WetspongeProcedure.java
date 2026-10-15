package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class WetspongeProcedure {
    public static void onRightClickItem(ShimEvent.RightClickItemShim event) {
        if (event.getHand() == event.getEntity().getUsedItemHand()) {
            WetspongeProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        WetspongeProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            ItemStack itemStack;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity)entity;
                itemStack = _livEnt.getMainHandItem();
            } else {
                itemStack = ItemStack.EMPTY;
            }
            if (itemStack.getItem() == ButcheryModItems.SPONGE.get() && entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getType() == HitResult.Type.BLOCK && world.getFluidState(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0f), entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getZ())).createLegacyBlock().getBlock() == Blocks.WATER) {
                ItemStack itemStack2;
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                if (world instanceof Level) {
                    Level _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.fishing_bobber.splash")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.fishing_bobber.splash")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                    }
                }
                String _tagName = "spongeWetness";
                double _tagValue = 10.0;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntx = (LivingEntity)entity;
                    itemStack2 = _livEntx.getMainHandItem();
                } else {
                    itemStack2 = ItemStack.EMPTY;
                }
                CustomData.update((DataComponentType)DataComponents.CUSTOM_DATA, (ItemStack)itemStack2, tag -> tag.putDouble("spongeWetness", 10.0));
            }
        }
    }
}

