package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.function.Function;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
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

public class WithercutupProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null
         && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
            .is(TagKey.create(Registries.ITEM, Identifier.parse("butchery:boss_tool")))
         && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "witherCut") == 0.0) {
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
               ButcheryPersistentData.of(_blockEntity).putDouble("witherCut", 1.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.WITHER_SKELETON_WALL_SKULL.defaultBlockState()));
         if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
               _level.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:crumbling")),
                  SoundSource.NEUTRAL,
                  0.1F,
                  0.5F
               );
            } else {
               _level.playLocalSound(
                  x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:crumbling")), SoundSource.NEUTRAL, 0.1F, 0.5F, false
               );
            }
         }

         if (!world.isClientSide() && world.getServer() != null) {
            ObjectListIterator var23 = world.getServer()
               .reloadableRegistries()
               .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/wither_heart_drop")))
               .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
               .iterator();

            while (var23.hasNext()) {
               ItemStack itemstackiterator = (ItemStack)var23.next();
               if (world instanceof ServerLevel _levelx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelx, x, y, z, itemstackiterator);
                  entityToSpawn.setPickUpDelay(10);
                  _levelx.addFreshEntity(entityToSpawn);
               }
            }
         }

         if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
            label156:
            if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                     .getEnchantments()
                     .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                  != 0
               && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                     .getEnchantments()
                     .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                  == 1) {
               int index0 = 0;

               while (true) {
                  if (index0 >= (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0)) {
                     break label156;
                  }

                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var35 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/wither_heart_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var35.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var35.next();
                        if (world instanceof ServerLevel _levelx) {
                           ItemEntity entityToSpawn = new ItemEntity(_levelx, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _levelx.addFreshEntity(entityToSpawn);
                        }
                     }
                  }

                  index0++;
               }
            } else if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                     .getEnchantments()
                     .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                  != 0
               && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                     .getEnchantments()
                     .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                  == 2) {
               int index1 = 0;

               while (true) {
                  if (index1 >= (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0)) {
                     break label156;
                  }

                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var34 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/wither_heart_drop")))
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

                  index1++;
               }
            } else if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
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
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/wither_heart_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var16.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var16.next();
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

         new WithercutupProcedure.RedwiresTimedLoop(
               25,
               1,
               _timedLoop -> {
                  if (world instanceof ServerLevel _levelxxxx) {
                     _levelxxxx.sendParticles(
                        (SimpleParticleType)ButcheryModParticleTypes.WITHERSMOKE.get(),
                        x + Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                        y,
                        z + Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                        10,
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.1, 0.75)
                     );
                  }

                  if (world instanceof ServerLevel _levelxxx) {
                     _levelxxx.sendParticles(
                        (SimpleParticleType)ButcheryModParticleTypes.WITHERSMOKE.get(),
                        x + Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                        y,
                        z - Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                        10,
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.1, 0.75)
                     );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.sendParticles(
                        (SimpleParticleType)ButcheryModParticleTypes.WITHERSMOKE.get(),
                        x - Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                        y,
                        z + Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                        10,
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.1, 0.75)
                     );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.sendParticles(
                        (SimpleParticleType)ButcheryModParticleTypes.WITHERSMOKE.get(),
                        x - Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                        y,
                        z - Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                        10,
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.0, 0.75),
                        Mth.nextDouble(RandomSource.create(), 0.1, 1.5)
                     );
                  }

                  return true;
               }
            )
            .run();
         ButcheryMod.queueServerWork(20, () -> world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3));
      }
   }

   private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
   }

   private static class RedwiresTimedLoop {
      private int iterator = 0;
      private int ticks = 0;
      private final int total;
      private final Function<WithercutupProcedure.RedwiresTimedLoop, Boolean> forEach;

      private RedwiresTimedLoop(int total, int ticks, Function<WithercutupProcedure.RedwiresTimedLoop, Boolean> forEach) {
         this.total = total;
         this.ticks = ticks;
         this.forEach = forEach;
      }

      private void run() {
         if (this.forEach.apply(this)) {
            ButcheryMod.queueServerWork(this.ticks, this::next);
         }
      }

      private void setTicks(int ticks) {
         this.ticks = ticks;
      }

      private int getIterator() {
         return this.iterator;
      }

      private void next() {
         if (this.total > ++this.iterator) {
            this.run();
         }
      }
   }
}
