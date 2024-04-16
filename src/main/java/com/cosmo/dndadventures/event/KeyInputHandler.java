package com.cosmo.dndadventures.event;

import com.cosmo.dndadventures.networking.ModMessages;
import com.cosmo.dndadventures.screen.racechoosingscreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;


public class KeyInputHandler {
    public static final String KEY_CATAGORY_DND = "key.category.dndadventure.dnd";
    public static final String KEY_SET_VALUE = "key.dndadventures.set_value";
    public static final String KEY_RESET_VALUE = "key.dndadventures.reset_value";
    public static KeyBinding setvaluekey;
    public static KeyBinding resetvaluekey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (setvaluekey.wasPressed()) {
                ClientPlayNetworking.send(ModMessages.SETTING_ID, PacketByteBufs.create());
            }
            if (resetvaluekey.wasPressed()) {
                racechoosingscreen.num = 0;
                client.setScreen(new racechoosingscreen(Text.literal("test")));
                ClientPlayNetworking.send(ModMessages.RESETING_ID, PacketByteBufs.create());
            }
        });
    }

    public static void register() {
        setvaluekey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
           KEY_SET_VALUE,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEY_CATAGORY_DND
        ));
        resetvaluekey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_RESET_VALUE,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                KEY_CATAGORY_DND
        ));
        registerKeyInputs();
    }
}
