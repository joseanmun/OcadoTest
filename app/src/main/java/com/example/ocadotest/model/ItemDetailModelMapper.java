/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.ocadotest.model;

import com.example.domain.bean.ItemDetailBO;

public class ItemDetailModelMapper {

    public ItemDetailModelMapper() {
    }

    public static ItemDetailModel toModel(ItemDetailBO item) {
        ItemDetailModel itemDetailModel = null;
        if (item != null) {
            itemDetailModel = new ItemDetailModel();
            itemDetailModel.setId(item.getId());
            itemDetailModel.setImageUrl(item.getImageUrl());
            itemDetailModel.setPrice(item.getPrice());
            itemDetailModel.setSize(item.getSize());
            itemDetailModel.setTitle(item.getTitle());
            itemDetailModel.setDescription(item.getDescription());
            itemDetailModel.setAllergyInformation(item.getAllergyInformation());
        }
        return itemDetailModel;
    }
}
