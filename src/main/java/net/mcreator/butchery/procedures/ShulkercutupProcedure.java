package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: ShulkercutupProcedure.class */
public class ShulkercutupProcedure {
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
        ItemStack mainHandItem23;
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
                    mainHandItem23 = _livEnt.getMainHandItem();
                } else {
                    mainHandItem23 = ItemStack.EMPTY;
                }
                if (!mainHandItem23.is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) {
                    return;
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SHULKER_CARCASS.get()) {
                Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    Property<?> _getip7 = property;
                    iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip7)).intValue();
                } else {
                    iIntValue3 = -1;
                }
                if (iIntValue3 == 0) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx = (LivingEntity) entity;
                            mainHandItem22 = _livEntxx.getMainHandItem();
                        } else {
                            mainHandItem22 = ItemStack.EMPTY;
                        }
                        mainHandItem22.hurtAndBreak(1, _level, (ServerPlayer) null, _stkprov -> {
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
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.SHULKER_CARCASS.get()).defaultBlockState()));
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
                            _levelx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sniffer_egg.crack")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sniffer_egg.crack")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var45 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var45.hasNext()) {
                            ItemStack itemstackiterator = (ItemStack) var45.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxx = (ServerLevel) world;
                                ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                                entityToSpawn.setPickUpDelay(10);
                                _levelxx.addFreshEntity(entityToSpawn);
                            }
                        }
                    }
                    if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx = (LivingEntity) entity;
                            mainHandItem16 = _livEntxxx.getMainHandItem();
                        } else {
                            mainHandItem16 = ItemStack.EMPTY;
                        }
                        if (mainHandItem16.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx2 = (LivingEntity) entity;
                                mainHandItem21 = _livEntxx2.getMainHandItem();
                            } else {
                                mainHandItem21 = ItemStack.EMPTY;
                            }
                            if (mainHandItem21.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                for (int index0 = 0; index0 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index0++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var92 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var92.hasNext()) {
                                            ItemStack itemstackiterator2 = (ItemStack) var92.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxx2 = (ServerLevel) world;
                                                ItemEntity entityToSpawn2 = new ItemEntity(_levelxx2, x, y, z, itemstackiterator2);
                                                entityToSpawn2.setPickUpDelay(10);
                                                _levelxx2.addFreshEntity(entityToSpawn2);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx2 = (LivingEntity) entity;
                            mainHandItem17 = _livEntxxx2.getMainHandItem();
                        } else {
                            mainHandItem17 = ItemStack.EMPTY;
                        }
                        if (mainHandItem17.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx3 = (LivingEntity) entity;
                                mainHandItem20 = _livEntxx3.getMainHandItem();
                            } else {
                                mainHandItem20 = ItemStack.EMPTY;
                            }
                            if (mainHandItem20.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                for (int index1 = 0; index1 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index1++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var91 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var91.hasNext()) {
                                            ItemStack itemstackiterator3 = (ItemStack) var91.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxx3 = (ServerLevel) world;
                                                ItemEntity entityToSpawn3 = new ItemEntity(_levelxx3, x, y, z, itemstackiterator3);
                                                entityToSpawn3.setPickUpDelay(10);
                                                _levelxx3.addFreshEntity(entityToSpawn3);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx3 = (LivingEntity) entity;
                            mainHandItem18 = _livEntxxx3.getMainHandItem();
                        } else {
                            mainHandItem18 = ItemStack.EMPTY;
                        }
                        if (mainHandItem18.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx4 = (LivingEntity) entity;
                                mainHandItem19 = _livEntxx4.getMainHandItem();
                            } else {
                                mainHandItem19 = ItemStack.EMPTY;
                            }
                            if (mainHandItem19.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                for (int index2 = 0; index2 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index2++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var90 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_1_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var90.hasNext()) {
                                            ItemStack itemstackiterator4 = (ItemStack) var90.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxx4 = (ServerLevel) world;
                                                ItemEntity entityToSpawn4 = new ItemEntity(_levelxx4, x, y, z, itemstackiterator4);
                                                entityToSpawn4.setPickUpDelay(10);
                                                _levelxx4.addFreshEntity(entityToSpawn4);
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
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SHULKER_CARCASS.get()) {
                Property<?> property3 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property3 instanceof IntegerProperty) {
                    Property<?> _getip46 = property3;
                    iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip46)).intValue();
                } else {
                    iIntValue2 = -1;
                }
                if (iIntValue2 == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxx5 = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx5 = (LivingEntity) entity;
                            mainHandItem15 = _livEntxx5.getMainHandItem();
                        } else {
                            mainHandItem15 = ItemStack.EMPTY;
                        }
                        mainHandItem15.hurtAndBreak(1, _levelxx5, (ServerPlayer) null, _stkprov2 -> {
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
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.SHULKER_CARCASS.get()).defaultBlockState()));
                    if (world instanceof Level) {
                        Level _levelxx6 = (Level) world;
                        if (!_levelxx6.isClientSide()) {
                            _levelxx6.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxx6.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
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
                        ObjectListIterator var38 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var38.hasNext()) {
                            ItemStack itemstackiterator5 = (ItemStack) var38.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxxxx = (ServerLevel) world;
                                ItemEntity entityToSpawn5 = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator5);
                                entityToSpawn5.setPickUpDelay(10);
                                _levelxxxx.addFreshEntity(entityToSpawn5);
                            }
                        }
                    }
                    if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx4 = (LivingEntity) entity;
                            mainHandItem9 = _livEntxxx4.getMainHandItem();
                        } else {
                            mainHandItem9 = ItemStack.EMPTY;
                        }
                        if (mainHandItem9.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx6 = (LivingEntity) entity;
                                mainHandItem14 = _livEntxx6.getMainHandItem();
                            } else {
                                mainHandItem14 = ItemStack.EMPTY;
                            }
                            if (mainHandItem14.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                for (int index3 = 0; index3 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index3++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var89 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var89.hasNext()) {
                                            ItemStack itemstackiterator6 = (ItemStack) var89.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxx2 = (ServerLevel) world;
                                                ItemEntity entityToSpawn6 = new ItemEntity(_levelxxxx2, x, y, z, itemstackiterator6);
                                                entityToSpawn6.setPickUpDelay(10);
                                                _levelxxxx2.addFreshEntity(entityToSpawn6);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx5 = (LivingEntity) entity;
                            mainHandItem10 = _livEntxxx5.getMainHandItem();
                        } else {
                            mainHandItem10 = ItemStack.EMPTY;
                        }
                        if (mainHandItem10.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx7 = (LivingEntity) entity;
                                mainHandItem13 = _livEntxx7.getMainHandItem();
                            } else {
                                mainHandItem13 = ItemStack.EMPTY;
                            }
                            if (mainHandItem13.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                for (int index4 = 0; index4 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index4++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var88 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var88.hasNext()) {
                                            ItemStack itemstackiterator7 = (ItemStack) var88.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxx3 = (ServerLevel) world;
                                                ItemEntity entityToSpawn7 = new ItemEntity(_levelxxxx3, x, y, z, itemstackiterator7);
                                                entityToSpawn7.setPickUpDelay(10);
                                                _levelxxxx3.addFreshEntity(entityToSpawn7);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx6 = (LivingEntity) entity;
                            mainHandItem11 = _livEntxxx6.getMainHandItem();
                        } else {
                            mainHandItem11 = ItemStack.EMPTY;
                        }
                        if (mainHandItem11.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx8 = (LivingEntity) entity;
                                mainHandItem12 = _livEntxx8.getMainHandItem();
                            } else {
                                mainHandItem12 = ItemStack.EMPTY;
                            }
                            if (mainHandItem12.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                for (int index5 = 0; index5 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index5++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var87 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_2_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var87.hasNext()) {
                                            ItemStack itemstackiterator8 = (ItemStack) var87.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxx4 = (ServerLevel) world;
                                                ItemEntity entityToSpawn8 = new ItemEntity(_levelxxxx4, x, y, z, itemstackiterator8);
                                                entityToSpawn8.setPickUpDelay(10);
                                                _levelxxxx4.addFreshEntity(entityToSpawn8);
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
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SHULKER_CARCASS.get()) {
                Property<?> property5 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property5 instanceof IntegerProperty) {
                    IntegerProperty _getip85 = (IntegerProperty) property5;
                    iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip85)).intValue();
                } else {
                    iIntValue = -1;
                }
                if (iIntValue == 2) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _levelxxxx5 = (ServerLevel) world;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxx9 = (LivingEntity) entity;
                            mainHandItem8 = _livEntxx9.getMainHandItem();
                        } else {
                            mainHandItem8 = ItemStack.EMPTY;
                        }
                        mainHandItem8.hurtAndBreak(1, _levelxxxx5, (ServerPlayer) null, _stkprov3 -> {
                        });
                    }
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity3 = (LivingEntity) entity;
                        _entity3.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                    }
                    world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block) ButcheryModBlocks.SHULKER_CARCASS.get()).defaultBlockState()));
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
                            _levelxxxxx.playSound((Entity) null, BlockPos.containing(x, y, z), (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sniffer_egg.crack")), SoundSource.NEUTRAL, 0.3f, 1.0f);
                        } else {
                            _levelxxxxx.playLocalSound(x, y, z, (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sniffer_egg.crack")), SoundSource.NEUTRAL, 0.3f, 1.0f, false);
                        }
                    }
                    if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var31 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                        while (var31.hasNext()) {
                            ItemStack itemstackiterator9 = (ItemStack) var31.next();
                            if (world instanceof ServerLevel) {
                                ServerLevel _levelxxxxxx = (ServerLevel) world;
                                ItemEntity entityToSpawn9 = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator9);
                                entityToSpawn9.setPickUpDelay(10);
                                _levelxxxxxx.addFreshEntity(entityToSpawn9);
                            }
                        }
                    }
                    if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue()) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx7 = (LivingEntity) entity;
                            mainHandItem2 = _livEntxxx7.getMainHandItem();
                        } else {
                            mainHandItem2 = ItemStack.EMPTY;
                        }
                        if (mainHandItem2.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx10 = (LivingEntity) entity;
                                mainHandItem7 = _livEntxx10.getMainHandItem();
                            } else {
                                mainHandItem7 = ItemStack.EMPTY;
                            }
                            if (mainHandItem7.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
                                for (int index6 = 0; index6 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 1.0d)); index6++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var86 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var86.hasNext()) {
                                            ItemStack itemstackiterator10 = (ItemStack) var86.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxx2 = (ServerLevel) world;
                                                ItemEntity entityToSpawn10 = new ItemEntity(_levelxxxxxx2, x, y, z, itemstackiterator10);
                                                entityToSpawn10.setPickUpDelay(10);
                                                _levelxxxxxx2.addFreshEntity(entityToSpawn10);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx8 = (LivingEntity) entity;
                            mainHandItem3 = _livEntxxx8.getMainHandItem();
                        } else {
                            mainHandItem3 = ItemStack.EMPTY;
                        }
                        if (mainHandItem3.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx11 = (LivingEntity) entity;
                                mainHandItem6 = _livEntxx11.getMainHandItem();
                            } else {
                                mainHandItem6 = ItemStack.EMPTY;
                            }
                            if (mainHandItem6.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
                                for (int index7 = 0; index7 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 2.0d)); index7++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var85 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var85.hasNext()) {
                                            ItemStack itemstackiterator11 = (ItemStack) var85.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxx3 = (ServerLevel) world;
                                                ItemEntity entityToSpawn11 = new ItemEntity(_levelxxxxxx3, x, y, z, itemstackiterator11);
                                                entityToSpawn11.setPickUpDelay(10);
                                                _levelxxxxxx3.addFreshEntity(entityToSpawn11);
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEntxxx9 = (LivingEntity) entity;
                            mainHandItem4 = _livEntxxx9.getMainHandItem();
                        } else {
                            mainHandItem4 = ItemStack.EMPTY;
                        }
                        if (mainHandItem4.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEntxx12 = (LivingEntity) entity;
                                mainHandItem5 = _livEntxx12.getMainHandItem();
                            } else {
                                mainHandItem5 = ItemStack.EMPTY;
                            }
                            if (mainHandItem5.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
                                for (int index8 = 0; index8 < ((int) Mth.nextDouble(RandomSource.create(), 0.0d, 3.0d)); index8++) {
                                    if (!world.isClientSide() && world.getServer() != null) {
                                        ObjectListIterator var21 = world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/shulker_cut_3_drop"))).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY)).iterator();
                                        while (var21.hasNext()) {
                                            ItemStack itemstackiterator12 = (ItemStack) var21.next();
                                            if (world instanceof ServerLevel) {
                                                ServerLevel _levelxxxxxx4 = (ServerLevel) world;
                                                ItemEntity entityToSpawn12 = new ItemEntity(_levelxxxxxx4, x, y, z, itemstackiterator12);
                                                entityToSpawn12.setPickUpDelay(10);
                                                _levelxxxxxx4.addFreshEntity(entityToSpawn12);
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
