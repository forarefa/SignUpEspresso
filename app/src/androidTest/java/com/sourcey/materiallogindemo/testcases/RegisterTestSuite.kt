package com.sourcey.materiallogindemo.testcases

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.sourcey.materiallogindemo.MainActivity
import com.sourcey.materiallogindemo.keywords.features.Register
import com.sourcey.materiallogindemo.utils.Regression
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class RegisterTestSuite {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    private val name = "Workshop Espresso"
    private val address = "East Building"
    private val email = "email@email.com"
    private val mobile = "0884808890"
    private val password = "a112233"
    private val confirmPassword = "a112233"

    private var userInfo = hashMapOf(
            "name" to name,
            "address" to address,
            "email" to email,
            "mobile" to mobile,
            "password" to password,
            "confirmPassword" to confirmPassword
    )

    @Test
    fun TC1001_RegisterSuccess() {
        Register.gotoRegisterScreenAndRegisterSuccess(
                name,
                address,
                email,
                mobile,
                password,
                confirmPassword)
    }

    @Regression
    @Test
    fun TC1001_RegisterSuccessV2() {
        Register.gotoRegisterScreenAndRegisterSuccessV2(userInfo)
    }

    @Test
    fun TC1002_RegisterFailWithEmptyName() {
        userInfo["name"] = ""
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyNameError("at least 3 characters")
    }

    @Test
    fun TC1003_RegisterFailWithNameLessthan3Cheracters() {
        userInfo["name"] = "Wo"
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyNameError("at least 3 characters")
    }

    @Test
    fun TC1004_RegisterFailWithEmptyAddress() {
        userInfo["address"] = ""
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyAddressError("Enter Valid Address")
    }

    @Test
    fun TC1005_RegisterFailWithInvalidAddress() {
        userInfo["email"] = "email@email"
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyEmailError("enter a valid email address")
    }

    @Test
    fun TC1006_RegisterFailWithEmptyEmail() {
        userInfo["email"] = ""
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyEmailError("enter a valid email address")
    }

    @Test
    fun TC1007_RegisterFailWithEmptyMobileNumber() {
        userInfo["mobile"] = ""
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyMobileError("Enter Valid Mobile Number")
    }

    @Test
    fun TC1008_RegisterFailMobileNumberLessThan10() {
        userInfo["mobile"] = "088777999"
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyMobileError("Enter Valid Mobile Number")
    }

    @Test
    fun TC1009_RegisterFailMobileNumberMoreThan10() {
        userInfo["mobile"] = "0887776666123"
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyMobileError("Enter Valid Mobile Number")
    }

    @Test
    fun TC1010_RegisterFailPasswordLessThan4() {
        userInfo["password"] = "a11"
        userInfo["confirmPassword"] = "a11"
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyPasswordError("between 4 and 10 alphanumeric characters")
    }

    @Test
    fun TC1011_RegisterFailPasswordMoreThan10() {
        userInfo["password"] = "a112233445566"
        userInfo["confirmPassword"] = "a112233445566"
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyPasswordError("between 4 and 10 alphanumeric characters")
    }

    @Test
    fun TC1012_RegisterFailEmptyConfirmPasswordNotMatch() {
        userInfo["password"] = "a112233"
        userInfo["confirmPassword"] = ""
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyConfirmPasswordError("Password Do not match")
    }

    @Test
    fun TC1013_RegisterFailConfirmPasswordLessThan4() {
        userInfo["password"] = "a112233"
        userInfo["confirmPassword"] = "aaa"
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyConfirmPasswordError("Password Do not match")
    }

    @Test
    fun TC1014_RegisterFailConfirmPasswordMoreThan10() {
        userInfo["password"] = "a112233"
        userInfo["confirmPassword"] = "a112233445566"
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyConfirmPasswordError("Password Do not match")
    }

    @Test
    fun TC1015_RegisterFailConfirmPasswordNotMatch() {
        userInfo["password"] = "a112233"
        userInfo["confirmPassword"] = "a1122"
        Register.gotoRegisterScreen()
        Register.enterRegisterInfoAndSignUpV2(userInfo)
        Register.verifyConfirmPasswordError("Password Do not match")
    }
}