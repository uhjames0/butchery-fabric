package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class wither_carcassAnimation {
    public static final AnimationDefinition shrink = AnimationDefinition.Builder.withLength((float)1.0f).addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.degreeVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.0f, (Vector3fc)KeyframeAnimations.degreeVec((float)5.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)-5.2f, (float)0.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)1.0, (double)1.0, (double)1.0), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)1.0, (double)1.0, (double)0.0), AnimationChannel.Interpolations.LINEAR)})).build();
}

