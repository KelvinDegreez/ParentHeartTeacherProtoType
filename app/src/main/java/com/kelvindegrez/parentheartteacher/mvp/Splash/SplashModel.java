package com.kelvindegrez.parentheartteacher.mvp.splash;

import com.kelvindegrez.parentheartteacher.mvp.MvpModel;
import com.kelvindegrez.parentheartteacher.mvp.Screen;

public interface SplashModel extends MvpModel<SplashPresenter>{

    Screen getNextScreen();

}
