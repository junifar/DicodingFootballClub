package com.rubahapi.footballclub.main

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.R.id.add_to_favorite
import com.rubahapi.footballclub.R.id.list_league
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @Rule
    @JvmField var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testRecyclerViewBehaviour() {
        Espresso.onView(ViewMatchers.withId(list_league))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(list_league)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        Espresso.onView(ViewMatchers.withId(list_league)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, ViewActions.click()))
    }

    @Test
    fun testMainActivityBehaviour(){
        onView(withText("English Premier League")).perform(click())

        onView(ViewMatchers.withId(R.id.last_match_recycler)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
            .check(matches(isDisplayed()))
        onView(ViewMatchers.withId(R.id.last_match_recycler)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, ViewActions.click()))

        onView(withId(add_to_favorite)).check(matches(isDisplayed()))
        onView(withId(add_to_favorite)).perform(click())

        pressBack()
        onView(withId(navigation))
            .check(matches(isDisplayed()))
        onView(withId(navigation_favorite)).perform(click())


//        onView(withText("Chelsea")).check(matches(isDisplayed()))
//        onView(withText("Chelsea")).perform(click())

//        onView(withText("Chelsea 3 VS 1 Crystal Palace")).perform(click())
//        onView(withId(add_to_favorite)).check(matches(isDisplayed()))
//        onView(withId(add_to_favorite)).perform(click())
//        pressBack()
//        pressBack()
    }
}