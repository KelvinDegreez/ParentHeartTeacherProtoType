package com.kelvindegrez.parentheartteacher.mvp.Splash;

import com.kelvindegrez.parentheartteacher.mvp.MvpView;
import com.kelvindegrez.parentheartteacher.mvp.Screen;

public interface SplashView extends MvpView<SplashPresenter> {

    void navigateToScreen(Screen screen);
}
