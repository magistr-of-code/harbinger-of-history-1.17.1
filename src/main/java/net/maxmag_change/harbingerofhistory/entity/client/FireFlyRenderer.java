package net.maxmag_change.harbingerofhistory.entity.client;


import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.FireFly;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FireFlyRenderer extends GeoEntityRenderer<FireFly> {
    public FireFlyRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new FireFlyModel());
        this.shadowRadius = 0;
    }

    @Override
    public Identifier getTextureLocation(FireFly instance) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "textures/entity/firefly.png");
    }


    @Override
    public RenderLayer getRenderType(FireFly animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
