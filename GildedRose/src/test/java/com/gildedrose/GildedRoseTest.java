package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
        Approvals.verify(doUpdateQuality("foo", 0, 0));
    }

    @Test
    void testBrie() {
        Approvals.verify(doUpdateQuality("Aged Brie", 0, 0));
    }

    private static String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }

}
