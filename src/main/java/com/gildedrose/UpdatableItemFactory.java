package com.gildedrose;

final class UpdatableItemFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    static UpdatableItem basedOn(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASSES:
                return new BackstagePass(item);
            case SULFURAS:
                return new Sulfuras(item);
            default:
                return new StandardItem(item);
        }
    }
}
