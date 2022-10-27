package net.maxmag_change.harbingerofhistory.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item EARTH_HARDENED_STEEL = registerItem("earth_hardened_steel",
            new Item(new FabricItemSettings().group(ModItemGroup.EARTH_HARDENED_STEEL)));
    public static final Item RED_CANDY_CANE = registerItem("red_candy_cane",
            new Item(new FabricItemSettings().group(ModItemGroup.FOOD).food(ModFoodComponents.CANDY_CANE)));
    public static final Item PURPLE_CANDY_CANE = registerItem("purple_candy_cane",
            new Item(new FabricItemSettings().group(ModItemGroup.FOOD).food(ModFoodComponents.CANDY_CANE)));
    public static final Item BLUE_CANDY_CANE = registerItem("blue_candy_cane",
            new Item(new FabricItemSettings().group(ModItemGroup.FOOD).food(ModFoodComponents.CANDY_CANE)));
    public static final Item CANDY_CORN = registerItem("candy_corn",
            new Item(new FabricItemSettings().group(ModItemGroup.FOOD).food(ModFoodComponents.CANDY_CORN)));
    public static final Item TANZANITE_DAGGER = registerItem("tanzanite_dagger",
            new SwordItem(ModToolMaterials.TANZANITE, 7, 1f, new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item COBBLESTONE_SHIELD = registerItem("cobblestone_shield",
            new ShieldItem(new FabricItemSettings().group(ModItemGroup.SPECIAL)));
    public static final Item CANDY_LAIN = registerItem("candy_lain",
            new Item(new FabricItemSettings().group(ModItemGroup.SPECIAL)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(HarbingerOfHistory.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HarbingerOfHistory.LOGGER.debug("Registering Mod Items for " + HarbingerOfHistory.MOD_ID);
    }

}
