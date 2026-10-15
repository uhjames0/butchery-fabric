package net.mcreator.butchery.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.mcreator.butchery.block.DrainedsniffercarcassblockBlock;
import net.mcreator.butchery.block.entity.DrainedsniffercarcassblockBlockEntity;
import net.mcreator.butchery.client.model.Modelsniffer_carcass;
import net.mcreator.butchery.client.model.animations.hanging_sniffer_anim_cut_1Animation;
import net.mcreator.butchery.client.model.animations.hanging_sniffer_anim_cut_2Animation;
import net.mcreator.butchery.client.model.animations.hanging_sniffer_anim_headlessAnimation;
import net.mcreator.butchery.client.model.animations.hanging_sniffer_anim_idleAnimation;
import net.mcreator.butchery.client.model.animations.hanging_sniffer_anim_skinnedAnimation;
import net.mcreator.butchery.client.model.animations.sniffer_cut_1Animation;
import net.mcreator.butchery.client.model.animations.sniffer_cut_2Animation;
import net.mcreator.butchery.client.model.animations.sniffer_headlessAnimation;
import net.mcreator.butchery.client.model.animations.sniffer_idleAnimation;
import net.mcreator.butchery.client.model.animations.sniffer_skinnedAnimation;
import net.mcreator.butchery.procedures.Snifferanimationcondition10Procedure;
import net.mcreator.butchery.procedures.Snifferanimationcondition1Procedure;
import net.mcreator.butchery.procedures.Snifferanimationcondition2Procedure;
import net.mcreator.butchery.procedures.Snifferanimationcondition3Procedure;
import net.mcreator.butchery.procedures.Snifferanimationcondition4Procedure;
import net.mcreator.butchery.procedures.Snifferanimationcondition5Procedure;
import net.mcreator.butchery.procedures.Snifferanimationcondition6Procedure;
import net.mcreator.butchery.procedures.Snifferanimationcondition7Procedure;
import net.mcreator.butchery.procedures.Snifferanimationcondition8Procedure;
import net.mcreator.butchery.procedures.Snifferanimationcondition9Procedure;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.geom.ModelPart;
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
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: DrainedsniffercarcassblockRenderer.class */
public class DrainedsniffercarcassblockRenderer implements BlockEntityRenderer<DrainedsniffercarcassblockBlockEntity, DrainedsniffercarcassblockRenderer.State> {
    private final CustomHierarchicalModel model;
    private final Identifier texture = Identifier.parse("butchery:textures/block/sniffer.png");

    /* JADX INFO: loaded from: DrainedsniffercarcassblockRenderer$State.class */
    public static class State extends BlockEntityRenderState {
        public float ageInTicks;
        public Direction facing = Direction.NORTH;
        public final LivingEntityRenderState living = new LivingEntityRenderState();
    }

    public DrainedsniffercarcassblockRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new CustomHierarchicalModel(context.bakeLayer(Modelsniffer_carcass.LAYER_LOCATION));
    }

    /* JADX INFO: renamed from: createRenderState, reason: merged with bridge method [inline-methods] */
    public State createRenderState() {
        return new State();
    }

    public void extractRenderState(DrainedsniffercarcassblockBlockEntity blockEntity, State state, float partialTick, Vec3 cameraPos, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTick, cameraPos, breakProgress);
        int tickCount = (int) blockEntity.getLevel().getGameTime();
        state.ageInTicks = tickCount + partialTick;
        state.living.ageInTicks = state.ageInTicks;
        blockEntity.animationState0.animateWhen(Snifferanimationcondition1Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState1.animateWhen(Snifferanimationcondition2Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState2.animateWhen(Snifferanimationcondition3Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState3.animateWhen(Snifferanimationcondition4Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState4.animateWhen(Snifferanimationcondition5Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState5.animateWhen(Snifferanimationcondition6Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState6.animateWhen(Snifferanimationcondition7Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState7.animateWhen(Snifferanimationcondition8Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState8.animateWhen(Snifferanimationcondition9Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState9.animateWhen(Snifferanimationcondition10Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        state.facing = blockEntity.getBlockState().getValue(DrainedsniffercarcassblockBlock.FACING);
        this.model.setupBlockEntityAnim(blockEntity, state);
    }

    public void submit(State state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        poseStack.translate(-0.5d, -0.5d, 0.5d);
        switch (AnonymousClass1.$SwitchMap$net$minecraft$core$Direction[state.facing.ordinal()]) {
            case 2:
                poseStack.rotateDegrees(Axis.YP, 90.0f);
                break;
            case 3:
                poseStack.rotateDegrees(Axis.YP, -90.0f);
                break;
            case 4:
                poseStack.rotateDegrees(Axis.YP, 180.0f);
                break;
        }
        poseStack.translate(0.0f, -1.0f, 0.0f);
        submitNodeCollector.submitModel(this.model, state.living, poseStack, RenderTypes.entityCutoutCull(this.texture), state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: net.mcreator.butchery.client.renderer.block.DrainedsniffercarcassblockRenderer$1, reason: invalid class name */
    /* JADX INFO: loaded from: DrainedsniffercarcassblockRenderer$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction = new int[Direction.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.WEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: loaded from: DrainedsniffercarcassblockRenderer$CustomHierarchicalModel.class */
    private static final class CustomHierarchicalModel extends Modelsniffer_carcass {
        private final KeyframeAnimation keyframeAnimation0;
        private final KeyframeAnimation keyframeAnimation1;
        private final KeyframeAnimation keyframeAnimation2;
        private final KeyframeAnimation keyframeAnimation3;
        private final KeyframeAnimation keyframeAnimation4;
        private final KeyframeAnimation keyframeAnimation5;
        private final KeyframeAnimation keyframeAnimation6;
        private final KeyframeAnimation keyframeAnimation7;
        private final KeyframeAnimation keyframeAnimation8;
        private final KeyframeAnimation keyframeAnimation9;

        public CustomHierarchicalModel(ModelPart root) {
            super(root);
            this.keyframeAnimation0 = sniffer_idleAnimation.idle.bake(root);
            this.keyframeAnimation1 = sniffer_headlessAnimation.headless.bake(root);
            this.keyframeAnimation2 = sniffer_skinnedAnimation.skinned.bake(root);
            this.keyframeAnimation3 = sniffer_cut_1Animation.cut_1.bake(root);
            this.keyframeAnimation4 = sniffer_cut_2Animation.cut_2.bake(root);
            this.keyframeAnimation5 = hanging_sniffer_anim_idleAnimation.idle.bake(root);
            this.keyframeAnimation6 = hanging_sniffer_anim_headlessAnimation.headless.bake(root);
            this.keyframeAnimation7 = hanging_sniffer_anim_skinnedAnimation.skinned.bake(root);
            this.keyframeAnimation8 = hanging_sniffer_anim_cut_1Animation.cut_1.bake(root);
            this.keyframeAnimation9 = hanging_sniffer_anim_cut_2Animation.cut_2.bake(root);
        }

        public void setupBlockEntityAnim(DrainedsniffercarcassblockBlockEntity blockEntity, State state) {
            root().getAllParts().forEach((v0) -> {
                v0.resetPose();
            });
            this.keyframeAnimation0.apply(blockEntity.animationState0, state.ageInTicks, 1.0f);
            this.keyframeAnimation1.apply(blockEntity.animationState1, state.ageInTicks, 1.0f);
            this.keyframeAnimation2.apply(blockEntity.animationState2, state.ageInTicks, 1.0f);
            this.keyframeAnimation3.apply(blockEntity.animationState3, state.ageInTicks, 1.0f);
            this.keyframeAnimation4.apply(blockEntity.animationState4, state.ageInTicks, 1.0f);
            this.keyframeAnimation5.apply(blockEntity.animationState5, state.ageInTicks, 1.0f);
            this.keyframeAnimation6.apply(blockEntity.animationState6, state.ageInTicks, 1.0f);
            this.keyframeAnimation7.apply(blockEntity.animationState7, state.ageInTicks, 1.0f);
            this.keyframeAnimation8.apply(blockEntity.animationState8, state.ageInTicks, 1.0f);
            this.keyframeAnimation9.apply(blockEntity.animationState9, state.ageInTicks, 1.0f);
            super.setupAnim(state.living);
        }
    }
}
