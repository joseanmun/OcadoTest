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
