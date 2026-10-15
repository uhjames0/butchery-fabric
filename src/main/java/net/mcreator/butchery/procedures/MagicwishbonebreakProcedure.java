package net.mcreator.butchery.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Comparator;
import java.util.Locale;
import java.util.function.Function;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.itemcap.ItemHandlerHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.storage.loot.LootParams.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MagicwishbonebreakProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack enchantedItem = ItemStack.EMPTY;
         ItemStack enchantmedItem2 = ItemStack.EMPTY;
         ItemStack enchantedItem3 = ItemStack.EMPTY;
         ItemStack enchantedItem4 = ItemStack.EMPTY;
         ItemStack armorPiece = ItemStack.EMPTY;
         boolean found = false;
         double LocalRandom = 0.0;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         if ((Boolean)ButcheryconfigConfiguration.MAGIC_WISHBONE.get() && !world.isClientSide()) {
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
               if (entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.MAGIC_WISHBONE.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }

               if (entity instanceof Player _player) {
                  ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.BROKEN_WISHBONE.get()).copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:wishbone_break")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:wishbone_break")),
                     SoundSource.NEUTRAL,
                     1.0F,
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
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.illusioner.cast_spell")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.5F
                  );
               } else {
                  _levelx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.illusioner.cast_spell")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.5F,
                     false
                  );
               }
            }

            if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.chime")),
                     SoundSource.NEUTRAL,
                     0.25F,
                     0.25F
                  );
               } else {
                  _levelxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.chime")),
                     SoundSource.NEUTRAL,
                     0.25F,
                     0.25F,
                     false
                  );
               }
            }

            LocalRandom = Mth.nextInt(RandomSource.create(), 1, 23);
            if (LocalRandom == 1.0) {
               for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 5.0, 16.0); index0++) {
                  if (world instanceof ServerLevel _levelxxx) {
                     Entity entityToSpawn = ((EntityType)BuiltInRegistries.ENTITY_TYPE.getValue(Identifier.parse("minecraft:ZOMBIE".toLowerCase(Locale.ROOT))))
                        .spawn(_levelxxx, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                     }
                  }
               }

               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.sendSystemMessage(Component.literal("§4RUUUN!"));
               }
            } else if (LocalRandom != 2.0 && LocalRandom != 3.0 && LocalRandom != 4.0) {
               if (LocalRandom == 5.0) {
                  for (int index1 = 0; index1 < 20; index1++) {
                     if (world instanceof ServerLevel _levelxxxx) {
                        Entity entityToSpawn = ((EntityType)BuiltInRegistries.ENTITY_TYPE.getValue(Identifier.parse("minecraft:TNT".toLowerCase(Locale.ROOT))))
                           .spawn(_levelxxxx, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(
                              Mth.nextDouble(RandomSource.create(), -0.7, 0.7),
                              Mth.nextDouble(RandomSource.create(), 0.0, 0.7),
                              Mth.nextDouble(RandomSource.create(), -0.7, 0.7)
                           );
                        }
                     }
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§4RUUUN!"));
                  }
               } else if (LocalRandom == 6.0) {
                  for (int index2 = 0; index2 < (int)Mth.nextDouble(RandomSource.create(), 5.0, 16.0); index2++) {
                     if (world instanceof ServerLevel _levelxxxxx) {
                        Entity entityToSpawn = ((EntityType)BuiltInRegistries.ENTITY_TYPE
                              .getValue(Identifier.parse("minecraft:SILVERFISH".toLowerCase(Locale.ROOT))))
                           .spawn(_levelxxxxx, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§4RUUUN!"));
                  }
               } else if (LocalRandom == 7.0) {
                  for (int index3 = 0; index3 < (int)Mth.nextDouble(RandomSource.create(), 5.0, 16.0); index3++) {
                     if (world instanceof ServerLevel _levelxxxxxx) {
                        Entity entityToSpawn = ((EntityType)BuiltInRegistries.ENTITY_TYPE
                              .getValue(Identifier.parse("minecraft:SKELETON".toLowerCase(Locale.ROOT))))
                           .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§4RUUUN!"));
                  }
               } else if (LocalRandom == 8.0) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 2400, 2, false, false));
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§2You don't look too good.."));
                  }
               } else if (LocalRandom == 9.0) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 9600, 2, false, false));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.HASTE, 9600, 2, false, false));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 9600, 2, false, false));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 9600, 2, false, false));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 9600, 2, false, false));
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§bYou have been blessed."));
                  }
               } else if (LocalRandom == 10.0) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 2400, 2, false, false));
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§2Hungry?"));
                  }
               } else if (LocalRandom == 11.0) {
                  entity.igniteForSeconds(5.0F);
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§4Spontaneous combustion!"));
                  }
               } else if (LocalRandom == 12.0) {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§7Oof. It was a dud!"));
                  }
               } else if (LocalRandom == 13.0) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 900, 2, false, false));
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§bTo the moooon!"));
                  }
               } else if (LocalRandom == 14.0) {
                  if (entity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack((ItemLike)ButcheryModItems.MAGIC_WISHBONE.get()).copy();
                     _setstack.setCount(2);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§6Duplication?!"));
                  }
               } else if (LocalRandom == 15.0) {
                  enchantedItem = new ItemStack(Items.DIAMOND_HELMET).copy();
                  enchantedItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), 4);
                  enchantedItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION), 3);
                  enchantedItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 3);
                  enchantedItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY), 3);
                  if (world instanceof ServerLevel _levelxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxx, x, y, z, enchantedItem);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxx.addFreshEntity(entityToSpawn);
                  }

                  enchantmedItem2 = new ItemStack(Items.DIAMOND_CHESTPLATE).copy();
                  enchantmedItem2.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), 4);
                  enchantmedItem2.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 3);
                  enchantmedItem2.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS), 3);
                  if (world instanceof ServerLevel _levelxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxx, x, y, z, enchantmedItem2);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxx.addFreshEntity(entityToSpawn);
                  }

                  enchantedItem3 = new ItemStack(Items.DIAMOND_LEGGINGS).copy();
                  enchantedItem3.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), 4);
                  enchantedItem3.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 3);
                  if (world instanceof ServerLevel _levelxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxx, x, y, z, enchantedItem3);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxx.addFreshEntity(entityToSpawn);
                  }

                  enchantedItem4 = new ItemStack(Items.DIAMOND_BOOTS).copy();
                  enchantedItem4.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), 4);
                  enchantedItem4.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING), 4);
                  enchantedItem4.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER), 3);
                  enchantedItem4.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 3);
                  enchantedItem4.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED), 3);
                  if (world instanceof ServerLevel _levelxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxx, x, y, z, enchantedItem4);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxx.addFreshEntity(entityToSpawn);
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§bArmor of the gods!"));
                  }
               } else if (LocalRandom == 16.0) {
                  armorPiece = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy();
                  if (entity instanceof Player _player) {
                     ItemStack _setstack = armorPiece.copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  enchantedItem = new ItemStack(Items.ELYTRA).copy();
                  enchantedItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
                  if (world instanceof ServerLevel _levelxxxxxxx) {
                     enchantedItem.hurtAndBreak(431, _levelxxxxxxx, null, _stkprov -> {});
                  }

                  if (entity instanceof LivingEntity _living) {
                     _living.setItemSlot(EquipmentSlot.CHEST, enchantedItem);
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§0You will never fly again. Muhahaha!"));
                  }

                  ButcheryMod.queueServerWork(400, () -> {
                     if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                        _playerx.sendSystemMessage(Component.literal("§0Just kidding"));
                     }

                     if (entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
                     }
                  });
               } else if (LocalRandom == 17.0) {
                  if (world instanceof ServerLevel _serverworld) {
                     StructureTemplate template = _serverworld.getStructureTemplateManager()
                        .getOrCreate(Identifier.fromNamespaceAndPath("butchery", "wishbone_structure_trap_1"));
                     if (template != null) {
                        template.placeInWorld(
                           _serverworld,
                           BlockPos.containing(x - 1.0, y, z - 1.0),
                           BlockPos.containing(x - 1.0, y, z - 1.0),
                           new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                           _serverworld.getRandom(),
                           3
                        );
                     }
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§9Hope you can swim!"));
                  }
               } else if (LocalRandom == 18.0) {
                  if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
                     if (world instanceof ServerLevel _serverworldx) {
                        StructureTemplate template = _serverworldx.getStructureTemplateManager()
                           .getOrCreate(Identifier.fromNamespaceAndPath("butchery", "wishbone_structure_trap_2"));
                        if (template != null) {
                           template.placeInWorld(
                              _serverworldx,
                              BlockPos.containing(x - 2.0, y + 12.0, z - 2.0),
                              BlockPos.containing(x - 2.0, y + 12.0, z - 2.0),
                              new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                              _serverworldx.getRandom(),
                              3
                           );
                        }
                     }

                     if (entity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.sendSystemMessage(Component.literal("§cLook up! RUN!"));
                     }
                  }
               } else if (LocalRandom == 19.0) {
                  if (world instanceof ServerLevel _serverworldxx) {
                     StructureTemplate template = _serverworldxx.getStructureTemplateManager()
                        .getOrCreate(Identifier.fromNamespaceAndPath("butchery", "wishbone_structure_trap_3"));
                     if (template != null) {
                        template.placeInWorld(
                           _serverworldxx,
                           BlockPos.containing(x - 1.0, y, z - 1.0),
                           BlockPos.containing(x - 1.0, y, z - 1.0),
                           new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
                           _serverworldxx.getRandom(),
                           3
                        );
                     }
                  }

                  for (int index4 = 0; index4 < Mth.nextInt(RandomSource.create(), 8, 16); index4++) {
                     if (world instanceof ServerLevel _levelxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)BuiltInRegistries.ENTITY_TYPE
                              .getValue(Identifier.parse("minecraft:CAVE_SPIDER".toLowerCase(Locale.ROOT))))
                           .spawn(_levelxxxxxxx, BlockPos.containing(x, y + 5.0, z), EntitySpawnReason.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§fWho's the fly now!"));
                  }
               } else if (LocalRandom == 20.0) {
                  new MagicwishbonebreakProcedure.RedwiresTimedLoop(
                        (int)Mth.nextDouble(RandomSource.create(), 2.0, 6.0),
                        5,
                        _timedLoop -> {
                           if (world instanceof ServerLevel _levelxxxxxxxxx) {
                              Entity entityToSpawnx = ((EntityType)BuiltInRegistries.ENTITY_TYPE
                                    .getValue(Identifier.parse("minecraft:CREEPER".toLowerCase(Locale.ROOT))))
                                 .spawn(
                                    _levelxxxxxxxxx,
                                    BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, 4), y, z + Mth.nextInt(RandomSource.create(), 1, 4)),
                                    EntitySpawnReason.MOB_SUMMONED
                                 );
                              if (entityToSpawnx != null) {
                                 entityToSpawnx.setYRot(world.getRandom().nextFloat() * 360.0F);
                              }
                           }

                           ButcheryMod.queueServerWork(
                              1,
                              () -> {
                                 Vec3 _center = new Vec3(x, y, z);

                                 for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32.0), e -> true)
                                    .stream()
                                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                    .toList()) {
                                    if (entityiterator instanceof Creeper) {
                                       if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                          LightningBolt entityToSpawnxx = (LightningBolt)((EntityType)BuiltInRegistries.ENTITY_TYPE
                                                .getValue(Identifier.parse("minecraft:LIGHTNING_BOLT".toLowerCase(Locale.ROOT))))
                                             .create(_levelxxxxxxxxxx, EntitySpawnReason.TRIGGERED);
                                          entityToSpawnxx.snapTo(
                                             Vec3.atBottomCenterOf(
                                                BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 2.0, entityiterator.getZ())
                                             )
                                          );
                                          _levelxxxxxxxxxx.addFreshEntity(entityToSpawnxx);
                                       }

                                       if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                          _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 240, 1, false, false));
                                       }
                                    }
                                 }
                              }
                           );
                           return true;
                        }
                     )
                     .run();
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§bSUPERCHARGED §aCREEPERS"));
                  }
               } else if (LocalRandom == 21.0) {
                  for (int index5 = 0; index5 < 64; index5++) {
                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        _levelxxxxxxxx.addFreshEntity(
                           new ExperienceOrb(
                              _levelxxxxxxxx,
                              x + Mth.nextInt(RandomSource.create(), 1, 6),
                              y + Mth.nextInt(RandomSource.create(), 1, 8),
                              z + Mth.nextInt(RandomSource.create(), 1, 6),
                              Mth.nextInt(RandomSource.create(), 1, 149)
                           )
                        );
                     }

                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        _levelxxxxxxxx.addFreshEntity(
                           new ExperienceOrb(
                              _levelxxxxxxxx,
                              x - Mth.nextInt(RandomSource.create(), 1, 6),
                              y + Mth.nextInt(RandomSource.create(), 1, 8),
                              z - Mth.nextInt(RandomSource.create(), 1, 6),
                              Mth.nextInt(RandomSource.create(), 1, 149)
                           )
                        );
                     }

                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        _levelxxxxxxxx.addFreshEntity(
                           new ExperienceOrb(
                              _levelxxxxxxxx,
                              x + Mth.nextInt(RandomSource.create(), 1, 6),
                              y + Mth.nextInt(RandomSource.create(), 1, 8),
                              z - Mth.nextInt(RandomSource.create(), 1, 6),
                              Mth.nextInt(RandomSource.create(), 1, 149)
                           )
                        );
                     }

                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        _levelxxxxxxxx.addFreshEntity(
                           new ExperienceOrb(
                              _levelxxxxxxxx,
                              x - Mth.nextInt(RandomSource.create(), 1, 6),
                              y + Mth.nextInt(RandomSource.create(), 1, 8),
                              z + Mth.nextInt(RandomSource.create(), 1, 6),
                              Mth.nextInt(RandomSource.create(), 1, 149)
                           )
                        );
                     }
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§aLEVEL UP!"));
                  }
               } else if (LocalRandom == 22.0) {
                  enchantedItem = new ItemStack(Items.DIAMOND_PICKAXE).copy();
                  enchantedItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 8);
                  enchantedItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 3);
                  enchantedItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 8);
                  enchantedItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), 1);
                  if (world instanceof ServerLevel _levelxxxxxxxx) {
                     ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, enchantedItem);
                     entityToSpawn.setPickUpDelay(10);
                     _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§bPickaxe of the gods!"));
                  }
               } else if (LocalRandom == 23.0) {
                  for (int index6 = 0; index6 < Mth.nextInt(RandomSource.create(), 1, 4); index6++) {
                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(
                           _levelxxxxxxxx,
                           x + Mth.nextInt(RandomSource.create(), 1, 4),
                           y + Mth.nextInt(RandomSource.create(), 1, 6),
                           z + Mth.nextInt(RandomSource.create(), 1, 4),
                           new ItemStack(Items.SHEEP_SPAWN_EGG)
                        );
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }

                  for (int index7 = 0; index7 < Mth.nextInt(RandomSource.create(), 1, 4); index7++) {
                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(
                           _levelxxxxxxxx,
                           x - Mth.nextInt(RandomSource.create(), 1, 4),
                           y + Mth.nextInt(RandomSource.create(), 1, 6),
                           z - Mth.nextInt(RandomSource.create(), 1, 4),
                           new ItemStack(Items.CHICKEN_SPAWN_EGG)
                        );
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }

                  for (int index8 = 0; index8 < Mth.nextInt(RandomSource.create(), 1, 4); index8++) {
                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(
                           _levelxxxxxxxx,
                           x - Mth.nextInt(RandomSource.create(), 1, 4),
                           y + Mth.nextInt(RandomSource.create(), 1, 6),
                           z + Mth.nextInt(RandomSource.create(), 1, 4),
                           new ItemStack(Items.COW_SPAWN_EGG)
                        );
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }

                  for (int index9 = 0; index9 < Mth.nextInt(RandomSource.create(), 1, 4); index9++) {
                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(
                           _levelxxxxxxxx,
                           x + Mth.nextInt(RandomSource.create(), 1, 4),
                           y + Mth.nextInt(RandomSource.create(), 1, 6),
                           z - Mth.nextInt(RandomSource.create(), 1, 4),
                           new ItemStack(Items.PIG_SPAWN_EGG)
                        );
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.sendSystemMessage(Component.literal("§6Now you can start a farm!"));
                  }
               }
            } else {
               if (!world.isClientSide() && world.getServer() != null) {
                  ObjectListIterator var39 = world.getServer()
                     .reloadableRegistries()
                     .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("butchery:entities/magic_wishbone_loot")))
                     .getRandomItems(new Builder((ServerLevel)world).create(LootContextParamSets.EMPTY))
                     .iterator();

                  while (var39.hasNext()) {
                     ItemStack itemstackiterator = (ItemStack)var39.next();
                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        ItemEntity entityToSpawn = new ItemEntity(_levelxxxxxxxx, x, y, z, itemstackiterator);
                        entityToSpawn.setPickUpDelay(10);
                        _levelxxxxxxxx.addFreshEntity(entityToSpawn);
                     }
                  }
               }

               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.sendSystemMessage(Component.literal("§dHere's a gift."));
               }
            }
         }
      }
   }

   private static class RedwiresTimedLoop {
      private int iterator = 0;
      private int ticks = 0;
      private final int total;
      private final Function<MagicwishbonebreakProcedure.RedwiresTimedLoop, Boolean> forEach;

      private RedwiresTimedLoop(int total, int ticks, Function<MagicwishbonebreakProcedure.RedwiresTimedLoop, Boolean> forEach) {
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
