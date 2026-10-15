package net.mcreator.butchery.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.mcreator.butchery.client.model.ModelEvokerDisguise;
import net.mcreator.butchery.client.model.ModelPillager_Disguise;
import net.mcreator.butchery.client.model.Modelbloody_butcher_apron;
import net.mcreator.butchery.client.model.Modelbutcher_apron;
import net.mcreator.butchery.client.model.Modelcash_register;
import net.mcreator.butchery.client.model.Modeldragon_armor;
import net.mcreator.butchery.client.model.Modelelder_guardian;
import net.mcreator.butchery.client.model.Modelender_dragon;
import net.mcreator.butchery.client.model.Modelenderman;
import net.mcreator.butchery.client.model.Modelevoker_disguise;
import net.mcreator.butchery.client.model.Modelhanging_enderman;
import net.mcreator.butchery.client.model.Modelpiglin_brute_disguise;
import net.mcreator.butchery.client.model.Modelplayer_corpse;
import net.mcreator.butchery.client.model.Modelravager;
import net.mcreator.butchery.client.model.Modelshell_boat;
import net.mcreator.butchery.client.model.Modelsniffer_carcass;
import net.mcreator.butchery.client.model.Modelspit_roast;
import net.mcreator.butchery.client.model.Modelstray_necklace;
import net.mcreator.butchery.client.model.Modelturtle_shell_chestplate;
import net.mcreator.butchery.client.model.Modelunknown;
import net.mcreator.butchery.client.model.Modelvindicator_disguise;
import net.mcreator.butchery.client.model.Modelwarden_carcass;
import net.mcreator.butchery.client.model.Modelwitch_clothes;
import net.mcreator.butchery.client.model.Modelwitch_disguise;
import net.mcreator.butchery.client.model.Modelwither;
import net.mcreator.butchery.client.model.Modelwolf_fur_suit;
import net.mcreator.butchery.client.particle.BloodparticleParticle;
import net.mcreator.butchery.client.particle.FeathersParticle;
import net.mcreator.butchery.client.particle.FreezersmokeParticle;
import net.mcreator.butchery.client.particle.SandparticleParticle;
import net.mcreator.butchery.client.particle.SparksParticle;
import net.mcreator.butchery.client.particle.WithersmokeParticle;
import net.mcreator.butchery.client.renderer.DragonRenderer;
import net.mcreator.butchery.client.renderer.PlayercorpseRenderer;
import net.mcreator.butchery.client.renderer.TurtleshellboatRenderer;
import net.mcreator.butchery.client.renderer.block.CashregisterblockRenderer;
import net.mcreator.butchery.client.renderer.block.DrainedendermancarcassRenderer;
import net.mcreator.butchery.client.renderer.block.DrainedsniffercarcassblockRenderer;
import net.mcreator.butchery.client.renderer.block.ElderguardiancarcassRenderer;
import net.mcreator.butchery.client.renderer.block.EnderdragoncarcassRenderer;
import net.mcreator.butchery.client.renderer.block.EndermancarcassRenderer;
import net.mcreator.butchery.client.renderer.block.HangingdrainedendermancarcassRenderer;
import net.mcreator.butchery.client.renderer.block.HangingendermancarcassRenderer;
import net.mcreator.butchery.client.renderer.block.RavagerRenderer;
import net.mcreator.butchery.client.renderer.block.SniffercarcassblockRenderer;
import net.mcreator.butchery.client.renderer.block.WardencarcassRenderer;
import net.mcreator.butchery.client.renderer.block.WithercarcassRenderer;
import net.mcreator.butchery.custom.model.Modelplayer_corpse_slim;
import net.mcreator.butchery.init.ButcheryModBlockEntities;
import net.mcreator.butchery.init.ButcheryModEntities;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.shim.ModelLayerRegistry;
import net.minecraft.core.particles.ParticleType;

@Environment(value=EnvType.CLIENT)
public class ButcheryModClientRegistries {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(ButcheryModEntities.TURTLESHELLBOAT.get(), TurtleshellboatRenderer::new);
        EntityRendererRegistry.register(ButcheryModEntities.DRAGON.get(), DragonRenderer::new);
    }

    public static void registerBlockEntityRenderers() {
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.CASH_REGISTER_BLOCK.get(), CashregisterblockRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.WITHER_CARCASS.get(), WithercarcassRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.WARDEN_CARCASS.get(), WardencarcassRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.SNIFFER_CARCASS_BLOCK.get(), SniffercarcassblockRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.DRAINED_SNIFFER_CARCASS_BLOCK.get(), DrainedsniffercarcassblockRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.RAVAGER.get(), RavagerRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.HANGING_ENDERMAN_CARCASS.get(), HangingendermancarcassRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.HANGING_DRAINED_ENDERMAN_CARCASS.get(), HangingdrainedendermancarcassRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.ENDERMAN_CARCASS.get(), EndermancarcassRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.DRAINED_ENDERMAN_CARCASS.get(), DrainedendermancarcassRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.ENDER_DRAGON_CARCASS.get(), EnderdragoncarcassRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.ELDER_GUARDIAN_CARCASS.get(), ElderguardiancarcassRenderer::new);
        BlockEntityRendererRegistry.register(ButcheryModBlockEntities.PLAYERCORPSE.get(), PlayercorpseRenderer::new);
    }

    public static void registerLayerDefinitions() {
        ModelLayerRegistry.register(Modelspit_roast.LAYER_LOCATION, Modelspit_roast::createBodyLayer);
        ModelLayerRegistry.register(Modelender_dragon.LAYER_LOCATION, Modelender_dragon::createBodyLayer);
        ModelLayerRegistry.register(ModelPillager_Disguise.LAYER_LOCATION, ModelPillager_Disguise::createBodyLayer);
        ModelLayerRegistry.register(Modelshell_boat.LAYER_LOCATION, Modelshell_boat::createBodyLayer);
        ModelLayerRegistry.register(Modelvindicator_disguise.LAYER_LOCATION, Modelvindicator_disguise::createBodyLayer);
        ModelLayerRegistry.register(Modelravager.LAYER_LOCATION, Modelravager::createBodyLayer);
        ModelLayerRegistry.register(Modelwolf_fur_suit.LAYER_LOCATION, Modelwolf_fur_suit::createBodyLayer);
        ModelLayerRegistry.register(Modelpiglin_brute_disguise.LAYER_LOCATION, Modelpiglin_brute_disguise::createBodyLayer);
        ModelLayerRegistry.register(Modelstray_necklace.LAYER_LOCATION, Modelstray_necklace::createBodyLayer);
        ModelLayerRegistry.register(Modelbloody_butcher_apron.LAYER_LOCATION, Modelbloody_butcher_apron::createBodyLayer);
        ModelLayerRegistry.register(Modelsniffer_carcass.LAYER_LOCATION, Modelsniffer_carcass::createBodyLayer);
        ModelLayerRegistry.register(Modelwitch_clothes.LAYER_LOCATION, Modelwitch_clothes::createBodyLayer);
        ModelLayerRegistry.register(Modelwither.LAYER_LOCATION, Modelwither::createBodyLayer);
        ModelLayerRegistry.register(Modeldragon_armor.LAYER_LOCATION, Modeldragon_armor::createBodyLayer);
        ModelLayerRegistry.register(Modelunknown.LAYER_LOCATION, Modelunknown::createBodyLayer);
        ModelLayerRegistry.register(Modelevoker_disguise.LAYER_LOCATION, Modelevoker_disguise::createBodyLayer);
        ModelLayerRegistry.register(Modelturtle_shell_chestplate.LAYER_LOCATION, Modelturtle_shell_chestplate::createBodyLayer);
        ModelLayerRegistry.register(Modelbutcher_apron.LAYER_LOCATION, Modelbutcher_apron::createBodyLayer);
        ModelLayerRegistry.register(Modelplayer_corpse.LAYER_LOCATION, Modelplayer_corpse::createBodyLayer);
        ModelLayerRegistry.register(Modelplayer_corpse_slim.SLIM_LAYER_LOCATION, Modelplayer_corpse_slim::createSlimBodyLayer);
        ModelLayerRegistry.register(Modelenderman.LAYER_LOCATION, Modelenderman::createBodyLayer);
        ModelLayerRegistry.register(Modelwitch_disguise.LAYER_LOCATION, Modelwitch_disguise::createBodyLayer);
        ModelLayerRegistry.register(Modelcash_register.LAYER_LOCATION, Modelcash_register::createBodyLayer);
        ModelLayerRegistry.register(Modelwarden_carcass.LAYER_LOCATION, Modelwarden_carcass::createBodyLayer);
        ModelLayerRegistry.register(Modelhanging_enderman.LAYER_LOCATION, Modelhanging_enderman::createBodyLayer);
        ModelLayerRegistry.register(ModelEvokerDisguise.LAYER_LOCATION, ModelEvokerDisguise::createBodyLayer);
        ModelLayerRegistry.register(Modelelder_guardian.LAYER_LOCATION, Modelelder_guardian::createBodyLayer);
    }

    public static void registerParticleProviders() {
        ParticleProviderRegistry.getInstance().register((ParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), BloodparticleParticle::provider);
        ParticleProviderRegistry.getInstance().register((ParticleType)ButcheryModParticleTypes.FEATHERS.get(), FeathersParticle::provider);
        ParticleProviderRegistry.getInstance().register((ParticleType)ButcheryModParticleTypes.FREEZERSMOKE.get(), FreezersmokeParticle::provider);
        ParticleProviderRegistry.getInstance().register((ParticleType)ButcheryModParticleTypes.SANDPARTICLE.get(), SandparticleParticle::provider);
        ParticleProviderRegistry.getInstance().register((ParticleType)ButcheryModParticleTypes.SPARKS.get(), SparksParticle::provider);
        ParticleProviderRegistry.getInstance().register((ParticleType)ButcheryModParticleTypes.WITHERSMOKE.get(), WithersmokeParticle::provider);
    }
}

