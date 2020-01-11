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
