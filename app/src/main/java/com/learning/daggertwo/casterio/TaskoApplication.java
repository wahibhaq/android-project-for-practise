package com.learning.daggertwo.casterio;

import android.app.Application;
import android.content.Context;

import com.learning.daggertwo.casterio.dagger.ApiModule;
import com.learning.daggertwo.casterio.dagger.ApplicationComponent;
import com.learning.daggertwo.casterio.dagger.ApplicationModule;
import com.learning.daggertwo.casterio.dagger.DaggerApplicationComponent;
import com.learning.daggertwo.casterio.dagger.ProfileComponent;
import com.learning.daggertwo.casterio.dagger.ProfileModule;
import com.learning.daggertwo.casterio.dagger.SettingsComponent;
import com.learning.daggertwo.casterio.dagger.SettingsModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by wahibulhaq on 13/03/16.
 */
public abstract class TaskoApplication extends Application {

    private ApplicationComponent applicationComponent;
    private SettingsComponent settingsComponent;
    private ProfileComponent profileComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();

        // The realm file will be located in Context.getFilesDir() with name "default.realm"
        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static TaskoApplication get(Context context) {
        return (TaskoApplication) context.getApplicationContext();
    }

    public SettingsComponent createSettingsComponent() {
        settingsComponent = applicationComponent.plus(new SettingsModule());
        return settingsComponent;
    }

    public void releaseSettingsComponent() {
        settingsComponent = null;
    }

    public ProfileComponent createProfileComponent() {
        profileComponent = applicationComponent.plus(new ProfileModule());
        return profileComponent;
    }

    public void releaseProfileComponent() {
        profileComponent = null;
    }
}
