package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryVariants;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ChickenwishbonepluckProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            ChickenwishbonepluckProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        ChickenwishbonepluckProcedure.execute(null, world, x, y, z, entity);
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
            if (itemStack.getItem() == Blocks.AIR.asItem() && ButcheryVariants.isDrainedChickenCarcass(world, x, y, z) && !ChickenwishbonepluckProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "wishboneRemoved")) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        ButcheryPersistentData.of(_blockEntity).putBoolean("wishboneRemoved", true);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }
                if (world instanceof Level) {
                    Level _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:wishbone_break")), SoundSource.NEUTRAL, 0.2f, 1.0f);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:wishbone_break")), SoundSource.NEUTRAL, 0.2f, 1.0f, false);
                    }
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                if (Math.random() <= ButcheryconfigConfiguration.WISHBONE_CHANCE.get()) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelx = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity((Level)_levelx, x, y + 1.0, z, new ItemStack((ItemLike)ButcheryModItems.WISHBONE.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _levelx.addFreshEntity((Entity)entityToSpawn);
                    }
                } else if (world instanceof ServerLevel) {
                    ServerLevel _levelx = (ServerLevel)world;
                    ItemEntity entityToSpawn = new ItemEntity((Level)_levelx, x, y + 1.0, z, new ItemStack((ItemLike)ButcheryModItems.BROKEN_WISHBONE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _levelx.addFreshEntity((Entity)entityToSpawn);
                }
            }
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
    }
}

