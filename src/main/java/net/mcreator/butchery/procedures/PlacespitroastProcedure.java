package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class PlacespitroastProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            PlacespitroastProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        PlacespitroastProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block20: {
            block23: {
                Player _plr;
                LivingEntity _entity;
                block21: {
                    block22: {
                        ItemStack itemStack;
                        if (entity == null) break block20;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity)entity;
                            itemStack = _livEnt.getMainHandItem();
                        } else {
                            itemStack = ItemStack.EMPTY;
                        }
                        if (itemStack.getItem() != ((Block)ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()).asItem()) break block20;
                        if (event instanceof ICancellableEvent) {
                            NeoEvent _cancellable = event;
                            _cancellable.setCanceled(true);
                        }
                        if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 2.0), (double)z)).getBlock() != Blocks.AIR || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == Blocks.CAMPFIRE) break block21;
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        world.setBlock(BlockPos.containing((double)x, (double)(y + 2.0), (double)z), PlacespitroastProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()).defaultBlockState(), entity.getDirection()), 3);
                        if (world instanceof Level) {
                            Level _level = (Level)world;
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (!(entity instanceof Player)) break block22;
                        _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) break block20;
                    }
                    if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get());
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
                    }
                    break block20;
                }
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() != Blocks.AIR || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != Blocks.CAMPFIRE) break block20;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                world.setBlock(BlockPos.containing((double)x, (double)(y + 1.0), (double)z), PlacespitroastProcedure.blockStateWithDirection(((Block)ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()).defaultBlockState(), entity.getDirection()), 3);
                if (world instanceof Level) {
                    Level _levelx = (Level)world;
                    if (!_levelx.isClientSide()) {
                        _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                    } else {
                        _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.stone.place")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                    }
                }
                if (!(entity instanceof Player)) break block23;
                _plr = (Player)entity;
                if (_plr.getAbilities().instabuild) break block20;
            }
            if (entity instanceof Player) {
                Player _player = (Player)entity;
                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, (Container)_player.inventoryMenu.getCraftSlots());
            }
        }
    }

    private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
        EnumProperty enumProperty;
        EnumProperty enumProperty2;
        Property property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property instanceof EnumProperty && (enumProperty2 = (EnumProperty)property).getPossibleValues().contains(newValue)) {
            return (BlockState)blockState.setValue((Property)enumProperty2, (Comparable)newValue);
        }
        Property property2 = blockState.getBlock().getStateDefinition().getProperty("axis");
        return property2 instanceof EnumProperty && (enumProperty = (EnumProperty)property2).getPossibleValues().contains(newValue.getAxis()) ? (BlockState)blockState.setValue((Property)enumProperty, (Comparable)newValue.getAxis()) : blockState;
    }
}

