package com.kelvindegrez.parentheartteacher.impl.home;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.kelvindegrez.parentheartteacher.R;
import com.kelvindegrez.parentheartteacher.dagger2.MainApp;
import com.kelvindegrez.parentheartteacher.mvp.home.HomePresenter;
import com.kelvindegrez.parentheartteacher.mvp.home.HomeView;
import com.kelvindegrez.parentheartteacher.objects.Rating;
import com.kelvindegrez.parentheartteacher.objects.Subject;
import com.kelvindegrez.parentheartteacher.objects.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeScreenView extends AppCompatActivity implements HomeView {

    HomePresenter presenter;
    TeacherRecyclerViewAdapter adapter;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_view);
        if(presenter == null){
            setPresenter(MainApp.getDaggerComponent().provideHomePresenter());
        }
        ButterKnife.bind(this);

        adapter = new TeacherRecyclerViewAdapter(teacherList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void setPresenter(HomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public HomePresenter getPresenter() {
        return presenter;
    }

}
