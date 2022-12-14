package net.maxmag_change.harbingerofhistory.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.block.custom.*;
import net.maxmag_change.harbingerofhistory.item.ModItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(5f).luminance(3)), ModItemGroup.TANZANITE);
    public static final Block JUMPY_BLOCK = registerBlock("jumpy_block",
            new JumpyBlock(FabricBlockSettings.of(Material.METAL).strength(5f).luminance(15)), ModItemGroup.SPECIAL);
    public static final Block RTP_BLOCK = registerBlock("rtp_block",
            new RtpBlock(FabricBlockSettings.of(Material.TNT).strength(12f).luminance(1).noCollision().strength(16000f)), ModItemGroup.SPECIAL);
    public static final Block GOLD_FENCE = registerBlock("gold_fence",
            new GoldFence(FabricBlockSettings.of(Material.METAL).strength(2f)), ModItemGroup.SPECIAL);
    public static final Block PIANO = registerBlock("piano",
            new Piano(FabricBlockSettings.of(Material.WOOD).strength(2f)), ModItemGroup.SPECIAL);
    public static final Block SHOW_CASE = registerBlock("show_case",
            new ShowCase(FabricBlockSettings.of(Material.METAL).strength(2f)), ModItemGroup.SPECIAL);
    public static final Block SCAMP_ORE = registerBlock("scamp_ore",
            new ScampOre(FabricBlockSettings.of(Material.METAL).strength(4f)), ModItemGroup.SCAMP);
    public static final Block SCAMP_BLOCK = registerBlock("scamp_block",
            new ScampBlock(FabricBlockSettings.of(Material.METAL).strength(3f)), ModItemGroup.SCAMP);
    public static final Block QUARTZ_FENCE = registerBlock("quartz_fence",
            new FenceBlock(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool()), ModItemGroup.SPECIAL);
    public static final Block QUARTZ_WALL = registerBlock("quartz_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool()), ModItemGroup.SPECIAL);
    public static final Block LANTERN_STAND = registerBlock("lantern_stand",
            new LanternStand(FabricBlockSettings.of(Material.STONE).strength(2f)), ModItemGroup.SPECIAL);
    public static final Block TOMB_STONE = registerBlock("tomb_stone",
            new TombStone(FabricBlockSettings.of(Material.STONE).strength(2f)), ModItemGroup.SPECIAL);
    public static final Block LANTERN = registerBlock("lantern",
            new Lantern(FabricBlockSettings.of(Material.METAL).strength(2f).luminance(13)), ModItemGroup.SPECIAL);
    public static final Block HELLOWEEN_PUMPKIN = registerBlock("helloween_pumpkin",
            new Block(FabricBlockSettings.of(Material.BAMBOO).strength(1f)), ModItemGroup.SPECIAL);
    public static final Block WIDE_TOMB_STONE = registerBlock("wide_tomb_stone",
            new WideTombStone(FabricBlockSettings.of(Material.STONE).strength(2f)), ModItemGroup.SPECIAL);
    public static final Block WIDE_TOMB_STONE_WITH_FLOWERS = registerBlock("wide_tomb_stone_with_flowers",
            new WideTombStone(FabricBlockSettings.of(Material.STONE).strength(2f)), ModItemGroup.SPECIAL);


    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(HarbingerOfHistory.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(HarbingerOfHistory.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void registerModBlocks() {
        HarbingerOfHistory.LOGGER.debug("Registering ModBlocks for " + HarbingerOfHistory.MOD_ID);
    }
}
