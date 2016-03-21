package com.learning.daggertwo.casterio.dagger;

import com.learning.daggertwo.casterio.TaskoApplication;
import com.learning.daggertwo.casterio.activities.MainActivity;
import com.learning.daggertwo.casterio.fragments.MainFragment;
import com.learning.daggertwo.casterio.network.RestCountryServiceImpl;
import com.learning.daggertwo.casterio.services.PopulationCountService;

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
    void inject(PopulationCountService target);

    void inject(MainFragment target);
//    void inject(RestCountryServiceImpl target);

}
