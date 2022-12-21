package com.androidstation.flowersapidemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.androidstation.flowersapidemo.R;
import com.androidstation.flowersapidemo.adapters.FlowerAdapter;
import com.androidstation.flowersapidemo.pojo.Flower;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1- create member variable from view model in your Activity
    MainActivityViewModel mainActivityViewModel ;

    private RecyclerView recycler_flowers;
    private ProgressBar loading_progress_bar ;
    private FlowerAdapter adapter;
    private ArrayList<Flower> flowers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        //2- initialize the view model to view model providers
        mainActivityViewModel = new ViewModelProvider(this,new ViewModelProvider.
                AndroidViewModelFactory(getApplication())).get(MainActivityViewModel.class);
        mainActivityViewModel.getFlower();


        adapter = new FlowerAdapter(this,flowers);
        recycler_flowers.setAdapter(adapter);

        mainActivityViewModel.flowerMutableLiveData.observe(this, flowers -> {
            loading_progress_bar.setVisibility(View.GONE);
            adapter.setList(flowers);
        });

    }

    private void initViews() {
        recycler_flowers = findViewById(R.id.recycler_flowers);
        loading_progress_bar = findViewById(R.id.loading_progress_bar);
    }


}