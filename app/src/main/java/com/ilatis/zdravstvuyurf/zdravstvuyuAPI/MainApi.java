package com.ilatis.zdravstvuyurf.zdravstvuyuAPI;

import com.ilatis.zdravstvuyurf.HelperClass.ReturnIDs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class MainApi {
    public interface getUser{
        @GET("/mobile_login.php")
        Call<ReturnIDs> CurrUser(@Query("mobile_login") String str);
    }
}
