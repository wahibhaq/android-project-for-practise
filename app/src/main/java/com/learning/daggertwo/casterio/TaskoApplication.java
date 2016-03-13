package com.learning.daggertwo.casterio;

import android.app.Application;

import com.learning.daggertwo.casterio.dagger.ApplicationComponent;
import com.learning.daggertwo.casterio.dagger.ApplicationModule;
import com.learning.daggertwo.casterio.dagger.DaggerApplicationComponent;

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
                .build();
    }


    public ApplicationComponent getComponent() {
        return component;
    }
}
