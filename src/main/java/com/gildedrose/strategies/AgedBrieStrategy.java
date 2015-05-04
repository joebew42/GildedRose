package com.gildedrose.strategies;

import com.gildedrose.Item;

public class AgedBrieStrategy extends AbstractStrategy {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        increaseQuality(item);
    }

}
