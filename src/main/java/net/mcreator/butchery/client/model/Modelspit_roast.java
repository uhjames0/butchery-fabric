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

public class Modelspit_roast
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelspit_roast"), "main");
    public final ModelPart bone;
    public final ModelPart bone2;
    public final ModelPart bone3;
    public final ModelPart bone4;
    public final ModelPart bb_main;

    public Modelspit_roast(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
        this.bone2 = root.getChild("bone2");
        this.bone3 = root.getChild("bone3");
        this.bone4 = root.getChild("bone4");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation((float)21.0f, (float)40.0f, (float)-7.0f, (float)-0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0f, -1.0f, -1.0f, 32.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-16.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)1.5708f));
        PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation((float)21.0f, (float)40.0f, (float)7.0f, (float)0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0f, -1.0f, -1.0f, 32.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-16.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)1.5708f));
        PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-21.0f, (float)40.0f, (float)-7.0f, (float)-0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r3 = bone3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0f, -1.0f, -1.0f, 32.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-16.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)1.5708f));
        PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-21.0f, (float)40.0f, (float)7.0f, (float)0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r4 = bone4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0f, -1.0f, -1.0f, 32.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-16.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)1.5708f));
        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 4).addBox(-24.0f, -12.1f, -0.5f, 48.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(0, 6).addBox(-22.5f, -9.0f, -2.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(0, 6).addBox(19.5f, -9.0f, -2.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
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

