package com.yagmur.pawadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Yagmur on 20.4.2017.
 */

public class LogInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        Init();
    }

    public void signInOnClick(View view){
        Intent intent = new Intent(this, PetListActivity.class);
        startActivity(intent);
        finish();
    }

    private void Init() {

    }
}
