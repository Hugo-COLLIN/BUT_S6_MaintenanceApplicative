package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items)
            updateItemQuality(item);
    }

    private static void updateItemQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                //Nothing
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                break;
            case "Conjured":
                if (item.quality > 0) {
                    item.quality = item.quality - 2;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 2;
                    }
                }
                if (item.quality < 0)
                    item.quality = 0;
                break;
            default:
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
                break;
        }
    }

}
