package net.maxmag_change.harbingerofhistory.entity.client;

import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.Cacoda;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CacodaModel extends AnimatedGeoModel<Cacoda> {

    @Override
    public Identifier getModelLocation(Cacoda object) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "geo/cacoda.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Cacoda object) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "textures/entity/cacoda.png");
    }

    @Override
    public Identifier getAnimationFileLocation(Cacoda animatable) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "animations/cacoda.animation.json");
    }
}

