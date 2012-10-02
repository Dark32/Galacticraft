package micdoodle8.mods.galacticraft;

import net.minecraft.src.Material;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCBlockLandingPad extends GCBlock
{
	public GCBlockLandingPad(int i, int j) 
	{
		super(i, j, Material.rock);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
	}
	
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
