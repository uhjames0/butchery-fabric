package net.mcreator.butchery.client;

import java.util.List;
import java.util.function.BooleanSupplier;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.mcreator.butchery.procedures.Cleaver_hint_conditionProcedure;
import net.mcreator.butchery.procedures.HacksawhintoverlayProcedure;
import net.mcreator.butchery.procedures.HammerhintoverlayProcedure;
import net.mcreator.butchery.procedures.RagskinrackhintoverlayProcedure;
import net.mcreator.butchery.procedures.SalthintoverlayProcedure;
import net.mcreator.butchery.procedures.SkinningknifehintoverlayProcedure;
import net.mcreator.butchery.procedures.SkinoverlayhintProcedure;
import net.mcreator.butchery.procedures.WaterhintoverlayProcedure;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;

/**
 * Ported hint overlays (originally NeoForge RenderGuiEvent.Pre handlers in
 * net.mcreator.butchery.client.screens). Each overlay blits a 960x540 hint
 * texture roughly centered on the screen while its condition procedure holds.
 */
public final class ButcheryHintOverlays implements HudElement {
    private static final ButcheryHintOverlays INSTANCE = new ButcheryHintOverlays();

    private record Hint(BooleanSupplier condition, Identifier texture, int dx, int dy) {}

    private static final List<Hint> HINTS = List.of(
        new Hint(Cleaver_hint_conditionProcedure::execute, tex("butchers_knife_overlay.png"), -480, -269),
        new Hint(HacksawhintoverlayProcedure::execute, tex("hacksaw_overlay.png"), -480, -269),
        new Hint(HammerhintoverlayProcedure::execute, tex("hammer_overlay.png"), -479, -267),
        new Hint(ButcheryHintOverlays::ragSkinRackHintCondition, tex("rag_overlay.png"), -480, -238),
        new Hint(SalthintoverlayProcedure::execute, tex("salt_overlay.png"), -479, -267),
        new Hint(SkinoverlayhintProcedure::execute, tex("skin_overlay.png"), -479, -267),
        new Hint(SkinningknifehintoverlayProcedure::execute, tex("skinning_knife_overlay.png"), -479, -267),
        new Hint(WaterhintoverlayProcedure::execute, tex("sponge_overlay.png"), -479, -267)
    );

    // Original RagskinrackhintOverlay renders only when BOTH the water hint and the rag-skin-rack
    // hint conditions hold (player holds a water bottle/sponge AND looks at a rag skin rack).
    private static boolean ragSkinRackHintCondition() {
        return WaterhintoverlayProcedure.execute() && RagskinrackhintoverlayProcedure.execute();
    }

    private ButcheryHintOverlays() {}

    private static Identifier tex(String name) {
        return Identifier.parse("butchery:textures/screens/" + name);
    }

    public static void register() {
        // API: attachElementBefore(beforeThis, identifier, element) — attach our element BEFORE
        // the vanilla MISC_OVERLAYS layer, matching the original's RenderGuiEvent.Pre (HIGH) behaviour.
        HudElementRegistry.attachElementBefore(VanillaHudElements.MISC_OVERLAYS, Identifier.parse("butchery:hint_overlays"), INSTANCE);
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker) {
        int w = guiGraphics.guiWidth();
        int h = guiGraphics.guiHeight();
        for (Hint hint : HINTS) {
            if (hint.condition().getAsBoolean()) {
                guiGraphics.blit(RenderPipelines.GUI_TEXTURED, hint.texture(), w / 2 + hint.dx(), h / 2 + hint.dy(), 0.0F, 0.0F, 960, 540, 960, 540);
            }
        }
    }
}
