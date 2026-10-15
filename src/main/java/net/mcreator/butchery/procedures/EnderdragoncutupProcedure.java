package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
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

public class EnderdragoncutupProcedure {
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

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
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
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_head_drop")))
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
                        ObjectListIterator var362 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_head_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var362.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var362.next();
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
                        ObjectListIterator var361 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_head_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var361.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var361.next();
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
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_head_drop")))
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

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
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
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_1_cut")))
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
                        ObjectListIterator var365 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_1_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var365.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var365.next();
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
                        ObjectListIterator var364 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_1_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var364.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var364.next();
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
                        ObjectListIterator var363 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_1_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var363.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var363.next();
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

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
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
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_2_cut")))
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
                        ObjectListIterator var368 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_2_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var368.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var368.next();
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
                        ObjectListIterator var367 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_2_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var367.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var367.next();
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
                        ObjectListIterator var366 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_2_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var366.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var366.next();
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

            if (!world.isClientSide()) {
               BlockPos _bpxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
               BlockState _bsxxx = world.getBlockState(_bpxxx);
               if (_blockEntityxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxx).putDouble("butcherStage", 4.0);
               }

               if (world instanceof Level _levelxxxxxx) {
                  _levelxxxxxx.sendBlockUpdated(_bpxxx, _bsxxx, _bsxxx, 3);
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
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
               ObjectListIterator var45 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_3_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var45.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var45.next();
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
                        ObjectListIterator var371 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_3_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var371.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var371.next();
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
                        ObjectListIterator var370 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_3_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var370.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var370.next();
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
                        ObjectListIterator var369 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_3_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var369.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var369.next();
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
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 4.0) {
            if (world instanceof ServerLevel _levelxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _levelxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
               BlockState _bsxxxx = world.getBlockState(_bpxxxx);
               if (_blockEntityxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxx).putDouble("butcherStage", 5.0);
               }

               if (world instanceof Level _levelxxxxxxxx) {
                  _levelxxxxxxxx.sendBlockUpdated(_bpxxxx, _bsxxxx, _bsxxxx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxx) {
               if (!_levelxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxx) {
               if (!_levelxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var52 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_4_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var52.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var52.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index12 = 0; index12 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index12++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var374 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_4_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var374.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var374.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index13 = 0; index13 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index13++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var373 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_4_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var373.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var373.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index14 = 0; index14 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index14++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var372 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_4_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var372.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var372.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 5.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _levelxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
               BlockState _bsxxxxx = world.getBlockState(_bpxxxxx);
               if (_blockEntityxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxx).putDouble("butcherStage", 6.0);
               }

               if (world instanceof Level _levelxxxxxxxxxx) {
                  _levelxxxxxxxxxx.sendBlockUpdated(_bpxxxxx, _bsxxxxx, _bsxxxxx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxx) {
               if (!_levelxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var59 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_5_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var59.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var59.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index15 = 0; index15 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index15++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var377 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_5_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var377.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var377.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index16 = 0; index16 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index16++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var376 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_5_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var376.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var376.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index17 = 0; index17 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index17++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var375 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_5_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var375.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var375.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 6.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
               BlockState _bsxxxxxx = world.getBlockState(_bpxxxxxx);
               if (_blockEntityxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxx).putDouble("butcherStage", 7.0);
               }

               if (world instanceof Level _levelxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxx.sendBlockUpdated(_bpxxxxxx, _bsxxxxxx, _bsxxxxxx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var66 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_6_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var66.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var66.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index18 = 0; index18 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index18++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var380 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_6_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var380.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var380.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index19 = 0; index19 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index19++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var379 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_6_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var379.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var379.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index20 = 0; index20 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index20++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var378 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_6_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var378.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var378.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 7.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
               BlockState _bsxxxxxxx = world.getBlockState(_bpxxxxxxx);
               if (_blockEntityxxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxxx).putDouble("butcherStage", 8.0);
               }

               if (world instanceof Level _levelxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxx.sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxx, _bsxxxxxxx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var73 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_7_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var73.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var73.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index21 = 0; index21 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index21++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var383 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_7_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var383.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var383.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index22 = 0; index22 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index22++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var382 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_7_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var382.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var382.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index23 = 0; index23 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index23++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var381 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_7_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var381.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var381.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 8.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxxxx = world.getBlockEntity(_bpxxxxxxxx);
               BlockState _bsxxxxxxxx = world.getBlockState(_bpxxxxxxxx);
               if (_blockEntityxxxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxxxx).putDouble("butcherStage", 9.0);
               }

               if (world instanceof Level _levelxxxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxxxx.sendBlockUpdated(_bpxxxxxxxx, _bsxxxxxxxx, _bsxxxxxxxx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var80 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_8_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var80.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var80.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index24 = 0; index24 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index24++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var386 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_8_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var386.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var386.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index25 = 0; index25 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index25++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var385 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_8_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var385.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var385.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index26 = 0; index26 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index26++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var384 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_8_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var384.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var384.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 9.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxx);
               BlockState _bsxxxxxxxxx = world.getBlockState(_bpxxxxxxxxx);
               if (_blockEntityxxxxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putDouble("butcherStage", 10.0);
               }

               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxxxxxx.sendBlockUpdated(_bpxxxxxxxxx, _bsxxxxxxxxx, _bsxxxxxxxxx, 3);
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var87 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_9_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var87.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var87.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index27 = 0; index27 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index27++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var389 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_9_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var389.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var389.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index28 = 0; index28 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index28++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var388 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_9_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var388.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var388.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index29 = 0; index29 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index29++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var387 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_9_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var387.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var387.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 10.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxx);
               BlockState _bsxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxx);
               if (_blockEntityxxxxxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putDouble("butcherStage", 11.0);
               }

               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxxxxxxxx.sendBlockUpdated(_bpxxxxxxxxxx, _bsxxxxxxxxxx, _bsxxxxxxxxxx, 3);
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var94 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_10_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var94.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var94.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index30 = 0; index30 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index30++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var392 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_10_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var392.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var392.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index31 = 0; index31 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index31++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var391 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_10_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var391.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var391.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index32 = 0; index32 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index32++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var390 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_10_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var390.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var390.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 11.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxxxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxx);
               BlockState _bsxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxx);
               if (_blockEntityxxxxxxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putDouble("butcherStage", 12.0);
               }

               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxxxxxxxxxx.sendBlockUpdated(_bpxxxxxxxxxxx, _bsxxxxxxxxxxx, _bsxxxxxxxxxxx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var101 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_11_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var101.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var101.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index33 = 0; index33 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index33++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var395 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_11_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var395.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var395.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index34 = 0; index34 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index34++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var394 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_11_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var394.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var394.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index35 = 0; index35 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index35++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var393 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_11_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var393.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var393.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 12.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxxxxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxx);
               BlockState _bsxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxx);
               if (_blockEntityxxxxxxxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putDouble("butcherStage", 13.0);
               }

               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxx.sendBlockUpdated(_bpxxxxxxxxxxxx, _bsxxxxxxxxxxxx, _bsxxxxxxxxxxxx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var108 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_12_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var108.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var108.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index36 = 0; index36 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index36++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var398 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_12_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var398.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var398.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index37 = 0; index37 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index37++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var397 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_12_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var397.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var397.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index38 = 0; index38 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index38++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var396 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_12_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var396.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var396.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 13.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxxxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxx);
               BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxx);
               if (_blockEntityxxxxxxxxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putDouble("butcherStage", 14.0);
               }

               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.sendBlockUpdated(_bpxxxxxxxxxxxxx, _bsxxxxxxxxxxxxx, _bsxxxxxxxxxxxxx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var115 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_13_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var115.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var115.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index39 = 0; index39 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index39++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var401 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_13_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var401.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var401.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index40 = 0; index40 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index40++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var400 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_13_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var400.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var400.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index41 = 0; index41 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index41++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var399 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_13_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var399.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var399.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 14.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (!world.isClientSide()) {
               BlockPos _bpxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxx);
               BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxx);
               if (_blockEntityxxxxxxxxxxxxxx != null) {
                  ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putDouble("butcherStage", 15.0);
               }

               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.sendBlockUpdated(_bpxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, 3);
               }
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var122 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_14_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var122.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var122.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index42 = 0; index42 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index42++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var404 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_14_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var404.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var404.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index43 = 0; index43 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index43++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var403 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_14_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var403.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var403.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index44 = 0; index44 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index44++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var402 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_14_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var402.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var402.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 15.0) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(5, _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAGON_SCALE_BLOCK.get()).defaultBlockState()));
            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                  );
               }
            }

            if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                     SoundSource.NEUTRAL,
                     0.3F,
                     1.0F
                  );
               } else {
                  _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
               ObjectListIterator var128 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_15_cut")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var128.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var128.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index45 = 0; index45 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index45++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var407 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_15_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var407.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var407.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index46 = 0; index46 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index46++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var406 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_15_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var406.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var406.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                  for (int index47 = 0; index47 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index47++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var405 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ender_dragon_15_cut")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var405.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var405.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
