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

public class Modeldragon_armor
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modeldragon_armor"), "main");
    public final ModelPart Helmet;
    public final ModelPart Chestplate;
    public final ModelPart LeftPlate;
    public final ModelPart RightPlate;
    public final ModelPart LeftLegging;
    public final ModelPart RightLegging;
    public final ModelPart LeftBoot;
    public final ModelPart RightBoot;

    public Modeldragon_armor(ModelPart root) {
        super(root);
        this.Helmet = root.getChild("Helmet");
        this.Chestplate = root.getChild("Chestplate");
        this.LeftPlate = root.getChild("LeftPlate");
        this.RightPlate = root.getChild("RightPlate");
        this.LeftLegging = root.getChild("LeftLegging");
        this.RightLegging = root.getChild("RightLegging");
        this.LeftBoot = root.getChild("LeftBoot");
        this.RightBoot = root.getChild("RightBoot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Helmet2 = partdefinition.addOrReplaceChild("Helmet", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -7.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(1.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition CenterFrontSpike_r1 = Helmet2.addOrReplaceChild("CenterFrontSpike_r1", CubeListBuilder.create().texOffs(48, 40).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-9.25f, (float)-1.8f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        PartDefinition CenterBackSpike_r1 = Helmet2.addOrReplaceChild("CenterBackSpike_r1", CubeListBuilder.create().texOffs(48, 40).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-8.25f, (float)3.2f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        PartDefinition LeftHeadSpike_r1 = Helmet2.addOrReplaceChild("LeftHeadSpike_r1", CubeListBuilder.create().texOffs(43, 52).addBox(-3.5f, -3.5f, 0.0f, 7.0f, 9.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)6.2f, (float)-8.5f, (float)0.0f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition RightHeadSpike_r1 = Helmet2.addOrReplaceChild("RightHeadSpike_r1", CubeListBuilder.create().texOffs(43, 52).mirror().addBox(-3.5f, -3.5f, 0.0f, 7.0f, 9.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-6.2f, (float)-8.5f, (float)0.0f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition Chestplate2 = partdefinition.addOrReplaceChild("Chestplate", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.75f)).texOffs(16, 38).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.5f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition LeftPlate = partdefinition.addOrReplaceChild("LeftPlate", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0f, -2.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.75f)).mirror(false), PartPose.offset((float)5.0f, (float)2.0f, (float)0.0f));
        PartDefinition LeftSpikeEight_r1 = LeftPlate.addOrReplaceChild("LeftSpikeEight_r1", CubeListBuilder.create().texOffs(48, 40).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.2f, (float)3.2f, (float)1.0f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition LeftSpikeSix_r1 = LeftPlate.addOrReplaceChild("LeftSpikeSix_r1", CubeListBuilder.create().texOffs(47, 37).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0f, (float)-0.2f, (float)3.2f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition LeftSpikeFive_r1 = LeftPlate.addOrReplaceChild("LeftSpikeFive_r1", CubeListBuilder.create().texOffs(48, 40).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0f, (float)-3.2f, (float)5.2f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition LeftSpikeFour_r1 = LeftPlate.addOrReplaceChild("LeftSpikeFour_r1", CubeListBuilder.create().texOffs(48, 40).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.1f, (float)-3.2f, (float)3.0f, (float)0.0f, (float)2.3998f, (float)0.0f));
        PartDefinition LeftSpikeThree_r1 = LeftPlate.addOrReplaceChild("LeftSpikeThree_r1", CubeListBuilder.create().texOffs(48, 40).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0f, (float)-0.2f, (float)-4.175f, (float)0.0f, (float)-1.5752f, (float)0.0f));
        PartDefinition LeftSpikeTwo_r1 = LeftPlate.addOrReplaceChild("LeftSpikeTwo_r1", CubeListBuilder.create().texOffs(48, 40).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.1f, (float)-2.2f, (float)-3.075f, (float)0.0f, (float)-2.3562f, (float)0.0f));
        PartDefinition LeftSpikeOne_r1 = LeftPlate.addOrReplaceChild("LeftSpikeOne_r1", CubeListBuilder.create().texOffs(48, 40).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.2f, (float)-2.2f, (float)0.0f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition RightPlate = partdefinition.addOrReplaceChild("RightPlate", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0f, -2.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.75f)), PartPose.offset((float)-5.0f, (float)2.0f, (float)0.0f));
        PartDefinition RightSpikeEight_r1 = RightPlate.addOrReplaceChild("RightSpikeEight_r1", CubeListBuilder.create().texOffs(47, 37).addBox(-2.5f, -2.5f, 0.0f, 5.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-0.2f, (float)3.2f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition RightSpikeSeven_r1 = RightPlate.addOrReplaceChild("RightSpikeSeven_r1", CubeListBuilder.create().texOffs(48, 40).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-5.2f, (float)3.2f, (float)1.0f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition RightSpikeFive_r1 = RightPlate.addOrReplaceChild("RightSpikeFive_r1", CubeListBuilder.create().texOffs(48, 40).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-1.0f, (float)-3.2f, (float)3.2f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        PartDefinition RightSpikeFour_r1 = RightPlate.addOrReplaceChild("RightSpikeFour_r1", CubeListBuilder.create().texOffs(48, 40).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-4.1f, (float)-3.2f, (float)3.0f, (float)0.0f, (float)-2.3998f, (float)0.0f));
        PartDefinition RightSpikeThree_r1 = RightPlate.addOrReplaceChild("RightSpikeThree_r1", CubeListBuilder.create().texOffs(48, 40).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-1.0f, (float)-0.2f, (float)-4.175f, (float)0.0f, (float)1.5752f, (float)0.0f));
        PartDefinition RightSpikeTwo_r1 = RightPlate.addOrReplaceChild("RightSpikeTwo_r1", CubeListBuilder.create().texOffs(48, 40).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-4.1f, (float)-2.2f, (float)-3.075f, (float)0.0f, (float)2.3562f, (float)0.0f));
        PartDefinition RightSpikeOne_r1 = RightPlate.addOrReplaceChild("RightSpikeOne_r1", CubeListBuilder.create().texOffs(48, 40).mirror().addBox(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-4.2f, (float)-2.2f, (float)0.0f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition LeftLegging = partdefinition.addOrReplaceChild("LeftLegging", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.5f)).mirror(false), PartPose.offset((float)1.9f, (float)12.0f, (float)0.0f));
        PartDefinition RightLegging = partdefinition.addOrReplaceChild("RightLegging", CubeListBuilder.create().texOffs(0, 38).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.5f)), PartPose.offset((float)-1.9f, (float)12.0f, (float)0.0f));
        PartDefinition LeftBoot = partdefinition.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.75f)).mirror(false), PartPose.offset((float)1.9f, (float)12.0f, (float)0.0f));
        PartDefinition RightBoot = partdefinition.addOrReplaceChild("RightBoot", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.75f)), PartPose.offset((float)-1.9f, (float)12.0f, (float)0.0f));
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

