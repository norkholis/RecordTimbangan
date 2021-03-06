package com.example.norkholis.recordtimbangan.api;

import com.example.norkholis.recordtimbangan.model.DataTimbanganModel;
import com.example.norkholis.recordtimbangan.model.JadwalModel;
import com.example.norkholis.recordtimbangan.model.LoginModel;
import com.example.norkholis.recordtimbangan.model.NewTimbanganModel;
import com.example.norkholis.recordtimbangan.model.RegisterModel;
import com.example.norkholis.recordtimbangan.model.ResponseDetailTimbangan;
import com.example.norkholis.recordtimbangan.model.ResponseHapusTimbangan;
import com.example.norkholis.recordtimbangan.model.ResponseUpdateProfile;
import com.example.norkholis.recordtimbangan.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APICall {
    //Register User
    @FormUrlEncoded
    @POST("user/new")
    Call<RegisterModel> registerRequest(@Field("id_user")String id_user,
                                        @Field("nama_user")String nama_user,
                                        @Field("username_user")String username_user,
                                        @Field("password_user")String password_username,
                                        @Field("alamat_user")String alamat_user,
                                        @Field("telp_user")String telp_user,
                                        @Field("status_user")String status_user,
                                        @Field("id_anc")String id_anc);

    @FormUrlEncoded
    @POST("admin_nc/new")
    Call<RegisterModel>registerRequestNc(@Field("id_user")String id_user,
                                         @Field("nama_anc")String nama_anc,
                                         @Field("username_anc")String username_anc,
                                         @Field("password_anc")String password_anc,
                                         @Field("alamat_anc")String alamat_anc,
                                         @Field("telp_anc")String telp_anc,
                                         @Field("status_anc")String status_anc,
                                         @Field("id_sa")String id_sa);

    //Login User
    @FormUrlEncoded
    @POST("user/login")
    Call<LoginModel> loginRequest(@Field("username_user")String username_user,
                                  @Field("password_user")String password_user);

    //Get Data User
    @GET("user")
    Call<List<UserModel>>requestDataUser(@Query("id_user")int id_user);

    //Edit Data User
    @FormUrlEncoded
    @POST("user/update")
    Call<ResponseUpdateProfile>requestEditUser(@Field("id_user")int id_user,
                                               @Field("nama_user")String nama_user,
                                               @Field("username_user")String username_user,
                                               @Field("password_user")String password_user,
                                               @Field("alamat_user")String alamat_user,
                                               @Field("telp_user")String telp_user);

    //Add New Timbangan
    @FormUrlEncoded
    @POST("timbangan/new")
    Call<NewTimbanganModel>addTimbangan(@Field("id_user")int id_user,
                                        @Field("tanggal")String tanggal,
                                        @Field("berat_badan")float berat_badan,
                                        @Field("lemak_tubuh")float lemak_tubuh,
                                        @Field("kadar_air")float kadar_air,
                                        @Field("masa_otot")float masa_otot,
                                        @Field("rating_fisik")float rating_fisik,
                                        @Field("usia_sel")float usia_sel,
                                        @Field("kepadatan_tulang")float kepadatan_tulang,
                                        @Field("lemak_perut")float lemak_perut,
                                        @Field("bmr")float bmr);

    //Get data timbangan by user
    @GET("timbangan")
    Call<List<DataTimbanganModel>>getTimbanganUser(@Query("id_user")int id_user);

    //Get detail timbangan
    @FormUrlEncoded
    @POST("timbangan/lihat")
    Call<ResponseDetailTimbangan>getDetailTimbangan(@Field("id_user")int id_user,
                                                    @Field("id_timbangan")int id_timbangan);

    //Delete Timbangan
    @FormUrlEncoded
    @POST("timbangan/hapus")
    Call<ResponseHapusTimbangan>hapusTimbangan(@Field("id_timbangan")int id_timbangan);

    //Get Jadwal
    @GET("jadwal")
    Call<List<JadwalModel>>requestJadwal(@Query("id_user")int id_user);

}
