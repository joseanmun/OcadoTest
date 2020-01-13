/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/11/20 9:07 PM
 */

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
