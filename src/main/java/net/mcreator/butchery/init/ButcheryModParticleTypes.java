package net.mcreator.butchery.init;

import net.mcreator.butchery.shim.ButcherySimpleParticleType;
import net.mcreator.butchery.shim.DeferredHolder;
import net.mcreator.butchery.shim.DeferredRegister;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

public class ButcheryModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, "butchery");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD_PARTICLE = REGISTRY.register("blood_particle", () -> new ButcherySimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FEATHERS = REGISTRY.register("feathers", () -> new ButcherySimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FREEZERSMOKE = REGISTRY.register("freezersmoke", () -> new ButcherySimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SANDPARTICLE = REGISTRY.register("sandparticle", () -> new ButcherySimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPARKS = REGISTRY.register("sparks", () -> new ButcherySimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WITHERSMOKE = REGISTRY.register("withersmoke", () -> new ButcherySimpleParticleType(false));
}

