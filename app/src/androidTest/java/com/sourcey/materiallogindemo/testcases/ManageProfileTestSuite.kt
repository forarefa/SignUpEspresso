package com.sourcey.materiallogindemo.testcases

import androidx.test.rule.ActivityTestRule
import com.sourcey.materiallogindemo.MainActivity
import com.sourcey.materiallogindemo.keywords.features.ManageProfileInfo
import com.sourcey.materiallogindemo.keywords.features.Register
import org.junit.Rule
import org.junit.Test

class ManageProfileTestSuite {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun TC3001_UpdateProfileSuccess() {
        val userInfo = hashMapOf(
                "name" to "abc",
                "address" to "abcd",
                "email" to "email@email.com",
                "mobile" to "0886056051",
                "password" to "999999",
                "confirmPassword" to "999999"
        )

        val userInfoNew = hashMapOf(
                "name" to "accb",
                "address" to "222/111 Bangkok 10900",
                "email" to "email@email.com",
                "mobile" to "0886056051",
                "password" to "999999",
                "confirmPassword" to "999999"
        )

        Register.gotoRegisterScreenAndRegisterSuccessV2(userInfo)
        ManageProfileInfo.apply {
            gotoUpdateProfileScreen()
            enterProfileInfo2(userInfoNew)
            clickSaveUpdateProfile()
            verifyProfileInfo2(userInfoNew)
        }
    }
}