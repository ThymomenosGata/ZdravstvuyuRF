package com.ilatis.zdravstvuyurf.zdravstvuyuAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AutorizationAPI {
    private static String BASE_URL = "http://здравствую.рф";
    public static MainApi.getUser getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MainApi.getUser user = retrofit.create(MainApi.getUser.class);
        return user;

    }
}
