package com.popularlibrary.viewingphotos.mockito;

import com.popularlibrary.viewingphotos.recycler.presenter.MainPresenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RoomTest {

    @Mock
    MainPresenter mainPresenter;

    @Test
    public void updateRecyclerView_isVerify(){
        Mockito.verify(mainPresenter).getRecyclerMain();
    }
}
