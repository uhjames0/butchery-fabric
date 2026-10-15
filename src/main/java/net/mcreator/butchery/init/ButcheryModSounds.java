package net.mcreator.butchery.init;

import net.mcreator.butchery.shim.DeferredHolder;
import net.mcreator.butchery.shim.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ButcheryModSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, "butchery");
    public static final DeferredHolder<SoundEvent, SoundEvent> CHA_CHING = REGISTRY.register("cha_ching", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"cha_ching")));
    public static final DeferredHolder<SoundEvent, SoundEvent> DRAWER_CLOSE = REGISTRY.register("drawer_close", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"drawer_close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> DRAWER_OPEN = REGISTRY.register("drawer_open", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"drawer_open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> COIN = REGISTRY.register("coin", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"coin")));
    public static final DeferredHolder<SoundEvent, SoundEvent> INFLATE = REGISTRY.register("inflate", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"inflate")));
    public static final DeferredHolder<SoundEvent, SoundEvent> DEFLATE = REGISTRY.register("deflate", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"deflate")));
    public static final DeferredHolder<SoundEvent, SoundEvent> ROPE = REGISTRY.register("rope", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"rope")));
    public static final DeferredHolder<SoundEvent, SoundEvent> HACKSAW = REGISTRY.register("hacksaw", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"hacksaw")));
    public static final DeferredHolder<SoundEvent, SoundEvent> CRUMBLING = REGISTRY.register("crumbling", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"crumbling")));
    public static final DeferredHolder<SoundEvent, SoundEvent> WISHBONE_BREAK = REGISTRY.register("wishbone_break", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"wishbone_break")));
    public static final DeferredHolder<SoundEvent, SoundEvent> WATER_FREEZING = REGISTRY.register("water_freezing", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"water_freezing")));
    public static final DeferredHolder<SoundEvent, SoundEvent> ACID = REGISTRY.register("acid", () -> SoundEvent.createVariableRangeEvent((Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"acid")));
}

