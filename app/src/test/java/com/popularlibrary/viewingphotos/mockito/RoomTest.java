package com.popularlibrary.viewingphotos.mockito;

import com.popularlibrary.viewingphotos.recycler.model.room.Image;
import com.popularlibrary.viewingphotos.recycler.model.room.ImgDao;
import com.popularlibrary.viewingphotos.recycler.presenter.MainPresenter;
import com.popularlibrary.viewingphotos.recycler.view.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;

@RunWith(MockitoJUnitRunner.class)
public class RoomTest {

    @Mock
    MainPresenter mainPresenter;

    @Mock
    MainActivity mainActivity;

    @Mock
    ImgDao img;

//    @Test
//    public void updateRecyclerView_isVerify(){
//        Mockito.verify(mainPresenter).getRecyclerMain();
//    }

    @Test
    public void getData() {
        //Mockito.verify(mainPresenter).setOnItemClickListener(Mockito.any());
        Image image = new Image();
      //  Mockito.when(img.delete(image)).thenReturn(Observable.just(image));
        Mockito.verify(mainActivity).showNumber(1);
    }
}
