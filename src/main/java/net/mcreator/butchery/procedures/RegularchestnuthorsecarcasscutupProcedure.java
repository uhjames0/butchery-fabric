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

public class RegularchestnuthorsecarcasscutupProcedure {
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
               && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_CHESTNUT_HORSE_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip232
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip232)
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

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_DONKEY_CARCASS.get()).defaultBlockState()));
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
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/chestnut_horse_skin_drop")))
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
                     for (int index18 = 0; index18 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index18++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var147 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/chestnut_horse_skin_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var147.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var147.next();
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
                           ObjectListIterator var146 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/chestnut_horse_skin_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var146.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var146.next();
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
                           ObjectListIterator var145 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/chestnut_horse_skin_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var145.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var145.next();
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
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_CHESTNUT_HORSE_CARCASS.get()
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

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_DONKEY_CARCASS.get()).defaultBlockState()));
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
                  ObjectListIterator var78 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/chestnut_horse_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var78.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var78.next();
                     if (world instanceof ServerLevel _levelxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_CHESTNUT_HORSE_CARCASS.get()
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

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_DONKEY_CARCASS.get()).defaultBlockState()));
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
                  ObjectListIterator var69 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_1_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var69.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var69.next();
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
                           ObjectListIterator var189 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_1_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var189.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var189.next();
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
                           ObjectListIterator var188 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_1_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var188.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var188.next();
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
                           ObjectListIterator var187 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_1_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var187.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var187.next();
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
                     ObjectListIterator var71 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var71.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var71.next();
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
                              ObjectListIterator var192 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var192.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var192.next();
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
                              ObjectListIterator var191 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var191.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var191.next();
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
                              ObjectListIterator var190 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var190.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var190.next();
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_CHESTNUT_HORSE_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip90
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip90)
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

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_DONKEY_CARCASS.get()).defaultBlockState()));
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
                  ObjectListIterator var60 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_2_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var60.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var60.next();
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
                           ObjectListIterator var183 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var183.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var183.next();
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
                           ObjectListIterator var182 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var182.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var182.next();
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
                           ObjectListIterator var181 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var181.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var181.next();
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
                     ObjectListIterator var62 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var62.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var62.next();
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
                              ObjectListIterator var186 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var186.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var186.next();
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
                              ObjectListIterator var185 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var185.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var185.next();
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
                              ObjectListIterator var184 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var184.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var184.next();
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_REGULAR_CHESTNUT_HORSE_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip158
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip158)
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
               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_DONKEY_CARCASS.get()).defaultBlockState()));
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

               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var51 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_3_drop")))
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
                     for (int index12 = 0; index12 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index12++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var177 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_3_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var177.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var177.next();
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
                           ObjectListIterator var176 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_3_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var176.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var176.next();
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
                           ObjectListIterator entityToSpawn = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/horse_cut_3_drop")))
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

               if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var53 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
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
                              ObjectListIterator var180 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var180.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var180.next();
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
                              ObjectListIterator var179 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var179.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var179.next();
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
                              ObjectListIterator var178 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var178.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var178.next();
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
