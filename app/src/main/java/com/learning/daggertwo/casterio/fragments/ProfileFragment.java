package com.learning.daggertwo.casterio.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learning.daggertwo.casterio.R;
import com.learning.daggertwo.casterio.TaskoApplication;
import com.learning.daggertwo.casterio.demo.DemoApplication;
import com.learning.daggertwo.casterio.models.SomeTestObject;

import javax.inject.Inject;

/**
 * Created by wahibulhaq on 03/04/16.
 */
public class ProfileFragment extends BaseFragment {

    @Inject protected Resources resources;
    @Inject
    protected SomeTestObject someTestObject;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TaskoApplication) getActivity().getApplication()).createProfileComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((TaskoApplication) getActivity().getApplication()).releaseProfileComponent();
    }
}
