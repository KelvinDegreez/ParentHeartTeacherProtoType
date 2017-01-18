package com.kelvindegrez.parentheartteacher.impl.splash;


import com.kelvindegrez.parentheartteacher.dagger2.MainApp;
import com.kelvindegrez.parentheartteacher.mvp.splash.SplashModel;
import com.kelvindegrez.parentheartteacher.mvp.splash.SplashPresenter;
import com.kelvindegrez.parentheartteacher.mvp.splash.SplashView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashScreenPresenter implements SplashPresenter {

    private SplashView view;
    private SplashModel model;
    private boolean isViewAttached = false;
    private int SPLASH_TIME_OUT = 3000;

    public SplashScreenPresenter() {
        attachModel(MainApp.getDaggerComponent().provideSplashModel());
    }

    @Override
    public void loadData() {
        Observer observer = new Observer() {
            @Override
            public void onCompleted() {
                view.navigateToScreen(model.getNextScreen());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
            }
        };
        Observable.timer(SPLASH_TIME_OUT, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void attachView(SplashView view) {
        this.view = view;
        isViewAttached = true;
    }

    @Override
    public void detachView() {
        this.view = null;
        isViewAttached = false;
    }

    @Override
    public boolean isViewAttached() {
        return isViewAttached;
    }

    @Override
    public void attachModel(SplashModel model) {
        this.model = model;
        this.model.setPresenter(this);
    }

}
