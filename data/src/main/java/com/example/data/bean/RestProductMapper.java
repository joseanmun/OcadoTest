/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.data.bean;

import com.example.domain.bean.ItemBO;
import com.example.domain.bean.ProductBO;

import java.util.ArrayList;
import java.util.List;

public class RestProductMapper {
    public RestProductMapper() {
    }

    public static ProductBO toBo(RestProduct restProduct) {
        ProductBO productBO = null;
        if (restProduct != null) {
            productBO = new ProductBO();
            productBO.setTag(restProduct.getTag());
            if (restProduct.getItems() != null) {
                List<ItemBO> itemBOList = new ArrayList<>();
                for (RestItem restItem : restProduct.getItems()) {
                    itemBOList.add(RestItemMapper.toBo(restItem));
                }
                productBO.setItems(itemBOList);
            }
        }
        return productBO;
    }
}
