package com.eagle.divinity;

import com.eagle.divinity.items.ItemLoader;
import com.eagle.divinity.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = Dictionary.MOD_ID, version = Dictionary.VERSION)
public class Divinity
{
    @SidedProxy(clientSide = "com.eagle.divinity.proxies.ClientProxy", serverSide = "com.eagle.divinity.proxies.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs tab = new CreativeTabs("tabDivinity")
    {
        @Override
        public Item getTabIconItem()
        {
            return ItemLoader.materials;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ItemLoader.load();
        RecipeHandler.load();
    }
}
