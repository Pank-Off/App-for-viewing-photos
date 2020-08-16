package com.popularlibrary.viewingphotos.recycler.app;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.popularlibrary.viewingphotos.recycler.model.Model;
import com.popularlibrary.viewingphotos.recycler.model.retrofit.IApiHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    private final Application application;

    AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    IApiHelper provideOne() {
        return new IApiHelper();
    }

    @Singleton
    @Provides
    Model provideTwo() {
        return new Model();
    }

    @Singleton
    @Provides
    Gson provideThree() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

}
