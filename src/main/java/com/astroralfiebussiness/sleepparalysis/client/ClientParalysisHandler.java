package com.astroralfiebussiness.sleepparalysis.client;

import com.astroralfiebussiness.sleepparalysis.SleepParalysisMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber(modid = SleepParalysisMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientParalysisHandler {
    private static float distortionAmount = 0f;
    private static RandomSource random = RandomSource.create();

    @SubscribeEvent
    public static void onScreenRender(ScreenEvent.Init.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        
        if (minecraft.player == null) {
            return;
        }

        CompoundTag tag = minecraft.player.getPersistentData();
        
        if (tag.getBoolean("IsParalyzed")) {
            // Play distorted cave sounds
            playDistortedCaveSounds(minecraft);
        }
    }

    private static void playDistortedCaveSounds(Minecraft minecraft) {
        if (minecraft.getSoundManager() != null && random.nextInt(10) == 0) {
            // Play cave ambience with distortion effect
            // This will be enhanced with actual sound playing
        }
    }
}
