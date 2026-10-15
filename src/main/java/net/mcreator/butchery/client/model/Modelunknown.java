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

public class Modelunknown
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelunknown"), "main");
    public final ModelPart bb_main;
    public final ModelPart bone12;
    public final ModelPart bone11;
    public final ModelPart bone;
    public final ModelPart bone2;
    public final ModelPart bone5;
    public final ModelPart bone3;
    public final ModelPart bone13;
    public final ModelPart bone4;
    public final ModelPart bone6;
    public final ModelPart bone7;
    public final ModelPart bone8;
    public final ModelPart bone9;
    public final ModelPart bone10;

    public Modelunknown(ModelPart root) {
        super(root);
        this.bb_main = root.getChild("bb_main");
        this.bone12 = root.getChild("bone12");
        this.bone11 = root.getChild("bone11");
        this.bone = root.getChild("bone");
        this.bone2 = this.bone.getChild("bone2");
        this.bone5 = this.bone2.getChild("bone5");
        this.bone3 = this.bone.getChild("bone3");
        this.bone13 = this.bone3.getChild("bone13");
        this.bone4 = this.bone3.getChild("bone4");
        this.bone6 = this.bone.getChild("bone6");
        this.bone7 = this.bone6.getChild("bone7");
        this.bone8 = this.bone7.getChild("bone8");
        this.bone9 = this.bone6.getChild("bone9");
        this.bone10 = this.bone9.getChild("bone10");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition bb_main_r1 = bb_main.addOrReplaceChild("bb_main_r1", CubeListBuilder.create().texOffs(1, 35).addBox(-6.0f, -5.0f, -4.7503f, 12.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(14, 30).addBox(-4.0f, -4.0f, -3.7502f, 8.0f, 3.0f, 0.001f, new CubeDeformation(0.0f)).texOffs(1, 28).addBox(-5.0f, -4.0f, -4.7503f, 1.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(1, 28).addBox(4.0f, -4.0f, -4.7503f, 1.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(0, 22).addBox(-6.0f, -1.0f, -4.7503f, 12.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(0, 13).addBox(-6.0f, 1.0f, -4.7503f, 12.0f, 2.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(17, 15).addBox(-6.5f, 2.999f, 2.2498f, 13.0f, 0.001f, 3.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(-6.0f, 3.0f, -4.7503f, 12.0f, 3.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-6.0f, (float)0.2502f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone12 = partdefinition.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset((float)0.5f, (float)23.5f, (float)-0.3f));
        PartDefinition bone12_r1 = bone12.addOrReplaceChild("bone12_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-5.5f, 3.5f, -1.0503f, 11.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5f, (float)-5.5f, (float)0.5502f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone11 = partdefinition.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset((float)1.5f, (float)18.0f, (float)-2.5f));
        PartDefinition bone11_r1 = bone11.addOrReplaceChild("bone11_r1", CubeListBuilder.create().texOffs(3, 5).addBox(1.0f, -1.0f, -2.2502f, 1.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.5f, (float)0.0f, (float)2.7502f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset((float)1.0f, (float)20.0f, (float)4.0f));
        PartDefinition bone_r1 = bone.addOrReplaceChild("bone_r1", CubeListBuilder.create().texOffs(3, 1).addBox(1.999f, 1.0f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(4, 1).addBox(1.999f, 2.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-2.0f, (float)-3.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone_r2 = bone.addOrReplaceChild("bone_r2", CubeListBuilder.create().texOffs(3, 2).addBox(-1.001f, 1.5f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-2.0f, (float)-3.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset((float)2.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone2_r1 = bone2.addOrReplaceChild("bone2_r1", CubeListBuilder.create().texOffs(3, 1).addBox(3.999f, 1.0f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(4, 1).addBox(3.999f, 2.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.0f, (float)-2.0f, (float)-3.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone2_r2 = bone2.addOrReplaceChild("bone2_r2", CubeListBuilder.create().texOffs(3, 2).addBox(-1.001f, 3.5f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.0f, (float)-2.0f, (float)-3.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone5 = bone2.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset((float)-8.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone5_r1 = bone5.addOrReplaceChild("bone5_r1", CubeListBuilder.create().texOffs(3, 1).addBox(-4.001f, 1.0f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(4, 1).addBox(-4.001f, 2.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)-2.0f, (float)-3.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone5_r2 = bone5.addOrReplaceChild("bone5_r2", CubeListBuilder.create().texOffs(3, 2).addBox(-1.001f, -4.5f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)-2.0f, (float)-3.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset((float)-4.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone13 = bone3.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset((float)1.0f, (float)1.0f, (float)-2.0f));
        PartDefinition bone13_r1 = bone13.addOrReplaceChild("bone13_r1", CubeListBuilder.create().texOffs(4, 1).addBox(-2.001f, 2.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(3, 1).addBox(-2.001f, 1.0f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)-3.0f, (float)-1.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone13_r2 = bone13.addOrReplaceChild("bone13_r2", CubeListBuilder.create().texOffs(3, 2).addBox(-1.001f, -2.5f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)-3.0f, (float)-1.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset((float)2.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone4_r1 = bone4.addOrReplaceChild("bone4_r1", CubeListBuilder.create().texOffs(3, 1).addBox(-0.001f, 1.0f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(4, 1).addBox(-0.001f, 2.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0f, (float)-2.0f, (float)-3.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone4_r2 = bone4.addOrReplaceChild("bone4_r2", CubeListBuilder.create().texOffs(3, 2).addBox(-1.001f, -0.5f, 3.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0f, (float)-2.0f, (float)-3.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone6 = bone.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-2.0f, (float)-1.0f));
        PartDefinition bone6_r1 = bone6.addOrReplaceChild("bone6_r1", CubeListBuilder.create().texOffs(3, 1).addBox(1.999f, -1.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(4, 1).addBox(1.999f, 0.0f, 1.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone6_r2 = bone6.addOrReplaceChild("bone6_r2", CubeListBuilder.create().texOffs(3, 2).addBox(0.999f, 1.5f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone7 = bone6.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset((float)2.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone7_r1 = bone7.addOrReplaceChild("bone7_r1", CubeListBuilder.create().texOffs(3, 1).addBox(3.999f, -1.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(4, 1).addBox(3.999f, 0.0f, 1.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone7_r2 = bone7.addOrReplaceChild("bone7_r2", CubeListBuilder.create().texOffs(3, 2).addBox(0.999f, 3.5f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset((float)-8.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone8_r1 = bone8.addOrReplaceChild("bone8_r1", CubeListBuilder.create().texOffs(3, 1).addBox(-4.001f, -1.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(4, 1).addBox(-4.001f, 0.0f, 1.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone8_r2 = bone8.addOrReplaceChild("bone8_r2", CubeListBuilder.create().texOffs(3, 2).addBox(0.999f, -4.5f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone9 = bone6.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset((float)-4.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone9_r1 = bone9.addOrReplaceChild("bone9_r1", CubeListBuilder.create().texOffs(3, 1).addBox(-2.001f, -1.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(4, 1).addBox(-2.001f, 0.0f, 1.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone9_r2 = bone9.addOrReplaceChild("bone9_r2", CubeListBuilder.create().texOffs(3, 2).addBox(0.999f, -2.5f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
        PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset((float)2.0f, (float)0.0f, (float)0.0f));
        PartDefinition bone10_r1 = bone10.addOrReplaceChild("bone10_r1", CubeListBuilder.create().texOffs(3, 1).addBox(-0.001f, -1.0f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(4, 1).addBox(-0.001f, 0.0f, 1.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition bone10_r2 = bone10.addOrReplaceChild("bone10_r2", CubeListBuilder.create().texOffs(3, 2).addBox(0.999f, -0.5f, 2.2498f, 0.001f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0f, (float)0.0f, (float)-2.7498f, (float)-3.1416f, (float)0.0f, (float)-1.5708f));
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

