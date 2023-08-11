package lilypuree.decorative_blocks;

import lilypuree.decorative_blocks.core.*;
import lilypuree.decorative_blocks.core.setup.ModSetup;
import lilypuree.decorative_blocks.events.ClientEventHandler;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.Supplier;

@Mod(Constants.MODID)
public class DecorativeBlocks {

    public DecorativeBlocks() {
        DBTags.init();
        Registration.init();
        DBBlocks.init();
        DBItems.init();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener((FMLCommonSetupEvent e) -> {
            ModSetup.init();
        });
        modBus.addListener(ClientEventHandler::clientSetup);
        modBus.addListener(ClientEventHandler::onEntityRendererRegistry);
        modBus.addListener(ClientEventHandler::registerBindings);

        modBus.addListener(this::onRegisterEvent);
    }

    private void onRegisterEvent(RegisterEvent event) {
        if (event.getRegistryKey() == ForgeRegistries.FLUID_TYPES.get().getRegistryKey()) {
            registerFluidTypes(event.getForgeRegistry());
        }
    }


    public void registerFluidTypes(IForgeRegistry<FluidType> registry) {
        registry.register(DBNames.STILL_THATCH, Registration.STILL_THATCH.get().getFluidType());
        registry.register(DBNames.FLOWING_THATCH, Registration.FLOWING_THATCH.get().getFluidType());
    }

    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Add to ingredients tab
        //  if (event.getTab() == DBItems.ITEM_GROUP) {
        event.accept(DBItems.BLOCKSTATE_COPY_ITEM);
        event.accept(DBItems.BRAZIER);
        event.accept(DBItems.BAR_PANEL);
        event.accept(DBItems.CHAIN);
        event.accept(DBItems.LATTICE);
        event.accept(DBItems.CHANDELIER);
        event.accept(DBItems.ROCKY_DIRT);
        event.accept((Supplier<? extends ItemLike>) DBItems.BEAM_ITEMBLOCKS);
        //    }
    }

}
