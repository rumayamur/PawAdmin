package com.yagmur.pawadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected DrawerLayout base_activity_drawerLyt;
    private Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getMainLayoutID() == 0) {
            setContentView(R.layout.empty_activity_drawerlayout);
        } else {
            setContentView(getMainLayoutID());
        }
        base_activity_drawerLyt = (DrawerLayout) findViewById(R.id.base_activity_drawerLyt);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (getMenuTitleResource() != 0) {
            toolbar.setTitle(getResources().getString(getMenuTitleResource()));
        } else {
            toolbar.setTitle(getResources().getString(R.string.app_name));
        }
        setSupportActionBar(toolbar);

        if (isNavigationDrawerEnabled()) {
            drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        } else {
            Log.d("Navigation Drawer", "NO NAVIGATION DRAWER!");
        }
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (getMenuLayoutID() == 0) {
            return false;
        }
        getMenuInflater().inflate(getMenuLayoutID(), menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_pet_list) {
            Intent intent = new Intent(getApplicationContext(), PetListActivity.class);
            startActivity(intent);
            finish();
        }
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected abstract int getMainLayoutID();

    protected abstract int getMenuTitleResource();

    protected abstract int getMenuLayoutID();

    protected abstract boolean isNavigationDrawerEnabled();
}
