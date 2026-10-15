package net.mcreator.butchery.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.mcreator.butchery.block.SniffercarcassblockBlock;
import net.mcreator.butchery.block.entity.SniffercarcassblockBlockEntity;
import net.mcreator.butchery.client.model.Modelsniffer_carcass;
import net.mcreator.butchery.client.model.animations.hanging_sniffer_anim_idleAnimation;
import net.mcreator.butchery.procedures.Snifferanimationcondition2Procedure;
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

/* JADX INFO: loaded from: SniffercarcassblockRenderer.class */
public class SniffercarcassblockRenderer implements BlockEntityRenderer<SniffercarcassblockBlockEntity, SniffercarcassblockRenderer.State> {
    private final CustomHierarchicalModel model;
    private final Identifier texture = Identifier.parse("butchery:textures/block/sniffer.png");

    /* JADX INFO: loaded from: SniffercarcassblockRenderer$State.class */
    public static class State extends BlockEntityRenderState {
        public float ageInTicks;
        public Direction facing = Direction.NORTH;
        public final LivingEntityRenderState living = new LivingEntityRenderState();
    }

    public SniffercarcassblockRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new CustomHierarchicalModel(context.bakeLayer(Modelsniffer_carcass.LAYER_LOCATION));
    }

    /* JADX INFO: renamed from: createRenderState, reason: merged with bridge method [inline-methods] */
    public State createRenderState() {
        return new State();
    }

    public void extractRenderState(SniffercarcassblockBlockEntity blockEntity, State state, float partialTick, Vec3 cameraPos, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTick, cameraPos, breakProgress);
        int tickCount = (int) blockEntity.getLevel().getGameTime();
        state.ageInTicks = tickCount + partialTick;
        state.living.ageInTicks = state.ageInTicks;
        blockEntity.animationState0.animateWhen(Snifferanimationcondition2Procedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
        state.facing = blockEntity.getBlockState().getValue(SniffercarcassblockBlock.FACING);
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

    /* JADX INFO: renamed from: net.mcreator.butchery.client.renderer.block.SniffercarcassblockRenderer$1, reason: invalid class name */
    /* JADX INFO: loaded from: SniffercarcassblockRenderer$1.class */
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

    /* JADX INFO: loaded from: SniffercarcassblockRenderer$CustomHierarchicalModel.class */
    private static final class CustomHierarchicalModel extends Modelsniffer_carcass {
        private final KeyframeAnimation keyframeAnimation0;

        public CustomHierarchicalModel(ModelPart root) {
            super(root);
            this.keyframeAnimation0 = hanging_sniffer_anim_idleAnimation.idle.bake(root);
        }

        public void setupBlockEntityAnim(SniffercarcassblockBlockEntity blockEntity, State state) {
            root().getAllParts().forEach((v0) -> {
                v0.resetPose();
            });
            this.keyframeAnimation0.apply(blockEntity.animationState0, state.ageInTicks, 1.0f);
            super.setupAnim(state.living);
        }
    }
}
