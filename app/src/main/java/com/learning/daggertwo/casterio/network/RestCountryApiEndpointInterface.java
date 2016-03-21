package com.learning.daggertwo.casterio.network;

import java.util.List;

import eu.restcountries.models.CountryInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wahibulhaq on 14/03/16.
 */
public interface RestCountryApiEndpointInterface {
    @Headers({
            "Accept: application/json",
            "User-Agent: LearnignDaggerCasterio"
    })
    @GET("/name/{name}")
    Observable<List<CountryInfo>> getByCountryName(@Path("name") String name);

}
