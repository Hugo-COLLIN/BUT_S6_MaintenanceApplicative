package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
//        assertEquals("foo", app.items[0].name);
//        assertEquals(-1, app.items[0].sellIn);
//        assertEquals(0, app.items[0].quality);
//        assertEquals("foo, -1, 0", app.items[0].toString());
        Approvals.verify(app.items[0]);
    }

}
