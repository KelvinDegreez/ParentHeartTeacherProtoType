package com.kelvindegrez.parentheartteacher.impl.Splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.kelvindegrez.parentheartteacher.R;
import com.kelvindegrez.parentheartteacher.dagger2.MainApp;
import com.kelvindegrez.parentheartteacher.mvp.Screen;
import com.kelvindegrez.parentheartteacher.mvp.Splash.SplashPresenter;
import com.kelvindegrez.parentheartteacher.mvp.Splash.SplashView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenView extends AppCompatActivity implements SplashView {

    SplashPresenter presenter;

    @BindView(R.id.splash_logo) ImageView splashLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        setPresenter(MainApp.getDaggerComponent().provideSplashPresenter());
    }


    @Override
    public void navigateToScreen(Screen screen) {
        YoYo.with(Techniques.RubberBand)
                .duration(1000)
                .playOn(splashLogo);
        presenter.loadData();
    }

    @Override
    protected void onStart() {
        presenter.attachView(this);
        presenter.loadData();
        super.onStart();
    }

    @Override
    protected void onStop() {
        presenter.detachView(false);
        super.onStop();
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
