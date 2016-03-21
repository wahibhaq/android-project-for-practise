package com.learning.daggertwo.casterio;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.learning.daggertwo.casterio.dagger.ApiModule;
import com.learning.daggertwo.casterio.dagger.ApplicationComponent;
import com.learning.daggertwo.casterio.dagger.ApplicationModule;
import com.learning.daggertwo.casterio.dagger.DaggerApplicationComponent;
import com.learning.daggertwo.casterio.services.PopulationCountService;

/**
 * Created by wahibulhaq on 13/03/16.
 */
public abstract class TaskoApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();

        // Check the current conditions
//        startService(new Intent(this, PopulationCountService.class));

    }

    public ApplicationComponent getComponent() {
        return component;
    }

    public static TaskoApplication get(Context context) {
        return (TaskoApplication) context.getApplicationContext();
    }
}
