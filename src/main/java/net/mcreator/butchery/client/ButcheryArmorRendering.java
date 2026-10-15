package net.mcreator.butchery.client;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.client.model.ModelPillager_Disguise;
import net.mcreator.butchery.client.model.Modelbloody_butcher_apron;
import net.mcreator.butchery.client.model.Modelbutcher_apron;
import net.mcreator.butchery.client.model.Modeldragon_armor;
import net.mcreator.butchery.client.model.Modelevoker_disguise;
import net.mcreator.butchery.client.model.Modelpiglin_brute_disguise;
import net.mcreator.butchery.client.model.Modelstray_necklace;
import net.mcreator.butchery.client.model.Modelturtle_shell_chestplate;
import net.mcreator.butchery.client.model.Modelvindicator_disguise;
import net.mcreator.butchery.client.model.Modelwitch_disguise;
import net.mcreator.butchery.client.model.Modelwolf_fur_suit;
import net.mcreator.butchery.init.ButcheryModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.UvMapping;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: ButcheryArmorRendering.class */
@Environment(EnvType.CLIENT)
public final class ButcheryArmorRendering {
    private static final Map<Item, ArmorEntry> ENTRIES = new HashMap();

    /* JADX INFO: loaded from: ButcheryArmorRendering$ArmorEntry.class */
    private record ArmorEntry(Identifier texture, Supplier<Model<?>> model) {
        private ArmorEntry(Identifier texture, Supplier<Model<?>> model) {
            this.texture = texture;
            this.model = model;
        }

        public Supplier<Model<?>> model() {
            return this.model;
        }
    }

    private ButcheryArmorRendering() {
    }

    private static Identifier tex(String path) {
        return Identifier.parse(path);
    }

    private static ModelPart emptyPart() {
        return new ModelPart(Collections.emptyList(), Collections.emptyMap());
    }

    private static ModelPart emptyHead() {
        return new ModelPart(Collections.emptyList(), Map.of("hat", emptyPart()));
    }

    private static HumanoidModel<?> humanoid(Map<String, ModelPart> children) {
        return new HumanoidModel<>(new ModelPart(Collections.emptyList(), children));
    }

    private static ModelPart bake(String modelClass) {
        try {
            Class<?> cls = Class.forName("net.mcreator.butchery.client.model." + modelClass);
            Object layerLocation = cls.getField("LAYER_LOCATION").get(null);
            return Minecraft.getInstance().getEntityModels().bakeLayer((ModelLayerLocation) layerLocation);
        } catch (Exception e) {
            throw new RuntimeException("[Butchery] cannot bake armor model " + modelClass, e);
        }
    }

    private static void register(Item item, String texture, Supplier<Model<?>> model) {
        ENTRIES.put(item, new ArmorEntry(tex(texture), model));
    }

    public static void init() {
        register((Item) ButcheryModItems.BUTCHERS_APRON_CHESTPLATE.get(), "butchery:textures/entities/butchers_apron.png", () -> {
            Modelbutcher_apron m = new Modelbutcher_apron(bake("Modelbutcher_apron"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.BLOODY_BUTCHERS_APRON_CHESTPLATE.get(), "butchery:textures/entities/butchers_apron_bloody.png", () -> {
            Modelbloody_butcher_apron m = new Modelbloody_butcher_apron(bake("Modelbloody_butcher_apron"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.DRAGON_SCALE_ARMOR_HELMET.get(), "butchery:textures/entities/dragon_scale_armor.png", () -> {
            Modeldragon_armor m = new Modeldragon_armor(bake("Modeldragon_armor"));
            return humanoid(Map.of("head", new ModelPart(Collections.emptyList(), Map.of("head", m.Helmet, "hat", emptyPart())), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.DRAGON_SCALE_ARMOR_CHESTPLATE.get(), "butchery:textures/entities/dragon_scale_armor.png", () -> {
            Modeldragon_armor m = new Modeldragon_armor(bake("Modeldragon_armor"));
            return humanoid(Map.of("body", m.Chestplate, "left_arm", m.LeftPlate, "right_arm", m.RightPlate, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.DRAGON_SCALE_ARMOR_LEGGINGS.get(), "butchery:textures/entities/dragon_scale_armor.png", () -> {
            Modeldragon_armor m = new Modeldragon_armor(bake("Modeldragon_armor"));
            return humanoid(Map.of("left_leg", m.LeftLegging, "right_leg", m.RightLegging, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.DRAGON_SCALE_ARMOR_BOOTS.get(), "butchery:textures/entities/dragon_scale_armor.png", () -> {
            Modeldragon_armor m = new Modeldragon_armor(bake("Modeldragon_armor"));
            return humanoid(Map.of("left_leg", m.LeftBoot, "right_leg", m.RightBoot, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.EVOKER_ROBES_HELMET.get(), "butchery:textures/entities/evoker_disguise.png", () -> {
            Modelevoker_disguise m = new Modelevoker_disguise(bake("Modelevoker_disguise"));
            return humanoid(Map.of("head", new ModelPart(Collections.emptyList(), Map.of("head", m.Head, "hat", emptyPart())), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.EVOKER_ROBES_CHESTPLATE.get(), "butchery:textures/entities/evoker_disguise.png", () -> {
            Modelevoker_disguise m = new Modelevoker_disguise(bake("Modelevoker_disguise"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.EVOKER_ROBES_LEGGINGS.get(), "butchery:textures/entities/evoker_disguise.png", () -> {
            Modelevoker_disguise m = new Modelevoker_disguise(bake("Modelevoker_disguise"));
            return humanoid(Map.of("left_leg", m.LeftLeg, "right_leg", m.RightLeg, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.EVOKER_ROBES_BOOTS.get(), "butchery:textures/entities/evoker_disguise.png", () -> {
            Modelevoker_disguise m = new Modelevoker_disguise(bake("Modelevoker_disguise"));
            return humanoid(Map.of("left_leg", m.LeftBoot, "right_leg", m.RightBoot, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.FUR_SUIT_HELMET.get(), "butchery:textures/entities/wolf_suit.png", () -> {
            Modelwolf_fur_suit m = new Modelwolf_fur_suit(bake("Modelwolf_fur_suit"));
            return humanoid(Map.of("head", new ModelPart(Collections.emptyList(), Map.of("head", m.Head, "hat", emptyPart())), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.FUR_SUIT_CHESTPLATE.get(), "butchery:textures/entities/wolf_suit.png", () -> {
            Modelwolf_fur_suit m = new Modelwolf_fur_suit(bake("Modelwolf_fur_suit"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.FUR_SUIT_LEGGINGS.get(), "butchery:textures/entities/wolf_suit.png", () -> {
            Modelwolf_fur_suit m = new Modelwolf_fur_suit(bake("Modelwolf_fur_suit"));
            return humanoid(Map.of("left_leg", m.LeftLeg, "right_leg", m.RightLeg, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.FUR_SUIT_BOOTS.get(), "butchery:textures/entities/wolf_suit.png", () -> {
            Modelwolf_fur_suit m = new Modelwolf_fur_suit(bake("Modelwolf_fur_suit"));
            return humanoid(Map.of("left_leg", m.LeftBoot, "right_leg", m.RightBoot, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.PIGLIN_BRUTE_ARMOR_CHESTPLATE.get(), "butchery:textures/entities/piglin_brute_armor.png", () -> {
            Modelpiglin_brute_disguise m = new Modelpiglin_brute_disguise(bake("Modelpiglin_brute_disguise"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.PILLAGER_ARMOR_HELMET.get(), "butchery:textures/entities/pillager_disguise.png", () -> {
            ModelPillager_Disguise m = new ModelPillager_Disguise(bake("ModelPillager_Disguise"));
            return humanoid(Map.of("head", new ModelPart(Collections.emptyList(), Map.of("head", m.Head, "hat", emptyPart())), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.PILLAGER_ARMOR_CHESTPLATE.get(), "butchery:textures/entities/pillager_disguise.png", () -> {
            ModelPillager_Disguise m = new ModelPillager_Disguise(bake("ModelPillager_Disguise"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.PILLAGER_ARMOR_LEGGINGS.get(), "butchery:textures/entities/pillager_disguise.png", () -> {
            ModelPillager_Disguise m = new ModelPillager_Disguise(bake("ModelPillager_Disguise"));
            return humanoid(Map.of("left_leg", m.LeftLeg, "right_leg", m.RightLeg, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.PILLAGER_ARMOR_BOOTS.get(), "butchery:textures/entities/pillager_disguise.png", () -> {
            ModelPillager_Disguise m = new ModelPillager_Disguise(bake("ModelPillager_Disguise"));
            return humanoid(Map.of("left_leg", m.LeftLeg, "right_leg", m.RightLeg, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.STRAY_NECKLACE_CHESTPLATE.get(), "butchery:textures/entities/stray_neck.png", () -> {
            Modelstray_necklace m = new Modelstray_necklace(bake("Modelstray_necklace"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.TURTLE_SHELL_ARMOR_CHESTPLATE.get(), "butchery:textures/entities/turtle_armor.png", () -> {
            Modelturtle_shell_chestplate m = new Modelturtle_shell_chestplate(bake("Modelturtle_shell_chestplate"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.TURTLE_SHELL_ARMOR_LEGGINGS.get(), "butchery:textures/models/armor/turtle_shell_armor_layer_2.png", null);
        register((Item) ButcheryModItems.TURTLE_SHELL_ARMOR_BOOTS.get(), "butchery:textures/models/armor/turtle_shell_armor_layer_1.png", null);
        register((Item) ButcheryModItems.VINDICATORARMOR_HELMET.get(), "butchery:textures/entities/vindicator_disguise.png", () -> {
            Modelvindicator_disguise m = new Modelvindicator_disguise(bake("Modelvindicator_disguise"));
            return humanoid(Map.of("head", new ModelPart(Collections.emptyList(), Map.of("head", m.Head, "hat", emptyPart())), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.VINDICATORARMOR_CHESTPLATE.get(), "butchery:textures/entities/vindicator_disguise.png", () -> {
            Modelvindicator_disguise m = new Modelvindicator_disguise(bake("Modelvindicator_disguise"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.VINDICATORARMOR_LEGGINGS.get(), "butchery:textures/entities/vindicator_disguise.png", () -> {
            Modelvindicator_disguise m = new Modelvindicator_disguise(bake("Modelvindicator_disguise"));
            return humanoid(Map.of("left_leg", m.LeftLeg, "right_leg", m.RightLeg, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.VINDICATORARMOR_BOOTS.get(), "butchery:textures/entities/vindicator_disguise.png", () -> {
            Modelvindicator_disguise m = new Modelvindicator_disguise(bake("Modelvindicator_disguise"));
            return humanoid(Map.of("left_leg", m.LeftLeg, "right_leg", m.RightLeg, "head", emptyHead(), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart()));
        });
        register((Item) ButcheryModItems.WITCHES_CLOTHES_HELMET.get(), "butchery:textures/entities/witch_clothes.png", () -> {
            Modelwitch_disguise m = new Modelwitch_disguise(bake("Modelwitch_disguise"));
            return humanoid(Map.of("head", new ModelPart(Collections.emptyList(), Map.of("head", m.Head, "hat", emptyPart())), "body", emptyPart(), "right_arm", emptyPart(), "left_arm", emptyPart(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        register((Item) ButcheryModItems.WITCHES_CLOTHES_CHESTPLATE.get(), "butchery:textures/entities/witch_clothes.png", () -> {
            Modelwitch_disguise m = new Modelwitch_disguise(bake("Modelwitch_disguise"));
            return humanoid(Map.of("body", m.Body, "left_arm", m.LeftArm, "right_arm", m.RightArm, "head", emptyHead(), "right_leg", emptyPart(), "left_leg", emptyPart()));
        });
        ButcheryMod.LOGGER.debug("[Butchery] custom armor rendering registered for {} items", Integer.valueOf(ENTRIES.size()));
    }

    public static boolean handle(ItemStack stack, Model<?> vanillaModel, Object state, PoseStack poseStack, SubmitNodeCollector collector, int lightCoords, int outlineColor, int order) {
        ArmorEntry entry = ENTRIES.get(stack.getItem());
        if (entry == null) {
            return false;
        }
        Model<?> model = entry.model() != null ? entry.model().get() : vanillaModel;
        if (model == null) {
            return false;
        }
        collector.order(order).submitModel((Model) model, state, poseStack, RenderTypes.armorCutoutNoCull(entry.texture()), lightCoords, OverlayTexture.NO_OVERLAY, -1, (UvMapping) null, outlineColor);
        return true;
    }
}
