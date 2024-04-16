package com.cosmo.dndadventures.networking.packet;

import com.cosmo.dndadventures.util.EntityDataSaver;
import com.cosmo.dndadventures.util.RaceData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ResetC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //EveryThing here happens ONLY on the server!

        RaceData.resetRace(((EntityDataSaver) player));

        player.sendMessage(Text.literal("race has been reset")
                .fillStyle(Style.EMPTY.withColor(Formatting.BLUE)), true);

    }
}
