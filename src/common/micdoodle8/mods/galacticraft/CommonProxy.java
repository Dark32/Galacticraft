package micdoodle8.mods.galacticraft;

import java.util.List;

import micdoodle8.mods.galacticraft.client.GCGuiAirDistributor;
import micdoodle8.mods.galacticraft.client.GCGuiTankRefill;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class CommonProxy implements IGuiHandler
{
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	public void registerRenderInformation()
	{
		
	}
	
	public int getGCFluidRenderID()
	{
		return -1;
	}
	
	public int getGCUnlitTorchRenderID()
	{
		return -1;
	}
	
	public int getGCBreathableAirRenderID()
	{
		return -1;
	}
	
	public int getGCOxygenPipeRenderID()
	{
		return -1;
	}
	
	public World getClientWorld()
	{
		return null;
	}
	
	public void displayChoosePlanetGui()
	{
	}
	
    public void spawnParticle(String var1, double var2, double var4, double var6, double var8, double var10, double var12, boolean b) {}
    
    
    // IGUIHANDLER IMPLEMENTATION:
    
    GCInventoryTankRefill inv = null;

    public static List<GCInventoryTankRefill> airTanks = Lists.newArrayList();
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == GCConfigManager.idGuiTankRefill)
		{
			for (int i = 0; i < Galacticraft.serverPlayerAPIs.size(); ++i)
	        {
				GCPlayerBaseServer playerBase = (GCPlayerBaseServer) Galacticraft.serverPlayerAPIs.get(i);
				
				if (player.username == playerBase.getPlayer().username)
				{
					return new GCContainerTankRefill(player.inventory, playerBase.playerTankInventory);
				}
	        }
		}
		else if (ID == GCConfigManager.idGuiAirDistributor)
		{
			GCTileEntityOxygenDistributor distributor = (GCTileEntityOxygenDistributor) world.getBlockTileEntity(x, y, z);

			return new GCContainerAirDistributor(player.inventory, distributor);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == GCConfigManager.idGuiTankRefill)
		{
			return new GCGuiTankRefill(player);
		}
		else if (ID == GCConfigManager.idGuiAirDistributor)
		{
			GCTileEntityOxygenDistributor distributor = (GCTileEntityOxygenDistributor) world.getBlockTileEntity(x, y, z);
			
			return new GCGuiAirDistributor(player.inventory, distributor);
		}
		else
		{
			return null;
		}
	}
}
