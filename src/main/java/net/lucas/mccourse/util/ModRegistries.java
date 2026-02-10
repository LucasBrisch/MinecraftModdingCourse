package net.lucas.mccourse.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lucas.mccourse.item.ModItens;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItens.PEAT_BRICK, 300);
    }
}
