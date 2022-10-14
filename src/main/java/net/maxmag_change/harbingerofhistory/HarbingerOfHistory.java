package net.maxmag_change.harbingerofhistory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.maxmag_change.harbingerofhistory.block.ModBlocks;
import net.maxmag_change.harbingerofhistory.entity.ModEntity;
import net.maxmag_change.harbingerofhistory.entity.custom.WoodMonster;
import net.maxmag_change.harbingerofhistory.event.DeadPlayer;
import net.maxmag_change.harbingerofhistory.event.KilledEntity;
import net.maxmag_change.harbingerofhistory.event.PlayerTick;
import net.maxmag_change.harbingerofhistory.item.ModItemGroup;
import net.maxmag_change.harbingerofhistory.item.ModItems;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;
import net.maxmag_change.harbingerofhistory.util.ModRegistries;
import net.maxmag_change.harbingerofhistory.world.dimension.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
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

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLD_FENCE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PIANO, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LANTERN_STAND, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHOW_CASE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RTP_BLOCK, RenderLayer.getTranslucent());

		GeckoLib.initialize();

		FabricDefaultAttributeRegistry.register(ModEntity.WOOD_MONSTER, WoodMonster.setAttributes());

		ModMessages.registerS2CPackets();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTick());
		ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(new KilledEntity());
		ServerPlayerEvents.ALLOW_DEATH.register(new DeadPlayer());
		LOGGER.info("Hello Fabric world!");

		ModDimensions.register();

	}
}
