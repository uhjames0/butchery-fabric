package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
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
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: IronGolemCutUpProcedure.class */
public class IronGolemCutUpProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ItemStack mainHandItem;
        ItemStack mainHandItem2;
        ItemStack mainHandItem3;
        ItemStack mainHandItem4;
        ItemStack mainHandItem5;
        ItemStack mainHandItem6;
        ItemStack mainHandItem7;
        ItemStack mainHandItem8;
        ItemStack mainHandItem9;
        ItemStack mainHandItem10;
        ItemStack mainHandItem11;
        ItemStack mainHandItem12;
        ItemStack mainHandItem13;
        ItemStack mainHandItem14;
        ItemStack mainHandItem15;
        ItemStack mainHandItem16;
        ItemStack mainHandItem17;
        ItemStack mainHandItem18;
        ItemStack mainHandItem19;
        ItemStack mainHandItem20;
        ItemStack mainHandItem21;
        ItemStack mainHandItem22;
        ItemStack mainHandItem23;
        ItemStack mainHandItem24;
        ItemStack mainHandItem25;
        ItemStack mainHandItem26;
        ItemStack mainHandItem27;
        ItemStack mainHandItem28;
        int iIntValue;
        int iIntValue2;
        ItemStack mainHandItem29;
        int iIntValue3;
        int iIntValue4;
        ItemStack mainHandItem30;
        ItemStack mainHandItem31;
        ItemStack mainHandItem32;
        int iIntValue5;
        int iIntValue6;
        ItemStack mainHandItem33;
        ItemStack mainHandItem34;
        ItemStack mainHandItem35;
        int iIntValue7;
        int iIntValue8;
        ItemStack mainHandItem36;
        ItemStack mainHandItem37;
        ItemStack mainHandItem38;
        ItemStack mainHandItem39;
        if (entity != null) {
            if (entity instanceof LivingEntity) {
                LivingEntity _livEntx = (LivingEntity) entity;
                mainHandItem = _livEntx.getMainHandItem();
            } else {
                mainHandItem = ItemStack.EMPTY;
            }
            if (!mainHandItem.is(TagKey.create(Registries.ITEM, Identifier.parse("forge:hacksaw")))) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity) entity;
                    mainHandItem39 = _livEnt.getMainHandItem();
                } else {
                    mainHandItem39 = ItemStack.EMPTY;
                }
                if (!mainHandItem39.is(TagKey.create(Registries.ITEM, Identifier.parse("c:hacksaw")))) {
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.IRON_GOLEM.get()) {
                Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip7 = property;
                    iIntValue7 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip7)).intValue();
                } else {
                    iIntValue7 = -1;
                }
                if (iIntValue7 == 0) {
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 0.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bp = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntity = world.getBlockEntity(_bp);
                            BlockState _bs = world.getBlockState(_bp);
                            if (_blockEntity != null) {
                                ButcheryPersistentData.of(_blockEntity).putDouble("golemSaw", 1.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx = (LivingEntity) entity;
                                mainHandItem38 = _livEntxx.getMainHandItem();
                            } else {
                                mainHandItem38 = ItemStack.EMPTY;
                            }
                            mainHandItem38.hurtAndBreak(1, _level, (ServerPlayer) null, _stkprov -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity) entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _level2 = (Level) world;
                            if (!_level2.isClientSide()) {
                                _level2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _level2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                            return;
                        }
                        return;
                    }
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 1.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                            BlockState _bsx = world.getBlockState(_bpx);
                            if (_blockEntityx != null) {
                                ButcheryPersistentData.of(_blockEntityx).putDouble("golemSaw", 2.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelx = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx2 = (LivingEntity) entity;
                                mainHandItem37 = _livEntxx2.getMainHandItem();
                            } else {
                                mainHandItem37 = ItemStack.EMPTY;
                            }
                            mainHandItem37.hurtAndBreak(1, _levelx, (ServerPlayer) null, _stkprov2 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity2 = (LivingEntity) entity;
                            _entity2.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _levelx2 = (Level) world;
                            if (!_levelx2.isClientSide()) {
                                _levelx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                            return;
                        }
                        return;
                    }
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 2.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                            BlockState _bsxx = world.getBlockState(_bpxx);
                            if (_blockEntityxx != null) {
                                ButcheryPersistentData.of(_blockEntityxx).putDouble("golemSaw", 3.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxx = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx3 = (LivingEntity) entity;
                                mainHandItem36 = _livEntxx3.getMainHandItem();
                            } else {
                                mainHandItem36 = ItemStack.EMPTY;
                            }
                            mainHandItem36.hurtAndBreak(1, _levelxx, (ServerPlayer) null, _stkprov3 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity3 = (LivingEntity) entity;
                            _entity3.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxx2 = (Level) world;
                            if (!_levelxx2.isClientSide()) {
                                _levelxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        Property<?> property2 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property2 instanceof IntegerProperty) {
                            Property<?> _getip55 = property2;
                            iIntValue8 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip55)).intValue();
                        } else {
                            iIntValue8 = -1;
                        }
                        if (iIntValue8 == 0) {
                            BlockPos _pos = BlockPos.containing(x, y, z);
                            BlockState _bsxxx = world.getBlockState(_pos);
                            Property<?> property3 = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property3 instanceof IntegerProperty) {
                                IntegerProperty _integerProp = (IntegerProperty) property3;
                                if (_integerProp.getPossibleValues().contains(1)) {
                                    world.setBlock(_pos, (BlockState) _bsxxx.setValue(_integerProp, 1), 3);
                                }
                            }
                            if (!world.isClientSide() && world.getServer() != null) {
                                ObjectListIterator var339 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_head_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                while (var339.hasNext()) {
                                    ItemStack itemstackiterator = (ItemStack) var339.next();
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _levelxxx = (ServerLevel) world;
                                        ItemEntity entityToSpawn = new ItemEntity(_levelxxx, x, y, z, itemstackiterator);
                                        entityToSpawn.setPickUpDelay(10);
                                        _levelxxx.addFreshEntity(entityToSpawn);
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.IRON_GOLEM.get()) {
                Property<?> property4 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property4 instanceof IntegerProperty) {
                    Property<?> _getip63 = property4;
                    iIntValue5 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip63)).intValue();
                } else {
                    iIntValue5 = -1;
                }
                if (iIntValue5 == 1) {
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 3.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpxxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                            BlockState _bsxxxx = world.getBlockState(_bpxxx);
                            if (_blockEntityxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxx).putDouble("golemSaw", 4.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpxxx, _bsxxxx, _bsxxxx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx2 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx4 = (LivingEntity) entity;
                                mainHandItem35 = _livEntxx4.getMainHandItem();
                            } else {
                                mainHandItem35 = ItemStack.EMPTY;
                            }
                            mainHandItem35.hurtAndBreak(1, _levelxxx2, (ServerPlayer) null, _stkprov4 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity4 = (LivingEntity) entity;
                            _entity4.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _levelxxx3 = (Level) world;
                            if (!_levelxxx3.isClientSide()) {
                                _levelxxx3.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxx3.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                            return;
                        }
                        return;
                    }
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 4.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                            BlockState _bsxxxxx = world.getBlockState(_bpxxxx);
                            if (_blockEntityxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxx).putDouble("golemSaw", 5.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpxxxx, _bsxxxxx, _bsxxxxx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxx = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx5 = (LivingEntity) entity;
                                mainHandItem34 = _livEntxx5.getMainHandItem();
                            } else {
                                mainHandItem34 = ItemStack.EMPTY;
                            }
                            mainHandItem34.hurtAndBreak(1, _levelxxxx, (ServerPlayer) null, _stkprov5 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity5 = (LivingEntity) entity;
                            _entity5.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _levelxxxx2 = (Level) world;
                            if (!_levelxxxx2.isClientSide()) {
                                _levelxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                            return;
                        }
                        return;
                    }
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 5.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                            BlockState _bsxxxxxx = world.getBlockState(_bpxxxxx);
                            if (_blockEntityxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxx).putDouble("golemSaw", 6.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpxxxxx, _bsxxxxxx, _bsxxxxxx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxx = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx6 = (LivingEntity) entity;
                                mainHandItem33 = _livEntxx6.getMainHandItem();
                            } else {
                                mainHandItem33 = ItemStack.EMPTY;
                            }
                            mainHandItem33.hurtAndBreak(1, _levelxxxxx, (ServerPlayer) null, _stkprov6 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity6 = (LivingEntity) entity;
                            _entity6.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxx2 = (Level) world;
                            if (!_levelxxxxx2.isClientSide()) {
                                _levelxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
                        Property<?> property5 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property5 instanceof IntegerProperty) {
                            Property<?> _getip111 = property5;
                            iIntValue6 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip111)).intValue();
                        } else {
                            iIntValue6 = -1;
                        }
                        if (iIntValue6 == 1) {
                            BlockPos _posx = BlockPos.containing(x, y, z);
                            BlockState _bsxxxxxxx = world.getBlockState(_posx);
                            Property<?> property6 = _bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property6 instanceof IntegerProperty) {
                                IntegerProperty _integerProp2 = (IntegerProperty) property6;
                                if (_integerProp2.getPossibleValues().contains(2)) {
                                    world.setBlock(_posx, (BlockState) _bsxxxxxxx.setValue(_integerProp2, 2), 3);
                                }
                            }
                            if (!world.isClientSide() && world.getServer() != null) {
                                ObjectListIterator var330 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_arm_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                while (var330.hasNext()) {
                                    ItemStack itemstackiterator2 = (ItemStack) var330.next();
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _levelxxxxxx = (ServerLevel) world;
                                        ItemEntity entityToSpawn2 = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator2);
                                        entityToSpawn2.setPickUpDelay(10);
                                        _levelxxxxxx.addFreshEntity(entityToSpawn2);
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.IRON_GOLEM.get()) {
                Property<?> property7 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property7 instanceof IntegerProperty) {
                    Property<?> _getip119 = property7;
                    iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip119)).intValue();
                } else {
                    iIntValue3 = -1;
                }
                if (iIntValue3 == 2) {
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 6.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
                            BlockState _bsxxxxxxxx = world.getBlockState(_bpxxxxxx);
                            if (_blockEntityxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxx).putDouble("golemSaw", 7.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpxxxxxx, _bsxxxxxxxx, _bsxxxxxxxx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxx2 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx7 = (LivingEntity) entity;
                                mainHandItem32 = _livEntxx7.getMainHandItem();
                            } else {
                                mainHandItem32 = ItemStack.EMPTY;
                            }
                            mainHandItem32.hurtAndBreak(1, _levelxxxxxx2, (ServerPlayer) null, _stkprov7 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity7 = (LivingEntity) entity;
                            _entity7.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxx3 = (Level) world;
                            if (!_levelxxxxxx3.isClientSide()) {
                                _levelxxxxxx3.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxx3.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                            return;
                        }
                        return;
                    }
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 7.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
                            BlockState _bsxxxxxxxxx = world.getBlockState(_bpxxxxxxx);
                            if (_blockEntityxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxx).putDouble("golemSaw", 8.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxxxx, _bsxxxxxxxxx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxx = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx8 = (LivingEntity) entity;
                                mainHandItem31 = _livEntxx8.getMainHandItem();
                            } else {
                                mainHandItem31 = ItemStack.EMPTY;
                            }
                            mainHandItem31.hurtAndBreak(1, _levelxxxxxxx, (ServerPlayer) null, _stkprov8 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity8 = (LivingEntity) entity;
                            _entity8.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxxx2 = (Level) world;
                            if (!_levelxxxxxxx2.isClientSide()) {
                                _levelxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                            return;
                        }
                        return;
                    }
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 8.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxxxxxxxx = world.getBlockEntity(_bpxxxxxxxx);
                            BlockState _bsxxxxxxxxxx = world.getBlockState(_bpxxxxxxxx);
                            if (_blockEntityxxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxxx).putDouble("golemSaw", 9.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpxxxxxxxx, _bsxxxxxxxxxx, _bsxxxxxxxxxx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxx = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx9 = (LivingEntity) entity;
                                mainHandItem30 = _livEntxx9.getMainHandItem();
                            } else {
                                mainHandItem30 = ItemStack.EMPTY;
                            }
                            mainHandItem30.hurtAndBreak(1, _levelxxxxxxxx, (ServerPlayer) null, _stkprov9 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity9 = (LivingEntity) entity;
                            _entity9.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxx2 = (Level) world;
                            if (!_levelxxxxxxxx2.isClientSide()) {
                                _levelxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        Property<?> property8 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property8 instanceof IntegerProperty) {
                            Property<?> _getip167 = property8;
                            iIntValue4 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip167)).intValue();
                        } else {
                            iIntValue4 = -1;
                        }
                        if (iIntValue4 == 2) {
                            BlockPos _posxx = BlockPos.containing(x, y, z);
                            BlockState _bsxxxxxxxxxxx = world.getBlockState(_posxx);
                            Property<?> property9 = _bsxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property9 instanceof IntegerProperty) {
                                IntegerProperty _integerProp3 = (IntegerProperty) property9;
                                if (_integerProp3.getPossibleValues().contains(3)) {
                                    world.setBlock(_posxx, (BlockState) _bsxxxxxxxxxxx.setValue(_integerProp3, 3), 3);
                                }
                            }
                            if (!world.isClientSide() && world.getServer() != null) {
                                ObjectListIterator var321 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_body_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                while (var321.hasNext()) {
                                    ItemStack itemstackiterator3 = (ItemStack) var321.next();
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _levelxxxxxxxxx = (ServerLevel) world;
                                        ItemEntity entityToSpawn3 = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator3);
                                        entityToSpawn3.setPickUpDelay(10);
                                        _levelxxxxxxxxx.addFreshEntity(entityToSpawn3);
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.IRON_GOLEM.get()) {
                Property<?> property10 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property10 instanceof IntegerProperty) {
                    Property<?> _getip175 = property10;
                    iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip175)).intValue();
                } else {
                    iIntValue = -1;
                }
                if (iIntValue == 3) {
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 9.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpxxxxxxxxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxx);
                            BlockState _bsxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxx);
                            if (_blockEntityxxxxxxxxx != null) {
                                ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putDouble("golemSaw", 10.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpxxxxxxxxx, _bsxxxxxxxxxxxx, _bsxxxxxxxxxxxx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxxx2 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx10 = (LivingEntity) entity;
                                mainHandItem29 = _livEntxx10.getMainHandItem();
                            } else {
                                mainHandItem29 = ItemStack.EMPTY;
                            }
                            mainHandItem29.hurtAndBreak(1, _levelxxxxxxxxx2, (ServerPlayer) null, _stkprov10 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity10 = (LivingEntity) entity;
                            _entity10.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxx3 = (Level) world;
                            if (!_levelxxxxxxxxx3.isClientSide()) {
                                _levelxxxxxxxxx3.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxx3.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        Property<?> property11 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property11 instanceof IntegerProperty) {
                            IntegerProperty _getip193 = (IntegerProperty) property11;
                            iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip193)).intValue();
                        } else {
                            iIntValue2 = -1;
                        }
                        if (iIntValue2 == 3) {
                            if (!world.isClientSide() && world.getServer() != null) {
                                ObjectListIterator var312 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_legs_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                while (var312.hasNext()) {
                                    ItemStack itemstackiterator4 = (ItemStack) var312.next();
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _levelxxxxxxxxxx = (ServerLevel) world;
                                        ItemEntity entityToSpawn4 = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator4);
                                        entityToSpawn4.setPickUpDelay(10);
                                        _levelxxxxxxxxxx.addFreshEntity(entityToSpawn4);
                                    }
                                }
                            }
                            world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.IRON_GOLEM_ARMS.get()) {
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 0.0d) {
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxx);
                        BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxx);
                        if (_blockEntityxxxxxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putDouble("golemSaw", 1.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxxxxxxxxxx, _bsxxxxxxxxxxxxx, _bsxxxxxxxxxxxxx, 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxx2 = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx11 = (LivingEntity) entity;
                            mainHandItem28 = _livEntxx11.getMainHandItem();
                        } else {
                            mainHandItem28 = ItemStack.EMPTY;
                        }
                        mainHandItem28.hurtAndBreak(1, _levelxxxxxxxxxx2, (ServerPlayer) null, _stkprov11 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity11 = (LivingEntity) entity;
                        _entity11.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxx3 = (Level) world;
                        if (!_levelxxxxxxxxxx3.isClientSide()) {
                            _levelxxxxxxxxxx3.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxxxxxxx3.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 0.0d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.0d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 1.0d) {
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxx);
                        BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxx);
                        if (_blockEntityxxxxxxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putDouble("golemSaw", 2.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxx = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx12 = (LivingEntity) entity;
                            mainHandItem27 = _livEntxx12.getMainHandItem();
                        } else {
                            mainHandItem27 = ItemStack.EMPTY;
                        }
                        mainHandItem27.hurtAndBreak(1, _levelxxxxxxxxxxx, (ServerPlayer) null, _stkprov12 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity12 = (LivingEntity) entity;
                        _entity12.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 0.0d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.0d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 2.0d) {
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxx);
                        BlockState _bsxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxx);
                        if (_blockEntityxxxxxxxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putDouble("golemSaw", 3.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxx, 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxx = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx13 = (LivingEntity) entity;
                            mainHandItem26 = _livEntxx13.getMainHandItem();
                        } else {
                            mainHandItem26 = ItemStack.EMPTY;
                        }
                        mainHandItem26.hurtAndBreak(1, _levelxxxxxxxxxxxx, (ServerPlayer) null, _stkprov13 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity13 = (LivingEntity) entity;
                        _entity13.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 0.0d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.0d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
                    world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var68 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var68.hasNext()) {
                            ItemStack itemstackiterator5 = (ItemStack) var68.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxxxxxxxxxxxxx = (ServerLevel) world;
                                ItemEntity entityToSpawn5 = new ItemEntity(_levelxxxxxxxxxxxxx, x, y, z, itemstackiterator5);
                                entityToSpawn5.setPickUpDelay(10);
                                _levelxxxxxxxxxxxxx.addFreshEntity(entityToSpawn5);
                            }
                        }
                    }
                    if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx = (LivingEntity) entity;
                            mainHandItem20 = _livEntxxx.getMainHandItem();
                        } else {
                            mainHandItem20 = ItemStack.EMPTY;
                        }
                        if (mainHandItem20.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx14 = (LivingEntity) entity;
                                mainHandItem25 = _livEntxx14.getMainHandItem();
                            } else {
                                mainHandItem25 = ItemStack.EMPTY;
                            }
                            if (mainHandItem25.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                for (int index0 = 0; index0 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index0++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var425 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var425.hasNext()) {
                                            ItemStack itemstackiterator6 = (ItemStack) var425.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxxxxxxxxx2 = (ServerLevel) world;
                                                ItemEntity entityToSpawn6 = new ItemEntity(_levelxxxxxxxxxxxxx2, x, y, z, itemstackiterator6);
                                                entityToSpawn6.setPickUpDelay(10);
                                                _levelxxxxxxxxxxxxx2.addFreshEntity(entityToSpawn6);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx2 = (LivingEntity) entity;
                            mainHandItem21 = _livEntxxx2.getMainHandItem();
                        } else {
                            mainHandItem21 = ItemStack.EMPTY;
                        }
                        if (mainHandItem21.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx15 = (LivingEntity) entity;
                                mainHandItem24 = _livEntxx15.getMainHandItem();
                            } else {
                                mainHandItem24 = ItemStack.EMPTY;
                            }
                            if (mainHandItem24.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                for (int index1 = 0; index1 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index1++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var424 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var424.hasNext()) {
                                            ItemStack itemstackiterator7 = (ItemStack) var424.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxxxxxxxxx3 = (ServerLevel) world;
                                                ItemEntity entityToSpawn7 = new ItemEntity(_levelxxxxxxxxxxxxx3, x, y, z, itemstackiterator7);
                                                entityToSpawn7.setPickUpDelay(10);
                                                _levelxxxxxxxxxxxxx3.addFreshEntity(entityToSpawn7);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx3 = (LivingEntity) entity;
                            mainHandItem22 = _livEntxxx3.getMainHandItem();
                        } else {
                            mainHandItem22 = ItemStack.EMPTY;
                        }
                        if (mainHandItem22.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx16 = (LivingEntity) entity;
                                mainHandItem23 = _livEntxx16.getMainHandItem();
                            } else {
                                mainHandItem23 = ItemStack.EMPTY;
                            }
                            if (mainHandItem23.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                for (int index2 = 0; index2 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index2++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var22 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var22.hasNext()) {
                                            ItemStack itemstackiterator8 = (ItemStack) var22.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxxxxxxxxx4 = (ServerLevel) world;
                                                ItemEntity entityToSpawn8 = new ItemEntity(_levelxxxxxxxxxxxxx4, x, y, z, itemstackiterator8);
                                                entityToSpawn8.setPickUpDelay(10);
                                                _levelxxxxxxxxxxxxx4.addFreshEntity(entityToSpawn8);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.IRON_GOLEM_BODY.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.REPAIRED_IRON_GOLEM_BODY.get()) {
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 0.0d) {
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxxx);
                        BlockState _bsxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxxx);
                        if (_blockEntityxxxxxxxxxxxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxxx).putDouble("golemSaw", 1.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxx, 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx17 = (LivingEntity) entity;
                            mainHandItem10 = _livEntxx17.getMainHandItem();
                        } else {
                            mainHandItem10 = ItemStack.EMPTY;
                        }
                        mainHandItem10.hurtAndBreak(1, _levelxxxxxxxxxxxxxxxx, (ServerPlayer) null, _stkprov14 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity14 = (LivingEntity) entity;
                        _entity14.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 0.0d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.0d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 1.0d) {
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxxxx);
                        BlockState _bsxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxxxx);
                        if (_blockEntityxxxxxxxxxxxxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxxxx).putDouble("golemSaw", 2.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxx, 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx18 = (LivingEntity) entity;
                            mainHandItem9 = _livEntxx18.getMainHandItem();
                        } else {
                            mainHandItem9 = ItemStack.EMPTY;
                        }
                        mainHandItem9.hurtAndBreak(1, _levelxxxxxxxxxxxxxxxxx, (ServerPlayer) null, _stkprov15 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity15 = (LivingEntity) entity;
                        _entity15.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 0.0d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.0d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 2.0d) {
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxxxxx);
                        BlockState _bsxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxxxxx);
                        if (_blockEntityxxxxxxxxxxxxxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxxxxx).putDouble("golemSaw", 3.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxx, 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx19 = (LivingEntity) entity;
                            mainHandItem8 = _livEntxx19.getMainHandItem();
                        } else {
                            mainHandItem8 = ItemStack.EMPTY;
                        }
                        mainHandItem8.hurtAndBreak(1, _levelxxxxxxxxxxxxxxxxxx, (ServerPlayer) null, _stkprov16 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity16 = (LivingEntity) entity;
                        _entity16.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 0.0d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.0d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
                    world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var109 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var109.hasNext()) {
                            ItemStack itemstackiterator9 = (ItemStack) var109.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                                ItemEntity entityToSpawn9 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator9);
                                entityToSpawn9.setPickUpDelay(10);
                                _levelxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn9);
                            }
                        }
                    }
                    if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx4 = (LivingEntity) entity;
                            mainHandItem2 = _livEntxxx4.getMainHandItem();
                        } else {
                            mainHandItem2 = ItemStack.EMPTY;
                        }
                        if (mainHandItem2.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx20 = (LivingEntity) entity;
                                mainHandItem7 = _livEntxx20.getMainHandItem();
                            } else {
                                mainHandItem7 = ItemStack.EMPTY;
                            }
                            if (mainHandItem7.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                for (int index3 = 0; index3 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index3++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var428 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var428.hasNext()) {
                                            ItemStack itemstackiterator10 = (ItemStack) var428.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxxxxxxxxxxxxxxx2 = (ServerLevel) world;
                                                ItemEntity entityToSpawn10 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxx2, x, y, z, itemstackiterator10);
                                                entityToSpawn10.setPickUpDelay(10);
                                                _levelxxxxxxxxxxxxxxxxxxx2.addFreshEntity(entityToSpawn10);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx5 = (LivingEntity) entity;
                            mainHandItem3 = _livEntxxx5.getMainHandItem();
                        } else {
                            mainHandItem3 = ItemStack.EMPTY;
                        }
                        if (mainHandItem3.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx21 = (LivingEntity) entity;
                                mainHandItem6 = _livEntxx21.getMainHandItem();
                            } else {
                                mainHandItem6 = ItemStack.EMPTY;
                            }
                            if (mainHandItem6.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                for (int index4 = 0; index4 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index4++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var427 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var427.hasNext()) {
                                            ItemStack itemstackiterator11 = (ItemStack) var427.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxxxxxxxxxxxxxxx3 = (ServerLevel) world;
                                                ItemEntity entityToSpawn11 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxx3, x, y, z, itemstackiterator11);
                                                entityToSpawn11.setPickUpDelay(10);
                                                _levelxxxxxxxxxxxxxxxxxxx3.addFreshEntity(entityToSpawn11);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx6 = (LivingEntity) entity;
                            mainHandItem4 = _livEntxxx6.getMainHandItem();
                        } else {
                            mainHandItem4 = ItemStack.EMPTY;
                        }
                        if (mainHandItem4.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx22 = (LivingEntity) entity;
                                mainHandItem5 = _livEntxx22.getMainHandItem();
                            } else {
                                mainHandItem5 = ItemStack.EMPTY;
                            }
                            if (mainHandItem5.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                for (int index5 = 0; index5 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index5++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var426 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var426.hasNext()) {
                                            ItemStack itemstackiterator12 = (ItemStack) var426.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxxxxxxxxxxxxxxx4 = (ServerLevel) world;
                                                ItemEntity entityToSpawn12 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxx4, x, y, z, itemstackiterator12);
                                                entityToSpawn12.setPickUpDelay(10);
                                                _levelxxxxxxxxxxxxxxxxxxx4.addFreshEntity(entityToSpawn12);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.IRON_GOLEM_LEGS.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.REPAIRED_IRON_GOLEM_LEGS.get()) {
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 0.0d) {
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxx);
                        BlockState _bsxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxx);
                        if (_blockEntityxxxxxxxxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putDouble("golemSaw", 1.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxx, 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxx5 = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx23 = (LivingEntity) entity;
                            mainHandItem19 = _livEntxx23.getMainHandItem();
                        } else {
                            mainHandItem19 = ItemStack.EMPTY;
                        }
                        mainHandItem19.hurtAndBreak(1, _levelxxxxxxxxxxxxx5, (ServerPlayer) null, _stkprov17 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity17 = (LivingEntity) entity;
                        _entity17.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxx6 = (Level) world;
                        if (!_levelxxxxxxxxxxxxx6.isClientSide()) {
                            _levelxxxxxxxxxxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 0.0d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 1.0d) {
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxx);
                        BlockState _bsxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxx);
                        if (_blockEntityxxxxxxxxxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putDouble("golemSaw", 2.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxx, 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxx = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx24 = (LivingEntity) entity;
                            mainHandItem18 = _livEntxx24.getMainHandItem();
                        } else {
                            mainHandItem18 = ItemStack.EMPTY;
                        }
                        mainHandItem18.hurtAndBreak(1, _levelxxxxxxxxxxxxxx, (ServerPlayer) null, _stkprov18 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity18 = (LivingEntity) entity;
                        _entity18.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 0.0d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemSaw") == 2.0d) {
                    if (!world.isClientSide()) {
                        BlockPos _bpxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxx);
                        BlockState _bsxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxx);
                        if (_blockEntityxxxxxxxxxxxxxxx != null) {
                            ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxx).putDouble("golemSaw", 3.0d);
                        }
                        if (world instanceof Level) {
                            ((Level) world).sendBlockUpdated(_bpxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxx, 3);
                        }
                    }
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxxxxxxxxxxxxx = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx25 = (LivingEntity) entity;
                            mainHandItem17 = _livEntxx25.getMainHandItem();
                        } else {
                            mainHandItem17 = ItemStack.EMPTY;
                        }
                        mainHandItem17.hurtAndBreak(1, _levelxxxxxxxxxxxxxxx, (ServerPlayer) null, _stkprov19 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity19 = (LivingEntity) entity;
                        _entity19.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 0.0d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                    }
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
                    world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                    if (world instanceof Level) {
                        Level _levelxxxxxxxxxxxxxxx2 = (Level) world;
                        if (!_levelxxxxxxxxxxxxxxx2.isClientSide()) {
                            _levelxxxxxxxxxxxxxxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxxxxxxxxxxxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:hacksaw")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var150 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var150.hasNext()) {
                            ItemStack itemstackiterator13 = (ItemStack) var150.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxxxxxxxxxxxxxxxx3 = (ServerLevel) world;
                                ItemEntity entityToSpawn13 = new ItemEntity(_levelxxxxxxxxxxxxxxxx3, x, y, z, itemstackiterator13);
                                entityToSpawn13.setPickUpDelay(10);
                                _levelxxxxxxxxxxxxxxxx3.addFreshEntity(entityToSpawn13);
                            }
                        }
                    }
                    if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx7 = (LivingEntity) entity;
                            mainHandItem11 = _livEntxxx7.getMainHandItem();
                        } else {
                            mainHandItem11 = ItemStack.EMPTY;
                        }
                        if (mainHandItem11.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx26 = (LivingEntity) entity;
                                mainHandItem16 = _livEntxx26.getMainHandItem();
                            } else {
                                mainHandItem16 = ItemStack.EMPTY;
                            }
                            if (mainHandItem16.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                for (int index6 = 0; index6 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index6++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var431 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var431.hasNext()) {
                                            ItemStack itemstackiterator14 = (ItemStack) var431.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxxxxxxxxxxxx4 = (ServerLevel) world;
                                                ItemEntity entityToSpawn14 = new ItemEntity(_levelxxxxxxxxxxxxxxxx4, x, y, z, itemstackiterator14);
                                                entityToSpawn14.setPickUpDelay(10);
                                                _levelxxxxxxxxxxxxxxxx4.addFreshEntity(entityToSpawn14);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx8 = (LivingEntity) entity;
                            mainHandItem12 = _livEntxxx8.getMainHandItem();
                        } else {
                            mainHandItem12 = ItemStack.EMPTY;
                        }
                        if (mainHandItem12.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx27 = (LivingEntity) entity;
                                mainHandItem15 = _livEntxx27.getMainHandItem();
                            } else {
                                mainHandItem15 = ItemStack.EMPTY;
                            }
                            if (mainHandItem15.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                for (int index7 = 0; index7 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index7++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var430 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var430.hasNext()) {
                                            ItemStack itemstackiterator15 = (ItemStack) var430.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxxxxxxxxxxxx5 = (ServerLevel) world;
                                                ItemEntity entityToSpawn15 = new ItemEntity(_levelxxxxxxxxxxxxxxxx5, x, y, z, itemstackiterator15);
                                                entityToSpawn15.setPickUpDelay(10);
                                                _levelxxxxxxxxxxxxxxxx5.addFreshEntity(entityToSpawn15);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx9 = (LivingEntity) entity;
                            mainHandItem13 = _livEntxxx9.getMainHandItem();
                        } else {
                            mainHandItem13 = ItemStack.EMPTY;
                        }
                        if (mainHandItem13.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx28 = (LivingEntity) entity;
                                mainHandItem14 = _livEntxx28.getMainHandItem();
                            } else {
                                mainHandItem14 = ItemStack.EMPTY;
                            }
                            if (mainHandItem14.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                for (int index8 = 0; index8 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index8++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var429 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/iron_golem_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var429.hasNext()) {
                                            ItemStack itemstackiterator16 = (ItemStack) var429.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxxxxxxxxxxxx6 = (ServerLevel) world;
                                                ItemEntity entityToSpawn16 = new ItemEntity(_levelxxxxxxxxxxxxxxxx6, x, y, z, itemstackiterator16);
                                                entityToSpawn16.setPickUpDelay(10);
                                                _levelxxxxxxxxxxxxxxxx6.addFreshEntity(entityToSpawn16);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0d);
        }
        return -1.0d;
    }
}
