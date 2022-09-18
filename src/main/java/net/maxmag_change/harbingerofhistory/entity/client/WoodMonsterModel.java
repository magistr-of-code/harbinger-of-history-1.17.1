package net.maxmag_change.harbingerofhistory.entity.client;

import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.WoodMonster;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WoodMonsterModel extends AnimatedGeoModel<WoodMonster> {

    @Override
    public Identifier getModelLocation(WoodMonster object) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "geo/wood_monster.geo.json");
    }

    @Override
    public Identifier getTextureLocation(WoodMonster object) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "textures/entity/wood_monster.png");
    }

    @Override
    public Identifier getAnimationFileLocation(WoodMonster animatable) {
        return new Identifier(HarbingerOfHistory.MOD_ID, "animations/wood_monster.animation.json");
    }
}
