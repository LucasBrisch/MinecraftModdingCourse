 package net.lucas.mccourse.block;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lucas.mccourse.MCCourseMod;
import net.lucas.mccourse.block.custom.SoundBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

 public class ModBlocks {

     public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
             new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
     );
     public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
             new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
     );
     public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
             new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE))
     );
    public static final Block NETHER_PINK_GARNET_ORE = registerBlock("nether_pink_garnet_ore",
             new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE))
     );
    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock("end_stone_pink_garnet_ore",
             new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE))
     );
    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock("deepslate_pink_garnet_ore",
             new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE))
     );

     public static final Block SOUND_BLOCK = registerBlock("sound_block",
             new SoundBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE))
     );

     private static Block registerBlock(String name, Block block) {
         registerBlockItem(name, block);
         return Registry.register(Registries.BLOCK, Identifier.of(MCCourseMod.MOD_ID, name), block);

     }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MCCourseMod.LOGGER.info("Registering mod blocks for" + MCCourseMod.MOD_ID);
    }
}
