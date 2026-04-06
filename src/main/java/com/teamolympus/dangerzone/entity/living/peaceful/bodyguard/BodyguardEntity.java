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
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class BodyguardEntity extends EntityTameable implements IInvBasic {

    private EntityAITempt aiTempt;

    private int lastFoodCheckTick;

    public BodyguardEntity(World world) {
        super(world);
        this.setTextureMale(this.rand.nextInt(BodyguardRender.TEXTURES_MALE.length));
        this.setTextureFemale(this.rand.nextInt(BodyguardRender.TEXTURES_FEMALE.length));
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
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySheep.class, 200, false));
        this.setTamed(false);
        this.setCanPickUpLoot(true);
    }



    static final int GENDER = 19;
    static final int ENTITY_REQUESTED_TAME_AMM =20;
    static final int PLAYER_GIVEN_TAME_AMM = 21;

    static final int TEXTUREID_MALE = 22;
    static final int TEXTUREID_FEMALE = 23;
    static final int HUNGER = 24;
    static final int ANGER = 25;

    @Override
    // https://jabelarminecraft.blogspot.com/p/minecraft-modding-datawatcher.html
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(GENDER, (byte)0); //gender

        this.dataWatcher.addObject(ENTITY_REQUESTED_TAME_AMM, (byte)0); // entity tame requested amm

        this.dataWatcher.addObject(PLAYER_GIVEN_TAME_AMM, (byte)0); // Player given amm

        //TODO: REWRITE USING THE SYSTEM DEV PROVIDED
        this.dataWatcher.addObject(TEXTUREID_FEMALE, (byte)0); // female
        this.dataWatcher.addObject(TEXTUREID_MALE, (byte)0); // male

        this.dataWatcher.addObject(HUNGER, (byte)20); // hunger
        this.dataWatcher.addObject(ANGER, (byte)0); // anger
    }

    public int getAnger()
    {
        return this.dataWatcher.getWatchableObjectByte(ANGER);
    }

    public void setAnger(int text)
    {
        this.dataWatcher.updateObject(ANGER, (byte)text);
    }

    public void increaseAnger(int amm) {
        this.setAnger(this.getAnger() + 1);
    }


    public int getHunger()
    {
        return this.dataWatcher.getWatchableObjectByte(HUNGER);
    }

    public void setHunger(int text)
    {
        this.dataWatcher.updateObject(HUNGER, (byte)text);
    }

    public void decreaseFoodLevel(int amm)
    {
        setHunger(this.getHunger() - amm);
    }

    public int getPlayerGivenAmm()
    {
        return this.dataWatcher.getWatchableObjectByte(PLAYER_GIVEN_TAME_AMM);
    }

    public void setPlayerGivenAmm(int givenAmm)
    {
        this.dataWatcher.updateObject(PLAYER_GIVEN_TAME_AMM, (byte) givenAmm);
    }

    public int getRequestedAmm()
    {
        return this.dataWatcher.getWatchableObjectByte(ENTITY_REQUESTED_TAME_AMM);
    }

    public void setRequestedAmm(int requestedAmm)
    {
        this.dataWatcher.updateObject(ENTITY_REQUESTED_TAME_AMM, (byte) requestedAmm);
    }

    public int getGender()
    {
        return this.dataWatcher.getWatchableObjectByte(GENDER);
    }

    public void setGender(int gender)
    {
        this.dataWatcher.updateObject(GENDER, (byte)gender);
    }

    public int getTextureFemale()
    {
        return this.dataWatcher.getWatchableObjectByte(TEXTUREID_FEMALE);
    }

    public void setTextureFemale(int text)
    {
        this.dataWatcher.updateObject(TEXTUREID_FEMALE, (byte)text);
    }

    public int getTextureMale()
    {
        return this.dataWatcher.getWatchableObjectByte(TEXTUREID_MALE);
    }

    public void setTextureMale(int text)
    {
        this.dataWatcher.updateObject(TEXTUREID_MALE, (byte)text);
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
        p_70014_1_.setInteger("FoodLevel", this.getHunger());
        p_70014_1_.setInteger("Anger", this.getAnger());

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
        this.setHunger(p_70037_1_.getInteger("FoodLevel"));
        this.setAnger(p_70037_1_.getInteger("Anger"));

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

        for (ItemStack itemstack : aitemstack) {
            if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                int l = ((ItemArmor) itemstack.getItem()).damageReduceAmount;
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

        if (this.ticksExisted - lastFoodCheckTick > 900)
        {
            lastFoodCheckTick = this.ticksExisted;
            decreaseFoodLevel(1);

            if (this.getHunger() <= 0)
            {
                this.attackEntityFrom(DamageSource.starve, 1.0F);
                increaseAnger(1);
            }
        }


        if (this.getAnger() > 100 && isTamed()) {
            System.out.println("I am angry");
        }

    }


    short hasClickedMobRecentlyCounter = 0;
    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();


        if (!this.isTamed() && hasClickedMobRecentlyCounter < 3)
        {
            hasClickedMobRecentlyCounter++;
            player.addChatMessage(new ChatComponentTranslation("BodyguardSafety"));
           // player.addChatMessage(new ChatComponentTranslation("Needed AMM" + this.getRequestedAmm()));
          //  player.addChatMessage(new ChatComponentTranslation("Given Amm" + this.getPlayerGivenAmm()));
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

            if (itemstack.getItem() == Items.diamond && getAnger() > 100) {
                --itemstack.stackSize;
                setAnger(0);
                player.addChatMessage(new ChatComponentTranslation("BodyguardClamed"));
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
            player.addChatMessage(new ChatComponentTranslation("BodyguardTamePoppy"));
        } else {
            player.addChatMessage(new ChatComponentTranslation("BodyguardIncorrectItem"));
        }
    }

    private void incorrectItemMale(int random, EntityPlayer player) {
        if (random == 1) {
            player.addChatMessage(new ChatComponentTranslation("BodyguardTameSteak"));
        } else {
            player.addChatMessage(new ChatComponentTranslation("BodyguardIncorrectItem"));
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

   @Override
    public void onInventoryChanged(InventoryBasic p_76316_1_) {

    }

}
