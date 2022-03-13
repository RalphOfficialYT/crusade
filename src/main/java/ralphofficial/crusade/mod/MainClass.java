package ralphofficial.crusade.mod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ralphofficial.crusade.mod.modGen.OreGen;

public class MainClass implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("crusade");

	public static final String MOD_ID = "crusade";

	@Override
	public void onInitialize() {

		//Calls methods from some classes
		ModBlocks.blockRegistry();
		ModItems.itemRegistry();
		ModEntities.entityRegistry();
		OreGen.oreGenRegistry();

		LOGGER.info("Hello Fabric world!");
	}
}
