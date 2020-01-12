package com.example.domain.bean;

public class ItemDetailBO extends ItemBO {
    private String description;

    private String allergyInformation;

    public ItemDetailBO() {
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
