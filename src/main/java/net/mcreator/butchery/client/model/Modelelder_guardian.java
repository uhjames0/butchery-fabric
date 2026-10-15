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

public class Modelelder_guardian
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelelder_guardian"), "main");
    public final ModelPart bone;
    public final ModelPart body;
    public final ModelPart body_flipped;
    public final ModelPart body_sub_1;
    public final ModelPart bone2;
    public final ModelPart eye;
    public final ModelPart tail1;
    public final ModelPart tail2;
    public final ModelPart tail3;
    public final ModelPart spine1;
    public final ModelPart spine1_rotation;
    public final ModelPart spine2;
    public final ModelPart spine2_rotation;
    public final ModelPart spine3;
    public final ModelPart spine3_rotation;
    public final ModelPart spine4;
    public final ModelPart spine4_rotation;
    public final ModelPart spine5;
    public final ModelPart spine5_rotation;
    public final ModelPart spine6;
    public final ModelPart spine6_rotation;
    public final ModelPart spine7;
    public final ModelPart spine7_rotation;
    public final ModelPart spine8;
    public final ModelPart spine8_rotation;
    public final ModelPart spine9;
    public final ModelPart spine9_rotation;
    public final ModelPart spine10;
    public final ModelPart spine10_rotation;
    public final ModelPart spine11;
    public final ModelPart spine11_rotation;
    public final ModelPart spine12;
    public final ModelPart spine12_rotation;

    public Modelelder_guardian(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
        this.body = this.bone.getChild("body");
        this.body_flipped = this.body.getChild("body_flipped");
        this.body_sub_1 = this.body_flipped.getChild("body_sub_1");
        this.bone2 = this.bone.getChild("bone2");
        this.eye = this.bone.getChild("eye");
        this.tail1 = this.bone.getChild("tail1");
        this.tail2 = this.bone.getChild("tail2");
        this.tail3 = this.bone.getChild("tail3");
        this.spine1 = this.bone.getChild("spine1");
        this.spine1_rotation = this.spine1.getChild("spine1_rotation");
        this.spine2 = this.bone.getChild("spine2");
        this.spine2_rotation = this.spine2.getChild("spine2_rotation");
        this.spine3 = this.bone.getChild("spine3");
        this.spine3_rotation = this.spine3.getChild("spine3_rotation");
        this.spine4 = this.bone.getChild("spine4");
        this.spine4_rotation = this.spine4.getChild("spine4_rotation");
        this.spine5 = this.bone.getChild("spine5");
        this.spine5_rotation = this.spine5.getChild("spine5_rotation");
        this.spine6 = this.bone.getChild("spine6");
        this.spine6_rotation = this.spine6.getChild("spine6_rotation");
        this.spine7 = this.bone.getChild("spine7");
        this.spine7_rotation = this.spine7.getChild("spine7_rotation");
        this.spine8 = this.bone.getChild("spine8");
        this.spine8_rotation = this.spine8.getChild("spine8_rotation");
        this.spine9 = this.bone.getChild("spine9");
        this.spine9_rotation = this.spine9.getChild("spine9_rotation");
        this.spine10 = this.bone.getChild("spine10");
        this.spine10_rotation = this.spine10.getChild("spine10_rotation");
        this.spine11 = this.bone.getChild("spine11");
        this.spine11_rotation = this.spine11.getChild("spine11_rotation");
        this.spine12 = this.bone.getChild("spine12");
        this.spine12_rotation = this.spine12.getChild("spine12_rotation");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.75f, -18.0f, -24.0f, 36.0f, 36.0f, 48.0f, new CubeDeformation(0.0f)).texOffs(48, 120).addBox(-12.75f, -24.0f, -18.0f, 36.0f, 6.0f, 36.0f, new CubeDeformation(0.0f)).texOffs(0, 84).addBox(-18.75f, -18.0f, -18.0f, 6.0f, 36.0f, 36.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-5.25f, (float)-24.0f, (float)0.0f));
        PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(48, 120).addBox(-18.0f, -3.0f, -18.0f, 36.0f, 6.0f, 36.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.25f, (float)21.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-3.1416f));
        PartDefinition body_flipped = body.addOrReplaceChild("body_flipped", CubeListBuilder.create(), PartPose.offset((float)5.25f, (float)24.0f, (float)0.0f));
        PartDefinition body_sub_1 = body_flipped.addOrReplaceChild("body_sub_1", CubeListBuilder.create().texOffs(0, 84).mirror().addBox(18.0f, -42.0f, -18.0f, 6.0f, 36.0f, 36.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(54, 126).addBox(-9.0f, -27.0f, -24.0f, 18.0f, 9.0f, 48.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)3.0f));
        PartDefinition eye = bone.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0f, -3.0f, -1.5f, 6.0f, 6.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-22.5f, (float)-23.25f));
        PartDefinition tail1 = bone.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(120, 0).addBox(-6.0f, -6.0f, -12.0f, 12.0f, 12.0f, 24.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)33.0f));
        PartDefinition tail2 = bone.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 162).addBox(-4.5f, -4.5f, -10.5f, 9.0f, 9.0f, 21.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)52.5f));
        PartDefinition tail3 = bone.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(123, 96).addBox(-3.75f, -3.0f, -15.75f, 6.0f, 6.0f, 18.0f, new CubeDeformation(0.0f)).texOffs(75, 57).addBox(-0.75f, -13.5f, -6.75f, 0.0f, 27.0f, 27.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.75f, (float)-24.0f, (float)75.75f));
        PartDefinition tail3_r1 = tail3.addOrReplaceChild("tail3_r1", CubeListBuilder.create().texOffs(75, 57).addBox(0.0f, -13.5f, -13.5f, 0.0f, 27.0f, 27.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.75f, (float)0.0f, (float)6.75f, (float)0.0f, (float)0.0f, (float)-3.1416f));
        PartDefinition spine1 = bone.addOrReplaceChild("spine1", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine1_rotation = spine1.addOrReplaceChild("spine1_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-45.0f, (float)21.0f, (float)-0.7854f, (float)0.0f, (float)0.0f));
        PartDefinition spine2 = bone.addOrReplaceChild("spine2", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine2_rotation = spine2.addOrReplaceChild("spine2_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-45.0f, (float)-21.0f, (float)0.7854f, (float)0.0f, (float)0.0f));
        PartDefinition spine3 = bone.addOrReplaceChild("spine3", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine3_rotation = spine3.addOrReplaceChild("spine3_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)21.0f, (float)-45.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition spine4 = bone.addOrReplaceChild("spine4", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine4_rotation = spine4.addOrReplaceChild("spine4_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-21.0f, (float)-45.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition spine5 = bone.addOrReplaceChild("spine5", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine5_rotation = spine5.addOrReplaceChild("spine5_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-21.0f, (float)-24.0f, (float)-21.0f, (float)1.5708f, (float)0.7854f, (float)0.0f));
        PartDefinition spine6 = bone.addOrReplaceChild("spine6", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine6_rotation = spine6.addOrReplaceChild("spine6_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)21.0f, (float)-24.0f, (float)-21.0f, (float)1.5708f, (float)-0.7854f, (float)0.0f));
        PartDefinition spine7 = bone.addOrReplaceChild("spine7", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine7_rotation = spine7.addOrReplaceChild("spine7_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)21.0f, (float)-24.0f, (float)21.0f, (float)-1.5708f, (float)0.7854f, (float)0.0f));
        PartDefinition spine8 = bone.addOrReplaceChild("spine8", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine8_rotation = spine8.addOrReplaceChild("spine8_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-21.0f, (float)-24.0f, (float)21.0f, (float)-1.5708f, (float)-0.7854f, (float)0.0f));
        PartDefinition spine9 = bone.addOrReplaceChild("spine9", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine9_rotation = spine9.addOrReplaceChild("spine9_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-3.0f, (float)21.0f, (float)-2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition spine10 = bone.addOrReplaceChild("spine10", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine10_rotation = spine10.addOrReplaceChild("spine10_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-3.0f, (float)-21.0f, (float)2.3562f, (float)0.0f, (float)0.0f));
        PartDefinition spine11 = bone.addOrReplaceChild("spine11", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine11_rotation = spine11.addOrReplaceChild("spine11_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)21.0f, (float)-3.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)2.3562f));
        PartDefinition spine12 = bone.addOrReplaceChild("spine12", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition spine12_rotation = spine12.addOrReplaceChild("spine12_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -6.0f, -3.0f, 6.0f, 27.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-21.0f, (float)-3.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-2.3562f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)192, (int)192);
    }

    public void setupAnim(LivingEntityRenderState state) {
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
    }
}

