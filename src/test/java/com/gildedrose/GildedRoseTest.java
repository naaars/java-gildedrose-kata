package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item[] arrayWith(Item item) {
        return new Item[]{item};
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item randomItem = new Item("random", 10, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(randomItem));
        gildedRose.updateQuality();

        assertEquals(randomItem.sellIn, 9);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item randomItem = new Item("random", 1, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(randomItem));
        gildedRose.updateQuality();

        assertEquals(randomItem.quality, 9);
    }

    @Test
    public void testThatQualityDecreasesDoubleWhenSellByIsPassed() {
        Item randomItem = new Item("random", 0, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(randomItem));
        gildedRose.updateQuality();

        assertEquals(randomItem.quality, 8);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item randomItem = new Item("random", 0, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(randomItem));
        gildedRose.updateQuality();

        assertEquals(randomItem.quality, 0);
    }

    @Test
    public void testThatAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = new Item("Aged Brie", 5, 4);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 5);
    }

    @Test
    public void testThatQualityOfAnItemIsNeverOverFifty() {
        Item agedBrie = new Item("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose(arrayWith(sulfuras));
        gildedRose.updateQuality();

        assertEquals(sulfuras.quality, 25);
        assertEquals(sulfuras.sellIn, 0);
    }

    @Test
    public void testThatBackstagePassesIncreaseQualityWhenSellInMoreThanTen() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePass));
        gildedRose.updateQuality();

        assertEquals(backstagePass.quality, 11);
        assertEquals(backstagePass.sellIn, 10);
    }

    @Test
    public void testThatBackstagePassesIncreaseQualityByTwoWhenSellInIsLessOrEqualThanTen() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePass));
        gildedRose.updateQuality();

        assertEquals(backstagePass.quality, 12);
        assertEquals(backstagePass.sellIn, 9);
    }

    @Test
    public void testThatBackstagePassesIncreaseQualityByThreeWhenSellInIsLessOrEqualThanFive() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePass));
        gildedRose.updateQuality();

        assertEquals(backstagePass.quality, 13);
        assertEquals(backstagePass.sellIn, 4);
    }

    @Test
    public void testThatBackstagePassesDropsQualityToZeroWhenSellByPassed() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePass));
        gildedRose.updateQuality();

        assertEquals(backstagePass.quality, 0);
    }
}
