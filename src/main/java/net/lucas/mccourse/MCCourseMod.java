package net.lucas.mccourse;

import net.fabricmc.api.ModInitializer;

import net.lucas.mccourse.block.ModBlocks;
import net.lucas.mccourse.item.ModItemGroup;
import net.lucas.mccourse.item.ModItens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	public static final String MOD_ID = "mccourse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItens.registerModItens();
		ModBlocks.registerModBlocks();
	}
}