package me.konstip.paymenow.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class BanknoteItem extends Item {
    private final int value; // Dollar value of this banknote

    public BanknoteItem(Settings settings, int value) {
        super(settings);
        this.value = value;
    }

    @Override
    public Text getName(ItemStack stack) {
        int count = stack.getCount();
        int totalValue = count * value;

        if (count == 1) {
            return Text.literal(value + "$" + " ")
                    .formatted(Formatting.GREEN)
                    .copy()
                    .append(Text.literal("(" + "1" + "x " + value + "$ Banknotes)")
                            .formatted(Formatting.GRAY, Formatting.ITALIC));
        } else {
            return Text.literal(totalValue + "$" + " ")
                    .formatted(Formatting.GREEN)
                    .copy()
                    .append(Text.literal("(" + count + "x " + value + "$ Banknotes)")
                            .formatted(Formatting.GRAY, Formatting.ITALIC));
        }
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        int count = stack.getCount();
        int totalValue = count * value;

        tooltip.add(Text.literal("Value: $" + value + " each").formatted(Formatting.GRAY));
        if (count > 1) {
            tooltip.add(Text.literal("Total: $" + totalValue).formatted(Formatting.GOLD));
        }
    }
}