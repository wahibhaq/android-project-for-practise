package com.learning.daggertwo.casterio.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learning.daggertwo.casterio.R;
import com.learning.daggertwo.casterio.TaskoApplication;
import com.learning.daggertwo.casterio.services.SettingsService;

import javax.inject.Inject;

/**
 * Created by wahibulhaq on 03/04/16.
 */
public class SettingsFragment extends BaseFragment {

    @Inject protected Resources resources;
    @Inject protected SettingsService settingsService;

    public SettingsFragment() {
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TaskoApplication) getActivity().getApplication()).createSettingsComponent().inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((TaskoApplication) getActivity().getApplication()).releaseSettingsComponent();
    }
}
