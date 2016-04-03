package com.learning.daggertwo.casterio.dagger.CountryInfo;

import com.learning.daggertwo.casterio.fragments.CountryInfoFragment;

import dagger.Subcomponent;

/**
 * Created by wahibulhaq on 03/04/16.
 */

@Subcomponent(modules = {CountryInfoModule.class})
@CountryInfoScope
public interface CountryInfoComponent {

    void inject(CountryInfoFragment target);

}
