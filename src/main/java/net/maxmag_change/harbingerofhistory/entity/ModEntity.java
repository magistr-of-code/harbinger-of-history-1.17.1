package net.maxmag_change.harbingerofhistory.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.WoodMonster;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntity {
    public static final EntityType<WoodMonster> WOOD_MONSTER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(HarbingerOfHistory.MOD_ID, "wood_monster"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WoodMonster::new).dimensions(EntityDimensions.fixed(1.5f,3f)).build());
}
