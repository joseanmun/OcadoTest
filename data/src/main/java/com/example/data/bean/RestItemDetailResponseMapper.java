/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.data.bean;

import com.example.domain.bean.ItemDetailBO;

public class RestItemDetailResponseMapper {
    public RestItemDetailResponseMapper() {
    }

    public static ItemDetailBO toBo(RestItemDetailResponse itemDetailResponse) {
        ItemDetailBO itemDetailBO = null;
        if (itemDetailResponse != null) {
            itemDetailBO = new ItemDetailBO();
            itemDetailBO.setId(itemDetailResponse.getId());
            itemDetailBO.setImageUrl(itemDetailResponse.getImageUrl());
            itemDetailBO.setPrice(itemDetailResponse.getPrice());
            itemDetailBO.setTitle(itemDetailResponse.getTitle());
            itemDetailBO.setDescription(itemDetailResponse.getDescription());
            itemDetailBO.setAllergyInformation(itemDetailResponse.getAllergyInformation());

        }
        return itemDetailBO;
    }
}
