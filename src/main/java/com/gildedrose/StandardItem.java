package com.gildedrose;

public class StandardItem extends UpdatableItem {
    private static final int DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD = 0;

    StandardItem(Item item) {
        super(item);
    }

    @Override
    void update() {
        decreaseSellIn();
        decreaseQuality();

        if (item.sellIn < DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD) {
            decreaseQuality();
        }
    }
}
