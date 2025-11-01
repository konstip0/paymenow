package me.konstip.paymenow;

import net.fabricmc.api.ClientModInitializer;

public class PayMeNowClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PayMeNow.LOGGER.info("Client initializing — item models should load now");
    }
}
