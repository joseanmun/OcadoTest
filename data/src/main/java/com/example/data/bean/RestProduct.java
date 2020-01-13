/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.data.bean;

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
