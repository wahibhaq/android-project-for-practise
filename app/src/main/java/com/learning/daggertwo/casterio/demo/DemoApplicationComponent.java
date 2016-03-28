package com.learning.daggertwo.casterio.demo;

import com.learning.daggertwo.casterio.dagger.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wahibulhaq on 28/03/16.
 */

@Singleton
@Component(modules = {ApiModule.class, DemoModule.class})
public interface DemoApplicationComponent extends DemoComponent {
}
