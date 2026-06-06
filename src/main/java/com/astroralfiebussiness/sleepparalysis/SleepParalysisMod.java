package com.astroralfiebussiness.sleepparalysis;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafxmod.ModLoadingContext;
import net.minecraftforge.fml.javafxmod.FMLModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("sleepparalysis")
public class SleepParalysisMod {
    public static final String MOD_ID = "sleepparalysis";
    private static final Logger LOGGER = LogManager.getLogger();

    public SleepParalysisMod() {
        IEventBus modEventBus = FMLModLoadingContext.getInstance().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Sleep Paralysis mod loaded. Sweet dreams...");
    }

    private void clientSetup(FMLClientSetupEvent event) {
        LOGGER.info("Sleep Paralysis client setup complete.");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {
    }
}
