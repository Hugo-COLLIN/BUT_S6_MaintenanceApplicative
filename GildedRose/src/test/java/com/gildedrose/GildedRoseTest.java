package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
         CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                new String[] { "foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros" },
                new Integer[] { -1, 0, 20 },
                new Integer[] { 0, 49, 80 });
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }

}
