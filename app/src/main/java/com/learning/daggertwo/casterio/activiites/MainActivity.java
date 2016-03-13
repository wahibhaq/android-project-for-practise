package com.learning.daggertwo.casterio.activiites;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.learning.daggertwo.casterio.R;
import com.learning.daggertwo.casterio.TaskoApplication;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TaskoApplication)getApplication()).getComponent().inject(this);
        if(prefs != null) {
            Log.d("Dagger2", "Prefs is not null");
        }
    }
}
