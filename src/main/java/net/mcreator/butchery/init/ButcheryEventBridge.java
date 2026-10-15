package net.mcreator.butchery.init;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.network.ButcheryModVariables;
import net.mcreator.butchery.procedures.AlexsMobsfillbloodgrateProcedure;
import net.mcreator.butchery.procedures.AlexsSmallMobsfillbloodgrateProcedure;
import net.mcreator.butchery.procedures.AxolotlacidProcedure;
import net.mcreator.butchery.procedures.AxolotlbleedingProcedure;
import net.mcreator.butchery.procedures.AxolotlbrokenProcedure;
import net.mcreator.butchery.procedures.AxolotlcarcassdropProcedure;
import net.mcreator.butchery.procedures.AxolotlcutupProcedure;
import net.mcreator.butchery.procedures.BasincollectsaltProcedure;
import net.mcreator.butchery.procedures.BatCutupProcedure;
import net.mcreator.butchery.procedures.BatacidProcedure;
import net.mcreator.butchery.procedures.BatcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.BatcarcassdropProcedure;
import net.mcreator.butchery.procedures.BeecarcassdropProcedure;
import net.mcreator.butchery.procedures.BeecutupProcedure;
import net.mcreator.butchery.procedures.BloodiedapronProcedure;
import net.mcreator.butchery.procedures.BlowupballoonProcedure;
import net.mcreator.butchery.procedures.BrainattractProcedure;
import net.mcreator.butchery.procedures.BreakhangingsausagesProcedure;
import net.mcreator.butchery.procedures.BreakheadProcedure;
import net.mcreator.butchery.procedures.BrownmooshroomcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.BrownmooshroomcarcasscutupProcedure;
import net.mcreator.butchery.procedures.BrownmooshroomcarcassdropProcedure;
import net.mcreator.butchery.procedures.CamelacidProcedure;
import net.mcreator.butchery.procedures.CamelcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.CamelcarcassdropProcedure;
import net.mcreator.butchery.procedures.CamelcutupProcedure;
import net.mcreator.butchery.procedures.CatacidProcedure;
import net.mcreator.butchery.procedures.CatcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.CatcarcassbrokenProcedure;
import net.mcreator.butchery.procedures.CatcarcasscutupProcedure;
import net.mcreator.butchery.procedures.CatcarcassdropProcedure;
import net.mcreator.butchery.procedures.CavespidercarcassdropProcedure;
import net.mcreator.butchery.procedures.CavespidercutupProcedure;
import net.mcreator.butchery.procedures.ChangebottlemodeProcedure;
import net.mcreator.butchery.procedures.ChangebucketmodeProcedure;
import net.mcreator.butchery.procedures.ChickenacidProcedure;
import net.mcreator.butchery.procedures.ChickencarcassbleedingProcedure;
import net.mcreator.butchery.procedures.ChickencarcassdropProcedure;
import net.mcreator.butchery.procedures.ChickencutupProcedure;
import net.mcreator.butchery.procedures.ChickenwishbonepluckProcedure;
import net.mcreator.butchery.procedures.CleanbloodProcedure;
import net.mcreator.butchery.procedures.CodcarcassdropProcedure;
import net.mcreator.butchery.procedures.CodcutupProcedure;
import net.mcreator.butchery.procedures.CompostingitemsProcedure;
import net.mcreator.butchery.procedures.ConvertingskinProcedure;
import net.mcreator.butchery.procedures.CowacidProcedure;
import net.mcreator.butchery.procedures.CowcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.CowcarcassdropProcedure;
import net.mcreator.butchery.procedures.CowcutupProcedure;
import net.mcreator.butchery.procedures.CreeperacidProcedure;
import net.mcreator.butchery.procedures.CreepercarcassbleedingProcedure;
import net.mcreator.butchery.procedures.CreepercarcasscutupProcedure;
import net.mcreator.butchery.procedures.CreepercarcassdropProcedure;
import net.mcreator.butchery.procedures.DeflateballoonProcedure;
import net.mcreator.butchery.procedures.DolphinacidProcedure;
import net.mcreator.butchery.procedures.DolphincarcassbleedingProcedure;
import net.mcreator.butchery.procedures.DolphincarcassdropProcedure;
import net.mcreator.butchery.procedures.DolphincutupProcedure;
import net.mcreator.butchery.procedures.DonkeyacidProcedure;
import net.mcreator.butchery.procedures.DonkeycarcassbleedingProcedure;
import net.mcreator.butchery.procedures.DonkeycarcasscutupProcedure;
import net.mcreator.butchery.procedures.DonkeycarcassdropProcedure;
import net.mcreator.butchery.procedures.DrainedaxolotlbrokenProcedure;
import net.mcreator.butchery.procedures.DrainedcatcarcassbrokenProcedure;
import net.mcreator.butchery.procedures.DrainedendermancarcassbrokenProcedure;
import net.mcreator.butchery.procedures.DrainedfrogcarcassbrokenProcedure;
import net.mcreator.butchery.procedures.DrainedllamacarcassbrokenProcedure;
import net.mcreator.butchery.procedures.DrainedsniffercarcassbrokenProcedure;
import net.mcreator.butchery.procedures.DrownedacidProcedure;
import net.mcreator.butchery.procedures.DrownedcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.DrownedcarcasscutupProcedure;
import net.mcreator.butchery.procedures.DrownedcarcassdropProcedure;
import net.mcreator.butchery.procedures.ElderguardiandropProcedure;
import net.mcreator.butchery.procedures.EmptybasinProcedure;
import net.mcreator.butchery.procedures.EnderdragondropProcedure;
import net.mcreator.butchery.procedures.EndermanbleedingProcedure;
import net.mcreator.butchery.procedures.EndermancarcassdropProcedure;
import net.mcreator.butchery.procedures.EndermancutupProcedure;
import net.mcreator.butchery.procedures.EndermanheartdiscetingProcedure;
import net.mcreator.butchery.procedures.EndermitecarcassdropProcedure;
import net.mcreator.butchery.procedures.EndermitecutupProcedure;
import net.mcreator.butchery.procedures.EvokeracidProcedure;
import net.mcreator.butchery.procedures.EvokercorpsebleedingProcedure;
import net.mcreator.butchery.procedures.EvokercorpsedropProcedure;
import net.mcreator.butchery.procedures.EvokercutupProcedure;
import net.mcreator.butchery.procedures.FirstcarcassadvancementProcedure;
import net.mcreator.butchery.procedures.FirstjoinguideProcedure;
import net.mcreator.butchery.procedures.FishacidProcedure;
import net.mcreator.butchery.procedures.FoxacidProcedure;
import net.mcreator.butchery.procedures.FoxcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.FoxcarcassdropProcedure;
import net.mcreator.butchery.procedures.FoxcutupProcedure;
import net.mcreator.butchery.procedures.FrogcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.FrogcarcasscutupProcedure;
import net.mcreator.butchery.procedures.FrogcarcassdropProcedure;
import net.mcreator.butchery.procedures.FrogontrayhintProcedure;
import net.mcreator.butchery.procedures.GlowsquidcarcassdropProcedure;
import net.mcreator.butchery.procedures.GlowsquidcutupProcedure;
import net.mcreator.butchery.procedures.GoatCutupProcedure;
import net.mcreator.butchery.procedures.GoatacidProcedure;
import net.mcreator.butchery.procedures.GoatcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.GoatcarcassdropProcedure;
import net.mcreator.butchery.procedures.GrantHangingaroundadvancementProcedure;
import net.mcreator.butchery.procedures.GrantPlayertickadvancementsProcedure;
import net.mcreator.butchery.procedures.GrantcutabovetherestadvancementProcedure;
import net.mcreator.butchery.procedures.GranteverypartcountsadvancementProcedure;
import net.mcreator.butchery.procedures.GrantfirstbloodadvancementProcedure;
import net.mcreator.butchery.procedures.GrantheadsupProcedure;
import net.mcreator.butchery.procedures.GrantleatherlatethanneveradvancementProcedure;
import net.mcreator.butchery.procedures.GrantseasontoperfectionadvancementProcedure;
import net.mcreator.butchery.procedures.GrantskininthegameadvancementProcedure;
import net.mcreator.butchery.procedures.GrantsteptowardsleatheradvancementProcedure;
import net.mcreator.butchery.procedures.GuardiancarcassbleedingProcedure;
import net.mcreator.butchery.procedures.GuardiancarcassdropProcedure;
import net.mcreator.butchery.procedures.GuardiancutupProcedure;
import net.mcreator.butchery.procedures.HangcarcasshintProcedure;
import net.mcreator.butchery.procedures.HangingAxolotlcutupProcedure;
import net.mcreator.butchery.procedures.HangingBrownmooshroomcarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingDonkeycarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingMulecarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingPandacarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingPiglincutupProcedure;
import net.mcreator.butchery.procedures.HangingPillagercorpsecutupProcedure;
import net.mcreator.butchery.procedures.HangingPolarbearcutupProcedure;
import net.mcreator.butchery.procedures.HangingRedmooshroomcarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingSnowfoxcutupProcedure;
import net.mcreator.butchery.procedures.HangingWitherskeletoncutupProcedure;
import net.mcreator.butchery.procedures.HangingZombiePiglincutupProcedure;
import net.mcreator.butchery.procedures.HangingZombiehorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingZombievillagercutupProcedure;
import net.mcreator.butchery.procedures.HangingbatcutupProcedure;
import net.mcreator.butchery.procedures.HangingcamelcarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingcatcarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingcavespidercutupProcedure;
import net.mcreator.butchery.procedures.HangingchickencutupProcedure;
import net.mcreator.butchery.procedures.HangingcowcutupProcedure;
import net.mcreator.butchery.procedures.HangingcreepercarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingdolphincutupProcedure;
import net.mcreator.butchery.procedures.HangingdrownedcutupProcedure;
import net.mcreator.butchery.procedures.HangingendermancutupProcedure;
import net.mcreator.butchery.procedures.HangingevokercutupProcedure;
import net.mcreator.butchery.procedures.HangingfoxcutupProcedure;
import net.mcreator.butchery.procedures.HangingglowsquidcutupProcedure;
import net.mcreator.butchery.procedures.HanginggoatcutupProcedure;
import net.mcreator.butchery.procedures.HangingguardiancutupProcedure;
import net.mcreator.butchery.procedures.HanginghoglincutupProcedure;
import net.mcreator.butchery.procedures.HanginghuskcutupProcedure;
import net.mcreator.butchery.procedures.HangingllamacutupProcedure;
import net.mcreator.butchery.procedures.HangingocelotcutupProcedure;
import net.mcreator.butchery.procedures.HangingphantomcutupProcedure;
import net.mcreator.butchery.procedures.HangingpigcutupProcedure;
import net.mcreator.butchery.procedures.HangingpiglinbrutecutupProcedure;
import net.mcreator.butchery.procedures.HangingplayercutupProcedure;
import net.mcreator.butchery.procedures.HangingrabbitcutupProcedure;
import net.mcreator.butchery.procedures.HangingregularblackhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingregularbrownhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingregularchestnuthorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingregularcreamyhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingregulardarkbrownhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingregulargrayhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingregularwhitehorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingsheepcutupProcedure;
import net.mcreator.butchery.procedures.HangingskeletoncutupProcedure;
import net.mcreator.butchery.procedures.HangingskeletonhorsecutupProcedure;
import net.mcreator.butchery.procedures.HangingskincatcarcasscutupProcedure;
import net.mcreator.butchery.procedures.HangingsniffercutupProcedure;
import net.mcreator.butchery.procedures.HangingspidercutupProcedure;
import net.mcreator.butchery.procedures.HangingsquidcutupProcedure;
import net.mcreator.butchery.procedures.HangingstraycorpsecutupProcedure;
import net.mcreator.butchery.procedures.HangingstridercutupProcedure;
import net.mcreator.butchery.procedures.HangingturtlecutupProcedure;
import net.mcreator.butchery.procedures.HangingvillagercutupProcedure;
import net.mcreator.butchery.procedures.HangingvindicatorcorpsecutupProcedure;
import net.mcreator.butchery.procedures.HangingwitchcutupProcedure;
import net.mcreator.butchery.procedures.HangingwolfcutupProcedure;
import net.mcreator.butchery.procedures.HangingzoglincutupProcedure;
import net.mcreator.butchery.procedures.HangingzombiecutupProcedure;
import net.mcreator.butchery.procedures.HoglinacidProcedure;
import net.mcreator.butchery.procedures.HoglinbleedingProcedure;
import net.mcreator.butchery.procedures.HoglincarcassdropProcedure;
import net.mcreator.butchery.procedures.HoglincutupProcedure;
import net.mcreator.butchery.procedures.HookplacedProcedure;
import net.mcreator.butchery.procedures.HorseacidProcedure;
import net.mcreator.butchery.procedures.HorseblackdropProcedure;
import net.mcreator.butchery.procedures.HorsebrowndropProcedure;
import net.mcreator.butchery.procedures.HorsechestnutdropProcedure;
import net.mcreator.butchery.procedures.HorsecreamydropProcedure;
import net.mcreator.butchery.procedures.HorsedarkbrowndropProcedure;
import net.mcreator.butchery.procedures.HorsegraydropProcedure;
import net.mcreator.butchery.procedures.HorsewhitedropProcedure;
import net.mcreator.butchery.procedures.HuskacidProcedure;
import net.mcreator.butchery.procedures.HuskcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.HuskcarcasscutupProcedure;
import net.mcreator.butchery.procedures.HuskcarcassdropProcedure;
import net.mcreator.butchery.procedures.IceybonemealuseProcedure;
import net.mcreator.butchery.procedures.IronGolemCutUpProcedure;
import net.mcreator.butchery.procedures.IronGolemDropProcedure;
import net.mcreator.butchery.procedures.JarrightclickedbrainProcedure;
import net.mcreator.butchery.procedures.LlamaacidProcedure;
import net.mcreator.butchery.procedures.LlamacarcassbleedingProcedure;
import net.mcreator.butchery.procedures.LlamacarcassbrokenProcedure;
import net.mcreator.butchery.procedures.LlamacarcassdropProcedure;
import net.mcreator.butchery.procedures.LlamacutupProcedure;
import net.mcreator.butchery.procedures.MagmacarcassdropProcedure;
import net.mcreator.butchery.procedures.MagmacutupProcedure;
import net.mcreator.butchery.procedures.MediummagmacutupProcedure;
import net.mcreator.butchery.procedures.MediumslimecutupProcedure;
import net.mcreator.butchery.procedures.MooshroomacidProcedure;
import net.mcreator.butchery.procedures.MuleacidProcedure;
import net.mcreator.butchery.procedures.MulecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.MulecarcasscutupProcedure;
import net.mcreator.butchery.procedures.MulecarcassdropProcedure;
import net.mcreator.butchery.procedures.OcelotacidProcedure;
import net.mcreator.butchery.procedures.OcelotcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.OcelotcarcassdropProcedure;
import net.mcreator.butchery.procedures.OcelotcutupProcedure;
import net.mcreator.butchery.procedures.PandaacidProcedure;
import net.mcreator.butchery.procedures.PandacarcassbleedingProcedure;
import net.mcreator.butchery.procedures.PandacarcasscutupProcedure;
import net.mcreator.butchery.procedures.PandacarcassdropProcedure;
import net.mcreator.butchery.procedures.PayeracidProcedure;
import net.mcreator.butchery.procedures.PhantomacidProcedure;
import net.mcreator.butchery.procedures.PhantombleedingProcedure;
import net.mcreator.butchery.procedures.PhantomcarcassdropProcedure;
import net.mcreator.butchery.procedures.PhantomcutupProcedure;
import net.mcreator.butchery.procedures.PigacidProcedure;
import net.mcreator.butchery.procedures.PigcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.PigcarcassdropProcedure;
import net.mcreator.butchery.procedures.PigcutupProcedure;
import net.mcreator.butchery.procedures.PiglinacidProcedure;
import net.mcreator.butchery.procedures.PiglinbrutecorpsedropProcedure;
import net.mcreator.butchery.procedures.PiglinbrutecutupProcedure;
import net.mcreator.butchery.procedures.PiglincorpsebleedingProcedure;
import net.mcreator.butchery.procedures.PiglincorpsecutupProcedure;
import net.mcreator.butchery.procedures.PiglincorpsedropProcedure;
import net.mcreator.butchery.procedures.PillagercorpsebleedingProcedure;
import net.mcreator.butchery.procedures.PillagercorpsecutupProcedure;
import net.mcreator.butchery.procedures.PillagercorpsedropProcedure;
import net.mcreator.butchery.procedures.PillagermaskProcedure;
import net.mcreator.butchery.procedures.PlaceBrownmooshroomcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceCookedbloodsausagesonhookProcedure;
import net.mcreator.butchery.procedures.PlaceMulecarcassProcedure;
import net.mcreator.butchery.procedures.PlacePandacarcassProcedure;
import net.mcreator.butchery.procedures.PlacePiglinbrutecorpseProcedure;
import net.mcreator.butchery.procedures.PlacePiglincorpseProcedure;
import net.mcreator.butchery.procedures.PlaceRedmooshroomcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceShulkercarcassProcedure;
import net.mcreator.butchery.procedures.PlaceSnowfoxcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceStrayProcedure;
import net.mcreator.butchery.procedures.PlaceTurtlecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceWitherskeletonProcedure;
import net.mcreator.butchery.procedures.PlaceZombiehorsecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceZombievillagercorpseProcedure;
import net.mcreator.butchery.procedures.PlacebatcarcassProcedure;
import net.mcreator.butchery.procedures.PlacebeecarcassProcedure;
import net.mcreator.butchery.procedures.PlacecamelcarcassProcedure;
import net.mcreator.butchery.procedures.PlacecarcassonspitroastProcedure;
import net.mcreator.butchery.procedures.PlacecatcarcassProcedure;
import net.mcreator.butchery.procedures.PlacecavespidercarcassProcedure;
import net.mcreator.butchery.procedures.PlacechickencarcassProcedure;
import net.mcreator.butchery.procedures.PlacecoldchickencarcassProcedure;
import net.mcreator.butchery.procedures.PlacewarmchickencarcassProcedure;
import net.mcreator.butchery.procedures.PlacecodcarcassProcedure;
import net.mcreator.butchery.procedures.PlacecookedsausagesonhookProcedure;
import net.mcreator.butchery.procedures.PlacecowcarcassProcedure;
import net.mcreator.butchery.procedures.PlacecoldcowcarcassProcedure;
import net.mcreator.butchery.procedures.PlacewarmcowcarcassProcedure;
import net.mcreator.butchery.procedures.PlacecreepercarcassProcedure;
import net.mcreator.butchery.procedures.PlacedAxolotlcarcassProcedure;
import net.mcreator.butchery.procedures.PlacedAxolotlskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedChickenskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedCreeperskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedDolphinskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedDonkeyskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedGuardiancarcassProcedure;
import net.mcreator.butchery.procedures.PlacedHoglinskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedMooshroomskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedMuleskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedOcelotskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedPandaskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedPiglinskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedPillagercorpseProcedure;
import net.mcreator.butchery.procedures.PlacedPolarbearcarcassProcedure;
import net.mcreator.butchery.procedures.PlacedPolarbearskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedVindicatorcorpseProcedure;
import net.mcreator.butchery.procedures.PlacedbatskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedcamelskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedcatskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedcowskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedevokerskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedfoxcarcassProcedure;
import net.mcreator.butchery.procedures.PlacedfoxskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedgoatskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedllamaskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedolphincarcassProcedure;
import net.mcreator.butchery.procedures.PlacedonkeycarcassProcedure;
import net.mcreator.butchery.procedures.PlacedphantomskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedpigskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedrownedcarcassProcedure;
import net.mcreator.butchery.procedures.PlacedsheepskeletonProcedure;
import net.mcreator.butchery.procedures.PlacedwolfskeletonProcedure;
import net.mcreator.butchery.procedures.PlaceendermancarcassProcedure;
import net.mcreator.butchery.procedures.PlaceendermitecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceevokercorpseProcedure;
import net.mcreator.butchery.procedures.PlacefrogcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceglowsquidcarcassProcedure;
import net.mcreator.butchery.procedures.PlacegoatcarcassProcedure;
import net.mcreator.butchery.procedures.PlacehoglincarcassProcedure;
import net.mcreator.butchery.procedures.PlacehuskcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceirongolemProcedure;
import net.mcreator.butchery.procedures.PlacellamacarcassProcedure;
import net.mcreator.butchery.procedures.PlacemagmacarcassProcedure;
import net.mcreator.butchery.procedures.PlaceocelotcarcassProcedure;
import net.mcreator.butchery.procedures.PlacephantomcarcassProcedure;
import net.mcreator.butchery.procedures.PlacepigcarcassProcedure;
import net.mcreator.butchery.procedures.PlacecoldpigcarcassProcedure;
import net.mcreator.butchery.procedures.PlacewarmpigcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceplayercorpseProcedure;
import net.mcreator.butchery.procedures.PlacepufferfishcarcassProcedure;
import net.mcreator.butchery.procedures.PlacerabbitcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceravageronhookProcedure;
import net.mcreator.butchery.procedures.PlacerawbloodsausagesonhookProcedure;
import net.mcreator.butchery.procedures.PlacerawsausagesonhookProcedure;
import net.mcreator.butchery.procedures.PlaceregularblackhorsecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceregularbrownhorsecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceregularchestnuthorsecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceregularcreamyhorsecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceregulardarkbrownhorsecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceregulargrayhorsecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceregularwhitehorsecarcassProcedure;
import net.mcreator.butchery.procedures.PlacesalmoncarcassProcedure;
import net.mcreator.butchery.procedures.PlacesheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceorangesheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlacemagentasheepcarcassProcedure;
import net.mcreator.butchery.procedures.Placelight_bluesheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceyellowsheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlacelimesheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlacepinksheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlacegraysheepcarcassProcedure;
import net.mcreator.butchery.procedures.Placelight_graysheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlacecyansheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlacepurplesheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlacebluesheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlacebrownsheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlacegreensheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceredsheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceblacksheepcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceshellboatProcedure;
import net.mcreator.butchery.procedures.PlaceshellboatonblockProcedure;
import net.mcreator.butchery.procedures.PlacesilverfishcarcassProcedure;
import net.mcreator.butchery.procedures.PlaceskeletonProcedure;
import net.mcreator.butchery.procedures.PlaceskeletonhorsecarcassProcedure;
import net.mcreator.butchery.procedures.PlaceslimecarcassProcedure;
import net.mcreator.butchery.procedures.PlacespidercarcassProcedure;
import net.mcreator.butchery.procedures.PlacespitroastProcedure;
import net.mcreator.butchery.procedures.PlacesquidcarcassProcedure;
import net.mcreator.butchery.procedures.PlacestridercarcassProcedure;
import net.mcreator.butchery.procedures.PlacevillagercorpseProcedure;
import net.mcreator.butchery.procedures.PlacewitchcorpseProcedure;
import net.mcreator.butchery.procedures.PlacewolfcarcassProcedure;
import net.mcreator.butchery.procedures.PlacezoglincarcassProcedure;
import net.mcreator.butchery.procedures.PlacezombiecarcassProcedure;
import net.mcreator.butchery.procedures.PlacezombiepiglincorpseProcedure;
import net.mcreator.butchery.procedures.PlayercorpsedropProcedure;
import net.mcreator.butchery.procedures.PlayercutupProcedure;
import net.mcreator.butchery.procedures.PolarbearacidProcedure;
import net.mcreator.butchery.procedures.PolarbearbleedingProcedure;
import net.mcreator.butchery.procedures.PolarbearcarcassdropProcedure;
import net.mcreator.butchery.procedures.PolarbearcutupProcedure;
import net.mcreator.butchery.procedures.PufferfishcarcassdropProcedure;
import net.mcreator.butchery.procedures.PufferfishcutupProcedure;
import net.mcreator.butchery.procedures.PufferfishcutuphangingProcedure;
import net.mcreator.butchery.procedures.RabbitcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.RabbitcarcassdropProcedure;
import net.mcreator.butchery.procedures.RabbitcutupProcedure;
import net.mcreator.butchery.procedures.RavagerdropProcedure;
import net.mcreator.butchery.procedures.RedmooshroomcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.RedmooshroomcarcasscutupProcedure;
import net.mcreator.butchery.procedures.RedmooshroomcarcassdropProcedure;
import net.mcreator.butchery.procedures.RegularblackhorsecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.RegularblackhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.RegularbrownhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.RegularchestnuthorsecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.RegularchestnuthorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.RegularcreamyhorsecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.RegularcreamyhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.RegulardarkbrownhorsecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.RegulardarkbrownhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.RegulargrayhorsecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.RegulargrayhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.RegularwhitehorsecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.RegularwhitehorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.RepairedIronGolemCutUpProcedure;
import net.mcreator.butchery.procedures.RepairgolemProcedure;
import net.mcreator.butchery.procedures.RetrieveskinProcedure;
import net.mcreator.butchery.procedures.RightclickdragonheadmountsProcedure;
import net.mcreator.butchery.procedures.RightclickheadmountProcedure;
import net.mcreator.butchery.procedures.RopeplacedProcedure;
import net.mcreator.butchery.procedures.SalmoncarcassdropProcedure;
import net.mcreator.butchery.procedures.SalmoncutupProcedure;
import net.mcreator.butchery.procedures.SaltformationbrokenProcedure;
import net.mcreator.butchery.procedures.SheepacidProcedure;
import net.mcreator.butchery.procedures.SheepcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.SheepcarcassdropProcedure;
import net.mcreator.butchery.procedures.SheepcutupProcedure;
import net.mcreator.butchery.procedures.ShellboatentityishurtProcedure;
import net.mcreator.butchery.procedures.ShulkercarcassdropProcedure;
import net.mcreator.butchery.procedures.ShulkercutupProcedure;
import net.mcreator.butchery.procedures.SilverfishcarcassdropProcedure;
import net.mcreator.butchery.procedures.SilverfishcutupProcedure;
import net.mcreator.butchery.procedures.SkeletoncutupProcedure;
import net.mcreator.butchery.procedures.SkeletondropProcedure;
import net.mcreator.butchery.procedures.SkeletonhorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.SkeletonhorsecarcassdropProcedure;
import net.mcreator.butchery.procedures.SkincatcarcasscutupProcedure;
import net.mcreator.butchery.procedures.SlimecarcassdropProcedure;
import net.mcreator.butchery.procedures.SlimecutupProcedure;
import net.mcreator.butchery.procedures.SnifferbleedingProcedure;
import net.mcreator.butchery.procedures.SniffercarcassdropProcedure;
import net.mcreator.butchery.procedures.SniffercutupProcedure;
import net.mcreator.butchery.procedures.SnowfoxcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.SnowfoxcutupProcedure;
import net.mcreator.butchery.procedures.SpidercarcassdropProcedure;
import net.mcreator.butchery.procedures.SpidercutupProcedure;
import net.mcreator.butchery.procedures.SquidcarcassdropProcedure;
import net.mcreator.butchery.procedures.SquidcutupProcedure;
import net.mcreator.butchery.procedures.StraycorpsecutupProcedure;
import net.mcreator.butchery.procedures.StraycorpsedropProcedure;
import net.mcreator.butchery.procedures.StridercarcassdropProcedure;
import net.mcreator.butchery.procedures.StridercutupProcedure;
import net.mcreator.butchery.procedures.TurtlecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.TurtlecarcassdropProcedure;
import net.mcreator.butchery.procedures.TurtlecutupProcedure;
import net.mcreator.butchery.procedures.VillagercorpsebleedingProcedure;
import net.mcreator.butchery.procedures.VillagercorpsedropProcedure;
import net.mcreator.butchery.procedures.VillagercutupProcedure;
import net.mcreator.butchery.procedures.VariantSkinrackProcedure;
import net.mcreator.butchery.procedures.VindicatorcorpsebleedingProcedure;
import net.mcreator.butchery.procedures.VindicatorcorpsecutupProcedure;
import net.mcreator.butchery.procedures.VindicatorcorpsedropProcedure;
import net.mcreator.butchery.procedures.WardendropProcedure;
import net.mcreator.butchery.procedures.WelcomemessageProcedure;
import net.mcreator.butchery.procedures.WetragProcedure;
import net.mcreator.butchery.procedures.WetragcauldronProcedure;
import net.mcreator.butchery.procedures.WetspongeProcedure;
import net.mcreator.butchery.procedures.WetspongecauldronProcedure;
import net.mcreator.butchery.procedures.WishbonebreakProcedure;
import net.mcreator.butchery.procedures.WitchCorpseDropProcedure;
import net.mcreator.butchery.procedures.WitchCutUpProcedure;
import net.mcreator.butchery.procedures.WitchcorpsebleedingProcedure;
import net.mcreator.butchery.procedures.WitherSkeletoncutupProcedure;
import net.mcreator.butchery.procedures.WitherSkeletondropProcedure;
import net.mcreator.butchery.procedures.WitherdropProcedure;
import net.mcreator.butchery.procedures.WitheredheartchanceProcedure;
import net.mcreator.butchery.procedures.WolfacidProcedure;
import net.mcreator.butchery.procedures.WolfcarcassbleedingProcedure;
import net.mcreator.butchery.procedures.WolfcarcassdropProcedure;
import net.mcreator.butchery.procedures.WolfcutupProcedure;
import net.mcreator.butchery.procedures.WoodenspitrotisserieBlockDestroyedByPlayerProcedure;
import net.mcreator.butchery.procedures.ZoglinbleedingProcedure;
import net.mcreator.butchery.procedures.ZoglincarcassdropProcedure;
import net.mcreator.butchery.procedures.ZoglincutupProcedure;
import net.mcreator.butchery.procedures.ZombiePiglincorpsebleedingProcedure;
import net.mcreator.butchery.procedures.ZombiePiglincorpsecutupProcedure;
import net.mcreator.butchery.procedures.ZombiePiglincorpsedropProcedure;
import net.mcreator.butchery.procedures.ZombieVillagercorpsebleedingProcedure;
import net.mcreator.butchery.procedures.ZombieVillagercorpsedropProcedure;
import net.mcreator.butchery.procedures.ZombieVillagercutupProcedure;
import net.mcreator.butchery.procedures.ZombieacidProcedure;
import net.mcreator.butchery.procedures.ZombiecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.ZombiecarcasscutupProcedure;
import net.mcreator.butchery.procedures.ZombiecarcassdropProcedure;
import net.mcreator.butchery.procedures.ZombiehorsecarcassbleedingProcedure;
import net.mcreator.butchery.procedures.ZombiehorsecarcasscutupProcedure;
import net.mcreator.butchery.procedures.ZombiehorsecarcassdropProcedure;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ButcheryEventBridge {
    public static void registerServerEvents() {
        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
            if (world.isClientSide()) {
                return InteractionResult.PASS;
            }
            ShimEvent.RightClickBlockShim ev = new ShimEvent.RightClickBlockShim(player, world, hand, hit);
            try {
                FrogcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedfoxskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RopeplacedProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacecreepercarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                MuleacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedAxolotlcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                JarrightclickedbrainProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingsquidcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZombiehorsecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacespitroastProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                AxolotlacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedMuleskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingBrownmooshroomcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RedmooshroomcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceStrayProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZombieVillagercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                WitchCutUpProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SnifferbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GuardiancarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingregularbrownhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacerawbloodsausagesonhookProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedllamaskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SheepcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacephantomcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingcatcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ChickencarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                DrownedcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingPolarbearcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacestridercarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacesheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlaceorangesheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlacemagentasheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                Placelight_bluesheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlaceyellowsheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlacelimesheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlacepinksheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlacegraysheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                Placelight_graysheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlacecyansheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlacepurplesheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlacebluesheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlacebrownsheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlacegreensheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlaceredsheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
try {
                PlaceblacksheepcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GrantskininthegameadvancementProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingstraycorpsecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PandacarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacePiglincorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingregularwhitehorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingpiglinbrutecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegularchestnuthorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingcreepercarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacebeecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedbatskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacePandacarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                MagmacutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HanginghuskcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceBrownmooshroomcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                BrownmooshroomcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                EndermanbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SkeletonhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                AxolotlbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingbatcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceendermancarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                WitchcorpsebleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SkeletoncutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedOcelotskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingregulardarkbrownhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegulardarkbrownhorsecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingevokercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceravageronhookProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CowcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceirongolemProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingregularchestnuthorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CodcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CatcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedPolarbearcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                EmptybasinProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZombiePiglincorpsebleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingskeletonhorsecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacechickencarcassProcedure.onRightClickBlock(ev);
            try {
                PlacecoldchickencarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacewarmchickencarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacecodcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SalmoncutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegularblackhorsecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PufferfishcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RedmooshroomcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                BatCutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                LlamacutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SquidcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacepigcarcassProcedure.onRightClickBlock(ev);
            try {
                PlacecoldpigcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacewarmpigcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CreepercarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HorseacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacecatcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegularwhitehorsecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingwitchcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacehuskcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingZombiePiglincutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HoglinbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacegoatcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedAxolotlskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingPiglincutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CreeperacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                DonkeycarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                BreakheadProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedpigskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SlimecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZombiecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceshellboatonblockProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CamelcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SniffercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GrantfirstbloodadvancementProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceregularcreamyhorsecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PiglincorpsebleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                VindicatorcorpsecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingSnowfoxcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacesquidcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingregularblackhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                EvokercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CavespidercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingPandacarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingglowsquidcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RabbitcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                FrogcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RepairgolemProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedwolfskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                BeecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingzoglincutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PandaacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                StraycorpsecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacewitchcorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                StridercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacefrogcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedsheepskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingPillagercorpsecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PillagermaskProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedChickenskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                OcelotacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PolarbearacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacehoglincarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingvillagercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegularchestnuthorsecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegulargrayhorsecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacePiglinbrutecorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingsniffercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedPiglinskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZombiehorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedolphincarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacerabbitcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceWitherskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GranteverypartcountsadvancementProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GoatcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PolarbearbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                BrownmooshroomcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RetrieveskinProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ChickencutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingguardiancutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingskincatcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingturtlecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                FrogontrayhintProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HanginghoglincutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingZombievillagercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingphantomcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegulargrayhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GlowsquidcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacellamacarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RightclickdragonheadmountsProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                OcelotcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacesilverfishcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CompostingitemsProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GrantseasontoperfectionadvancementProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                MooshroomacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceslimecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacespidercarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GrantcutabovetherestadvancementProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                MediummagmacutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegularbrownhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingplayercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceregularbrownhorsecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangcarcasshintProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZoglincutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                TurtlecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingZombiehorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HuskcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                BatcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PandacarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                DrownedacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                LlamacarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                VindicatorcorpsebleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingchickencutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RabbitcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                WetragcauldronProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZombieVillagercorpsebleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedGuardiancarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingwolfcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceMulecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingregularcreamyhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                EvokeracidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CreepercarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CowcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacezombiepiglincorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                IronGolemCutUpProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceendermitecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedMooshroomskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                AxolotlcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedrownedcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceplayercorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                DolphinacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacebatcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                EndermitecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                BatacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedPandaskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedDonkeyskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PayeracidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingstridercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SnowfoxcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HuskcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                FishacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SheepacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                WolfacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceZombiehorsecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                FoxacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZombiecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HanginggoatcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PhantomacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                FoxcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                MediumslimecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingllamacutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingsheepcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GrantsteptowardsleatheradvancementProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceCookedbloodsausagesonhookProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegularblackhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HuskacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PillagercorpsebleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZombieacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SheepcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceregulardarkbrownhorsecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingWitherskeletoncutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CamelacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacevillagercorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingspidercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                OcelotcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedphantomskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PigacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GoatacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CowacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedonkeycarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedPolarbearskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PillagercorpsecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedCreeperskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceregularchestnuthorsecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RightclickheadmountProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZoglinbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                DonkeycarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                WetspongecauldronProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacezoglincarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PhantombleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingMulecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegularwhitehorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceregularwhitehorsecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingzombiecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedcowskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedcamelskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingendermancutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SkincatcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceocelotcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingocelotcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ShulkercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ConvertingskinProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                AlexsMobsfillbloodgrateProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacepufferfishcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                EvokercorpsebleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacecamelcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PigcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedgoatskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                DonkeyacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacecavespidercarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PufferfishcutuphangingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PiglinbrutecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HoglincutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CatacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SpidercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingregulargrayhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingcamelcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GuardiancutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceregulargrayhorsecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingdolphincutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                MulecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingRedmooshroomcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HoglinacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegulardarkbrownhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                EndermancutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingcavespidercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlayercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingrabbitcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceShulkercarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                BasincollectsaltProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacezombiecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PiglincorpsecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ChickenacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceglowsquidcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                VillagercutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacemagmacarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacecarcassonspitroastProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PolarbearcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceRedmooshroomcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingpigcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ZombiePiglincorpsecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegularcreamyhorsecarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                LlamaacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingdrownedcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacerawsausagesonhookProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RepairedIronGolemCutUpProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceSnowfoxcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedcatskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedevokerskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingfoxcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacecookedsausagesonhookProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                WitherSkeletoncutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacecowcarcassProcedure.onRightClickBlock(ev);
            try {
                PlacecoldcowcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacewarmcowcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                MulecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                ChickenwishbonepluckProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GoatCutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                BloodiedapronProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                GrantHangingaroundadvancementProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                TurtlecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacewolfcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                FoxcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                WolfcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                DrownedcarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingcowcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingDonkeycarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SnowfoxcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PigcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceevokercorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceregularblackhorsecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                DolphincutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                AlexsSmallMobsfillbloodgrateProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CleanbloodProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedDolphinskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PiglinacidProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HookplacedProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceTurtlecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedVindicatorcorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingAxolotlcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingskeletoncutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedHoglinskeletonProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PhantomcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacesalmoncarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                RegularcreamyhorsecarcasscutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                HangingvindicatorcorpsecutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                WolfcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CamelcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                VillagercorpsebleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedfoxcarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                CatcarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceskeletonhorsecarcassProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                SilverfishcutupProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                DolphincarcassbleedingProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlaceZombievillagercorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                PlacedPillagercorpseProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            try {
                VariantSkinrackProcedure.onRightClickBlock(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useblock handler error", (Throwable)e);
            }
            return ev.canceled ? InteractionResult.FAIL : InteractionResult.PASS;
        });
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ShimEvent.RightClickItemShim ev = new ShimEvent.RightClickItemShim(player, world, hand);
            try {
                ChangebucketmodeProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            try {
                WetspongeProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            try {
                DeflateballoonProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            try {
                EndermanheartdiscetingProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            try {
                PlaceshellboatProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            try {
                ChangebottlemodeProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            try {
                IceybonemealuseProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            try {
                WetragProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            try {
                BlowupballoonProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            try {
                WishbonebreakProcedure.onRightClickItem(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] useitem handler error", (Throwable)e);
            }
            return ev.canceled ? InteractionResult.FAIL : InteractionResult.PASS;
        });
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            ShimEvent.LivingDeathShim ev = new ShimEvent.LivingDeathShim(entity, source);
            try {
                SniffercarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                FoxcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                EndermitecarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                BeecarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                LlamacarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                SpidercarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                CavespidercarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                CamelcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                ZombiecarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                ZombiehorsecarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                StridercarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                MagmacarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                GlowsquidcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                CowcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                FirstcarcassadvancementProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                SalmoncarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                PlayercorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                SlimecarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                TurtlecarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                DonkeycarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                GoatcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                PillagercorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                SilverfishcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                DolphincarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                CatcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                HorsebrowndropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                RabbitcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                PufferfishcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                WitchCorpseDropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                PandacarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                CodcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                HorsecreamydropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                HorsewhitedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                ZombiePiglincorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                IronGolemDropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                SheepcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                ElderguardiandropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                SkeletonhorsecarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                ZoglincarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                EvokercorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                PhantomcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                SquidcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                BrownmooshroomcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                HorsechestnutdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                HorsedarkbrowndropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                StraycorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                EndermancarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                RedmooshroomcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                SkeletondropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                ShulkercarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                ChickencarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                ZombieVillagercorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                GuardiancarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                WardendropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                PolarbearcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                PigcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                MulecarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                CreepercarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                WolfcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                OcelotcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                HuskcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                DrownedcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                HorsegraydropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                EnderdragondropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                FrogcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                PiglincorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                HoglincarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                WitherSkeletondropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                VillagercorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                BatcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                HorseblackdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                VindicatorcorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                PiglinbrutecorpsedropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                RavagerdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                WitherdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
            try {
                AxolotlcarcassdropProcedure.onEntityDeath(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdeath handler error", (Throwable)e);
            }
        });
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            ShimEvent.BreakShim ev = new ShimEvent.BreakShim(player, world, pos, state);
            try {
                WoodenspitrotisserieBlockDestroyedByPlayerProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                DrainedendermancarcassbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                SaltformationbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                DrainedllamacarcassbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                DrainedaxolotlbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                CatcarcassbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                BreakhangingsausagesProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                DrainedcatcarcassbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                LlamacarcassbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                DrainedfrogcarcassbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                AxolotlbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            try {
                DrainedsniffercarcassbrokenProcedure.onBlockBreak(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] break handler error", (Throwable)e);
            }
            return !ev.canceled;
        });
        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            ShimEvent.EntityJoinShim ev = new ShimEvent.EntityJoinShim(entity, (Level)world);
            try {
                BrainattractProcedure.onEntitySpawned(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] entityjoin handler error", (Throwable)e);
            }
        });
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            ShimEvent.LivingDamageShim ev = new ShimEvent.LivingDamageShim(entity, source, amount);
            try {
                WitheredheartchanceProcedure.onEntityAttacked(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdamage handler error", (Throwable)e);
            }
            try {
                GrantPlayertickadvancementsProcedure.onEntityTick(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdamage handler error", (Throwable)e);
            }
            try {
                ShellboatentityishurtProcedure.onEntityAttacked(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] livingdamage handler error", (Throwable)e);
            }
            return !ev.canceled && ev.newDamage >= 0.0f;
        });
        ServerTickEvents.END_SERVER_TICK.register(server -> {});
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ShimEvent.PlayerLoggedInShim ev = new ShimEvent.PlayerLoggedInShim((Player)handler.getPlayer());
            try {
                FirstjoinguideProcedure.onPlayerLoggedIn(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] join handler error", (Throwable)e);
            }
            try {
                WelcomemessageProcedure.onPlayerLoggedIn(ev);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.error("[Butchery] join handler error", (Throwable)e);
            }
            ButcheryModVariables.sync(handler.getPlayer());
        });
    }

    public static void playerTick(ServerPlayer sp) {
        ShimEvent.PlayerTickShim ev = new ShimEvent.PlayerTickShim((Player)sp);
        try {
            GrantheadsupProcedure.onPlayerTick(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] playertick handler error", (Throwable)e);
        }
    }

    public static void onItemPickup(Player player, ItemEntity itemEntity) {
        try {
            if (player.level().isClientSide()) {
                return;
            }
            ShimEvent.ItemPickupShim ev = new ShimEvent.ItemPickupShim(player, itemEntity);
            GrantleatherlatethanneveradvancementProcedure.onPickup(ev);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.error("[Butchery] item pickup handler error", (Throwable)e);
        }
    }
}

