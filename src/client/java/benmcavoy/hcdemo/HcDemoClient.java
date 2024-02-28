package benmcavoy.hcdemo;

import benmcavoy.hcdemo.abstracts.Exploit;
import benmcavoy.hcdemo.abstracts.ExploitState;
import benmcavoy.hcdemo.exploits.NoFall;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.lwjgl.glfw.GLFW;

import benmcavoy.hcdemo.exploits.Flight;
import benmcavoy.hcdemo.gui.ExploitGUI;

import java.util.ArrayList;
import java.util.List;

public class HcDemoClient implements ClientModInitializer {
    private static KeyBinding MenuKeybinding;
    List<Exploit> exploits = new ArrayList<>();

    Screen screen = new ExploitGUI();

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
                client.setScreen(screen);

                for (Exploit exploit : exploits) {
                    exploit.Toggle();
                }
            }
        });
    }
}