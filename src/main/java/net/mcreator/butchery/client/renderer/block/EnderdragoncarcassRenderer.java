package net.mcreator.butchery.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.mcreator.butchery.block.EnderdragoncarcassBlock;
import net.mcreator.butchery.block.entity.EnderdragoncarcassBlockEntity;
import net.mcreator.butchery.client.model.Modelender_dragon;
import net.mcreator.butchery.client.model.animations.dragon_cut_10Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_11Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_12Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_13Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_14Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_15Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_1Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_2Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_3Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_4Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_5Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_6Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_7Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_8Animation;
import net.mcreator.butchery.client.model.animations.dragon_cut_9Animation;
import net.mcreator.butchery.client.model.animations.dragon_headlessAnimation;
import net.mcreator.butchery.client.model.animations.end_dragonAnimation;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition10Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition11Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition12Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition13Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition14Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition15Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition1Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition2Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition3Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition4Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition5Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition6Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition7Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition8Procedure;
import net.mcreator.butchery.procedures.Enderdragonanimationcondition9Procedure;
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

/* JADX INFO: loaded from: EnderdragoncarcassRenderer.class */
public class EnderdragoncarcassRenderer implements BlockEntityRenderer<EnderdragoncarcassBlockEntity, EnderdragoncarcassRenderer.State> {
    private final CustomHierarchicalModel model;
    private final Identifier texture = Identifier.parse("butchery:textures/block/dragon.png");

    /* JADX INFO: loaded from: EnderdragoncarcassRenderer$State.class */
    public static class State extends BlockEntityRenderState {
        public float ageInTicks;
        public Direction facing = Direction.NORTH;
        public final LivingEntityRenderState living = new LivingEntityRenderState();
    }

    public EnderdragoncarcassRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new CustomHierarchicalModel(context.bakeLayer(Modelender_dragon.LAYER_LOCATION));
    }

    /* JADX INFO: renamed from: createRenderState, reason: merged with bridge method [inline-methods] */
    public State createRenderState() {
        return new State();
    }

    public void extractRenderState(EnderdragoncarcassBlockEntity blockEntity, State state, float partialTick, Vec3 cameraPos, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTick, cameraPos, breakProgress);
        int tickCount = (int) blockEntity.getLevel().getGameTime();
        state.ageInTicks = tickCount + partialTick;
        state.living.ageInTicks = state.ageInTicks;
        blockEntity.animationState0.animateWhen(true, tickCount);
        blockEntity.animationState1.animateWhen(Enderdragonanimationcondition1Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState2.animateWhen(Enderdragonanimationcondition2Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState3.animateWhen(Enderdragonanimationcondition3Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState4.animateWhen(Enderdragonanimationcondition4Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState5.animateWhen(Enderdragonanimationcondition5Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState6.animateWhen(Enderdragonanimationcondition6Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState7.animateWhen(Enderdragonanimationcondition7Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState8.animateWhen(Enderdragonanimationcondition8Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState9.animateWhen(Enderdragonanimationcondition9Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState10.animateWhen(Enderdragonanimationcondition10Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState11.animateWhen(Enderdragonanimationcondition11Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState12.animateWhen(Enderdragonanimationcondition12Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState13.animateWhen(Enderdragonanimationcondition12Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState14.animateWhen(Enderdragonanimationcondition13Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState15.animateWhen(Enderdragonanimationcondition14Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState16.animateWhen(Enderdragonanimationcondition15Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        state.facing = blockEntity.getBlockState().getValue(EnderdragoncarcassBlock.FACING);
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

    /* JADX INFO: renamed from: net.mcreator.butchery.client.renderer.block.EnderdragoncarcassRenderer$1, reason: invalid class name */
    /* JADX INFO: loaded from: EnderdragoncarcassRenderer$1.class */
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

    /* JADX INFO: loaded from: EnderdragoncarcassRenderer$CustomHierarchicalModel.class */
    private static final class CustomHierarchicalModel extends Modelender_dragon {
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
        private final KeyframeAnimation keyframeAnimation10;
        private final KeyframeAnimation keyframeAnimation11;
        private final KeyframeAnimation keyframeAnimation12;
        private final KeyframeAnimation keyframeAnimation13;
        private final KeyframeAnimation keyframeAnimation14;
        private final KeyframeAnimation keyframeAnimation15;
        private final KeyframeAnimation keyframeAnimation16;

        public CustomHierarchicalModel(ModelPart root) {
            super(root);
            this.keyframeAnimation0 = end_dragonAnimation.ender_dragon.bake(root);
            this.keyframeAnimation1 = dragon_headlessAnimation.dragon_headless.bake(root);
            this.keyframeAnimation2 = dragon_cut_1Animation.dragon_cut_1.bake(root);
            this.keyframeAnimation3 = dragon_cut_2Animation.dragon_cut_2.bake(root);
            this.keyframeAnimation4 = dragon_cut_3Animation.dragon_cut_3.bake(root);
            this.keyframeAnimation5 = dragon_cut_4Animation.dragon_cut_4.bake(root);
            this.keyframeAnimation6 = dragon_cut_5Animation.dragon_cut_5.bake(root);
            this.keyframeAnimation7 = dragon_cut_6Animation.dragon_cut_6.bake(root);
            this.keyframeAnimation8 = dragon_cut_7Animation.dragon_cut_7.bake(root);
            this.keyframeAnimation9 = dragon_cut_8Animation.dragon_cut_8.bake(root);
            this.keyframeAnimation10 = dragon_cut_9Animation.dragon_cut_9.bake(root);
            this.keyframeAnimation11 = dragon_cut_10Animation.dragon_cut_10.bake(root);
            this.keyframeAnimation12 = dragon_cut_11Animation.dragon_cut_11.bake(root);
            this.keyframeAnimation13 = dragon_cut_12Animation.dragon_cut_12.bake(root);
            this.keyframeAnimation14 = dragon_cut_13Animation.dragon_cut_13.bake(root);
            this.keyframeAnimation15 = dragon_cut_14Animation.dragon_cut_14.bake(root);
            this.keyframeAnimation16 = dragon_cut_15Animation.dragon_cut_15.bake(root);
        }

        public void setupBlockEntityAnim(EnderdragoncarcassBlockEntity blockEntity, State state) {
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
            this.keyframeAnimation10.apply(blockEntity.animationState10, state.ageInTicks, 1.0f);
            this.keyframeAnimation11.apply(blockEntity.animationState11, state.ageInTicks, 1.0f);
            this.keyframeAnimation12.apply(blockEntity.animationState12, state.ageInTicks, 1.0f);
            this.keyframeAnimation13.apply(blockEntity.animationState13, state.ageInTicks, 1.0f);
            this.keyframeAnimation14.apply(blockEntity.animationState14, state.ageInTicks, 1.0f);
            this.keyframeAnimation15.apply(blockEntity.animationState15, state.ageInTicks, 1.0f);
            this.keyframeAnimation16.apply(blockEntity.animationState16, state.ageInTicks, 1.0f);
            super.setupAnim(state.living);
        }
    }
}
