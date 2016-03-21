package com.learning.daggertwo.casterio.network;

/**
 * Created by wahibulhaq on 13/03/16.
 */
public interface RestCountryService {
    void getPopulatationCountFor(String country, PopulationCountListener populationCountListener);
}
