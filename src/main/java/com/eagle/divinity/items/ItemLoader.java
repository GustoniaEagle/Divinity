package com.eagle.divinity.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by Mikael on 07/08/2014.
 */
public class ItemLoader
{
    public static Item materials = new ItemMaterials();
    public static Item clock = new ItemTimeClock();
    public static void load()
    {
        materials.setUnlocalizedName("divinityMaterials");
        clock.setUnlocalizedName("timeClock");
        //
        GameRegistry.registerItem(materials, "Divinity_materials");
        GameRegistry.registerItem(clock, "Divinity_clock");
    }
}
