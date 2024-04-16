package com.cosmo.dndadventures.screen;

import com.cosmo.dndadventures.networking.ModMessages;
import com.cosmo.dndadventures.races.Races;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import javax.print.DocFlavor;
import java.util.ArrayList;


public class racechoosingscreen extends Screen {


    public static int num = 0;

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
                    if(num==0){
                        num+=1;
                    }else{
                        num=0;
                    }
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
        context.drawTextWithShadow(textRenderer, Text.literal("race: "), 40,80, 0xffffff);
        context.drawTextWithShadow(textRenderer, Text.literal("speed"), 40,100,0xffffff);
        // Call the super method to render other screen elements
        super.render(context, mouseX, mouseY, delta);
    }
    public void renderBackgroundTexture(DrawContext context) {
        context.setShaderColor(0.25f,0.25f,0.25f,1.0f);
        int i = 32;
        context.drawTexture(OPTIONS_BACKGROUND_TEXTURE,0,0,0,0.0f,this.width,this.height,32,32);
        context.setShaderColor(1.0f,1.0f,1.0f,1.0f);
    }
    public racechoosingscreen(Text title) {
        super(title);
    }
}
