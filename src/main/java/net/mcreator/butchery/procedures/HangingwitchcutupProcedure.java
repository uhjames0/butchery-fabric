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

public class HangingwitchcutupProcedure {
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
               && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WITCH_CORPSE.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip198
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip198)
                        : -1
                  )
                  == 2) {
               if (world instanceof ServerLevel _level) {
                  (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               int _value = 3;
               BlockPos _pos = BlockPos.containing(x, y, z);
               BlockState _bs = world.getBlockState(_pos);
               if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_value)) {
                  world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, _value), 3);
               }

               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.armor.equip_leather")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.armor.equip_leather")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F,
                        false
                     );
                  }
               }

               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var34 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_skin_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var34.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var34.next();
                     if (world instanceof ServerLevel _levelx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelx.addFreshEntity(entityToSpawn);
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
                     for (int index12 = 0; index12 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index12++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var136 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_skin_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var136.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var136.next();
                              if (world instanceof ServerLevel _levelx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelx.addFreshEntity(entityToSpawn);
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
                     for (int index13 = 0; index13 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index13++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var135 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_skin_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var135.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var135.next();
                              if (world instanceof ServerLevel _levelx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelx.addFreshEntity(entityToSpawn);
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
                     for (int index14 = 0; index14 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index14++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var134 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_skin_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var134.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var134.next();
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
         } else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WITCH_CORPSE.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip8)
                        : -1
                  )
                  == 1) {
               if (world instanceof ServerLevel _levelx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               int _valuex = 2;
               BlockPos _posx = BlockPos.containing(x, y, z);
               BlockState _bsx = world.getBlockState(_posx);
               if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuex)) {
                  world.setBlock(_posx, (BlockState)_bsx.setValue(_integerProp, _valuex), 3);
               }

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_EVOKER_CORPSE.get()).defaultBlockState()));
               if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _levelx.playLocalSound(
                        x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                     );
                  }
               }

               if (world instanceof Level _levelxx) {
                  if (!_levelxx.isClientSide()) {
                     _levelxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _levelxx.playLocalSound(
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
                  ObjectListIterator var75 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var75.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var75.next();
                     if (world instanceof ServerLevel _levelxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WITCH_CORPSE.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip22
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip22)
                        : -1
                  )
                  == 3) {
               if (world instanceof ServerLevel _levelxxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               int _valuexx = 4;
               BlockPos _posxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = world.getBlockState(_posxx);
               if (_bsxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuexx)) {
                  world.setBlock(_posxx, (BlockState)_bsxx.setValue(_integerProp, _valuexx), 3);
               }

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_EVOKER_CORPSE.get()).defaultBlockState()));
               if (world instanceof Level _levelxxx) {
                  if (!_levelxxx.isClientSide()) {
                     _levelxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _levelxxx.playLocalSound(
                        x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                     );
                  }
               }

               if (world instanceof Level _levelxxxx) {
                  if (!_levelxxxx.isClientSide()) {
                     _levelxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _levelxxxx.playLocalSound(
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
                  ObjectListIterator var68 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_1_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var68.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var68.next();
                     if (world instanceof ServerLevel _levelxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var173 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_1_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var173.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var173.next();
                              if (world instanceof ServerLevel _levelxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var172 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_1_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var172.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var172.next();
                              if (world instanceof ServerLevel _levelxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var171 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_1_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var171.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var171.next();
                              if (world instanceof ServerLevel _levelxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WITCH_CORPSE.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip61
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip61)
                        : -1
                  )
                  == 4) {
               if (world instanceof ServerLevel _levelxxxxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxxxxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               int _valuexxx = 5;
               BlockPos _posxxx = BlockPos.containing(x, y, z);
               BlockState _bsxxx = world.getBlockState(_posxxx);
               if (_bsxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuexxx)) {
                  world.setBlock(_posxxx, (BlockState)_bsxxx.setValue(_integerProp, _valuexxx), 3);
               }

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_EVOKER_CORPSE.get()).defaultBlockState()));
               if (world instanceof Level _levelxxxxx) {
                  if (!_levelxxxxx.isClientSide()) {
                     _levelxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _levelxxxxx.playLocalSound(
                        x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                     );
                  }
               }

               if (world instanceof Level _levelxxxxxx) {
                  if (!_levelxxxxxx.isClientSide()) {
                     _levelxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxx.playLocalSound(
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
                  ObjectListIterator var61 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_2_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var61.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var61.next();
                     if (world instanceof ServerLevel _levelxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var170 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var170.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var170.next();
                              if (world instanceof ServerLevel _levelxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var169 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var169.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var169.next();
                              if (world instanceof ServerLevel _levelxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var168 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_2_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var168.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var168.next();
                              if (world instanceof ServerLevel _levelxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WITCH_CORPSE.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip100
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip100)
                        : -1
                  )
                  == 5) {
               if (world instanceof ServerLevel _levelxxxxxxx) {
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                     .hurtAndBreak(1, _levelxxxxxxx, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_EVOKER_CORPSE.get()).defaultBlockState()));
               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
               if (world instanceof Level _levelxxxxxxx) {
                  if (!_levelxxxxxxx.isClientSide()) {
                     _levelxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxx.playLocalSound(
                        x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")), SoundSource.NEUTRAL, 0.3F, 1.0F, false
                     );
                  }
               }

               if (world instanceof Level _levelxxxxxxxx) {
                  if (!_levelxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.step")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxx.playLocalSound(
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
                  ObjectListIterator var50 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_3_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var50.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var50.next();
                     if (world instanceof ServerLevel _levelxxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var158 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_3_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var158.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var158.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator var157 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_3_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var157.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var157.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                           ObjectListIterator entityToSpawn = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/witch_cut_3_drop")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (entityToSpawn.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)entityToSpawn.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                 ItemEntity entityToSpawnx = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawnx.setPickUpDelay(10);
                                 _levelxxxxxxxxx.addFreshEntity(entityToSpawnx);
                              }
                           }
                        }
                     }
                  }
               }

               if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var52 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var52.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var52.next();
                        if (world instanceof ServerLevel _levelxxxxxxxxx) {
                           ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
                        }
                     }
                  }

                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var53 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var53.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var53.next();
                        if (world instanceof ServerLevel _levelxxxxxxxxx) {
                           ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
                        }
                     }
                  }

                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var54 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var54.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var54.next();
                        if (world instanceof ServerLevel _levelxxxxxxxxx) {
                           ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var165 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var165.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var165.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var166 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var166.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var166.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var167 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var167.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var167.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var162.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var162.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var163 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var163.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var163.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var164 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var164.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var164.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var159 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_1")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var159.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var159.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var160 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_2")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var160.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var160.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
                                 }
                              }
                           }

                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var161 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/organs_drop_3")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var161.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var161.next();
                                 if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                    ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxx, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _levelxxxxxxxxx.addFreshEntity(entityToSpawn);
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
