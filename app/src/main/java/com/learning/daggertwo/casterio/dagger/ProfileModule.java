package com.learning.daggertwo.casterio.dagger;

import com.learning.daggertwo.casterio.models.SomeTestObject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wahibulhaq on 03/04/16.
 */

@Module
public class ProfileModule {
    // Profile Screen based dependencies go here

    @Provides
    public SomeTestObject providesSomeBigObject() {
        return new SomeTestObject("HAHAHA");
    }

}
