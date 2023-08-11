package lilypuree.decorative_blocks.blocks.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public interface IWoodType {
    String toString();

    String namespace();

    Block getLog();

    Block getStrippedLog();

    Block getSlab();

    Block getFence();

    Block getPlanks();
/*
    default MaterialColor getMaterialColor() {
        return MaterialColor.WOOD;
    }

    default Material getMaterial() {
        return Material.WOOD;
    }*/

    default SoundType getSoundType() {
        return SoundType.WOOD;
    }

    boolean isAvailable();

    boolean isFlammable();
}
