package net.mcreator.butchery.init;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.entity.animal.chicken.ChickenVariants;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.animal.cow.CowVariants;
import net.minecraft.world.entity.animal.pig.PigVariants;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/*
 * Central dispatch for vanilla biome variants (cold/warm/temperate) of pigs, cows
 * and chickens introduced in Minecraft 26.3. Used by the shared drop, cutup,
 * bleeding, broken and tick procedures so that variant carcasses keep the
 * correct appearance and produce variant skins and heads.
 */
public class ButcheryVariants {
    private ButcheryVariants() {}

    private static Block blockAt(LevelAccessor world, double x, double y, double z) {
        return world.getBlockState(BlockPos.containing(x, y, z)).getBlock();
    }

    // ---------- entity based (death drop procedures) ----------
    public static String pigCarcassLoot(Entity entity) {
        if (entity instanceof Pig pig && pig.getVariant().is(PigVariants.COLD)) {
            return "cold_pig_carcass_loot";
        }
        if (entity instanceof Pig pig && pig.getVariant().is(PigVariants.WARM)) {
            return "warm_pig_carcass_loot";
        }
        return "pig_carcass_loot";
    }

    public static String cowCarcassLoot(Entity entity) {
        if (entity instanceof Cow cow && cow.getVariant().is(CowVariants.COLD)) {
            return "cold_cow_carcass_loot";
        }
        if (entity instanceof Cow cow && cow.getVariant().is(CowVariants.WARM)) {
            return "warm_cow_carcass_loot";
        }
        return "cow_carcass_loot";
    }

    public static String chickenCarcassLoot(Entity entity) {
        if (entity instanceof Chicken chicken && chicken.getVariant().is(ChickenVariants.COLD)) {
            return "cold_chicken_carcass_loot";
        }
        if (entity instanceof Chicken chicken && chicken.getVariant().is(ChickenVariants.WARM)) {
            return "warm_chicken_carcass_loot";
        }
        return "chicken_carcass_loot";
    }

    // ---------- block based (cutup procedures) ----------
    public static String pigSkinDrop(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.COLD_PIG_CARCASS.get() || b == ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get()) {
            return "cold_pig_skin_drop";
        }
        if (b == ButcheryModBlocks.WARM_PIG_CARCASS.get() || b == ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get()) {
            return "warm_pig_skin_drop";
        }
        return "pig_skin_drop";
    }

    public static String cowSkinDrop(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.COLD_COW_CARCASS.get() || b == ButcheryModBlocks.DRAINED_COLD_COW_CARCASS.get()) {
            return "cold_cow_skin_drop";
        }
        if (b == ButcheryModBlocks.WARM_COW_CARCASS.get() || b == ButcheryModBlocks.DRAINED_WARM_COW_CARCASS.get()) {
            return "warm_cow_skin_drop";
        }
        return "cow_skin_drop";
    }

    public static String pigHeadDrop(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.COLD_PIG_CARCASS.get() || b == ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get()) {
            return "cold_pig_head_drop";
        }
        if (b == ButcheryModBlocks.WARM_PIG_CARCASS.get() || b == ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get()) {
            return "warm_pig_head_drop";
        }
        return "pig_head_drop";
    }

    public static String cowHeadDrop(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.COLD_COW_CARCASS.get() || b == ButcheryModBlocks.DRAINED_COLD_COW_CARCASS.get()) {
            return "cold_cow_head_drop";
        }
        if (b == ButcheryModBlocks.WARM_COW_CARCASS.get() || b == ButcheryModBlocks.DRAINED_WARM_COW_CARCASS.get()) {
            return "warm_cow_head_drop";
        }
        return "cow_head_drop";
    }

    public static String chickenHeadDrop(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.COLD_CHICKEN_CARCASS.get() || b == ButcheryModBlocks.DRAINED_COLD_CHICKEN_CARCASS.get()) {
            return "cold_chicken_head_drop";
        }
        if (b == ButcheryModBlocks.WARM_CHICKEN_CARCASS.get() || b == ButcheryModBlocks.DRAINED_WARM_CHICKEN_CARCASS.get()) {
            return "warm_chicken_head_drop";
        }
        return "chicken_head_drop";
    }

    // ---------- block membership checks ----------
    public static boolean isPigCarcass(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        return b == ButcheryModBlocks.PIG_CARCASS.get()
            || b == ButcheryModBlocks.COLD_PIG_CARCASS.get()
            || b == ButcheryModBlocks.WARM_PIG_CARCASS.get();
    }

    public static boolean isDrainedPigCarcass(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        return b == ButcheryModBlocks.DRAINED_PIG_CARCASS.get()
            || b == ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get()
            || b == ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get();
    }

    public static boolean isCowCarcass(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        return b == ButcheryModBlocks.COW_CARCASS.get()
            || b == ButcheryModBlocks.COLD_COW_CARCASS.get()
            || b == ButcheryModBlocks.WARM_COW_CARCASS.get();
    }

    public static boolean isDrainedCowCarcass(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        return b == ButcheryModBlocks.DRAINED_COW_CARCASS.get()
            || b == ButcheryModBlocks.DRAINED_COLD_COW_CARCASS.get()
            || b == ButcheryModBlocks.DRAINED_WARM_COW_CARCASS.get();
    }

    public static boolean isChickenCarcass(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        return b == ButcheryModBlocks.CHICKEN_CARCASS.get()
            || b == ButcheryModBlocks.COLD_CHICKEN_CARCASS.get()
            || b == ButcheryModBlocks.WARM_CHICKEN_CARCASS.get();
    }

    public static boolean isDrainedChickenCarcass(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        return b == ButcheryModBlocks.DRAINED_CHICKEN_CARCASS.get()
            || b == ButcheryModBlocks.DRAINED_COLD_CHICKEN_CARCASS.get()
            || b == ButcheryModBlocks.DRAINED_WARM_CHICKEN_CARCASS.get();
    }

    // ---------- bleeding / tick transitions ----------
    public static Block drainedPigCarcassFor(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.COLD_PIG_CARCASS.get()) {
            return (Block)ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get();
        }
        if (b == ButcheryModBlocks.WARM_PIG_CARCASS.get()) {
            return (Block)ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get();
        }
        return (Block)ButcheryModBlocks.DRAINED_PIG_CARCASS.get();
    }

    public static Block drainedCowCarcassFor(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.COLD_COW_CARCASS.get()) {
            return (Block)ButcheryModBlocks.DRAINED_COLD_COW_CARCASS.get();
        }
        if (b == ButcheryModBlocks.WARM_COW_CARCASS.get()) {
            return (Block)ButcheryModBlocks.DRAINED_WARM_COW_CARCASS.get();
        }
        return (Block)ButcheryModBlocks.DRAINED_COW_CARCASS.get();
    }

    public static Block drainedChickenCarcassFor(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.COLD_CHICKEN_CARCASS.get()) {
            return (Block)ButcheryModBlocks.DRAINED_COLD_CHICKEN_CARCASS.get();
        }
        if (b == ButcheryModBlocks.WARM_CHICKEN_CARCASS.get()) {
            return (Block)ButcheryModBlocks.DRAINED_WARM_CHICKEN_CARCASS.get();
        }
        return (Block)ButcheryModBlocks.DRAINED_CHICKEN_CARCASS.get();
    }

    // ---------- spit roast ----------
    public static String heldPigCarcassVariant(Entity entity) {
        ItemStack held = entity instanceof LivingEntity le ? le.getMainHandItem() : ItemStack.EMPTY;
        if (held.getItem() == ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get().asItem()) {
            return "cold";
        }
        if (held.getItem() == ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get().asItem()) {
            return "warm";
        }
        return "";
    }

    public static Item spitRoastCarcassItem(LevelAccessor world, BlockPos pos) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be != null) {
            String variant = net.mcreator.butchery.shim.ButcheryPersistentData.of(be).getString("carcassVariant").orElse("");
            if ("cold".equals(variant)) {
                return (Item)ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get().asItem();
            }
            if ("warm".equals(variant)) {
                return (Item)ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get().asItem();
            }
        }
        return (Item)ButcheryModBlocks.DRAINED_PIG_CARCASS.get().asItem();
    }

    // ---------- broken procedures: item to drop for the broken blockstate ----------
    public static Item pigCarcassItem(BlockState state) {
        Block b = state.getBlock();
        if (b == ButcheryModBlocks.COLD_PIG_CARCASS.get()) {
            return (Item)ButcheryModBlocks.COLD_PIG_CARCASS.get().asItem();
        }
        if (b == ButcheryModBlocks.WARM_PIG_CARCASS.get()) {
            return (Item)ButcheryModBlocks.WARM_PIG_CARCASS.get().asItem();
        }
        return (Item)ButcheryModBlocks.PIG_CARCASS.get().asItem();
    }

    public static Item drainedPigCarcassItem(BlockState state) {
        Block b = state.getBlock();
        if (b == ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get()) {
            return (Item)ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get().asItem();
        }
        if (b == ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get()) {
            return (Item)ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get().asItem();
        }
        return (Item)ButcheryModBlocks.DRAINED_PIG_CARCASS.get().asItem();
    }

    public static Item cowCarcassItem(BlockState state) {
        Block b = state.getBlock();
        if (b == ButcheryModBlocks.COLD_COW_CARCASS.get()) {
            return (Item)ButcheryModBlocks.COLD_COW_CARCASS.get().asItem();
        }
        if (b == ButcheryModBlocks.WARM_COW_CARCASS.get()) {
            return (Item)ButcheryModBlocks.WARM_COW_CARCASS.get().asItem();
        }
        return (Item)ButcheryModBlocks.COW_CARCASS.get().asItem();
    }

    public static Item drainedCowCarcassItem(BlockState state) {
        Block b = state.getBlock();
        if (b == ButcheryModBlocks.DRAINED_COLD_COW_CARCASS.get()) {
            return (Item)ButcheryModBlocks.DRAINED_COLD_COW_CARCASS.get().asItem();
        }
        if (b == ButcheryModBlocks.DRAINED_WARM_COW_CARCASS.get()) {
            return (Item)ButcheryModBlocks.DRAINED_WARM_COW_CARCASS.get().asItem();
        }
        return (Item)ButcheryModBlocks.DRAINED_COW_CARCASS.get().asItem();
    }

    public static Item chickenCarcassItem(BlockState state) {
        Block b = state.getBlock();
        if (b == ButcheryModBlocks.COLD_CHICKEN_CARCASS.get()) {
            return (Item)ButcheryModBlocks.COLD_CHICKEN_CARCASS.get().asItem();
        }
        if (b == ButcheryModBlocks.WARM_CHICKEN_CARCASS.get()) {
            return (Item)ButcheryModBlocks.WARM_CHICKEN_CARCASS.get().asItem();
        }
        return (Item)ButcheryModBlocks.CHICKEN_CARCASS.get().asItem();
    }

    public static Item drainedChickenCarcassItem(BlockState state) {
        Block b = state.getBlock();
        if (b == ButcheryModBlocks.DRAINED_COLD_CHICKEN_CARCASS.get()) {
            return (Item)ButcheryModBlocks.DRAINED_COLD_CHICKEN_CARCASS.get().asItem();
        }
        if (b == ButcheryModBlocks.DRAINED_WARM_CHICKEN_CARCASS.get()) {
            return (Item)ButcheryModBlocks.DRAINED_WARM_CHICKEN_CARCASS.get().asItem();
        }
        return (Item)ButcheryModBlocks.DRAINED_CHICKEN_CARCASS.get().asItem();
    }

    // ---------- sheep dye colors (16) ----------
    private static final String[] SHEEP_COLORS = {
        "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray",
        "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"
    };
    private static Block[] sheepCarcassBlocks() {
        return new Block[]{
            ButcheryModBlocks.ORANGE_SHEEP_CARCASS.get(), ButcheryModBlocks.MAGENTA_SHEEP_CARCASS.get(),
            ButcheryModBlocks.LIGHT_BLUE_SHEEP_CARCASS.get(), ButcheryModBlocks.YELLOW_SHEEP_CARCASS.get(),
            ButcheryModBlocks.LIME_SHEEP_CARCASS.get(), ButcheryModBlocks.PINK_SHEEP_CARCASS.get(),
            ButcheryModBlocks.GRAY_SHEEP_CARCASS.get(), ButcheryModBlocks.LIGHT_GRAY_SHEEP_CARCASS.get(),
            ButcheryModBlocks.CYAN_SHEEP_CARCASS.get(), ButcheryModBlocks.PURPLE_SHEEP_CARCASS.get(),
            ButcheryModBlocks.BLUE_SHEEP_CARCASS.get(), ButcheryModBlocks.BROWN_SHEEP_CARCASS.get(),
            ButcheryModBlocks.GREEN_SHEEP_CARCASS.get(), ButcheryModBlocks.RED_SHEEP_CARCASS.get(),
            ButcheryModBlocks.BLACK_SHEEP_CARCASS.get()
        };
    }
    private static Block[] drainedSheepCarcassBlocks() {
        return new Block[]{
            ButcheryModBlocks.DRAINED_ORANGE_SHEEP_CARCASS.get(), ButcheryModBlocks.DRAINED_MAGENTA_SHEEP_CARCASS.get(),
            ButcheryModBlocks.DRAINED_LIGHT_BLUE_SHEEP_CARCASS.get(), ButcheryModBlocks.DRAINED_YELLOW_SHEEP_CARCASS.get(),
            ButcheryModBlocks.DRAINED_LIME_SHEEP_CARCASS.get(), ButcheryModBlocks.DRAINED_PINK_SHEEP_CARCASS.get(),
            ButcheryModBlocks.DRAINED_GRAY_SHEEP_CARCASS.get(), ButcheryModBlocks.DRAINED_LIGHT_GRAY_SHEEP_CARCASS.get(),
            ButcheryModBlocks.DRAINED_CYAN_SHEEP_CARCASS.get(), ButcheryModBlocks.DRAINED_PURPLE_SHEEP_CARCASS.get(),
            ButcheryModBlocks.DRAINED_BLUE_SHEEP_CARCASS.get(), ButcheryModBlocks.DRAINED_BROWN_SHEEP_CARCASS.get(),
            ButcheryModBlocks.DRAINED_GREEN_SHEEP_CARCASS.get(), ButcheryModBlocks.DRAINED_RED_SHEEP_CARCASS.get(),
            ButcheryModBlocks.DRAINED_BLACK_SHEEP_CARCASS.get()
        };
    }
    private static Item[] sheepSkinItems() {
        return new Item[]{
            ButcheryModItems.ORANGE_SHEEP_SKIN.get(), ButcheryModItems.MAGENTA_SHEEP_SKIN.get(),
            ButcheryModItems.LIGHT_BLUE_SHEEP_SKIN.get(), ButcheryModItems.YELLOW_SHEEP_SKIN.get(),
            ButcheryModItems.LIME_SHEEP_SKIN.get(), ButcheryModItems.PINK_SHEEP_SKIN.get(),
            ButcheryModItems.GRAY_SHEEP_SKIN.get(), ButcheryModItems.LIGHT_GRAY_SHEEP_SKIN.get(),
            ButcheryModItems.CYAN_SHEEP_SKIN.get(), ButcheryModItems.PURPLE_SHEEP_SKIN.get(),
            ButcheryModItems.BLUE_SHEEP_SKIN.get(), ButcheryModItems.BROWN_SHEEP_SKIN.get(),
            ButcheryModItems.GREEN_SHEEP_SKIN.get(), ButcheryModItems.RED_SHEEP_SKIN.get(),
            ButcheryModItems.BLACK_SHEEP_SKIN.get()
        };
    }
    private static int sheepColorIndex(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        Block[] carcasses = sheepCarcassBlocks();
        for (int i = 0; i < carcasses.length; i++) {
            if (b == carcasses[i]) return i;
        }
        return -1;
    }

    public static String sheepCarcassLoot(Entity entity) {
        if (entity instanceof net.minecraft.world.entity.animal.sheep.Sheep sheep
            && sheep.getColor() != net.minecraft.world.item.DyeColor.WHITE) {
            return sheep.getColor().getName() + "_sheep_carcass_loot";
        }
        return "sheep_carcass_loot";
    }

    public static String sheepSkinDrop(LevelAccessor world, double x, double y, double z) {
        int i = sheepColorIndex(world, x, y, z);
        if (i >= 0) return SHEEP_COLORS[i] + "_sheep_skin_drop";
        Block b = blockAt(world, x, y, z);
        Block[] drained = drainedSheepCarcassBlocks();
        for (int j = 0; j < drained.length; j++) {
            if (b == drained[j]) return SHEEP_COLORS[j] + "_sheep_skin_drop";
        }
        return "sheep_skin_drop";
    }

    public static String sheepHeadDrop(LevelAccessor world, double x, double y, double z) {
        String skin = sheepSkinDrop(world, x, y, z);
        return skin.equals("sheep_skin_drop") ? "sheep_head_drop" : skin.replace("_skin_drop", "_head_drop");
    }

    public static boolean isSheepCarcass(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.SHEEP_CARCASS.get()) return true;
        for (Block c : sheepCarcassBlocks()) {
            if (b == c) return true;
        }
        return false;
    }

    public static boolean isDrainedSheepCarcass(LevelAccessor world, double x, double y, double z) {
        Block b = blockAt(world, x, y, z);
        if (b == ButcheryModBlocks.DRAINED_SHEEP_CARCASS.get()) return true;
        for (Block c : drainedSheepCarcassBlocks()) {
            if (b == c) return true;
        }
        return false;
    }

    public static Block drainedSheepCarcassFor(LevelAccessor world, double x, double y, double z) {
        int i = sheepColorIndex(world, x, y, z);
        if (i >= 0) return drainedSheepCarcassBlocks()[i];
        return (Block)ButcheryModBlocks.DRAINED_SHEEP_CARCASS.get();
    }

    public static Item sheepCarcassItem(BlockState state) {
        Block b = state.getBlock();
        Block[] carcasses = sheepCarcassBlocks();
        for (int i = 0; i < carcasses.length; i++) {
            if (b == carcasses[i]) return (Item)carcasses[i].asItem();
        }
        return (Item)ButcheryModBlocks.SHEEP_CARCASS.get().asItem();
    }

    public static Item drainedSheepCarcassItem(BlockState state) {
        Block b = state.getBlock();
        Block[] drained = drainedSheepCarcassBlocks();
        for (int i = 0; i < drained.length; i++) {
            if (b == drained[i]) return (Item)drained[i].asItem();
        }
        return (Item)ButcheryModBlocks.DRAINED_SHEEP_CARCASS.get().asItem();
    }

    /** Skin rack states 36-50 hold the 15 dyed sheepskins. */
    public static Item sheepSkinForRackState(int rackState) {
        Item[] skins = sheepSkinItems();
        int idx = rackState - 36;
        if (idx >= 0 && idx < skins.length) return skins[idx];
        return null;
    }
}
