package net.mcreator.butchery.init;

import net.mcreator.butchery.recipe.MeatgrinderjeiRecipe;
import net.mcreator.butchery.recipe.PestleandmortarrecipetypeRecipe;
import net.mcreator.butchery.recipe.TaxidermyRecipe;
import net.mcreator.butchery.shim.DeferredHolder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ButcheryModRecipeTypes {
    public static final DeferredHolder<RecipeType<?>, RecipeType<?>> TAXIDERMY = ButcheryModRecipeTypes.registerType("taxidermy", TaxidermyRecipe.Type.INSTANCE);
    public static final DeferredHolder<RecipeType<?>, RecipeType<?>> MEATGRINDERJEI = ButcheryModRecipeTypes.registerType("meatgrinderjei", MeatgrinderjeiRecipe.Type.INSTANCE);
    public static final DeferredHolder<RecipeType<?>, RecipeType<?>> PESTLEANDMORTARRECIPE = ButcheryModRecipeTypes.registerType("pestleandmortarrecipetype", PestleandmortarrecipetypeRecipe.Type.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> TAXIDERMY_SER = ButcheryModRecipeTypes.registerSerializer("taxidermy", TaxidermyRecipe.Serializer.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> MEATGRINDERJEI_SER = ButcheryModRecipeTypes.registerSerializer("meatgrinderjei", MeatgrinderjeiRecipe.Serializer.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> PESTLEANDMORTARRECIPE_SER = ButcheryModRecipeTypes.registerSerializer("pestleandmortarrecipetype", PestleandmortarrecipetypeRecipe.Serializer.INSTANCE);

    private static <T extends RecipeType<?>> DeferredHolder<RecipeType<?>, RecipeType<?>> registerType(String path, RecipeType<?> instance) {
        return new DeferredHolder(Identifier.fromNamespaceAndPath((String)"butchery", (String)path), () -> {
            Registry.register((Registry)BuiltInRegistries.RECIPE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)path), (Object)instance);
            return instance;
        });
    }

    private static DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> registerSerializer(String path, RecipeSerializer<?> instance) {
        return new DeferredHolder(Identifier.fromNamespaceAndPath((String)"butchery", (String)path), () -> {
            Registry.register((Registry)BuiltInRegistries.RECIPE_SERIALIZER, (Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)path), (Object)instance);
            return instance;
        });
    }

    public static void register() {
        TAXIDERMY.get();
        MEATGRINDERJEI.get();
        PESTLEANDMORTARRECIPE.get();
        TAXIDERMY_SER.get();
        MEATGRINDERJEI_SER.get();
        PESTLEANDMORTARRECIPE_SER.get();
    }
}

