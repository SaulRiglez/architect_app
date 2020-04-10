package com.yoprogramo.allinone.login.repository

import com.yoprogramo.allinone.login.model.User

interface LoginRepository {
    fun getUser() : User?
    fun saveUser(user: User?)
}