package com.pallav.androidjetpack.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pallav.androidjetpack.model.PersonModel;
import com.pallav.androidjetpack.network.APIService;
import com.pallav.androidjetpack.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PersonListViewModel extends ViewModel {

    private MutableLiveData<List<PersonModel>> personList;
    public PersonListViewModel() {
            personList = new MutableLiveData<>();
    }

    public MutableLiveData<List<PersonModel>> getPersonListObsever(){
        return personList;

    }

    public void makeApiCall(){

      APIService apiService = RetroInstance.getRetrofitClient().create(APIService.class);

        Call<List<PersonModel>> call  = apiService.getPersonList();
        call.enqueue(new Callback<List<PersonModel>>() {
            @Override
            public void onResponse(Call<List<PersonModel>> call, Response<List<PersonModel>> response) {
                personList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PersonModel>> call, Throwable t) {
                personList.postValue(null);
            }
        });
    }
}
