package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class hanging_sniffer_anim_idleAnimation {
    public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength((float)0.0f).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.degreeVec((float)20.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)4.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone6", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)1.0, (double)0.0, (double)1.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone9", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.degreeVec((float)-80.0093f, (float)-90.434f, (float)-0.0379f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone9", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)5.0f, (float)-10.0f, (float)-16.0f), AnimationChannel.Interpolations.LINEAR)})).build();
}

