package net.mcreator.butchery.procedures;

import java.util.Locale;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class CashregisterOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (CashregisterOnBlockRightClickedProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "registerOpen")) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        ButcheryPersistentData.of(_blockEntity).putBoolean("registerOpen", false);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }
                if (world instanceof Level) {
                    Level _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:drawer_close")), SoundSource.NEUTRAL, 0.6f, 1.0f);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:drawer_close")), SoundSource.NEUTRAL, 0.6f, 1.0f, false);
                    }
                }
            } else {
                ItemStack itemStack;
                if (!world.isClientSide()) {
                    BlockPos _bpx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                    BlockState _bsx = world.getBlockState(_bpx);
                    if (_blockEntityx != null) {
                        ButcheryPersistentData.of(_blockEntityx).putBoolean("registerOpen", true);
                    }
                    if (world instanceof Level) {
                        Level _levelx = (Level)world;
                        _levelx.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                    }
                }
                if (world instanceof Level) {
                    Level _levelx = (Level)world;
                    if (!_levelx.isClientSide()) {
                        _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:drawer_open")), SoundSource.NEUTRAL, 0.4f, 1.0f);
                    } else {
                        _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:drawer_open")), SoundSource.NEUTRAL, 0.4f, 1.0f, false);
                    }
                }
                if (world instanceof Level) {
                    Level _levelxx = (Level)world;
                    if (!_levelxx.isClientSide()) {
                        _levelxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:cha_ching")), SoundSource.NEUTRAL, 0.8f, 1.0f);
                    } else {
                        _levelxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:cha_ching")), SoundSource.NEUTRAL, 0.8f, 1.0f, false);
                    }
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    itemStack = _livEnt.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                if (itemStack.getItem() == ButcheryModItems.COIN.get()) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.COIN.get());
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                    }
                    if (world instanceof Level) {
                        Level _levelxxx = (Level)world;
                        if (!_levelxxx.isClientSide()) {
                            _levelxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:cha_ching")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:cha_ching")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    if (!world.isClientSide() && world.getServer() != null) {
                        for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.parse((String)ButcheryconfigConfiguration.COIN_LOOTTABLE.get().toLowerCase(Locale.ENGLISH)))).getRandomItems(new LootParams.Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))) {
                            if (!(world instanceof ServerLevel)) continue;
                            ServerLevel _levelxxxx = (ServerLevel)world;
                            ItemEntity entityToSpawn = new ItemEntity((Level)_levelxxxx, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _levelxxxx.addFreshEntity((Entity)entityToSpawn);
                        }
                    }
                }
            }
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
    }
}

