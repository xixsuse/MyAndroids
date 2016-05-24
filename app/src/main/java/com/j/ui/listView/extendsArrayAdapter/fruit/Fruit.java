package com.j.ui.listView.extendsArrayAdapter.fruit;

/**
 * Created by Administrator on 2015/9/9.
 */
public class Fruit {
    private String name;
    private int imageId;
    private double price;

    public Fruit(String name, int imageId, double price) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
