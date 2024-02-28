package benmcavoy.hcdemo.gui;

import net.minecraft.client.gui.widget.CheckboxWidget;

public abstract class ModWidget {
    public CheckboxWidget enabledWidget;
    public String name;

    ModWidget(String name) {
        this.name = name;
    }
}