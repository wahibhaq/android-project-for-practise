package com.learning.daggertwo.casterio.dagger.Settings;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wahibulhaq on 03/04/16.
 */

@Module
public class SettingsModule {

    // All settings screen dependencies go here

    @Provides
    public SettingsService provideSettingsService() {
        return new SettingServiceImpl();
    }
}
