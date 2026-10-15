package net.mcreator.butchery.shim.events;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

public class EntityAttributeShim {
    public static final List<Entry> ENTRIES = new ArrayList<Entry>();

    public void put(EntityType<?> type, AttributeSupplier supplier) {
        ENTRIES.add(new Entry(type, supplier));
    }

    public record Entry(EntityType<?> type, AttributeSupplier supplier) {
    }
}

