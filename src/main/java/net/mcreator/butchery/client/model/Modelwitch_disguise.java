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

public class Modelwitch_disguise
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelwitch_disguise"), "main");
    public final ModelPart Head;
    public final ModelPart Body;
    public final ModelPart RightArm;
    public final ModelPart LeftArm;

    public Modelwitch_disguise(ModelPart root) {
        super(root);
        this.Head = root.getChild("Head");
        this.Body = root.getChild("Body");
        this.RightArm = root.getChild("RightArm");
        this.LeftArm = root.getChild("LeftArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition hat4_r1 = Head.addOrReplaceChild("hat4_r1", CubeListBuilder.create().texOffs(0, 95).addBox(-0.5f, -1.0f, -0.5f, 1.0f, 2.0f, 1.0f, new CubeDeformation(0.25f)), PartPose.offsetAndRotation((float)0.0f, (float)-16.2656f, (float)1.9329f, (float)-0.6109f, (float)0.0f, (float)0.0f));
        PartDefinition hat3_r1 = Head.addOrReplaceChild("hat3_r1", CubeListBuilder.create().texOffs(0, 87).addBox(-1.875f, -4.0f, -1.75f, 4.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.125f, (float)-11.85f, (float)0.15f, (float)-0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition hat2_r1 = Head.addOrReplaceChild("hat2_r1", CubeListBuilder.create().texOffs(0, 76).addBox(-3.5f, -2.0f, -3.5f, 7.0f, 4.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.05f, (float)-10.2794f, (float)0.3266f, (float)-0.1575f, (float)-0.0038f, (float)-3.0E-4f));
        PartDefinition headwear_r1 = Head.addOrReplaceChild("headwear_r1", CubeListBuilder.create().texOffs(0, 64).addBox(-5.375f, 4.0f, -5.75f, 10.0f, 2.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.375f, (float)-12.55f, (float)1.05f, (float)-0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(2, 40).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 20.0f, 4.0f, new CubeDeformation(0.25f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(37, 44).addBox(-3.3f, -2.0f, -2.5f, 5.0f, 10.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-5.0f, (float)2.0f, (float)0.0f));
        PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(37, 44).addBox(-1.7f, -2.0f, -2.5f, 5.0f, 10.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)5.0f, (float)2.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)64, (int)128);
    }

    public void setupAnim(LivingEntityRenderState state) {
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
    }
}

