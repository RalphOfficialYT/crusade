package ralphofficial.crusade.mod;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import ralphofficial.crusade.mod.itemClasses.DynamiteItem;

public class ModItems {

    //Main mod itemgroup (can be accessed in creative mode)
    public static final ItemGroup CRUSADE = FabricItemGroupBuilder.create(
            new Identifier(MainClass.MOD_ID, "crusade"))
            .icon(() -> new ItemStack(ModItems.AMETHYST_ORB))
            .appendItems(itemStacks -> {
                itemStacks.add(new ItemStack(ModItems.AMETHYST_ORB));
                itemStacks.add(new ItemStack(ModBlocks.MAVISTONE));
                itemStacks.add(new ItemStack(ModBlocks.MAVISTONE_STAIRS));
                itemStacks.add(new ItemStack(ModBlocks.MAVISTONE_SLAB));
                itemStacks.add(new ItemStack(ModBlocks.POLISHED_MAVISTONE));
                itemStacks.add(new ItemStack(ModBlocks.POLISHED_MAVISTONE_STAIRS));
                itemStacks.add(new ItemStack(ModBlocks.POLISHED_MAVISTONE_SLAB));
                itemStacks.add(new ItemStack(ModBlocks.MAUVESTONE));
                itemStacks.add(new ItemStack(ModBlocks.MAUVESTONE_STAIRS));
                itemStacks.add(new ItemStack(ModBlocks.MAUVESTONE_SLAB));
                itemStacks.add(new ItemStack(ModBlocks.BRONZE_ORE));
                itemStacks.add(new ItemStack(ModItems.RAW_BRONZE));
                itemStacks.add(new ItemStack(ModItems.BRONZE_INGOT));
                itemStacks.add(new ItemStack(ModBlocks.BOLT_CONDUCTOR));
                itemStacks.add(new ItemStack(ModItems.DYNAMITE));
            })
            .build();

    //Creates all items
    public static final Item AMETHYST_ORB = new Item(new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.UNCOMMON));
    public static final Item RAW_BRONZE = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item BRONZE_INGOT = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item DYNAMITE = new DynamiteItem(new Item.Settings().group(ItemGroup.MISC).maxCount(16));

    public static void itemRegistry() {
        //Registers all Items
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "amethyst_orb"), AMETHYST_ORB);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "raw_bronze"), RAW_BRONZE);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "bronze_ingot"), BRONZE_INGOT);
        Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, "dynamite"), DYNAMITE);

    }

}
