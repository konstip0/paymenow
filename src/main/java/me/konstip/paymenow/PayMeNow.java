package me.konstip.paymenow;

import me.konstip.paymenow.item.ModItemGroups;
import me.konstip.paymenow.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayMeNow implements ModInitializer {
	public static final String MOD_ID = "paymenow";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerItems();
        ModItemGroups.registerItemGroups();
	}
}