package com.sourcey.materiallogindemo.keywords.featrue

import com.sourcey.materiallogindemo.keywords.screen.LoginScreen

class LoginFeature {

    private val loginScreen = LoginScreen()

    fun gotoRegisterInput() {
        loginScreen.iClickBtnSignUp()

//        loginScreen.apply {
//            iClickBtnSignUp()
//            iClickTC()
//        }
    }
}