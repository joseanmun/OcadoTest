package com.example.ocadotest.model;

import com.example.domain.bean.ItemBO;

import java.util.List;

public class ProductModel {

    private String tag;

    private List<ItemModel> items;

    public ProductModel() {
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}
