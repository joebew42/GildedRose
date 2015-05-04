package com.gildedrose;

import com.gildedrose.strategies.AbstractStrategy;
import com.gildedrose.strategies.StrategyFactory;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            update(item);
        }
    }

    private void update(Item item) {
        StrategyFactory factory = new StrategyFactory();
        AbstractStrategy strategy = factory.createFor(item);

        strategy.update(item);
    }
}
