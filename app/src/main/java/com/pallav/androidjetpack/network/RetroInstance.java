package com.pallav.androidjetpack.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String BaseUrl = "https://dummyapi.io/data";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient() {

        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                            .baseUrl(BaseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        }

        return retrofit;
    }

}
