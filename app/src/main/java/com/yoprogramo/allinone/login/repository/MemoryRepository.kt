package com.yoprogramo.allinone.login.repository

import com.yoprogramo.allinone.login.model.User

class MemoryRepository : LoginRepository {

    private var user: User? = null


    override fun getUser(): User? {
        if (user == null) {
            user = User(0, "Corona", "Virus")
            return user
        } else {
            return user
        }

    }

    override fun saveUser(user: User?) {
        user?.let {
            this.user = it
            return
        }
        this.user = getUser()
    }
}