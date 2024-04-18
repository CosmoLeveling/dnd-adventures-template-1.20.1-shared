package com.cosmo.dndadventures.networking.packet;

import com.cosmo.dndadventures.races.Races;
import com.cosmo.dndadventures.screen.racechoosingscreen;
import com.cosmo.dndadventures.util.EntityDataSaver;
import com.cosmo.dndadventures.util.RaceData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.cosmo.dndadventures.ModRegisteryKeys.RACES_KEY;


public class SetC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //EveryThing here happens ONLY on the server!
        int num = racechoosingscreen.num;
        List<RegistryEntry.Reference<Races>> list = racechoosingscreen.list;
        RaceData.setRace(((EntityDataSaver) player),list.get(num).value().name());
        player.sendMessage(Text.literal("race " + ((EntityDataSaver) player).getPersistentData().getString("race"))
                .fillStyle(Style.EMPTY.withColor(Formatting.BLUE)), true);
        Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(list.get(num).value().constitution());
    }
}
