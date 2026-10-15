package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class warden_armlessAnimation {
    public static final AnimationDefinition armless = AnimationDefinition.Builder.withLength((float)0.0f).addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)-10.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)0.0, (double)1.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)7.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)0.0, (double)1.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone2", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)-0.1f, (double)0.0, (double)0.2f), AnimationChannel.Interpolations.LINEAR)})).build();
}

