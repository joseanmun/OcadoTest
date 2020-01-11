package com.example.data.bean;

import com.google.gson.annotations.SerializedName;

public class RestItem {
    @SerializedName("id")
    private int id;
    @SerializedName("price")
    private String price;
    @SerializedName("title")
    private String title;
    @SerializedName("size")
    private int size;
    @SerializedName("imageUrl")
    private String imageUrl;

    public RestItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
