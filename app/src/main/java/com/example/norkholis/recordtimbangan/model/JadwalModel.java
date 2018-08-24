package com.example.norkholis.recordtimbangan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JadwalModel {
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("id_user")
    @Expose
    private String idUser;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
