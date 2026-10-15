package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/* JADX INFO: loaded from: PlayercorpsebleedingProcedure.class */
public class PlayercorpsebleedingProcedure {
    /* JADX WARN: Type inference failed for: r0v123, types: [net.mcreator.butchery.procedures.PlayercorpsebleedingProcedure$3] */
    /* JADX WARN: Type inference failed for: r0v6, types: [net.mcreator.butchery.procedures.PlayercorpsebleedingProcedure$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [net.mcreator.butchery.procedures.PlayercorpsebleedingProcedure$2] */
    public static void execute(final LevelAccessor world, final double x, final double y, final double z, Entity entity) {
        ItemStack mainHandItem;
        int iIntValue;
        int iIntValue2;
        ItemStack mainHandItem2;
        if (entity != null) {
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
            if (!new Object() { // from class: net.mcreator.butchery.procedures.PlayercorpsebleedingProcedure.1
                public boolean getValue(LevelAccessor world2, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world2.getBlockEntity(pos);
                    if (blockEntity != null) {
                        return ((Boolean) ButcheryPersistentData.of(blockEntity).getBoolean(tag).orElse(false)).booleanValue();
                    }
                    return false;
                }
            }.getValue(world, BlockPos.containing(x, y, z), "isBleeding") && !new Object() { // from class: net.mcreator.butchery.procedures.PlayercorpsebleedingProcedure.2
                public boolean getValue(LevelAccessor world2, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world2.getBlockEntity(pos);
                    if (blockEntity != null) {
                        return ((Boolean) ButcheryPersistentData.of(blockEntity).getBoolean(tag).orElse(false)).booleanValue();
                    }
                    return false;
                }
            }.getValue(world, BlockPos.containing(x, y, z), "isDrained")) {
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
                    if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PLAYERCORPSE.get()) {
                        Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property instanceof IntegerProperty) {
                            Property<?> _getip11 = property;
                            iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip11)).intValue();
                        } else {
                            iIntValue2 = -1;
                        }
                        if (iIntValue2 == 1) {
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
                            BlooddrippingProcedure.execute(world, x, y, z);
                            new Object() { // from class: net.mcreator.butchery.procedures.PlayercorpsebleedingProcedure.3
                                void timedLoop(int timedloopiterator, int timedlooptotal, int ticks) {
                                    int iIntValue3;
                                    if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PLAYERCORPSE.get()) {
                                        Property<?> property2 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                                        if (property2 instanceof IntegerProperty) {
                                            Property<?> _getip18 = property2;
                                            iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip18)).intValue();
                                        } else {
                                            iIntValue3 = -1;
                                        }
                                        if (iIntValue3 == 1) {
                                            FillbloodgrateProcedure.execute(world, x, y, z);
                                        }
                                    }
                                    ButcheryMod.queueServerWork(ticks, () -> {
                                        if (timedlooptotal > timedloopiterator + 1) {
                                            timedLoop(timedloopiterator + 1, timedlooptotal, ticks);
                                        }
                                    });
                                }
                            }.timedLoop(0, 22, 45);
                            ButcheryMod.queueServerWork(900, () -> {
                                int iIntValue3;
                                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PLAYERCORPSE.get()) {
                                    Property<?> property2 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                                    if (property2 instanceof IntegerProperty) {
                                        Property<?> _getip23 = property2;
                                        iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip23)).intValue();
                                    } else {
                                        iIntValue3 = -1;
                                    }
                                    if (iIntValue3 == 1) {
                                        if (!world.isClientSide()) {
                                            BlockPos _bpx = BlockPos.containing(x, y, z);
                                            BlockEntity _blockEntityxx = world.getBlockEntity(_bpx);
                                            BlockState _bsxx = world.getBlockState(_bpx);
                                            if (_blockEntityxx != null) {
                                                ButcheryPersistentData.of(_blockEntityxx).putBoolean("isBleeding", false);
                                            }
                                            if (world instanceof Level) {
                                                Level _levelxx = (Level) world;
                                                _levelxx.sendBlockUpdated(_bpx, _bsxx, _bsxx, 3);
                                            }
                                        }
                                        if (!world.isClientSide()) {
                                            BlockPos _bpx2 = BlockPos.containing(x, y, z);
                                            BlockEntity _blockEntityx = world.getBlockEntity(_bpx2);
                                            BlockState _bsx = world.getBlockState(_bpx2);
                                            if (_blockEntityx != null) {
                                                ButcheryPersistentData.of(_blockEntityx).putBoolean("isDrained", true);
                                            }
                                            if (world instanceof Level) {
                                                Level _levelxx2 = (Level) world;
                                                _levelxx2.sendBlockUpdated(_bpx2, _bsx, _bsx, 3);
                                            }
                                        }
                                    }
                                }
                            });
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
                    if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PLAYERCORPSE.get()) {
                        Property<?> property2 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property2 instanceof IntegerProperty) {
                            IntegerProperty _getip34 = (IntegerProperty) property2;
                            iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip34)).intValue();
                        } else {
                            iIntValue = -1;
                        }
                        if (iIntValue == 1) {
                            if (!world.isClientSide()) {
                                BlockPos _bpx = BlockPos.containing(x, y, z);
                                BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                                BlockState _bsx = world.getBlockState(_bpx);
                                if (_blockEntityx != null) {
                                    ButcheryPersistentData.of(_blockEntityx).putBoolean("isBleeding", false);
                                }
                                if (world instanceof Level) {
                                    Level _levelxxxx = (Level) world;
                                    _levelxxxx.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                                }
                            }
                            if (!world.isClientSide()) {
                                BlockPos _bpxx = BlockPos.containing(x, y, z);
                                BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                                BlockState _bsxx = world.getBlockState(_bpxx);
                                if (_blockEntityxx != null) {
                                    ButcheryPersistentData.of(_blockEntityxx).putBoolean("isDrained", true);
                                }
                                if (world instanceof Level) {
                                    Level _levelxxxx2 = (Level) world;
                                    _levelxxxx2.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                                }
                            }
                            InstantfillbloodgrateProcedure.execute(world, x, y, z);
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxxxx3 = (ServerLevel) world;
                                _levelxxxx3.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5d, y - 0.6d, z + 0.5d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                            }
                            ButcheryMod.queueServerWork(1, () -> {
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxx4 = (ServerLevel) world;
                                    _levelxxxx4.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6d, y - 0.6d, z + 0.6d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                                }
                            });
                            ButcheryMod.queueServerWork(2, () -> {
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxx4 = (ServerLevel) world;
                                    _levelxxxx4.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6d, y - 0.6d, z + 0.4d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
                                }
                            });
                            ButcheryMod.queueServerWork(3, () -> {
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxx4 = (ServerLevel) world;
                                    _levelxxxx4.sendParticles((SimpleParticleType) ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4d, y - 0.6d, z + 0.6d, 1, 0.0d, 0.1d, 0.0d, 0.1d);
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
