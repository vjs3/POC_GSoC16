package com.vjs3.retrofit20usage;

import com.vjs3.retrofit20usage.Model.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vjs3 on 25/5/16.
 */

public interface RestApi {
    String city = "Jaipur, India";
    String AppID = "cacb4e84e756d55eceb986a51adbc143";

    @GET("/data/2.5/weather")
    Call<MainModel>getWeatherReport(@Query("q") String city, @Query("APPID") String AppID);
}
