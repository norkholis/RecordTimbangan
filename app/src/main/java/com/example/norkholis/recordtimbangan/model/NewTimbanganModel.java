package com.example.norkholis.recordtimbangan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewTimbanganModel {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private DataTimbanganModel data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public DataTimbanganModel getData() {
        return data;
    }

    public void setData(DataTimbanganModel data) {
        this.data = data;
    }
}
