package com.popularlibrary.viewingphotos.recycler.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.SkipStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showCount(int count);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showNumber(int number);

    @StateStrategyType(value = SkipStrategy.class)
    void updateRecyclerView();
}
