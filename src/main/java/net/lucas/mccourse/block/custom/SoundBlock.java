package net.lucas.mccourse.block.custom;

import net.lucas.mccourse.MCCourseMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class SoundBlock extends Block {
    public  SoundBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        super.onBroken(world, pos, state);

        if (!world.isClient() && world instanceof World w) {
            w.createExplosion(
                    null,
                    pos.getX() +0.5,
                    pos.getY() +0.5,
                    pos.getZ() +0.5,
                    4.0F,
                    World.ExplosionSourceType.BLOCK );
        }
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if(world.isClient()) {
            MCCourseMod.LOGGER.info("Sound block was right clicked");
        }

        return ActionResult.SUCCESS;
    }
}
