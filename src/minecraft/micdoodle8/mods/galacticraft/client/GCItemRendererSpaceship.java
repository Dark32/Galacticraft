package micdoodle8.mods.galacticraft.client;

import micdoodle8.mods.galacticraft.GCEntitySpaceship;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.Tessellator;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCItemRendererSpaceship implements IItemRenderer 
{
	GCEntitySpaceship spaceship = new GCEntitySpaceship(FMLClientHandler.instance().getClient().theWorld);
	GCModelSpaceship modelSpaceship = new GCModelSpaceship();
    
	private void renderPipeItem(ItemRenderType type, RenderBlocks render, ItemStack item, float translateX, float translateY, float translateZ) 
	{
        GL11.glPushMatrix();
        long var10 = (long)spaceship.entityId * 493286711L;
        var10 = var10 * var10 * 4392167121L + var10 * 98761L;
        float var12 = (((float)(var10 >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float var13 = (((float)(var10 >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float var14 = (((float)(var10 >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        
        if (type == ItemRenderType.EQUIPPED)
        {
            GL11.glScalef(2.2F, 2.2F, 2.2F);
            GL11.glTranslatef(0.3F, 0.7F, 0.4F);
        }
        
        GL11.glTranslatef(var12, var13 - 0.1F, var14);
        GL11.glScalef(-0.4F, -0.4F, 0.4F);
        if (type == ItemRenderType.INVENTORY)
        {
        	GL11.glRotatef(80F, 1F, 0F, 1F);
        	GL11.glRotatef(20F, 1F, 0F, 0F);
        	GL11.glScalef(1.3F, 1.3F, 1.3F);
        	GL11.glTranslatef(0, -0.6F, 0);
        	GL11.glRotatef((ClientProxy.getCurrentTime - ClientProxy.getFirstBootTime) / 20, 0F, 1F, 0F);
        }
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(FMLClientHandler.instance().getClient().renderEngine.getTexture("/micdoodle8/mods/galacticraft/client/entities/spaceship1.png"));
        this.modelSpaceship.render(spaceship, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
	}

	
	/** IItemRenderer implementation **/
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		switch (type) {
		case ENTITY:
			return false;
		case EQUIPPED:
			return true;
		case INVENTORY:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		switch (type) 
		{
		case EQUIPPED:
			renderPipeItem(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		case INVENTORY:
			renderPipeItem(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		default:
		}
	}

}
