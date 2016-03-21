package com.learning.daggertwo.casterio.dagger;

import android.content.Context;
import android.util.Log;

import com.learning.daggertwo.casterio.R;
import com.learning.daggertwo.casterio.network.Constants;
import com.learning.daggertwo.casterio.network.RestCountryApiEndpointInterface;

import java.io.IOException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wahibulhaq on 14/03/16.
 */

@Module
public class ApiModule {

    @Provides
    @Singleton
    @Named(Constants.Injection.Named.RESTCOUNTRY_BASE_URL_KEY)
    public String provideBaseUrl() {
        return Constants.Injection.Named.RESTCOUNTRY_BASE_URL;
    }

    @Provides
    @Singleton
    @Named(Constants.Injection.Named.MASHAPE_API_KEY)
    public String provideMashapeApiKey(Context context) {
        return context.getString(R.string.mashape_api_key);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(final @Named(Constants.Injection.Named.MASHAPE_API_KEY) String key) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

//                long t1 = System.nanoTime();
//                Log.d("ApiModule", "Sending request : " +
//                        original.url() + " , " + chain.connection() + " , " +  original.headers());


                // Customize the request
                Request requestBuilder = original.newBuilder()
                        .header(Constants.Injection.Named.MASHAPE_API_KEY, key)
                        .method(original.method(), original.body())
                        .build();

                Response response = chain.proceed(requestBuilder);

//                long t2 = System.nanoTime();
//                Log.d("ApiModule", "Received response : " +
//                        response.request().url()+ " , " +  (t2 - t1) / 1e6d + " , " +  response.headers());

                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                // Customize or return the response
                return response;
            }
        });

        return httpClient.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(
            @Named(Constants.Injection.Named.RESTCOUNTRY_BASE_URL_KEY) String baseUrl, OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public RestCountryApiEndpointInterface provideRestCountryApiService(Retrofit retrofit) {
        return retrofit.create(RestCountryApiEndpointInterface.class);
    }

}
