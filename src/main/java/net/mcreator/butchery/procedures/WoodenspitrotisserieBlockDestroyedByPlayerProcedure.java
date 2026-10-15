package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryVariants;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: WoodenspitrotisserieBlockDestroyedByPlayerProcedure.class */
public class WoodenspitrotisserieBlockDestroyedByPlayerProcedure {
    public static void onBlockBreak(ShimEvent.BreakShim event) {
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        if (entity != null) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()) {
                Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip3 = property;
                    iIntValue4 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip3)).intValue();
                } else {
                    iIntValue4 = -1;
                }
                if (iIntValue4 == 0) {
                    if (event instanceof ICancellableEvent) {
                        event.setCanceled(true);
                    }
                    world.destroyBlock(BlockPos.containing(x, y, z), false);
                    if (entity instanceof Player) {
                        Player _plr = (Player) entity;
                        if (_plr.getAbilities().instabuild) {
                            return;
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike) ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                        return;
                    }
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()) {
                Property<?> property2 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property2 instanceof IntegerProperty) {
                    Property<?> _getip10 = property2;
                    iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip10)).intValue();
                } else {
                    iIntValue3 = -1;
                }
                if (iIntValue3 == 1) {
                    if (event instanceof ICancellableEvent) {
                        event.setCanceled(true);
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                            ButcheryPersistentData.of(_blockEntity).putBoolean("mobCooking", false);
                            ButcheryPersistentData.of(_blockEntity).putDouble("Timer", 0.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                    }
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bsx = world.getBlockState(_pos);
                    Property<?> property3 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property3 instanceof IntegerProperty) {
                        IntegerProperty _integerProp = (IntegerProperty) property3;
                        if (_integerProp.getPossibleValues().contains(0)) {
                            world.setBlock(_pos, (BlockState) _bsx.setValue(_integerProp, 0), 3);
                        }
                    }
                    if (world instanceof Level) {
                        Level _level2 = (Level) world;
                        if (!_level2.isClientSide()) {
                            _level2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _level2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    if (entity instanceof Player) {
                        Player _plr2 = (Player) entity;
                        if (_plr2.getAbilities().instabuild) {
                            return;
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelx = (ServerLevel) world;
                        ItemEntity entityToSpawn2 = new ItemEntity(_levelx, x, y, z, new ItemStack((ItemLike) ButcheryVariants.spitRoastCarcassItem(world, BlockPos.containing(x, y, z))));
                        entityToSpawn2.setPickUpDelay(10);
                        _levelx.addFreshEntity(entityToSpawn2);
                        return;
                    }
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()) {
                Property<?> property4 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property4 instanceof IntegerProperty) {
                    Property<?> _getip20 = property4;
                    iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip20)).intValue();
                } else {
                    iIntValue2 = -1;
                }
                if (iIntValue2 == 2) {
                    if (event instanceof ICancellableEvent) {
                        event.setCanceled(true);
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bpx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                        BlockState _bsxx = world.getBlockState(_bpx);
                        if (_blockEntityx != null) {
                            ButcheryPersistentData.of(_blockEntityx).putBoolean("mobCooking", false);
                            ButcheryPersistentData.of(_blockEntityx).putDouble("Timer", 0.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpx, _bsxx, _bsxx, 3);
                        }
                    }
                    BlockPos _posx = BlockPos.containing(x, y, z);
                    BlockState _bsxxx = world.getBlockState(_posx);
                    Property<?> property5 = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property5 instanceof IntegerProperty) {
                        IntegerProperty _integerProp2 = (IntegerProperty) property5;
                        if (_integerProp2.getPossibleValues().contains(0)) {
                            world.setBlock(_posx, (BlockState) _bsxxx.setValue(_integerProp2, 0), 3);
                        }
                    }
                    if (world instanceof Level) {
                        Level _levelx2 = (Level) world;
                        if (!_levelx2.isClientSide()) {
                            _levelx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    if (entity instanceof Player) {
                        Player _plr3 = (Player) entity;
                        if (_plr3.getAbilities().instabuild) {
                            return;
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx = (ServerLevel) world;
                        ItemEntity entityToSpawn3 = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COOKED_HAM.get()));
                        entityToSpawn3.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn3);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx2 = (ServerLevel) world;
                        ItemEntity entityToSpawn4 = new ItemEntity(_levelxx2, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COOKED_PORK_BELLY.get()));
                        entityToSpawn4.setPickUpDelay(10);
                        _levelxx2.addFreshEntity(entityToSpawn4);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx3 = (ServerLevel) world;
                        ItemEntity entityToSpawn5 = new ItemEntity(_levelxx3, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COOKED_PORK_LEG.get()));
                        entityToSpawn5.setPickUpDelay(10);
                        _levelxx3.addFreshEntity(entityToSpawn5);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx4 = (ServerLevel) world;
                        ItemEntity entityToSpawn6 = new ItemEntity(_levelxx4, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COOKED_PORK_LEG.get()));
                        entityToSpawn6.setPickUpDelay(10);
                        _levelxx4.addFreshEntity(entityToSpawn6);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx5 = (ServerLevel) world;
                        ItemEntity entityToSpawn7 = new ItemEntity(_levelxx5, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COOKED_PORK_LEG.get()));
                        entityToSpawn7.setPickUpDelay(10);
                        _levelxx5.addFreshEntity(entityToSpawn7);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx6 = (ServerLevel) world;
                        ItemEntity entityToSpawn8 = new ItemEntity(_levelxx6, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COOKED_PORK_LEG.get()));
                        entityToSpawn8.setPickUpDelay(10);
                        _levelxx6.addFreshEntity(entityToSpawn8);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx7 = (ServerLevel) world;
                        ItemEntity entityToSpawn9 = new ItemEntity(_levelxx7, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COOKED_PORK_LOIN.get()));
                        entityToSpawn9.setPickUpDelay(10);
                        _levelxx7.addFreshEntity(entityToSpawn9);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx8 = (ServerLevel) world;
                        ItemEntity entityToSpawn10 = new ItemEntity(_levelxx8, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COOKED_PORK_SHOULDER.get()));
                        entityToSpawn10.setPickUpDelay(10);
                        _levelxx8.addFreshEntity(entityToSpawn10);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx9 = (ServerLevel) world;
                        ItemEntity entityToSpawn11 = new ItemEntity(_levelxx9, x, y, z, new ItemStack((ItemLike) ButcheryModItems.HOOF.get()));
                        entityToSpawn11.setPickUpDelay(10);
                        _levelxx9.addFreshEntity(entityToSpawn11);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx10 = (ServerLevel) world;
                        ItemEntity entityToSpawn12 = new ItemEntity(_levelxx10, x, y, z, new ItemStack((ItemLike) ButcheryModItems.HOOF.get()));
                        entityToSpawn12.setPickUpDelay(10);
                        _levelxx10.addFreshEntity(entityToSpawn12);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx11 = (ServerLevel) world;
                        ItemEntity entityToSpawn13 = new ItemEntity(_levelxx11, x, y, z, new ItemStack((ItemLike) ButcheryModItems.HOOF.get()));
                        entityToSpawn13.setPickUpDelay(10);
                        _levelxx11.addFreshEntity(entityToSpawn13);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx12 = (ServerLevel) world;
                        ItemEntity entityToSpawn14 = new ItemEntity(_levelxx12, x, y, z, new ItemStack((ItemLike) ButcheryModItems.HOOF.get()));
                        entityToSpawn14.setPickUpDelay(10);
                        _levelxx12.addFreshEntity(entityToSpawn14);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx13 = (ServerLevel) world;
                        ItemEntity entityToSpawn15 = new ItemEntity(_levelxx13, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CRACKLING.get()));
                        entityToSpawn15.setPickUpDelay(10);
                        _levelxx13.addFreshEntity(entityToSpawn15);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx14 = (ServerLevel) world;
                        ItemEntity entityToSpawn16 = new ItemEntity(_levelxx14, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CRACKLING.get()));
                        entityToSpawn16.setPickUpDelay(10);
                        _levelxx14.addFreshEntity(entityToSpawn16);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx15 = (ServerLevel) world;
                        ItemEntity entityToSpawn17 = new ItemEntity(_levelxx15, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CRACKLING.get()));
                        entityToSpawn17.setPickUpDelay(10);
                        _levelxx15.addFreshEntity(entityToSpawn17);
                        return;
                    }
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()) {
                Property<?> property6 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property6 instanceof IntegerProperty) {
                    Property<?> _getip44 = property6;
                    iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip44)).intValue();
                } else {
                    iIntValue = -1;
                }
                if (iIntValue == 3) {
                    if (event instanceof ICancellableEvent) {
                        event.setCanceled(true);
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bpxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                        BlockState _bsxxxx = world.getBlockState(_bpxx);
                        if (_blockEntityxx != null) {
                            ButcheryPersistentData.of(_blockEntityxx).putBoolean("mobCooking", false);
                            ButcheryPersistentData.of(_blockEntityxx).putDouble("Timer", 0.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxx, _bsxxxx, _bsxxxx, 3);
                        }
                    }
                    BlockPos _posxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxx = world.getBlockState(_posxx);
                    Property<?> property7 = _bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property7 instanceof IntegerProperty) {
                        IntegerProperty _integerProp3 = (IntegerProperty) property7;
                        if (_integerProp3.getPossibleValues().contains(0)) {
                            world.setBlock(_posxx, (BlockState) _bsxxxxx.setValue(_integerProp3, 0), 3);
                        }
                    }
                    if (world instanceof Level) {
                        Level _levelxx16 = (Level) world;
                        if (!_levelxx16.isClientSide()) {
                            _levelxx16.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sand.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelxx16.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sand.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    if (entity instanceof Player) {
                        Player _plr4 = (Player) entity;
                        if (_plr4.getAbilities().instabuild) {
                            return;
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn18 = new ItemEntity(_levelxxx, x, y, z, new ItemStack(Items.CHARCOAL));
                        entityToSpawn18.setPickUpDelay(10);
                        _levelxxx.addFreshEntity(entityToSpawn18);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxx2 = (ServerLevel) world;
                        ItemEntity entityToSpawn19 = new ItemEntity(_levelxxx2, x, y, z, new ItemStack(Items.CHARCOAL));
                        entityToSpawn19.setPickUpDelay(10);
                        _levelxxx2.addFreshEntity(entityToSpawn19);
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxx3 = (ServerLevel) world;
                        ItemEntity entityToSpawn20 = new ItemEntity(_levelxxx3, x, y, z, new ItemStack(Items.CHARCOAL));
                        entityToSpawn20.setPickUpDelay(10);
                        _levelxxx3.addFreshEntity(entityToSpawn20);
                    }
                }
            }
        }
    }
}
