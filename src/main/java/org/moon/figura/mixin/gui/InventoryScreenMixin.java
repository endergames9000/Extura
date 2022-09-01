package org.moon.figura.mixin.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.world.entity.LivingEntity;
import org.moon.figura.utils.ui.UIHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public class InventoryScreenMixin {

    @Inject(method = "renderEntityInInventory", at = @At("HEAD"), cancellable = true)
    private static void renderEntityInInventory(int x, int y, int size, float mouseX, float mouseY, LivingEntity entity, CallbackInfo ci) {
        UIHelper.drawEntity(x, y, size, mouseX, mouseY, entity, RenderSystem.getModelViewStack(), UIHelper.EntityRenderMode.HUD);
        ci.cancel();
    }
}
