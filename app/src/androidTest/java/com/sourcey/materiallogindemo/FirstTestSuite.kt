package com.sourcey.materiallogindemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class FirstTestSuite {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun firstTest() {
//        onView(withId(R.id.btn_login)).check(matches(isDisplayed()))
        onView(withText("LOGINxxxxx")).check(matches(isDisplayed()))
    }
}
