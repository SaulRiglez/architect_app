package com.yoprogramo.allinone.login.presenter

import com.yoprogramo.allinone.login.LoginActivityMVP
import com.yoprogramo.allinone.login.model.User
import javax.inject.Inject

class PresenterImpl @Inject constructor(val model: LoginActivityMVP.Model) :
    LoginActivityMVP.Presenter {

    private var view: LoginActivityMVP.View? = null

    override fun setView(view: LoginActivityMVP.View) {
        this.view = view
    }

    override fun loginButtonClicked() {
        view?.run {
            if (getFirstName().isEmpty() || getLastName().isEmpty()) {
                showInputError()
            } else {
                model.createUser(getFirstName(), getLastName())
                showUserSaveMessage()
                startLoginFlow()
            }
        }
    }

    override fun getCurrentUser() {
        val user = model.getUser();

        user?.run {
            view?.setFirstName(userName)
            view?.setLastName(LastName)
        } ?: view?.shouldNotNotAvailable()

    }

}