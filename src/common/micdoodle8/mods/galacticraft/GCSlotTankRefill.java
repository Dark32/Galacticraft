package micdoodle8.mods.galacticraft;

import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCSlotTankRefill extends Slot 
{
	public GCSlotTankRefill(IInventory par3IInventory, int par4, int par5, int par6) 
	{
		super(par3IInventory, par4, par5, par6);
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack)
	{
		return GCUtil.getDrainSpacing(par1ItemStack) > 0;
	}

	@Override
	public int getSlotStackLimit() 
	{
		return 1;
	}
}
