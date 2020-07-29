package com.popularlibrary.viewingphotos.room;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

class RoomPresenter {

    private static final String TAG = "RoomPresenter";
    private UserDao userDao;
    RoomPresenter(){
        userDao = App.getAppDatabase().userDao();
    }

   void putData(){
        User user = new User("Kirill", "Pankov", 23);
       Disposable disposable = userDao.insert(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
               .subscribe(id->{
                   Log.d(TAG, "putData: " + id);
               }, throwable -> {
                   Log.d(TAG, "putData: " + throwable);
               });
    }
    void deleteData(){
        User user = new User();
        user.id = 2;
        Disposable disposable = userDao.delete(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "deleteData: " + id);
                }, throwable -> {
                    Log.d(TAG, "deleteData: " + throwable);
                });
    }
    void updateData(){
        User user = new User("Kosta", "Voronin", 33);
        user.id = 1;
        Disposable disposable = userDao.update(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(users->{
                    Log.d(TAG, "updateData: " + users + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "updateData: " + throwable);
                });
    }

    void getData(){
        Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    Log.d(TAG, "getData: " + users + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "getData: " + throwable);
                });
    }
}
