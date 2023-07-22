package lilypuree.decorative_blocks;

import net.minecraftforge.api.fml.event.config.ModConfigEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class Config {
    public static final String CATEGORY_GENERAL = "general";

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.ConfigValue<String> BONFIRE_ACTIVATOR;
    public static ForgeConfigSpec.ConfigValue<Boolean> THATCH_ENABLED;
    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("Decorative Blocks Configs").push(CATEGORY_GENERAL);
        setUpBonfireActivatorConfig(COMMON_BUILDER);

        THATCH_ENABLED = COMMON_BUILDER.comment("Disable thatch creation on shearing hay bale")
                .define("thatch enabled", true);

        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
    private static void setUpBonfireActivatorConfig(ForgeConfigSpec.Builder COMMON_BUILDER) {
        BONFIRE_ACTIVATOR = COMMON_BUILDER.comment("Bonfire Activator, default: \"minecraft:blaze_powder\"")
                .define("bonfire activator", "minecraft:blaze_powder");

    }

    public static void register() {
        ModConfigEvent.LOADING.register(Config::onLoad);
        ModConfigEvent.RELOADING.register(Config::onReload);
    }

    public static void onLoad(ModConfig event){
       CommonConfig.BONFIRE_ACTIVATOR = BONFIRE_ACTIVATOR.get();
       CommonConfig.THATCH_ENABLED = THATCH_ENABLED.get();
    }

    public static void onReload(ModConfig event){
        CommonConfig.BONFIRE_ACTIVATOR = BONFIRE_ACTIVATOR.get();
        CommonConfig.THATCH_ENABLED = THATCH_ENABLED.get();
    }
}
