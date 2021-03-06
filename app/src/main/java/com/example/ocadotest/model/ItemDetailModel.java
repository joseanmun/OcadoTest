/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.ocadotest.model;

public class ItemDetailModel extends ItemModel {
    private String description;

    private String allergyInformation;


    public ItemDetailModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAllergyInformation() {
        return allergyInformation;
    }

    public void setAllergyInformation(String allergyInformation) {
        this.allergyInformation = allergyInformation;
    }
}
