package net.mcreator.butchery;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryNetworking;
import net.mcreator.butchery.shim.ButcheryPayloadContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

@Environment(value=EnvType.CLIENT)
public class ClientEnvHooks {
    public static volatile Screen currentScreen;

    public static Player clientPlayer() {
        return Minecraft.getInstance().player;
    }

    public static boolean clientConnected() {
        return Minecraft.getInstance().getConnection() != null;
    }

    public static void registerClientPayloadReceiver(ButcheryNetworking.PayloadEntry e) {
        ClientPlayNetworking.registerGlobalReceiver(e.type(), (payload, context) -> {
            try {
                e.handle(payload, new ButcheryPayloadContext((Player)context.client().player, null, null));
            }
            catch (Exception ex) {
                ButcheryMod.LOGGER.error("[Butchery] client network handler error", (Throwable)ex);
            }
        });
    }

    public static int basinWaterColor(BlockState state, BlockGetter level, BlockPos pos, int tintIndex) {
        BlockAndTintGetter batg;
        block3: {
            block2: {
                if (!(level instanceof BlockAndTintGetter)) break block2;
                batg = (BlockAndTintGetter)level;
                if (pos != null) break block3;
            }
            return -1;
        }
        return BiomeColors.getAverageWaterColor((BlockAndTintGetter)batg, (BlockPos)pos);
    }
}

