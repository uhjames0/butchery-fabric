package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryVariants;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.procedures.InstantfillbloodgrateProcedure;
import net.mcreator.butchery.procedures.PlacebloodpuddleProcedure;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
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

public class PigcarcassbleedingProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            PigcarcassbleedingProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {

        LivingEntity _entity = null;

        _entity = null;
        PigcarcassbleedingProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {

        LivingEntity _entity = null;
        block40: {
            block41: {
                ItemStack itemStack;
                ItemStack itemStack2;
                int n;
                if (entity == null || !ButcheryVariants.isPigCarcass(world, x, y, z)) break block40;
                Property property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip3 = (IntegerProperty)property;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip3);
                } else {
                    n = -1;
                }
                if (n != 1) break block40;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntx = (LivingEntity)entity;
                    itemStack2 = _livEntx.getMainHandItem();
                } else {
                    itemStack2 = ItemStack.EMPTY;
                }
                if (itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) break block41;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    itemStack = _livEnt.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                if (!itemStack.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) break block40;
            }
            if (!PigcarcassbleedingProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "isBleeding") && !PigcarcassbleedingProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "isDrained")) {
                if (!ButcheryconfigConfiguration.INSTANT_BLEED.get().booleanValue()) {
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                            ButcheryPersistentData.of(_blockEntity).putBoolean("isBleeding", true);
                        }
                        if (world instanceof Level) {
                            Level _level = (Level)world;
                            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                    }
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    if (world instanceof Level) {
                        Level _levelx = (Level)world;
                        if (!_levelx.isClientSide()) {
                            _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                } else if (ButcheryconfigConfiguration.INSTANT_BLEED.get().booleanValue()) {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof Level) {
                        Level _levelxx = (Level)world;
                        if (!_levelxx.isClientSide()) {
                            _levelxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    if (world instanceof Level) {
                        Level _levelxxx = (Level)world;
                        if (!_levelxxx.isClientSide()) {
                            _levelxxx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelxxx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"block.honey_block.hit")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    BlockPos _bpx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockState _bsx = new Object(){

                        /*
                         * Enabled aggressive block sorting
                         */
                        public BlockState with(BlockState _bs, String _property, int _newValue) {
                            BlockState blockState;
                            Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                            if (_prop instanceof IntegerProperty) {
                                Property<?> _ip = (IntegerProperty)_prop;
                                if (_prop.getPossibleValues().contains(_newValue)) {
                                    blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                                    return blockState;
                                }
                            }
                            blockState = _bs;
                            return blockState;
                        }
                    }.with(ButcheryVariants.drainedPigCarcassFor(world, x, y, z).defaultBlockState(), "blockstate", 1);
                    BlockState _bso = world.getBlockState(_bpx);
                    for (Property _propertyOld : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                        if (_propertyNew == null || _bsx.getValue(_propertyNew) == null) continue;
                        try {
                            _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                        }
                        catch (Exception exception) {}
                    }
                    BlockEntity _be = world.getBlockEntity(_bpx);
                    CompoundTag _bnbt = null;
                    if (_be != null) {
                        _bnbt = _be.saveWithFullMetadata((HolderLookup.Provider)world.registryAccess());
                        _be.setRemoved();
                    }
                    world.setBlock(_bpx, _bsx, 3);
                    if (_bnbt != null && (_be = world.getBlockEntity(_bpx)) != null) {
                        try {
                            _be.loadWithComponents(TagValueInput.create((ProblemReporter)ProblemReporter.DISCARDING, (HolderLookup.Provider)world.registryAccess(), (CompoundTag)_bnbt));
                        }
                        catch (Exception _propertyNew) {
                            // empty catch block
                        }
                    }
                    if (!world.isClientSide()) {
                        _bpx = BlockPos.containing((double)x, (double)y, (double)z);
                        BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                        _bso = world.getBlockState(_bpx);
                        if (_blockEntityx != null) {
                            ButcheryPersistentData.of(_blockEntityx).putBoolean("isDrained", true);
                        }
                        if (world instanceof Level) {
                            Level _levelxxxx = (Level)world;
                            _levelxxxx.sendBlockUpdated(_bpx, _bso, _bso, 3);
                        }
                    }
                    InstantfillbloodgrateProcedure.execute(world, x, y, z);
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxx = (ServerLevel)world;
                        _levelxxxx.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(1, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxx = (ServerLevel)world;
                            _levelxxxx.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(2, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxx = (ServerLevel)world;
                            _levelxxxx.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(3, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxx = (ServerLevel)world;
                            _levelxxxx.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
                PlacebloodpuddleProcedure.execute(world, x, y, z);
            }
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
    }
}

