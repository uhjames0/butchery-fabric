package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryVariants;
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
import net.minecraft.world.level.ItemLike;
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

public class SheepcutupProcedure {
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
               && ButcheryVariants.isDrainedSheepCarcass(world, x, y, z)
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip324
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip324)
                        : -1
                  )
                  == 6) {
               if (world instanceof ServerLevel _level) {
                  (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               int _value = 7;
               BlockPos _pos = BlockPos.containing(x, y, z);
               BlockState _bs = world.getBlockState(_pos);
               if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_value)) {
                  world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, _value), 3);
               }

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SHEEP_CARCASS.get()).defaultBlockState()));
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
                  ObjectListIterator var35 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/" + ButcheryVariants.sheepSkinDrop(world, x, y, z))))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var35.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var35.next();
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
                     for (int index24 = 0; index24 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index24++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var173 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/" + ButcheryVariants.sheepSkinDrop(world, x, y, z))))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var173.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var173.next();
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
                     for (int index25 = 0; index25 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index25++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var172 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/" + ButcheryVariants.sheepSkinDrop(world, x, y, z))))
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
                        == 3) {
                     for (int index26 = 0; index26 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index26++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var171 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/" + ButcheryVariants.sheepSkinDrop(world, x, y, z))))
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
                  }
               }
            }
         } else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
            if (ButcheryVariants.isDrainedSheepCarcass(world, x, y, z)
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip8)
                        : -1
                  )
                  == 0) {
               if (world instanceof ServerLevel _levelxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               int _valuex = 6;
               BlockPos _posx = BlockPos.containing(x, y, z);
               BlockState _bsx = world.getBlockState(_posx);
               if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuex)) {
                  world.setBlock(_posx, (BlockState)_bsx.setValue(_integerProp, _valuex), 3);
               }

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SHEEP_CARCASS.get()).defaultBlockState()));
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
                  ObjectListIterator var86 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/" + ButcheryVariants.sheepHeadDrop(world, x, y, z))))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var86.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var86.next();
                     if (world instanceof ServerLevel _levelxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (ButcheryVariants.isDrainedSheepCarcass(world, x, y, z)
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip22
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip22)
                        : -1
                  )
                  == 7) {
               if (world instanceof ServerLevel _levelxxxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxxxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               int _valuexx = 8;
               BlockPos _posxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = world.getBlockState(_posxx);
               if (_bsxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuexx)) {
                  world.setBlock(_posxx, (BlockState)_bsxx.setValue(_integerProp, _valuexx), 3);
               }

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SHEEP_CARCASS.get()).defaultBlockState()));
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

               if (FabricLoader.getInstance().isModLoaded("farmersdelight") && (Boolean)ButcheryconfigConfiguration.FARMERS_DELIGHT.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var75 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_1_drop_fd_compat")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var75.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var75.next();
                        if (world instanceof ServerLevel _levelxxxxxx) {
                           ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _levelxxxxxx.addFreshEntity(entityToSpawn);
                        }
                     }
                  }

                  if (world instanceof ServerLevel _levelxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(
                        _levelxxxxxx, x, y, z, new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                     );
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxx.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof ServerLevel _levelxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(
                        _levelxxxxxx, x, y, z, new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                     );
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxx.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var239 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_1_drop_fd_compat")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var239.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var239.next();
                                 if (world instanceof ServerLevel _levelxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (world instanceof ServerLevel _levelxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxx.addFreshEntity(entityToSpawn);
                           }

                           if (world instanceof ServerLevel _levelxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxx.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var236 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_1_drop_fd_compat")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var236.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var236.next();
                                 if (world instanceof ServerLevel _levelxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (world instanceof ServerLevel _levelxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxx.addFreshEntity(entityToSpawn);
                           }

                           if (world instanceof ServerLevel _levelxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxx.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var233 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_1_drop_fd_compat")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var233.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var233.next();
                                 if (world instanceof ServerLevel _levelxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (world instanceof ServerLevel _levelxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxx.addFreshEntity(entityToSpawn);
                           }

                           if (world instanceof ServerLevel _levelxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               } else {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var73 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_1_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var73.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var73.next();
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
                              ObjectListIterator var232 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_1_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var232.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var232.next();
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
                              ObjectListIterator var231 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_1_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var231.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var231.next();
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
                              ObjectListIterator var230 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_1_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var230.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var230.next();
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

               if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var79 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var79.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var79.next();
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
                        for (int index6 = 0; index6 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index6++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var244 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var244.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var244.next();
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
                        for (int index7 = 0; index7 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index7++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var243 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var243.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var243.next();
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
                        for (int index8 = 0; index8 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index8++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var242 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var242.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var242.next();
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
            } else if (ButcheryVariants.isDrainedSheepCarcass(world, x, y, z)
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip136
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip136)
                        : -1
                  )
                  == 8) {
               if (world instanceof ServerLevel _levelxxxxxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                     .hurtAndBreak(1, _levelxxxxxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               int _valuexxx = 9;
               BlockPos _posxxx = BlockPos.containing(x, y, z);
               BlockState _bsxxx = world.getBlockState(_posxxx);
               if (_bsxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuexxx)) {
                  world.setBlock(_posxxx, (BlockState)_bsxxx.setValue(_integerProp, _valuexxx), 3);
               }

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SHEEP_CARCASS.get()).defaultBlockState()));
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
                  ObjectListIterator var64 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_2_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var64.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var64.next();
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
                           ObjectListIterator var226 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var226.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var226.next();
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
                           ObjectListIterator var225 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var225.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var225.next();
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
                           ObjectListIterator var224 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var224.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var224.next();
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
                     ObjectListIterator var66 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var66.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var66.next();
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
                        for (int index12 = 0; index12 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index12++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var229 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var229.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var229.next();
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
                        for (int index13 = 0; index13 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index13++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var228 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var228.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var228.next();
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
                        for (int index14 = 0; index14 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index14++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var227 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var227.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var227.next();
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
            } else if (ButcheryVariants.isDrainedSheepCarcass(world, x, y, z)
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip204
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip204)
                        : -1
                  )
                  == 9) {
               if (world instanceof ServerLevel _levelxxxxxxxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                     .hurtAndBreak(1, _levelxxxxxxxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_SHEEP_CARCASS.get()).defaultBlockState()));
               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
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

               if (FabricLoader.getInstance().isModLoaded("farmersdelight") && (Boolean)ButcheryconfigConfiguration.FARMERS_DELIGHT.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var53 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_3_drop_fd_compat")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var53.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var53.next();
                        if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                           ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                        }
                     }
                  }

                  if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(
                        _levelxxxxxxxxxx, x, y, z, new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                     );
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(
                        _levelxxxxxxxxxx, x, y, z, new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                     );
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var218 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_3_drop_fd_compat")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var218.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var218.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }

                           if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var215 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_3_drop_fd_compat")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var215.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var215.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }

                           if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var212 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_3_drop_fd_compat")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var212.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var212.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }

                           if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(
                                 _levelxxxxxxxxxx,
                                 x,
                                 y,
                                 z,
                                 new ItemStack((ItemLike)BuiltInRegistries.ITEM.getValue(Identifier.parse("farmersdelight:mutton_chops")))
                              );
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxx.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }
               } else {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var51 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_3_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var51.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var51.next();
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
                        for (int index18 = 0; index18 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index18++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var211 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_3_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var211.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var211.next();
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
                        for (int index19 = 0; index19 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index19++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var210 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_3_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var210.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var210.next();
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
                        for (int index20 = 0; index20 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index20++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator entityToSpawn = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/sheep_cut_3_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (entityToSpawn.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)entityToSpawn.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                    ItemEntity entityToSpawnx = new ItemEntity(_levelxxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawnx.setPickUpDelay(10);
                                    _levelxxxxxxxxxx.addFreshEntity(entityToSpawnx);
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var57 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var57.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var57.next();
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
                        for (int index21 = 0; index21 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index21++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var223 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var223.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var223.next();
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
                        for (int index22 = 0; index22 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index22++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var222 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var222.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var222.next();
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
                        for (int index23 = 0; index23 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index23++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var221 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var221.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var221.next();
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
}
