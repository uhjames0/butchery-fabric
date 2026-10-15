package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: RetrieveskinProcedure.class */
public class RetrieveskinProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        execute(null, world, x, y, z, blockstate, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        ItemStack mainHandItem;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        int iIntValue5;
        int iIntValue6;
        int iIntValue7;
        int iIntValue8;
        int iIntValue9;
        int iIntValue10;
        int iIntValue11;
        int iIntValue12;
        int iIntValue13;
        int iIntValue14;
        int iIntValue15;
        int iIntValue16;
        int iIntValue17;
        int iIntValue18;
        int iIntValue19;
        int iIntValue20;
        int iIntValue21;
        int iIntValue22;
        int iIntValue23;
        int iIntValue24;
        int iIntValue25;
        int iIntValue26;
        int iIntValue27;
        int iIntValue28;
        int iIntValue29;
        int iIntValue32;
        int iIntValue33;
        int iIntValue34;
        int iIntValue35;
        if (entity != null && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SKIN_RACK.get()) {
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity) entity;
                mainHandItem = _livEnt.getMainHandItem();
            } else {
                mainHandItem = ItemStack.EMPTY;
            }
            if (mainHandItem.getItem() == Blocks.AIR.asItem()) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity) entity;
                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                }
                Property<?> property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip6 = property;
                    iIntValue = ((Integer) blockstate.getValue(_getip6)).intValue();
                } else {
                    iIntValue = -1;
                }
                if (iIntValue == 1) {
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property<?> property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property2 instanceof IntegerProperty) {
                        IntegerProperty _integerProp = (IntegerProperty) property2;
                        if (_integerProp.getPossibleValues().contains(0)) {
                            world.setBlock(_pos, (BlockState) _bs.setValue(_integerProp, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike) ButcheryModItems.BAT_SKIN.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }
                    if (world instanceof Level) {
                        Level _level2 = (Level) world;
                        if (!_level2.isClientSide()) {
                            _level2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _level2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property3 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property3 instanceof IntegerProperty) {
                    Property<?> _getip11 = property3;
                    iIntValue2 = ((Integer) blockstate.getValue(_getip11)).intValue();
                } else {
                    iIntValue2 = -1;
                }
                if (iIntValue2 == 2) {
                    BlockPos _posx = BlockPos.containing(x, y, z);
                    BlockState _bsx = world.getBlockState(_posx);
                    Property<?> property4 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property4 instanceof IntegerProperty) {
                        IntegerProperty _integerProp2 = (IntegerProperty) property4;
                        if (_integerProp2.getPossibleValues().contains(0)) {
                            world.setBlock(_posx, (BlockState) _bsx.setValue(_integerProp2, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelx = (ServerLevel) world;
                        ItemEntity entityToSpawn2 = new ItemEntity(_levelx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.BLACK_HORSE_SKIN.get()));
                        entityToSpawn2.setPickUpDelay(10);
                        _levelx.addFreshEntity(entityToSpawn2);
                    }
                    if (world instanceof Level) {
                        Level _levelx2 = (Level) world;
                        if (!_levelx2.isClientSide()) {
                            _levelx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property5 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property5 instanceof IntegerProperty) {
                    Property<?> _getip16 = property5;
                    iIntValue3 = ((Integer) blockstate.getValue(_getip16)).intValue();
                } else {
                    iIntValue3 = -1;
                }
                if (iIntValue3 == 3) {
                    BlockPos _posxx = BlockPos.containing(x, y, z);
                    BlockState _bsxx = world.getBlockState(_posxx);
                    Property<?> property6 = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property6 instanceof IntegerProperty) {
                        IntegerProperty _integerProp3 = (IntegerProperty) property6;
                        if (_integerProp3.getPossibleValues().contains(0)) {
                            world.setBlock(_posxx, (BlockState) _bsxx.setValue(_integerProp3, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx = (ServerLevel) world;
                        ItemEntity entityToSpawn3 = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.BROWN_MOOSHROOM_SKIN.get()));
                        entityToSpawn3.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn3);
                    }
                    if (world instanceof Level) {
                        Level _levelxx2 = (Level) world;
                        if (!_levelxx2.isClientSide()) {
                            _levelxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property7 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property7 instanceof IntegerProperty) {
                    Property<?> _getip21 = property7;
                    iIntValue4 = ((Integer) blockstate.getValue(_getip21)).intValue();
                } else {
                    iIntValue4 = -1;
                }
                if (iIntValue4 == 4) {
                    BlockPos _posxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxx = world.getBlockState(_posxxx);
                    Property<?> property8 = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property8 instanceof IntegerProperty) {
                        IntegerProperty _integerProp4 = (IntegerProperty) property8;
                        if (_integerProp4.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxx, (BlockState) _bsxxx.setValue(_integerProp4, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn4 = new ItemEntity(_levelxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CHESTNUT_HORSE_SKIN.get()));
                        entityToSpawn4.setPickUpDelay(10);
                        _levelxxx.addFreshEntity(entityToSpawn4);
                    }
                    if (world instanceof Level) {
                        Level _levelxxx2 = (Level) world;
                        if (!_levelxxx2.isClientSide()) {
                            _levelxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property9 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property9 instanceof IntegerProperty) {
                    Property<?> _getip26 = property9;
                    iIntValue5 = ((Integer) blockstate.getValue(_getip26)).intValue();
                } else {
                    iIntValue5 = -1;
                }
                if (iIntValue5 == 5) {
                    BlockPos _posxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxx = world.getBlockState(_posxxxx);
                    Property<?> property10 = _bsxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property10 instanceof IntegerProperty) {
                        IntegerProperty _integerProp5 = (IntegerProperty) property10;
                        if (_integerProp5.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxx, (BlockState) _bsxxxx.setValue(_integerProp5, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn5 = new ItemEntity(_levelxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CREAMY_HORSE_SKIN.get()));
                        entityToSpawn5.setPickUpDelay(10);
                        _levelxxxx.addFreshEntity(entityToSpawn5);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxx2 = (Level) world;
                        if (!_levelxxxx2.isClientSide()) {
                            _levelxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property11 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property11 instanceof IntegerProperty) {
                    Property<?> _getip31 = property11;
                    iIntValue6 = ((Integer) blockstate.getValue(_getip31)).intValue();
                } else {
                    iIntValue6 = -1;
                }
                if (iIntValue6 == 6) {
                    BlockPos _posxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxx = world.getBlockState(_posxxxxx);
                    Property<?> property12 = _bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property12 instanceof IntegerProperty) {
                        IntegerProperty _integerProp6 = (IntegerProperty) property12;
                        if (_integerProp6.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxx, (BlockState) _bsxxxxx.setValue(_integerProp6, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn6 = new ItemEntity(_levelxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CREEPER_SKIN.get()));
                        entityToSpawn6.setPickUpDelay(10);
                        _levelxxxxx.addFreshEntity(entityToSpawn6);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxx2 = (Level) world;
                        if (!_levelxxxxx2.isClientSide()) {
                            _levelxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property13 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property13 instanceof IntegerProperty) {
                    Property<?> _getip36 = property13;
                    iIntValue7 = ((Integer) blockstate.getValue(_getip36)).intValue();
                } else {
                    iIntValue7 = -1;
                }
                if (iIntValue7 == 7) {
                    BlockPos _posxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxx = world.getBlockState(_posxxxxxx);
                    Property<?> property14 = _bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property14 instanceof IntegerProperty) {
                        IntegerProperty _integerProp7 = (IntegerProperty) property14;
                        if (_integerProp7.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxx, (BlockState) _bsxxxxxx.setValue(_integerProp7, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn7 = new ItemEntity(_levelxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.DARK_BROWN_HORSE_SKIN.get()));
                        entityToSpawn7.setPickUpDelay(10);
                        _levelxxxxxx.addFreshEntity(entityToSpawn7);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxx2 = (Level) world;
                        if (!_levelxxxxxx2.isClientSide()) {
                            _levelxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property15 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property15 instanceof IntegerProperty) {
                    Property<?> _getip41 = property15;
                    iIntValue8 = ((Integer) blockstate.getValue(_getip41)).intValue();
                } else {
                    iIntValue8 = -1;
                }
                if (iIntValue8 == 8) {
                    BlockPos _posxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxx = world.getBlockState(_posxxxxxxx);
                    Property<?> property16 = _bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property16 instanceof IntegerProperty) {
                        IntegerProperty _integerProp8 = (IntegerProperty) property16;
                        if (_integerProp8.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxx, (BlockState) _bsxxxxxxx.setValue(_integerProp8, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn8 = new ItemEntity(_levelxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.DOLPHIN_SKIN.get()));
                        entityToSpawn8.setPickUpDelay(10);
                        _levelxxxxxxx.addFreshEntity(entityToSpawn8);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxx2.isClientSide()) {
                            _levelxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property17 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property17 instanceof IntegerProperty) {
                    Property<?> _getip46 = property17;
                    iIntValue9 = ((Integer) blockstate.getValue(_getip46)).intValue();
                } else {
                    iIntValue9 = -1;
                }
                if (iIntValue9 == 9) {
                    BlockPos _posxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxx = world.getBlockState(_posxxxxxxxx);
                    Property<?> property18 = _bsxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property18 instanceof IntegerProperty) {
                        IntegerProperty _integerProp9 = (IntegerProperty) property18;
                        if (_integerProp9.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxx, (BlockState) _bsxxxxxxxx.setValue(_integerProp9, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn9 = new ItemEntity(_levelxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.DONKEY_SKIN.get()));
                        entityToSpawn9.setPickUpDelay(10);
                        _levelxxxxxxxx.addFreshEntity(entityToSpawn9);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property19 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property19 instanceof IntegerProperty) {
                    Property<?> _getip51 = property19;
                    iIntValue10 = ((Integer) blockstate.getValue(_getip51)).intValue();
                } else {
                    iIntValue10 = -1;
                }
                if (iIntValue10 == 10) {
                    BlockPos _posxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxx = world.getBlockState(_posxxxxxxxxx);
                    Property<?> property20 = _bsxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property20 instanceof IntegerProperty) {
                        IntegerProperty _integerProp10 = (IntegerProperty) property20;
                        if (_integerProp10.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxx, (BlockState) _bsxxxxxxxxx.setValue(_integerProp10, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn10 = new ItemEntity(_levelxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.FOX_SKIN.get()));
                        entityToSpawn10.setPickUpDelay(10);
                        _levelxxxxxxxxx.addFreshEntity(entityToSpawn10);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property21 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property21 instanceof IntegerProperty) {
                    Property<?> _getip56 = property21;
                    iIntValue11 = ((Integer) blockstate.getValue(_getip56)).intValue();
                } else {
                    iIntValue11 = -1;
                }
                if (iIntValue11 == 11) {
                    BlockPos _posxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxx);
                    Property<?> property22 = _bsxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property22 instanceof IntegerProperty) {
                        IntegerProperty _integerProp11 = (IntegerProperty) property22;
                        if (_integerProp11.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxx, (BlockState) _bsxxxxxxxxxx.setValue(_integerProp11, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn11 = new ItemEntity(_levelxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.GRAY_HORSE_SKIN.get()));
                        entityToSpawn11.setPickUpDelay(10);
                        _levelxxxxxxxxxx.addFreshEntity(entityToSpawn11);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property23 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property23 instanceof IntegerProperty) {
                    Property<?> _getip61 = property23;
                    iIntValue12 = ((Integer) blockstate.getValue(_getip61)).intValue();
                } else {
                    iIntValue12 = -1;
                }
                if (iIntValue12 == 12) {
                    BlockPos _posxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxx);
                    Property<?> property24 = _bsxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property24 instanceof IntegerProperty) {
                        IntegerProperty _integerProp12 = (IntegerProperty) property24;
                        if (_integerProp12.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxx.setValue(_integerProp12, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn12 = new ItemEntity(_levelxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.HOGLIN_SKIN.get()));
                        entityToSpawn12.setPickUpDelay(10);
                        _levelxxxxxxxxxxx.addFreshEntity(entityToSpawn12);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property25 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property25 instanceof IntegerProperty) {
                    Property<?> _getip66 = property25;
                    iIntValue13 = ((Integer) blockstate.getValue(_getip66)).intValue();
                } else {
                    iIntValue13 = -1;
                }
                if (iIntValue13 == 13) {
                    BlockPos _posxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxx);
                    Property<?> property26 = _bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property26 instanceof IntegerProperty) {
                        IntegerProperty _integerProp13 = (IntegerProperty) property26;
                        if (_integerProp13.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxx.setValue(_integerProp13, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn13 = new ItemEntity(_levelxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.MULE_SKIN.get()));
                        entityToSpawn13.setPickUpDelay(10);
                        _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn13);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property27 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property27 instanceof IntegerProperty) {
                    Property<?> _getip71 = property27;
                    iIntValue14 = ((Integer) blockstate.getValue(_getip71)).intValue();
                } else {
                    iIntValue14 = -1;
                }
                if (iIntValue14 == 14) {
                    BlockPos _posxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxx);
                    Property<?> property28 = _bsxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property28 instanceof IntegerProperty) {
                        IntegerProperty _integerProp14 = (IntegerProperty) property28;
                        if (_integerProp14.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxx.setValue(_integerProp14, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn14 = new ItemEntity(_levelxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.OCELOT_SKIN.get()));
                        entityToSpawn14.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxx.addFreshEntity(entityToSpawn14);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property29 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property29 instanceof IntegerProperty) {
                    Property<?> _getip76 = property29;
                    iIntValue15 = ((Integer) blockstate.getValue(_getip76)).intValue();
                } else {
                    iIntValue15 = -1;
                }
                if (iIntValue15 == 15) {
                    BlockPos _posxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxx);
                    Property<?> property30 = _bsxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property30 instanceof IntegerProperty) {
                        IntegerProperty _integerProp15 = (IntegerProperty) property30;
                        if (_integerProp15.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxx.setValue(_integerProp15, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn15 = new ItemEntity(_levelxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.PANDA_SKIN.get()));
                        entityToSpawn15.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn15);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property31 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property31 instanceof IntegerProperty) {
                    Property<?> _getip81 = property31;
                    iIntValue16 = ((Integer) blockstate.getValue(_getip81)).intValue();
                } else {
                    iIntValue16 = -1;
                }
                if (iIntValue16 == 16) {
                    BlockPos _posxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxx);
                    Property<?> property32 = _bsxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property32 instanceof IntegerProperty) {
                        IntegerProperty _integerProp16 = (IntegerProperty) property32;
                        if (_integerProp16.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxx.setValue(_integerProp16, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn16 = new ItemEntity(_levelxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.PIG_SKIN.get()));
                        entityToSpawn16.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn16);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property33 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property33 instanceof IntegerProperty) {
                    Property<?> _getip86 = property33;
                    iIntValue17 = ((Integer) blockstate.getValue(_getip86)).intValue();
                } else {
                    iIntValue17 = -1;
                }
                if (iIntValue17 == 17) {
                    BlockPos _posxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxx);
                    Property<?> property34 = _bsxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property34 instanceof IntegerProperty) {
                        IntegerProperty _integerProp17 = (IntegerProperty) property34;
                        if (_integerProp17.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxx.setValue(_integerProp17, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn17 = new ItemEntity(_levelxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.RED_MOOSHROOM_SKIN.get()));
                        entityToSpawn17.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn17);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property35 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property35 instanceof IntegerProperty) {
                    Property<?> _getip91 = property35;
                    iIntValue18 = ((Integer) blockstate.getValue(_getip91)).intValue();
                } else {
                    iIntValue18 = -1;
                }
                if (iIntValue18 == 18) {
                    BlockPos _posxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxx);
                    Property<?> property36 = _bsxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property36 instanceof IntegerProperty) {
                        IntegerProperty _integerProp18 = (IntegerProperty) property36;
                        if (_integerProp18.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxx.setValue(_integerProp18, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn18 = new ItemEntity(_levelxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.SHEEP_SKIN.get()));
                        entityToSpawn18.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn18);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property37 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property37 instanceof IntegerProperty) {
                    Property<?> _getip96 = property37;
                    iIntValue19 = ((Integer) blockstate.getValue(_getip96)).intValue();
                } else {
                    iIntValue19 = -1;
                }
                if (iIntValue19 == 19) {
                    BlockPos _posxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxx);
                    Property<?> property38 = _bsxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property38 instanceof IntegerProperty) {
                        IntegerProperty _integerProp19 = (IntegerProperty) property38;
                        if (_integerProp19.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxx.setValue(_integerProp19, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn19 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.SNOW_FOX_SKIN.get()));
                        entityToSpawn19.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn19);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property39 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property39 instanceof IntegerProperty) {
                    Property<?> _getip101 = property39;
                    iIntValue20 = ((Integer) blockstate.getValue(_getip101)).intValue();
                } else {
                    iIntValue20 = -1;
                }
                if (iIntValue20 == 20) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxx);
                    Property<?> property40 = _bsxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property40 instanceof IntegerProperty) {
                        IntegerProperty _integerProp20 = (IntegerProperty) property40;
                        if (_integerProp20.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxx.setValue(_integerProp20, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn20 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.WHITE_HORSE_SKIN.get()));
                        entityToSpawn20.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn20);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property41 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property41 instanceof IntegerProperty) {
                    Property<?> _getip106 = property41;
                    iIntValue21 = ((Integer) blockstate.getValue(_getip106)).intValue();
                } else {
                    iIntValue21 = -1;
                }
                if (iIntValue21 == 21) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxx);
                    Property<?> property42 = _bsxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property42 instanceof IntegerProperty) {
                        IntegerProperty _integerProp21 = (IntegerProperty) property42;
                        if (_integerProp21.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp21, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn21 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.POLAR_BEAR_SKIN.get()));
                        entityToSpawn21.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn21);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property43 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property43 instanceof IntegerProperty) {
                    Property<?> _getip111 = property43;
                    iIntValue22 = ((Integer) blockstate.getValue(_getip111)).intValue();
                } else {
                    iIntValue22 = -1;
                }
                if (iIntValue22 == 22) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxx);
                    Property<?> property44 = _bsxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property44 instanceof IntegerProperty) {
                        IntegerProperty _integerProp22 = (IntegerProperty) property44;
                        if (_integerProp22.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp22, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn22 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.BROWN_LLAMA_SKIN.get()));
                        entityToSpawn22.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn22);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property45 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property45 instanceof IntegerProperty) {
                    Property<?> _getip116 = property45;
                    iIntValue23 = ((Integer) blockstate.getValue(_getip116)).intValue();
                } else {
                    iIntValue23 = -1;
                }
                if (iIntValue23 == 23) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxx);
                    Property<?> property46 = _bsxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property46 instanceof IntegerProperty) {
                        IntegerProperty _integerProp23 = (IntegerProperty) property46;
                        if (_integerProp23.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp23, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn23 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CREAMY_LLAMA_SKIN.get()));
                        entityToSpawn23.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn23);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property47 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property47 instanceof IntegerProperty) {
                    Property<?> _getip121 = property47;
                    iIntValue24 = ((Integer) blockstate.getValue(_getip121)).intValue();
                } else {
                    iIntValue24 = -1;
                }
                if (iIntValue24 == 24) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxx);
                    Property<?> property48 = _bsxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property48 instanceof IntegerProperty) {
                        IntegerProperty _integerProp24 = (IntegerProperty) property48;
                        if (_integerProp24.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp24, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn24 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.GRAY_LLAMA_SKIN.get()));
                        entityToSpawn24.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn24);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property49 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property49 instanceof IntegerProperty) {
                    Property<?> _getip126 = property49;
                    iIntValue25 = ((Integer) blockstate.getValue(_getip126)).intValue();
                } else {
                    iIntValue25 = -1;
                }
                if (iIntValue25 == 25) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxx);
                    Property<?> property50 = _bsxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property50 instanceof IntegerProperty) {
                        IntegerProperty _integerProp25 = (IntegerProperty) property50;
                        if (_integerProp25.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp25, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn25 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.WHITE_LLAMA_SKIN.get()));
                        entityToSpawn25.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn25);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property51 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property51 instanceof IntegerProperty) {
                    Property<?> _getip131 = property51;
                    iIntValue26 = ((Integer) blockstate.getValue(_getip131)).intValue();
                } else {
                    iIntValue26 = -1;
                }
                if (iIntValue26 == 28) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxx);
                    Property<?> property52 = _bsxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property52 instanceof IntegerProperty) {
                        IntegerProperty _integerProp26 = (IntegerProperty) property52;
                        if (_integerProp26.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp26, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn26 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COW_SKIN.get()));
                        entityToSpawn26.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn26);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property53 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property53 instanceof IntegerProperty) {
                    Property<?> _getip136 = property53;
                    iIntValue27 = ((Integer) blockstate.getValue(_getip136)).intValue();
                } else {
                    iIntValue27 = -1;
                }
                if (iIntValue27 == 29) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxx);
                    Property<?> property54 = _bsxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property54 instanceof IntegerProperty) {
                        IntegerProperty _integerProp27 = (IntegerProperty) property54;
                        if (_integerProp27.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp27, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn27 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.ZOGLIN_SKIN.get()));
                        entityToSpawn27.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn27);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property55 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property55 instanceof IntegerProperty) {
                    Property<?> _getip141 = property55;
                    iIntValue28 = ((Integer) blockstate.getValue(_getip141)).intValue();
                } else {
                    iIntValue28 = -1;
                }
                if (iIntValue28 == 30) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                    Property<?> property56 = _bsxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property56 instanceof IntegerProperty) {
                        IntegerProperty _integerProp28 = (IntegerProperty) property56;
                        if (_integerProp28.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp28, 0), 3);
                        }
                    }
                    for (int index0 = 0; index0 < ((int) ((Double) ButcheryconfigConfiguration.SKIN_RACK_YIELD.get()).doubleValue()); index0++) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                            ItemEntity entityToSpawn28 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack(Items.LEATHER));
                            entityToSpawn28.setPickUpDelay(10);
                            _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn28);
                        }
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            return;
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            return;
                        }
                    }
                    return;
                }
                Property<?> property57 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (property57 instanceof IntegerProperty) {
                    Property<?> _getip147 = property57;
                    iIntValue29 = ((Integer) blockstate.getValue(_getip147)).intValue();
                } else {
                    iIntValue29 = -1;
                }
                if (iIntValue29 == 31) {
                    BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                    Property<?> property58 = _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property58 instanceof IntegerProperty) {
                        IntegerProperty _integerProp29 = (IntegerProperty) property58;
                        if (_integerProp29.getPossibleValues().contains(0)) {
                            world.setBlock(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState) _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp29, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        ItemEntity entityToSpawn29 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, new ItemStack((ItemLike) ButcheryModItems.CAMEL_SKIN.get()));
                        entityToSpawn29.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn29);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                }
                Property<?> propertyvb32 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (propertyvb32 instanceof IntegerProperty) {
                    Property<?> _getipvb32 = propertyvb32;
                    iIntValue32 = ((Integer) blockstate.getValue(_getipvb32)).intValue();
                } else {
                    iIntValue32 = -1;
                }
                if (iIntValue32 == 32) {
                    BlockPos _posvb32 = BlockPos.containing(x, y, z);
                    BlockState _bsvb32 = world.getBlockState(_posvb32);
                    Property<?> propertyvb232 = _bsvb32.getBlock().getStateDefinition().getProperty("blockstate");
                    if (propertyvb232 instanceof IntegerProperty) {
                        IntegerProperty _integerPropvb32 = (IntegerProperty) propertyvb232;
                        if (_integerPropvb32.getPossibleValues().contains(0)) {
                            world.setBlock(_posvb32, (BlockState) _bsvb32.setValue(_integerPropvb32, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelvb32 = (ServerLevel) world;
                        ItemEntity entityToSpawnvb32 = new ItemEntity(_levelvb32, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COLD_PIG_SKIN.get()));
                        entityToSpawnvb32.setPickUpDelay(10);
                        _levelvb32.addFreshEntity(entityToSpawnvb32);
                    }
                    if (world instanceof Level) {
                        Level _levelvb232 = (Level) world;
                        if (!_levelvb232.isClientSide()) {
                            _levelvb232.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelvb232.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    return;
                }
                Property<?> propertyvb33 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (propertyvb33 instanceof IntegerProperty) {
                    Property<?> _getipvb33 = propertyvb33;
                    iIntValue33 = ((Integer) blockstate.getValue(_getipvb33)).intValue();
                } else {
                    iIntValue33 = -1;
                }
                if (iIntValue33 == 33) {
                    BlockPos _posvb33 = BlockPos.containing(x, y, z);
                    BlockState _bsvb33 = world.getBlockState(_posvb33);
                    Property<?> propertyvb233 = _bsvb33.getBlock().getStateDefinition().getProperty("blockstate");
                    if (propertyvb233 instanceof IntegerProperty) {
                        IntegerProperty _integerPropvb33 = (IntegerProperty) propertyvb233;
                        if (_integerPropvb33.getPossibleValues().contains(0)) {
                            world.setBlock(_posvb33, (BlockState) _bsvb33.setValue(_integerPropvb33, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelvb33 = (ServerLevel) world;
                        ItemEntity entityToSpawnvb33 = new ItemEntity(_levelvb33, x, y, z, new ItemStack((ItemLike) ButcheryModItems.WARM_PIG_SKIN.get()));
                        entityToSpawnvb33.setPickUpDelay(10);
                        _levelvb33.addFreshEntity(entityToSpawnvb33);
                    }
                    if (world instanceof Level) {
                        Level _levelvb233 = (Level) world;
                        if (!_levelvb233.isClientSide()) {
                            _levelvb233.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelvb233.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    return;
                }
                Property<?> propertyvb34 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (propertyvb34 instanceof IntegerProperty) {
                    Property<?> _getipvb34 = propertyvb34;
                    iIntValue34 = ((Integer) blockstate.getValue(_getipvb34)).intValue();
                } else {
                    iIntValue34 = -1;
                }
                if (iIntValue34 == 34) {
                    BlockPos _posvb34 = BlockPos.containing(x, y, z);
                    BlockState _bsvb34 = world.getBlockState(_posvb34);
                    Property<?> propertyvb234 = _bsvb34.getBlock().getStateDefinition().getProperty("blockstate");
                    if (propertyvb234 instanceof IntegerProperty) {
                        IntegerProperty _integerPropvb34 = (IntegerProperty) propertyvb234;
                        if (_integerPropvb34.getPossibleValues().contains(0)) {
                            world.setBlock(_posvb34, (BlockState) _bsvb34.setValue(_integerPropvb34, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelvb34 = (ServerLevel) world;
                        ItemEntity entityToSpawnvb34 = new ItemEntity(_levelvb34, x, y, z, new ItemStack((ItemLike) ButcheryModItems.COLD_COW_SKIN.get()));
                        entityToSpawnvb34.setPickUpDelay(10);
                        _levelvb34.addFreshEntity(entityToSpawnvb34);
                    }
                    if (world instanceof Level) {
                        Level _levelvb234 = (Level) world;
                        if (!_levelvb234.isClientSide()) {
                            _levelvb234.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelvb234.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    return;
                }
                Property<?> propertyvb35 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                if (propertyvb35 instanceof IntegerProperty) {
                    Property<?> _getipvb35 = propertyvb35;
                    iIntValue35 = ((Integer) blockstate.getValue(_getipvb35)).intValue();
                } else {
                    iIntValue35 = -1;
                }
                if (iIntValue35 == 35) {
                    BlockPos _posvb35 = BlockPos.containing(x, y, z);
                    BlockState _bsvb35 = world.getBlockState(_posvb35);
                    Property<?> propertyvb235 = _bsvb35.getBlock().getStateDefinition().getProperty("blockstate");
                    if (propertyvb235 instanceof IntegerProperty) {
                        IntegerProperty _integerPropvb35 = (IntegerProperty) propertyvb235;
                        if (_integerPropvb35.getPossibleValues().contains(0)) {
                            world.setBlock(_posvb35, (BlockState) _bsvb35.setValue(_integerPropvb35, 0), 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelvb35 = (ServerLevel) world;
                        ItemEntity entityToSpawnvb35 = new ItemEntity(_levelvb35, x, y, z, new ItemStack((ItemLike) ButcheryModItems.WARM_COW_SKIN.get()));
                        entityToSpawnvb35.setPickUpDelay(10);
                        _levelvb35.addFreshEntity(entityToSpawnvb35);
                    }
                    if (world instanceof Level) {
                        Level _levelvb235 = (Level) world;
                        if (!_levelvb235.isClientSide()) {
                            _levelvb235.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelvb235.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }

                        // dyed sheep skins (states 36-50)
                        if (iIntValue35 >= 36 && iIntValue35 <= 50) {
                            BlockPos _sheepPos = BlockPos.containing(x, y, z);
                            BlockState _sheepBs = world.getBlockState(_sheepPos);
                            Property<?> _sheepProp = _sheepBs.getBlock().getStateDefinition().getProperty("blockstate");
                            if (_sheepProp instanceof IntegerProperty _sheepIp && _sheepIp.getPossibleValues().contains(0)) {
                                world.setBlock(_sheepPos, (BlockState) _sheepBs.setValue(_sheepIp, 0), 3);
                            }
                            if (world instanceof ServerLevel) {
                                ServerLevel _sheepLevel = (ServerLevel) world;
                                Item _sheepSkin = net.mcreator.butchery.init.ButcheryVariants.sheepSkinForRackState(iIntValue35);
                                if (_sheepSkin != null) {
                                    ItemEntity _sheepDrop = new ItemEntity(_sheepLevel, x, y, z, new ItemStack((ItemLike) _sheepSkin));
                                    _sheepDrop.setPickUpDelay(10);
                                    _sheepLevel.addFreshEntity((Entity) _sheepDrop);
                                }
                            }
                            if (world instanceof Level) {
                                Level _sheepLvl = (Level) world;
                                if (!_sheepLvl.isClientSide()) {
                                    _sheepLvl.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.wool.break")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                                }
                            }
                        }
                    return;
                }
            }
        }
    }
}
