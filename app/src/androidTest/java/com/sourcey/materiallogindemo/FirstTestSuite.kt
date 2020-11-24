package com.sourcey.materiallogindemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//class FirstTestSuite {
//    @get:Rule
//    val activityRule = ActivityTestRule(MainActivity::class.java)
//
//    @Test
//    fun test01() {
//        onView(withText("LOGIN")).check(matches(isDisplayed()))
//    }
//}

@RunWith(AndroidJUnit4::class)
@LargeTest
class FirstTestSuite {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test01() {
        onView(withText("LOGIN")).check(matches(isDisplayed()))
    }
}
