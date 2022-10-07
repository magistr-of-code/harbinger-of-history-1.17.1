package net.maxmag_change.harbingerofhistory.world.dimension;

import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> SPAWN_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(HarbingerOfHistory.MOD_ID, "spawn"));
    public static final RegistryKey<DimensionType> SPAWN_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            SPAWN_DIMENSION_KEY.getValue());


    public static void register() {
        HarbingerOfHistory.LOGGER.debug("Registering ModDimensions for " + HarbingerOfHistory.MOD_ID);
    }
}