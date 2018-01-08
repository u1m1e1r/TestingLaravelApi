package com.example.hp.testinglaravelapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HP on 11/21/2017.
 */

public interface MyInterface {

    String base_url = "http://10.0.2.2:8080//";
    @GET("laravelmy/public/api/movies/")
    Call<List<PojoClass>> getMovie();

}
