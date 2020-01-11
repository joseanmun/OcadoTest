package com.example.ocadotest.model;

import com.example.domain.bean.ItemBO;
import com.example.domain.bean.ProductBO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductModelMapper {

    public ProductModelMapper() {
    }

    public static ProductModel toModel(ProductBO productBO) {
        ProductModel productModel = null;
        if (productBO != null) {
            productModel = new ProductModel();
            productModel.setTag(productBO.getTag());
            if (productBO.getItems() != null) {
                List<ItemModel> itemModelList = new ArrayList<>();
                for (ItemBO itemBO : productBO.getItems()) {
                    itemModelList.add(ItemModelMapper.toModel(itemBO));
                }
                productModel.setItems(itemModelList);
            }
        }
        return productModel;
    }

    public static List<ProductModel> toModel(Collection<ProductBO> productBOList) {
        List<ProductModel> productModelList = new ArrayList<>();
        if (productBOList != null) {
            for (ProductBO productBO : productBOList) {
                productModelList.add(ProductModelMapper.toModel(productBO));
            }
        }
        return productModelList;
    }
}
