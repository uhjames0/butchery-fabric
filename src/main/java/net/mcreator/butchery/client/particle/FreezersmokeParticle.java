package net.mcreator.butchery.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class FreezersmokeParticle
extends SingleQuadParticle {
    private final SpriteSet spriteSet;

    public static FreezersmokeParticleProvider provider(SpriteSet spriteSet) {
        return new FreezersmokeParticleProvider(spriteSet);
    }

    protected FreezersmokeParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z, spriteSet.get(world.getRandom()));
        this.spriteSet = spriteSet;
        this.setSize(0.2f, 0.2f);
        this.quadSize *= 1.2f;
        this.lifetime = Math.max(1, 32 + (this.random.nextInt(16) - 8));
        this.gravity = -0.1f;
        this.hasPhysics = true;
        this.xd = vx * -1.0;
        this.yd = vy * -1.0;
        this.zd = vz * -1.0;
        this.setSpriteFromAge(spriteSet);
    }

    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.OPAQUE;
    }

    public void tick() {
        super.tick();
        if (!this.removed) {
            this.setSprite(this.spriteSet.get(this.age / 6 % 8 + 1, 8));
        }
    }

    public static class FreezersmokeParticleProvider
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public FreezersmokeParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public SingleQuadParticle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new FreezersmokeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }
    }
}

