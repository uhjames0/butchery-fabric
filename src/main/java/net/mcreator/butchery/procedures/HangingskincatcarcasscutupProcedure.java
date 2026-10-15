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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class HangingskincatcarcasscutupProcedure {
   public static void onRightClickBlock(RightClickBlockShim event) {
      if (event.getHand() == InteractionHand.MAIN_HAND) {
         execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null
         && (
            (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))
         )
         && getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CAT_CARCASS.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip8)
                     : -1
               )
               == 1) {
            if (world instanceof ServerLevel _level) {
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            int _value = 2;
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
               && _integerProp.getPossibleValues().contains(_value)) {
               world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, _value), 3);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_OCELOT_CARCASS.get()).defaultBlockState()));
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
               ObjectListIterator var49 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_1_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var49.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var49.next();
                  if (world instanceof ServerLevel _levelxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var137 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_1_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var137.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var137.next();
                           if (world instanceof ServerLevel _levelxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var136 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_1_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var136.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var136.next();
                           if (world instanceof ServerLevel _levelxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var135 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_1_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var135.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var135.next();
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

            if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var51 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var51.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var51.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var140 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var140.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var140.next();
                              if (world instanceof ServerLevel _levelxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var139 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var139.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var139.next();
                              if (world instanceof ServerLevel _levelxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var138 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var138.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var138.next();
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
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CAT_CARCASS.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip76
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip76)
                     : -1
               )
               == 2) {
            if (world instanceof ServerLevel _levelxx) {
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            int _valuex = 3;
            BlockPos _posx = BlockPos.containing(x, y, z);
            BlockState _bsx = world.getBlockState(_posx);
            if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
               && _integerProp.getPossibleValues().contains(_valuex)) {
               world.setBlock(_posx, (BlockState)_bsx.setValue(_integerProp, _valuex), 3);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_OCELOT_CARCASS.get()).defaultBlockState()));
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
               ObjectListIterator var40 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_2_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var40.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var40.next();
                  if (world instanceof ServerLevel _levelxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var131 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_2_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var131.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var131.next();
                           if (world instanceof ServerLevel _levelxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var130 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_2_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var130.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var130.next();
                           if (world instanceof ServerLevel _levelxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var129 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_2_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var129.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var129.next();
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

            if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var42 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var42.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var42.next();
                     if (world instanceof ServerLevel _levelxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var134 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var134.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var134.next();
                              if (world instanceof ServerLevel _levelxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var133 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var133.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var133.next();
                              if (world instanceof ServerLevel _levelxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var132 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var132.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var132.next();
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
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CAT_CARCASS.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip144
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip144)
                     : -1
               )
               == 3) {
            if (world instanceof ServerLevel _levelxxxx) {
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_OCELOT_CARCASS.get()).defaultBlockState()));
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
               ObjectListIterator var31 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_3_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var31.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var31.next();
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
                  for (int index12 = 0; index12 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index12++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var125 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_3_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var125.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var125.next();
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
                  for (int index13 = 0; index13 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index13++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var124 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_3_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var124.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var124.next();
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
                  for (int index14 = 0; index14 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index14++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var21 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/skinned_cat_cut_3_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var21.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var21.next();
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
                  ObjectListIterator var33 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var33.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var33.next();
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
                     for (int index15 = 0; index15 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index15++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var128 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var128.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var128.next();
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
                     for (int index16 = 0; index16 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index16++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var127 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var127.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var127.next();
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
                     for (int index17 = 0; index17 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index17++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var126 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var126.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var126.next();
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
         }
      }
   }

   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
   }
}
