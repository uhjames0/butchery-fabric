package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PillagermaskProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            PillagermaskProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        PillagermaskProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.PILLAGER_HEAD.get()) {
            ItemStack itemStack;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity)entity;
                itemStack = _livEnt.getMainHandItem();
            } else {
                itemStack = ItemStack.EMPTY;
            }
            if (itemStack.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"butchery:skinning_knife")))) {
                ItemEntity entityToSpawn;
                ServerLevel _level;
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                world.levelEvent(2001, BlockPos.containing((double)x, (double)y, (double)z), Block.getId((BlockState)((Block)ButcheryModBlocks.PILLAGER_HEAD.get()).defaultBlockState()));
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.PILLAGER_ARMOR_HELMET.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)Items.BONE_MEAL));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModItems.EYE.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)ButcheryModBlocks.BRAIN.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity((Entity)entityToSpawn);
                }
            }
        }
    }
}

