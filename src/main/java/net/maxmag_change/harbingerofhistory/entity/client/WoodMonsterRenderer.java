package net.maxmag_change.harbingerofhistory.entity.client;


import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.WoodMonster;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WoodMonsterRenderer extends GeoEntityRenderer<WoodMonster> {
    public WoodMonsterRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new WoodMonsterModel());
        this.shadowRadius = 1.3f;
    }

    @Override
    public Identifier getTextureLocation(WoodMonster instance) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "textures/entity/wood_monster.png");
    }


    @Override
    public RenderLayer getRenderType(WoodMonster animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
