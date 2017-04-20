package com.yagmur.pawadmin;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public abstract class BaseActivity extends AppCompatActivity {
    protected CoordinatorLayout base_activity;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getMainLayoutID() == 0) {
            setContentView(R.layout.empty_activity);
        } else {
            setContentView(getMainLayoutID());
        }
        base_activity = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (getMenuTitleResource() != 0) {
            toolbar.setTitle(getResources().getString(getMenuTitleResource()));
        } else {
            toolbar.setTitle(getResources().getString(R.string.app_name));
        }
        setSupportActionBar(toolbar);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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

    protected abstract int getMainLayoutID();

    protected abstract int getMenuTitleResource();

    protected abstract int getMenuLayoutID();

}
