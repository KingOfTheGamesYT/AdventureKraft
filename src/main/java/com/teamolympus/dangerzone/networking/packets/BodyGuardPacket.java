package com.teamolympus.dangerzone.networking.packets;

import com.teamolympus.dangerzone.entity.living.peaceful.bodyguard.BodyguardEntity;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;

public class BodyGuardPacket implements IMessage {

    // Needed for initilization
    public BodyGuardPacket()
    {

    }

     BodyguardEntity guard;
     IInventory inv;
     EntityPlayer player;
    public BodyGuardPacket(EntityPlayer player, BodyguardEntity guard, IInventory inv)
    {
        this.player = player;
        this.guard = guard;
        this.inv = inv;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {

    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    }

    public static class Handler implements IMessageHandler<BodyGuardPacket, IMessage> {

        @Override
        public IMessage onMessage(BodyGuardPacket message, MessageContext ctx)
        {
            return null;
        }
    }
}
