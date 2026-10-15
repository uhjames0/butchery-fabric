package net.mcreator.butchery.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.mcreator.butchery.network.EvokermaskpressMessage;
import net.mcreator.butchery.network.PillagernosepressMessage;
import net.mcreator.butchery.network.VindicatornosepressMessage;
import net.mcreator.butchery.shim.ButcheryNet;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

@Environment(value=EnvType.CLIENT)
public class ButcheryModKeyMappings {
    public static final KeyMapping EVOKERMASKPRESS = new KeyMapping("key.butchery.evokermaskpress", 67, KeyMapping.Category.MISC);
    public static final KeyMapping PILLAGERNOSEPRESS = new KeyMapping("key.butchery.pillagernosepress", 67, KeyMapping.Category.MISC);
    public static final KeyMapping VINDICATORNOSEPRESS = new KeyMapping("key.butchery.vindicatornosepress", 67, KeyMapping.Category.MISC);
    private static boolean evokerDownOld = false;
    private static boolean pillagerDownOld = false;
    private static boolean vindicatorDownOld = false;

    public static void clientTick() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            return;
        }
        boolean ev = EVOKERMASKPRESS.isDown();
        if (ev != evokerDownOld && ev) {
            ButcheryNet.sendToServer(new EvokermaskpressMessage(0, 0));
            EvokermaskpressMessage.pressAction((Player)mc.player, 0, 0);
        }
        evokerDownOld = ev;
        boolean pi = PILLAGERNOSEPRESS.isDown();
        if (pi != pillagerDownOld && pi) {
            ButcheryNet.sendToServer(new PillagernosepressMessage(0, 0));
            PillagernosepressMessage.pressAction((Player)mc.player, 0, 0);
        }
        pillagerDownOld = pi;
        boolean vi = VINDICATORNOSEPRESS.isDown();
        if (vi != vindicatorDownOld && vi) {
            ButcheryNet.sendToServer(new VindicatornosepressMessage(0, 0));
            VindicatornosepressMessage.pressAction((Player)mc.player, 0, 0);
        }
        vindicatorDownOld = vi;
    }

    public static void registerKeys() {
        KeyMappingHelper.registerKeyMapping((KeyMapping)EVOKERMASKPRESS);
        KeyMappingHelper.registerKeyMapping((KeyMapping)PILLAGERNOSEPRESS);
        KeyMappingHelper.registerKeyMapping((KeyMapping)VINDICATORNOSEPRESS);
    }
}

