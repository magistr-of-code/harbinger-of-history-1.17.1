package net.maxmag_change.harbingerofhistory.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.entity.custom.Cacoda;
import net.maxmag_change.harbingerofhistory.entity.custom.FireFly;
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

    public static final EntityType<FireFly> FIREFLY = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(HarbingerOfHistory.MOD_ID, "firefly"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FireFly::new).dimensions(EntityDimensions.fixed(0.2f,0.1f)).build());
    public static final EntityType<Cacoda> CACODA = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(HarbingerOfHistory.MOD_ID, "cacoda"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, Cacoda::new).dimensions(EntityDimensions.fixed(0.2f,0.8f)).build());
}
