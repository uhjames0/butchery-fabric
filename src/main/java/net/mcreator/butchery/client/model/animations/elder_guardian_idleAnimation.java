package net.mcreator.butchery.client.model.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3fc;

public class elder_guardian_idleAnimation {
    public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength((float)2.0f).looping().addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe[]{new Keyframe(0.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)-0.3f, (float)0.0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.0f, (Vector3fc)KeyframeAnimations.posVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.CATMULLROM)})).build();
}

