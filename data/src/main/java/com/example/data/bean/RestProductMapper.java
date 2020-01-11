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
