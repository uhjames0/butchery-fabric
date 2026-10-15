package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class ravager_leg_2Animation {
    public static final AnimationDefinition ravager_leg_2 = AnimationDefinition.Builder.withLength((float)0.0f).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)0.0, (double)0.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)-0.2f, (double)0.0), AnimationChannel.Interpolations.LINEAR)})).addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.3f, (double)0.0, (double)0.0), AnimationChannel.Interpolations.LINEAR)})).build();
}

