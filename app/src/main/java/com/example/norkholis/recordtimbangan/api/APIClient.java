package com.example.norkholis.recordtimbangan.api;

import com.example.norkholis.recordtimbangan.BuildConfig;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;

    public static Retrofit retrofit(String BASE_URL){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }return retrofit;
    }


    public APICall getService(){
        return retrofit(BuildConfig.BASE_URL).create(APICall.class);
    }
}


//    public APIClient(){
//
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        Request original = chain.request();
//                        HttpUrl httpUrl = original.url()
//                                .newBuilder()
//                                .build();
//
//                        original = original.newBuilder()
//                                .url(httpUrl)
//                                .build();
//
//                        return chain.proceed(original);
//                    }
//                })
//                .build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(client)
//                .baseUrl(BuildConfig.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        apiCall = retrofit.create(APICall.class);
//    }