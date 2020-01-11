package com.example.ocadotest.model;

import com.example.data.bean.RestItem;
import com.example.data.bean.RestItemMapper;
import com.example.data.bean.RestProduct;
import com.example.domain.bean.ItemBO;
import com.example.domain.bean.ProductBO;

import java.util.ArrayList;
import java.util.List;

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
