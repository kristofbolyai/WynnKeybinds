package com.bolyai.wynnkeybinds;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Keybinds {
    public static KeyBinding GuildMenuKeyBind;

    public static void registerKeybinds() {
        GuildMenuKeyBind = new KeyBinding("Open Guild Menu", Keyboard.KEY_G, "Wynncraft");
        ClientRegistry.registerKeyBinding(GuildMenuKeyBind);
    }
}
