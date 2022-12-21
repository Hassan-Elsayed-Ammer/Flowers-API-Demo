package com.androidstation.flowersapidemo.ui;


import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidstation.flowersapidemo.network.ApiClient;
import com.androidstation.flowersapidemo.pojo.Flower;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    //1-create variable from data that will return from retrofit
    MutableLiveData<ArrayList<Flower>> flowerMutableLiveData =
            new MutableLiveData<>();

    //2- Create function to get data from retrofit( Make Call Backs)
    public void getFlower(){
        Observable observable = ApiClient.getINSTANCE().getFlower()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<ArrayList<Flower>> observer = new Observer<ArrayList<Flower>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ArrayList<Flower> flowers) {
                    flowerMutableLiveData.setValue(flowers);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }



}
