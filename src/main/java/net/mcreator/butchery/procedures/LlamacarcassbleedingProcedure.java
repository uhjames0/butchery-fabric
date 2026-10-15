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

/* JADX INFO: loaded from: LlamacarcassbleedingProcedure.class */
public class LlamacarcassbleedingProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    /* JADX WARN: Type inference failed for: r0v106, types: [net.mcreator.butchery.procedures.LlamacarcassbleedingProcedure$3] */
    /* JADX WARN: Type inference failed for: r0v144, types: [net.mcreator.butchery.procedures.LlamacarcassbleedingProcedure$2] */
    /* JADX WARN: Type inference failed for: r0v191, types: [net.mcreator.butchery.procedures.LlamacarcassbleedingProcedure$1] */
    /* JADX WARN: Type inference failed for: r0v68, types: [net.mcreator.butchery.procedures.LlamacarcassbleedingProcedure$4] */
    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        int iIntValue;
        ItemStack mainHandItem;
        int iIntValue2;
        BlockEntity _bexxx;
        BlockEntity _bexx;
        BlockEntity _bex;
        BlockEntity _be;
        ItemStack mainHandItem2;
        if (entity != null) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BROWN_LLAMA_CARCASS.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CREAMY_LLAMA_CARCASS.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GRAY_LLAMA_CARCASS.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WHITE_LLAMA_CARCASS.get()) {
                Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip9 = property;
                    iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip9)).intValue();
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
                            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BROWN_LLAMA_CARCASS.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CREAMY_LLAMA_CARCASS.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GRAY_LLAMA_CARCASS.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WHITE_LLAMA_CARCASS.get()) {
                                Property<?> property2 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                                if (property2 instanceof IntegerProperty) {
                                    Property<?> _getip34 = property2;
                                    iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip34)).intValue();
                                } else {
                                    iIntValue2 = -1;
                                }
                                if (iIntValue2 == 1) {
                                    if (!world.isClientSide()) {
                                        BlockPos _bpx = BlockPos.containing(x, y, z);
                                        BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                                        BlockState _bsx = world.getBlockState(_bpx);
                                        if (_blockEntityx != null) {
                                            ButcheryPersistentData.of(_blockEntityx).putBoolean("isBleeding", false);
                                            ButcheryPersistentData.of(_blockEntityx).putBoolean("isDrained", true);
                                        }
                                        if (world instanceof Level) {
                                            Level _levelxxxx = (Level) world;
                                            _levelxxxx.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                                        }
                                    }
                                    InstantfillbloodgrateProcedure.execute(world, x, y, z);
                                    if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BROWN_LLAMA_CARCASS.get()) {
                                        BlockPos _bpxx = BlockPos.containing(x, y, z);
                                        BlockState _bsxx = new Object() { // from class: net.mcreator.butchery.procedures.LlamacarcassbleedingProcedure.1
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
                                        }.with(((Block) ButcheryModBlocks.DRAINED_BROWN_LLAMA_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                                        BlockState _bso = world.getBlockState(_bpxx);
                                        for (Property<?> _propertyOld : _bso.getProperties()) {
                                            Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                                            if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                                                try {
                                                    _bsxx = (BlockState) _bsxx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                                                } catch (Exception e) {
                                                }
                                            }
                                        }
                                        BlockEntity _be2 = world.getBlockEntity(_bpxx);
                                        CompoundTag _bnbt = null;
                                        if (_be2 != null) {
                                            _bnbt = _be2.saveWithFullMetadata(world.registryAccess());
                                            _be2.setRemoved();
                                        }
                                        world.setBlock(_bpxx, _bsxx, 3);
                                        if (_bnbt != null && (_be = world.getBlockEntity(_bpxx)) != null) {
                                            try {
                                                _be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
                                            } catch (Exception e2) {
                                            }
                                        }
                                    } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CREAMY_LLAMA_CARCASS.get()) {
                                        BlockPos _bpxx2 = BlockPos.containing(x, y, z);
                                        BlockState _bsxx2 = new Object() { // from class: net.mcreator.butchery.procedures.LlamacarcassbleedingProcedure.2
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
                                        }.with(((Block) ButcheryModBlocks.DRAINED_CREAMY_LLAMA_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                                        BlockState _bso2 = world.getBlockState(_bpxx2);
                                        for (Property<?> _propertyOldx : _bso2.getProperties()) {
                                            Property _propertyNew2 = _bsxx2.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                                            if (_propertyNew2 != null && _bsxx2.getValue(_propertyNew2) != null) {
                                                try {
                                                    _bsxx2 = (BlockState) _bsxx2.setValue(_propertyNew2, _bso2.getValue(_propertyOldx));
                                                } catch (Exception e3) {
                                                }
                                            }
                                        }
                                        BlockEntity _bex2 = world.getBlockEntity(_bpxx2);
                                        CompoundTag _bnbtx = null;
                                        if (_bex2 != null) {
                                            _bnbtx = _bex2.saveWithFullMetadata(world.registryAccess());
                                            _bex2.setRemoved();
                                        }
                                        world.setBlock(_bpxx2, _bsxx2, 3);
                                        if (_bnbtx != null && (_bex = world.getBlockEntity(_bpxx2)) != null) {
                                            try {
                                                _bex.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtx));
                                            } catch (Exception e4) {
                                            }
                                        }
                                    } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GRAY_LLAMA_CARCASS.get()) {
                                        BlockPos _bpxx3 = BlockPos.containing(x, y, z);
                                        BlockState _bsxx3 = new Object() { // from class: net.mcreator.butchery.procedures.LlamacarcassbleedingProcedure.3
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
                                        }.with(((Block) ButcheryModBlocks.DRAINED_GRAY_LLAMA_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                                        BlockState _bso3 = world.getBlockState(_bpxx3);
                                        for (Property<?> _propertyOldxx : _bso3.getProperties()) {
                                            Property _propertyNew3 = _bsxx3.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                                            if (_propertyNew3 != null && _bsxx3.getValue(_propertyNew3) != null) {
                                                try {
                                                    _bsxx3 = (BlockState) _bsxx3.setValue(_propertyNew3, _bso3.getValue(_propertyOldxx));
                                                } catch (Exception e5) {
                                                }
                                            }
                                        }
                                        BlockEntity _bexx2 = world.getBlockEntity(_bpxx3);
                                        CompoundTag _bnbtxx = null;
                                        if (_bexx2 != null) {
                                            _bnbtxx = _bexx2.saveWithFullMetadata(world.registryAccess());
                                            _bexx2.setRemoved();
                                        }
                                        world.setBlock(_bpxx3, _bsxx3, 3);
                                        if (_bnbtxx != null && (_bexx = world.getBlockEntity(_bpxx3)) != null) {
                                            try {
                                                _bexx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxx));
                                            } catch (Exception e6) {
                                            }
                                        }
                                    } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WHITE_LLAMA_CARCASS.get()) {
                                        BlockPos _bpxx4 = BlockPos.containing(x, y, z);
                                        BlockState _bsxx4 = new Object() { // from class: net.mcreator.butchery.procedures.LlamacarcassbleedingProcedure.4
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
                                        }.with(((Block) ButcheryModBlocks.DRAINED_WHITE_LLAMA_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                                        BlockState _bso4 = world.getBlockState(_bpxx4);
                                        for (Property<?> _propertyOldxxx : _bso4.getProperties()) {
                                            Property _propertyNew4 = _bsxx4.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                                            if (_propertyNew4 != null && _bsxx4.getValue(_propertyNew4) != null) {
                                                try {
                                                    _bsxx4 = (BlockState) _bsxx4.setValue(_propertyNew4, _bso4.getValue(_propertyOldxxx));
                                                } catch (Exception e7) {
                                                }
                                            }
                                        }
                                        BlockEntity _bexxx2 = world.getBlockEntity(_bpxx4);
                                        CompoundTag _bnbtxxx = null;
                                        if (_bexxx2 != null) {
                                            _bnbtxxx = _bexxx2.saveWithFullMetadata(world.registryAccess());
                                            _bexxx2.setRemoved();
                                        }
                                        world.setBlock(_bpxx4, _bsxx4, 3);
                                        if (_bnbtxxx != null && (_bexxx = world.getBlockEntity(_bpxx4)) != null) {
                                            try {
                                                _bexxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxx));
                                            } catch (Exception e8) {
                                            }
                                        }
                                    }
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
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false);
        }
        return false;
    }
}
