package lilypuree.decorative_blocks.events;

import com.mojang.blaze3d.platform.InputConstants;
import lilypuree.decorative_blocks.Constants;
import lilypuree.decorative_blocks.client.ClientSetup;
import lilypuree.decorative_blocks.core.Registration;
import lilypuree.decorative_blocks.entity.EmptyRenderer;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEventHandler {
    public static void clientSetup(FMLClientSetupEvent e) {
        e.enqueueWork(() -> {
            ClientSetup.initRenderLayers();
            ClientSetup.initItemPropertyFunctions();
        });
    }
    public static final KeyMapping aaaa = new KeyMapping("key.decorative_blocks.switch_item_state", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, "key.categories.inventory");

    public static final Lazy<KeyMapping> SWITCH_STATE = Lazy.of(() -> new KeyMapping("key.decorative_blocks.switch_item_state",InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, "key.categories.inventory"));

    public static void registerBindings(RegisterKeyMappingsEvent event) {
    //    event.register(SWITCH_STATE.get()); //Just disabling this for now as the keybind doesn't even do anything... Wanted to fix the registration anyways
    }
    public static void onEntityRendererRegistry(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.DUMMY_ENTITY_TYPE.get(), EmptyRenderer::new);
    }
}
