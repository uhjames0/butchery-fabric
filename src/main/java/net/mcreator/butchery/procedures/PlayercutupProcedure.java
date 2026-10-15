package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.services.ProfileResult;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.UUID;
import net.mcreator.butchery.block.entity.PlayercorpseBlockEntity;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: PlayercutupProcedure.class */
public class PlayercutupProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ItemStack mainHandItem;
        BlockPos pos;
        BlockEntity blockEntity;
        if (entity != null) {
            if (entity instanceof LivingEntity) {
                LivingEntity living = (LivingEntity) entity;
                mainHandItem = living.getMainHandItem();
            } else {
                mainHandItem = ItemStack.EMPTY;
            }
            ItemStack tool = mainHandItem;
            if ((tool.is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver"))) || tool.is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) && (blockEntity = world.getBlockEntity((pos = BlockPos.containing(x, y, z)))) != null && ((Boolean) ButcheryPersistentData.of(blockEntity).getBoolean("isDrained").orElse(false)).booleanValue()) {
                BlockState state = world.getBlockState(pos);
                if (state.getBlock() == ButcheryModBlocks.PLAYERCORPSE.get()) {
                    int corpseState = getCorpseState(state);
                    switch (corpseState) {
                        case 0:
                            performCut(world, pos, entity, tool, 11);
                            dropPlayerHead(world, pos, blockEntity);
                            break;
                        case 11:
                            performCut(world, pos, entity, tool, 12);
                            dropWithLooting(world, pos, entity, tool, "butchery:blocks/player_arm_drop", 1);
                            break;
                        case 12:
                            performCut(world, pos, entity, tool, 13);
                            dropWithLooting(world, pos, entity, tool, "butchery:blocks/player_arm_drop", 1);
                            break;
                        case 13:
                            performCut(world, pos, entity, tool, 14);
                            dropWithLooting(world, pos, entity, tool, "butchery:blocks/player_chest_skin_drop", 1);
                            break;
                        case 14:
                            performCut(world, pos, entity, tool, 15);
                            dropWithLooting(world, pos, entity, tool, "butchery:blocks/player_heart_drop", 1);
                            break;
                        case 15:
                            performCut(world, pos, entity, tool, 16);
                            dropWithLooting(world, pos, entity, tool, "butchery:blocks/player_stomach_drop", 1);
                            break;
                        case 16:
                            performCut(world, pos, entity, tool, 17);
                            dropWithLooting(world, pos, entity, tool, "butchery:blocks/player_liver_drop", 1);
                            break;
                        case 17:
                            performCut(world, pos, entity, tool, 19);
                            dropWithLooting(world, pos, entity, tool, "butchery:blocks/player_intestine_drop", 1);
                            break;
                        case 18:
                            performFinalCut(world, pos, entity, tool);
                            dropWithLooting(world, pos, entity, tool, "butchery:blocks/player_leg_drop", 2);
                            break;
                        case 19:
                            performCut(world, pos, entity, tool, 18);
                            dropWithLooting(world, pos, entity, tool, "butchery:blocks/player_body_drop", 1);
                            break;
                    }
                }
            }
        }
    }

    private static int getCorpseState(BlockState state) {
        Property<?> property = state.getBlock().getStateDefinition().getProperty("blockstate");
        if (!(property instanceof IntegerProperty)) {
            return -1;
        }
        Property<?> property2 = property;
        return ((Integer) state.getValue(property2)).intValue();
    }

    private static void performCut(LevelAccessor world, BlockPos pos, Entity entity, ItemStack tool, int newState) {
        damageTool(entity, tool);
        swing(entity);
        BlockState state = world.getBlockState(pos);
        Property<?> property = state.getBlock().getStateDefinition().getProperty("blockstate");
        if (property instanceof IntegerProperty) {
            IntegerProperty property2 = (IntegerProperty) property;
            if (property2.getPossibleValues().contains(Integer.valueOf(newState))) {
                world.setBlock(pos, (BlockState) state.setValue((Property) property2, (Comparable) Integer.valueOf(newState)), 3);
            }
        }
        cutEffects(world, pos);
    }

    private static void performFinalCut(LevelAccessor world, BlockPos pos, Entity entity, ItemStack tool) {
        damageTool(entity, tool);
        swing(entity);
        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        cutEffects(world, pos);
    }

    private static void damageTool(Entity entity, ItemStack tool) {
        if (entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entity;
            if (!tool.isEmpty()) {
                tool.hurtAndBreak(1, living, EquipmentSlot.MAINHAND);
            }
        }
    }

    private static void swing(Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entity;
            living.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
        }
    }

    private static void cutEffects(LevelAccessor world, BlockPos pos) {
        world.levelEvent(2001, pos, Block.getId(((Block) ButcheryModBlocks.PLAYERCORPSE.get()).defaultBlockState()));
        playSound(world, pos, "minecraft:item.axe.strip");
        playSound(world, pos, "minecraft:block.honey_block.step");
    }

    private static void playSound(LevelAccessor world, BlockPos pos, String soundId) {
        if (world instanceof Level) {
            Level level = (Level) world;
            SoundEvent sound = (SoundEvent) BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse(soundId));
            if (!level.isClientSide()) {
                level.playSound((Entity) null, pos, sound, SoundSource.NEUTRAL, 0.3f, 1.0f);
            } else {
                level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), sound, SoundSource.NEUTRAL, 0.3f, 1.0f, false);
            }
        }
    }

    private static void dropPlayerHead(LevelAccessor world, BlockPos pos, BlockEntity blockEntity) {
        if (world instanceof ServerLevel) {
            ServerLevel level = (ServerLevel) world;
            if (blockEntity instanceof PlayercorpseBlockEntity) {
                PlayercorpseBlockEntity corpse = (PlayercorpseBlockEntity) blockEntity;
                String playerUUID = corpse.getPlayerUUID();
                String playerName = corpse.getPlayerName();
                ItemStack playerHead = new ItemStack(Blocks.PLAYER_HEAD);
                UUID uuid = null;
                if (playerUUID != null && !playerUUID.isEmpty()) {
                    try {
                        uuid = UUID.fromString(playerUUID);
                    } catch (IllegalArgumentException e) {
                    }
                }
                if (uuid != null || (playerName != null && !playerName.isEmpty())) {
                    GameProfile profile = new GameProfile(uuid, (playerName == null || playerName.isEmpty()) ? null : playerName);
                    if (uuid != null) {
                        try {
                            ProfileResult profileResult = level.getServer().services().sessionService().fetchProfile(uuid, false);
                            if (profileResult != null && profileResult.profile() != null) {
                                profile = profileResult.profile();
                            }
                        } catch (Exception e2) {
                        }
                    }
                    playerHead.set(DataComponents.PROFILE, ResolvableProfile.createResolved(profile));
                }
                if (playerName != null && !playerName.isEmpty()) {
                    playerHead.set(DataComponents.CUSTOM_NAME, Component.literal(playerName + " Head"));
                }
                spawnItem(level, pos, playerHead);
            }
        }
    }

    private static void dropWithLooting(LevelAccessor world, BlockPos pos, Entity entity, ItemStack tool, String lootTableId, int baseDrops) {
        int lootingLevel;
        if (world instanceof ServerLevel) {
            ServerLevel level = (ServerLevel) world;
            for (int lootingLevel2 = 0; lootingLevel2 < baseDrops; lootingLevel2++) {
                dropLootTable(level, pos, lootTableId);
            }
            if (((Boolean) ButcheryconfigConfiguration.LOOTING_ENCHANT.get()).booleanValue() && (lootingLevel = getLootingLevel(level, tool)) > 0) {
                int extraIterations = (int) Mth.nextDouble(RandomSource.create(), 0.0d, lootingLevel);
                for (int i = 0; i < extraIterations; i++) {
                    for (int j = 0; j < baseDrops; j++) {
                        dropLootTable(level, pos, lootTableId);
                    }
                }
            }
        }
    }

    private static int getLootingLevel(ServerLevel level, ItemStack tool) {
        return EnchantmentHelper.getItemEnchantmentLevel(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING), tool);
    }

    private static void dropLootTable(ServerLevel level, BlockPos pos, String lootTableId) {
        ResourceKey<LootTable> key = ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse(lootTableId));
        LootTable lootTable = level.getServer().reloadableRegistries().getLootTable(key);
        ObjectListIterator var5 = lootTable.getRandomItems(new LootParams.Builder(level).create(LootContextParamSets.EMPTY)).iterator();
        while (var5.hasNext()) {
            ItemStack stack = (ItemStack) var5.next();
            spawnItem(level, pos, stack);
        }
    }

    private static void spawnItem(ServerLevel level, BlockPos pos, ItemStack stack) {
        ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack);
        itemEntity.setPickUpDelay(10);
        level.addFreshEntity(itemEntity);
    }
}
