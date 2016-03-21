package com.learning.daggertwo.casterio.network;

import eu.restcountries.models.CountryInfo;

/**
 * Created by wahibulhaq on 13/03/16.
 */
public interface PopulationCountListener {
    void onPopulationCountLoaded(CountryInfo countryInfo);
    void onPopulationCountFailed(Throwable exception);

}
