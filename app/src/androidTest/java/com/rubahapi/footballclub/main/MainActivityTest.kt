package com.rubahapi.footballclub.main

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @Rule
    @JvmField var activityRule = ActivityTestRule(MainActivity::class.java)

//    @Test
//    fun testRecyclerViewBehaviour() {
//        Espresso.onView(ViewMatchers.withId(list_team))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(ViewMatchers.withId(list_team)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
//        Espresso.onView(ViewMatchers.withId(list_team)).perform(
//            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, ViewActions.click()))
//    }
}