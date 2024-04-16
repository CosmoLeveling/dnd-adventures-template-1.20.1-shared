package com.cosmo.dndadventures.networking;


import com.cosmo.dndadventures.DndAdventures;
import com.cosmo.dndadventures.networking.packet.ResetC2SPacket;
import com.cosmo.dndadventures.networking.packet.SetC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier SETTING_ID = new Identifier(DndAdventures.MOD_ID,"test");
    public static final Identifier RESETING_ID = new Identifier(DndAdventures.MOD_ID,"reset");
    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(SETTING_ID, SetC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(RESETING_ID, ResetC2SPacket::receive);
    }

    public static void registerS2CPackets() {

    }

}
