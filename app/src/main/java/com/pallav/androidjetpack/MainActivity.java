package com.pallav.androidjetpack;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pallav.androidjetpack.adapter.PersonListAdapter;
import com.pallav.androidjetpack.model.PersonModel;
import com.pallav.androidjetpack.model.PersonObj;
import com.pallav.androidjetpack.viewmodel.PersonListViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity  {
    private RecyclerView recyclerView;
    private PersonListAdapter personListAdapter;
    private List<PersonObj> personObj;
    private PersonListViewModel viewModel;

  //  PersonModel personModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
       LinearLayoutManager layoutManager = new GridLayoutManager(this, 2); // beacuse Grid with 2 columns

        viewModel = new PersonListViewModel();
        viewModel.makeApiCall();
        viewModel.setStateUpdateListener(new PersonListViewModel.UpdateListener() {
            @Override
            public void onUpdate(PersonModel state) {
                personListAdapter.update(state.getPersonlist());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

        recyclerView.setLayoutManager(layoutManager);
        personListAdapter = new PersonListAdapter(this);
        recyclerView.setAdapter(personListAdapter);



        /*viewModel = ViewModelProviders.of(this).get(PersonListViewModel.class);
        viewModel.getPersonListObsever().observe(this, new Observer<PersonModel>() {
            @Override
            public void onChanged(PersonModel personModel) {

                if (personModel.data != null) {
                    //personModelList = personModels;
                    personListAdapter.setPersonlist(personModel.getPersonlist());
                } else {
                    Toast.makeText(MainActivity.this, "No result found", Toast.LENGTH_SHORT).show();
                }
            }


        });*/


    }
}
