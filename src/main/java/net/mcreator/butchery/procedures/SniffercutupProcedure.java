package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
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
import org.jetbrains.annotations.Nullable;

public class SniffercutupProcedure {
   public static void onRightClickBlock(RightClickBlockShim event) {
      if (event.getHand() == InteractionHand.MAIN_HAND) {
         execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!(entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
               .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))
            && !(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
               .is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) {
            if ((
                  (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                        .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:skinning_knives")))
                     || (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .is(TagKey.create(Registries.ITEM, Identifier.parse("c:skinning_knives")))
               )
               && getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")
               && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()
               && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 1.0) {
               if (world instanceof ServerLevel _level) {
                  (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _level, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (!world.isClientSide()) {
                  BlockPos _bp = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntity = world.getBlockEntity(_bp);
                  BlockState _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     ButcheryPersistentData.of(_blockEntity).putDouble("butcherStage", 2.0);
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               world.levelEvent(
                  2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState())
               );
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
                  ObjectListIterator var60 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_fur_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var60.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var60.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }

               if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
                  if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 1) {
                     for (int index18 = 0; index18 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index18++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var172 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_fur_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var172.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var172.next();
                              if (world instanceof ServerLevel _levelxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  } else if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 2) {
                     for (int index19 = 0; index19 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index19++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var171 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_fur_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var171.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var171.next();
                              if (world instanceof ServerLevel _levelxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  } else if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 3) {
                     for (int index20 = 0; index20 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index20++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var170 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_fur_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var170.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var170.next();
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
            }
         } else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()
               && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 0.0) {
               if (world instanceof ServerLevel _levelxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _levelxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (!world.isClientSide()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                  BlockState _bsx = world.getBlockState(_bpx);
                  if (_blockEntityx != null) {
                     ButcheryPersistentData.of(_blockEntityx).putDouble("butcherStage", 1.0);
                  }

                  if (world instanceof Level _levelxx) {
                     _levelxx.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                  }
               }

               world.levelEvent(
                  2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState())
               );
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
                  ObjectListIterator var54 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var54.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var54.next();
                     if (world instanceof ServerLevel _levelxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()
               && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 2.0) {
               if (world instanceof ServerLevel _levelxxxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _levelxxxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
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

               world.levelEvent(
                  2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState())
               );
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
                  ObjectListIterator var45 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_1_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var45.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var45.next();
                     if (world instanceof ServerLevel _levelxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }

               if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
                  if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 1) {
                     for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index0++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var166 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_1_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var166.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var166.next();
                              if (world instanceof ServerLevel _levelxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 2) {
                     for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index1++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var165 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_1_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var165.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var165.next();
                              if (world instanceof ServerLevel _levelxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 3) {
                     for (int index2 = 0; index2 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index2++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var164 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_1_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var164.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var164.next();
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

               if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var47 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var47.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var47.next();
                        if (world instanceof ServerLevel _levelxxxxxx) {
                           ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _levelxxxxxx.addFreshEntity(entityToSpawn);
                        }
                     }
                  }

                  if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
                     if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 1) {
                        for (int index3 = 0; index3 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index3++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var169 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var169.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var169.next();
                                 if (world instanceof ServerLevel _levelxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }
                        }
                     } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 2) {
                        for (int index4 = 0; index4 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index4++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var168 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var168.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var168.next();
                                 if (world instanceof ServerLevel _levelxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }
                        }
                     } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 3) {
                        for (int index5 = 0; index5 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index5++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var167 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var167.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var167.next();
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
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()
               && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 3.0) {
               if (world instanceof ServerLevel _levelxxxxxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                     .hurtAndBreak(5, _levelxxxxxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
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

               world.levelEvent(
                  2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState())
               );
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
                  ObjectListIterator var36 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_2_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var36.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var36.next();
                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }

               if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
                  if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 1) {
                     for (int index6 = 0; index6 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index6++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var160 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var160.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var160.next();
                              if (world instanceof ServerLevel _levelxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 2) {
                     for (int index7 = 0; index7 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index7++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var159 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var159.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var159.next();
                              if (world instanceof ServerLevel _levelxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 3) {
                     for (int index8 = 0; index8 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index8++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var158 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var158.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var158.next();
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

               if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var38 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var38.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var38.next();
                        if (world instanceof ServerLevel _levelxxxxxxxx) {
                           ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                        }
                     }
                  }

                  if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
                     if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 1) {
                        for (int index9 = 0; index9 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index9++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var163 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var163.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var163.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }
                        }
                     } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 2) {
                        for (int index10 = 0; index10 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index10++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var162 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var162.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var162.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }
                        }
                     } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 3) {
                        for (int index11 = 0; index11 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index11++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var161 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var161.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var161.next();
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()
               && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 4.0) {
               if (world instanceof ServerLevel _levelxxxxxxxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                     .hurtAndBreak(5, _levelxxxxxxxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
               world.levelEvent(
                  2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SNIFFER_CARCASS_BLOCK.get()).defaultBlockState())
               );
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
                  ObjectListIterator var27 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_3_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var27.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var27.next();
                     if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }

               if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
                  if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 1) {
                     for (int index12 = 0; index12 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index12++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var154 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_3_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var154.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var154.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 2) {
                     for (int index13 = 0; index13 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index13++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var153 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_3_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var153.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var153.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        != 0
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                           .getEnchantments()
                           .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                        == 3) {
                     for (int index14 = 0; index14 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index14++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var20 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sniffer_cut_3_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var20.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var20.next();
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

               if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var29 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var29.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var29.next();
                        if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                           ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                        }
                     }
                  }

                  if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
                     if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 1) {
                        for (int index15 = 0; index15 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index15++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var157 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var157.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var157.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }
                        }
                     } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 2) {
                        for (int index16 = 0; index16 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index16++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var156 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var156.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var156.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }
                        }
                     } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 3) {
                        for (int index17 = 0; index17 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index17++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var155 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var155.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var155.next();
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
               }
            }
         }
      }
   }

   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
   }

   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
   }
}
