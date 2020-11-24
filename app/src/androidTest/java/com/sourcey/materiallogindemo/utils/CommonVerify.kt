package com.sourcey.materiallogindemo.utils

import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.sourcey.materiallogindemo.MainActivity
import org.hamcrest.Matchers.not

fun verifyToast(toastText: String, activityRule: ActivityTestRule<MainActivity>) {
    onView(withText(toastText))
            .inRoot(withDecorView(not(activityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))
}

fun verifyToast2(toastText: String, activity: Activity) {
    onView(withText(toastText))
            .inRoot(withDecorView(not(activity.window.decorView)))
            .check(matches(isDisplayed()))
}
