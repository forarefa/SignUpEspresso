package com.sourcey.materiallogindemo.keywords.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.sourcey.materiallogindemo.R

class LoginScreen {

    private val btnSignUp = onView(withId(R.id.link_signup))

    fun iClickBtnSignUp() {
        btnSignUp.perform(click())
    }
}