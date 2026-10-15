package net.mcreator.butchery.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class BloodparticleParticle
extends SingleQuadParticle {
    private final SpriteSet spriteSet;

    public static BloodparticleParticleProvider provider(SpriteSet spriteSet) {
        return new BloodparticleParticleProvider(spriteSet);
    }

    protected BloodparticleParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z, spriteSet.get(world.getRandom()));
        this.spriteSet = spriteSet;
        this.setSize(0.1f, 0.1f);
        this.quadSize *= 0.2f;
        this.lifetime = 7;
        this.gravity = 15.0f;
        this.hasPhysics = true;
        this.xd = vx * 0.0;
        this.yd = vy * 0.0;
        this.zd = vz * 0.0;
        this.setSpriteFromAge(spriteSet);
    }

    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.OPAQUE;
    }

    public void tick() {
        super.tick();
    }

    public static class BloodparticleParticleProvider
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public BloodparticleParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public SingleQuadParticle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new BloodparticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }
    }
}

