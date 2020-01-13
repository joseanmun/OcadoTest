/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.data.bean;

import com.example.domain.bean.ItemBO;

public class RestItemMapper {

    public RestItemMapper() {
    }

    public static ItemBO toBo(RestItem restItem) {
        ItemBO itemBO = null;
        if (restItem != null) {
            itemBO = new ItemBO();
            itemBO.setId(restItem.getId());
            itemBO.setImageUrl(restItem.getImageUrl());
            itemBO.setPrice(restItem.getPrice());
            itemBO.setSize(restItem.getSize());
            itemBO.setTitle(restItem.getTitle());
        }
        return itemBO;
    }
}
