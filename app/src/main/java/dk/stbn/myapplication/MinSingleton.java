package dk.stbn.myapplication;

import android.app.Application;

public class MinSingleton extends Application {

    static MinSingleton app;

    GætTal spil;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("hej fra singleton");
        app = this;
        spil = new GætTal();
    }
}
