package lilypuree.decorative_blocks;

import lilypuree.decorative_blocks.core.DBItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;

public class FabricCreativeTab {

    public static final ResourceKey<CreativeModeTab> CREATIVE_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MODID,"decorative_blocks"));
    public static void init(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_TAB, FabricItemGroup.builder()
                .title(Component.translatable("tab.decorative_blocks"))
                .icon(() -> new ItemStack(DBItems.BRAZIER.get()))
                .build());
        ItemGroupEvents.modifyEntriesEvent(CREATIVE_TAB).register(FabricCreativeTab::entries);
    }
    private static void entries(FabricItemGroupEntries entries) {
        DBItems.SEAT_ITEMBLOCKS.values().forEach((r)-> entries.accept(r.get()));
        DBItems.BEAM_ITEMBLOCKS.values().forEach((r)-> entries.accept(r.get()));
        DBItems.PALISADE_ITEMBLOCKS.values().forEach((r)-> entries.accept(r.get()));
        DBItems.SUPPORT_ITEMBLOCKS.values().forEach((r)-> entries.accept(r.get()));
        entries.accept(DBItems.BRAZIER.get());
        entries.accept(DBItems.SOUL_BRAZIER.get());
        entries.accept(DBItems.CHANDELIER.get());
        entries.accept(DBItems.SOUL_CHANDELIER.get());
        entries.accept(DBItems.BAR_PANEL.get());
        entries.accept(DBItems.LATTICE.get());
        entries.accept(DBItems.CHAIN.get());
        entries.accept(DBItems.STONE_PILLAR.get());
        entries.accept(DBItems.ROCKY_DIRT.get());
        entries.accept(DBItems.BLOCKSTATE_COPY_ITEM.get());
    }
}
