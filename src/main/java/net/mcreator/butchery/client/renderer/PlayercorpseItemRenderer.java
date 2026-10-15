package net.mcreator.butchery.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import java.util.function.Consumer;
import net.mcreator.butchery.client.model.Modelplayer_corpse;
import net.mcreator.butchery.custom.model.CorpseSkinLookup;
import net.mcreator.butchery.custom.model.Modelplayer_corpse_slim;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.UvMapping;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.PlayerModelType;
import net.minecraft.world.entity.player.PlayerSkin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: PlayercorpseItemRenderer.class */
public class PlayercorpseItemRenderer implements SpecialModelRenderer<PlayercorpseItemRenderer.CorpseRenderData> {
    private final LivingEntityRenderState renderState = new LivingEntityRenderState();
    private final Modelplayer_corpse classicModel;
    private final Modelplayer_corpse_slim slimModel;

    public PlayercorpseItemRenderer(EntityModelSet entityModelSet) {
        this.classicModel = new Modelplayer_corpse(entityModelSet.bakeLayer(Modelplayer_corpse.LAYER_LOCATION));
        this.slimModel = new Modelplayer_corpse_slim(entityModelSet.bakeLayer(Modelplayer_corpse_slim.SLIM_LAYER_LOCATION));
    }

    /* JADX INFO: renamed from: extractArgument, reason: merged with bridge method [inline-methods] */
    public CorpseRenderData extractArgument(ItemStack stack) {
        CustomData customData = (CustomData) stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        CompoundTag tag = customData.copyTag();
        String uuidString = (String) tag.getString("PlayerUUID").orElse("");
        String playerName = (String) tag.getString("PlayerName").orElse("");
        return new CorpseRenderData(uuidString, playerName);
    }

    public void submit(CorpseRenderData data, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, int packedOverlay, boolean hasFoil, int outlineColor) {
        PlayerSkin playerSkin = CorpseSkinLookup.get(data == null ? "" : data.uuidString(), data == null ? "" : data.playerName());
        Identifier skinTexture = playerSkin.body().texturePath();
        Modelplayer_corpse corpseModel = playerSkin.model() == PlayerModelType.SLIM ? this.slimModel : this.classicModel;
        setItemPose(corpseModel);
        this.renderState.ageInTicks = 0.0f;
        poseStack.pushPose();
        poseStack.translate(0.5d, 0.5d, 0.5d);
        poseStack.scale(1.0f, -1.0f, -1.0f);
        poseStack.translate(0.0d, -1.0d, 0.0d);
        submitNodeCollector.submitModel(corpseModel, this.renderState, poseStack, RenderTypes.entityCutout(skinTexture), packedLight, OverlayTexture.NO_OVERLAY, -1, (UvMapping) null, outlineColor);
        poseStack.popPose();
    }

    public void getExtents(Consumer<Vector3fc> output) {
        output.accept(new Vector3f(-0.5f, -0.5f, -0.5f));
        output.accept(new Vector3f(0.5f, 0.5f, 0.5f));
    }

    private void setItemPose(Modelplayer_corpse corpseModel) {
        corpseModel.Body.xRot = (float) Math.toRadians(10.0d);
        corpseModel.Body.yRot = 0.0f;
        corpseModel.Body.zRot = 0.0f;
        corpseModel.Head.xRot = (float) Math.toRadians(22.5d);
        corpseModel.Head.yRot = 0.0f;
        corpseModel.Head.zRot = 0.0f;
        corpseModel.RightArm.xRot = (float) Math.toRadians(5.0d);
        corpseModel.RightArm.yRot = 0.0f;
        corpseModel.RightArm.zRot = (float) Math.toRadians(2.5d);
        corpseModel.LeftArm.xRot = (float) Math.toRadians(7.5d);
        corpseModel.LeftArm.yRot = 0.0f;
        corpseModel.LeftArm.zRot = (float) Math.toRadians(-2.5d);
        corpseModel.RightLeg.xRot = (float) Math.toRadians(-90.0d);
        corpseModel.RightLeg.yRot = (float) Math.toRadians(22.5d);
        corpseModel.RightLeg.zRot = 0.0f;
        corpseModel.LeftLeg.xRot = (float) Math.toRadians(-90.0d);
        corpseModel.LeftLeg.yRot = (float) Math.toRadians(-22.5d);
        corpseModel.LeftLeg.zRot = 0.0f;
    }

    /* JADX INFO: loaded from: PlayercorpseItemRenderer$CorpseRenderData.class */
    public record CorpseRenderData(String uuidString, String playerName) {}

    /* JADX INFO: loaded from: PlayercorpseItemRenderer$Unbaked.class */
    public static final class Unbaked implements SpecialModelRenderer.Unbaked<CorpseRenderData> {
        public static final MapCodec<Unbaked> MAP_CODEC = MapCodec.unit(new Unbaked());

        public MapCodec<Unbaked> type() {
            return MAP_CODEC;
        }

        public SpecialModelRenderer<CorpseRenderData> bake(SpecialModelRenderer.BakingContext context) {
            return new PlayercorpseItemRenderer(context.entityModelSet());
        }
    }
}
