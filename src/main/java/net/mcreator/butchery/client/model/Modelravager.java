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

public class Modelravager
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelravager"), "main");
    public final ModelPart bone;
    public final ModelPart head;
    public final ModelPart horns;
    public final ModelPart left_horn;
    public final ModelPart jaw;
    public final ModelPart body;
    public final ModelPart rotation;
    public final ModelPart leg1;
    public final ModelPart leg2;
    public final ModelPart leg3;
    public final ModelPart leg4;
    public final ModelPart neck;

    public Modelravager(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
        this.head = this.bone.getChild("head");
        this.horns = this.head.getChild("horns");
        this.left_horn = this.horns.getChild("left_horn");
        this.jaw = this.head.getChild("jaw");
        this.body = this.bone.getChild("body");
        this.rotation = this.body.getChild("rotation");
        this.leg1 = this.bone.getChild("leg1");
        this.leg2 = this.bone.getChild("leg2");
        this.leg3 = this.bone.getChild("leg3");
        this.leg4 = this.bone.getChild("leg4");
        this.neck = this.bone.getChild("neck");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-3.4732f, (float)14.8716f, (float)0.0541f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition head = bone.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.3333f, -12.6667f, -3.6667f, 16.0f, 20.0f, 16.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(-0.3333f, 1.3333f, -7.6667f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-1.5935f, (float)0.7951f, (float)-16.8874f));
        PartDefinition horns = head.addOrReplaceChild("horns", CubeListBuilder.create().texOffs(74, 55).addBox(-5.0f, -14.5f, -0.134f, 2.0f, 14.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.3333f, (float)-4.6667f, (float)1.3333f, (float)1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition left_horn = horns.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(74, 55).mirror().addBox(8.0f, -41.5f, -19.134f, 2.0f, 14.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)5.0f, (float)27.0f, (float)19.0f));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 36).addBox(-8.0f, -2.5f, -8.0f, 16.0f, 3.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offset((float)1.6667f, (float)7.8333f, (float)4.3333f));
        PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset((float)0.0732f, (float)0.1284f, (float)6.9459f));
        PartDefinition rotation = body.addOrReplaceChild("rotation", CubeListBuilder.create().texOffs(0, 55).addBox(-7.0f, -10.0f, -9.0f, 14.0f, 16.0f, 20.0f, new CubeDeformation(0.0f)).texOffs(0, 91).addBox(-6.0f, 6.0f, -9.0f, 12.0f, 13.0f, 18.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition leg1 = bone.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offset((float)-10.4929f, (float)-0.9479f, (float)15.8525f));
        PartDefinition leg1_r1 = leg1.addOrReplaceChild("leg1_r1", CubeListBuilder.create().texOffs(96, 0).addBox(-4.0f, -8.5f, -4.0f, 8.0f, 37.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.566f, (float)-4.4237f, (float)8.5934f, (float)-1.0744f, (float)0.2136f, (float)0.1525f));
        PartDefinition leg2 = bone.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset((float)11.3809f, (float)-1.1261f, (float)15.3605f));
        PartDefinition leg2_r1 = leg2.addOrReplaceChild("leg2_r1", CubeListBuilder.create().texOffs(96, 0).mirror().addBox(-4.0f, -7.5f, -4.0f, 8.0f, 37.0f, 8.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-3.3078f, (float)-5.2454f, (float)9.0854f, (float)-1.0264f, (float)-0.2635f, (float)-0.1564f));
        PartDefinition leg3 = bone.addOrReplaceChild("leg3", CubeListBuilder.create(), PartPose.offset((float)-10.2466f, (float)-2.3131f, (float)-5.9078f));
        PartDefinition leg3_r1 = leg3.addOrReplaceChild("leg3_r1", CubeListBuilder.create().texOffs(64, 0).addBox(-12.0f, -9.5f, -4.0f, 8.0f, 37.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)10.3198f, (float)-2.0585f, (float)5.8537f, (float)-0.9093f, (float)0.147f, (float)0.3563f));
        PartDefinition leg4 = bone.addOrReplaceChild("leg4", CubeListBuilder.create(), PartPose.offset((float)10.7326f, (float)-2.2932f, (float)-5.2557f));
        PartDefinition leg4_r1 = leg4.addOrReplaceChild("leg4_r1", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(4.0f, -9.5f, -4.0f, 8.0f, 37.0f, 8.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-10.6594f, (float)-2.0783f, (float)5.2016f, (float)-0.8171f, (float)-0.1603f, (float)-0.4105f));
        PartDefinition neck = bone.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(68, 73).addBox(-5.0f, -5.0f, -9.0f, 10.0f, 10.0f, 18.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0732f, (float)-2.8716f, (float)2.4459f));
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

