package net.mcreator.butchery.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.mcreator.butchery.entity.DragonEntity;
import net.mcreator.butchery.entity.TurtleshellboatEntity;
import net.mcreator.butchery.shim.DeferredHolder;
import net.mcreator.butchery.shim.SpinPlacementsShim;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

public class ButcheryModEntities {
    public static final DeferredHolder<EntityType<?>, EntityType<TurtleshellboatEntity>> TURTLESHELLBOAT = ButcheryModEntities.register("turtleshellboat", EntityType.Builder.of(TurtleshellboatEntity::new, (MobCategory)MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3).sized(0.5f, 1.2f));
    public static final DeferredHolder<EntityType<?>, EntityType<DragonEntity>> DRAGON = ButcheryModEntities.register("dragon", EntityType.Builder.of(DragonEntity::new, (MobCategory)MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3).sized(0.6f, 1.8f));

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        ResourceKey key = ResourceKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)registryname));
        EntityType type = entityTypeBuilder.build(key);
        Registry.register((Registry)BuiltInRegistries.ENTITY_TYPE, (ResourceKey)key, (Object)type);
        DeferredHolder holder = new DeferredHolder(key.identifier(), () -> type);
        holder.bind((EntityType)type);
        return holder;
    }

    public static void init(SpinPlacementsShim event) {
        TurtleshellboatEntity.init(event);
        DragonEntity.init(event);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(TURTLESHELLBOAT.get(), (AttributeSupplier)TurtleshellboatEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(DRAGON.get(), (AttributeSupplier)DragonEntity.createAttributes().build());
    }
}

