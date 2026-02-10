package net.lucas.mccourse.item.custom;
import net.lucas.mccourse.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockstate = context.getWorld().getBlockState(positionClicked.down(i));
                Block block = blockstate.getBlock();

                if (isValuableBlock(blockstate)) {
                    outputValuableCoordinates(positionClicked.down(i), player, block);
                    foundBlock = true;
                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(Text.translatable("item.mmcourse.metal_detector.no_valuables"));
            }
        }

        context.getStack().damage(1, context.getPlayer(),
            EquipmentSlot.MAINHAND);

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
//        super.appendTooltip(stack, context, tooltip, type);
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.mccourse.metal_detector.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.mccourse.metal_detector.tooltip"));
        }
    }

    private void outputValuableCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Valueable found at: " + position.getX() + ", " + position.getY() + ", " + position.getZ() + " - Block: " + block.asItem().getName().getString()));
    }

    private boolean isValuableBlock(BlockState blockstate) {
        return blockstate.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }
}
