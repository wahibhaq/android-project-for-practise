package com.learning.daggertwo.casterio.activities;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.learning.daggertwo.casterio.R;
import com.learning.daggertwo.casterio.TaskoApplication;
import com.learning.daggertwo.casterio.fragments.MainFragment;
import com.learning.daggertwo.casterio.fragments.ProfileFragment;
import com.learning.daggertwo.casterio.fragments.SettingsFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements
        MainFragment.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    @Inject
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TaskoApplication.get(this).getApplicationComponent().inject(this);

        if(prefs != null) {
            Log.d("Dagger2", "Prefs is not null");
        }

//        navigateToMainFragment();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigateToProfileFragment();

        // Select the first item in the home view
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    private void navigateToMainFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, MainFragment.newInstance(), MainFragment.class.getSimpleName())
                .commit();
    }

    private void navigateToProfileFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, ProfileFragment.newInstance(), ProfileFragment.class.getSimpleName())
                .commit();
    }

    private void navigateToSettingsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, SettingsFragment.newInstance(), SettingsFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            navigateToProfileFragment();
        } else if (id == R.id.nav_settings) {
            navigateToSettingsFragment();
        } else if (id == R.id.nav_main) {
            navigateToMainFragment();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
