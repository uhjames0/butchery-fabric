package net.mcreator.butchery.mixinbridge;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import java.util.HashMap;
import java.util.Map;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModMobEffects;
import net.mcreator.butchery.procedures.BreathlessadvancementaddedProcedure;
import net.mcreator.butchery.procedures.GrantbloodandgearsProcedure;
import net.mcreator.butchery.procedures.GrantbloodbankadvancementProcedure;
import net.mcreator.butchery.procedures.GrantbutcheradvancementProcedure;
import net.mcreator.butchery.procedures.GrantknifetomeatyouProcedure;
import net.mcreator.butchery.procedures.GrantrackemupadvancementProcedure;
import net.mcreator.butchery.procedures.GrantrotisserierookieProcedure;
import net.mcreator.butchery.procedures.GrantthetrophymakerProcedure;
import net.mcreator.butchery.procedures.ItsafloateradvancementgrantedProcedure;
import net.mcreator.butchery.procedures.SalttipplacedProcedure;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Compostable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;

public class ButcheryMixinHooks {
    private static final Object2FloatMap<Item> COMPOSTABLES = new Object2FloatOpenHashMap();
    private static boolean compostableInit = false;
    private static final Map<Item, Integer> FUELS = new HashMap<Item, Integer>();

    public static void addCompostable(Item item, float chance) {
    }

    public static float compostableChance(Item item) {
        Compostable c = (Compostable)item.components().get(DataComponents.COMPOSTABLE);
        if (c == null) {
            return 0.0f;
        }
        ResolvableInt resolvableInt = c.layers();
        if (resolvableInt instanceof ResolvableInt.Constant) {
            ResolvableInt.Constant constant = (ResolvableInt.Constant)resolvableInt;
            return (float)constant.value() / 100.0f;
        }
        return 0.0f;
    }

    public static void addFuel(Item item, int burnTime) {
        FUELS.put(item, burnTime);
    }

    public static int getBurnTime(ItemStack stack) {
        Integer t = FUELS.get(stack.getItem());
        return t == null ? -1 : t;
    }

    public static void initHooks() {
    }

    public static void onCrafted(Player player, ItemStack crafted, CraftingContainer container) {
        ShimEvent.ItemCraftedShim ev = new ShimEvent.ItemCraftedShim(player, crafted, container);
        try {
            GrantbloodandgearsProcedure.onItemCrafted(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] crafted handler error", (Throwable)e);
        }
        try {
            GrantbutcheradvancementProcedure.onItemCrafted(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] crafted handler error", (Throwable)e);
        }
        try {
            GrantrotisserierookieProcedure.onItemCrafted(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] crafted handler error", (Throwable)e);
        }
        try {
            GrantknifetomeatyouProcedure.onItemCrafted(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] crafted handler error", (Throwable)e);
        }
        try {
            GrantrackemupadvancementProcedure.onItemCrafted(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] crafted handler error", (Throwable)e);
        }
        try {
            GrantthetrophymakerProcedure.onItemCrafted(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] crafted handler error", (Throwable)e);
        }
        try {
            GrantbloodbankadvancementProcedure.onItemCrafted(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] crafted handler error", (Throwable)e);
        }
    }

    public static void onEntityTick(Entity entity) {
        ShimEvent.EntityTickShim ev = new ShimEvent.EntityTickShim(entity);
    }

    /** NeoForge BlockEvent.EntityPlaceEvent equivalent - salt formation growth */
    public static void onBlockPlaced(Player player, Level level, BlockPos pos) {
        ShimEvent.EntityPlaceShim ev = new ShimEvent.EntityPlaceShim(player, level, pos, level.getBlockState(pos));
        try {
            SalttipplacedProcedure.onBlockPlace(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] block place handler error", (Throwable)e);
        }
    }

    /** NeoForge AdvancementEvent.AdvancementEarnEvent equivalent */
    public static void onAdvancementEarned(ServerPlayer player, AdvancementHolder holder) {
        ShimEvent.AdvancementEarnShim ev = new ShimEvent.AdvancementEarnShim((Player)player, holder);
        try {
            BreathlessadvancementaddedProcedure.onAdvancement(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] advancement handler error", (Throwable)e);
        }
        try {
            ItsafloateradvancementgrantedProcedure.onAdvancement(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] advancement handler error", (Throwable)e);
        }
    }

    public static void onDimensionChange(ServerPlayer player) {
        ShimEvent.PlayerChangedDimensionShim ev = new ShimEvent.PlayerChangedDimensionShim((Player)player);
    }

    public static void onEffectRemoved(Entity entity, MobEffectInstance effect) {
        try {
            ButcheryModMobEffects.onEffectRemoved(entity, effect);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

