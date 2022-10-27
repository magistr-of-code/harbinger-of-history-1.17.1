package net.maxmag_change.harbingerofhistory;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.maxmag_change.harbingerofhistory.block.ModBlocks;
import net.maxmag_change.harbingerofhistory.entity.ModEntity;
import net.maxmag_change.harbingerofhistory.entity.client.*;
import net.maxmag_change.harbingerofhistory.networking.ModMessages;
import net.minecraft.client.render.RenderLayer;

public class HarbingerOfHistoryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntity.CACODA, CacodaRenderer::new);

        EntityRendererRegistry.register(ModEntity.FIREFLY, FireFlyRenderer::new);

        EntityRendererRegistry.register(ModEntity.WOOD_MONSTER, WoodMonsterRenderer::new);

        EntityRendererRegistry.register(ModEntity.PLAYER, PlayerRenderer::new);

        EntityRendererRegistry.register(ModEntity.COOK, CookRenderer::new);

        EntityRendererRegistry.register(ModEntity.SELLER, SellerRenderer::new);

        EntityRendererRegistry.register(ModEntity.MAN, ManRenderer::new);

        EntityRendererRegistry.register(ModEntity.CITIZEN, CitizenRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLD_FENCE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PIANO, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LANTERN_STAND, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HELLOWEEN_PUMPKIN, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WIDE_TOMB_STONE_WITH_FLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WIDE_TOMB_STONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHOW_CASE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RTP_BLOCK, RenderLayer.getTranslucent());


        ModMessages.registerC2SPackets();
    }
}
