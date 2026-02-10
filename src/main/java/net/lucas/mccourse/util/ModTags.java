package net.lucas.mccourse.util;

import net.lucas.mccourse.MCCourseMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCKS =
                createBlockTag("metal_detector_detectable_blocks");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MCCourseMod.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", name));
        }
    }

    public static class Items {

        private static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MCCourseMod.MOD_ID, name));
        }

        private static TagKey<Item> createCommonItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("c", name));
        }
    }
}
