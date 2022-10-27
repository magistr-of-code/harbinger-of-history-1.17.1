package net.maxmag_change.harbingerofhistory;

import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import jdk.jfr.EventFactory;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerBlockEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.maxmag_change.harbingerofhistory.block.ModBlocks;
import net.maxmag_change.harbingerofhistory.entity.ModEntity;
import net.maxmag_change.harbingerofhistory.entity.custom.*;
import net.maxmag_change.harbingerofhistory.event.DeadPlayer;
import net.maxmag_change.harbingerofhistory.event.KilledEntity;
import net.maxmag_change.harbingerofhistory.event.OnEntityUse;
import net.maxmag_change.harbingerofhistory.event.PlayerTick;
import net.maxmag_change.harbingerofhistory.item.ModItems;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;
import net.maxmag_change.harbingerofhistory.util.ModRegistries;
import net.maxmag_change.harbingerofhistory.world.dimension.ModDimensions;
import net.minecraft.server.network.ServerPlayNetworkHandler;
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

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTick());
		ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(new KilledEntity());
		ServerPlayerEvents.ALLOW_DEATH.register(new DeadPlayer());
		UseEntityCallback.EVENT.register(new OnEntityUse());

		LOGGER.info("Hello Fabric world!");

		FabricDefaultAttributeRegistry.register(ModEntity.WOOD_MONSTER, WoodMonster.setAttributes());

		FabricDefaultAttributeRegistry.register(ModEntity.FIREFLY, FireFly.setAttributes());

		FabricDefaultAttributeRegistry.register(ModEntity.CACODA, Cacoda.setAttributes());

		FabricDefaultAttributeRegistry.register(ModEntity.PLAYER, Player.setAttributes());

		FabricDefaultAttributeRegistry.register(ModEntity.COOK, Player.setAttributes());

		FabricDefaultAttributeRegistry.register(ModEntity.SELLER, Player.setAttributes());

		FabricDefaultAttributeRegistry.register(ModEntity.MAN, Player.setAttributes());

		FabricDefaultAttributeRegistry.register(ModEntity.CITIZEN, Player.setAttributes());

		ModDimensions.register();

	}
}
