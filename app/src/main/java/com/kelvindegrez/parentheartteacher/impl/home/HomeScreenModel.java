package com.kelvindegrez.parentheartteacher.impl.home;

import com.kelvindegrez.parentheartteacher.mvp.home.HomeModel;
import com.kelvindegrez.parentheartteacher.mvp.home.HomePresenter;

public class HomeScreenModel implements HomeModel {

    private HomePresenter presenter;

    @Override
    public void setPresenter(HomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public HomePresenter getPresenter() {
        return presenter;
    }
}
