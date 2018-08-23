package com.example.norkholis.recordtimbangan.api;

import com.example.norkholis.recordtimbangan.model.LoginModel;
import com.example.norkholis.recordtimbangan.model.RegisterModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

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
    //Login User
    @FormUrlEncoded
    @POST("user/login")
    Call<LoginModel> loginRequest(@Field("username_user")String username_user,
                                  @Field("password_user")String password_user);

}
