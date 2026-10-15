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

public class Modelsniffer_carcass
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelsniffer_carcass"), "main");
    public final ModelPart bone9;
    public final ModelPart head;
    public final ModelPart lower_beak;
    public final ModelPart nose;
    public final ModelPart left_ear;
    public final ModelPart right_ear;
    public final ModelPart body;
    public final ModelPart bone4;
    public final ModelPart bone2;
    public final ModelPart bone8;
    public final ModelPart bone7;
    public final ModelPart bone3;
    public final ModelPart bone;
    public final ModelPart bone5;
    public final ModelPart front_left_leg;
    public final ModelPart front_right_leg;
    public final ModelPart middle_left_leg;
    public final ModelPart middle_right_leg;
    public final ModelPart back_left_leg;
    public final ModelPart back_right_leg;
    public final ModelPart bone6;
    public final ModelPart front_left_leg2;
    public final ModelPart front_right_leg2;
    public final ModelPart middle_left_leg2;
    public final ModelPart middle_right_leg2;
    public final ModelPart back_left_leg2;
    public final ModelPart back_right_leg2;

    public Modelsniffer_carcass(ModelPart root) {
        super(root);
        this.bone9 = root.getChild("bone9");
        this.head = this.bone9.getChild("head");
        this.lower_beak = this.head.getChild("lower_beak");
        this.nose = this.head.getChild("nose");
        this.left_ear = this.head.getChild("left_ear");
        this.right_ear = this.head.getChild("right_ear");
        this.body = this.bone9.getChild("body");
        this.bone4 = this.body.getChild("bone4");
        this.bone2 = this.body.getChild("bone2");
        this.bone8 = this.bone2.getChild("bone8");
        this.bone7 = this.bone2.getChild("bone7");
        this.bone3 = this.bone2.getChild("bone3");
        this.bone = this.body.getChild("bone");
        this.bone5 = this.bone9.getChild("bone5");
        this.front_left_leg = this.bone5.getChild("front_left_leg");
        this.front_right_leg = this.bone5.getChild("front_right_leg");
        this.middle_left_leg = this.bone5.getChild("middle_left_leg");
        this.middle_right_leg = this.bone5.getChild("middle_right_leg");
        this.back_left_leg = this.bone5.getChild("back_left_leg");
        this.back_right_leg = this.bone5.getChild("back_right_leg");
        this.bone6 = this.bone9.getChild("bone6");
        this.front_left_leg2 = this.bone6.getChild("front_left_leg2");
        this.front_right_leg2 = this.bone6.getChild("front_right_leg2");
        this.middle_left_leg2 = this.bone6.getChild("middle_left_leg2");
        this.middle_right_leg2 = this.bone6.getChild("middle_right_leg2");
        this.back_left_leg2 = this.bone6.getChild("back_left_leg2");
        this.back_right_leg2 = this.bone6.getChild("back_right_leg2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bone9 = partdefinition.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-4.0f, (float)14.125f, (float)-1.875f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition head = bone9.addOrReplaceChild("head", CubeListBuilder.create().texOffs(8, 4).addBox(-6.5f, 7.5f, -11.5f, 13.0f, 0.0f, 11.0f, new CubeDeformation(0.0f)).texOffs(8, 15).addBox(-6.5f, -7.5f, -11.5f, 13.0f, 18.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-2.625f, (float)-14.625f));
        PartDefinition lower_beak = head.addOrReplaceChild("lower_beak", CubeListBuilder.create().texOffs(10, 57).addBox(-6.5f, -7.0f, -8.0f, 13.0f, 12.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)2.5f, (float)-12.5f));
        PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(10, 45).addBox(-6.5f, -2.0f, -9.0f, 13.0f, 2.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-4.5f, (float)-11.5f));
        PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(2, 0).addBox(0.0f, 0.0f, -3.0f, 1.0f, 19.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offset((float)6.51f, (float)-7.5f, (float)-4.5f));
        PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0f, 0.0f, -3.0f, 1.0f, 19.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-6.51f, (float)-7.5f, (float)-4.5f));
        PartDefinition body = bone9.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-9.125f, (float)4.875f));
        PartDefinition bone4 = body.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(62, 68).addBox(-12.5f, -17.5f, -20.0f, 25.0f, 29.0f, 40.0f, new CubeDeformation(0.0f)).texOffs(62, 0).addBox(-12.5f, -17.5f, -20.0f, 25.0f, 24.0f, 40.0f, new CubeDeformation(0.5f)).texOffs(87, 68).addBox(-12.5f, 8.5f, -20.0f, 25.0f, 0.0f, 40.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)3.5f, (float)0.0f));
        PartDefinition bone2 = body.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(78, 326).addBox(-9.5f, -33.0f, -19.0f, 19.0f, 20.0f, 38.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)20.0f, (float)0.0f));
        PartDefinition bone8 = bone2.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 295).addBox(-12.5f, -32.0f, 8.0f, 24.0f, 25.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.5f, (float)-1.5f, (float)0.5f));
        PartDefinition bone7 = bone2.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 256).addBox(-12.0f, -12.5f, -7.0f, 24.0f, 25.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-21.0f, (float)-12.5f));
        PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(76, 256).addBox(-12.0f, -12.5f, -7.0f, 24.0f, 25.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-21.0f, (float)1.5f));
        PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)19.0f, (float)0.0f));
        PartDefinition bone5 = bone9.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)5.875f, (float)4.875f));
        PartDefinition front_left_leg = bone5.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(0, 87).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.5f, (float)0.0f, (float)-15.0f, (float)-1.5708f, (float)-0.7854f, (float)0.0f));
        PartDefinition front_right_leg = bone5.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(32, 87).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-7.5f, (float)0.0f, (float)-15.0f, (float)-1.5708f, (float)0.6545f, (float)0.0f));
        PartDefinition middle_left_leg = bone5.addOrReplaceChild("middle_left_leg", CubeListBuilder.create().texOffs(0, 105).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.5f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)-0.6981f, (float)0.0f));
        PartDefinition middle_right_leg = bone5.addOrReplaceChild("middle_right_leg", CubeListBuilder.create().texOffs(32, 105).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-7.5f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)0.4363f, (float)0.0f));
        PartDefinition back_left_leg = bone5.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(0, 123).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.5f, (float)0.0f, (float)15.0f, (float)-1.5708f, (float)-0.9599f, (float)0.0f));
        PartDefinition back_right_leg = bone5.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(32, 123).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-7.5f, (float)0.0f, (float)15.0f, (float)-1.5708f, (float)0.9599f, (float)0.0f));
        PartDefinition bone6 = bone9.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)5.875f, (float)4.875f));
        PartDefinition front_left_leg2 = bone6.addOrReplaceChild("front_left_leg2", CubeListBuilder.create().texOffs(0, 199).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.5f, (float)0.0f, (float)-15.0f, (float)-1.5708f, (float)-0.7854f, (float)0.0f));
        PartDefinition front_right_leg2 = bone6.addOrReplaceChild("front_right_leg2", CubeListBuilder.create().texOffs(32, 199).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-7.5f, (float)0.0f, (float)-15.0f, (float)-1.5708f, (float)0.6545f, (float)0.0f));
        PartDefinition middle_left_leg2 = bone6.addOrReplaceChild("middle_left_leg2", CubeListBuilder.create().texOffs(0, 217).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.5f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)-0.6981f, (float)0.0f));
        PartDefinition middle_right_leg2 = bone6.addOrReplaceChild("middle_right_leg2", CubeListBuilder.create().texOffs(32, 217).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-7.5f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)0.4363f, (float)0.0f));
        PartDefinition back_left_leg2 = bone6.addOrReplaceChild("back_left_leg2", CubeListBuilder.create().texOffs(0, 235).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.5f, (float)0.0f, (float)15.0f, (float)-1.5708f, (float)-0.9599f, (float)0.0f));
        PartDefinition back_right_leg2 = bone6.addOrReplaceChild("back_right_leg2", CubeListBuilder.create().texOffs(32, 235).addBox(-3.5f, -5.0f, -4.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-7.5f, (float)0.0f, (float)15.0f, (float)-1.5708f, (float)0.9599f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)192, (int)384);
    }

    public void setupAnim(LivingEntityRenderState state) {
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
    }
}

