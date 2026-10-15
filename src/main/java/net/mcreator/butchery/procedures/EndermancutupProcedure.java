package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Comparator;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class EndermancutupProcedure {
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
         && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()
         && (
            (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))
         )) {
         if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 0.0) {
            if (world instanceof ServerLevel _level) {
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {});
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

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState()));
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
               ObjectListIterator var26 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_head_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var26.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var26.next();
                  if (world instanceof ServerLevel _levelxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxx.addFreshEntity(entityToSpawn);
                  }
               }
            }
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 1.0) {
            if (world instanceof ServerLevel _levelxx) {
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxx, null, _stkprov -> {});
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

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState()));
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
               ObjectListIterator var32 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_1_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var32.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var32.next();
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
                  for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index0++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var222 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_1_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var222.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var222.next();
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
                  for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index1++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var221 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_1_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var221.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var221.next();
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
                  for (int index2 = 0; index2 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index2++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var18 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_1_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var18.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var18.next();
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
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxxxx, null, _stkprov -> {});
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

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState()));
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
               ObjectListIterator var39 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_2_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var39.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var39.next();
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
                        ObjectListIterator var225 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_2_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var225.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var225.next();
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
                        ObjectListIterator var224 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_2_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var224.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var224.next();
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
                        ObjectListIterator var223 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_2_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var223.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var223.next();
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
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxxxxxx, null, _stkprov -> {});
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

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState()));
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
               ObjectListIterator var46 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_3_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var46.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var46.next();
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
                        ObjectListIterator var228 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_3_drop")))
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
                     == 2) {
                  for (int index7 = 0; index7 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index7++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var227 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_3_drop")))
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
                        ObjectListIterator var226 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_3_drop")))
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
               }
            }

            ButcheryMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(ItemEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(4.0), e -> true).isEmpty()) {
                     if ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 4.0) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY)
                           .getItem()
                        == ButcheryModItems.ENDERMAN_HEART.get()) {
                        if (entity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.sendOverlayMessage(Component.literal("You manage to carefully remove the §3Enderman Heart§f!"));
                        }
                     } else if ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 4.0) instanceof ItemEntity _itemEntx
                              ? _itemEntx.getItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        != ButcheryModItems.ENDERMAN_HEART.get()) {
                        if (world instanceof Level _levelxxxxxxxx) {
                           if (!_levelxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.enderman.teleport")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.enderman.teleport")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        if (world instanceof ServerLevel _levelxxxxxxxxx) {
                           _levelxxxxxxxxx.sendParticles(ParticleTypes.PORTAL, x, y, z, 32, 1.0, 1.0, 1.0, 0.01);
                        }

                        if (entity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.sendOverlayMessage(Component.literal("The §3Enderman Heart §fvanished as soon as you touched it.."));
                        }
                     }
                  }
               }
            );
         } else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "butcherStage") == 4.0) {
            if (world instanceof ServerLevel _levelxxxxxxxx) {
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _levelxxxxxxxx, null, _stkprov -> {});
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

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState()));
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
               ObjectListIterator var53 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_4_drop")))
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
                  for (int index9 = 0; index9 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index9++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var231 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_4_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var231.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var231.next();
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
                  for (int index10 = 0; index10 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index10++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var230 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_4_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var230.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var230.next();
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
                  for (int index11 = 0; index11 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index11++) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        ObjectListIterator var229 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_4_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var229.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var229.next();
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
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(1, _levelxxxxxxxxxx, null, _stkprov -> {});
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

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState()));
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
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
               ObjectListIterator var60 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_5_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var60.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var60.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var234 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_5_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var234.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var234.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var233 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_5_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var233.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var233.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var232 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_5_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var232.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var232.next();
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
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(1, _levelxxxxxxxxxxxx, null, _stkprov -> {});
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

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState()));
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
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
               ObjectListIterator var67 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_6_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var67.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var67.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var237 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_6_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var237.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var237.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var236 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_6_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var236.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var236.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var235 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_6_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var235.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var235.next();
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
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(1, _levelxxxxxxxxxxxxxx, null, _stkprov -> {});
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

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState()));
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
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
               ObjectListIterator var74 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_7_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var74.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var74.next();
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var240 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_7_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var240.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var240.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var239 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_7_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var239.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var239.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var238 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_7_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var238.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var238.next();
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
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                  .hurtAndBreak(1, _levelxxxxxxxxxxxxxxxx, null, _stkprov -> {});
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState()));
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
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
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_8_drop")))
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
                        ObjectListIterator var243 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_8_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var243.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var243.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var242 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_8_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var242.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var242.next();
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                              ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                              entityToSpawn.setPickUpDelay(10);
                              _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                        ObjectListIterator var241 = world.getServer()
                           .reloadableRegistries()
                           .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/enderman_cut_8_drop")))
                           .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                           .iterator();

                        while (var241.hasNext()) {
                           ItemStack itemstackiterator = (ItemStack)var241.next();
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

            if ((Boolean)ButcheryconfigConfiguration.ORGANS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var82 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_2")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var82.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var82.next();
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }

               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var83 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_3")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var83.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var83.next();
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }

               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var84 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_4")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var84.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var84.next();
                     if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                     for (int index24 = 0; index24 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index24++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var250 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_2")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var250.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var250.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }

                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var251 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_3")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var251.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var251.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }

                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var252 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_4")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var252.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var252.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                     for (int index25 = 0; index25 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index25++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var247 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_2")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var247.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var247.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }

                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var248 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_3")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var248.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var248.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }

                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var249 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_4")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var249.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var249.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
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
                     for (int index26 = 0; index26 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index26++) {
                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var244 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_2")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var244.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var244.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }

                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var245 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_3")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var245.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var245.next();
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                                 ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxxxxxxxxxxxx, x, y, z, itemstackiterator);
                                 entityToSpawn.setPickUpDelay(10);
                                 _levelxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                              }
                           }
                        }

                        if (!world.isClientSide() && world.getServer() != null) {
                           ObjectListIterator var246 = world.getServer()
                              .reloadableRegistries()
                              .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/end_organs_drop_4")))
                              .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                              .iterator();

                           while (var246.hasNext()) {
                              ItemStack itemstackiterator = (ItemStack)var246.next();
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
            }
         }
      }
   }

   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
   }

   private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
      return world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z)))
         .findFirst()
         .orElse(null);
   }
}
