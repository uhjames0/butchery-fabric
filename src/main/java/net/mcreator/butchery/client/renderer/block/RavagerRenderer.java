package net.mcreator.butchery.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.mcreator.butchery.block.RavagerBlock;
import net.mcreator.butchery.block.entity.RavagerBlockEntity;
import net.mcreator.butchery.client.model.Modelravager;
import net.mcreator.butchery.client.model.animations.ravager_headlessAnimation;
import net.mcreator.butchery.client.model.animations.ravager_leg_1Animation;
import net.mcreator.butchery.client.model.animations.ravager_leg_2Animation;
import net.mcreator.butchery.client.model.animations.ravager_leg_3Animation;
import net.mcreator.butchery.client.model.animations.ravager_leg_4Animation;
import net.mcreator.butchery.procedures.Ravageranimationcondition1Procedure;
import net.mcreator.butchery.procedures.Ravageranimationcondition2Procedure;
import net.mcreator.butchery.procedures.Ravageranimationcondition3Procedure;
import net.mcreator.butchery.procedures.Ravageranimationcondition4Procedure;
import net.mcreator.butchery.procedures.Ravageranimationcondition5Procedure;
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

/* JADX INFO: loaded from: RavagerRenderer.class */
public class RavagerRenderer implements BlockEntityRenderer<RavagerBlockEntity, RavagerRenderer.State> {
    private final CustomHierarchicalModel model;
    private final Identifier texture = Identifier.parse("butchery:textures/block/ravager.png");

    /* JADX INFO: loaded from: RavagerRenderer$State.class */
    public static class State extends BlockEntityRenderState {
        public float ageInTicks;
        public Direction facing = Direction.NORTH;
        public final LivingEntityRenderState living = new LivingEntityRenderState();
    }

    public RavagerRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new CustomHierarchicalModel(context.bakeLayer(Modelravager.LAYER_LOCATION));
    }

    /* JADX INFO: renamed from: createRenderState, reason: merged with bridge method [inline-methods] */
    public State createRenderState() {
        return new State();
    }

    public void extractRenderState(RavagerBlockEntity blockEntity, State state, float partialTick, Vec3 cameraPos, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTick, cameraPos, breakProgress);
        int tickCount = (int) blockEntity.getLevel().getGameTime();
        state.ageInTicks = tickCount + partialTick;
        state.living.ageInTicks = state.ageInTicks;
        blockEntity.animationState0.animateWhen(Ravageranimationcondition1Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState1.animateWhen(Ravageranimationcondition2Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState2.animateWhen(Ravageranimationcondition3Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState3.animateWhen(Ravageranimationcondition4Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        blockEntity.animationState4.animateWhen(Ravageranimationcondition5Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        state.facing = blockEntity.getBlockState().getValue(RavagerBlock.FACING);
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

    /* JADX INFO: renamed from: net.mcreator.butchery.client.renderer.block.RavagerRenderer$1, reason: invalid class name */
    /* JADX INFO: loaded from: RavagerRenderer$1.class */
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

    /* JADX INFO: loaded from: RavagerRenderer$CustomHierarchicalModel.class */
    private static final class CustomHierarchicalModel extends Modelravager {
        private final KeyframeAnimation keyframeAnimation0;
        private final KeyframeAnimation keyframeAnimation1;
        private final KeyframeAnimation keyframeAnimation2;
        private final KeyframeAnimation keyframeAnimation3;
        private final KeyframeAnimation keyframeAnimation4;

        public CustomHierarchicalModel(ModelPart root) {
            super(root);
            this.keyframeAnimation0 = ravager_headlessAnimation.ravager_headless.bake(root);
            this.keyframeAnimation1 = ravager_leg_1Animation.ravager_leg_1.bake(root);
            this.keyframeAnimation2 = ravager_leg_2Animation.ravager_leg_2.bake(root);
            this.keyframeAnimation3 = ravager_leg_3Animation.ravager_leg_3.bake(root);
            this.keyframeAnimation4 = ravager_leg_4Animation.ravager_leg_4.bake(root);
        }

        public void setupBlockEntityAnim(RavagerBlockEntity blockEntity, State state) {
            root().getAllParts().forEach((v0) -> {
                v0.resetPose();
            });
            this.keyframeAnimation0.apply(blockEntity.animationState0, state.ageInTicks, 1.0f);
            this.keyframeAnimation1.apply(blockEntity.animationState1, state.ageInTicks, 1.0f);
            this.keyframeAnimation2.apply(blockEntity.animationState2, state.ageInTicks, 1.0f);
            this.keyframeAnimation3.apply(blockEntity.animationState3, state.ageInTicks, 1.0f);
            this.keyframeAnimation4.apply(blockEntity.animationState4, state.ageInTicks, 1.0f);
            super.setupAnim(state.living);
        }
    }
}
