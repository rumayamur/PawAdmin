package com.yagmur.pawadmin;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Yagmur on 20.4.2017.
 */

public class PetProfileAddActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();
    }

    private void Init() {
        Spinner speciesSpinner = (Spinner) findViewById(R.id.species_spinner);
        ArrayAdapter<CharSequence> speciesAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.species_array, R.layout.spinner_item);
        speciesAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        speciesSpinner.setAdapter(speciesAdapter);

        Spinner genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.gender_array, R.layout.spinner_item);
        genderAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);
    }

    @Override
    protected int getMainLayoutID() {
        return R.layout.petprofileadd_activity;
    }

    @Override
    protected int getMenuTitleResource() {
        return 0;
    }

    @Override
    protected int getMenuLayoutID() {
        return 0;
    }
}
