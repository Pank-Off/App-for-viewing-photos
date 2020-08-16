package com.popularlibrary.viewingphotos.recycler.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface DetailView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showNumber(int number);

}
