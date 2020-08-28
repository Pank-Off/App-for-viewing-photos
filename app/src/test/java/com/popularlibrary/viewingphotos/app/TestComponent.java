package com.popularlibrary.viewingphotos.app;

import com.popularlibrary.viewingphotos.PresenterTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent {
    void inject(PresenterTest presenter);
}
