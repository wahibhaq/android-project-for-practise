package com.learning.daggertwo.casterio.dagger.Settings;

import com.learning.daggertwo.casterio.fragments.SettingsFragment;

import dagger.Subcomponent;

/**
 * Created by wahibulhaq on 03/04/16.
 */

@SettingsScope
@Subcomponent(modules = { SettingsModule.class })
public interface SettingsComponent {
    void inject(SettingsFragment target);
}
