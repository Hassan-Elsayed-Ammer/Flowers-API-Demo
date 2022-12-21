package com.androidstation.flowersapidemo.network;

import com.androidstation.flowersapidemo.pojo.Flower;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://services.hanselandpetal.com/";

    //Reference variable from API interface
    private FlowerAPI flowerAPI;

    private static ApiClient INSTANCE;


    // Create constructor to idealize the retrofit object
    public ApiClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        flowerAPI = retrofit.create(FlowerAPI.class);
    }

    public static ApiClient getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new ApiClient();
        }
        return INSTANCE;
    }

    public Observable<ArrayList<Flower>> getFlower() {
        return flowerAPI.getFlowers();
    }
}
