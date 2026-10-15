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

public class Modelwolf_fur_suit
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelwolf_fur_suit"), "main");
    public final ModelPart Head;
    public final ModelPart Body;
    public final ModelPart RightArm;
    public final ModelPart LeftArm;
    public final ModelPart RightLeg;
    public final ModelPart LeftLeg;
    public final ModelPart LeftBoot;
    public final ModelPart RightBoot;

    public Modelwolf_fur_suit(ModelPart root) {
        super(root);
        this.Head = root.getChild("Head");
        this.Body = root.getChild("Body");
        this.RightArm = root.getChild("RightArm");
        this.LeftArm = root.getChild("LeftArm");
        this.RightLeg = root.getChild("RightLeg");
        this.LeftLeg = root.getChild("LeftLeg");
        this.LeftBoot = root.getChild("LeftBoot");
        this.RightBoot = root.getChild("RightBoot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(16, 42).addBox(-4.5f, -8.5f, -4.3f, 9.0f, 9.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(25, 0).addBox(-1.0f, -3.0f, -6.0f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 22).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(16, 16).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.25f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(41, 15).addBox(-3.75f, -2.0f, -2.5f, 5.0f, 12.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(19, 32).addBox(-4.25f, 6.0f, -3.0f, 6.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-5.0f, (float)2.0f, (float)0.0f));
        PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(41, 15).addBox(-1.25f, -2.0f, -2.5f, 5.0f, 12.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(19, 32).addBox(-1.75f, 6.0f, -3.0f, 6.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)5.0f, (float)2.0f, (float)0.0f));
        PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-1.9f, (float)12.0f, (float)0.0f));
        PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(0, 48).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)1.9f, (float)12.0f, (float)0.0f));
        PartDefinition LeftBoot = partdefinition.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.75f)).mirror(false), PartPose.offset((float)1.9f, (float)12.0f, (float)0.0f));
        PartDefinition RightBoot = partdefinition.addOrReplaceChild("RightBoot", CubeListBuilder.create(), PartPose.offset((float)-1.9f, (float)12.0f, (float)0.0f));
        PartDefinition right_shoe_r1 = RightBoot.addOrReplaceChild("right_shoe_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0f, -6.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.75f)), PartPose.offsetAndRotation((float)0.0f, (float)6.0f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
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

