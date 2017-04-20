package com.yagmur.pawadmin;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.yagmur.pawadmin.Adapter.PetListAdapter;
import com.yagmur.pawadmin.Model.Dog;

import java.util.ArrayList;
import java.util.List;

public class PetListActivity extends BaseActivity {
    private Dog dog;
    private List<Dog> dogList = new ArrayList<>();
    private RecyclerView petListRV;
    private PetListAdapter myAdapter;
    private View alertDialogView;
    private AlertDialog searchDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();
    }

    private void Init() {
        petListRV = (RecyclerView) findViewById(R.id.petListRecyclerV);
        myAdapter = new PetListAdapter(dogList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        petListRV.setLayoutManager(mLayoutManager);
        petListRV.setItemAnimator(new DefaultItemAnimator());
        petListRV.setAdapter(myAdapter);

        prepareDogData();

    }

    public void fabSearch(View v) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(PetListActivity.this);
        alertDialogView = getLayoutInflater().inflate(R.layout.dialog_search, null);
        alertDialogInit();
        mBuilder.setView(alertDialogView);
        searchDialog = mBuilder.create();
        searchDialog.show();

    }

    private void alertDialogInit() {
        Spinner speciesSpinner = (Spinner) alertDialogView.findViewById(R.id.species_spinner);
        ArrayAdapter<CharSequence> speciesAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.species_array, R.layout.spinner_item);
        speciesAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        speciesSpinner.setAdapter(speciesAdapter);

        Spinner ageSpinner = (Spinner) alertDialogView.findViewById(R.id.age_spinner);
        ArrayAdapter<CharSequence> ageAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.age_array, R.layout.spinner_item);
        ageAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);
    }

    public void searchButtonOnClick(View view) {
        // TODO: 17.4.2017 Search edilen listeyi döndürecek.
        Snackbar.make(view, "Search OnClick is going to be here", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    public void cancelButtonOnClick(View view) {
        searchDialog.dismiss();
    }

    private void prepareDogData() {
        dog = new Dog("1000", 2, BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.image));
        dogList.add(dog);

        dog = new Dog("1002", 1, BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.image2));
        dogList.add(dog);

        dog = new Dog("1003", 4, BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.image3));
        dogList.add(dog);

        dog = new Dog("1004", 6, BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.image));
        dogList.add(dog);

        int id = 1005;
        for (int i = 0; i <= 10; i++) {
            String idS = String.valueOf(id);
            dog = new Dog(idS, 6);
            dogList.add(dog);
            id++;
        }

        myAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(this, PetProfileAddActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getMainLayoutID() {
        return R.layout.petlist_activity;
    }

    @Override
    protected int getMenuTitleResource() {
        return R.string.pet_list_title;
    }

    @Override
    protected int getMenuLayoutID() {
        return R.menu.petlist_menu;
    }

}
