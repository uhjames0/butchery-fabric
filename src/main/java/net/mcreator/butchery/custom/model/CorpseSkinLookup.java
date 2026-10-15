package net.mcreator.butchery.custom.model;

import com.mojang.authlib.GameProfile;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.world.entity.player.PlayerSkin;

@Environment(value=EnvType.CLIENT)
public final class CorpseSkinLookup {
    private static final Map<UUID, PlayerSkin> SKINS = new ConcurrentHashMap<UUID, PlayerSkin>();
    private static final Set<UUID> REQUESTED = ConcurrentHashMap.newKeySet();

    private CorpseSkinLookup() {
    }

    public static PlayerSkin get(String uuidString, String playerName) {
        if (uuidString != null && !uuidString.isEmpty()) {
            try {
                PlayerInfo playerInfo;
                UUID uuid = UUID.fromString(uuidString);
                Minecraft minecraft = Minecraft.getInstance();
                if (minecraft.getConnection() != null && (playerInfo = minecraft.getConnection().getPlayerInfo(uuid)) != null) {
                    PlayerSkin skin = playerInfo.getSkin();
                    SKINS.put(uuid, skin);
                    return skin;
                }
                PlayerSkin cached = SKINS.get(uuid);
                if (cached != null) {
                    return cached;
                }
                GameProfile fallbackProfile = new GameProfile(uuid, playerName != null && !playerName.isEmpty() ? playerName : null);
                if (REQUESTED.add(uuid)) {
                    // empty if block
                }
                return DefaultPlayerSkin.get((UUID)uuid);
            }
            catch (Exception var7) {
                return DefaultPlayerSkin.get((UUID)new UUID(0L, 0L));
            }
        }
        return DefaultPlayerSkin.get((UUID)new UUID(0L, 0L));
    }
}

