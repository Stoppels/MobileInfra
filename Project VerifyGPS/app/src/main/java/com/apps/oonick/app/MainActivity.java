package com.apps.oonick.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by N. Shayan on 10-6-2016.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String date = "10-06-2016";
        String device = "Genymotion";
        List<String> location = Arrays.asList("75.23432", "72.03032");
        float temperature = (float) 30.0;
        String user = "admin";

        ReadingHelper rh = new ReadingHelper();
        Reading r = new Reading(date, device, location, temperature, user);

        // Quick and dirty: demonstrate object creation via POST method over http
        rh.addReading(r);
        // Then get all readings to demonstrate listing data
        rh.getReadings();
    }

}
