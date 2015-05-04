package com.gildedrose.strategies;

import com.gildedrose.Item;

public class StrategyFactory {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";

    public AbstractStrategy createFor(Item item) {
        AbstractStrategy strategy = new NullStrategy();

        if (isAgedBrie(item)) {
            strategy = new AgedBrieStrategy();
        } else if (isBackstagePasses(item)) {
            strategy = new BackstageStrategy();
        } else if (!isSulfuras(item)) {
            strategy = new OtherStrategy();
        }

        return strategy;
    }

    private boolean isSulfuras(Item item) {
        return is(SULFURAS, item);
    }

    private boolean isBackstagePasses(Item item) {
        return is(BACKSTAGE_PASSES, item);
    }

    private boolean isAgedBrie(Item item) {
        return is(AGED_BRIE, item);
    }

    private boolean is(String agedBrie, Item item) {
        return item.name.equals(agedBrie);
    }

}
