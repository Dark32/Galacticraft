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
public class GCItemSensorGlasses extends GCItemBreathableHelmet implements IArmorTextureProvider
{
	public boolean attachedMask;
	
	public GCItemSensorGlasses(int par1, EnumArmorMaterial material, int i, int j, boolean breathable) 
	{
		super(par1, material, i, j);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.attachedMask = breathable;
	}

    public String getArmorTextureFile(ItemStack itemstack)
    {
    	return attachedMask ? "/micdoodle8/mods/galacticraft/client/armor/sensorox_1.png" : "/micdoodle8/mods/galacticraft/client/armor/sensor_1.png";
    }
	
	public String getTextureFile()
	{
		return "/micdoodle8/mods/galacticraft/client/items/core.png";
	}
}
