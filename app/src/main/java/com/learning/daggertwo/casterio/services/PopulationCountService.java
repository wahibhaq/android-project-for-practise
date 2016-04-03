package com.learning.daggertwo.casterio.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.learning.daggertwo.casterio.TaskoApplication;
import com.learning.daggertwo.casterio.network.PopulationCountListener;
import com.learning.daggertwo.casterio.network.RestCountryService;

import javax.inject.Inject;

import eu.restcountries.models.CountryInfo;

public class PopulationCountService extends Service {

    private static final String TAG = PopulationCountService.class.getSimpleName();

    @Inject
    RestCountryService restCountryService;

    @Override
    public void onCreate() {
        super.onCreate();
//        android.os.Debug.waitForDebugger();
        TaskoApplication.get(this).getApplicationComponent().inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Attempting to get current conditions.");

        // Forecast service is an ASYNC call.
        // hard coded to NYC. In prod: Use a location listener to get the GPS coords of the user.
        restCountryService.getPopulatationCountFor("Pakistan", new PopulationCountListener() {
            @Override
            public void onPopulationCountLoaded(CountryInfo countryInfo) {

                if (countryInfo != null) {
                    Log.d(TAG, "Country info loaded.");
                }

                if (countryInfo != null && countryInfo.getPopulation() != null) {
                    int populationCount = countryInfo.getPopulation();
                    Log.d(TAG, "Country Population : " + populationCount);

                }

                stopSelf();
            }

            @Override
            public void onPopulationCountFailed(Throwable e) {
                Log.e(TAG, e.getMessage());
                stopSelf();
            }
        });

        return Service.START_NOT_STICKY;

    }

    @Override
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }
}
