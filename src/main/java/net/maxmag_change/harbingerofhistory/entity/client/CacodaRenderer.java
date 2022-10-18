package net.maxmag_change.harbingerofhistory.entity.client;

import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.Cacoda;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CacodaRenderer extends GeoEntityRenderer<Cacoda> {
    public CacodaRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CacodaModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureLocation(Cacoda instance) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "textures/entity/cacoda.png");
    }


    @Override
    public RenderLayer getRenderType(Cacoda animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}