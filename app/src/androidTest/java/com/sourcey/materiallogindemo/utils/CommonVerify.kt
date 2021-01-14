package com.sourcey.materiallogindemo.utils

import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers

fun verifyToastMessage(text: String, tActivity: Activity) {
    onView(withText(text))
            .inRoot(RootMatchers.withDecorView(Matchers.not((tActivity.window.decorView))))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}