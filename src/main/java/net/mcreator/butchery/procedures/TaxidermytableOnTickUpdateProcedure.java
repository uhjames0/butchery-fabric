package net.mcreator.butchery.procedures;

import java.util.List;
import java.util.stream.Collectors;
import net.mcreator.butchery.recipe.TaxidermyRecipe;
import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.ItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandlerModifiable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.LevelAccessor;

/* JADX INFO: loaded from: TaxidermytableOnTickUpdateProcedure.class */
public class TaxidermytableOnTickUpdateProcedure {
    /* JADX WARN: Type inference failed for: r0v2, types: [net.mcreator.butchery.procedures.TaxidermytableOnTickUpdateProcedure$1] */
    public static void execute(final LevelAccessor world, final double x, final double y, final double z) {
        ItemStack itemStack = ItemStack.EMPTY;
        ItemStack slotitem = new Object() { // from class: net.mcreator.butchery.procedures.TaxidermytableOnTickUpdateProcedure.1
            public ItemStack getResult() {
                List<TaxidermyRecipe> recipes;
                if (world instanceof ServerLevel) {
                    ServerLevel _lvl = (ServerLevel) world;
                    recipes = (List) _lvl.recipeAccess().getRecipes().stream().filter(rh -> {
                        return rh.value().getType() == TaxidermyRecipe.Type.INSTANCE;
                    }).map(rh2 -> {
                        return (TaxidermyRecipe) rh2.value();
                    }).collect(Collectors.toList());
                } else {
                    recipes = List.of();
                }
                for (TaxidermyRecipe recipe : recipes) {
                    List<Ingredient> ingredients = recipe.getIngredients();
                    if (ingredients.get(0).test(TaxidermytableOnTickUpdateProcedure.itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()) && ingredients.get(1).test(TaxidermytableOnTickUpdateProcedure.itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()) && ingredients.get(2).test(TaxidermytableOnTickUpdateProcedure.itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy())) {
                        return recipe.getResultItems().get(0).copy();
                    }
                }
                return ItemStack.EMPTY;
            }
        }.getResult().copy();
        Object capability = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
        if (capability instanceof IItemHandlerModifiable) {
            IItemHandlerModifiable _itemHandlerModifiable = (IItemHandlerModifiable) capability;
            ItemStack _setstack = slotitem.copy();
            _setstack.setCount(slotitem.getCount());
            _itemHandlerModifiable.setStackInSlot(3, _setstack);
        }
    }

    private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
        new ILevelExtension(world);
        IItemHandler itemHandler = (IItemHandler) ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{pos, null});
        if (itemHandler != null) {
            return itemHandler.getStackInSlot(slot);
        }
        return ItemStack.EMPTY;
    }
}
