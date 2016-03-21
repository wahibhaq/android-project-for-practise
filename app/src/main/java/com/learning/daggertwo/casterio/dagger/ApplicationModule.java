package com.learning.daggertwo.casterio.dagger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.learning.daggertwo.casterio.network.RestCountryApiEndpointInterface;
import com.learning.daggertwo.casterio.network.RestCountryService;
import com.learning.daggertwo.casterio.network.RestCountryServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wahibulhaq on 13/03/16.
 */

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    public RestCountryService provideRestCountryService(RestCountryApiEndpointInterface apiService) {
        return new RestCountryServiceImpl(apiService);
    }
}
