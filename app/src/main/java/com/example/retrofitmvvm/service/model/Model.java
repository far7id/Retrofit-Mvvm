package com.example.retrofitmvvm.service.model;

import com.google.gson.annotations.SerializedName;

public class Model
{
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    public Model(int id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }
}
