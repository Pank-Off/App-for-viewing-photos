package com.popularlibrary.viewingphotos.app;

import com.popularlibrary.viewingphotos.recycler.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent {
    void inject(MainPresenter presenter);

}
