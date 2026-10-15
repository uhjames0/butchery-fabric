package net.mcreator.butchery.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

/* 26.3 port note: outputs are parsed as ItemStackTemplate (the same type vanilla
 * crafting recipes use for their "result" field). Plain ItemStack codecs fail
 * during datapack registry loading because item components are not bound yet
 * at that stage ("Item ... does not have components yet"). Templates are
 * materialised into ItemStacks on demand by getResultItems(). */
public record TaxidermyRecipe(List<ItemStackTemplate> outputs, List<Ingredient> recipeItems) implements Recipe<RecipeInput>  {
    public String group() {
        return "";
    }

    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public PlacementInfo placementInfo() {
        return PlacementInfo.create(this.recipeItems);
    }

    public boolean showNotification() {
        return true;
    }

    public boolean matches(RecipeInput pContainer, Level pLevel) {
        return pLevel.isClientSide() ? false : false;
    }

    public List<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    public ItemStack assemble(RecipeInput input) {
        return ItemStack.EMPTY;
    }

    public List<ItemStack> getResultItems() {
        return this.outputs.stream().map(ItemStackTemplate::create).toList();
    }

    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return Type.INSTANCE;
    }

    public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return Serializer.INSTANCE;
    }

    /* JADX INFO: loaded from TaxidermyRecipe$Serializer.class */
    public static class Serializer {
        private static final MapCodec<TaxidermyRecipe> CODEC = RecordCodecBuilder.mapCodec(builder -> {
            return builder.group(ItemStackTemplate.CODEC.listOf().fieldOf("outputs").forGetter((v0) -> {
                return v0.outputs();
            }), Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter((v0) -> {
                return v0.recipeItems();
            })).apply(builder, TaxidermyRecipe::new);
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, TaxidermyRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        public static final RecipeSerializer<TaxidermyRecipe> INSTANCE = new RecipeSerializer<>(CODEC, STREAM_CODEC);

        private static TaxidermyRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
            int ingredientCount = buf.readVarInt();
            List<Ingredient> ingredients = new java.util.ArrayList<>();
            for (int i = 0; i < ingredientCount; i++) {
                ingredients.add((Ingredient) Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
            }
            int outputCount = buf.readVarInt();
            List<ItemStackTemplate> outputs = new java.util.ArrayList<>();
            for (int i = 0; i < outputCount; i++) {
                outputs.add((ItemStackTemplate) ItemStackTemplate.STREAM_CODEC.decode(buf));
            }
            return new TaxidermyRecipe(outputs, ingredients);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buf, TaxidermyRecipe recipe) {
            buf.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                if (ing.items().findFirst().isEmpty() || ing.items().findFirst().get().value() == Items.AIR) {
                    Ingredient.CONTENTS_STREAM_CODEC.encode(buf, Ingredient.of(new ItemLike[0]));
                } else {
                    Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ing);
                }
            }
            buf.writeVarInt(recipe.outputs.size());
            for (ItemStackTemplate template : recipe.outputs) {
                ItemStackTemplate.STREAM_CODEC.encode(buf, template);
            }
        }
    }

    /* JADX INFO: loaded from TaxidermyRecipe$Type.class */
    public static class Type implements RecipeType<TaxidermyRecipe> {
        public static final RecipeType<TaxidermyRecipe> INSTANCE = new Type();

        private Type() {
        }
    }
}
