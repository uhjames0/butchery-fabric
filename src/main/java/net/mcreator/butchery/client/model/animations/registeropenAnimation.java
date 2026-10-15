package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class registeropenAnimation {
    public static final AnimationDefinition open = AnimationDefinition.Builder.withLength((float)0.4583f).addAnimation("bone12", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.2917f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.4583f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)-5.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone11", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.125f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.2083f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)2.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR)})).addAnimation("bone13", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.degreeVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.0833f, (Vector3fc)KeyframeAnimations.degreeVec((float)12.5f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.1667f, (Vector3fc)KeyframeAnimations.degreeVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR)})).build();
}

