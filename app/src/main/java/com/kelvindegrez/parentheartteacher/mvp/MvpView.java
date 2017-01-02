package com.kelvindegrez.parentheartteacher.mvp;


public interface MvpView<T extends MvpPresenter> {

    void setPresenter(T presenter);

    T getPresenter();


}
