package micdoodle8.mods.galacticraft.client;

import micdoodle8.mods.galacticraft.GCEntityCreeper;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
@SideOnly(Side.CLIENT)
public class GCRenderCreeper extends RenderLiving
{
    private ModelBase creeperModel = new GCModelCreeper(2.0F);

    public GCRenderCreeper()
    {
        super(new GCModelCreeper(), 0.5F);
    }

    /**
     * Updates creeper scale in prerender callback
     */
    protected void updateCreeperScale(GCEntityCreeper par1GCEntityCreeper, float par2)
    {
        float var4 = par1GCEntityCreeper.setCreeperFlashTime(par2);
        float var5 = 1.0F + MathHelper.sin(var4 * 100.0F) * var4 * 0.01F;

        if (var4 < 0.0F)
        {
            var4 = 0.0F;
        }

        if (var4 > 1.0F)
        {
            var4 = 1.0F;
        }

        var4 *= var4;
        var4 *= var4;
        float var6 = (1.0F + var4 * 0.4F) * var5;
        float var7 = (1.0F + var4 * 0.1F) / var5;
        GL11.glScalef(var6, var7, var6);
    }

    /**
     * Updates color multiplier based on creeper state called by getColorMultiplier
     */
    protected int updateCreeperColorMultiplier(GCEntityCreeper par1GCEntityCreeper, float par2, float par3)
    {
        float var5 = par1GCEntityCreeper.setCreeperFlashTime(par3);

        if ((int)(var5 * 10.0F) % 2 == 0)
        {
            return 0;
        }
        else
        {
            int var6 = (int)(var5 * 0.2F * 255.0F);

            if (var6 < 0)
            {
                var6 = 0;
            }

            if (var6 > 255)
            {
                var6 = 255;
            }

            short var7 = 255;
            short var8 = 255;
            short var9 = 255;
            return var6 << 24 | var7 << 16 | var8 << 8 | var9;
        }
    }

    /**
     * A method used to render a creeper's powered form as a pass model.
     */
    protected int renderCreeperPassModel(GCEntityCreeper par1GCEntityCreeper, int par2, float par3)
    {
        if (par1GCEntityCreeper.getPowered())
        {
            if (par2 == 1)
            {
                float var4 = (float)par1GCEntityCreeper.ticksExisted + par3;
                this.loadTexture("/armor/power.png");
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                float var5 = var4 * 0.01F;
                float var6 = var4 * 0.01F;
                GL11.glTranslatef(var5, var6, 0.0F);
                this.setRenderPassModel(this.creeperModel);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_BLEND);
                float var7 = 0.5F;
                GL11.glColor4f(var7, var7, var7, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
                return 1;
            }

            if (par2 == 2)
            {
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
            }
        }

        return -1;
    }

    protected int func_77061_b(GCEntityCreeper par1GCEntityCreeper, int par2, float par3)
    {
        return -1;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.updateCreeperScale((GCEntityCreeper)par1EntityLiving, par2);
    }

    /**
     * Returns an ARGB int color back. Args: entityLiving, lightBrightness, partialTickTime
     */
    protected int getColorMultiplier(EntityLiving par1EntityLiving, float par2, float par3)
    {
        return this.updateCreeperColorMultiplier((GCEntityCreeper)par1EntityLiving, par2, par3);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.renderCreeperPassModel((GCEntityCreeper)par1EntityLiving, par2, par3);
    }

    protected int inheritRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.func_77061_b((GCEntityCreeper)par1EntityLiving, par2, par3);
    }
}
