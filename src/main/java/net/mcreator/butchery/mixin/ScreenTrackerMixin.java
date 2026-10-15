package net.mcreator.butchery.mixin;

import net.mcreator.butchery.ClientEnvHooks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Minecraft.class})
public abstract class ScreenTrackerMixin {
    @Inject(method={"setScreenAndShow"}, at={@At(value="TAIL")})
    private void butchery$trackScreen(Screen screen, CallbackInfo ci) {
        ClientEnvHooks.currentScreen = screen;
    }
}

