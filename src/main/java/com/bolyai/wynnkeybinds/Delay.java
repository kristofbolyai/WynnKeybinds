package com.bolyai.wynnkeybinds;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Delay {

    private final Runnable function;
    private int delay;
    private boolean isRunning = true;
    private boolean onPause = false;

    public Delay(Runnable function, int delay) {
        this.function = function;
        this.delay = delay;

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e) {
        if (e.phase == TickEvent.Phase.END && !onPause && isRunning) {
            if (delay < 0) {
                start();
            }
            delay--;
        }
    }

    public boolean isRunning() {
        return isRunning && !onPause;
    }

    public boolean pause() {
        if (!onPause && isRunning) {
            onPause = true;
            return true;  // success
        }

        return false;
    }

    public boolean resume() {
        if (onPause && isRunning) {
            onPause = false;
            return true;  // success
        }

        return false;
    }

    public void start() {
        isRunning = false;
        function.run();
        end();
    }

    public void end() {
        isRunning = false;
        MinecraftForge.EVENT_BUS.unregister(this);
    }
}
