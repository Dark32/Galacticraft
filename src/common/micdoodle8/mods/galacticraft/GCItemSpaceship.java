package micdoodle8.mods.galacticraft;

import java.util.List;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCItemSpaceship extends GCItem
{
	public GCItemSpaceship(int par1) 
	{
		super(par1);
	}

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	int amountOfCorrectBlocks = 0;
    	
    	if (par3World.isRemote)
    	{
    		return false;
    	}
    	else
    	{
    		for (int i = -1; i < 2; i++)
    		{
    			for (int j = -1; j < 2; j++)
        		{
    				if (par3World.getBlockId(par4 + i, par5, par6 + j) == GCBlocks.landingPad.blockID)
    				{
    					amountOfCorrectBlocks++;
    				}
        		}
    		}
    		
    		if (amountOfCorrectBlocks == 9)
    		{
	    		par3World.spawnEntityInWorld(new GCEntitySpaceship(par3World, (double)((float)par4 + 0.5F), (double)((float)par5 - 1.5F), (double)((float)par6 + 0.5F), false));
	    		if (!par2EntityPlayer.capabilities.isCreativeMode)
	    		par2EntityPlayer.inventory.consumeInventoryItem(par1ItemStack.getItem().shiftedIndex);
    		}
    		else
    		{
    			return false;
    		}
    	}
        return true;
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, List par2List) 
    {
    	par2List.add("Failure chance: " + String.valueOf(GCUtil.getSpaceshipFailChance(FMLClientHandler.instance().getClient().thePlayer)) + "%");
    }
}
