package com.example.domain.bean;

import java.util.List;

public class ProductBO {

    private String tag;

    private List<ItemBO> items;

    public ProductBO() {
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<ItemBO> getItems() {
        return items;
    }

    public void setItems(List<ItemBO> items) {
        this.items = items;
    }
}
