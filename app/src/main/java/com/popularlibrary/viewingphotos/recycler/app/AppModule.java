package com.popularlibrary.viewingphotos.recycler.app;

import android.app.Application;

import com.popularlibrary.viewingphotos.dagger.Green;
import com.popularlibrary.viewingphotos.recycler.model.retrofit.IApiHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    final Application application;

    AppModule(Application application){
        this.application = application;
    }

    @Singleton
    @Provides
    IApiHelper provideOne() {
        return new IApiHelper();
    }
}
