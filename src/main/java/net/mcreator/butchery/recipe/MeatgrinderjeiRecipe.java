package net.mcreator.butchery.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
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

/* JADX INFO: loaded from: MeatgrinderjeiRecipe.class */
public record MeatgrinderjeiRecipe(List<ItemStack> outputs, List<Ingredient> recipeItems) implements Recipe<RecipeInput>  {
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
        return this.outputs;
    }

    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return Type.INSTANCE;
    }

    public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return Serializer.INSTANCE;
    }

    /* JADX INFO: loaded from: MeatgrinderjeiRecipe$Serializer.class */
    public static class Serializer {
        private static final MapCodec<MeatgrinderjeiRecipe> CODEC = RecordCodecBuilder.mapCodec(builder -> {
            return builder.group(ItemStack.OPTIONAL_CODEC.listOf().fieldOf("outputs").forGetter((v0) -> {
                return v0.outputs();
            }), Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter((v0) -> {
                return v0.recipeItems();
            })).apply(builder, MeatgrinderjeiRecipe::new);
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, MeatgrinderjeiRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        public static final RecipeSerializer<MeatgrinderjeiRecipe> INSTANCE = new RecipeSerializer<>(CODEC, STREAM_CODEC);

        private static MeatgrinderjeiRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
            NonNullList nonNullListWithSize = NonNullList.withSize(buf.readVarInt(), Ingredient.of(new ItemLike[0]));
            nonNullListWithSize.replaceAll(ingredients -> {
                return (Ingredient) Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            });
            NonNullList nonNullListWithSize2 = NonNullList.withSize(buf.readVarInt(), ItemStack.EMPTY);
            nonNullListWithSize2.replaceAll(results -> {
                return (ItemStack) ItemStack.STREAM_CODEC.decode(buf);
            });
            return new MeatgrinderjeiRecipe(nonNullListWithSize2, nonNullListWithSize);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buf, MeatgrinderjeiRecipe recipe) {
            buf.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                if (((Holder) ing.items().findFirst().get()).value() == Items.AIR) {
                    Ingredient.CONTENTS_STREAM_CODEC.encode(buf, Ingredient.of(new ItemLike[0]));
                } else {
                    Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ing);
                }
            }
            buf.writeVarInt(recipe.getResultItems().size());
            for (ItemStack itemstack : recipe.getResultItems()) {
                ItemStack.STREAM_CODEC.encode(buf, itemstack);
            }
        }
    }

    /* JADX INFO: loaded from: MeatgrinderjeiRecipe$Type.class */
    public static class Type implements RecipeType<MeatgrinderjeiRecipe> {
        public static final RecipeType<MeatgrinderjeiRecipe> INSTANCE = new Type();

        private Type() {
        }
    }
}
