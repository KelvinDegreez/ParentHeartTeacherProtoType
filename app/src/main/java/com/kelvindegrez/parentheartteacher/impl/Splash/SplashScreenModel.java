package com.kelvindegrez.parentheartteacher.impl.splash;

import com.kelvindegrez.parentheartteacher.mvp.Screen;
import com.kelvindegrez.parentheartteacher.mvp.splash.SplashModel;
import com.kelvindegrez.parentheartteacher.mvp.splash.SplashPresenter;

public class SplashScreenModel implements SplashModel {

    private SplashPresenter presenter;

    public SplashScreenModel() {
    }

    @Override
    public Screen getNextScreen() {
        return Screen.Home;
    }

    @Override
    public void setPresenter(SplashPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public SplashPresenter getPresenter() {
        return presenter;
    }


}
