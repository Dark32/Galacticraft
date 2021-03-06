package micdoodle8.mods.galacticraft;

import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;

public abstract class GCEntityMob extends EntityMob
{
	public GCEntityMob(World par1World) 
	{
		super(par1World);
	}
    
    private boolean handleBacterialMovement()
    {
        return this.worldObj.isMaterialInBB(this.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), GCBlocks.bacterialSludge);
    }

	@Override
    public void onUpdate()
    {
    	super.onUpdate();
    	
    	this.fallDistance = 0;

        if (this.rand.nextFloat() < 0.8F && handleBacterialMovement())
        {
            this.isJumping = true;
        }
		
		if (handleBacterialMovement() && !this.isPotionActive(Potion.poison))
		{
			this.addPotionEffect(new PotionEffect(Potion.poison.id, 40, 0));
		}
    }

	@Override
    public void moveEntityWithHeading(float par1, float par2)
    {
        super.moveEntityWithHeading(par1, par2);
		
        if (this.handleBacterialMovement())
        {
            double var9 = this.posY;
            this.moveFlying(par1, par2, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
            this.motionY -= 0.02D;

            if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579D - this.posY + var9, this.motionZ))
            {
                this.motionY = 0.30000001192092896D;
            }
        }
    }

	@Override
    public void fall(float var1)
    {
		;
    }
}
