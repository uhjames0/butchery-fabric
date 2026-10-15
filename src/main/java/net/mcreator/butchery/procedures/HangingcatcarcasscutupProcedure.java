package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.ProblemReporter;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.storage.loot.LootParams.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

public class HangingcatcarcasscutupProcedure {
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
               && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()
               )
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip119
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip119)
                        : -1
                  )
                  == 2) {
               if (world instanceof ServerLevel _level) {
                  (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {});
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var65 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/all_black_cat_skin_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var65.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var65.next();
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                        for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index0++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var252 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/all_black_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var252.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var252.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index1++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var251 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/all_black_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var251.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var251.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index2 = 0; index2 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index2++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var250 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/all_black_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var250.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var250.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var63 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/black_cat_skin_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var63.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var63.next();
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                        for (int index3 = 0; index3 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index3++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var249 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/black_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var249.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var249.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index4 = 0; index4 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index4++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var248 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/black_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var248.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var248.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index5 = 0; index5 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index5++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var247 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/black_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var247.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var247.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var61 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bshorthair_cat_skin_drop")))
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

                  if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
                     if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 1) {
                        for (int index6 = 0; index6 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index6++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var246 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bshorthair_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var246.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var246.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index7 = 0; index7 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index7++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var245 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bshorthair_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var245.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var245.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index8 = 0; index8 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index8++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var244 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bshorthair_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var244.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var244.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var59 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/calico_cat_skin_drop")))
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

                  if ((Boolean)ButcheryconfigConfiguration.LOOTING_ENCHANT.get()) {
                     if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           != 0
                        && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getEnchantments()
                              .getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))
                           == 1) {
                        for (int index9 = 0; index9 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index9++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var243 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/calico_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var243.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var243.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index10 = 0; index10 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index10++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var242 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/calico_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var242.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var242.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index11 = 0; index11 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index11++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var241 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/calico_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var241.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var241.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var57 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/jellie_cat_skin_drop")))
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
                              ObjectListIterator var240 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/jellie_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var240.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var240.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var239 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/jellie_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var239.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var239.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var238 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/jellie_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var238.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var238.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var55 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/persian_cat_skin_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var55.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var55.next();
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                        for (int index15 = 0; index15 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index15++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var237 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/persian_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var237.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var237.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index16 = 0; index16 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index16++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var236 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/persian_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var236.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var236.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index17 = 0; index17 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index17++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var235 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/persian_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var235.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var235.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var53 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ragdoll_cat_skin_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var53.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var53.next();
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var234 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ragdoll_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var234.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var234.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var233 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ragdoll_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var233.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var233.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var232 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ragdoll_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var232.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var232.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var51 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/red_cat_skin_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var51.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var51.next();
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                        for (int index21 = 0; index21 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index21++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var231 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/red_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var231.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var231.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index22 = 0; index22 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index22++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var230 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/red_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var230.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var230.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index23 = 0; index23 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index23++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var229 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/red_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var229.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var229.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var49 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/siamese_cat_skin_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var49.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var49.next();
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var228 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/siamese_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var228.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var228.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var227 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/siamese_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var227.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var227.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                              ObjectListIterator var226 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/siamese_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var226.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var226.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var47 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/tabby_cat_skin_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var47.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var47.next();
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                        for (int index27 = 0; index27 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index27++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var225 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/tabby_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var225.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var225.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index28 = 0; index28 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index28++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var224 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/tabby_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var224.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var224.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index29 = 0; index29 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index29++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var223 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/tabby_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var223.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var223.next();
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
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()) {
                  if (!world.isClientSide() && world.getServer() != null) {
                     ObjectListIterator var45 = world.getServer()
                        .reloadableRegistries()
                        .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/white_cat_skin_drop")))
                        .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                        .iterator();

                     while (var45.hasNext()) {
                        ItemStack itemstackiterator = (ItemStack)var45.next();
                        if (world instanceof ServerLevel _level) {
                           ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
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
                        for (int index30 = 0; index30 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 1.0); index30++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var222 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/white_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var222.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var222.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index31 = 0; index31 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 2.0); index31++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var221 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/white_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var221.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var221.next();
                                 if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
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
                        for (int index32 = 0; index32 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index32++) {
                           if (!world.isClientSide() && world.getServer() != null) {
                              ObjectListIterator var21 = world.getServer()
                                 .reloadableRegistries()
                                 .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/white_cat_skin_drop")))
                                 .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                                 .iterator();

                              while (var21.hasNext()) {
                                 ItemStack itemstackiterator = (ItemStack)var21.next();
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

               ButcheryMod.queueServerWork(
                  1,
                  () -> {
                     BlockPos _bp = BlockPos.containing(x, y, z);
                     BlockState _bsx = blockStateWithDirection(
                        (new Object() {
                              public BlockState with(BlockState _bs, String _property, int _newValue) {
                                 Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                 return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                    ? (BlockState)_bs.setValue(_ip, _newValue)
                                    : _bs;
                              }
                           })
                           .with(((Block)ButcheryModBlocks.CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1),
                        getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y + 1.0, z)))
                     );
                     BlockEntity _be = world.getBlockEntity(_bp);
                     CompoundTag _bnbt = null;
                     if (_be != null) {
                        _bnbt = _be.saveWithFullMetadata(world.registryAccess());
                        _be.setRemoved();
                     }

                     world.setBlock(_bp, _bsx, 3);
                     if (_bnbt != null) {
                        _be = world.getBlockEntity(_bp);
                        if (_be != null) {
                           try {
                              _be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
                           } catch (Exception var12) {
                           }
                        }
                     }

                     world.levelEvent(
                        2001, BlockPos.containing(x, y, z), Block.getId(((Block)ButcheryModBlocks.DRAINED_OCELOT_CARCASS.get()).defaultBlockState())
                     );
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
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.axe.strip")),
                              SoundSource.NEUTRAL,
                              0.3F,
                              1.0F,
                              false
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
               );
            }
         } else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")
            && (
               world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()
                  || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()
            )
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip28
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip28)
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

            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var31 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/all_black_cat_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var31.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var31.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var32 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/black_cat_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var32.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var32.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var33 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/bshorthair_cat_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var33.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var33.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var34 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/calico_cat_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var34.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var34.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var35 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/jellie_cat_head_drop")))
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var36 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/persian_cat_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var36.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var36.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var37 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/ragdoll_cat_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var37.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var37.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var38 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/red_cat_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var38.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var38.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var39 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/siamese_cat_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var39.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var39.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()) {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var40 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/tabby_cat_head_drop")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var40.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var40.next();
                     if (world instanceof ServerLevel _levelxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()
               && !world.isClientSide()
               && world.getServer() != null) {
               ObjectListIterator var41 = world.getServer()
                  .reloadableRegistries()
                  .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:blocks/white_cat_head_drop")))
                  .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                  .iterator();

               while (var41.hasNext()) {
                  ItemStack itemstackiterator = (ItemStack)var41.next();
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

   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
   }

   private static Direction getDirectionFromBlockState(BlockState blockState) {
      if (blockState.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty ep && ep.getValueClass() == Direction.class) {
         return (Direction)blockState.getValue(ep);
      } else {
         return blockState.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty ep && ep.getValueClass() == Axis.class
            ? Direction.fromAxisAndDirection((Axis)blockState.getValue(ep), AxisDirection.POSITIVE)
            : Direction.NORTH;
      }
   }

   private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
      if (blockState.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty enumProperty
         && enumProperty.getPossibleValues().contains(newValue)) {
         return (BlockState)blockState.setValue(enumProperty, newValue);
      } else {
         return blockState.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty enumProperty
               && enumProperty.getPossibleValues().contains(newValue.getAxis())
            ? (BlockState)blockState.setValue(enumProperty, newValue.getAxis())
            : blockState;
      }
   }
}
