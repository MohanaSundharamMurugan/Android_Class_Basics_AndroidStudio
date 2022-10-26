package com.example.sample;

public class ItemModel
{
    private String item_name;
    private int item_image;

    public ItemModel(String item_name, int item_image) {
        this.item_name = item_name;
        this.item_image = item_image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}
