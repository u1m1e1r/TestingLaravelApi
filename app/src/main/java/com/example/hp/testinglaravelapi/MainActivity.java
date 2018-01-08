package com.example.hp.testinglaravelapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyInterface.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyInterface api = retrofit.create(MyInterface.class);
        Call<List<PojoClass>> call  = api.getMovie();
        call.enqueue(new Callback<List<PojoClass>>() {

            @Override
            public void onResponse(Call<List<PojoClass>> call, Response<List<PojoClass>> response) {
                List<PojoClass> movies = response.body();
                Toast.makeText(getApplicationContext(),"omaromar",Toast.LENGTH_LONG).show();
                for(PojoClass p : movies){
                    Log.d("name",p.getMovie_name());
                }
            }

            @Override
            public void onFailure(Call<List<PojoClass>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),""+t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
