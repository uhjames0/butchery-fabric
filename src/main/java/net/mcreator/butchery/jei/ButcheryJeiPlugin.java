package net.mcreator.butchery.jei;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * JEI integration for Butchery. Loaded only when JEI is installed
 * (via the "jei_mod_plugin" entrypoint); the class is never referenced
 * from normal mod code, so the game runs fine without JEI.
 *
 * Categories:
 *  - Butchering : placed carcass + cleaver  -> full meat yield
 *  - Skinning   : placed carcass + skinning knife -> hide
 *  - Hanging    : carcass hung on a hook -> drained carcass
 *  - Skin Rack  : skin (+ salt) on a skin rack -> leather
 *  - Meat Grinder : raw meat (+ attachment/blood) -> mince/sausage
 *  - Pestle & Mortar : bones/hooves -> bone meal / glue
 *  - Taxidermy : head + wheat + empty head mount -> head mount block
 */
@JeiPlugin
public class ButcheryJeiPlugin implements IModPlugin {
   public static final IRecipeType<ButcheringDisplay> BUTCHERING_TYPE =
      IRecipeType.create("butchery", "butchering", ButcheringDisplay.class);
   public static final IRecipeType<SkinningDisplay> SKINNING_TYPE =
      IRecipeType.create("butchery", "skinning", SkinningDisplay.class);
   public static final IRecipeType<HangingDisplay> HANGING_TYPE =
      IRecipeType.create("butchery", "hanging", HangingDisplay.class);
   public static final IRecipeType<SkinRackDisplay> SKIN_RACK_TYPE =
      IRecipeType.create("butchery", "skin_rack", SkinRackDisplay.class);
   public static final IRecipeType<GrinderDisplay> GRINDER_TYPE =
      IRecipeType.create("butchery", "meat_grinder", GrinderDisplay.class);
   public static final IRecipeType<PestleDisplay> PESTLE_TYPE =
      IRecipeType.create("butchery", "pestle_and_mortar", PestleDisplay.class);
   public static final IRecipeType<TaxidermyDisplay> TAXIDERMY_TYPE =
      IRecipeType.create("butchery", "taxidermy", TaxidermyDisplay.class);

   public record ButcheringDisplay(List<ItemStack> carcasses, List<ItemStack> outputs) {}
   public record SkinningDisplay(List<ItemStack> carcasses, ItemStack skin) {}
   public record HangingDisplay(ItemStack carcass, ItemStack drained) {}
   public record SkinRackDisplay(List<ItemStack> skins, ItemStack salt, ItemStack leather) {}
   public record GrinderDisplay(List<ItemStack> inputs, List<ItemStack> extras, List<ItemStack> outputs) {}
   public record PestleDisplay(List<ItemStack> inputs, ItemStack output) {}
   public record TaxidermyDisplay(List<ItemStack> heads, ItemStack wheat, ItemStack mount, ItemStack output) {}

   @Override
   public Identifier getPluginUid() {
      return Identifier.parse("butchery:main");
   }

   // ------------------------------------------------------------------
   // helpers
   // ------------------------------------------------------------------
   private static ItemStack stack(String spec) {
      // spec = "namespace:path" or "namespace:path*count"
      int star = spec.indexOf('*');
      String id = star >= 0 ? spec.substring(0, star) : spec;
      int count = star >= 0 ? Integer.parseInt(spec.substring(star + 1)) : 1;
      Identifier key = Identifier.parse(id);
      if (!BuiltInRegistries.ITEM.containsKey(key))
         return null;
      ItemStack s = new ItemStack(BuiltInRegistries.ITEM.getValue(key));
      if (count > 1)
         s.setCount(count);
      return s;
   }

   private static ItemStack modItem(String path) {
      return stack("butchery:" + path);
   }

   // ------------------------------------------------------------------
   // registration
   // ------------------------------------------------------------------
   @Override
   public void registerCategories(IRecipeCategoryRegistration registration) {
      IGuiHelper gui = registration.getJeiHelpers().getGuiHelper();
      registration.addRecipeCategories(
         new ButcheringCategory(gui),
         new SkinningCategory(gui),
         new HangingCategory(gui),
         new SkinRackCategory(gui),
         new GrinderCategory(gui),
         new PestleCategory(gui),
         new TaxidermyCategory(gui));
   }

   @Override
   public void registerRecipes(IRecipeRegistration registration) {
      List<ButcheringDisplay> butchering = new ArrayList<>();
      List<ItemStack> allCarcasses = new ArrayList<>();
      for (ButcheryJeiRecipes.Butchering r : ButcheryJeiRecipes.BUTCHERING) {
         List<ItemStack> inputs = new ArrayList<>();
         for (String id : r.carcasses()) {
            ItemStack s = stack(id);
            if (s != null) inputs.add(s);
         }
         List<ItemStack> outputs = new ArrayList<>();
         for (String spec : r.outputs()) {
            ItemStack s = stack(spec);
            if (s != null) outputs.add(s);
         }
         if (inputs.isEmpty() || outputs.isEmpty()) continue;
         butchering.add(new ButcheringDisplay(inputs, outputs));
         for (ItemStack s : inputs)
            if (!allCarcasses.contains(s)) allCarcasses.add(s);
      }
      registration.addRecipes(BUTCHERING_TYPE, butchering);

      List<SkinningDisplay> skinning = new ArrayList<>();
      List<ItemStack> skinningCarcasses = new ArrayList<>();
      for (ButcheryJeiRecipes.Skinning r : ButcheryJeiRecipes.SKINNING) {
         List<ItemStack> inputs = new ArrayList<>();
         for (String id : r.carcasses()) {
            ItemStack s = stack(id);
            if (s != null) inputs.add(s);
         }
         ItemStack skin = stack(r.skin());
         if (inputs.isEmpty() || skin == null) continue;
         skinning.add(new SkinningDisplay(inputs, skin));
         for (ItemStack s : inputs)
            if (!skinningCarcasses.contains(s)) skinningCarcasses.add(s);
      }
      registration.addRecipes(SKINNING_TYPE, skinning);

      List<HangingDisplay> hanging = new ArrayList<>();
      for (ButcheryJeiRecipes.Hanging r : ButcheryJeiRecipes.HANGING) {
         ItemStack carcass = stack(r.carcass());
         ItemStack drained = stack(r.drained());
         if (carcass == null || drained == null) continue;
         hanging.add(new HangingDisplay(carcass, drained));
      }
      registration.addRecipes(HANGING_TYPE, hanging);

      List<ItemStack> rackSkins = new ArrayList<>();
      for (String id : ButcheryJeiRecipes.RACK_SKINS) {
         ItemStack s = stack(id);
         if (s != null) rackSkins.add(s);
      }
      ItemStack salt = modItem("salt");
      ItemStack leather = new ItemStack(Items.LEATHER);
      if (!rackSkins.isEmpty() && salt != null)
         registration.addRecipes(SKIN_RACK_TYPE, List.of(new SkinRackDisplay(rackSkins, salt, leather)));

      List<GrinderDisplay> grinder = new ArrayList<>();
      for (ButcheryJeiRecipes.Grinder r : ButcheryJeiRecipes.GRINDER) {
         List<ItemStack> inputs = new ArrayList<>();
         for (String id : r.inputs()) {
            ItemStack s = stack(id);
            if (s != null) inputs.add(s);
         }
         List<ItemStack> extras = new ArrayList<>();
         for (String id : r.extras()) {
            ItemStack s = stack(id);
            if (s != null) extras.add(s);
         }
         List<ItemStack> outputs = new ArrayList<>();
         for (String spec : r.outputs()) {
            ItemStack s = stack(spec);
            if (s != null) outputs.add(s);
         }
         if (inputs.isEmpty() || outputs.isEmpty()) continue;
         grinder.add(new GrinderDisplay(inputs, extras, outputs));
      }
      registration.addRecipes(GRINDER_TYPE, grinder);

      List<PestleDisplay> pestle = new ArrayList<>();
      for (ButcheryJeiRecipes.Pestle r : ButcheryJeiRecipes.PESTLE) {
         List<ItemStack> inputs = new ArrayList<>();
         for (String id : r.inputs()) {
            ItemStack s = stack(id);
            if (s != null) inputs.add(s);
         }
         ItemStack output = stack(r.output());
         if (inputs.isEmpty() || output == null) continue;
         pestle.add(new PestleDisplay(inputs, output));
      }
      registration.addRecipes(PESTLE_TYPE, pestle);

      List<TaxidermyDisplay> taxidermy = new ArrayList<>();
      ItemStack taxidermyWheat = new ItemStack(Items.WHEAT);
      for (ButcheryJeiRecipes.Taxidermy r : ButcheryJeiRecipes.TAXIDERMY) {
         List<ItemStack> heads = new ArrayList<>();
         for (String id : r.heads()) {
            ItemStack s = stack(id);
            if (s != null) heads.add(s);
         }
         ItemStack mount = stack(r.mount());
         ItemStack out = stack(r.output());
         if (heads.isEmpty() || mount == null || out == null) continue;
         taxidermy.add(new TaxidermyDisplay(heads, taxidermyWheat, mount, out));
      }
      registration.addRecipes(TAXIDERMY_TYPE, taxidermy);

      // ingredient info: the butchery workflow, shown on the Information tab
      if (!allCarcasses.isEmpty())
         registration.addIngredientInfo(allCarcasses, VanillaTypes.ITEM_STACK,
            Component.translatable("butchery.jei.info.carcass"));
      for (String tool : new String[]{"iron_cleaver", "bone_cleaver", "copper_cleaver", "gold_cleaver",
                                      "diamond_cleaver", "netherite_cleaver"}) {
         ItemStack s = modItem(tool);
         if (s != null)
            registration.addIngredientInfo(List.of(s), VanillaTypes.ITEM_STACK,
               Component.translatable("butchery.jei.info.cleaver"));
      }
      for (String tool : new String[]{"iron_skinning_knife", "bone_skinning_knife", "copper_skinning_knife",
                                      "gold_skinning_knife", "diamond_skinning_knife", "netherite_skinning_knife"}) {
         ItemStack s = modItem(tool);
         if (s != null)
            registration.addIngredientInfo(List.of(s), VanillaTypes.ITEM_STACK,
               Component.translatable("butchery.jei.info.knife"));
      }
      ItemStack hook = modItem("hook");
      if (hook != null)
         registration.addIngredientInfo(List.of(hook), VanillaTypes.ITEM_STACK,
            Component.translatable("butchery.jei.info.hook"));
      ItemStack rack = modItem("skin_rack");
      if (rack != null)
         registration.addIngredientInfo(List.of(rack), VanillaTypes.ITEM_STACK,
            Component.translatable("butchery.jei.info.rack"));
      ItemStack taxTable = modItem("taxidermy_table");
      if (taxTable != null)
         registration.addIngredientInfo(List.of(taxTable), VanillaTypes.ITEM_STACK,
            Component.translatable("butchery.jei.info.taxidermy"));
   }

   @Override
   public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
      List<ItemStack> butcherTools = new ArrayList<>();
      for (String t : new String[]{"bone_cleaver", "copper_cleaver", "iron_cleaver", "gold_cleaver",
                                   "diamond_cleaver", "netherite_cleaver"}) {
         ItemStack s = modItem(t);
         if (s != null) butcherTools.add(s);
      }
      List<ItemStack> knifeTools = new ArrayList<>();
      for (String t : new String[]{"bone_skinning_knife", "copper_skinning_knife", "iron_skinning_knife",
                                   "gold_skinning_knife", "diamond_skinning_knife", "netherite_skinning_knife"}) {
         ItemStack s = modItem(t);
         if (s != null) knifeTools.add(s);
      }

      // carcass items: click one in JEI to see its butchering / skinning / hanging recipes
      List<ItemStack> allCarcasses = new ArrayList<>();
      for (ButcheryJeiRecipes.Butchering r : ButcheryJeiRecipes.BUTCHERING)
         for (String id : r.carcasses()) {
            ItemStack s = stack(id);
            if (s != null && !allCarcasses.contains(s)) allCarcasses.add(s);
         }
      List<ItemStack> skinCarcasses = new ArrayList<>();
      for (ButcheryJeiRecipes.Skinning r : ButcheryJeiRecipes.SKINNING)
         for (String id : r.carcasses()) {
            ItemStack s = stack(id);
            if (s != null && !skinCarcasses.contains(s)) skinCarcasses.add(s);
         }
      List<ItemStack> hangingCarcasses = new ArrayList<>();
      for (ButcheryJeiRecipes.Hanging r : ButcheryJeiRecipes.HANGING) {
         ItemStack s = stack(r.carcass());
         if (s != null && !hangingCarcasses.contains(s)) hangingCarcasses.add(s);
      }

      for (ItemStack t : butcherTools)
         registration.addCraftingStation(BUTCHERING_TYPE, t);
      for (ItemStack t : knifeTools)
         registration.addCraftingStation(SKINNING_TYPE, t);
      ItemStack taxidermyTable = modItem("taxidermy_table");
      if (taxidermyTable != null)
         registration.addCraftingStation(TAXIDERMY_TYPE, taxidermyTable);
      for (String m : new String[]{"small_empty_head_mount", "empty_head_mount", "large_empty_head_mount",
                                   "empty_dragon_trimmed_head_mount", "empty_warden_trimmed_head_mount"}) {
         ItemStack s = modItem(m);
         if (s != null)
            registration.addCraftingStation(TAXIDERMY_TYPE, s);
      }
      for (ItemStack c : allCarcasses)
         registration.addCraftingStation(BUTCHERING_TYPE, c);
      for (ItemStack c : skinCarcasses)
         registration.addCraftingStation(SKINNING_TYPE, c);
      for (ItemStack c : hangingCarcasses)
         registration.addCraftingStation(HANGING_TYPE, c);

      ItemStack hook = modItem("hook");
      if (hook != null)
         registration.addCraftingStation(HANGING_TYPE, hook);
      ItemStack rack = modItem("skin_rack");
      ItemStack salt = modItem("salt");
      if (rack != null)
         registration.addCraftingStation(SKIN_RACK_TYPE, rack);
      if (salt != null)
         registration.addCraftingStation(SKIN_RACK_TYPE, salt);
      for (String id : ButcheryJeiRecipes.RACK_SKINS) {
         ItemStack s = stack(id);
         if (s != null)
            registration.addCraftingStation(SKIN_RACK_TYPE, s);
      }

      ItemStack grinderItem = modItem("meat_grinder");
      if (grinderItem != null)
         registration.addCraftingStation(GRINDER_TYPE, grinderItem);
      for (ButcheryJeiRecipes.Grinder r : ButcheryJeiRecipes.GRINDER)
         for (String id : r.inputs()) {
            ItemStack s = stack(id);
            if (s != null)
               registration.addCraftingStation(GRINDER_TYPE, s);
         }

      ItemStack pestleItem = modItem("pestle_and_mortar");
      if (pestleItem != null)
         registration.addCraftingStation(PESTLE_TYPE, pestleItem);
      for (ButcheryJeiRecipes.Pestle r : ButcheryJeiRecipes.PESTLE)
         for (String id : r.inputs()) {
            ItemStack s = stack(id);
            if (s != null)
               registration.addCraftingStation(PESTLE_TYPE, s);
         }
   }

   // ------------------------------------------------------------------
   // categories
   // ------------------------------------------------------------------
   public static class ButcheringCategory implements IRecipeCategory<ButcheringDisplay> {
      private final IDrawable icon;

      public ButcheringCategory(IGuiHelper gui) {
         ItemStack iconStack = new ItemStack(BuiltInRegistries.ITEM.getValue(
            Identifier.parse("butchery:iron_cleaver")));
         this.icon = gui.createDrawableItemStack(iconStack);
      }

      @Override
      public IRecipeType<ButcheringDisplay> getRecipeType() {
         return BUTCHERING_TYPE;
      }

      @Override
      public Component getTitle() {
         return Component.translatable("butchery.jei.category.butchering");
      }

      @Override
      public int getWidth() {
         return 132;
      }

      @Override
      public int getHeight() {
         return 66;
      }

      @Override
      public IDrawable getIcon() {
         return icon;
      }

      @Override
      public void setRecipe(IRecipeLayoutBuilder builder, ButcheringDisplay recipe, IFocusGroup focuses) {
         builder.addSlot(RecipeIngredientRole.CRAFTING_STATION, 6, 24)
            .addItemStacks(recipe.carcasses()).setStandardSlotBackground();
         int i = 0;
         for (ItemStack out : recipe.outputs()) {
            int col = i % 4, row = i / 4;
            builder.addSlot(RecipeIngredientRole.OUTPUT, 52 + col * 18, 6 + row * 18)
               .add(out).setStandardSlotBackground();
            i++;
         }
      }
   }

   public static class SkinningCategory implements IRecipeCategory<SkinningDisplay> {
      private final IDrawable icon;

      public SkinningCategory(IGuiHelper gui) {
         ItemStack iconStack = new ItemStack(BuiltInRegistries.ITEM.getValue(
            Identifier.parse("butchery:iron_skinning_knife")));
         this.icon = gui.createDrawableItemStack(iconStack);
      }

      @Override
      public IRecipeType<SkinningDisplay> getRecipeType() {
         return SKINNING_TYPE;
      }

      @Override
      public Component getTitle() {
         return Component.translatable("butchery.jei.category.skinning");
      }

      @Override
      public int getWidth() {
         return 96;
      }

      @Override
      public int getHeight() {
         return 50;
      }

      @Override
      public IDrawable getIcon() {
         return icon;
      }

      @Override
      public void setRecipe(IRecipeLayoutBuilder builder, SkinningDisplay recipe, IFocusGroup focuses) {
         builder.addSlot(RecipeIngredientRole.CRAFTING_STATION, 8, 16)
            .addItemStacks(recipe.carcasses()).setStandardSlotBackground();
         builder.addSlot(RecipeIngredientRole.OUTPUT, 70, 16)
            .add(recipe.skin()).setStandardSlotBackground();
      }
   }

   public static class HangingCategory implements IRecipeCategory<HangingDisplay> {
      private final IDrawable icon;

      public HangingCategory(IGuiHelper gui) {
         ItemStack iconStack = new ItemStack(BuiltInRegistries.ITEM.getValue(
            Identifier.parse("butchery:hook")));
         this.icon = gui.createDrawableItemStack(iconStack);
      }

      @Override
      public IRecipeType<HangingDisplay> getRecipeType() {
         return HANGING_TYPE;
      }

      @Override
      public Component getTitle() {
         return Component.translatable("butchery.jei.category.hanging");
      }

      @Override
      public int getWidth() {
         return 96;
      }

      @Override
      public int getHeight() {
         return 50;
      }

      @Override
      public IDrawable getIcon() {
         return icon;
      }

      @Override
      public void setRecipe(IRecipeLayoutBuilder builder, HangingDisplay recipe, IFocusGroup focuses) {
         builder.addSlot(RecipeIngredientRole.INPUT, 8, 16)
            .add(recipe.carcass()).setStandardSlotBackground();
         builder.addSlot(RecipeIngredientRole.OUTPUT, 70, 16)
            .add(recipe.drained()).setStandardSlotBackground();
      }
   }

   public static class SkinRackCategory implements IRecipeCategory<SkinRackDisplay> {
      private final IDrawable icon;

      public SkinRackCategory(IGuiHelper gui) {
         ItemStack iconStack = new ItemStack(BuiltInRegistries.ITEM.getValue(
            Identifier.parse("butchery:skin_rack")));
         this.icon = gui.createDrawableItemStack(iconStack);
      }

      @Override
      public IRecipeType<SkinRackDisplay> getRecipeType() {
         return SKIN_RACK_TYPE;
      }

      @Override
      public Component getTitle() {
         return Component.translatable("butchery.jei.category.skin_rack");
      }

      @Override
      public int getWidth() {
         return 110;
      }

      @Override
      public int getHeight() {
         return 50;
      }

      @Override
      public IDrawable getIcon() {
         return icon;
      }

      @Override
      public void setRecipe(IRecipeLayoutBuilder builder, SkinRackDisplay recipe, IFocusGroup focuses) {
         builder.addSlot(RecipeIngredientRole.CRAFTING_STATION, 8, 16)
            .addItemStacks(recipe.skins()).setStandardSlotBackground();
         builder.addSlot(RecipeIngredientRole.INPUT, 30, 16)
            .add(recipe.salt()).setStandardSlotBackground();
         builder.addSlot(RecipeIngredientRole.OUTPUT, 84, 16)
            .add(recipe.leather()).setOutputSlotBackground();
      }
   }

   public static class GrinderCategory implements IRecipeCategory<GrinderDisplay> {
      private final IDrawable icon;

      public GrinderCategory(IGuiHelper gui) {
         ItemStack iconStack = new ItemStack(BuiltInRegistries.ITEM.getValue(
            Identifier.parse("butchery:meat_grinder")));
         this.icon = gui.createDrawableItemStack(iconStack);
      }

      @Override
      public IRecipeType<GrinderDisplay> getRecipeType() {
         return GRINDER_TYPE;
      }

      @Override
      public Component getTitle() {
         return Component.translatable("butchery.jei.category.meat_grinder");
      }

      @Override
      public int getWidth() {
         return 124;
      }

      @Override
      public int getHeight() {
         return 50;
      }

      @Override
      public IDrawable getIcon() {
         return icon;
      }

      @Override
      public void setRecipe(IRecipeLayoutBuilder builder, GrinderDisplay recipe, IFocusGroup focuses) {
         builder.addSlot(RecipeIngredientRole.CRAFTING_STATION, 6, 16)
            .addItemStacks(recipe.inputs()).setStandardSlotBackground();
         int x = 28;
         for (ItemStack extra : recipe.extras()) {
            builder.addSlot(RecipeIngredientRole.INPUT, x, 16)
               .add(extra).setStandardSlotBackground();
            x += 20;
         }
         int outX = 92;
         for (ItemStack out : recipe.outputs()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, outX, 16)
               .add(out).setStandardSlotBackground();
            outX += 20;
         }
      }
   }

   public static class PestleCategory implements IRecipeCategory<PestleDisplay> {
      private final IDrawable icon;

      public PestleCategory(IGuiHelper gui) {
         ItemStack iconStack = new ItemStack(BuiltInRegistries.ITEM.getValue(
            Identifier.parse("butchery:pestle_and_mortar")));
         this.icon = gui.createDrawableItemStack(iconStack);
      }

      @Override
      public IRecipeType<PestleDisplay> getRecipeType() {
         return PESTLE_TYPE;
      }

      @Override
      public Component getTitle() {
         return Component.translatable("butchery.jei.category.pestle_and_mortar");
      }

      @Override
      public int getWidth() {
         return 96;
      }

      @Override
      public int getHeight() {
         return 50;
      }

      @Override
      public IDrawable getIcon() {
         return icon;
      }

      @Override
      public void setRecipe(IRecipeLayoutBuilder builder, PestleDisplay recipe, IFocusGroup focuses) {
         builder.addSlot(RecipeIngredientRole.CRAFTING_STATION, 8, 16)
            .addItemStacks(recipe.inputs()).setStandardSlotBackground();
         builder.addSlot(RecipeIngredientRole.OUTPUT, 70, 16)
            .add(recipe.output()).setStandardSlotBackground();
      }
   }

   public static class TaxidermyCategory implements IRecipeCategory<TaxidermyDisplay> {
      private final IDrawable icon;

      public TaxidermyCategory(IGuiHelper gui) {
         ItemStack iconStack = new ItemStack(BuiltInRegistries.ITEM.getValue(
            Identifier.parse("butchery:taxidermy_table")));
         this.icon = gui.createDrawableItemStack(iconStack);
      }

      @Override
      public IRecipeType<TaxidermyDisplay> getRecipeType() {
         return TAXIDERMY_TYPE;
      }

      @Override
      public Component getTitle() {
         return Component.translatable("butchery.jei.category.taxidermy");
      }

      @Override
      public int getWidth() {
         return 124;
      }

      @Override
      public int getHeight() {
         return 50;
      }

      @Override
      public IDrawable getIcon() {
         return icon;
      }

      @Override
      public void setRecipe(IRecipeLayoutBuilder builder, TaxidermyDisplay recipe, IFocusGroup focuses) {
         // mirrors the taxidermy station GUI: wheat (left), head (top), mount (right) -> output (bottom)
         builder.addSlot(RecipeIngredientRole.INPUT, 30, 8)
            .add(recipe.wheat()).setStandardSlotBackground();
         builder.addSlot(RecipeIngredientRole.INPUT, 30, 30)
            .addItemStacks(recipe.heads()).setStandardSlotBackground();
         builder.addSlot(RecipeIngredientRole.INPUT, 52, 19)
            .add(recipe.mount()).setStandardSlotBackground();
         builder.addSlot(RecipeIngredientRole.OUTPUT, 100, 19)
            .add(recipe.output()).setStandardSlotBackground();
      }
   }
}
