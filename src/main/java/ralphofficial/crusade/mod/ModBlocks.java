package ralphofficial.crusade.mod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ralphofficial.crusade.mod.blockClasses.BaseSlab;
import ralphofficial.crusade.mod.blockClasses.BaseStairs;
import ralphofficial.crusade.mod.blockClasses.ConductorBlock;

public class ModBlocks {

    public static final Block MAVISTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f,6f).requiresTool());
    public static final Block BRONZE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f,6f).requiresTool());
    public static final Block MAUVESTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f,6f)
            .sounds(BlockSoundGroup.STONE).requiresTool());

    public static final Block POLISHED_MAVISTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f,6f).requiresTool());

    public static final BaseStairs POLISHED_MAVISTONE_STAIRS = new BaseStairs(POLISHED_MAVISTONE.getDefaultState(),
            FabricBlockSettings.of(Material.STONE).strength(1.5f,6f).requiresTool());
    public static final BaseStairs MAVISTONE_STAIRS = new BaseStairs(MAVISTONE.getDefaultState(),
            FabricBlockSettings.of(Material.STONE).strength(1.5f,6f).requiresTool());
    public static final BaseStairs MAUVESTONE_STAIRS = new BaseStairs(MAUVESTONE.getDefaultState(),
            FabricBlockSettings.of(Material.STONE).strength(1.5f,6f).requiresTool());

    public static final BaseSlab POLISHED_MAVISTONE_SLAB = new BaseSlab(FabricBlockSettings.of(Material.STONE)
            .strength(1.5f,6f).requiresTool());
    public static final BaseSlab MAVISTONE_SLAB = new BaseSlab(FabricBlockSettings.of(Material.STONE)
            .strength(1.5f,6f).requiresTool());
    public static final BaseSlab MAUVESTONE_SLAB = new BaseSlab(FabricBlockSettings.of(Material.STONE)
            .strength(1.5f,6f).requiresTool());

    public static final ConductorBlock BOLT_CONDUCTOR = new ConductorBlock(FabricBlockSettings.of(Material.METAL)
            .strength(1.5f,8f).sounds(BlockSoundGroup.METAL).requiresTool());

    public static void blockRegistry() {

        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "mavistone"), MAVISTONE);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "mavistone"),
                new BlockItem(MAVISTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "polished_mavistone"), POLISHED_MAVISTONE);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "polished_mavistone"),
                new BlockItem(POLISHED_MAVISTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "bronze_ore"), BRONZE_ORE);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "bronze_ore"),
                new BlockItem(BRONZE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "mauvestone"), MAUVESTONE);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "mauvestone"),
                new BlockItem(MAUVESTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "polished_mavistone_stairs"), POLISHED_MAVISTONE_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "polished_mavistone_stairs"),
                new BlockItem(POLISHED_MAVISTONE_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "mavistone_stairs"), MAVISTONE_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "mavistone_stairs"),
                new BlockItem(MAVISTONE_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "mauvestone_stairs"), MAUVESTONE_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "mauvestone_stairs"),
                new BlockItem(MAUVESTONE_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "polished_mavistone_slab"), POLISHED_MAVISTONE_SLAB);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "polished_mavistone_slab"),
                new BlockItem(POLISHED_MAVISTONE_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "mavistone_slab"), MAVISTONE_SLAB);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "mavistone_slab"),
                new BlockItem(MAVISTONE_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "mauvestone_slab"), MAUVESTONE_SLAB);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "mauvestone_slab"),
                new BlockItem(MAUVESTONE_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, "bolt_conductor"), BOLT_CONDUCTOR);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "bolt_conductor"),
                new BlockItem(BOLT_CONDUCTOR, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

    }

}
