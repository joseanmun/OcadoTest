package com.example.data.bean;

import com.example.domain.bean.ItemBO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestProduct {

    @SerializedName("tag")
    private String tag;
    @SerializedName("items")
    private List<RestItem> items;

    public RestProduct() {
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<RestItem> getItems() {
        return items;
    }

    public void setItems(List<RestItem> items) {
        this.items = items;
    }
}
