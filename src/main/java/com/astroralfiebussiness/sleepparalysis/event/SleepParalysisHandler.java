package com.astroralfiebussiness.sleepparalysis.event;

import com.astroralfiebussiness.sleepparalysis.SleepParalysisMod;
import com.astroralfiebussiness.sleepparalysis.util.ParalysisData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = SleepParalysisMod.MOD_ID)
public class SleepParalysisHandler {
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onPlayerWakeUp(PlayerWakeUpEvent event) {
        Player player = event.getEntity();
        
        if (player.level().isClientSide) {
            return;
        }

        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }

        // Get or initialize paralysis data
        CompoundTag tag = serverPlayer.getPersistentData();
        int nightCount = tag.getInt("ParalysisNightCount");
        nightCount++;
        tag.putInt("ParalysisNightCount", nightCount);

        // Calculate paralysis duration: 5 seconds base + 1 second per night
        int durationTicks = (5 + (nightCount - 1)) * 20; // Convert seconds to ticks
        tag.putInt("ParalysisEndTick", serverPlayer.tickCount + durationTicks);
        tag.putBoolean("IsParalyzed", true);

        LOGGER.info("Player {} woken up paralyzed. Night #{}, Duration: {} ticks", 
            serverPlayer.getName().getString(), nightCount, durationTicks);
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
            CompoundTag tag = player.getPersistentData();
            
            if (!tag.getBoolean("IsParalyzed")) {
                continue;
            }

            int endTick = tag.getInt("ParalysisEndTick");
            
            if (player.tickCount >= endTick) {
                tag.putBoolean("IsParalyzed", false);
                LOGGER.info("Player {} paralysis ended", player.getName().getString());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerMovement(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START || event.player.level().isClientSide) {
            return;
        }

        Player player = event.player;
        CompoundTag tag = player.getPersistentData();

        if (tag.getBoolean("IsParalyzed")) {
            // Block all movement
            player.setDeltaMovement(0, player.getDeltaMovement().y, 0);
            player.input.getMoveVector().mul(0, 0, 0);
        }
    }
}
