package com.cosmo.dndadventures.networking.packet;

import com.cosmo.dndadventures.races.Races;
import com.cosmo.dndadventures.screen.racechoosingscreen;
import com.cosmo.dndadventures.util.EntityDataSaver;
import com.cosmo.dndadventures.util.RaceData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.Objects;


public class SetC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //EveryThing here happens ONLY on the server!
        int num = racechoosingscreen.num;
        RaceData.setRace(((EntityDataSaver) player),"test");
        player.sendMessage(Text.literal("race " + ((EntityDataSaver) player).getPersistentData().getString("race"))
                .fillStyle(Style.EMPTY.withColor(Formatting.BLUE)), true);
        Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(10);
    }
}
