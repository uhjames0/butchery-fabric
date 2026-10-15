package net.mcreator.butchery.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class Modelwither
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelwither"), "main");
    public final ModelPart bone;
    public final ModelPart head1;
    public final ModelPart head2;
    public final ModelPart head3;
    public final ModelPart body1;
    public final ModelPart body2;
    public final ModelPart body3;

    public Modelwither(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
        this.head1 = this.bone.getChild("head1");
        this.head2 = this.bone.getChild("head2");
        this.head3 = this.bone.getChild("head3");
        this.body1 = this.bone.getChild("body1");
        this.body2 = this.bone.getChild("body2");
        this.body3 = this.bone.getChild("body3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation((float)26.0f, (float)20.0f, (float)-1.5f, (float)0.0f, (float)1.5708f, (float)-1.4835f));
        PartDefinition head1 = bone.addOrReplaceChild("head1", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-48.0f, (float)0.0f));
        PartDefinition head1_r1 = head1.addOrReplaceChild("head1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3054f, (float)0.0f));
        PartDefinition head2 = bone.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset((float)-18.0f, (float)-42.0f, (float)-2.0f));
        PartDefinition head2_r1 = head2.addOrReplaceChild("head2_r1", CubeListBuilder.create().texOffs(64, 0).addBox(-6.0f, -6.0f, -6.0f, 12.0f, 12.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-10.0f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.829f));
        PartDefinition head3 = bone.addOrReplaceChild("head3", CubeListBuilder.create(), PartPose.offset((float)18.0f, (float)-42.0f, (float)-2.0f));
        PartDefinition head3_r1 = head3.addOrReplaceChild("head3_r1", CubeListBuilder.create().texOffs(64, 0).addBox(-6.0f, -6.0f, -6.0f, 12.0f, 12.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)-6.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3927f));
        PartDefinition body1 = bone.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 32).addBox(-20.0f, -2.6514f, -6.9848f, 40.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-37.2f, (float)2.0f));
        PartDefinition body2 = bone.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 44).addBox(-3.0f, -9.6514f, -6.9848f, 6.0f, 20.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(48, 44).addBox(-11.0f, 3.3486f, -5.9848f, 22.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-1.0f, (float)-24.2f, (float)2.0f));
        PartDefinition body2_r1 = body2.addOrReplaceChild("body2_r1", CubeListBuilder.create().texOffs(48, 44).addBox(-11.0f, -2.0f, -2.0f, 22.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.3486f, (float)-3.9848f, (float)0.0f, (float)-0.0873f, (float)0.0f));
        PartDefinition body2_r2 = body2.addOrReplaceChild("body2_r2", CubeListBuilder.create().texOffs(48, 44).addBox(-11.0f, -2.0f, -2.0f, 22.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-4.6514f, (float)-3.9848f, (float)0.0f, (float)0.0873f, (float)0.0f));
        PartDefinition body3 = bone.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(24, 44).addBox(-3.0f, 0.0f, -3.0f, 6.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-13.8514f, (float)-1.9848f, (float)0.0873f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(LivingEntityRenderState state) {
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
    }
}

