package com.kelvindegrez.parentheartteacher.mvp;

public interface MvpPresenter<V extends MvpView, M extends MvpModel> {

    void attachView(V view);

    void detachView(boolean retainInstance);

    public boolean isViewAttached();

    void attachModel(M model);
}

