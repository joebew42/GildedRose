package com.gildedrose.strategies;

import com.gildedrose.Item;

public class BackstageStrategy extends AbstractStrategy {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        increaseQuality(item);

        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }

        if (isExpired(item)) {
            dropQuality(item);
        }
    }

}
