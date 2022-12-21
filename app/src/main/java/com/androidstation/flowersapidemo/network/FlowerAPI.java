package com.androidstation.flowersapidemo.network;

import com.androidstation.flowersapidemo.pojo.Flower;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/** Definition of Api As  Abstract Form (convert APIs to Java interface )
 * 1- Type of API GET or POST (@GET)
 * 2- end point of URL ("feeds/flowers.json")
 * 3- Return of method (Call) Return type (ArrayList<Flower>)
 * 4- parameters (in thi sCase we don't have parameters)  **/
public interface FlowerAPI {

    @GET("feeds/flowers.json")
    Observable<ArrayList<Flower>> getFlowers();

    /*
    @HTTP();
    @POST();
    @PUT();
    @PATCH();
    @DELETE();
    @OPTIONS();
    @HEAD();
     */
}
