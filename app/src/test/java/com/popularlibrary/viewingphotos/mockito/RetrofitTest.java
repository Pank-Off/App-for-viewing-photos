package com.popularlibrary.viewingphotos.mockito;

import com.popularlibrary.viewingphotos.app.TestComponent;
import com.popularlibrary.viewingphotos.app.TestModule;
import com.popularlibrary.viewingphotos.recycler.model.retrofit.IApiHelper;
import com.popularlibrary.viewingphotos.recycler.model.room.Image;
import com.popularlibrary.viewingphotos.recycler.presenter.MainPresenter;
import com.popularlibrary.viewingphotos.recycler.view.MainView;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class RetrofitTest {

    private MainPresenter presenter;

    @Mock
    MainView mainView;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                __ -> Schedulers.trampoline());
    }

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        presenter = Mockito.spy(new MainPresenter());
    }

    @Test
    public void getCorrectAnswer(){
//        TestComponent component = DaggerTestComponent.builder()
//                .testModule(new TestModule() {
//
//                    @Override
//                    public IApiHelper provideRetrofitApi() {
//                        IApiHelper retrofitApi = super.provideRetrofitApi();
//                        Image image = new Image();
//                        image.URL = "www.test.com";
//                        Mockito.when(retrofitApi.requestServer()).thenReturn(Observable.just(image));
//                        return retrofitApi;
//                    }
//                }).build();
//        component.inject(presenter);
//        presenter.attachView(mainView);

    }
}
