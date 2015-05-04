package com.gildedrose.strategies;

import com.gildedrose.Item;

public class ConjuredStrategy extends AbstractStrategy {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        decreaseQuality(item);
        decreaseQuality(item);
    }

}
