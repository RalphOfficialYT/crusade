package ralphofficial.crusade.mod.modGen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import ralphofficial.crusade.mod.MainClass;
import ralphofficial.crusade.mod.ModBlocks;

import java.util.Arrays;

public class OreGen {

    //Creates the configured feature for mavistone
    private static ConfiguredFeature<?,?> OVERWORLD_MAVISTONE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.MAVISTONE.getDefaultState(),
                    20
            ));
    //Creates the configured feature for mauvestone
    private static ConfiguredFeature<?,?> OVERWORLD_MAUVESTONE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.MAUVESTONE.getDefaultState(),
                    30
            ));
    //Creates the configured feature for Bronze ore
    private static ConfiguredFeature<?,?> OVERWORLD_BRONZE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.BRONZE_ORE.getDefaultState(),
                    5
            ));

    //Creates the placed feature for the mavistone
    public static PlacedFeature OVERWORLD_MAVISTONE_PLACED_FEATURE = new PlacedFeature
            (RegistryEntry.of(OVERWORLD_MAVISTONE_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(20),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
            ));
    //Creates the placed feature for the mauvestone
    public static PlacedFeature OVERWORLD_MAUVESTONE_PLACED_FEATURE = new PlacedFeature
            (RegistryEntry.of(OVERWORLD_MAUVESTONE_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(20),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
            ));
    //Creates the placed featur for the Bronze ore
    public static PlacedFeature OVERWORLD_BRONZE_ORE_PLACED_FEATURE = new PlacedFeature
            (RegistryEntry.of(OVERWORLD_BRONZE_ORE_CONFIGURED_FEATURE), Arrays.asList(
                    CountPlacementModifier.of(10),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
            ));

    public static void oreGenRegistry() {

        //Registers the configured feature of Mavistone
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(MainClass.MOD_ID, "overworld_mavistone"), OVERWORLD_MAVISTONE_CONFIGURED_FEATURE);
        //Registers the placed feature of Mavistone
        Registry.register(BuiltinRegistries.PLACED_FEATURE,
                new Identifier(MainClass.MOD_ID, "overworld_mavistone"), OVERWORLD_MAVISTONE_PLACED_FEATURE);
        //Registers the biome placements of Mavistone
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(MainClass.MOD_ID, "overworld_mavistone")));

        //Registers the configured feature of Mauvestone
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(MainClass.MOD_ID, "overworld_mauvestone"), OVERWORLD_MAUVESTONE_CONFIGURED_FEATURE);
        //Registers the placed feature of Mauvestone
        Registry.register(BuiltinRegistries.PLACED_FEATURE,
                new Identifier(MainClass.MOD_ID, "overworld_mauvestone"), OVERWORLD_MAUVESTONE_PLACED_FEATURE);
        //Registers the biome placements of Mauvestone
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(MainClass.MOD_ID, "overworld_mauvestone")));

        //Registers the configured feature of Bronze Ore
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(MainClass.MOD_ID, "overworld_bronze_ore"), OVERWORLD_BRONZE_ORE_CONFIGURED_FEATURE);
        //Registers the placed feature of Bronze Ore
        Registry.register(BuiltinRegistries.PLACED_FEATURE,
                new Identifier(MainClass.MOD_ID, "overworld_bronze_ore"), OVERWORLD_BRONZE_ORE_PLACED_FEATURE);
        //Registers the biome placements of Bronze Ore
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(MainClass.MOD_ID, "overworld_bronze_ore")));

    }

}
