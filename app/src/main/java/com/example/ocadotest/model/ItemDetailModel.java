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
