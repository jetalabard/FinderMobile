package com.finder.model;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by jerem on 18/03/2018.
 */

public interface IWebServiceUser {

    @FormUrlEncoded
    @POST("/login")
    Call<JSONObject> login(@Field("username") String username, @Field("password") String password);
}
