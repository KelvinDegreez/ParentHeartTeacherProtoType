package com.kelvindegrez.parentheartteacher.impl.home;


import com.kelvindegrez.parentheartteacher.dagger2.MainApp;
import com.kelvindegrez.parentheartteacher.mvp.home.HomeModel;
import com.kelvindegrez.parentheartteacher.mvp.home.HomePresenter;
import com.kelvindegrez.parentheartteacher.mvp.home.HomeView;

public class HomeScreenPresenter implements HomePresenter{

    private HomeModel model;
    private HomeView view;
    private boolean isViewAttached = false;

    public HomeScreenPresenter(){
        attachModel(MainApp.getDaggerComponent().provideHomeModel());
    }

    @Override
    public void attachView(HomeView view) {
        this.view = view;
        isViewAttached = true;
    }

    @Override
    public void detachView() {
        view.setPresenter(null);
        this.view = null;
        isViewAttached = false;
    }

    @Override
    public boolean isViewAttached() {
        return isViewAttached;
    }

    @Override
    public void attachModel(HomeModel model) {
        this.model = model;
        this.model.setPresenter(this);
    }
}
