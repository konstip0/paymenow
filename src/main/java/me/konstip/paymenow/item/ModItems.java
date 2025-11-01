package me.konstip.paymenow.item;

import me.konstip.paymenow.PayMeNow;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item BANKNOTE_1_DOLLAR;
    public static Item BANKNOTE_2_DOLLAR;
    public static Item BANKNOTE_5_DOLLAR;
    public static Item BANKNOTE_10_DOLLAR;
    public static Item BANKNOTE_50_DOLLAR;
    public static Item BANKNOTE_100_DOLLAR;

    private static Item registerItem(String name) {
        // Create the identifier and registry key
        Identifier id = Identifier.of(PayMeNow.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        // Create settings with the registry key BEFORE creating the item
        Item.Settings settings = new Item.Settings()
                .registryKey(key)
                .maxCount(64);

        // Create and register the item
        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    private static Item registerBanknote(String name, int value) {
        Identifier id = Identifier.of(PayMeNow.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        Item.Settings settings = new Item.Settings()
                .registryKey(key)
                .maxCount(64); // Reasonable stack size for easy counting

        return Registry.register(Registries.ITEM, key, new BanknoteItem(settings, value));
    }

    public static void registerItems() {
        // Register items
        BANKNOTE_1_DOLLAR = registerBanknote("banknote_1", 1);
        BANKNOTE_2_DOLLAR = registerBanknote("banknote_2", 2);
        BANKNOTE_5_DOLLAR = registerBanknote("banknote_5", 5);
        BANKNOTE_10_DOLLAR = registerBanknote("banknote_10", 10);
        BANKNOTE_50_DOLLAR = registerBanknote("banknote_50", 50);
        BANKNOTE_100_DOLLAR = registerBanknote("banknote_100", 100);

        PayMeNow.LOGGER.info("Items registered successfully");
    }
}