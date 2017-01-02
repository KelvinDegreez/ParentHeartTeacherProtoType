package com.kelvindegrez.parentheartteacher.mvp;

public interface MvpModel<T extends MvpPresenter> {

    void setPresenter(T presenter);

    T getPresenter();

}
