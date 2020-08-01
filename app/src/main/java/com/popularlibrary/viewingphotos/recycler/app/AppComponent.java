package com.popularlibrary.viewingphotos.recycler.app;

import com.popularlibrary.viewingphotos.recycler.model.retrofit.IApiHelper;
import com.popularlibrary.viewingphotos.recycler.presenter.DetailPresenter;
import com.popularlibrary.viewingphotos.recycler.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainPresenter mainPresenter);
    void inject(DetailPresenter detailPresenter);
}
