package zz.autorespawn.mixin.client;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ExampleClientMixin {
	@Inject(at = @At("HEAD"), method = "run")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftClient.run()V
	}

	@Inject(at = @At("HEAD"), method = "tick()V")
    private void onTick(CallbackInfo info) {
        // Access the MinecraftClient instance
        MinecraftClient client = (MinecraftClient) (Object) this;

        // Check if inGameHud is available
        if (client.inGameHud != null) {
            // Log the title if it's set
            String title = client.inGameHud.toString();
            System.out.println("Current HUD Title: " + title);
        }

    }
}