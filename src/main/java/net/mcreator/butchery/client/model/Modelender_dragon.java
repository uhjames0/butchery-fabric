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

public class Modelender_dragon
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"butchery", (String)"modelender_dragon"), "main");
    public final ModelPart bone;
    public final ModelPart body;
    public final ModelPart tail1;
    public final ModelPart tail2;
    public final ModelPart tail3;
    public final ModelPart tail4;
    public final ModelPart tail5;
    public final ModelPart tail6;
    public final ModelPart tail7;
    public final ModelPart tail8;
    public final ModelPart tail9;
    public final ModelPart tail10;
    public final ModelPart tail11;
    public final ModelPart tail12;
    public final ModelPart back_left_leg;
    public final ModelPart back_left_shin;
    public final ModelPart back_left_foot;
    public final ModelPart back_right_leg;
    public final ModelPart back_right_shin;
    public final ModelPart back_right_foot;
    public final ModelPart front_left_leg;
    public final ModelPart front_left_shin;
    public final ModelPart front_left_foot;
    public final ModelPart front_right_leg;
    public final ModelPart front_right_shin;
    public final ModelPart front_right_foot;
    public final ModelPart left_wing;
    public final ModelPart left_wing_tip;
    public final ModelPart right_wing;
    public final ModelPart right_wing_tip;
    public final ModelPart neck1;
    public final ModelPart neck2;
    public final ModelPart neck3;
    public final ModelPart neck4;
    public final ModelPart neck5;
    public final ModelPart head;
    public final ModelPart mirrored;
    public final ModelPart jaw;

    public Modelender_dragon(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
        this.body = this.bone.getChild("body");
        this.tail1 = this.body.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.tail4 = this.tail3.getChild("tail4");
        this.tail5 = this.tail4.getChild("tail5");
        this.tail6 = this.tail5.getChild("tail6");
        this.tail7 = this.tail6.getChild("tail7");
        this.tail8 = this.tail7.getChild("tail8");
        this.tail9 = this.tail8.getChild("tail9");
        this.tail10 = this.tail9.getChild("tail10");
        this.tail11 = this.tail10.getChild("tail11");
        this.tail12 = this.tail11.getChild("tail12");
        this.back_left_leg = this.body.getChild("back_left_leg");
        this.back_left_shin = this.back_left_leg.getChild("back_left_shin");
        this.back_left_foot = this.back_left_shin.getChild("back_left_foot");
        this.back_right_leg = this.body.getChild("back_right_leg");
        this.back_right_shin = this.back_right_leg.getChild("back_right_shin");
        this.back_right_foot = this.back_right_shin.getChild("back_right_foot");
        this.front_left_leg = this.body.getChild("front_left_leg");
        this.front_left_shin = this.front_left_leg.getChild("front_left_shin");
        this.front_left_foot = this.front_left_shin.getChild("front_left_foot");
        this.front_right_leg = this.body.getChild("front_right_leg");
        this.front_right_shin = this.front_right_leg.getChild("front_right_shin");
        this.front_right_foot = this.front_right_shin.getChild("front_right_foot");
        this.left_wing = this.body.getChild("left_wing");
        this.left_wing_tip = this.left_wing.getChild("left_wing_tip");
        this.right_wing = this.body.getChild("right_wing");
        this.right_wing_tip = this.right_wing.getChild("right_wing_tip");
        this.neck1 = this.body.getChild("neck1");
        this.neck2 = this.neck1.getChild("neck2");
        this.neck3 = this.neck2.getChild("neck3");
        this.neck4 = this.neck3.getChild("neck4");
        this.neck5 = this.neck4.getChild("neck5");
        this.head = this.neck5.getChild("head");
        this.mirrored = this.head.getChild("mirrored");
        this.jaw = this.head.getChild("jaw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)24.0f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0f, 0.0f, -16.0f, 24.0f, 24.0f, 64.0f, new CubeDeformation(0.0f)).texOffs(220, 53).addBox(-1.0f, -6.0f, -10.0f, 2.0f, 6.0f, 12.0f, new CubeDeformation(0.0f)).texOffs(220, 53).addBox(-1.0f, -6.0f, 10.0f, 2.0f, 6.0f, 12.0f, new CubeDeformation(0.0f)).texOffs(220, 53).addBox(-1.0f, -6.0f, 30.0f, 2.0f, 6.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)-16.0f));
        PartDefinition tail1 = body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)7.0f, (float)52.0f, (float)-3.0107f, (float)0.0f, (float)3.1416f));
        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)3.0543f, (float)0.0f, (float)3.1416f));
        PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)10.0f, (float)3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)10.0f, (float)3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition tail6 = tail5.addOrReplaceChild("tail6", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)-2.9671f, (float)0.0f, (float)3.1416f));
        PartDefinition tail7 = tail6.addOrReplaceChild("tail7", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)10.0f, (float)3.054f, (float)-0.0869f, (float)-3.134f));
        PartDefinition tail8 = tail7.addOrReplaceChild("tail8", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)0.0f, (float)-2.9671f, (float)0.0f));
        PartDefinition tail9 = tail8.addOrReplaceChild("tail9", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)10.0f, (float)0.0f, (float)-2.8798f, (float)0.0f));
        PartDefinition tail10 = tail9.addOrReplaceChild("tail10", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)0.0f, (float)-2.8798f, (float)0.0f));
        PartDefinition tail11 = tail10.addOrReplaceChild("tail11", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)10.0f, (float)0.0f, (float)-2.8798f, (float)0.0f));
        PartDefinition tail12 = tail11.addOrReplaceChild("tail12", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)0.0f, (float)-2.9234f, (float)0.0f));
        PartDefinition back_left_leg = body.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0f, -4.0f, -8.0f, 16.0f, 32.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)16.0f, (float)16.0f, (float)34.0f, (float)1.5708f, (float)0.1309f, (float)0.0f));
        PartDefinition back_left_shin = back_left_leg.addOrReplaceChild("back_left_shin", CubeListBuilder.create().texOffs(196, 0).addBox(-6.0f, -2.0f, 0.0f, 12.0f, 32.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)30.0f, (float)-6.0f, (float)0.0f, (float)0.0f, (float)0.2182f));
        PartDefinition back_left_foot = back_left_shin.addOrReplaceChild("back_left_foot", CubeListBuilder.create().texOffs(112, 0).addBox(-9.0f, 0.0f, -20.0f, 18.0f, 6.0f, 24.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)30.0f, (float)-1.0f, (float)1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition back_right_leg = body.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0f, -4.0f, -8.0f, 16.0f, 32.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-16.0f, (float)16.0f, (float)34.0f, (float)1.5708f, (float)-0.1745f, (float)0.0f));
        PartDefinition back_right_shin = back_right_leg.addOrReplaceChild("back_right_shin", CubeListBuilder.create().texOffs(196, 0).addBox(-6.0f, -2.0f, 0.0f, 12.0f, 32.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)30.0f, (float)-6.0f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition back_right_foot = back_right_shin.addOrReplaceChild("back_right_foot", CubeListBuilder.create().texOffs(112, 0).addBox(-9.0f, 0.0f, -20.0f, 18.0f, 6.0f, 24.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)30.0f, (float)-1.0f, (float)1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition front_left_leg = body.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(112, 104).addBox(-4.0f, -4.0f, -4.0f, 8.0f, 24.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)12.0f, (float)20.0f, (float)-6.0f, (float)-1.5708f, (float)-0.2182f, (float)0.0f));
        PartDefinition front_left_shin = front_left_leg.addOrReplaceChild("front_left_shin", CubeListBuilder.create().texOffs(226, 138).addBox(-3.0f, -1.0f, -3.0f, 6.0f, 24.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)21.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)0.1309f));
        PartDefinition front_left_foot = front_left_shin.addOrReplaceChild("front_left_foot", CubeListBuilder.create().texOffs(144, 104).addBox(-3.0f, 0.0f, -12.0f, 8.0f, 4.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)23.0f, (float)0.0f, (float)1.6581f, (float)0.0f, (float)0.0f));
        PartDefinition front_right_leg = body.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(112, 104).addBox(-4.0f, -4.0f, -4.0f, 8.0f, 24.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-12.0f, (float)20.0f, (float)-6.0f, (float)-1.5708f, (float)0.1745f, (float)0.0f));
        PartDefinition front_right_shin = front_right_leg.addOrReplaceChild("front_right_shin", CubeListBuilder.create().texOffs(226, 138).addBox(-3.0f, -1.0f, -3.0f, 6.0f, 24.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)21.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition front_right_foot = front_right_shin.addOrReplaceChild("front_right_foot", CubeListBuilder.create().texOffs(144, 104).addBox(-4.0f, 0.0f, -12.0f, 8.0f, 4.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)23.0f, (float)0.0f, (float)1.6581f, (float)0.0f, (float)0.0f));
        PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(112, 88).mirror().addBox(0.0f, -4.0f, -4.0f, 56.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(-56, 88).mirror().addBox(0.0f, 0.0f, 2.0f, 56.0f, 0.0f, 56.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)12.0f, (float)1.0f, (float)-6.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition left_wing_tip = left_wing.addOrReplaceChild("left_wing_tip", CubeListBuilder.create().texOffs(112, 136).mirror().addBox(0.0f, -2.0f, -2.0f, 56.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(-56, 144).mirror().addBox(0.0f, 0.0f, 2.0f, 56.0f, 0.0f, 56.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)56.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(-56, 88).addBox(-56.0f, 0.0f, 2.0f, 56.0f, 0.0f, 56.0f, new CubeDeformation(0.0f)).texOffs(112, 88).addBox(-56.0f, -4.0f, -4.0f, 56.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-12.0f, (float)1.0f, (float)-6.0f, (float)0.0f, (float)0.0f, (float)-0.3054f));
        PartDefinition right_wing_tip = right_wing.addOrReplaceChild("right_wing_tip", CubeListBuilder.create().texOffs(-56, 144).addBox(-56.0f, 0.0f, 2.0f, 56.0f, 0.0f, 56.0f, new CubeDeformation(0.0f)).texOffs(112, 136).addBox(-56.0f, -2.0f, -2.0f, 56.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-56.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3054f));
        PartDefinition neck1 = body.addOrReplaceChild("neck1", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)17.0f, (float)-20.0f, (float)0.0f, (float)-0.1309f, (float)0.0f));
        PartDefinition neck2 = neck1.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)0.0f, (float)-0.1309f, (float)0.0f));
        PartDefinition neck3 = neck2.addOrReplaceChild("neck3", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)0.0f, (float)-0.1309f, (float)0.0f));
        PartDefinition neck4 = neck3.addOrReplaceChild("neck4", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)0.0f, (float)-0.1309f, (float)0.0f));
        PartDefinition neck5 = neck4.addOrReplaceChild("neck5", CubeListBuilder.create().texOffs(192, 104).addBox(-5.0f, -5.0f, -5.0f, 10.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(48, 0).addBox(-1.0f, -9.0f, -3.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-10.0f, (float)0.0f, (float)-0.1745f, (float)0.0f));
        PartDefinition head = neck5.addOrReplaceChild("head", CubeListBuilder.create().texOffs(176, 44).addBox(-8.0f, 1.625f, -30.25f, 12.0f, 5.0f, 16.0f, new CubeDeformation(0.0f)).texOffs(112, 30).addBox(-10.0f, -5.375f, -16.25f, 16.0f, 16.0f, 16.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(1.0f, -9.375f, -10.25f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(112, 0).addBox(1.0f, -0.375f, -28.25f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)-3.625f, (float)-3.75f, (float)0.0f, (float)-0.3491f, (float)0.0f));
        PartDefinition mirrored = head.addOrReplaceChild("mirrored", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0f, -90.0f, -28.0f, 2.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(112, 0).mirror().addBox(-5.0f, -81.0f, -46.0f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)-2.0f, (float)80.625f, (float)17.75f));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(176, 65).addBox(-6.0f, -72.0f, -16.0f, 12.0f, 4.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-2.0f, (float)78.625f, (float)-14.25f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(LivingEntityRenderState state) {
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
    }
}

