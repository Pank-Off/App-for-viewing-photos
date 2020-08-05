package com.popularlibrary.viewingphotos.espresso;

import androidx.test.rule.ActivityTestRule;

import com.popularlibrary.viewingphotos.R;
import com.popularlibrary.viewingphotos.espressotest.EspressoTestActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class EspressoTest {
    @Rule
    public ActivityTestRule<EspressoTestActivity> activityRule = new ActivityTestRule<>(EspressoTestActivity.class);

    @Test
    public void onClick(){
        onView(withId(R.id.test_button)).perform(click());
        onView(withId(R.id.test_textView)).check(matches(withText("Test passed")));
    }
}
