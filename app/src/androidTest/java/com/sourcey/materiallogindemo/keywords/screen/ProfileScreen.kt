package com.sourcey.materiallogindemo.keywords.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.sourcey.materiallogindemo.utils.waitForElementToAppear
import org.hamcrest.Matchers.allOf

class ProfileScreen {
    private val btnMoreOption = onView(withContentDescription("More options"))
    private val btnUpdate = onView(withText("Update Profiles"))
    private val txtWelcome = onView(withText("Welcome!"))
    private val userName = onView(withContentDescription("info-name"))
    private val userEmail = onView(withContentDescription("info-email"))
    private val userAddress = onView(withContentDescription("info-address"))
    private val userMobile = onView(withContentDescription("info-mobile"))

    fun iCanSeeProfileScreen() {
        waitForElementToAppear(txtWelcome)
        txtWelcome.check(matches(isDisplayed()))
    }

    fun iVerifyName(txt: String) {
        userName.check(matches(allOf(isDisplayed(), withText(txt))))
    }

    fun iVerifyEmail(txt: String) {
        userEmail.check(matches(allOf(isDisplayed(), withText(txt))))
    }

    fun iVerifyAddress(txt: String) {
        userAddress.check(matches(allOf(isDisplayed(), withText(txt))))
    }

    fun iVerifyMobile(txt: String) {
        userMobile.check(matches(allOf(isDisplayed(), withText(txt))))
    }

    fun iClickMoreOption() {
        waitForElementToAppear(btnMoreOption)
        btnMoreOption.perform(click())
    }

    fun iClickUpdateProfile() {
        waitForElementToAppear(btnUpdate)
        btnUpdate.perform(click())
    }
}