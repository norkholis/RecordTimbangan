package com.example.norkholis.recordtimbangan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("username_user")
    @Expose
    private String usernameUser;
    @SerializedName("password_user")
    @Expose
    private String passwordUser;
    @SerializedName("nama_user")
    @Expose
    private String namaUser;
    @SerializedName("alamat_user")
    @Expose
    private String alamatUser;
    @SerializedName("telp_user")
    @Expose
    private String telpUser;
    @SerializedName("status_user")
    @Expose
    private String statusUser;
    @SerializedName("id_anc")
    @Expose
    private String idAnc;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getAlamatUser() {
        return alamatUser;
    }

    public void setAlamatUser(String alamatUser) {
        this.alamatUser = alamatUser;
    }

    public String getTelpUser() {
        return telpUser;
    }

    public void setTelpUser(String telpUser) {
        this.telpUser = telpUser;
    }

    public String getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(String statusUser) {
        this.statusUser = statusUser;
    }

    public String getIdAnc() {
        return idAnc;
    }

    public void setIdAnc(String idAnc) {
        this.idAnc = idAnc;
    }
}
