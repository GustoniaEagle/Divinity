package com.eagle.divinity;

import com.eagle.divinity.items.ItemLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Mikael on 07/08/2014.
 */
public class RecipeHandler
{
    public static void load()
    {
        GameRegistry.addRecipe(new ItemStack(ItemLoader.materials), "XYX", "YXY", "XYX", 'X', Blocks.diamond_block, 'Y', Blocks.obsidian);
        GameRegistry.addRecipe(new ItemStack(ItemLoader.clock), " X ", "XYX", " X ", 'X', new ItemStack(ItemLoader.materials, 1, 0), 'Y', Items.clock);
        for (int i = 0; i < 23; i++)
        {
            GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.materials, 1, i + 1), new ItemStack(ItemLoader.materials, 1, i), new ItemStack(ItemLoader.materials, 1, i));
            GameRegistry.addRecipe(new ItemStack(ItemLoader.clock, 1, i + 1), " X ", "XYX", " X ", 'X', new ItemStack(ItemLoader.materials, 1, i + 1), 'Y', new ItemStack(ItemLoader.clock, 1, i));
        }
    }
}
