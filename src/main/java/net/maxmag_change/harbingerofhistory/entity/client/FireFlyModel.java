package net.maxmag_change.harbingerofhistory.entity.client;

import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.FireFly;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FireFlyModel extends AnimatedGeoModel<FireFly> {

    @Override
    public Identifier getModelLocation(FireFly object) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "geo/firefly.geo.json");
    }

    @Override
    public Identifier getTextureLocation(FireFly object) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "textures/entity/firefly.png");
    }

    @Override
    public Identifier getAnimationFileLocation(FireFly animatable) {
        return new Identifier(HarbingerOfHistory.MOD_ID, null);
    }
}
