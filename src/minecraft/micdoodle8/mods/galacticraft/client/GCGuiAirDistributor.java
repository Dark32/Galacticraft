package micdoodle8.mods.galacticraft.client;

import micdoodle8.mods.galacticraft.GCContainerAirDistributor;
import micdoodle8.mods.galacticraft.GCTileEntityOxygenDistributor;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;

import org.lwjgl.opengl.GL11;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCGuiAirDistributor extends GuiContainer
{
    private GCTileEntityOxygenDistributor distributorInv;
    
	public GCGuiAirDistributor(InventoryPlayer par1InventoryPlayer, GCTileEntityOxygenDistributor par2TileEntityAirDistributor) 
	{
        super(new GCContainerAirDistributor(par1InventoryPlayer, par2TileEntityAirDistributor));
        this.distributorInv = par2TileEntityAirDistributor;
	}

    protected void drawGuiContainerForegroundLayer()
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.airdistributor"), 8, 10, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 92 + 2, 4210752);
        this.fontRenderer.drawString("Power:  " + String.valueOf(9), 45, this.ySize - 142 + 2, 0x208326);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		int texture = this.mc.renderEngine.getTexture("/micdoodle8/mods/galacticraft/client/gui/distributor.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6 + 5, 0, 0, this.xSize, this.ySize);
	}
}
