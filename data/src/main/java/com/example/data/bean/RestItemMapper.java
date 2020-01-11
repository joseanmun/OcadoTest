package com.example.data.bean;

import com.example.domain.bean.ItemBO;

public class RestItemMapper {

    public RestItemMapper() {
    }

    public static ItemBO toBo(RestItem restItem) {
        ItemBO itemBO = null;
        if (restItem != null) {
            itemBO.setId(restItem.getId());
            itemBO.setImageUrl(restItem.getImageUrl());
            itemBO.setPrice(restItem.getPrice());
            itemBO.setSize(restItem.getSize());
            itemBO.setTitle(restItem.getTitle());
        }
        return itemBO;
    }
}
