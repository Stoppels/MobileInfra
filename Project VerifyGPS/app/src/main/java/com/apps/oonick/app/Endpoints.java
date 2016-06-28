package com.apps.oonick.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Nick Shayan on 22-06-16.
 */
public interface Endpoints {

    @GET("readings/")
    Call<List<Reading>> getReadings();

//    @GET("readings/<id>")
//    Call<List<Reading>> getReading();

    @POST("readings/")
    Call<Reading> addReading(@Body Reading reading);
}
