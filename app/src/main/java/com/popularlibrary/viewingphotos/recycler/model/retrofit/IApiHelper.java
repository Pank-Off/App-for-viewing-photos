package com.popularlibrary.viewingphotos.recycler.model.retrofit;

import com.google.gson.Gson;
import com.popularlibrary.viewingphotos.recycler.app.App;
import com.popularlibrary.viewingphotos.recycler.model.entity.Photo;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IApiHelper {
    private static final String URL = "https://pixabay.com";
    private static final String KEY = "17884563-fb94ad5dba4068f6c2ac360c3";

    @Inject
    Gson gson;

    public Observable<Photo> requestServer() {
        App.getAppComponent().inject(this);
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
        //http://pixabay.com/api/?key=17884563-fb94ad5dba4068f6c2ac360c3
        IApiService api = new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(IApiService.class);

        return api.getPhoto(KEY).subscribeOn(Schedulers.io());
    }
}
