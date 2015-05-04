package com.gildedrose.strategies;

import com.gildedrose.Item;

public abstract class AbstractStrategy {

    public abstract void update(Item item);

    protected void dropQuality(Item item) {
        item.quality = 0;
    }

    protected void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

}