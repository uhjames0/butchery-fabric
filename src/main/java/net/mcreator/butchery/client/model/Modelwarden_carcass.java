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

public class Modelwarden_carcass
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelwarden_carcass"), "main");
    public final ModelPart bone;
    public final ModelPart right_arm;
    public final ModelPart bone2;
    public final ModelPart head;
    public final ModelPart left_tendril;
    public final ModelPart right_tendril;
    public final ModelPart torso;
    public final ModelPart left_ribcage;
    public final ModelPart right_ribcage;
    public final ModelPart left_arm;
    public final ModelPart left_leg;
    public final ModelPart right_leg;

    public Modelwarden_carcass(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
        this.right_arm = this.bone.getChild("right_arm");
        this.bone2 = this.bone.getChild("bone2");
        this.head = this.bone2.getChild("head");
        this.left_tendril = this.bone2.getChild("left_tendril");
        this.right_tendril = this.bone2.getChild("right_tendril");
        this.torso = this.bone.getChild("torso");
        this.left_ribcage = this.bone.getChild("left_ribcage");
        this.right_ribcage = this.bone.getChild("right_ribcage");
        this.left_arm = this.bone.getChild("left_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)18.0f, (float)2.0f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = bone.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(44, 50).addBox(-4.0f, -7.0f, -4.0f, 8.0f, 28.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-13.0f, (float)-14.0f, (float)0.0f, (float)-0.5236f, (float)0.0f, (float)0.0f));
        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-19.2f, (float)-1.0f, (float)0.3927f, (float)0.0f, (float)0.0f));
        PartDefinition head = bone2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 32).addBox(-8.0f, -16.0f, -5.0f, 16.0f, 16.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_tendril = bone2.addOrReplaceChild("left_tendril", CubeListBuilder.create().texOffs(58, 0).addBox(-8.0f, -16.0f, 0.0f, 16.0f, 16.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)16.0f, (float)-9.0f, (float)1.0f));
        PartDefinition right_tendril = bone2.addOrReplaceChild("right_tendril", CubeListBuilder.create().texOffs(52, 32).addBox(-8.0f, -16.0f, 0.0f, 16.0f, 16.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-16.0f, (float)-9.0f, (float)1.0f));
        PartDefinition torso = bone.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-22.0f, -17.5f, -5.5f, 18.0f, 21.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offset((float)13.0f, (float)-3.5f, (float)0.5f));
        PartDefinition left_ribcage = bone.addOrReplaceChild("left_ribcage", CubeListBuilder.create().texOffs(90, 11).mirror().addBox(-17.5f, -17.5f, 0.0f, 9.0f, 21.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)17.5f, (float)-3.5f, (float)-5.1f));
        PartDefinition right_ribcage = bone.addOrReplaceChild("right_ribcage", CubeListBuilder.create().texOffs(90, 11).addBox(-17.5f, -17.5f, 0.0f, 9.0f, 21.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)8.5f, (float)-3.5f, (float)-5.1f));
        PartDefinition left_arm = bone.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 58).addBox(-4.0f, -7.0f, -4.0f, 8.0f, 28.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)13.0f, (float)-14.0f, (float)0.0f, (float)-0.5236f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset((float)6.0f, (float)18.0f, (float)1.0f));
        PartDefinition left_leg_r1 = left_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(76, 76).addBox(3.1f, -2.5f, -3.0f, 6.0f, 13.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-7.0f, (float)3.0f, (float)0.5f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset((float)-6.0f, (float)18.0f, (float)1.0f));
        PartDefinition right_leg_r1 = right_leg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(76, 48).addBox(-9.1f, -2.5f, -3.0f, 6.0f, 13.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.0f, (float)3.0f, (float)0.5f, (float)-1.5708f, (float)0.0f, (float)0.0f));
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

