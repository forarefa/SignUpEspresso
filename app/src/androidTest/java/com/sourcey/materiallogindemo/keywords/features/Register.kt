package com.sourcey.materiallogindemo.keywords.features

import com.sourcey.materiallogindemo.keywords.screens.LoginScreen
import com.sourcey.materiallogindemo.keywords.screens.RegisterScreen

object Register {
    private val loginScreen by lazy { LoginScreen() }
    private val registerScreen by lazy { RegisterScreen() }

    fun gotoRegisterScreen() {
        loginScreen.iClickBtnRegister()
        registerScreen.iCanSeeRegisterScreen()
    }

    fun enterRegisterInfoAndSignUp(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        registerScreen.apply {
            iEnterName(name)
            iEnterAddress(address)
            iEnterEmail(email)
            iEnterMobileNumber(mobile)
            iEnterPassword(password)
            iEnterConfirmPassword(confirmPassword)
            iClickBtnSignUp()
        }
    }

    fun enterRegisterInfoAndSignUpV2(registerData: Map<String, String>) {
        registerScreen.apply{
            iEnterName(registerData.getValue("name"))
            iEnterAddress(registerData.getValue("address"))
            iEnterEmail(registerData.getValue("email"))
            iEnterMobileNumber(registerData.getValue("mobile"))
            iEnterPassword(registerData.getValue("password"))
            iEnterConfirmPassword(registerData.getValue("confirmPassword"))
            iClickBtnSignUp()
        }
    }

    fun gotoRegisterScreenAndRegisterSuccess(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        gotoRegisterScreen()
        enterRegisterInfoAndSignUp(name, address, email, mobile, password, confirmPassword)
        ManageProfileInfo.verifyProfileInfo(name, address, email, mobile)
    }

    fun gotoRegisterScreenAndRegisterSuccessV2(userInfo: Map<String, String>) {
        gotoRegisterScreen()
        enterRegisterInfoAndSignUpV2(userInfo)
        ManageProfileInfo.verifyProfileInfo(
                userInfo.getValue("name"), userInfo.getValue("address"), userInfo.getValue("email"), userInfo.getValue("mobile"))
    }

    fun verifyNameError(errorMessage: String?) {
        registerScreen.iVerifyNameError(errorMessage)
    }

    fun verifyAddressError(errorMessage: String?) {
        registerScreen.iVerifyAddressError(errorMessage)
    }

    fun verifyEmailError(errorMessage: String?) {
        registerScreen.iVerifyEmailError(errorMessage)
    }

    fun verifyMobileError(errorMessage: String?) {
        registerScreen.iVerifyMobileError(errorMessage)
    }

    fun verifyPasswordError(errorMessage: String?) {
        registerScreen.iVerifyPasswordError(errorMessage)
    }

    fun verifyConfirmPasswordError(errorMessage: String?) {
        registerScreen.iVerifyConfirmPasswordError(errorMessage)
    }
}