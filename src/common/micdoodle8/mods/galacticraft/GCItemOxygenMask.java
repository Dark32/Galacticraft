package micdoodle8.mods.galacticraft;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCItemOxygenMask extends GCItemBreathableHelmet implements IArmorTextureProvider
{
	protected GCItemOxygenMask(int par1, EnumArmorMaterial material, int i, int j) 
	{
		super(par1, material, j, j);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}

    public String getArmorTextureFile(ItemStack itemstack)
    {
    	return "/micdoodle8/mods/galacticraft/client/armor/oxygen_1.png";
    }
	
	public String getTextureFile()
	{
		return "/micdoodle8/mods/galacticraft/client/items/core.png";
	}
}
