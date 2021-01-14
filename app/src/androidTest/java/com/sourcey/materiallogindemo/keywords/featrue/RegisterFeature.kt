package com.sourcey.materiallogindemo.keywords.featrue

import com.sourcey.materiallogindemo.keywords.screen.RegisterInputScreen

class RegisterFeature {

    private val registerInputScreen = RegisterInputScreen()

    fun enterRegisterInfo(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        registerInputScreen.apply {
            iEnterName(name)
            iEnterAddress(address)
            iEnterEmail(email)
            iEnterMobile(mobile)
            iEnterPassword(password)
            iEnterConfirmPassword(confirmPassword)
        }
    }

    fun submit() {
        registerInputScreen.iClickSubmit()
    }

    fun registerSuccess(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        LoginFeature().gotoRegisterInput()
        enterRegisterInfo(name, address, email, mobile, password, password)
        submit()
        ManageProfile().verifyProfileInfo(name, address, email, mobile)
    }
}