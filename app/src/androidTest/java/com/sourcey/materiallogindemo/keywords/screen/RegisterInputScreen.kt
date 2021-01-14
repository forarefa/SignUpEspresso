package com.sourcey.materiallogindemo.keywords.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.sourcey.materiallogindemo.R

class RegisterInputScreen {
    private val inputName = onView(withId(R.id.input_name))
    private val inputAddress = onView(withId(R.id.input_address))
    private val inputEmail = onView(withId(R.id.input_email))
    private val inputMobile = onView(withId(R.id.input_mobile))
    private val inputPassword = onView(withId(R.id.input_password))
    private val inputConfirmPassword = onView(withId(R.id.input_reEnterPassword))
    private val btnSubmit = onView(withId(R.id.btn_signup))

    fun iEnterName(text:String) {
        inputName.perform(typeText(text), pressImeActionButton())
    }

    fun iEnterAddress(text:String) {
        inputAddress.perform(typeText(text), pressImeActionButton())
    }

    fun iEnterEmail(text:String) {
        inputEmail.perform(typeText(text), pressImeActionButton())
    }

    fun iEnterMobile(text:String) {
        inputMobile.perform(typeText(text), pressImeActionButton())
    }

    fun iEnterPassword(text:String) {
        inputPassword.perform(typeText(text), pressImeActionButton())
    }

    fun iEnterConfirmPassword(text:String) {
        inputConfirmPassword.perform(typeText(text), pressImeActionButton())
    }

    fun iClickSubmit() {
        btnSubmit.perform(click())
    }
}