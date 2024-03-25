package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    private Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
}

    public static Item createItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }
}
