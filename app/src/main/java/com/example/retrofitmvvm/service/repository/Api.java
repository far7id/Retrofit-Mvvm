package com.example.retrofitmvvm.service.repository;

import com.example.retrofitmvvm.service.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api
{
    @GET("posts")
    Call<List<Model>> getList();
}
