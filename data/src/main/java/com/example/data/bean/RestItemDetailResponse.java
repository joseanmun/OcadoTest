package com.example.data.bean;

import com.google.gson.annotations.SerializedName;

public class RestItemDetailResponse extends RestItem {

    @SerializedName("description")
    private String description;
    @SerializedName("allergyInformation")
    private String allergyInformation;

    public RestItemDetailResponse() {
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
