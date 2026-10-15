package net.mcreator.butchery.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.mcreator.butchery.block.PlayercorpseBlock;
import net.mcreator.butchery.block.entity.PlayercorpseBlockEntity;
import net.mcreator.butchery.client.model.Modelplayer_corpse;
import net.mcreator.butchery.custom.model.CorpseSkinLookup;
import net.mcreator.butchery.custom.model.Modelplayer_corpse_slim;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.PlayerModelType;
import net.minecraft.world.entity.player.PlayerSkin;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: PlayercorpseRenderer.class */
public class PlayercorpseRenderer implements BlockEntityRenderer<PlayercorpseBlockEntity, PlayercorpseRenderer.State> {
    private final Modelplayer_corpse classicModel;
    private final Modelplayer_corpse_slim slimModel;

    /* JADX INFO: loaded from: PlayercorpseRenderer$State.class */
    public static class State extends BlockEntityRenderState {
        public float ageInTicks;
        public Identifier skinTexture;
        public boolean slim;
        public int corpseState;
        public Direction facing = Direction.NORTH;
        public final LivingEntityRenderState living = new LivingEntityRenderState();
    }

    public PlayercorpseRenderer(BlockEntityRendererProvider.Context context) {
        this.classicModel = new Modelplayer_corpse(context.bakeLayer(Modelplayer_corpse.LAYER_LOCATION));
        this.slimModel = new Modelplayer_corpse_slim(context.bakeLayer(Modelplayer_corpse_slim.SLIM_LAYER_LOCATION));
    }

    /* JADX INFO: renamed from: createRenderState, reason: merged with bridge method [inline-methods] */
    public State createRenderState() {
        return new State();
    }

    public void extractRenderState(PlayercorpseBlockEntity blockEntity, State state, float partialTick, Vec3 cameraPos, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTick, cameraPos, breakProgress);
        int tickCount = (int) blockEntity.getLevel().getGameTime();
        state.ageInTicks = tickCount + partialTick;
        state.living.ageInTicks = state.ageInTicks;
        PlayerSkin playerSkin = CorpseSkinLookup.get(blockEntity.getPlayerUUID(), blockEntity.getPlayerName());
        state.skinTexture = playerSkin.body().texturePath();
        state.slim = playerSkin.model() == PlayerModelType.SLIM;
        Modelplayer_corpse corpseModel = state.slim ? this.slimModel : this.classicModel;
        state.facing = blockEntity.getBlockState().getValue(PlayercorpseBlock.FACING);
        int corpseState = ((Integer) blockEntity.getBlockState().getValue(PlayercorpseBlock.BLOCKSTATE)).intValue();
        state.corpseState = corpseState;
        boolean sitting = corpseState == 0 || (corpseState >= 11 && corpseState <= 19);
        if (sitting) {
            setSittingPose(corpseModel);
        } else {
            setHangingPose(corpseModel);
        }
        setAllPartsVisible(corpseModel);
        applyCorpseStateVisibility(corpseModel, corpseState);
    }

    public void submit(State state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        Modelplayer_corpse corpseModel = state.slim ? this.slimModel : this.classicModel;
        poseStack.pushPose();
        poseStack.translate(0.5d, 0.5d, 0.5d);
        switch (AnonymousClass1.$SwitchMap$net$minecraft$core$Direction[state.facing.ordinal()]) {
            case 1:
                poseStack.rotateDegrees(Axis.YP, 270.0f);
                break;
            case 2:
                poseStack.rotateDegrees(Axis.YP, 180.0f);
                break;
            case 3:
                poseStack.rotateDegrees(Axis.YP, 90.0f);
                break;
        }
        poseStack.rotateDegrees(Axis.YP, 180.0f);
        if (state.corpseState == 0 || (state.corpseState >= 11 && state.corpseState <= 19)) {
            poseStack.translate(0.0d, -0.4d, 0.0d);
        } else {
            poseStack.translate(0.0d, 0.0d, 0.0d);
        }
        poseStack.scale(1.0f, -1.0f, -1.0f);
        poseStack.translate(0.0d, -1.0d, 0.0d);
        submitNodeCollector.submitModel(corpseModel, state.living, poseStack, RenderTypes.entityCutout(state.skinTexture), state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: net.mcreator.butchery.client.renderer.PlayercorpseRenderer$1, reason: invalid class name */
    /* JADX INFO: loaded from: PlayercorpseRenderer$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction = new int[Direction.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.EAST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.WEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.NORTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private void setAllPartsVisible(Modelplayer_corpse corpseModel) {
        corpseModel.Head.visible = true;
        corpseModel.Body.visible = true;
        corpseModel.RightArm.visible = true;
        corpseModel.LeftArm.visible = true;
        corpseModel.RightLeg.visible = true;
        corpseModel.LeftLeg.visible = true;
    }

    private void applyCorpseStateVisibility(Modelplayer_corpse corpseModel, int corpseState) {
        switch (corpseState) {
            case 2:
            case 11:
                corpseModel.Head.visible = false;
                break;
            case 3:
            case 12:
                corpseModel.Head.visible = false;
                corpseModel.RightArm.visible = false;
                break;
            case 4:
            case 13:
                corpseModel.Head.visible = false;
                corpseModel.RightArm.visible = false;
                corpseModel.LeftArm.visible = false;
                break;
            case 5:
                corpseModel.Head.visible = false;
                corpseModel.RightArm.visible = false;
                corpseModel.LeftArm.visible = false;
                corpseModel.RightLeg.visible = false;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 20:
                corpseModel.Head.visible = false;
                corpseModel.RightArm.visible = false;
                corpseModel.LeftArm.visible = false;
                corpseModel.RightLeg.visible = false;
                corpseModel.LeftLeg.visible = false;
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
                corpseModel.Head.visible = false;
                corpseModel.RightArm.visible = false;
                corpseModel.LeftArm.visible = false;
                break;
            case 18:
                corpseModel.Head.visible = false;
                corpseModel.Body.visible = false;
                corpseModel.RightArm.visible = false;
                corpseModel.LeftArm.visible = false;
                break;
        }
    }

    private void setSittingPose(Modelplayer_corpse corpseModel) {
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

    private void setHangingPose(Modelplayer_corpse corpseModel) {
        corpseModel.Head.xRot = 0.7069f;
        corpseModel.Head.yRot = 0.0f;
        corpseModel.Head.zRot = 0.0f;
        corpseModel.Body.xRot = 0.1091f;
        corpseModel.Body.yRot = 0.0f;
        corpseModel.Body.zRot = 0.0f;
        corpseModel.RightArm.xRot = 0.0262f;
        corpseModel.RightArm.yRot = 0.0f;
        corpseModel.RightArm.zRot = 0.0f;
        corpseModel.LeftArm.xRot = 0.0f;
        corpseModel.LeftArm.yRot = 0.0f;
        corpseModel.LeftArm.zRot = 0.0f;
        corpseModel.RightLeg.xRot = -0.0436f;
        corpseModel.RightLeg.yRot = 0.0f;
        corpseModel.RightLeg.zRot = 0.0436f;
        corpseModel.LeftLeg.xRot = 0.0436f;
        corpseModel.LeftLeg.yRot = 0.0f;
        corpseModel.LeftLeg.zRot = -0.0436f;
    }
}
