package com.example.clothesstore;

import com.google.gson.annotations.SerializedName;

public class RetrofitCore {
    private String productId;
    private String name;
    private String category;
    private double price;
    private double oldPrice;
    private int stock;

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }


    public String getCategory() {
        return category;
    }


    public double getPrice() {
        return price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public int getStock() {
        return stock;
    }


}
