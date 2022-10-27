package net.maxmag_change.harbingerofhistory.entity.client;


import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.Player;
import net.maxmag_change.harbingerofhistory.entity.custom.WoodMonster;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CookRenderer extends GeoEntityRenderer<Player> {
    public CookRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CookModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public Identifier getTextureLocation(Player instance) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "textures/entity/cooker.png");
    }


    @Override
    public RenderLayer getRenderType(Player animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        stack.scale(2f,2f,2f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
