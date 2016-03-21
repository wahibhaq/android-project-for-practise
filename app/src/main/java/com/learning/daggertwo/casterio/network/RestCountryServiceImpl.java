package com.learning.daggertwo.casterio.network;

import android.util.Log;

import java.util.List;

import eu.restcountries.models.CountryInfo;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wahibulhaq on 14/03/16.
 */
public class RestCountryServiceImpl implements RestCountryService {

    private RestCountryApiEndpointInterface apiService;
    private static final String CLASS_NAME = RestCountryServiceImpl.class.getSimpleName();
    private Subscription mPopCountSubscription;

    public RestCountryServiceImpl(RestCountryApiEndpointInterface service) {
        this.apiService = service;
    }

    @Override
    public void getPopulatationCountFor(final String countryName, final PopulationCountListener
            populationCountListener) {

        Observable<List<CountryInfo>> popCountObservable = apiService.getByCountryName(countryName);

        mPopCountSubscription = popCountObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Observer<List<CountryInfo>>() {
                            @Override
                            public void onCompleted() {
                                Log.d(CLASS_NAME, "Observer onCompleted");
                            }

                            @Override
                            public void onError(Throwable e) {
                                // cast to retrofit.HttpException to get the response code
                                if (e instanceof HttpException) {
                                    HttpException response = (HttpException) e;
                                    int code = response.code();
                                    Log.d(CLASS_NAME, "HttpException : " + code);
                                }

                                populationCountListener.onPopulationCountFailed(e);
                            }

                            @Override
                            public void onNext(List<CountryInfo> countryInfo) {
//                                Log.d(CLASS_NAME, "Observer onNext");
                                populationCountListener.onPopulationCountLoaded(countryInfo.get(0));
                            }
                        }
                );

    }
}
