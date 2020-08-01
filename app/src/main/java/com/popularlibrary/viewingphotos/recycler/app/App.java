package com.popularlibrary.viewingphotos.recycler.app;

import android.app.Application;

import androidx.room.Room;


import com.popularlibrary.viewingphotos.recycler.model.room.AppDatabase;

public class App extends Application {

    private static AppDatabase appDatabase;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase =
                Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "room_database").build();
        appComponent = generateAppComponent();
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponent generateAppComponent(){
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
