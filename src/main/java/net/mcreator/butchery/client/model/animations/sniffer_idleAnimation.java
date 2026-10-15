package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class sniffer_idleAnimation {
    public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength((float)0.0f).addAnimation("bone6", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.scaleVec((double)1.0, (double)0.0, (double)1.0), AnimationChannel.Interpolations.LINEAR)})).build();
}

