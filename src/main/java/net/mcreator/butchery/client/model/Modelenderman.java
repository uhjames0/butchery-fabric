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

public class Modelenderman
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelenderman"), "main");
    public final ModelPart bone;
    public final ModelPart body;
    public final ModelPart bone2;
    public final ModelPart bone5;
    public final ModelPart bone6;
    public final ModelPart bone3;
    public final ModelPart bone4;
    public final ModelPart head;
    public final ModelPart headwear;
    public final ModelPart right_arm;
    public final ModelPart left_arm;
    public final ModelPart right_leg;
    public final ModelPart left_leg;

    public Modelenderman(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
        this.body = this.bone.getChild("body");
        this.bone2 = this.body.getChild("bone2");
        this.bone5 = this.bone2.getChild("bone5");
        this.bone6 = this.bone2.getChild("bone6");
        this.bone3 = this.body.getChild("bone3");
        this.bone4 = this.bone3.getChild("bone4");
        this.head = this.bone.getChild("head");
        this.headwear = this.bone.getChild("headwear");
        this.right_arm = this.bone.getChild("right_arm");
        this.left_arm = this.bone.getChild("left_arm");
        this.right_leg = this.bone.getChild("right_leg");
        this.left_leg = this.bone.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)10.0f, (float)6.0f));
        PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone2 = body.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(32, 16).addBox(-3.8333f, -6.5f, -1.6667f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.1667f, (float)6.5f, (float)-0.3333f));
        PartDefinition bone5 = bone2.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(29, 34).addBox(-3.5f, -4.0f, 0.0f, 7.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.3333f, (float)-1.5f, (float)0.3333f));
        PartDefinition bone6 = bone2.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(30, 45).addBox(-4.0f, -2.5f, 0.0f, 8.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.1667f, (float)2.0f, (float)-0.6667f));
        PartDefinition bone3 = body.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(2, 36).addBox(-3.0083f, -5.9792f, -1.9833f, 6.0f, 10.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(32, 0).addBox(-4.0083f, 4.6958f, -2.2833f, 8.0f, 0.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-3.9333f, -6.9792f, -2.2833f, 0.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(3.9667f, -6.9792f, -2.2833f, 0.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(36, 4).addBox(-4.0083f, -6.9792f, 1.6167f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0083f, (float)6.9792f, (float)0.2833f));
        PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(24, 49).addBox(-4.0f, -5.0f, -2.0f, 8.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.0083f, (float)-0.9792f, (float)-0.2833f));
        PartDefinition head = bone.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-3.4641f, (float)-2.0f));
        PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)3.4641f, (float)2.0f, (float)0.5236f, (float)0.0f, (float)0.0f));
        PartDefinition headwear = bone.addOrReplaceChild("headwear", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = bone.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-5.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)0.1745f, (float)0.0f));
        PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(56, 15).addBox(-1.0f, -1.0f, 4.0f, 2.0f, 15.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.975f, (float)11.6f, (float)-7.125f, (float)-1.5708f, (float)0.0f, (float)1.5708f));
        PartDefinition right_arm_r2 = right_arm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0f, -1.0f, 4.0f, 2.0f, 15.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)-1.0472f, (float)1.5708f));
        PartDefinition left_arm = bone.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offsetAndRotation((float)5.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)-0.1309f, (float)0.0f));
        PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(56, 15).mirror().addBox(-1.0f, -1.0f, 4.0f, 2.0f, 15.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-4.975f, (float)11.6f, (float)-7.125f, (float)-1.5708f, (float)0.0f, (float)-1.5708f));
        PartDefinition left_arm_r2 = left_arm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(56, 0).mirror().addBox(-1.0f, -1.0f, 4.0f, 2.0f, 15.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-5.0f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)1.0472f, (float)-1.5708f));
        PartDefinition right_leg = bone.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0f, -15.0f, -1.0f, 2.0f, 30.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0f, (float)13.0f, (float)-13.2f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg = bone.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(56, 0).mirror().addBox(-1.0f, -3.0f, -1.0f, 2.0f, 30.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.0f, (float)12.9f, (float)-1.2f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(LivingEntityRenderState state) {
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
    }
}

