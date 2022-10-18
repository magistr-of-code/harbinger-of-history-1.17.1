package net.maxmag_change.harbingerofhistory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.maxmag_change.harbingerofhistory.block.ModBlocks;
import net.maxmag_change.harbingerofhistory.entity.ModEntity;
import net.maxmag_change.harbingerofhistory.entity.custom.Cacoda;
import net.maxmag_change.harbingerofhistory.entity.custom.FireFly;
import net.maxmag_change.harbingerofhistory.entity.custom.WoodMonster;
import net.maxmag_change.harbingerofhistory.item.ModItems;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;
import net.maxmag_change.harbingerofhistory.util.ModRegistries;
import net.maxmag_change.harbingerofhistory.world.dimension.ModDimensions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

public class HarbingerOfHistory implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "harbingerofhistory";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();

		GeckoLib.initialize();

		ModMessages.registerS2CPackets();

		//ServerTickEvents.START_SERVER_TICK.register(new PlayerTick());
		//ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(new KilledEntity());
		//ServerPlayerEvents.ALLOW_DEATH.register(new DeadPlayer());
		LOGGER.info("Hello Fabric world!");

		FabricDefaultAttributeRegistry.register(ModEntity.WOOD_MONSTER, WoodMonster.setAttributes());

		FabricDefaultAttributeRegistry.register(ModEntity.FIREFLY, FireFly.setAttributes());

		FabricDefaultAttributeRegistry.register(ModEntity.CACODA, Cacoda.setAttributes());

		ModDimensions.register();

	}
}
