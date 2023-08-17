package lilypuree.decorative_blocks;

import lilypuree.decorative_blocks.blocks.SupportBlock;
import lilypuree.decorative_blocks.core.setup.ModSetup;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.state.BlockState;

import static lilypuree.decorative_blocks.blocks.SupportBlock.onSupportActivation;

public class Callbacks {
    public static void initCallbacks() {
        AttackBlockCallback.EVENT.register(((player, world, hand, pos, direction) -> {
            if (ModSetup.onLeftClick(world, pos)) {
                return InteractionResult.sidedSuccess(world.isClientSide);
            }
            return InteractionResult.PASS;
        }));
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            int result = ModSetup.onRightClick(world, player, hand, player.getItemInHand(hand), hitResult.getBlockPos());

            if (result == -1) {
                return InteractionResult.FAIL;
            } else if (result == 1) {
                return InteractionResult.sidedSuccess(world.isClientSide);
            }
            return InteractionResult.PASS;
        });
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.getBlock() instanceof SupportBlock) {
                if (player.getItemInHand(hand).getItem() instanceof AxeItem) {
                    if (!world.isClientSide()) {
                        onSupportActivation(state, world, pos, player, hitResult.getLocation());
                    }
                    return InteractionResult.sidedSuccess(world.isClientSide);
                }
            }
            return InteractionResult.PASS;
        });
    }
}
