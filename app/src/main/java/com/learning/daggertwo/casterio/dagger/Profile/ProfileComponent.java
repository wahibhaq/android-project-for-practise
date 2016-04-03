package com.learning.daggertwo.casterio.dagger.Profile;

import com.learning.daggertwo.casterio.fragments.ProfileFragment;

import dagger.Subcomponent;

/**
 * Created by wahibulhaq on 03/04/16.
 */

@ProfileScope
@Subcomponent(modules = { ProfileModule.class })
public interface ProfileComponent {
    void inject(ProfileFragment target);
}
