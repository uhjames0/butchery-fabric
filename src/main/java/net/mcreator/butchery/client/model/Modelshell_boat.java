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

public class Modelshell_boat
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelshell_boat"), "main");
    public final ModelPart group;
    public final ModelPart group2;
    public final ModelPart leg4;
    public final ModelPart leg3;
    public final ModelPart leg2;
    public final ModelPart leg1;
    public final ModelPart body2;
    public final ModelPart body2_rotation;
    public final ModelPart body;
    public final ModelPart body_rotation;
    public final ModelPart group3;
    public final ModelPart shell;
    public final ModelPart head;
    public final ModelPart bb_main;

    public Modelshell_boat(ModelPart root) {
        super(root);
        this.group = root.getChild("group");
        this.group2 = this.group.getChild("group2");
        this.leg4 = this.group2.getChild("leg4");
        this.leg3 = this.group2.getChild("leg3");
        this.leg2 = this.group2.getChild("leg2");
        this.leg1 = this.group2.getChild("leg1");
        this.body2 = this.group2.getChild("body2");
        this.body2_rotation = this.body2.getChild("body2_rotation");
        this.body = this.group2.getChild("body");
        this.body_rotation = this.body.getChild("body_rotation");
        this.group3 = this.body_rotation.getChild("group3");
        this.shell = this.body_rotation.getChild("shell");
        this.head = this.group.getChild("head");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition group = partdefinition.addOrReplaceChild("group", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-1.9f, (float)13.2f, (float)0.4f, (float)1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition group2 = group.addOrReplaceChild("group2", CubeListBuilder.create(), PartPose.offset((float)-8.0f, (float)-8.0f, (float)8.0f));
        PartDefinition leg4 = group2.addOrReplaceChild("leg4", CubeListBuilder.create(), PartPose.offset((float)5.0f, (float)5.0f, (float)-4.0f));
        PartDefinition leg3 = group2.addOrReplaceChild("leg3", CubeListBuilder.create(), PartPose.offset((float)-5.0f, (float)5.0f, (float)-4.0f));
        PartDefinition leg2 = group2.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset((float)3.5f, (float)6.0f, (float)11.0f));
        PartDefinition leg1 = group2.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offset((float)-3.5f, (float)6.0f, (float)11.0f));
        PartDefinition body2 = group2.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-5.0f, (float)-10.0f));
        PartDefinition body2_rotation = body2.addOrReplaceChild("body2_rotation", CubeListBuilder.create().texOffs(64, 2).addBox(5.4507f, 0.6716f, -5.8998f, 9.0f, 18.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body = group2.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-5.0f, (float)-10.0f));
        PartDefinition body_rotation = body.addOrReplaceChild("body_rotation", CubeListBuilder.create().texOffs(88, 0).addBox(0.4508f, 2.6716f, -2.8998f, 3.0f, 14.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(71, 23).addBox(0.4508f, 16.6716f, -2.8998f, 19.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(7, 37).addBox(0.4508f, -0.3284f, -2.8998f, 19.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(31, 1).addBox(4.4507f, 0.6716f, -4.8998f, 11.0f, 18.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(52, 2).addBox(3.4507f, 0.6716f, -2.8998f, 1.0f, 18.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(52, 2).addBox(15.4507f, 0.6716f, -2.8998f, 1.0f, 18.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body_rotation_r1 = body_rotation.addOrReplaceChild("body_rotation_r1", CubeListBuilder.create().texOffs(110, 0).addBox(-1.5f, -7.0f, -3.0f, 3.0f, 14.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)17.9507f, (float)9.6716f, (float)0.1002f, (float)0.0f, (float)0.0f, (float)-3.1416f));
        PartDefinition group3 = body_rotation.addOrReplaceChild("group3", CubeListBuilder.create(), PartPose.offset((float)-1.5169f, (float)8.4216f, (float)10.8671f));
        PartDefinition shell = body_rotation.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset((float)-1.5169f, (float)8.4216f, (float)10.8671f));
        PartDefinition head = group.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset((float)-8.0f, (float)-5.0f, (float)-2.0f));
        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_rotation_r2 = bb_main.addOrReplaceChild("body_rotation_r2", CubeListBuilder.create().texOffs(64, 32).addBox(-6.5f, -1.0f, -7.5f, 14.0f, 0.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.4492f, (float)-8.0784f, (float)-3.4748f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition body_rotation_r3 = bb_main.addOrReplaceChild("body_rotation_r3", CubeListBuilder.create().texOffs(60, 48).addBox(-6.75f, -1.5f, -6.5f, 17.0f, 0.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.3492f, (float)-6.5784f, (float)-1.5748f, (float)0.0f, (float)1.5708f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)64);
    }

    public void setupAnim(LivingEntityRenderState state) {
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
    }
}

