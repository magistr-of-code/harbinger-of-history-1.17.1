package net.maxmag_change.harbingerofhistory.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.block.ModBlocks;
import net.maxmag_change.harbingerofhistory.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(
            new Identifier(HarbingerOfHistory.MOD_ID, "tanzanite"), () -> new ItemStack(ModItems.RAW_TANZANITE));
    public static final ItemGroup EARTH_HARDENED_STEEL = FabricItemGroupBuilder.build(
            new Identifier(HarbingerOfHistory.MOD_ID, "earth_hardened_steel"), () -> new ItemStack(ModItems.EARTH_HARDENED_STEEL));
    public static final ItemGroup SPECIAL = FabricItemGroupBuilder.build(
            new Identifier(HarbingerOfHistory.MOD_ID, "special"), () -> new ItemStack(ModBlocks.JUMPY_BLOCK));
    public static final ItemGroup FOOD = FabricItemGroupBuilder.build(
            new Identifier(HarbingerOfHistory.MOD_ID, "food"), () -> new ItemStack(ModItems.RED_CANDY_CANE));
    public static final ItemGroup SCAMP = FabricItemGroupBuilder.build(
            new Identifier(HarbingerOfHistory.MOD_ID, "scamp"), () -> new ItemStack(ModBlocks.SCAMP_ORE));
}
