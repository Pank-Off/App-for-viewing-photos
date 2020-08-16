package com.popularlibrary.viewingphotos;

import com.popularlibrary.viewingphotos.test.TestPresenter;
import com.popularlibrary.viewingphotos.test.TestView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    private TestPresenter presenter;

    @Mock
    TestView testView;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
       // presenter = Mockito.spy(new TestPresenter(testView));
    }

    @Test
    public void getList_isCorrect(){
        //presenter.getList();
       Mockito.verify(testView,Mockito.times(1)).testMethod();
    }

}
