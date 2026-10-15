package net.mcreator.butchery.procedures;

import java.util.Iterator;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.mcreator.butchery.shim.itemcap.ItemHandlerHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class CamelacidProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            CamelacidProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        CamelacidProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        block20: {
            block23: {
                ItemStack itemStack;
                ItemStack itemStack2;
                block22: {
                    block21: {
                        ItemStack itemStack3;
                        ItemStack itemStack4;
                        if (entity == null || !world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"forge:camel"))) && !world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"c:camel")))) break block20;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntx = (LivingEntity)entity;
                            itemStack4 = _livEntx.getMainHandItem();
                        } else {
                            itemStack4 = ItemStack.EMPTY;
                        }
                        if (itemStack4.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:acid_bottle")))) break block21;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity)entity;
                            itemStack3 = _livEnt.getMainHandItem();
                        } else {
                            itemStack3 = ItemStack.EMPTY;
                        }
                        if (!itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:acid_bottle")))) break block20;
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.empty")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"item.bottle.empty")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    if (world instanceof Level) {
                        Level _levelx = (Level)world;
                        if (!_levelx.isClientSide()) {
                            _levelx.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:acid")), SoundSource.NEUTRAL, 1.0f, 1.0f);
                        } else {
                            _levelx.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse((String)"butchery:acid")), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                        }
                    }
                    if (!(entity instanceof Player)) break block22;
                    Player _plr = (Player)entity;
                    if (_plr.getAbilities().instabuild) break block23;
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntxxx = (LivingEntity)entity;
                    itemStack2 = _livEntxxx.getMainHandItem();
                } else {
                    itemStack2 = ItemStack.EMPTY;
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEntxx = (LivingEntity)entity;
                    itemStack = _livEntxx.getMainHandItem();
                } else {
                    itemStack = ItemStack.EMPTY;
                }
                itemStack2.setCount(itemStack.getCount() - 1);
                if (entity instanceof Player) {
                    Player _player = (Player)entity;
                    ItemStack _setstack = new ItemStack((ItemLike)Items.GLASS_BOTTLE).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity)entity;
                _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
            if (world instanceof ServerLevel) {
                ServerLevel _levelxx = (ServerLevel)world;
                _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.5, y + 0.55, z + 0.5, 20, 0.1, 0.1, 0.1, 0.1);
            }
            ButcheryMod.queueServerWork(20, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.25, y, z + 0.25, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(40, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.55, y + 0.55, z + 0.55, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(60, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.5, y, z + 0.5, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(80, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.25, y + 0.55, z + 0.25, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(100, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.55, y, z + 0.55, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(120, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.5, y + 0.55, z + 0.5, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(140, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.25, y, z + 0.25, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(160, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.55, y, z + 0.55, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(180, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.25, y, z + 0.25, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(200, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _levelxx = (ServerLevel)world;
                    _levelxx.sendParticles((ParticleOptions)ParticleTypes.BUBBLE_POP, x + 0.55, y + 0.55, z + 0.55, 20, 0.1, 0.1, 0.1, 0.1);
                }
            });
            ButcheryMod.queueServerWork(220, () -> {
                int n;
                Property patt1$temp;
                BlockPos _bp;
                if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"forge:camel"))) || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"c:camel")))) {
                    int n2;
                    Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (patt0$temp instanceof IntegerProperty) {
                        Property<?> _getip43 = (IntegerProperty)patt0$temp;
                        n2 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip43);
                    } else {
                        n2 = -1;
                    }
                    if (n2 == 0) {
                        _bp = BlockPos.containing((double)x, (double)y, (double)z);
                        BlockState _bs = ((Block)ButcheryModBlocks.CAMEL_SKELETON.get()).defaultBlockState();
                        BlockState _bso = world.getBlockState(_bp);
                        Iterator i$ = _bso.getProperties().iterator();
                        while (true) {
                            if (!i$.hasNext()) {
                                world.setBlock(_bp, _bs, 3);
                                return;
                            }
                            Property _propertyOld = (Property)i$.next();
                            Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                            if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                            try {
                                _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
                            }
                            catch (Exception exception) {}
                        }
                    }
                }
                if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"forge:camel")))) {
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"c:camel")))) return;
                }
                if ((patt1$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate")) instanceof IntegerProperty) {
                    Property<?> _getip50 = (IntegerProperty)patt1$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip50);
                } else {
                    n = -1;
                }
                if (n != 1) return;
                _bp = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bs = new Object(){

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
                }.with(((Block)ButcheryModBlocks.CAMEL_SKELETON.get()).defaultBlockState(), "blockstate", 1);
                BlockState _bso = world.getBlockState(_bp);
                Iterator i$ = _bso.getProperties().iterator();
                while (true) {
                    if (!i$.hasNext()) {
                        world.setBlock(_bp, _bs, 3);
                        return;
                    }
                    Property _propertyOldx = (Property)i$.next();
                    Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                    if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                    try {
                        _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                    }
                    catch (Exception exception) {
                    }
                }
            });
        }
    }
}

