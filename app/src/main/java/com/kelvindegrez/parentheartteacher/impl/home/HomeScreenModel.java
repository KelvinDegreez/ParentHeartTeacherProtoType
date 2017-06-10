package com.kelvindegrez.parentheartteacher.impl.home;

import com.kelvindegrez.parentheartteacher.api.FakeDataGenerator;
import com.kelvindegrez.parentheartteacher.dagger2.MainApp;
import com.kelvindegrez.parentheartteacher.mvp.home.HomeModel;
import com.kelvindegrez.parentheartteacher.mvp.home.HomePresenter;
import com.kelvindegrez.parentheartteacher.objects.Teacher;

import java.util.List;

public class HomeScreenModel implements HomeModel {

    private HomePresenter presenter;
    private FakeDataGenerator fakeData;

    public HomeScreenModel(){
        fakeData = MainApp.fakeData;
    }

    @Override
    public void setPresenter(HomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public HomePresenter getPresenter() {
        return presenter;
    }

    @Override
    public List<Teacher> getTeacherList(){
        return fakeData.getTeachers().getValue();
    }
}
