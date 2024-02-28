package benmcavoy.hcdemo;

import benmcavoy.hcdemo.exploits.NoFall;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import benmcavoy.hcdemo.exploits.Flight;

import java.util.ArrayList;
import java.util.List;

public class HcDemoClient implements ClientModInitializer {
    private static KeyBinding MenuKeybinding;
    List<Exploit> exploits = new ArrayList<>();

    @Override
    public void onInitializeClient() {
        exploits.add(new Flight());
        exploits.add(new NoFall());

        MenuKeybinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Open menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "HC Demo"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for (Exploit exploit : exploits) {
                if (exploit.state == ExploitState.ON) {
                    exploit.OnTick();
                }
            }

            while (MenuKeybinding.wasPressed()) {
                for (Exploit exploit : exploits) {
                    exploit.Toggle();
                }
            }
        });
    }
}