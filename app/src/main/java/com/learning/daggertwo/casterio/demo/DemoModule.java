package com.learning.daggertwo.casterio.demo;

import com.learning.daggertwo.casterio.network.RestCountryApiEndpointInterface;
import com.learning.daggertwo.casterio.network.RestCountryService;
import com.learning.daggertwo.casterio.network.RestCountryServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wahibulhaq on 28/03/16.
 */

@Module
public class DemoModule {

    @Provides
    @Singleton
    public RestCountryService provideRestCountryService(RestCountryApiEndpointInterface apiService) {
        return new RestCountryServiceImpl(apiService);
    }
}
