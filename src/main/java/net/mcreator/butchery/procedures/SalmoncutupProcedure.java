package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootParams.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class SalmoncutupProcedure {
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
         && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SALMON_CARCASS.get()) {
         if (world instanceof ServerLevel _level) {
            (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {});
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
         }

         if (FabricLoader.getInstance().isModLoaded("farmersdelight")) {
            if ((Boolean)ButcheryconfigConfiguration.FARMERS_DELIGHT.get()) {
               if (world instanceof ServerLevel _level) {
                  ItemEntity entityToSpawn = new ItemEntity(
                     _level, x, y, z, new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:salmon_slice")))
                  );
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
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
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(
                              _level, x, y, z, new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:salmon_slice")))
                           );
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(
                              _level, x, y, z, new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:salmon_slice")))
                           );
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(
                              _level, x, y, z, new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:salmon_slice")))
                           );
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
                        }
                     }
                  }
               }
            } else {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var25 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/salmon_cut_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var25.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var25.next();
                     if (world instanceof ServerLevel _level) {
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var61 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/salmon_cut_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var61.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var61.next();
                              if (world instanceof ServerLevel _level) {
                                 ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _level.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var60 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/salmon_cut_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var60.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var60.next();
                              if (world instanceof ServerLevel _level) {
                                 ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _level.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var59 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/salmon_cut_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var59.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var59.next();
                              if (world instanceof ServerLevel _level) {
                                 ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _level.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  }
               }
            }
         } else {
            if (!world.isClientSide() && world.getServer() != null) {
               ObjectListIterator var23 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/salmon_cut_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var23.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var23.next();
                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var58 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/salmon_cut_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var58.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var58.next();
                           if (world instanceof ServerLevel _level) {
                              ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _level.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var57 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/salmon_cut_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var57.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var57.next();
                           if (world instanceof ServerLevel _level) {
                              ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _level.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator _level = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/salmon_cut_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (_level.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)_level.next();
                           if (world instanceof ServerLevel _levelx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               }
            }
         }

         world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
         world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.SALMON_CARCASS.get()).defaultBlockState()));
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
      }
   }
}
