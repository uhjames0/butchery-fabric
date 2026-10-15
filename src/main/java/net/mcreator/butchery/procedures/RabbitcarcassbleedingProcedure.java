package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.TagValueInput;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: RabbitcarcassbleedingProcedure.class */
public class RabbitcarcassbleedingProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    /* JADX WARN: Type inference failed for: r0v53, types: [net.mcreator.butchery.procedures.RabbitcarcassbleedingProcedure$1] */
    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        int iIntValue;
        ItemStack mainHandItem;
        int iIntValue2;
        BlockEntity _be;
        ItemStack mainHandItem2;
        if (entity != null && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RABBIT_CARCASS.get()) {
            Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip3 = property;
                iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip3)).intValue();
            } else {
                iIntValue = -1;
            }
            if (iIntValue == 1) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntx = (LivingEntity) entity;
                    mainHandItem = _livEntx.getMainHandItem();
                } else {
                    mainHandItem = ItemStack.EMPTY;
                }
                if (!mainHandItem.is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity) entity;
                        mainHandItem2 = _livEnt.getMainHandItem();
                    } else {
                        mainHandItem2 = ItemStack.EMPTY;
                    }
                    if (!mainHandItem2.is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) {
                        return;
                    }
                }
                if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isBleeding") && !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                            ButcheryPersistentData.of(_blockEntity).putBoolean("isBleeding", true);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                    }
                    if (!((Boolean) ButcheryconfigConfiguration.INSTANT_BLEED.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity) entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _level = (Level) world;
                            if (!_level.isClientSide()) {
                                _level.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _level.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelx = (Level) world;
                            if (!_levelx.isClientSide()) {
                                _levelx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                    } else if (((Boolean) ButcheryconfigConfiguration.INSTANT_BLEED.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity2 = (LivingEntity) entity;
                            _entity2.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _levelxx = (Level) world;
                            if (!_levelxx.isClientSide()) {
                                _levelxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxx = (Level) world;
                            if (!_levelxxx.isClientSide()) {
                                _levelxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                            } else {
                                _levelxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                            }
                        }
                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RABBIT_CARCASS.get()) {
                            Property<?> property2 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                            if (property2 instanceof IntegerProperty) {
                                Property<?> _getip22 = property2;
                                iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip22)).intValue();
                            } else {
                                iIntValue2 = -1;
                            }
                            if (iIntValue2 == 1) {
                                BlockPos _bpx = BlockPos.containing(x, y, z);
                                BlockState _bsx = new Object() { // from class: net.mcreator.butchery.procedures.RabbitcarcassbleedingProcedure.1
                                    public BlockState with(BlockState _bs2, String _property, int _newValue) {
                                        Property<?> property3 = _bs2.getBlock().getStateDefinition().getProperty(_property);
                                        if (property3 instanceof IntegerProperty) {
                                            IntegerProperty _ip = (IntegerProperty) property3;
                                            if (property3.getPossibleValues().contains(Integer.valueOf(_newValue))) {
                                                return (BlockState) _bs2.setValue((Property) _ip, (Comparable) Integer.valueOf(_newValue));
                                            }
                                        }
                                        return _bs2;
                                    }
                                }.with(((Block) ButcheryModBlocks.DRAINED_RABBIT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                                BlockState _bso = world.getBlockState(_bpx);
                                for (Property<?> _propertyOld : _bso.getProperties()) {
                                    Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                                    if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                                        try {
                                            _bsx = (BlockState) _bsx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                                        } catch (Exception e) {
                                        }
                                    }
                                }
                                BlockEntity _be2 = world.getBlockEntity(_bpx);
                                CompoundTag _bnbt = null;
                                if (_be2 != null) {
                                    _bnbt = _be2.saveWithFullMetadata(world.registryAccess());
                                    _be2.setRemoved();
                                }
                                world.setBlock(_bpx, _bsx, 3);
                                if (_bnbt != null && (_be = world.getBlockEntity(_bpx)) != null) {
                                    try {
                                        _be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
                                    } catch (Exception e2) {
                                    }
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bpx2 = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntityx = world.getBlockEntity(_bpx2);
                                    BlockState _bso2 = world.getBlockState(_bpx2);
                                    if (_blockEntityx != null) {
                                        ButcheryPersistentData.of(_blockEntityx).putBoolean("isBleeding", false);
                                        ButcheryPersistentData.of(_blockEntityx).putBoolean("isDrained", true);
                                    }
                                    if (world instanceof Level) {
                                        Level _levelxxxx = (Level) world;
                                        _levelxxxx.sendBlockUpdated(_bpx2, _bso2, _bso2, 3);
                                    }
                                }
                                SmallInstantfillbloodgrateProcedure.execute(world, x, y, z);
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxx2 = (ServerLevel) world;
                                    _levelxxxx2.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5d, y - 0.6d, z + 0.5d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                                }
                                ButcheryMod.queueServerWork(1, () -> {
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _levelxxxx3 = (ServerLevel) world;
                                        _levelxxxx3.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6d, y - 0.6d, z + 0.6d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                                    }
                                });
                                ButcheryMod.queueServerWork(2, () -> {
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _levelxxxx3 = (ServerLevel) world;
                                        _levelxxxx3.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6d, y - 0.6d, z + 0.4d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                                    }
                                });
                                ButcheryMod.queueServerWork(3, () -> {
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _levelxxxx3 = (ServerLevel) world;
                                        _levelxxxx3.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4d, y - 0.6d, z + 0.6d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                                    }
                                });
                            }
                        }
                    }
                }
                PlacebloodpuddleProcedure.execute(world, x, y, z);
            }
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false);
        }
        return false;
    }
}
