package com.kelvindegrez.parentheartteacher.mvp.splash;

import com.kelvindegrez.parentheartteacher.mvp.MvpPresenter;

public interface SplashPresenter extends MvpPresenter<SplashView, SplashModel> {

    void loadData();
}
