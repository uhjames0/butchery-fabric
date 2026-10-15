package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class enderman_headlessAnimation {
    public static final AnimationDefinition enderman_headless = AnimationDefinition.Builder.withLength((float)0.0f).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)0.0, (double)0.0, (double)0.6f), AnimationChannel.Interpolations.LINEAR)})).build();
}

