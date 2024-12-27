package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private List<UpdatableItem> listOf(UpdatableItem item) {
        return new ArrayList<UpdatableItem>(){{
            add(item);
        }};
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item randomItem = new Item("random", 10, 0);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(randomItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(randomItem.sellIn, 9);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item randomItem = new Item("random", 1, 10);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(randomItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(randomItem.quality, 9);
    }

    @Test
    public void testThatQualityDecreasesDoubleWhenSellByIsPassed() {
        Item randomItem = new Item("random", 0, 10);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(randomItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(randomItem.quality, 8);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item randomItem = new Item("random", 0, 0);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(randomItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(randomItem.quality, 0);
    }

    @Test
    public void testThatAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = new Item("Aged Brie", 5, 4);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(agedBrie);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(agedBrie.quality, 5);
    }

    @Test
    public void testThatQualityOfAnItemIsNeverOverFifty() {
        Item agedBrie = new Item("Aged Brie", 5, 50);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(agedBrie);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 25);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(sulfuras);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(sulfuras.quality, 25);
        assertEquals(sulfuras.sellIn, 0);
    }

    @Test
    public void testThatBackstagePassesIncreaseQualityWhenSellInMoreThanTen() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(backstagePass);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(backstagePass.quality, 11);
        assertEquals(backstagePass.sellIn, 10);
    }

    @Test
    public void testThatBackstagePassesIncreaseQualityByTwoWhenSellInIsLessOrEqualThanTen() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(backstagePass);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(backstagePass.quality, 12);
        assertEquals(backstagePass.sellIn, 9);
    }

    @Test
    public void testThatBackstagePassesIncreaseQualityByThreeWhenSellInIsLessOrEqualThanFive() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(backstagePass);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(backstagePass.quality, 13);
        assertEquals(backstagePass.sellIn, 4);
    }

    @Test
    public void testThatBackstagePassesDropsQualityToZeroWhenSellByPassed() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(backstagePass);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(backstagePass.quality, 0);
    }
}
