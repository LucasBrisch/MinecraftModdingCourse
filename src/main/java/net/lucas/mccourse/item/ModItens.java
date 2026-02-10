package net.lucas.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lucas.mccourse.MCCourseMod;
import net.lucas.mccourse.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItens {

    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new Item.Settings())
    );

    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new Item.Settings())
    );

    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER))
    );

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new Item.Settings().maxDamage(256))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name), item);
    };

    public static void registerModItens () {
        MCCourseMod.LOGGER.info("Registering Mod Itens for" + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);


            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }
}
