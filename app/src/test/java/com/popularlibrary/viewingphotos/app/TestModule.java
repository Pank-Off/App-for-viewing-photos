package com.popularlibrary.viewingphotos.app;

import com.popularlibrary.viewingphotos.recycler.model.retrofit.IApiHelper;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {
    @Provides
    public IApiHelper provideRetrofitApi(){
        return Mockito.mock(IApiHelper.class);
    }
}