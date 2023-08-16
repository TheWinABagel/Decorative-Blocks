package lilypuree.decorative_blocks.blocks.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public enum VanillaWoodTypes implements IWoodType {
    OAK("oak"),
    BIRCH("birch") {},
    SPRUCE("spruce") {},
    ACACIA("acacia") {},
    JUNGLE("jungle") {},
    DARK_OAK("dark_oak") {},
    MANGROVE("mangrove") {},
    CRIMSON("crimson") {
        @Override
        public boolean isFlammable() {
            return false;
        }
        },
    WARPED("warped") {
        @Override
        public boolean isFlammable() {
            return false;
        }
    },
    BAMBOO("bamboo"){},
    CHERRY("cherry"){};

    private final String name;

    private VanillaWoodTypes(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getName();
    }

    @Override
    public String namespace() {
        return "minecraft";
    }

    public String getName() {
        return this.name;
    }


    public static VanillaWoodTypes withName(String name) {
        if (name.equalsIgnoreCase("oak")) return OAK;
        else if (name.equalsIgnoreCase("birch")) return BIRCH;
        else if (name.equalsIgnoreCase("spruce")) return SPRUCE;
        else if (name.equalsIgnoreCase("acacia")) return ACACIA;
        else if (name.equalsIgnoreCase("jungle")) return JUNGLE;
        else if (name.equalsIgnoreCase("dark")) return DARK_OAK;
        else if (name.equalsIgnoreCase("mangrove")) return MANGROVE;
        else if (name.equalsIgnoreCase("crimson")) return CRIMSON;
        else if (name.equalsIgnoreCase("warped")) return WARPED;
        else if (name.equalsIgnoreCase("bamboo")) return CRIMSON;
        else if (name.equalsIgnoreCase("cherry")) return WARPED;
        return OAK;
    }

    public static VanillaWoodTypes fromPath(String path) {
        String[] paths = path.split("_");
        return withName(paths[0]);
    }

    public Block getLog() {
        return switch (this) {
            case OAK -> Blocks.OAK_LOG;
            case SPRUCE -> Blocks.SPRUCE_LOG;
            case BIRCH -> Blocks.BIRCH_LOG;
            case JUNGLE -> Blocks.JUNGLE_LOG;
            case DARK_OAK -> Blocks.DARK_OAK_LOG;
            case ACACIA -> Blocks.ACACIA_LOG;
            case MANGROVE -> Blocks.MANGROVE_LOG;
            case CRIMSON -> Blocks.CRIMSON_STEM;
            case WARPED -> Blocks.WARPED_STEM;
            case BAMBOO -> Blocks.BAMBOO_BLOCK;
            case CHERRY -> Blocks.CHERRY_LOG;
        };
    }

    public Block getStrippedLog() {
        return switch (this) {
            case OAK -> Blocks.STRIPPED_OAK_LOG;
            case SPRUCE -> Blocks.STRIPPED_SPRUCE_LOG;
            case BIRCH -> Blocks.STRIPPED_BIRCH_LOG;
            case JUNGLE -> Blocks.STRIPPED_JUNGLE_LOG;
            case DARK_OAK -> Blocks.STRIPPED_DARK_OAK_LOG;
            case ACACIA -> Blocks.STRIPPED_ACACIA_LOG;
            case MANGROVE -> Blocks.STRIPPED_MANGROVE_LOG;
            case CRIMSON -> Blocks.STRIPPED_CRIMSON_STEM;
            case WARPED -> Blocks.STRIPPED_WARPED_STEM;
            case BAMBOO -> Blocks.STRIPPED_BAMBOO_BLOCK;
            case CHERRY -> Blocks.STRIPPED_CHERRY_LOG;
        };
    }

    public Block getSlab() {
        return switch (this) {
            case OAK -> Blocks.OAK_SLAB;
            case SPRUCE -> Blocks.SPRUCE_SLAB;
            case BIRCH -> Blocks.BIRCH_SLAB;
            case JUNGLE -> Blocks.JUNGLE_SLAB;
            case DARK_OAK -> Blocks.DARK_OAK_SLAB;
            case ACACIA -> Blocks.ACACIA_SLAB;
            case MANGROVE -> Blocks.MANGROVE_SLAB;
            case CRIMSON -> Blocks.CRIMSON_SLAB;
            case WARPED -> Blocks.WARPED_SLAB;
            case BAMBOO -> Blocks.BAMBOO_SLAB;
            case CHERRY -> Blocks.CHERRY_SLAB;
        };
    }

    public Block getFence() {
        return switch (this) {
            case OAK -> Blocks.OAK_FENCE;
            case SPRUCE -> Blocks.SPRUCE_FENCE;
            case BIRCH -> Blocks.BIRCH_FENCE;
            case JUNGLE -> Blocks.JUNGLE_FENCE;
            case DARK_OAK -> Blocks.DARK_OAK_FENCE;
            case ACACIA -> Blocks.ACACIA_FENCE;
            case MANGROVE -> Blocks.MANGROVE_FENCE;
            case CRIMSON -> Blocks.CRIMSON_FENCE;
            case WARPED -> Blocks.WARPED_FENCE;
            case BAMBOO -> Blocks.BAMBOO_FENCE;
            case CHERRY -> Blocks.CHERRY_FENCE;
        };
    }

    public Block getPlanks() {
        return switch (this) {
            case OAK -> Blocks.OAK_PLANKS;
            case SPRUCE -> Blocks.SPRUCE_PLANKS;
            case BIRCH -> Blocks.BIRCH_PLANKS;
            case JUNGLE -> Blocks.JUNGLE_PLANKS;
            case DARK_OAK -> Blocks.DARK_OAK_PLANKS;
            case ACACIA -> Blocks.ACACIA_PLANKS;
            case MANGROVE -> Blocks.MANGROVE_PLANKS;
            case CRIMSON -> Blocks.CRIMSON_PLANKS;
            case WARPED -> Blocks.WARPED_PLANKS;
            case BAMBOO -> Blocks.BAMBOO_PLANKS;
            case CHERRY -> Blocks.CHERRY_PLANKS;
        };
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public boolean isFlammable() {
        return true;
    }


}
