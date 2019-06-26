package com.jhwang73.alarmix;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    @Rule
    public final ActivityTestRule<MainActivity> main = new
            ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testMainView() {
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()));
    }

    @Test
    public void testBottomNavigation() {
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()));
    }

    @Test
    public void testFragmentContainer() {
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
    }
}