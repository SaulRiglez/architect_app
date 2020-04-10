package com.yoprogramo.allinone.login

import com.yoprogramo.allinone.login.model.User

interface LoginActivityMVP {
    interface View {
        fun getFirstName(): String
        fun getLastName(): String

        fun shouldNotNotAvailable()
        fun showInputError()
        fun showUserSaveMessage()
        fun startLoginFlow()

        fun setFirstName(firstName: String)
        fun setLastName(lastName: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun loginButtonClicked()
        fun getCurrentUser()
    }

    interface Model {

        fun createUser(userName: String, lastName: String)
        fun getUser() : User?

    }
}