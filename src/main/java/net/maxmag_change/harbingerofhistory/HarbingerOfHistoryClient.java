package net.maxmag_change.harbingerofhistory;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.maxmag_change.harbingerofhistory.block.ModBlocks;
import net.maxmag_change.harbingerofhistory.entity.ModEntity;
import net.maxmag_change.harbingerofhistory.entity.client.CacodaRenderer;
import net.maxmag_change.harbingerofhistory.entity.client.FireFlyRenderer;
import net.maxmag_change.harbingerofhistory.entity.client.WoodMonsterRenderer;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;
import net.minecraft.client.render.RenderLayer;

public class HarbingerOfHistoryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntity.CACODA, CacodaRenderer::new);

        EntityRendererRegistry.register(ModEntity.FIREFLY, FireFlyRenderer::new);

        EntityRendererRegistry.register(ModEntity.WOOD_MONSTER, WoodMonsterRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLD_FENCE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PIANO, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LANTERN_STAND, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHOW_CASE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RTP_BLOCK, RenderLayer.getTranslucent());


        ModMessages.registerC2SPackets();
    }
}
