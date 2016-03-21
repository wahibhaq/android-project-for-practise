package com.learning.daggertwo.casterio.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wahibulhaq on 14/03/16.
 */
public class RestClient {

//    private static RestCountryApiService restCountryApiService;
//    private static final String baseUrl = "https://restcountries-v1.p.mashape.com";
//
//    public final RestCountryApiService getRestClient() {
//        if(restCountryApiService == null) {
//
//            OkHttpClient okHttpClient = new OkHttpClient();
//            okHttpClient.interceptors().add(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Response response = chain.proceed(chain.request());
//                    return response;
//                }
//            });
//
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .client(okHttpClient)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//            restCountryApiService = retrofit.create(RestCountryApiService.class);
//        }
//        return restCountryApiService;
//    }
}
