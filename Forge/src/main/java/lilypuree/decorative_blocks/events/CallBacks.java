package lilypuree.decorative_blocks.events;

import lilypuree.decorative_blocks.Constants;
import lilypuree.decorative_blocks.blocks.SupportBlock;
import lilypuree.decorative_blocks.core.setup.ModSetup;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static lilypuree.decorative_blocks.blocks.SupportBlock.onSupportActivation;

@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CallBacks {
    @SubscribeEvent
    public static void onRightClickThatch(PlayerInteractEvent.RightClickBlock event) {
        int result = ModSetup.onRightClick(event.getLevel(), event.getEntity(), event.getHand(), event.getItemStack(), event.getPos());
        if (result == -2) {
            event.setCanceled(true);
        } else if (result == -1) {
            event.setUseBlock(Event.Result.DENY);
        } else if (result == 1) {
            event.setUseBlock(Event.Result.ALLOW);
        }
    }

    @SubscribeEvent
    public static void onRightClickSupport(PlayerInteractEvent.RightClickBlock event) {
        BlockPos pos = event.getPos();
        Level world = event.getLevel();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        HitResult hitResult = event.getHitVec();
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof SupportBlock) {
            if (player.getItemInHand(hand).getItem() instanceof AxeItem) {
                if (!world.isClientSide()) {
                    onSupportActivation(state, world, pos, player, hitResult.getLocation());
                }
                event.setResult(Event.Result.ALLOW);
            }
        }
        event.setResult(Event.Result.DEFAULT);
    }

    @SubscribeEvent
    public static void onLeftClick(PlayerInteractEvent.LeftClickBlock event){
        if (ModSetup.onLeftClick(event.getLevel(), event.getPos())){
            event.setCanceled(true);
        }
    }
}
