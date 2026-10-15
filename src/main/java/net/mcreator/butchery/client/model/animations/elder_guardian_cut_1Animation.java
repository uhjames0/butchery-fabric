package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class elder_guardian_cut_1Animation {
    public static final AnimationDefinition tail_removed = AnimationDefinition.Builder.withLength((float)2.0f).looping().addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)-0.3f, (float)0.0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.CATMULLROM)})).addAnimation("eye", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)1.5f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)-23.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)-43.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("tail3", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)-76.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone2", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)-3.125f), AnimationChannel.Interpolations.LINEAR)})).build();
}

