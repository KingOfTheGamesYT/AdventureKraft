package com.teamolympus.dangerzone.networking;

import com.teamolympus.dangerzone.misc.DangerZone;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class DangerZoneNetworking {

    private static SimpleNetworkWrapper wrapper;

    public static void init() {
        wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(DangerZone.MODID + "packetHandler");

    }

    public static SimpleNetworkWrapper INSTANCE()
    {
        return wrapper;
    }

    int id = 1;
    private void registerPacket(Class handler, Class packet, Side side) {
        wrapper.registerMessage(handler, packet, id++, side);
    }

}
