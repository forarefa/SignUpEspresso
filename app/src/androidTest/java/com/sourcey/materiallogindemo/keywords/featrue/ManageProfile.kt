package com.sourcey.materiallogindemo.keywords.featrue

import com.sourcey.materiallogindemo.keywords.screen.ProfileScreen

class ManageProfile {
    private val profileScreen = ProfileScreen()

    fun verifyProfileInfo(name: String, address: String, email: String, mobile: String) {
        profileScreen.apply {
            iCanSeeProfileScreen()
            iVerifyName(name)
            iVerifyAddress(address)
            iVerifyEmail(email)
            iVerifyMobile(mobile)
        }
    }

}