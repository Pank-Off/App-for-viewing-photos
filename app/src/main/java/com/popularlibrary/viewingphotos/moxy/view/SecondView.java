package com.popularlibrary.viewingphotos.moxy.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface SecondView extends MvpView {
    @StateStrategyType(value = AddToEndStrategy.class)
    void setTextFromEditText(String text);
}
