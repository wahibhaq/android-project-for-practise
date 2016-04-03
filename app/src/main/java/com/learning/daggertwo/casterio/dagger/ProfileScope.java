package com.learning.daggertwo.casterio.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by wahibulhaq on 03/04/16.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ProfileScope {
}
