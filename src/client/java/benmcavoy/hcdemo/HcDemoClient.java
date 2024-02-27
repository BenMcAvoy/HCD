package benmcavoy.hcdemo;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class HcDemoClient implements ClientModInitializer {
    private static KeyBinding MenuKeybinding;

    Exploit[] exploits = new Exploit[10];

    @Override
    public void onInitializeClient() {
        exploits[0] = new benmcavoy.hcdemo.exploits.Flight();

        MenuKeybinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Open menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "HC Demo"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (MenuKeybinding.wasPressed()) {
                exploits[0].Toggle();
            }
        });
    }
}