package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
//        Approvals.verify(doUpdateQuality("foo", 0, 0));
         CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                new String[] { "foo", "Aged Brie" },
                new Integer[] { 0, 5 },
                new Integer[] { 0 });
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }

}
