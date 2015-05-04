package com.gildedrose.strategies;

import com.gildedrose.Item;

public class OtherStrategy extends AbstractStrategy {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        decreaseQuality(item);

        if (isExpired(item)) {
            decreaseQuality(item);
        }
    }

}
