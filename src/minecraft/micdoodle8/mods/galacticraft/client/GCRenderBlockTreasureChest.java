package micdoodle8.mods.galacticraft.client;

import micdoodle8.mods.galacticraft.GCBlocks;
import micdoodle8.mods.galacticraft.GCTileEntityTreasureChest;
import net.minecraft.src.Block;
import net.minecraft.src.ChestItemRenderHelper;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.TileEntityRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCRenderBlockTreasureChest implements ISimpleBlockRenderingHandler
{
    final int renderID;

    public GCRenderBlockTreasureChest(int var1)
    {
        this.renderID = var1;
    }

    public void renderInventoryBlock(Block var1, int var2, int var3, RenderBlocks var4) 
    {
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        this.renderChest(var1, var2, var3);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }

    public boolean renderWorldBlock(IBlockAccess var1, int var2, int var3, int var4, Block var5, int var6, RenderBlocks var7)
    {
    	return false;
    }

    public boolean shouldRender3DInInventory()
    {
        return true;
    }

    public int getRenderId()
    {
        return this.renderID;
    }
    
    private GCTileEntityTreasureChest chest = new GCTileEntityTreasureChest();
    
    public void renderChest(Block par1Block, int par2, float par3)
    {
        if (par1Block.blockID == GCBlocks.treasureChest.blockID)
        {
            TileEntityRenderer.instance.renderTileEntityAt(this.chest, 0.0D, 0.0D, 0.0D, 0.0F);
        }
    }
}
