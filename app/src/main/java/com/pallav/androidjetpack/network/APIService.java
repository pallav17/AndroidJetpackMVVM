package com.pallav.androidjetpack.network;

import com.pallav.androidjetpack.model.PersonModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIService {

    @Headers("app-id:6129406deaba4bb8b731f272")
    @GET("v1/user?limit=20")
    Call<List<PersonModel>> getPersonList();




}
