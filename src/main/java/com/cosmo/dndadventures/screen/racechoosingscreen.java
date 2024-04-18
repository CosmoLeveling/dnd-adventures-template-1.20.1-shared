package com.cosmo.dndadventures.screen;

import com.cosmo.dndadventures.networking.ModMessages;
import com.cosmo.dndadventures.races.Races;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.cosmo.dndadventures.ModRegisteryKeys.RACES_KEY;


public class racechoosingscreen extends Screen {

    public static int num = 0;
    public static List<RegistryEntry.Reference<Races>> list = Objects.requireNonNull(MinecraftClient.getInstance().getNetworkHandler()).getRegistryManager().getOptional(RACES_KEY).map((registry) -> registry.streamEntries().collect(Collectors.toList())).orElse(List.of());

    public ButtonWidget selectbutton;
    public ButtonWidget nextbutton;
    protected void init() {
        selectbutton = ButtonWidget.builder(Text.literal("select"), button -> {
                    System.out.println("You clicked button1!");
                    ClientPlayNetworking.send(ModMessages.SETTING_ID, PacketByteBufs.create());
                    this.close();
                })
                .dimensions(width / 2 - 205, 20, 40, 20)
                .tooltip(Tooltip.of(Text.literal("Tooltip of button1")))
                .build();
        addDrawableChild(selectbutton);
        nextbutton = ButtonWidget.builder(Text.literal("next"), button -> {
                    System.out.println(num);
                    System.out.println(list.get(num).value().toString());
                    System.out.println(list.size());
            if(num<list.size()-1){
                        num+=1;
                    }else{
                        num=0;
                    }
                    System.out.println(num);
                    System.out.println(list.get(num).value().toString());
                    System.out.println(list.get(num).value().name());
        })

                .dimensions(width / 2 - 205, 40, 40, 20)
                .tooltip(Tooltip.of(Text.literal("Tooltip of button1")))
                .build();
        addDrawableChild(nextbutton);
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Render the background texture
        renderBackgroundTexture(context);
        context.drawTextWithShadow(textRenderer, Text.literal("race: "+ list.get(num).value().name()), 40,80, 0xffffff);
        context.drawTextWithShadow(textRenderer, Text.literal("speed"), 40,100,0xffffff);
        // Call the super method to render other screen elements
        super.render(context, mouseX, mouseY, delta);
    }
    public void renderBackgroundTexture(DrawContext context) {
        context.setShaderColor(0.25f,0.25f,0.25f,1.0f);
        context.drawTexture(OPTIONS_BACKGROUND_TEXTURE,0,0,0,0.0f,this.width,this.height,32,32);
        context.setShaderColor(1.0f,1.0f,1.0f,1.0f);
    }
    public racechoosingscreen(Text title) {
        super(title);
    }
}
