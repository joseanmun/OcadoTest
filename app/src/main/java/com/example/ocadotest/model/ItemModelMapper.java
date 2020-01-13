/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.ocadotest.model;

import com.example.domain.bean.ItemBO;

public class ItemModelMapper {

    public ItemModelMapper() {
    }

    public static ItemModel toModel(ItemBO item) {
        ItemModel itemModel = null;
        if (item != null) {
            itemModel = new ItemModel();
            itemModel.setId(item.getId());
            itemModel.setImageUrl(item.getImageUrl());
            itemModel.setPrice(item.getPrice());
            itemModel.setSize(item.getSize());
            itemModel.setTitle(item.getTitle());
        }
        return itemModel;
    }
}
