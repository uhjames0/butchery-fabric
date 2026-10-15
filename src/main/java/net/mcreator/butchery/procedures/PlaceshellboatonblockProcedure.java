package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModEntities;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class PlaceshellboatonblockProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            PlaceshellboatonblockProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        PlaceshellboatonblockProcedure.execute(null, world, x, y, z, entity);
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
            if (itemStack.getItem() == ((Block)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get()).asItem() && world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.WATER) {
                AdvancementHolder _adv;
                ServerPlayer _playerx;
                ServerLevel var27;
                ServerPlayer _plr9;
                ServerLevel var24;
                AdvancementProgress _ap;
                ServerPlayer _plr7;
                ServerLevel _player;
                boolean var32;
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                if (entity instanceof Player) {
                    Player _player2 = (Player)entity;
                    ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get());
                    _player2.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player2.inventoryMenu.getCraftSlots());
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    Entity entityToSpawn = ButcheryModEntities.TURTLESHELLBOAT.get().spawn(_level, BlockPos.containing((double)x, (double)(y + 1.0), (double)z), EntitySpawnReason.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
                if (!(var32 = entity instanceof ServerPlayer && (_player = (_plr7 = (ServerPlayer)entity).level()) instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:butcherssecrets"))).isDone()) && entity instanceof ServerPlayer) {
                    AdvancementHolder _advx;
                    ServerLevel _sl_player;
                    ServerLevel _adv2;
                    ServerPlayer _player3 = (ServerPlayer)entity;
                    ServerLevel serverLevel = _player3.level();
                    ServerLevel serverLevel2 = _adv2 = serverLevel instanceof ServerLevel ? (_sl_player = serverLevel) : null;
                    if (_adv2 instanceof ServerLevel && (_advx = _adv2.getServer().getAdvancements().get(Identifier.parse((String)"butchery:butcherssecrets"))) != null && !(_ap = _player3.getAdvancements().getOrStartProgress(_advx)).isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                            _player3.getAdvancements().award(_advx, criteria);
                        }
                    }
                }
                if (!(var32 = entity instanceof ServerPlayer && (var24 = (_plr9 = (ServerPlayer)entity).level()) instanceof ServerLevel && _plr9.getAdvancements().getOrStartProgress(var24.getServer().getAdvancements().get(Identifier.parse((String)"butchery:itsafloater"))).isDone()) && entity instanceof ServerPlayer && (var27 = (_playerx = (ServerPlayer)entity).level()) instanceof ServerLevel && (_adv = var27.getServer().getAdvancements().get(Identifier.parse((String)"butchery:itsafloater"))) != null && !(_ap = _playerx.getAdvancements().getOrStartProgress(_adv)).isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _playerx.getAdvancements().award(_adv, criteria);
                    }
                }
            }
        }
    }
}

