package lilypuree.decorative_blocks;

import lilypuree.decorative_blocks.core.DBItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ForgeCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MODID);

    public static final RegistryObject<CreativeModeTab> DB_TAB = CREATIVE_MODE_TABS.register(Constants.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("tab." + Constants.MODID))
            .icon(() -> new ItemStack(DBItems.BRAZIER.get()))
            .displayItems((params, output) -> {
                DBItems.SEAT_ITEMBLOCKS.values().forEach((r)-> output.accept(r.get()));
                DBItems.BEAM_ITEMBLOCKS.values().forEach((r)-> output.accept(r.get()));
                DBItems.PALISADE_ITEMBLOCKS.values().forEach((r)-> output.accept(r.get()));
                DBItems.SUPPORT_ITEMBLOCKS.values().forEach((r)-> output.accept(r.get()));
                output.accept(DBItems.BRAZIER.get());
                output.accept(DBItems.SOUL_BRAZIER.get());
                output.accept(DBItems.CHANDELIER.get());
                output.accept(DBItems.SOUL_CHANDELIER.get());
                output.accept(DBItems.BAR_PANEL.get());
                output.accept(DBItems.LATTICE.get());
                output.accept(DBItems.CHAIN.get());
                output.accept(DBItems.STONE_PILLAR.get());
                output.accept(DBItems.ROCKY_DIRT.get());
                output.accept(DBItems.BLOCKSTATE_COPY_ITEM.get());
            })
            .build()
    );

}
