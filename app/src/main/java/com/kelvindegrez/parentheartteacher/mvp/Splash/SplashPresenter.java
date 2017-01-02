package com.kelvindegrez.parentheartteacher.mvp.Splash;

import com.kelvindegrez.parentheartteacher.mvp.MvpPresenter;

public interface SplashPresenter extends MvpPresenter<SplashView, SplashModel> {

    void loadData();
}
