package com.kelvindegrez.parentheartteacher.dagger2;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import com.kelvindegrez.parentheartteacher.impl.home.HomeScreenView;
import com.kelvindegrez.parentheartteacher.impl.splash.SplashScreenView;
import com.kelvindegrez.parentheartteacher.mvp.Screen;

import java.util.HashMap;
import java.util.Map;


public class MainApp extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getDaggerComponent(){return component;}

    //TODO: This can be moved later to be handled by some manager that handles logic for navigation
    public static void navigateToScreen(Activity activity, Screen screen) {
        Class navScreen = MainApp.ScreenClassMap.get(screen);
        if (navScreen != null) {
            Intent intent = new Intent(activity, navScreen);
            intent.putExtra("intent_key_screen_name", screen.toString());
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public static final Map<Screen, Class> ScreenClassMap;
    static
    {
        ScreenClassMap = new HashMap<>();
        ScreenClassMap.put(Screen.Splash, SplashScreenView.class);
        ScreenClassMap.put(Screen.Home, HomeScreenView.class);

    }

}
