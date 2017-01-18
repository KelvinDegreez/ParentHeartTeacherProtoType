package com.kelvindegrez.parentheartteacher.mvp.splash;

import com.kelvindegrez.parentheartteacher.mvp.MvpView;
import com.kelvindegrez.parentheartteacher.mvp.Screen;

public interface SplashView extends MvpView<SplashPresenter> {

    void navigateToScreen(Screen screen);
}
