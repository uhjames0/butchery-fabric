package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class dragon_cut_12Animation {
    public static final AnimationDefinition dragon_cut_12 = AnimationDefinition.Builder.withLength((float)0.0f).addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)1.0, (double)0.0, (double)0.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)1.0, (double)0.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)1.0, (double)0.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("neck1", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)1.0, (double)0.0, (double)0.0), AnimationChannel.Interpolations.LINEAR)})).build();
}

