package net.lucas.mccourse.item.custom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;


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

    private void outputValuableCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Valueable found at: " + position.getX() + ", " + position.getY() + ", " + position.getZ() + " - Block: " + block.asItem().getName().getString()));
    }

    private boolean isValuableBlock(BlockState blockstate) {
        return blockstate.getBlock() == net.minecraft.block.Blocks.IRON_ORE ||
               blockstate.getBlock() == net.minecraft.block.Blocks.GOLD_ORE ||
               blockstate.getBlock() == net.minecraft.block.Blocks.COPPER_ORE ||
               blockstate.getBlock() == net.minecraft.block.Blocks.DIAMOND_ORE ||
               blockstate.getBlock() == net.minecraft.block.Blocks.EMERALD_ORE;
    }
}
