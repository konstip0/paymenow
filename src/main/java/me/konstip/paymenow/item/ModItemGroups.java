package me.konstip.paymenow.item;

import me.konstip.paymenow.PayMeNow;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup PAYMENOW_ITEM_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(PayMeNow.MOD_ID, "paymenow_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.BANKNOTE_1_DOLLAR))
                    .displayName(Text.literal("PayMeNow")) // Use literal instead of translatable
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BANKNOTE_1_DOLLAR);
                        entries.add(ModItems.BANKNOTE_2_DOLLAR);
                        entries.add(ModItems.BANKNOTE_5_DOLLAR);
                        entries.add(ModItems.BANKNOTE_10_DOLLAR);
                        entries.add(ModItems.BANKNOTE_50_DOLLAR);
                        entries.add(ModItems.BANKNOTE_100_DOLLAR);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        PayMeNow.LOGGER.info("Registering Item Groups for " + PayMeNow.MOD_ID);
    }
}