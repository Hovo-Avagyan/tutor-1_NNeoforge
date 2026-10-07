package com.example.examplemod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult UseOn (UseOnContext context){
        Level level = context.getLevel();
        BlockPos positionClicked = context.getClickedPos();
        Player player = context.getPlayer();

        if(!level.isClientSide()){
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState state = level.getBlockState(positionClicked.below(i));

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    if(!foundBlock) {
                        outputNoValuablesFound(Player);
                    }
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
    private boolean isValuableBlock(BlockState blockState){
        return blockState.is(Blocks.IRON_ORE) || blockState.is(Blocks.IRON_ORE);
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block){
        player.sendSystemMessage(Component.literal("Valuables found: ")
                .append(block.getName()
                .append(Component.literal(" at (" + below.getX() + ", " + below.getY() + ", " + below.getZ() + ")")));

    }

    private void outputNoValuablesFound(Player player){
        player.sendSystemMessage(Component.translatable("item.examplemod.metal_detector.no_valuables"));

    }
}
