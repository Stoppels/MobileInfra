package com.apps.oonick.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nick Shayan on 20-06-16.
 */
public class ReadingHelper {

    final String BASE_URL = "http://localhostdeviceip:2403/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void addReading(Reading reading) {

        Endpoints apiService = retrofit.create(Endpoints.class);

        Call<Reading> call = apiService.addReading(reading);

        call.enqueue(new Callback<Reading>() {
            @Override
            public void onResponse(Call<Reading> call, Response<Reading> response) {
                System.out.println("Reading added successfully: " + response.message());
            }

            @Override
            public void onFailure(Call<Reading> call, Throwable t) {
                System.err.println("Adding of reading failed: " + t.getLocalizedMessage());
            }
        });
    }


    public void getReadings() {

        Endpoints apiService = retrofit.create(Endpoints.class);

        Call<List<Reading>> call = apiService.getReadings();

        call.enqueue(new Callback<List<Reading>>() {
            @Override
            public void onResponse(Call<List<Reading>> call, Response<List<Reading>> response) {
                List<Reading> readings = response.body();

                System.out.println("Got some with code " + response.code() + "\n ");

                for (Reading r : readings) {
                    System.out.println(r);
                }
            }

            @Override
            public void onFailure(Call<List<Reading>> call, Throwable t) {
                System.err.println("Getting readings failed with message " + t.toString());
            }
        });
    }

    public ReadingHelper() {
    }
}