package com.example.retrofitmvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.retrofitmvvm.service.model.Model;
import com.example.retrofitmvvm.service.repository.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.retrofitmvvm.service.model.BaseUrl.BASE_URL;

public class RetrofitViewModel extends androidx.lifecycle.ViewModel
{
    private MutableLiveData<List<Model>> resList;

    //we will call this method to get the data
    public LiveData<List<Model>> getHeroes()
    {
        if (resList == null)
        {
            resList = new MutableLiveData<List<Model>>();
            loadList();
        }

        return resList;
    }

    private void loadList()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Model>> call = api.getList();

        call.enqueue(new Callback<List<Model>>()
        {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response)
            {
                //finally we are setting the list to our MutableLiveData
                if (!response.isSuccessful())
                {
                    Log.e("Code: ", String.valueOf(response.code()));
                    return;
                }

                resList.setValue(response.body());
                Log.e("onResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t)
            {
                Log.e("onFailure", t.getMessage());
            }
        });
    }
}
