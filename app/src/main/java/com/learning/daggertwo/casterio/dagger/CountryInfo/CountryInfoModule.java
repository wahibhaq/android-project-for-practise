package com.learning.daggertwo.casterio.dagger.CountryInfo;

import com.learning.daggertwo.casterio.network.RestCountryApiEndpointInterface;
import com.learning.daggertwo.casterio.network.RestCountryService;
import com.learning.daggertwo.casterio.network.RestCountryServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wahibulhaq on 03/04/16.
 */

@Module
public class CountryInfoModule {

    @Provides
    public RestCountryService provideRestCountryService(RestCountryApiEndpointInterface apiService) {
        return new RestCountryServiceImpl(apiService);
    }
}
