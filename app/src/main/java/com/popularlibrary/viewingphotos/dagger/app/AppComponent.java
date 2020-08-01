package com.popularlibrary.viewingphotos.dagger.app;

import com.popularlibrary.viewingphotos.dagger.DaggerActivity;
import com.popularlibrary.viewingphotos.dagger.Red;
import com.popularlibrary.viewingphotos.dagger.White;
import com.popularlibrary.viewingphotos.recycler.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DaggerActivity daggerActivity);

    void inject(Red red);

    void inject(White white);
}
