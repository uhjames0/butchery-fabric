package net.mcreator.butchery.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderingRegistry;
import net.mcreator.butchery.init.ButcheryModFluids;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.Fluid;

@Environment(value=EnvType.CLIENT)
public class ButcheryFluidRendering {
    private static FluidModel.Unbaked model(String stillSprite, String flowingSprite) {
        return new FluidModel.Unbaked(new Material(Identifier.parse((String)stillSprite)), new Material(Identifier.parse((String)flowingSprite)), new Material(Identifier.withDefaultNamespace((String)"block/water_overlay")), state -> -1);
    }

    public static void register() {
        FluidRenderHandler handler = new FluidRenderHandler(){};
        FluidRenderingRegistry.register((Fluid)((Fluid)ButcheryModFluids.BLOOD.get()), (Fluid)((Fluid)ButcheryModFluids.FLOWING_BLOOD.get()), (FluidModel.Unbaked)ButcheryFluidRendering.model("butchery:block/blood_still", "butchery:block/blood_flow"), (FluidRenderHandler)handler);
        FluidRenderingRegistry.register((Fluid)((Fluid)ButcheryModFluids.INFECTED_BLOOD.get()), (Fluid)((Fluid)ButcheryModFluids.FLOWING_INFECTED_BLOOD.get()), (FluidModel.Unbaked)ButcheryFluidRendering.model("butchery:block/infected_blood_still", "butchery:block/infected_blood_flow"), (FluidRenderHandler)handler);
    }
}

