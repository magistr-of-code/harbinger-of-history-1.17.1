package net.maxmag_change.harbingerofhistory.entity.client;

import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.Player;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CitizenModel extends AnimatedGeoModel<Player> {

    @Override
    public Identifier getModelLocation(Player object) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "geo/player.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Player object) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "textures/entity/citizen.png");
    }

    @Override
    public Identifier getAnimationFileLocation(Player animatable) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "animations/player.animation.json");
    }
}
