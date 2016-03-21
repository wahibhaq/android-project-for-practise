package com.learning.daggertwo.casterio.activities;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.learning.daggertwo.casterio.R;
import com.learning.daggertwo.casterio.TaskoApplication;
import com.learning.daggertwo.casterio.fragments.MainFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

    @Inject
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskoApplication.get(this).getComponent().inject(this);

        if(prefs != null) {
            Log.d("Dagger2", "Prefs is not null");
        }

        navigateToMainFragment();
    }

    private void navigateToMainFragment() {
        MainFragment f = MainFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content, f, MainFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
