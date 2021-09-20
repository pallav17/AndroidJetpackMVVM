package com.pallav.androidjetpack.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.pallav.androidjetpack.model.PersonModel;
import com.pallav.androidjetpack.model.PersonObj;
import com.pallav.androidjetpack.network.APIService;
import com.pallav.androidjetpack.network.RetroInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PersonListViewModel  {

    ArrayList<PersonObj> arrayList;
        /*public MutableLiveData<PersonModel> personList;

         public PersonListViewModel() {
            personList = new MutableLiveData<>();
    }
            public MutableLiveData<PersonModel> getPersonListObsever(){
            return personList;*/
    public interface UpdateListener {

        public void onUpdate(PersonModel state);
        public void onFailure(Exception e);

    }

   PersonModel personModel;
    UpdateListener listener;

    public PersonListViewModel() {

        arrayList = new ArrayList<>();
        //  itemListViewState = new ItemListViewState("Delivery Items", items);

       personModel = new PersonModel(arrayList);

    }

    public void setStateUpdateListener(UpdateListener listener) {

        this.listener = listener;
        // listener.onUpdate(itemListViewState);

    }

    public void makeApiCall(){

      APIService apiService = RetroInstance.getRetrofitClient().create(APIService.class);

        Call<PersonModel> personResponse  = apiService.getPersonList();

        personResponse.enqueue(new Callback<PersonModel>() {
            @Override
            public void onResponse(Call<PersonModel> call, Response<PersonModel> response) {
               // Log.d("This is response","Person Response"+response.body().getPersonlist());
          // personList.postValue(response.body());
               personModel.setPersonlist(response.body().getPersonlist());
                listener.onUpdate(personModel);
            }

            @Override
            public void onFailure(Call<PersonModel> call, Throwable t) {
                Log.d("This is response for failure","Person Response"+t.getMessage());
                //personList.postValue(null);
            }
        });

    }
}
