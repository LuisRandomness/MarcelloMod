package io.github.luisrandomness.marcellomod;

import io.github.luisrandomness.marcellomod.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.*;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.DimensionTypes;
import net.minecraft.data.worldgen.biome.NetherBiomes;
import net.minecraft.data.worldgen.placement.TreePlacements;

public class MarcelloModDataGenerator implements DataGeneratorEntrypoint {
	public static FabricTagProvider.BlockTagProvider blockTags;

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(MM_ModelProvider::new);

		blockTags = pack.addProvider(MM_BlockTagProvider::new);
		pack.addProvider(MM_ItemTagProvider::new);
		pack.addProvider(MM_EntityTagProvider::new);
		pack.addProvider(MM_PaintingTagProvider::new);
		pack.addProvider(MM_BlockLootTableProvider::new);
		pack.addProvider(MM_RecipeProvider::new);
	}
}
