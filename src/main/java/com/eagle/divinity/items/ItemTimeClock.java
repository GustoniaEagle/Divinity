package com.eagle.divinity.items;

import com.eagle.divinity.Dictionary;
import com.eagle.divinity.Divinity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Mikael on 07/08/2014.
 */
public class ItemTimeClock extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icon;

    int itemCount = 24;

    public ItemTimeClock()
    {
        this.setHasSubtypes(true);
        this.setCreativeTab(Divinity.tab);
        this.setMaxStackSize(1);
    }

    public String getUnlocalizedName(ItemStack itemStack)
    {
        int i = MathHelper.clamp_int(itemStack.getItemDamage(), 0, itemCount - 1);
        return super.getUnlocalizedName() + "." + Dictionary.MATERIAL_NAMES[i] + "TimeClock";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tabs, List list)
    {
        for (int j = 0; j < itemCount; ++j)
        {
            list.add(new ItemStack(this, 1, j));
        }
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        this.icon = new IIcon[Dictionary.MATERIAL_NAMES.length];

        for (int i = 0; i < Dictionary.MATERIAL_NAMES.length; ++i)
        {
            this.icon[i] = iconRegister.registerIcon(Dictionary.MOD_ID + ":" + Dictionary.MATERIAL_NAMES[i] + "TimeClock");
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        int j = MathHelper.clamp_int(meta, 0, itemCount-1);
        return this.icon[j];
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        int time = (100*getDamage(itemStack))+100;

        if (!player.isSneaking())
        {
            world.setWorldTime(world.getWorldTime()+time);
            if (!world.isRemote)
            {
                player.worldObj.playSoundAtEntity(player, "random.pop", 0.1F, 1.3F);
                player.addChatMessage(new ChatComponentText("Time increased by " + time + "."));
            }
        }
        if (player.isSneaking())
        {
            world.setWorldTime(world.getWorldTime()-time);
            if (!world.isRemote)
            {
                player.worldObj.playSoundAtEntity(player, "random.fizz", 0.1F, 1.3F);
                player.addChatMessage(new ChatComponentText("Time decreased by " + time + "."));
            }
        }
        return itemStack;
    }
}
