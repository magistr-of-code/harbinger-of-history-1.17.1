package net.maxmag_change.harbingerofhistory;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.maxmag_change.harbingerofhistory.entity.ModEntity;
import net.maxmag_change.harbingerofhistory.entity.client.WoodMonsterRenderer;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;

public class HarbingerOfHistoryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntity.WOOD_MONSTER, WoodMonsterRenderer::new);

        ModMessages.registerC2SPackets();
    }
}
