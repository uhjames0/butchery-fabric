package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.storage.loot.LootParams.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ElderguardiancutupProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null
         && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
            .is(TagKey.create(Registries.ITEM, Identifier.parse("butchery:boss_tool")))) {
         if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 0.0) {
            if (world instanceof ServerLevel _level) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _level, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockEntity _blockEntity = world.getBlockEntity(_bp);
               BlockState _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  ButcheryPersistentData.of(_blockEntity).putDouble("butcherStage", 1.0);
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SANDSTONE.defaultBlockState()));
            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F,
                     false
                  );
               }
            }

            if (!world.isClientSide() && world.getServer() != null) {
               ObjectListIterator var24 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_1")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var24.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var24.next();
                  if (world instanceof ServerLevel _levelxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxx.addFreshEntity(entityToSpawn);
                  }
               }
            }

            if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 1) {
                  for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index0++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var98 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_1")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var98.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var98.next();
                           if (world instanceof ServerLevel _levelxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }

                  return;
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 2) {
                  for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index1++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var97 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_1")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var97.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var97.next();
                           if (world instanceof ServerLevel _levelxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }

                  return;
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 3) {
                  for (int index2 = 0; index2 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index2++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var16 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_1")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var16.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var16.next();
                           if (world instanceof ServerLevel _levelxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 1.0) {
            if (world instanceof ServerLevel _levelxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _levelxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
               BlockState _bsx = world.getBlockState(_bpx);
               if (_blockEntityx != null) {
                  ButcheryPersistentData.of(_blockEntityx).putDouble("butcherStage", 2.0);
               }

               if (world instanceof Level _levelxx) {
                  _levelxx.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SANDSTONE.defaultBlockState()));
            if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxx) {
               if (!_levelxxx.isClientSide()) {
                  _levelxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F,
                     false
                  );
               }
            }

            if (!world.isClientSide() && world.getServer() != null) {
               ObjectListIterator var31 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_2")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var31.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var31.next();
                  if (world instanceof ServerLevel _levelxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxx.addFreshEntity(entityToSpawn);
                  }
               }
            }

            if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 1) {
                  for (int index3 = 0; index3 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index3++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var101 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_2")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var101.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var101.next();
                           if (world instanceof ServerLevel _levelxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }

                  return;
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 2) {
                  for (int index4 = 0; index4 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index4++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var100 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_2")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var100.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var100.next();
                           if (world instanceof ServerLevel _levelxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }

                  return;
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 3) {
                  for (int index5 = 0; index5 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index5++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var99 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_2")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var99.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var99.next();
                           if (world instanceof ServerLevel _levelxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 2.0) {
            if (world instanceof ServerLevel _levelxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _levelxxxx, null, _stkprov -> {});
            }

            if (!world.isClientSide()) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
               BlockState _bsxx = world.getBlockState(_bpxx);
               if (_blockEntityxx != null) {
                  ButcheryPersistentData.of(_blockEntityxx).putDouble("butcherStage", 3.0);
               }

               if (world instanceof Level _levelxxxx) {
                  _levelxxxx.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SANDSTONE.defaultBlockState()));
            if (world instanceof Level _levelxxxx) {
               if (!_levelxxxx.isClientSide()) {
                  _levelxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxx) {
               if (!_levelxxxxx.isClientSide()) {
                  _levelxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F,
                     false
                  );
               }
            }

            if (!world.isClientSide() && world.getServer() != null) {
               ObjectListIterator var38 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_3")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var38.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var38.next();
                  if (world instanceof ServerLevel _levelxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxx.addFreshEntity(entityToSpawn);
                  }
               }
            }

            if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 1) {
                  for (int index6 = 0; index6 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index6++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var104 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_3")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var104.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var104.next();
                           if (world instanceof ServerLevel _levelxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }

                  return;
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 2) {
                  for (int index7 = 0; index7 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index7++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var103 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_3")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var103.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var103.next();
                           if (world instanceof ServerLevel _levelxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }

                  return;
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 3) {
                  for (int index8 = 0; index8 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index8++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var102 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_3")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var102.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var102.next();
                           if (world instanceof ServerLevel _levelxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 3.0) {
            if (world instanceof ServerLevel _levelxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _levelxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SANDSTONE.defaultBlockState()));
            if (world instanceof Level _levelxxxxxx) {
               if (!_levelxxxxxx.isClientSide()) {
                  _levelxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxx) {
               if (!_levelxxxxxxx.isClientSide()) {
                  _levelxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F,
                     false
                  );
               }
            }

            if (!world.isClientSide() && world.getServer() != null) {
               ObjectListIterator var44 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_4")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var44.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var44.next();
                  if (world instanceof ServerLevel _levelxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                  }
               }
            }

            if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 1) {
                  for (int index9 = 0; index9 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index9++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var107 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_4")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var107.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var107.next();
                           if (world instanceof ServerLevel _levelxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }

                  return;
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 2) {
                  for (int index10 = 0; index10 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index10++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var106 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_4")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var106.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var106.next();
                           if (world instanceof ServerLevel _levelxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }

                  return;
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     != 0
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .getEnchantments()
                        .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                     == 3) {
                  for (int index11 = 0; index11 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index11++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var105 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/elder_guardian_cut_4")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var105.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var105.next();
                           if (world instanceof ServerLevel _levelxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxx.addFreshEntity(entityToSpawn);
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
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
   }
}
