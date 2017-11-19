package com.moymac.meritapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by moymac on 11/14/17.
 */

public interface ApiInterface {

    String BASE_URL = "https://serene-brook-71867.herokuapp.com/";
//    String BASE_URL = "http://192.168.100.33:8000/";


//
//    @POST("inputs")
//    public void getInputs(Callback<ArrayList<Inputs>> callback);

    @GET("templates")
    Call<List<Templates>> getTemplates();

    @GET("projects")
    Call<List<Projects>> getProjects();

    @GET("/inputs/?format=json")
    Call<Inputs> getInputs();


    @FormUrlEncoded
    @POST("inputs")
    Call<Inputs> postInputs(@Field("step") int stepNum, @Field("text") String textData);


}
