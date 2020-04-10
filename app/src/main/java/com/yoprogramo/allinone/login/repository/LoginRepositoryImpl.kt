package com.yoprogramo.allinone.login.repository

import com.yoprogramo.allinone.login.model.User
import timber.log.Timber
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor( val memory : MemoryRepository): LoginRepository {
    override fun getUser(): User? {
       return memory.getUser()
    }

    override fun saveUser(user: User?) {
      memory.saveUser(user)
    }
}