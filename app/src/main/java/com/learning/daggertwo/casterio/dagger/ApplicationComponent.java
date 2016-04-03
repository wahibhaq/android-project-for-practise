package com.learning.daggertwo.casterio.dagger;

import com.learning.daggertwo.casterio.TaskoApplication;
import com.learning.daggertwo.casterio.activities.MainActivity;
import com.learning.daggertwo.casterio.dagger.CountryInfo.ApiModule;
import com.learning.daggertwo.casterio.dagger.CountryInfo.CountryInfoComponent;
import com.learning.daggertwo.casterio.dagger.CountryInfo.CountryInfoModule;
import com.learning.daggertwo.casterio.dagger.Profile.ProfileComponent;
import com.learning.daggertwo.casterio.dagger.Profile.ProfileModule;
import com.learning.daggertwo.casterio.dagger.Settings.SettingsComponent;
import com.learning.daggertwo.casterio.dagger.Settings.SettingsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wahibulhaq on 13/03/16.
 */

@Singleton
@Component (modules = {ApiModule.class, ApplicationModule.class})
public interface ApplicationComponent {

    void inject(TaskoApplication target);
    void inject(MainActivity target);

    CountryInfoComponent plus(CountryInfoModule countryInfoModule);
    SettingsComponent plus(SettingsModule settingsModule);
    ProfileComponent plus(ProfileModule ProfileModule);

}
