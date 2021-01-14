package com.sourcey.materiallogindemo.testcases

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.ActivityTestRule
import com.sourcey.materiallogindemo.MainActivity
import com.sourcey.materiallogindemo.R
import com.sourcey.materiallogindemo.utils.waitForElementToAppear
import org.hamcrest.CoreMatchers.endsWith
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test

class Register2TestSuite {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val tActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun tc001RegisterSuccess() {
        val name: String = "supagid"
        val address: String = "5/94"
        val email: String = "g.supagid@gmail.com"
        val mobile: String = "0830068916"
        val password: String = "Iambig001"

        onView(withId(R.id.link_signup)).perform(click())
        onView(withId(R.id.input_name)).perform(typeText(name),closeSoftKeyboard())
        onView(withId(R.id.input_address)).perform(typeText(address),closeSoftKeyboard())
        onView(withId(R.id.input_email)).perform(typeText(email),closeSoftKeyboard())
        onView(withId(R.id.input_mobile)).perform(typeText(mobile),closeSoftKeyboard())
        onView(withId(R.id.input_password)).perform(typeText(password),closeSoftKeyboard())
        onView(withId(R.id.input_reEnterPassword)).perform(typeText(password),closeSoftKeyboard())
        //Espresso.closeSoftKeyboard()
        onView(withId(R.id.btn_signup)).perform(click())
        Thread.sleep(3000)
        val txtWelcome = onView(withText("Welcome"))
        waitForElementToAppear(txtWelcome)
        onView(allOf(withContentDescription("info-name"), withText(name))).check(matches(isDisplayed()))
        onView(allOf(withContentDescription("info-address"), withText(address))).check(matches(isDisplayed()))
        onView(allOf(withContentDescription("info-email"), withText(email))).check(matches(isDisplayed()))
        onView(allOf(withContentDescription("info-mobile"), withText(mobile))).check(matches(isDisplayed()))

        onView(allOf(withContentDescription("info-name"), withText(name))).check(matches(isDisplayed()))
        onView(withContentDescription("info-name")).check(matches(allOf(isDisplayed(), withText(name))))
        onView(allOf(hasSibling(withText("Name")), withText(name))).check(matches(isDisplayed()))
        onView(allOf(hasSibling(withText("Name")), withParentIndex(1))).check(matches(allOf(isDisplayed(), withText(name))))
        onView(allOf(withParent(withId(R.id.rowName)), withParentIndex(1))).check(matches(allOf(isDisplayed(), withText(name))))
        onView(allOf(withText(name), withParent(withId(R.id.rowName)))).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.rowName))).check(matches(withChild(withText(name))))
        onView(allOf(withId(R.id.rowName))).check(matches(withChild(allOf(withClassName(endsWith("TextView")), withText(name)))))
        onView(withContentDescription("info-email")).check(matches(allOf(isDisplayed(), withText(email))))
        onView(withContentDescription("info-address")).check(matches(allOf(isDisplayed(), withText(address))))
        onView(withContentDescription("info-mobile")).check(matches(allOf(isDisplayed(), withText(mobile))))
    }

    @Test
    fun tc002RegisterFail() {
        val name: String = "supagid"
        val address: String = "5/94"
        val email: String = "g.supagid@gmail.com"
        val mobile: String = "165656656564"
        val password: String = "Iambig001"
        onView(withId(R.id.link_signup)).perform(click())
        onView(withId(R.id.input_name)).perform(typeText(name),closeSoftKeyboard())
        onView(withId(R.id.input_address)).perform(typeText(address),closeSoftKeyboard())
        onView(withId(R.id.input_email)).perform(typeText(email),closeSoftKeyboard())
        onView(withId(R.id.input_mobile)).perform(typeText(mobile),closeSoftKeyboard())
        onView(withId(R.id.input_password)).perform(typeText(password),closeSoftKeyboard())
        onView(withId(R.id.input_reEnterPassword)).perform(typeText(password),closeSoftKeyboard())
        onView(withId(R.id.btn_signup)).perform(click())
        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")))
        onView(withText("Login failed"))
                .inRoot(withDecorView(not((tActivityRule.activity.window.decorView))))
                .check(matches(isDisplayed()))
    }

    @Test
    fun tc003UpdateSuccess() {
        val name: String = "supagid"
        val address: String = "5/94"
        val email: String = "g.supagid@gmail.com"
        val mobile: String = "0830068916"
        val password: String = "Iambig001"
        val name2: String = "supagid2"
        val email2: String = "g.supagid2@gmail.com"
        val address2: String = "5/942"
        val mobile2: String = "0830068912"
        val txtWelcome = onView(withText("Welcome"))

        onView(withId(R.id.link_signup)).perform(click())
        onView(withId(R.id.input_name)).perform(typeText(name),closeSoftKeyboard())
        onView(withId(R.id.input_address)).perform(typeText(address),closeSoftKeyboard())
        onView(withId(R.id.input_email)).perform(typeText(email),closeSoftKeyboard())
        onView(withId(R.id.input_mobile)).perform(typeText(mobile),closeSoftKeyboard())
        onView(withId(R.id.input_password)).perform(typeText(password),closeSoftKeyboard())
        onView(withId(R.id.input_reEnterPassword)).perform(typeText(password),closeSoftKeyboard())
        onView(withId(R.id.btn_signup)).perform(click())

        waitForElementToAppear(txtWelcome)

        onView(allOf(withContentDescription("info-name"), withText(name))).check(matches(isDisplayed()))
        onView(allOf(withContentDescription("info-address"), withText(address))).check(matches(isDisplayed()))
        onView(allOf(withContentDescription("info-email"), withText(email))).check(matches(isDisplayed()))
        onView(allOf(withContentDescription("info-mobile"), withText(mobile))).check(matches(isDisplayed()))

        onView(withContentDescription("More options")).perform(click())
        onView(withText("Update Profiles")).perform(click())

        onView(allOf(hasSibling(withText("Name")), withText(name))).perform(replaceText(name2))
        onView(allOf(hasSibling(withText("Email")), withText(email))).perform(replaceText(email2))
        onView(allOf(hasSibling(withText("Address")), withText(address))).perform(replaceText(address2))
        onView(allOf(hasSibling(withText("Mobile")), withText(mobile))).perform(replaceText(mobile2))
        onView(withText("SAVE")).perform(click())

        waitForElementToAppear(txtWelcome)

        onView(allOf(withContentDescription("info-name"), withText(name2))).check(matches(isDisplayed()))
        onView(allOf(withContentDescription("info-address"), withText(address2))).check(matches(isDisplayed()))
        onView(allOf(withContentDescription("info-email"), withText(email2))).check(matches(isDisplayed()))
        onView(allOf(withContentDescription("info-mobile"), withText(mobile2))).check(matches(isDisplayed()))
    }
}

