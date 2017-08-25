package com.m.retrofit.retrofit_call;

import com.m.retrofit.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


public interface  RetrofitCall {

    @GET("/api/data?list=englishmonarchs&format=json")
    public void getUser(Callback<List<User>> response);

    //@GET("/posts")

}
