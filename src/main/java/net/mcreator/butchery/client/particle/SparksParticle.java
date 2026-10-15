package net.mcreator.butchery.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class SparksParticle
extends SingleQuadParticle {
    private final SpriteSet spriteSet;

    public static SparksParticleProvider provider(SpriteSet spriteSet) {
        return new SparksParticleProvider(spriteSet);
    }

    protected SparksParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z, spriteSet.get(world.getRandom()));
        this.spriteSet = spriteSet;
        this.setSize(0.2f, 1.0f);
        this.lifetime = 7;
        this.gravity = 1.0f;
        this.hasPhysics = true;
        this.xd = vx * 0.1;
        this.yd = vy * 0.1;
        this.zd = vz * 0.1;
        this.setSpriteFromAge(spriteSet);
    }

    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.OPAQUE;
    }

    public void tick() {
        super.tick();
    }

    public static class SparksParticleProvider
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public SparksParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public SingleQuadParticle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new SparksParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }
    }
}

