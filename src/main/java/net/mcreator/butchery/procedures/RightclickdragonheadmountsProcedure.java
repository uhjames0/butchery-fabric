package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class RightclickdragonheadmountsProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            RightclickdragonheadmountsProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {

        LivingEntity _entity = null;

        _entity = null;
        RightclickdragonheadmountsProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {

        LivingEntity _entity = null;
        if (entity != null) {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.ENDER_DRAGON_HEAD_MOUNT.get()) {
                int n;
                Property property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip3 = (IntegerProperty)property;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip3);
                } else {
                    n = -1;
                }
                if (n == 0) {
                    IntegerProperty _integerProp;
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    int _value = 1;
                    BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property2 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property2).getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.step")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.step")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                } else {
                    int n2;
                    Property _value = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (_value instanceof IntegerProperty) {
                        Property<?> _getip8 = (IntegerProperty)_value;
                        n2 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip8);
                    } else {
                        n2 = -1;
                    }
                    if (n2 == 1) {
                        IntegerProperty _integerProp;
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        int _valuex = 0;
                        BlockPos _posx = BlockPos.containing((double)x, (double)y, (double)z);
                        BlockState _bsx = world.getBlockState(_posx);
                        Property property3 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property3 instanceof IntegerProperty && (_integerProp = (IntegerProperty)property3).getPossibleValues().contains(_valuex)) {
                            world.setBlock(_posx, (BlockState)_bsx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuex)), 3);
                        }
                        if (world instanceof Level) {
                            Level _levelx = (Level)world;
                            if (!_levelx.isClientSide()) {
                                _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.step")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.step")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                    }
                }
            } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == ButcheryModBlocks.TRIMMED_ENDER_DRAGON_HEAD_MOUNT.get()) {
                int n;
                Property _valuex = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (_valuex instanceof IntegerProperty) {
                    Property<?> _getip15 = (IntegerProperty)_valuex;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip15);
                } else {
                    n = -1;
                }
                if (n == 0) {
                    IntegerProperty _integerProp;
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    int _valuexx = 1;
                    BlockPos _posxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockState _bsxx = world.getBlockState(_posxx);
                    Property property = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                    if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexx)) {
                        world.setBlock(_posxx, (BlockState)_bsxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexx)), 3);
                    }
                    if (world instanceof Level) {
                        Level _levelxx = (Level)world;
                        if (!_levelxx.isClientSide()) {
                            _levelxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.step")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.step")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                } else {
                    int n3;
                    Property _valuexx = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (_valuexx instanceof IntegerProperty) {
                        Property<?> _getip20 = (IntegerProperty)_valuexx;
                        n3 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip20);
                    } else {
                        n3 = -1;
                    }
                    if (n3 == 1) {
                        IntegerProperty _integerProp;
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        int _valuexxx = 0;
                        BlockPos _posxxx = BlockPos.containing((double)x, (double)y, (double)z);
                        BlockState _bsxxx = world.getBlockState(_posxxx);
                        Property property = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxx)) {
                            world.setBlock(_posxxx, (BlockState)_bsxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxx)), 3);
                        }
                        if (world instanceof Level) {
                            Level _levelxxx = (Level)world;
                            if (!_levelxxx.isClientSide()) {
                                _levelxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.step")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.wool.step")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                    }
                }
            }
        }
    }
}

