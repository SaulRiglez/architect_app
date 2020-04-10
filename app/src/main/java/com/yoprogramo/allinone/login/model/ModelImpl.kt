package com.yoprogramo.allinone.login.model

import com.yoprogramo.allinone.login.LoginActivityMVP
import com.yoprogramo.allinone.login.repository.LoginRepositoryImpl
import javax.inject.Inject

class ModelImpl @Inject constructor(private val repository: LoginRepositoryImpl) :
    LoginActivityMVP.Model {

    override fun createUser(userName: String, lastName: String) {
        repository.saveUser(User(2, userName, lastName))
    }

    override fun getUser(): User? {
        return repository.getUser()
    }
}