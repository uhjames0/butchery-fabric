package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: RepairgolemProcedure.class */
public class RepairgolemProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        execute(null, world, x, y, z, blockstate, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        int iIntValue;
        ItemStack mainHandItem;
        int iIntValue2;
        ItemStack mainHandItem2;
        ItemStack mainHandItem3;
        ItemStack mainHandItem4;
        ItemStack mainHandItem5;
        ItemStack mainHandItem6;
        ItemStack mainHandItem7;
        if (entity != null && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.IRON_GOLEM.get()) {
            Property<?> property = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip3 = property;
                iIntValue = ((Integer) blockstate.getValue(_getip3)).intValue();
            } else {
                iIntValue = -1;
            }
            if (iIntValue == 0) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity) entity;
                    mainHandItem = _livEnt.getMainHandItem();
                } else {
                    mainHandItem = ItemStack.EMPTY;
                }
                if (mainHandItem.getItem() == Items.IRON_INGOT) {
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemRepaired") == 0.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bp = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntity = world.getBlockEntity(_bp);
                            BlockState _bs = world.getBlockState(_bp);
                            if (_blockEntity != null) {
                                ButcheryPersistentData.of(_blockEntity).putDouble("golemRepaired", 1.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx = (LivingEntity) entity;
                                mainHandItem7 = _livEntx.getMainHandItem();
                            } else {
                                mainHandItem7 = ItemStack.EMPTY;
                            }
                            mainHandItem7.hurtAndBreak(1, _level, (ServerPlayer) null, _stkprov -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity) entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (entity instanceof Player) {
                            Player _player = (Player) entity;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx2 = (LivingEntity) entity;
                                mainHandItem6 = _livEntx2.getMainHandItem();
                            } else {
                                mainHandItem6 = ItemStack.EMPTY;
                            }
                            ItemStack _stktoremove = mainHandItem6;
                            _player.getInventory().clearOrCountMatchingItems(p -> {
                                return _stktoremove.getItem() == p.getItem();
                            }, false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                        if (world instanceof Level) {
                            Level _level2 = (Level) world;
                            if (!_level2.isClientSide()) {
                                _level2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.anvil.place")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _level2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.anvil.place")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
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
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemRepaired") == 1.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                            BlockState _bsx = world.getBlockState(_bpx);
                            if (_blockEntityx != null) {
                                ButcheryPersistentData.of(_blockEntityx).putDouble("golemRepaired", 2.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelx = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx3 = (LivingEntity) entity;
                                mainHandItem5 = _livEntx3.getMainHandItem();
                            } else {
                                mainHandItem5 = ItemStack.EMPTY;
                            }
                            mainHandItem5.hurtAndBreak(1, _levelx, (ServerPlayer) null, _stkprov2 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity2 = (LivingEntity) entity;
                            _entity2.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (entity instanceof Player) {
                            Player _player2 = (Player) entity;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx4 = (LivingEntity) entity;
                                mainHandItem4 = _livEntx4.getMainHandItem();
                            } else {
                                mainHandItem4 = ItemStack.EMPTY;
                            }
                            ItemStack _stktoremove2 = mainHandItem4;
                            _player2.getInventory().clearOrCountMatchingItems(p2 -> {
                                return _stktoremove2.getItem() == p2.getItem();
                            }, false, 1, _player2.inventoryMenu.getCraftSlots());
                        }
                        if (world instanceof Level) {
                            Level _levelx2 = (Level) world;
                            if (!_levelx2.isClientSide()) {
                                _levelx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.anvil.place")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.anvil.place")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
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
                    if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "golemRepaired") == 2.0d) {
                        if (!world.isClientSide()) {
                            BlockPos _bpxx = BlockPos.containing(x, y, z);
                            BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                            BlockState _bsxx = world.getBlockState(_bpxx);
                            if (_blockEntityxx != null) {
                                ButcheryPersistentData.of(_blockEntityxx).putDouble("golemRepaired", 3.0d);
                            }
                            if (world instanceof Level) {
                                ((Level) world).sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxx = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx5 = (LivingEntity) entity;
                                mainHandItem3 = _livEntx5.getMainHandItem();
                            } else {
                                mainHandItem3 = ItemStack.EMPTY;
                            }
                            mainHandItem3.hurtAndBreak(1, _levelxx, (ServerPlayer) null, _stkprov3 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity3 = (LivingEntity) entity;
                            _entity3.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        if (entity instanceof Player) {
                            Player _player3 = (Player) entity;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntx6 = (LivingEntity) entity;
                                mainHandItem2 = _livEntx6.getMainHandItem();
                            } else {
                                mainHandItem2 = ItemStack.EMPTY;
                            }
                            ItemStack _stktoremove3 = mainHandItem2;
                            _player3.getInventory().clearOrCountMatchingItems(p3 -> {
                                return _stktoremove3.getItem() == p3.getItem();
                            }, false, 1, _player3.inventoryMenu.getCraftSlots());
                        }
                        if (world instanceof Level) {
                            Level _levelxx2 = (Level) world;
                            if (!_levelxx2.isClientSide()) {
                                _levelxx2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.anvil.place")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxx2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.anvil.place")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx = (ServerLevel) world;
                            _levelxxx.sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 1.0d, z + 0.5d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx2 = (ServerLevel) world;
                            _levelxxx2.sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.5d, z + 0.25d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx3 = (ServerLevel) world;
                            _levelxxx3.sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 0.5d, z + 0.75d, 40, 0.3d, 0.3d, 0.3d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx4 = (ServerLevel) world;
                            _levelxxx4.sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y, z + 0.5d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx5 = (ServerLevel) world;
                            _levelxxx5.sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y + 1.0d, z + 0.25d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx6 = (ServerLevel) world;
                            _levelxxx6.sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.5d, z + 0.75d, 40, 0.2d, 0.2d, 0.2d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx7 = (ServerLevel) world;
                            _levelxxx7.sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.5d, y + 0.5d, z + 0.5d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx8 = (ServerLevel) world;
                            _levelxxx8.sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.25d, y, z + 0.25d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxx9 = (ServerLevel) world;
                            _levelxxx9.sendParticles((SimpleParticleType) ButcheryModParticleTypes.SPARKS.get(), x + 0.75d, y + 1.0d, z + 0.75d, 40, 0.1d, 0.1d, 0.1d, 0.8d);
                        }
                        Property<?> property2 = blockstate.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property2 instanceof IntegerProperty) {
                            Property<?> _getip58 = property2;
                            iIntValue2 = ((Integer) blockstate.getValue(_getip58)).intValue();
                        } else {
                            iIntValue2 = -1;
                        }
                        if (iIntValue2 == 0) {
                            BlockPos _bpxxx = BlockPos.containing(x, y, z);
                            BlockState _bsxxx = ((Block) ButcheryModBlocks.REPAIRED_IRONGOLEM.get()).defaultBlockState();
                            BlockState _bso = world.getBlockState(_bpxxx);
                            for (Property<?> _propertyOld : _bso.getProperties()) {
                                Property _propertyNew = _bsxxx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                                if (_propertyNew != null && _bsxxx.getValue(_propertyNew) != null) {
                                    try {
                                        _bsxxx = (BlockState) _bsxxx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                                    } catch (Exception e) {
                                    }
                                }
                            }
                            world.setBlock(_bpxxx, _bsxxx, 3);
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
