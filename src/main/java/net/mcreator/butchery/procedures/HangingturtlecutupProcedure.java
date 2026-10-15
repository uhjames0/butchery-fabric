package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
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

/* JADX INFO: loaded from: HangingturtlecutupProcedure.class */
public class HangingturtlecutupProcedure {
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
        int iIntValue;
        ItemStack mainHandItem2;
        ItemStack mainHandItem3;
        ItemStack mainHandItem4;
        ItemStack mainHandItem5;
        ItemStack mainHandItem6;
        ItemStack mainHandItem7;
        ItemStack mainHandItem8;
        int iIntValue2;
        ItemStack mainHandItem9;
        ItemStack mainHandItem10;
        ItemStack mainHandItem11;
        ItemStack mainHandItem12;
        ItemStack mainHandItem13;
        ItemStack mainHandItem14;
        ItemStack mainHandItem15;
        int iIntValue3;
        ItemStack mainHandItem16;
        ItemStack mainHandItem17;
        ItemStack mainHandItem18;
        ItemStack mainHandItem19;
        ItemStack mainHandItem20;
        ItemStack mainHandItem21;
        ItemStack mainHandItem22;
        int iIntValue4;
        ItemStack mainHandItem23;
        ItemStack mainHandItem24;
        ItemStack mainHandItem25;
        ItemStack mainHandItem26;
        ItemStack mainHandItem27;
        ItemStack mainHandItem28;
        ItemStack mainHandItem29;
        int iIntValue5;
        ItemStack mainHandItem30;
        ItemStack mainHandItem31;
        ItemStack mainHandItem32;
        ItemStack mainHandItem33;
        ItemStack mainHandItem34;
        ItemStack mainHandItem35;
        ItemStack mainHandItem36;
        int iIntValue6;
        ItemStack mainHandItem37;
        ItemStack mainHandItem38;
        ItemStack mainHandItem39;
        ItemStack mainHandItem40;
        ItemStack mainHandItem41;
        ItemStack mainHandItem42;
        ItemStack mainHandItem43;
        int iIntValue7;
        ItemStack mainHandItem44;
        ItemStack mainHandItem45;
        ItemStack mainHandItem46;
        ItemStack mainHandItem47;
        ItemStack mainHandItem48;
        ItemStack mainHandItem49;
        ItemStack mainHandItem50;
        int iIntValue8;
        ItemStack mainHandItem51;
        ItemStack mainHandItem52;
        ItemStack mainHandItem53;
        ItemStack mainHandItem54;
        ItemStack mainHandItem55;
        ItemStack mainHandItem56;
        ItemStack mainHandItem57;
        int iIntValue9;
        ItemStack mainHandItem58;
        ItemStack mainHandItem59;
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
                    mainHandItem59 = _livEnt.getMainHandItem();
                } else {
                    mainHandItem59 = ItemStack.EMPTY;
                }
                if (!mainHandItem59.is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) {
                    return;
                }
            }
            if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()) {
                    Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property instanceof IntegerProperty) {
                        Property<?> _getip8 = property;
                        iIntValue9 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip8)).intValue();
                    } else {
                        iIntValue9 = -1;
                    }
                    if (iIntValue9 == 17) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx = (LivingEntity) entity;
                                mainHandItem58 = _livEntxx.getMainHandItem();
                            } else {
                                mainHandItem58 = ItemStack.EMPTY;
                            }
                            mainHandItem58.hurtAndBreak(1, _level, (ServerPlayer) null, _stkprov -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity) entity;
                            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _pos = BlockPos.containing(x, y, z);
                        BlockState _bs = world.getBlockState(_pos);
                        Property<?> property2 = _bs.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property2 instanceof IntegerProperty) {
                            IntegerProperty _integerProp = (IntegerProperty) property2;
                            if (_integerProp.getPossibleValues().contains(1)) {
                                world.setBlock(_pos, (BlockState) _bs.setValue(_integerProp, 1), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _level2 = (Level) world;
                            if (!_level2.isClientSide()) {
                                _level2.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _level2.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelx = (Level) world;
                            if (!_levelx.isClientSide()) {
                                _levelx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.break")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.break")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var99 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_head_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var99.hasNext()) {
                                ItemStack itemstackiterator = (ItemStack) var99.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxx.addFreshEntity(entityToSpawn);
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()) {
                    Property<?> property3 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property3 instanceof IntegerProperty) {
                        Property<?> _getip22 = property3;
                        iIntValue8 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip22)).intValue();
                    } else {
                        iIntValue8 = -1;
                    }
                    if (iIntValue8 == 1) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxx2 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx2 = (LivingEntity) entity;
                                mainHandItem57 = _livEntxx2.getMainHandItem();
                            } else {
                                mainHandItem57 = ItemStack.EMPTY;
                            }
                            mainHandItem57.hurtAndBreak(1, _levelxx2, (ServerPlayer) null, _stkprov2 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity2 = (LivingEntity) entity;
                            _entity2.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posx = BlockPos.containing(x, y, z);
                        BlockState _bsx = world.getBlockState(_posx);
                        Property<?> property4 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property4 instanceof IntegerProperty) {
                            IntegerProperty _integerProp2 = (IntegerProperty) property4;
                            if (_integerProp2.getPossibleValues().contains(2)) {
                                world.setBlock(_posx, (BlockState) _bsx.setValue(_integerProp2, 2), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxx3 = (Level) world;
                            if (!_levelxx3.isClientSide()) {
                                _levelxx3.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxx3.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxx = (Level) world;
                            if (!_levelxxx.isClientSide()) {
                                _levelxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.break")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.break")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var92 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_leg_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var92.hasNext()) {
                                ItemStack itemstackiterator2 = (ItemStack) var92.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn2 = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator2);
                                    entityToSpawn2.setPickUpDelay(10);
                                    _levelxxxx.addFreshEntity(entityToSpawn2);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx = (LivingEntity) entity;
                                mainHandItem51 = _livEntxxx.getMainHandItem();
                            } else {
                                mainHandItem51 = ItemStack.EMPTY;
                            }
                            if (mainHandItem51.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx3 = (LivingEntity) entity;
                                    mainHandItem56 = _livEntxx3.getMainHandItem();
                                } else {
                                    mainHandItem56 = ItemStack.EMPTY;
                                }
                                if (mainHandItem56.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index0 = 0; index0 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index0++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var248 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_leg_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var248.hasNext()) {
                                                ItemStack itemstackiterator3 = (ItemStack) var248.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn3 = new ItemEntity(_levelxxxx2, x, y, z, itemstackiterator3);
                                                    entityToSpawn3.setPickUpDelay(10);
                                                    _levelxxxx2.addFreshEntity(entityToSpawn3);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx2 = (LivingEntity) entity;
                                mainHandItem52 = _livEntxxx2.getMainHandItem();
                            } else {
                                mainHandItem52 = ItemStack.EMPTY;
                            }
                            if (mainHandItem52.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx4 = (LivingEntity) entity;
                                    mainHandItem55 = _livEntxx4.getMainHandItem();
                                } else {
                                    mainHandItem55 = ItemStack.EMPTY;
                                }
                                if (mainHandItem55.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index1 = 0; index1 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index1++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var247 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_leg_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var247.hasNext()) {
                                                ItemStack itemstackiterator4 = (ItemStack) var247.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn4 = new ItemEntity(_levelxxxx3, x, y, z, itemstackiterator4);
                                                    entityToSpawn4.setPickUpDelay(10);
                                                    _levelxxxx3.addFreshEntity(entityToSpawn4);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx3 = (LivingEntity) entity;
                                mainHandItem53 = _livEntxxx3.getMainHandItem();
                            } else {
                                mainHandItem53 = ItemStack.EMPTY;
                            }
                            if (mainHandItem53.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx5 = (LivingEntity) entity;
                                    mainHandItem54 = _livEntxx5.getMainHandItem();
                                } else {
                                    mainHandItem54 = ItemStack.EMPTY;
                                }
                                if (mainHandItem54.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index2 = 0; index2 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index2++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var246 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_leg_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var246.hasNext()) {
                                                ItemStack itemstackiterator5 = (ItemStack) var246.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn5 = new ItemEntity(_levelxxxx4, x, y, z, itemstackiterator5);
                                                    entityToSpawn5.setPickUpDelay(10);
                                                    _levelxxxx4.addFreshEntity(entityToSpawn5);
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
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()) {
                    Property<?> property5 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property5 instanceof IntegerProperty) {
                        Property<?> _getip61 = property5;
                        iIntValue7 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip61)).intValue();
                    } else {
                        iIntValue7 = -1;
                    }
                    if (iIntValue7 == 2) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx6 = (LivingEntity) entity;
                                mainHandItem50 = _livEntxx6.getMainHandItem();
                            } else {
                                mainHandItem50 = ItemStack.EMPTY;
                            }
                            mainHandItem50.hurtAndBreak(1, _levelxxxx5, (ServerPlayer) null, _stkprov3 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity3 = (LivingEntity) entity;
                            _entity3.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posxx = BlockPos.containing(x, y, z);
                        BlockState _bsxx = world.getBlockState(_posxx);
                        Property<?> property6 = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property6 instanceof IntegerProperty) {
                            IntegerProperty _integerProp3 = (IntegerProperty) property6;
                            if (_integerProp3.getPossibleValues().contains(3)) {
                                world.setBlock(_posxx, (BlockState) _bsxx.setValue(_integerProp3, 3), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxx6 = (Level) world;
                            if (!_levelxxxx6.isClientSide()) {
                                _levelxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxx = (Level) world;
                            if (!_levelxxxxx.isClientSide()) {
                                _levelxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var85 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var85.hasNext()) {
                                ItemStack itemstackiterator6 = (ItemStack) var85.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn6 = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator6);
                                    entityToSpawn6.setPickUpDelay(10);
                                    _levelxxxxxx.addFreshEntity(entityToSpawn6);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx4 = (LivingEntity) entity;
                                mainHandItem44 = _livEntxxx4.getMainHandItem();
                            } else {
                                mainHandItem44 = ItemStack.EMPTY;
                            }
                            if (mainHandItem44.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx7 = (LivingEntity) entity;
                                    mainHandItem49 = _livEntxx7.getMainHandItem();
                                } else {
                                    mainHandItem49 = ItemStack.EMPTY;
                                }
                                if (mainHandItem49.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index3 = 0; index3 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index3++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var245 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var245.hasNext()) {
                                                ItemStack itemstackiterator7 = (ItemStack) var245.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn7 = new ItemEntity(_levelxxxxxx2, x, y, z, itemstackiterator7);
                                                    entityToSpawn7.setPickUpDelay(10);
                                                    _levelxxxxxx2.addFreshEntity(entityToSpawn7);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx5 = (LivingEntity) entity;
                                mainHandItem45 = _livEntxxx5.getMainHandItem();
                            } else {
                                mainHandItem45 = ItemStack.EMPTY;
                            }
                            if (mainHandItem45.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx8 = (LivingEntity) entity;
                                    mainHandItem48 = _livEntxx8.getMainHandItem();
                                } else {
                                    mainHandItem48 = ItemStack.EMPTY;
                                }
                                if (mainHandItem48.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index4 = 0; index4 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index4++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var244 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var244.hasNext()) {
                                                ItemStack itemstackiterator8 = (ItemStack) var244.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn8 = new ItemEntity(_levelxxxxxx3, x, y, z, itemstackiterator8);
                                                    entityToSpawn8.setPickUpDelay(10);
                                                    _levelxxxxxx3.addFreshEntity(entityToSpawn8);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx6 = (LivingEntity) entity;
                                mainHandItem46 = _livEntxxx6.getMainHandItem();
                            } else {
                                mainHandItem46 = ItemStack.EMPTY;
                            }
                            if (mainHandItem46.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx9 = (LivingEntity) entity;
                                    mainHandItem47 = _livEntxx9.getMainHandItem();
                                } else {
                                    mainHandItem47 = ItemStack.EMPTY;
                                }
                                if (mainHandItem47.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index5 = 0; index5 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index5++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var243 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var243.hasNext()) {
                                                ItemStack itemstackiterator9 = (ItemStack) var243.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn9 = new ItemEntity(_levelxxxxxx4, x, y, z, itemstackiterator9);
                                                    entityToSpawn9.setPickUpDelay(10);
                                                    _levelxxxxxx4.addFreshEntity(entityToSpawn9);
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
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()) {
                    Property<?> property7 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property7 instanceof IntegerProperty) {
                        Property<?> _getip100 = property7;
                        iIntValue6 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip100)).intValue();
                    } else {
                        iIntValue6 = -1;
                    }
                    if (iIntValue6 == 3) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx10 = (LivingEntity) entity;
                                mainHandItem43 = _livEntxx10.getMainHandItem();
                            } else {
                                mainHandItem43 = ItemStack.EMPTY;
                            }
                            mainHandItem43.hurtAndBreak(1, _levelxxxxxx5, (ServerPlayer) null, _stkprov4 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity4 = (LivingEntity) entity;
                            _entity4.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxx = world.getBlockState(_posxxx);
                        Property<?> property8 = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property8 instanceof IntegerProperty) {
                            IntegerProperty _integerProp4 = (IntegerProperty) property8;
                            if (_integerProp4.getPossibleValues().contains(4)) {
                                world.setBlock(_posxxx, (BlockState) _bsxxx.setValue(_integerProp4, 4), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxx6 = (Level) world;
                            if (!_levelxxxxxx6.isClientSide()) {
                                _levelxxxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxxx = (Level) world;
                            if (!_levelxxxxxxx.isClientSide()) {
                                _levelxxxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var78 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var78.hasNext()) {
                                ItemStack itemstackiterator10 = (ItemStack) var78.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn10 = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator10);
                                    entityToSpawn10.setPickUpDelay(10);
                                    _levelxxxxxxxx.addFreshEntity(entityToSpawn10);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx7 = (LivingEntity) entity;
                                mainHandItem37 = _livEntxxx7.getMainHandItem();
                            } else {
                                mainHandItem37 = ItemStack.EMPTY;
                            }
                            if (mainHandItem37.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx11 = (LivingEntity) entity;
                                    mainHandItem42 = _livEntxx11.getMainHandItem();
                                } else {
                                    mainHandItem42 = ItemStack.EMPTY;
                                }
                                if (mainHandItem42.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index6 = 0; index6 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index6++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var242 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var242.hasNext()) {
                                                ItemStack itemstackiterator11 = (ItemStack) var242.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn11 = new ItemEntity(_levelxxxxxxxx2, x, y, z, itemstackiterator11);
                                                    entityToSpawn11.setPickUpDelay(10);
                                                    _levelxxxxxxxx2.addFreshEntity(entityToSpawn11);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx8 = (LivingEntity) entity;
                                mainHandItem38 = _livEntxxx8.getMainHandItem();
                            } else {
                                mainHandItem38 = ItemStack.EMPTY;
                            }
                            if (mainHandItem38.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx12 = (LivingEntity) entity;
                                    mainHandItem41 = _livEntxx12.getMainHandItem();
                                } else {
                                    mainHandItem41 = ItemStack.EMPTY;
                                }
                                if (mainHandItem41.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index7 = 0; index7 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index7++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var241 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var241.hasNext()) {
                                                ItemStack itemstackiterator12 = (ItemStack) var241.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn12 = new ItemEntity(_levelxxxxxxxx3, x, y, z, itemstackiterator12);
                                                    entityToSpawn12.setPickUpDelay(10);
                                                    _levelxxxxxxxx3.addFreshEntity(entityToSpawn12);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx9 = (LivingEntity) entity;
                                mainHandItem39 = _livEntxxx9.getMainHandItem();
                            } else {
                                mainHandItem39 = ItemStack.EMPTY;
                            }
                            if (mainHandItem39.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx13 = (LivingEntity) entity;
                                    mainHandItem40 = _livEntxx13.getMainHandItem();
                                } else {
                                    mainHandItem40 = ItemStack.EMPTY;
                                }
                                if (mainHandItem40.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index8 = 0; index8 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index8++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var240 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var240.hasNext()) {
                                                ItemStack itemstackiterator13 = (ItemStack) var240.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn13 = new ItemEntity(_levelxxxxxxxx4, x, y, z, itemstackiterator13);
                                                    entityToSpawn13.setPickUpDelay(10);
                                                    _levelxxxxxxxx4.addFreshEntity(entityToSpawn13);
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
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()) {
                    Property<?> property9 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property9 instanceof IntegerProperty) {
                        Property<?> _getip139 = property9;
                        iIntValue5 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip139)).intValue();
                    } else {
                        iIntValue5 = -1;
                    }
                    if (iIntValue5 == 4) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx14 = (LivingEntity) entity;
                                mainHandItem36 = _livEntxx14.getMainHandItem();
                            } else {
                                mainHandItem36 = ItemStack.EMPTY;
                            }
                            mainHandItem36.hurtAndBreak(1, _levelxxxxxxxx5, (ServerPlayer) null, _stkprov5 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity5 = (LivingEntity) entity;
                            _entity5.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxx = world.getBlockState(_posxxxx);
                        Property<?> property10 = _bsxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property10 instanceof IntegerProperty) {
                            IntegerProperty _integerProp5 = (IntegerProperty) property10;
                            if (_integerProp5.getPossibleValues().contains(5)) {
                                world.setBlock(_posxxxx, (BlockState) _bsxxxx.setValue(_integerProp5, 5), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxx6 = (Level) world;
                            if (!_levelxxxxxxxx6.isClientSide()) {
                                _levelxxxxxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxx = (Level) world;
                            if (!_levelxxxxxxxxx.isClientSide()) {
                                _levelxxxxxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var71 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var71.hasNext()) {
                                ItemStack itemstackiterator14 = (ItemStack) var71.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn14 = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator14);
                                    entityToSpawn14.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawn14);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx10 = (LivingEntity) entity;
                                mainHandItem30 = _livEntxxx10.getMainHandItem();
                            } else {
                                mainHandItem30 = ItemStack.EMPTY;
                            }
                            if (mainHandItem30.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx15 = (LivingEntity) entity;
                                    mainHandItem35 = _livEntxx15.getMainHandItem();
                                } else {
                                    mainHandItem35 = ItemStack.EMPTY;
                                }
                                if (mainHandItem35.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index9 = 0; index9 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index9++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var239 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var239.hasNext()) {
                                                ItemStack itemstackiterator15 = (ItemStack) var239.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn15 = new ItemEntity(_levelxxxxxxxxxx2, x, y, z, itemstackiterator15);
                                                    entityToSpawn15.setPickUpDelay(10);
                                                    _levelxxxxxxxxxx2.addFreshEntity(entityToSpawn15);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx11 = (LivingEntity) entity;
                                mainHandItem31 = _livEntxxx11.getMainHandItem();
                            } else {
                                mainHandItem31 = ItemStack.EMPTY;
                            }
                            if (mainHandItem31.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx16 = (LivingEntity) entity;
                                    mainHandItem34 = _livEntxx16.getMainHandItem();
                                } else {
                                    mainHandItem34 = ItemStack.EMPTY;
                                }
                                if (mainHandItem34.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index10 = 0; index10 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index10++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var238 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var238.hasNext()) {
                                                ItemStack itemstackiterator16 = (ItemStack) var238.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn16 = new ItemEntity(_levelxxxxxxxxxx3, x, y, z, itemstackiterator16);
                                                    entityToSpawn16.setPickUpDelay(10);
                                                    _levelxxxxxxxxxx3.addFreshEntity(entityToSpawn16);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx12 = (LivingEntity) entity;
                                mainHandItem32 = _livEntxxx12.getMainHandItem();
                            } else {
                                mainHandItem32 = ItemStack.EMPTY;
                            }
                            if (mainHandItem32.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx17 = (LivingEntity) entity;
                                    mainHandItem33 = _livEntxx17.getMainHandItem();
                                } else {
                                    mainHandItem33 = ItemStack.EMPTY;
                                }
                                if (mainHandItem33.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index11 = 0; index11 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index11++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var237 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var237.hasNext()) {
                                                ItemStack itemstackiterator17 = (ItemStack) var237.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn17 = new ItemEntity(_levelxxxxxxxxxx4, x, y, z, itemstackiterator17);
                                                    entityToSpawn17.setPickUpDelay(10);
                                                    _levelxxxxxxxxxx4.addFreshEntity(entityToSpawn17);
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
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()) {
                    Property<?> property11 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property11 instanceof IntegerProperty) {
                        Property<?> _getip178 = property11;
                        iIntValue4 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip178)).intValue();
                    } else {
                        iIntValue4 = -1;
                    }
                    if (iIntValue4 == 5) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxxxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx18 = (LivingEntity) entity;
                                mainHandItem29 = _livEntxx18.getMainHandItem();
                            } else {
                                mainHandItem29 = ItemStack.EMPTY;
                            }
                            mainHandItem29.hurtAndBreak(1, _levelxxxxxxxxxx5, (ServerPlayer) null, _stkprov6 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity6 = (LivingEntity) entity;
                            _entity6.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxx = world.getBlockState(_posxxxxx);
                        Property<?> property12 = _bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property12 instanceof IntegerProperty) {
                            IntegerProperty _integerProp6 = (IntegerProperty) property12;
                            if (_integerProp6.getPossibleValues().contains(6)) {
                                world.setBlock(_posxxxxx, (BlockState) _bsxxxxx.setValue(_integerProp6, 6), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxx6 = (Level) world;
                            if (!_levelxxxxxxxxxx6.isClientSide()) {
                                _levelxxxxxxxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxxx = (Level) world;
                            if (!_levelxxxxxxxxxxx.isClientSide()) {
                                _levelxxxxxxxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var64 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_4_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var64.hasNext()) {
                                ItemStack itemstackiterator18 = (ItemStack) var64.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn18 = new ItemEntity(_levelxxxxxxxxxxxx, x, y, z, itemstackiterator18);
                                    entityToSpawn18.setPickUpDelay(10);
                                    _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn18);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx13 = (LivingEntity) entity;
                                mainHandItem23 = _livEntxxx13.getMainHandItem();
                            } else {
                                mainHandItem23 = ItemStack.EMPTY;
                            }
                            if (mainHandItem23.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx19 = (LivingEntity) entity;
                                    mainHandItem28 = _livEntxx19.getMainHandItem();
                                } else {
                                    mainHandItem28 = ItemStack.EMPTY;
                                }
                                if (mainHandItem28.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index12 = 0; index12 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index12++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var236 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_4_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var236.hasNext()) {
                                                ItemStack itemstackiterator19 = (ItemStack) var236.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn19 = new ItemEntity(_levelxxxxxxxxxxxx2, x, y, z, itemstackiterator19);
                                                    entityToSpawn19.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxx2.addFreshEntity(entityToSpawn19);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx14 = (LivingEntity) entity;
                                mainHandItem24 = _livEntxxx14.getMainHandItem();
                            } else {
                                mainHandItem24 = ItemStack.EMPTY;
                            }
                            if (mainHandItem24.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx20 = (LivingEntity) entity;
                                    mainHandItem27 = _livEntxx20.getMainHandItem();
                                } else {
                                    mainHandItem27 = ItemStack.EMPTY;
                                }
                                if (mainHandItem27.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index13 = 0; index13 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index13++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var235 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_4_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var235.hasNext()) {
                                                ItemStack itemstackiterator20 = (ItemStack) var235.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn20 = new ItemEntity(_levelxxxxxxxxxxxx3, x, y, z, itemstackiterator20);
                                                    entityToSpawn20.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxx3.addFreshEntity(entityToSpawn20);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx15 = (LivingEntity) entity;
                                mainHandItem25 = _livEntxxx15.getMainHandItem();
                            } else {
                                mainHandItem25 = ItemStack.EMPTY;
                            }
                            if (mainHandItem25.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx21 = (LivingEntity) entity;
                                    mainHandItem26 = _livEntxx21.getMainHandItem();
                                } else {
                                    mainHandItem26 = ItemStack.EMPTY;
                                }
                                if (mainHandItem26.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index14 = 0; index14 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index14++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var234 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_4_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var234.hasNext()) {
                                                ItemStack itemstackiterator21 = (ItemStack) var234.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn21 = new ItemEntity(_levelxxxxxxxxxxxx4, x, y, z, itemstackiterator21);
                                                    entityToSpawn21.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxx4.addFreshEntity(entityToSpawn21);
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
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()) {
                    Property<?> property13 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property13 instanceof IntegerProperty) {
                        Property<?> _getip217 = property13;
                        iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip217)).intValue();
                    } else {
                        iIntValue3 = -1;
                    }
                    if (iIntValue3 == 6) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxxxxxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx22 = (LivingEntity) entity;
                                mainHandItem22 = _livEntxx22.getMainHandItem();
                            } else {
                                mainHandItem22 = ItemStack.EMPTY;
                            }
                            mainHandItem22.hurtAndBreak(1, _levelxxxxxxxxxxxx5, (ServerPlayer) null, _stkprov7 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity7 = (LivingEntity) entity;
                            _entity7.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posxxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxxx = world.getBlockState(_posxxxxxx);
                        Property<?> property14 = _bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property14 instanceof IntegerProperty) {
                            IntegerProperty _integerProp7 = (IntegerProperty) property14;
                            if (_integerProp7.getPossibleValues().contains(7)) {
                                world.setBlock(_posxxxxxx, (BlockState) _bsxxxxxx.setValue(_integerProp7, 7), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxxxx6 = (Level) world;
                            if (!_levelxxxxxxxxxxxx6.isClientSide()) {
                                _levelxxxxxxxxxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxxxxx = (Level) world;
                            if (!_levelxxxxxxxxxxxxx.isClientSide()) {
                                _levelxxxxxxxxxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var57 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_5_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var57.hasNext()) {
                                ItemStack itemstackiterator22 = (ItemStack) var57.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn22 = new ItemEntity(_levelxxxxxxxxxxxxxx, x, y, z, itemstackiterator22);
                                    entityToSpawn22.setPickUpDelay(10);
                                    _levelxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn22);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx16 = (LivingEntity) entity;
                                mainHandItem16 = _livEntxxx16.getMainHandItem();
                            } else {
                                mainHandItem16 = ItemStack.EMPTY;
                            }
                            if (mainHandItem16.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx23 = (LivingEntity) entity;
                                    mainHandItem21 = _livEntxx23.getMainHandItem();
                                } else {
                                    mainHandItem21 = ItemStack.EMPTY;
                                }
                                if (mainHandItem21.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index15 = 0; index15 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index15++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var233 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_5_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var233.hasNext()) {
                                                ItemStack itemstackiterator23 = (ItemStack) var233.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn23 = new ItemEntity(_levelxxxxxxxxxxxxxx2, x, y, z, itemstackiterator23);
                                                    entityToSpawn23.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxxxx2.addFreshEntity(entityToSpawn23);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx17 = (LivingEntity) entity;
                                mainHandItem17 = _livEntxxx17.getMainHandItem();
                            } else {
                                mainHandItem17 = ItemStack.EMPTY;
                            }
                            if (mainHandItem17.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx24 = (LivingEntity) entity;
                                    mainHandItem20 = _livEntxx24.getMainHandItem();
                                } else {
                                    mainHandItem20 = ItemStack.EMPTY;
                                }
                                if (mainHandItem20.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index16 = 0; index16 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index16++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var232 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_5_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var232.hasNext()) {
                                                ItemStack itemstackiterator24 = (ItemStack) var232.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn24 = new ItemEntity(_levelxxxxxxxxxxxxxx3, x, y, z, itemstackiterator24);
                                                    entityToSpawn24.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxxxx3.addFreshEntity(entityToSpawn24);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx18 = (LivingEntity) entity;
                                mainHandItem18 = _livEntxxx18.getMainHandItem();
                            } else {
                                mainHandItem18 = ItemStack.EMPTY;
                            }
                            if (mainHandItem18.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx25 = (LivingEntity) entity;
                                    mainHandItem19 = _livEntxx25.getMainHandItem();
                                } else {
                                    mainHandItem19 = ItemStack.EMPTY;
                                }
                                if (mainHandItem19.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index17 = 0; index17 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index17++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var231 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_5_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var231.hasNext()) {
                                                ItemStack itemstackiterator25 = (ItemStack) var231.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn25 = new ItemEntity(_levelxxxxxxxxxxxxxx4, x, y, z, itemstackiterator25);
                                                    entityToSpawn25.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxxxx4.addFreshEntity(entityToSpawn25);
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
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()) {
                    Property<?> property15 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property15 instanceof IntegerProperty) {
                        Property<?> _getip256 = property15;
                        iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip256)).intValue();
                    } else {
                        iIntValue2 = -1;
                    }
                    if (iIntValue2 == 7) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxxxxxxxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx26 = (LivingEntity) entity;
                                mainHandItem15 = _livEntxx26.getMainHandItem();
                            } else {
                                mainHandItem15 = ItemStack.EMPTY;
                            }
                            mainHandItem15.hurtAndBreak(1, _levelxxxxxxxxxxxxxx5, (ServerPlayer) null, _stkprov8 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity8 = (LivingEntity) entity;
                            _entity8.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        BlockPos _posxxxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxxxx = world.getBlockState(_posxxxxxxx);
                        Property<?> property16 = _bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                        if (property16 instanceof IntegerProperty) {
                            IntegerProperty _integerProp8 = (IntegerProperty) property16;
                            if (_integerProp8.getPossibleValues().contains(8)) {
                                world.setBlock(_posxxxxxxx, (BlockState) _bsxxxxxxx.setValue(_integerProp8, 8), 3);
                            }
                        }
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxxxxxx6 = (Level) world;
                            if (!_levelxxxxxxxxxxxxxx6.isClientSide()) {
                                _levelxxxxxxxxxxxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxxxxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxxxxxxx = (Level) world;
                            if (!_levelxxxxxxxxxxxxxxx.isClientSide()) {
                                _levelxxxxxxxxxxxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var50 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_6_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var50.hasNext()) {
                                ItemStack itemstackiterator26 = (ItemStack) var50.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxxxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn26 = new ItemEntity(_levelxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator26);
                                    entityToSpawn26.setPickUpDelay(10);
                                    _levelxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn26);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx19 = (LivingEntity) entity;
                                mainHandItem9 = _livEntxxx19.getMainHandItem();
                            } else {
                                mainHandItem9 = ItemStack.EMPTY;
                            }
                            if (mainHandItem9.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx27 = (LivingEntity) entity;
                                    mainHandItem14 = _livEntxx27.getMainHandItem();
                                } else {
                                    mainHandItem14 = ItemStack.EMPTY;
                                }
                                if (mainHandItem14.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index18 = 0; index18 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index18++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var230 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_6_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var230.hasNext()) {
                                                ItemStack itemstackiterator27 = (ItemStack) var230.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxxxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn27 = new ItemEntity(_levelxxxxxxxxxxxxxxxx2, x, y, z, itemstackiterator27);
                                                    entityToSpawn27.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxxxxxx2.addFreshEntity(entityToSpawn27);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx20 = (LivingEntity) entity;
                                mainHandItem10 = _livEntxxx20.getMainHandItem();
                            } else {
                                mainHandItem10 = ItemStack.EMPTY;
                            }
                            if (mainHandItem10.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx28 = (LivingEntity) entity;
                                    mainHandItem13 = _livEntxx28.getMainHandItem();
                                } else {
                                    mainHandItem13 = ItemStack.EMPTY;
                                }
                                if (mainHandItem13.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index19 = 0; index19 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index19++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var229 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_6_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var229.hasNext()) {
                                                ItemStack itemstackiterator28 = (ItemStack) var229.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxxxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn28 = new ItemEntity(_levelxxxxxxxxxxxxxxxx3, x, y, z, itemstackiterator28);
                                                    entityToSpawn28.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxxxxxx3.addFreshEntity(entityToSpawn28);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx21 = (LivingEntity) entity;
                                mainHandItem11 = _livEntxxx21.getMainHandItem();
                            } else {
                                mainHandItem11 = ItemStack.EMPTY;
                            }
                            if (mainHandItem11.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx29 = (LivingEntity) entity;
                                    mainHandItem12 = _livEntxx29.getMainHandItem();
                                } else {
                                    mainHandItem12 = ItemStack.EMPTY;
                                }
                                if (mainHandItem12.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index20 = 0; index20 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index20++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var228 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_6_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var228.hasNext()) {
                                                ItemStack itemstackiterator29 = (ItemStack) var228.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn29 = new ItemEntity(_levelxxxxxxxxxxxxxxxx4, x, y, z, itemstackiterator29);
                                                    entityToSpawn29.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxxxxxx4.addFreshEntity(entityToSpawn29);
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
                }
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()) {
                    Property<?> property17 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property17 instanceof IntegerProperty) {
                        IntegerProperty _getip295 = (IntegerProperty) property17;
                        iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip295)).intValue();
                    } else {
                        iIntValue = -1;
                    }
                    if (iIntValue == 8) {
                        if (world instanceof ServerLevel) {
                            ServerLevel _levelxxxxxxxxxxxxxxxx5 = (ServerLevel) world;
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx30 = (LivingEntity) entity;
                                mainHandItem8 = _livEntxx30.getMainHandItem();
                            } else {
                                mainHandItem8 = ItemStack.EMPTY;
                            }
                            mainHandItem8.hurtAndBreak(1, _levelxxxxxxxxxxxxxxxx5, (ServerPlayer) null, _stkprov9 -> {
                            });
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _entity9 = (LivingEntity) entity;
                            _entity9.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }
                        world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState()));
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxxxxxxxx6 = (Level) world;
                            if (!_levelxxxxxxxxxxxxxxxx6.isClientSide()) {
                                _levelxxxxxxxxxxxxxxxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxxxxxxxxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (world instanceof Level) {
                            Level _levelxxxxxxxxxxxxxxxxx = (Level) world;
                            if (!_levelxxxxxxxxxxxxxxxxx.isClientSide()) {
                                _levelxxxxxxxxxxxxxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                            } else {
                                _levelxxxxxxxxxxxxxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.turtle.egg_crack")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                            }
                        }
                        if (!world.isClientSide() && world.getServer() != null) {
                            ObjectListIterator var43 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_7_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                            while (var43.hasNext()) {
                                ItemStack itemstackiterator30 = (ItemStack) var43.next();
                                if (world instanceof ServerLevel) {
                                    ServerLevel _levelxxxxxxxxxxxxxxxxxx = (ServerLevel) world;
                                    ItemEntity entityToSpawn30 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator30);
                                    entityToSpawn30.setPickUpDelay(10);
                                    _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn30);
                                }
                            }
                        }
                        if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx22 = (LivingEntity) entity;
                                mainHandItem2 = _livEntxxx22.getMainHandItem();
                            } else {
                                mainHandItem2 = ItemStack.EMPTY;
                            }
                            if (mainHandItem2.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx31 = (LivingEntity) entity;
                                    mainHandItem7 = _livEntxx31.getMainHandItem();
                                } else {
                                    mainHandItem7 = ItemStack.EMPTY;
                                }
                                if (mainHandItem7.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                    for (int index21 = 0; index21 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index21++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var227 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_7_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var227.hasNext()) {
                                                ItemStack itemstackiterator31 = (ItemStack) var227.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxxxxxxxx2 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn31 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx2, x, y, z, itemstackiterator31);
                                                    entityToSpawn31.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxxxxxxxx2.addFreshEntity(entityToSpawn31);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx23 = (LivingEntity) entity;
                                mainHandItem3 = _livEntxxx23.getMainHandItem();
                            } else {
                                mainHandItem3 = ItemStack.EMPTY;
                            }
                            if (mainHandItem3.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx32 = (LivingEntity) entity;
                                    mainHandItem6 = _livEntxx32.getMainHandItem();
                                } else {
                                    mainHandItem6 = ItemStack.EMPTY;
                                }
                                if (mainHandItem6.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                    for (int index22 = 0; index22 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index22++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var226 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_7_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var226.hasNext()) {
                                                ItemStack itemstackiterator32 = (ItemStack) var226.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxxxxxxxx3 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn32 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx3, x, y, z, itemstackiterator32);
                                                    entityToSpawn32.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxxxxxxxx3.addFreshEntity(entityToSpawn32);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxxx24 = (LivingEntity) entity;
                                mainHandItem4 = _livEntxxx24.getMainHandItem();
                            } else {
                                mainHandItem4 = ItemStack.EMPTY;
                            }
                            if (mainHandItem4.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEntxx33 = (LivingEntity) entity;
                                    mainHandItem5 = _livEntxx33.getMainHandItem();
                                } else {
                                    mainHandItem5 = ItemStack.EMPTY;
                                }
                                if (mainHandItem5.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                    for (int index23 = 0; index23 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index23++) {
                                        if (!world.isClientSide() && world.getServer() != null) {
                                            ObjectListIterator var27 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/turtle_cut_7_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                            while (var27.hasNext()) {
                                                ItemStack itemstackiterator33 = (ItemStack) var27.next();
                                                if (world instanceof ServerLevel) {
                                                    ServerLevel _levelxxxxxxxxxxxxxxxxxx4 = (ServerLevel) world;
                                                    ItemEntity entityToSpawn33 = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx4, x, y, z, itemstackiterator33);
                                                    entityToSpawn33.setPickUpDelay(10);
                                                    _levelxxxxxxxxxxxxxxxxxx4.addFreshEntity(entityToSpawn33);
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
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false);
        }
        return false;
    }
}
