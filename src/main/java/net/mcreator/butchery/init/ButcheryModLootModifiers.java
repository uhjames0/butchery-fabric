package net.mcreator.butchery.init;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents.Modify;
import net.mcreator.butchery.ButcheryMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.providers.number.ints.ConstantValue;

public class ButcheryModLootModifiers {
   public static void initLootModifiers() {
      LootTableEvents.MODIFY
         .register(
            (Modify)(key, tableBuilder, source, registries) -> {
               Identifier id = key.identifier();
               if (id.equals(BuiltInLootTables.END_CITY_TREASURE.identifier())) {
                  ResourceKey<LootTable> ref = ResourceKey.create(
                     Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("butchery", "blocks/end_dragon_smithing_template")
                  );
                  tableBuilder.withPool(
                     LootPool.lootPool()
                        .add(NestedLootTable.lootTableReference(registries.lookupOrThrow(Registries.LOOT_TABLE).getOrThrow(ref)))
                        .setRolls(Holder.direct(new ConstantValue(1)))
                  );
               } else if (id.equals(BuiltInLootTables.ANCIENT_CITY.identifier())) {
                  ResourceKey<LootTable> ref = ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("butchery", "wardensmithingtemplate"));
                  tableBuilder.withPool(
                     LootPool.lootPool()
                        .add(NestedLootTable.lootTableReference(registries.lookupOrThrow(Registries.LOOT_TABLE).getOrThrow(ref)))
                        .setRolls(Holder.direct(new ConstantValue(1)))
                  );
               }
            }
         );
      ButcheryMod.LOGGER.debug("[Butchery] loot modifiers registered");
   }
}
