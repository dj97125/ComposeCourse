package com.danielcaballero.mynewcompose.login.domain

import com.danielcaballero.mynewcompose.core.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService) {

    suspend fun doLogin(user: String, password: String): Boolean {
        return api.doLogin(user, password)
    }
}