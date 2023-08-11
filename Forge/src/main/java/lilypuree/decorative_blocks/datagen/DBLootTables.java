package lilypuree.decorative_blocks.datagen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
/*
public class DBLootTables extends LootTableProvider {
    public DBLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn.getPackOutput());
    }

    @Override
    public List<SubProviderEntry> getTables() {
        return List.of(Pair.of(DBBlockLoots::new, LootContextParamSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
    }
}
*/