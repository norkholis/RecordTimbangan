package com.example.norkholis.recordtimbangan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataTimbanganModel {
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("berat_badan")
    @Expose
    private String beratBadan;
    @SerializedName("lemak_tubuh")
    @Expose
    private String lemakTubuh;
    @SerializedName("kadar_air")
    @Expose
    private String kadarAir;
    @SerializedName("masa_otot")
    @Expose
    private String masaOtot;
    @SerializedName("rating_fisik")
    @Expose
    private String ratingFisik;
    @SerializedName("usia_sel")
    @Expose
    private String usiaSel;
    @SerializedName("kepadatan_tulang")
    @Expose
    private String kepadatanTulang;
    @SerializedName("lemak_perut")
    @Expose
    private String lemakPerut;
    @SerializedName("bmr")
    @Expose
    private String bmr;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(String beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getLemakTubuh() {
        return lemakTubuh;
    }

    public void setLemakTubuh(String lemakTubuh) {
        this.lemakTubuh = lemakTubuh;
    }

    public String getKadarAir() {
        return kadarAir;
    }

    public void setKadarAir(String kadarAir) {
        this.kadarAir = kadarAir;
    }

    public String getMasaOtot() {
        return masaOtot;
    }

    public void setMasaOtot(String masaOtot) {
        this.masaOtot = masaOtot;
    }

    public String getRatingFisik() {
        return ratingFisik;
    }

    public void setRatingFisik(String ratingFisik) {
        this.ratingFisik = ratingFisik;
    }

    public String getUsiaSel() {
        return usiaSel;
    }

    public void setUsiaSel(String usiaSel) {
        this.usiaSel = usiaSel;
    }

    public String getKepadatanTulang() {
        return kepadatanTulang;
    }

    public void setKepadatanTulang(String kepadatanTulang) {
        this.kepadatanTulang = kepadatanTulang;
    }

    public String getLemakPerut() {
        return lemakPerut;
    }

    public void setLemakPerut(String lemakPerut) {
        this.lemakPerut = lemakPerut;
    }

    public String getBmr() {
        return bmr;
    }

    public void setBmr(String bmr) {
        this.bmr = bmr;
    }
}
