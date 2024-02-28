package benmcavoy.hcdemo.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import benmcavoy.hcdemo.BuildProperties;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {
    @Inject(at = @At("RETURN"), method = "render")
    public void render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

        // Get version from gradle file using the Gradle API
        String text = "HCDemo v" + BuildProperties.getVersion();

        int width = textRenderer.getWidth(text);
        context.drawCenteredTextWithShadow(textRenderer, Text.of(text), 8 + (width / 2), 8, 0xffffff);
    }
}
