package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() throws Exception {
        Item item = testItem("any_item", 0, 10);

        assertEquals(-1, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    public void the_quality_of_an_item_is_never_negative() throws Exception {
        Item item = testItem("any_item", 0, 1);

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    public void aged_brie_actually_increases_in_quality_the_older_it_gets() throws Exception {
        Item item = testItem("Aged Brie", 10, 12);

        assertEquals(9, item.sellIn);
        assertEquals(13, item.quality);
    }

    @Test
    public void the_quality_of_an_item_is_never_more_than_50() throws Exception {
        Item item = testItem("Aged Brie", 10, 50);

        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void sulfuras_being_a_legendary_item_never_has_to_be_sold_or_decreases_in_quality() throws Exception {
        Item item = testItem("Sulfuras, Hand of Ragnaros", 10, 50);

        assertEquals(10, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void backstage_passes_increases_in_quality_as_its_sellIn_value_approaches() throws Exception {
        Item item = testItem("Backstage passes to a TAFKAL80ETC concert", 20, 10);

        assertEquals(19, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    public void backstage_quality_increases_by_2_when_there_are_10_days_or_less() throws Exception {
        Item item = testItem("Backstage passes to a TAFKAL80ETC concert", 10, 10);

        assertEquals(9, item.sellIn);
        assertEquals(12, item.quality);
    }

    @Test
    public void backstage_quality_increases_by_3_when_there_are_5_days_or_less() throws Exception {
        Item item = testItem("Backstage passes to a TAFKAL80ETC concert", 5, 10);

        assertEquals(4, item.sellIn);
        assertEquals(13, item.quality);
    }

    @Test
    public void backstage_quality_drops_to_0_after_concert() throws Exception {
        Item item = testItem("Backstage passes to a TAFKAL80ETC concert", 0, 10);

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    private Item testItem(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0];
    }

}
