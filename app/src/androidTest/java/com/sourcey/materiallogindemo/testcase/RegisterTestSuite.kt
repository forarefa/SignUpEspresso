package com.sourcey.materiallogindemo.testcase

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
import com.sourcey.materiallogindemo.keywords.featrue.LoginFeature
import com.sourcey.materiallogindemo.keywords.featrue.ManageProfile
import com.sourcey.materiallogindemo.keywords.featrue.RegisterFeature
import com.sourcey.materiallogindemo.utils.verifyToastMessage
import com.sourcey.materiallogindemo.utils.waitForElementToAppear
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test

class RegisterTestSuite {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val tActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun tc001RegisterSuccess() {
        val name = "kanittha"
        val address = "50/123"
        val email = "email@email.com"
        val mobile = "0998889999"
        val password = "112233"

        LoginFeature().gotoRegisterInput()
        RegisterFeature().apply {
            enterRegisterInfo(name, address, email, mobile, password, password)
            submit()
        }
        ManageProfile().verifyProfileInfo(name, address, email, mobile)
//        onView(withId(R.id.link_signup)).perform(click())
//        onView(withId(R.id.input_name)).perform(typeText(name))
//        onView(withId(R.id.input_address)).perform(typeText(address), pressImeActionButton())
//        onView(withId(R.id.input_email)).perform(typeText(email))
//        onView(withId(R.id.input_mobile)).perform(scrollTo(), typeText(mobile))
//        Espresso.closeSoftKeyboard()
//        onView(withId(R.id.input_password)).perform(typeText(password))
//        onView(withId(R.id.input_reEnterPassword)).perform(scrollTo(), typeText(password), closeSoftKeyboard())
//        onView(withId(R.id.btn_signup)).perform(click())
//        val txtWelcome = onView(withText("Welcome!"))
//        waitForElementToAppear(txtWelcome)
//        txtWelcome.check(matches(isDisplayed()))
//
//        onView(withText(email)).check(matches(isDisplayed()))
//        onView(allOf(withContentDescription("info-name"), withText(name))).check(matches(isDisplayed()))
//        onView(withContentDescription("info-name")).check(matches(allOf(isDisplayed(), withText(name))))
//
//        onView(allOf(hasSibling(withText("Name")), withText(name))).check(matches(isDisplayed()))
//        onView(allOf(hasSibling(withText("Name")), withParentIndex(1))).check(matches(allOf(isDisplayed(), withText(name))))
//
//        onView(allOf(withParent(withId(R.id.rowName)), withParentIndex(1))).check(matches(allOf(isDisplayed(), withText(name))))
//
//        onView(allOf(withText(name), withParent(withId(R.id.rowName)))).check(matches(isDisplayed()))
//        onView(allOf(withId(R.id.rowName))).check(matches(withChild(withText(name))))
//        onView(allOf(withId(R.id.rowName))).check(matches(withChild(allOf(withClassName(endsWith("TextView")), withText(name)))))
//
//        onView(withContentDescription("info-email")).check(matches(allOf(isDisplayed(), withText(email))))
//        onView(withContentDescription("info-address")).check(matches(allOf(isDisplayed(), withText(address))))
//        onView(withContentDescription("info-mobile")).check(matches(allOf(isDisplayed(), withText(mobile))))
    }

    @Test
    fun tc002RegisterInvalidMobile() {
        val name = "kanittha"
        val address = "50/123"
        val email = "email@email.com"
        val mobile = "098111222"
        val password = "112233"

        LoginFeature().gotoRegisterInput()
        RegisterFeature().apply {
            enterRegisterInfo(name, address, email, mobile, password, password)
            submit()
        }

        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")))

                //        onView(withText("Login failed"))
//                .inRoot(withDecorView(not((tActivityRule.activity.window.decorView))))
//                .check(matches(isDisplayed()))

        verifyToastMessage("Login failed", tActivityRule.activity)
    }

    @Test
    fun tc003UpdateProfileSuccess() {
        val name = "kanittha"
        val address = "50/123"
        val email = "email@email.com"
        val mobile = "0998889999"
        val password = "112233"

        val newName = "Peter"
        val newEmail = "newemail@email.com"
        val newAddress = "New Address 22/33"
        val newMobile = "0887878890"

        onView(withId(R.id.link_signup)).perform(click())
        onView(withId(R.id.input_name)).perform(typeText(name))
        onView(withId(R.id.input_address)).perform(typeText(address), pressImeActionButton())
        onView(withId(R.id.input_email)).perform(typeText(email))
        onView(withId(R.id.input_mobile)).perform(scrollTo(), typeText(mobile))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.input_password)).perform(typeText(password))
        onView(withId(R.id.input_reEnterPassword)).perform(scrollTo(), typeText(password), closeSoftKeyboard())
        onView(withId(R.id.btn_signup)).perform(click())

        val txtWelcome = onView(withText("Welcome!"))
        waitForElementToAppear(txtWelcome)
        txtWelcome.check(matches(isDisplayed()))

        onView(withContentDescription("info-name")).check(matches(allOf(isDisplayed(), withText(name))))
        onView(withContentDescription("info-email")).check(matches(allOf(isDisplayed(), withText(email))))
        onView(withContentDescription("info-address")).check(matches(allOf(isDisplayed(), withText(address))))
        onView(withContentDescription("info-mobile")).check(matches(allOf(isDisplayed(), withText(mobile))))

        // goto edit screen
        val btnMoreOption = onView(withContentDescription("More options"))
        waitForElementToAppear(btnMoreOption)
        btnMoreOption.perform(click())

        val btnUpdate = onView(withText("Update Profiles"))
        waitForElementToAppear(btnUpdate)
        btnUpdate.perform(click())

        waitForElementToAppear(onView(withText(R.string.menu_edit_profile)))
        onView(withText(R.string.menu_edit_profile)).check(matches(isDisplayed()))

        // enter update info
        onView(allOf(hasSibling(withText("Name")), withClassName(endsWith("EditText")))).perform(clearText(), typeText(newName))
        onView(allOf(hasSibling(withText("Email")), withClassName(endsWith("EditText")))).perform(clearText(), typeText(newEmail))
        onView(allOf(hasSibling(withText("Address")), withParentIndex(1))).perform(replaceText(newAddress))
        onView(allOf(hasSibling(withText("Mobile")), withClassName(endsWith("EditText")))).perform(replaceText(newMobile))
        onView(withId(R.id.btn_update_profiles)).perform(click())

        // verify profile after update
        waitForElementToAppear(onView(withText("User Information")))
        onView(withContentDescription("info-name")).check(matches(allOf(isDisplayed(), withText(newName))))
        onView(withContentDescription("info-email")).check(matches(allOf(isDisplayed(), withText(newEmail))))
        onView(withContentDescription("info-address")).check(matches(allOf(isDisplayed(), withText(newAddress))))
        onView(withContentDescription("info-mobile")).check(matches(allOf(isDisplayed(), withText(newMobile))))
    }
}