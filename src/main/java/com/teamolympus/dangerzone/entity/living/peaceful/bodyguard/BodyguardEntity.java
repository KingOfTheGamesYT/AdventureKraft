package com.teamolympus.dangerzone.entity.living.peaceful.bodyguard;


import com.teamolympus.dangerzone.client.render.BodyguardRender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class BodyguardEntity extends EntityTameable /**implements IInvBasic **/{

    private EntityAITempt aiTempt;
    public int textureIndexMale;
    public int textureIndexGirl;

    public BodyguardEntity(World world) {
        super(world);
        this.textureIndexMale = this.rand.nextInt(BodyguardRender.TEXTURES_MALE.length);
        this.textureIndexGirl = this.rand.nextInt(BodyguardRender.TEXTURES_FEMALE.length);



        this.getNavigator().setAvoidsWater(false);
        this.getNavigator().setCanSwim(true);
        this.setGender(this.worldObj.rand.nextInt(2));
        this.setRequestedAmm(this.worldObj.rand.nextInt(99));
        this.setPlayerGivenAmm(0);
        this.setSize(0.6F, 1.8F);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
     //   this.tasks.addTask(8, new EntityAIBeg(this, 8.0F));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySheep.class, 200, false));
        this.setTamed(false);
        this.setCanPickUpLoot(true);
    }

    @Override
    // https://jabelarminecraft.blogspot.com/p/minecraft-modding-datawatcher.html
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, (byte)0); //gender

        this.dataWatcher.addObject(20, (byte)0); // entity tame requested amm

        this.dataWatcher.addObject(21, (byte)0); // Player given amm


        // textures
        this.dataWatcher.addObject(22, (byte)0);
        this.dataWatcher.addObject(23, (byte)0);
    }

    public int getPlayerGivenAmm()
    {
        return this.dataWatcher.getWatchableObjectByte(21);
    }

    public void setPlayerGivenAmm(int givenAmm)
    {
        this.dataWatcher.updateObject(21, (byte) givenAmm);
    }

    public int getRequestedAmm()
    {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public void setRequestedAmm(int requestedAmm)
    {
        this.dataWatcher.updateObject(20, (byte) requestedAmm);
    }

    public int getGender()
    {
        return this.dataWatcher.getWatchableObjectByte(18);
    }

    public void setGender(int gender)
    {
        this.dataWatcher.updateObject(18, (byte)gender);
    }

    public int getTextureFemale()
    {
        return this.dataWatcher.getWatchableObjectByte(22);
    }

    public void setTextureFemale(int text)
    {
        this.dataWatcher.updateObject(22, (byte)text);
    }

    public int getTextureMale()
    {
        return this.dataWatcher.getWatchableObjectByte(23);
    }

    public void setTextureMale(int text)
    {
        this.dataWatcher.updateObject(23, (byte)text);
    }

    public boolean isMale() {
        return getGender() == 1;
    }

    public boolean isFeMale() {
        return !(getGender() == 1);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("Gender", this.getGender());
        p_70014_1_.setInteger("RequestedAmm", this.getRequestedAmm());
        p_70014_1_.setInteger("PlayerGivenTameAmm", this.getPlayerGivenAmm());
        p_70014_1_.setInteger("femaleTextureIndex", this.getTextureFemale());
        p_70014_1_.setInteger("maleTextureIndex", this.getTextureMale());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.setGender(p_70037_1_.getInteger("Gender"));
        this.setRequestedAmm(p_70037_1_.getInteger("RequestedAmm"));
        this.setPlayerGivenAmm(p_70037_1_.getInteger("PlayerGivenTameAmm"));
        this.setTextureFemale(p_70037_1_.getInteger("femaleTextureIndex"));
        this.setTextureMale(p_70037_1_.getInteger("maleTextureIndex"));
    }

    @Override
    public boolean isAIEnabled()
    {
        return true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
    }

    @Override
    public int getTotalArmorValue()
    {
        int i = 0;
        i += 7;
        ItemStack[] aitemstack = this.getLastActiveItems();
        int j = aitemstack.length;

        for (int k = 0; k < j; ++k)
        {
            ItemStack itemstack = aitemstack[k];

            if (itemstack != null && itemstack.getItem() instanceof ItemArmor)
            {
                int l = ((ItemArmor)itemstack.getItem()).damageReduceAmount;
                i += l;
            }
        }

        return i;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        if (this.getHeldItem() != null && this.getHeldItem().getItem() != null && this.getHeldItem().getItem() instanceof ItemTool) {
            ItemTool tool = (ItemTool) this.getHeldItem().getItem();
            float damage = tool.func_150913_i().getDamageVsEntity();
            return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1.0F + damage);
        }

        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1.0F);
    }

    @Override
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            return super.attackEntityFrom(p_70097_1_, p_70097_2_);
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }


    short hasClickedMobRecentlyCounter = 0;
    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();


        if (!this.isTamed() && hasClickedMobRecentlyCounter < 3)
        {
            hasClickedMobRecentlyCounter++;
            player.addChatMessage(new ChatComponentText("If you give me a random amount of steak/poppies between 1 and 100, then I will ensure your safety forever."));
            player.addChatMessage(new ChatComponentText("Needed AMM" + this.getRequestedAmm()));
            player.addChatMessage(new ChatComponentText("Given Amm" + this.getPlayerGivenAmm()));
        }

        if (this.isTamed())
        {
            if (this./*IsPlayerOwner*/func_152114_e(player) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack))
            {
                this.aiSit.setSitting(!this.isSitting());
            }
        }
        else if (itemstack != null)
        {
            executeItemRemovalTameLogic(player, itemstack);
            if (!this.worldObj.isRemote)
            {
                if (this.getPlayerGivenAmm() >= this.getRequestedAmm())
                {
                    this.setTamed(true);
                    this.func_152115_b(player.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.aiSit.setSitting(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }
            }

            return true;
        }

        return super.interact(player);
    }

    private void executeItemRemovalTameLogic(EntityPlayer player , ItemStack itemstack) {
        int random = rand.nextInt(3);
        if (this.isMale()) {
            if (itemstack.getItem() == Items.cooked_beef) {
                this.removeItemDependingOnGender(player, itemstack);
            } else {
                incorrectItemMale(random, player);
            }
        } else if (this.isFeMale()) {
            if (itemstack.getItem() == Item.getItemFromBlock(Blocks.red_flower)) {
                this.removeItemDependingOnGender(player, itemstack);
            } else {
                incorrectItemFemale(random, player);
            }

        }
    }

    private void incorrectItemFemale(int random, EntityPlayer player) {
        if (random == 1) {
            player.addChatMessage(new ChatComponentText("Did you get me my Poppy yet?"));
        } else {
            player.addChatMessage(new ChatComponentText("That is not what I asked for!"));
        }
    }

    private void incorrectItemMale(int random, EntityPlayer player) {
        if (random == 1) {
            player.addChatMessage(new ChatComponentText("Did you get me my Steak yet?"));
        } else {
            player.addChatMessage(new ChatComponentText("That is not what I asked for!"));
        }
    }

    private void removeItemDependingOnGender(EntityPlayer player, ItemStack itemstack) {
        if (!player.capabilities.isCreativeMode)
        {
            --itemstack.stackSize;
        }

        this.setPlayerGivenAmm(this.getPlayerGivenAmm() + 1);
        if (itemstack.stackSize <= 0)
        {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack)
    {
        if (itemStack != null) {
            if (this.isMale()) {
                return itemStack.getItem() == Items.cooked_beef;
            } else {
                return itemStack.getItem() == Item.getItemFromBlock(Blocks.red_flower);
            }
        }
        return false;
    }


    @Override
    public boolean canMateWith(EntityAnimal p_70878_1_)
    {
        return false;
    }

    @Override
    public String getCommandSenderName()
    {
        return this.hasCustomNameTag() ? this.getCustomNameTag() : (this.isTamed() ? StatCollector.translateToLocal("entity.Cat.name") : super.getCommandSenderName());
    }

    @Override
    public BodyguardEntity createChild(EntityAgeable p_90011_1_) {
        return null;
    }

 /**   @Override
    public void onInventoryChanged(InventoryBasic p_76316_1_) {

    }
 **/
}
