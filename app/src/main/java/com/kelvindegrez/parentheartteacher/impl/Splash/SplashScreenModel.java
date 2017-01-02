package com.kelvindegrez.parentheartteacher.impl.Splash;

import com.kelvindegrez.parentheartteacher.dagger2.MainApp;
import com.kelvindegrez.parentheartteacher.mvp.Screen;
import com.kelvindegrez.parentheartteacher.mvp.Splash.SplashModel;
import com.kelvindegrez.parentheartteacher.mvp.Splash.SplashPresenter;

public class SplashScreenModel implements SplashModel {

    SplashPresenter presenter;

    public SplashScreenModel(){
    }

    @Override
    public Screen getNextScreen() {
        return Screen.Splash;
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
