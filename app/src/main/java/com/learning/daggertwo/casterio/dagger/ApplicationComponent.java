package com.learning.daggertwo.casterio.dagger;

import com.learning.daggertwo.casterio.TaskoApplication;
import com.learning.daggertwo.casterio.activiites.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wahibulhaq on 13/03/16.
 */

@Singleton
@Component (modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(TaskoApplication target);
    void inject(MainActivity target);

}
