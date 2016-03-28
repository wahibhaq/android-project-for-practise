package com.learning.daggertwo.casterio.demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.learning.daggertwo.casterio.R;
import com.learning.daggertwo.casterio.network.PopulationCountListener;
import com.learning.daggertwo.casterio.network.RestCountryService;

import javax.inject.Inject;

import eu.restcountries.models.CountryInfo;

public class DemoActivity extends AppCompatActivity {

//    @Inject
//    RestCountryService restCountryService;

    private TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

//        DemoApplication.get(this).getComponent().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtContent = (TextView) findViewById(R.id.txt_content);

//        performFetchingData();

    }

//    private void performFetchingData() {
//
//        restCountryService.getPopulatationCountFor("Germany", new PopulationCountListener() {
//            @Override
//            public void onPopulationCountLoaded(CountryInfo countryInfo) {
//                txtContent.setText("Country : " + countryInfo.getName() + ", Population : " +
//                countryInfo.getPopulation());
//            }
//
//            @Override
//            public void onPopulationCountFailed(Throwable exception) {
//                Toast.makeText(DemoActivity.this, "PopulationFetch Failed!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}
