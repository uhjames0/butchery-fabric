package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class enderman_cut_4Animation {
    public static final AnimationDefinition enderman_cut_4 = AnimationDefinition.Builder.withLength((float)0.0f).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)0.0, (double)0.6f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)0.0, (double)1.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone4", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)0.0, (double)1.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone5", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)1.0, (double)0.0, (double)1.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone6", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)1.0, (double)0.2f, (double)1.0), AnimationChannel.Interpolations.LINEAR)})).build();
}

