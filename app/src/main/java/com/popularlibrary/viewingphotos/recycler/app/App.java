package com.popularlibrary.viewingphotos.recycler.app;

import android.app.Application;

import androidx.room.Room;

import com.popularlibrary.viewingphotos.recycler.model.room.AppDatabase;
import com.squareup.leakcanary.LeakCanary;

public class App extends Application {

    private static AppDatabase appDatabase;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initLeakCanary();
        appDatabase = generateAppDataBase();

        appComponent = generateAppComponent();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private AppDatabase generateAppDataBase() {
        return Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_database").build();
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponent generateAppComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
