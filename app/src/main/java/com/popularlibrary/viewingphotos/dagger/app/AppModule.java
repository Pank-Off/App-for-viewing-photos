package com.popularlibrary.viewingphotos.dagger.app;

import android.app.Application;

import com.popularlibrary.viewingphotos.dagger.Green;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Green provideOne() {
        return new Green();
    }

}
