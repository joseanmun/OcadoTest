/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.data.bean;

import com.example.domain.bean.ProductBO;

import java.util.ArrayList;
import java.util.List;

public class RestProductsResponseMapper {

    public RestProductsResponseMapper() {
    }

    public static List<ProductBO> toBo(RestProductsResponse response) {
        List<ProductBO> list = new ArrayList<>();
        if (response != null && response.getProducts() != null) {
            for (RestProduct restProduct : response.getProducts()) {
                list.add(RestProductMapper.toBo(restProduct));
            }
        }
        return list;
    }
}
